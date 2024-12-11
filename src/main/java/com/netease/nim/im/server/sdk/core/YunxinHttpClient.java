package com.netease.nim.im.server.sdk.core;

import com.netease.nim.im.server.sdk.core.exception.HttpCodeException;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.ContextType;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.core.http.HttpResponse;
import com.netease.nim.im.server.sdk.core.endpoint.*;
import com.netease.nim.im.server.sdk.core.http.ParamBuilder;
import com.netease.nim.im.server.sdk.core.metrics.MetricsConfig;
import com.netease.nim.im.server.sdk.core.metrics.Stats;
import com.netease.nim.im.server.sdk.core.metrics.YunxinApiSdkMetricsCollector;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;
import com.netease.nim.im.server.sdk.core.trace.YunxinTraceId;
import com.netease.nim.im.server.sdk.core.trace.TraceIdUtils;
import com.netease.nim.im.server.sdk.core.utils.CheckSumBuilder;
import com.netease.nim.im.server.sdk.core.utils.ExceptionUtils;
import okhttp3.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by caojiajun on 2024/11/27
 */
public class YunxinHttpClient implements HttpClient {

    private static final String APPKEY = "AppKey";
    private static final String NONCE = "Nonce";
    private static final String CURTIME = "CurTime";
    private static final String CHECKSUM = "CheckSum";
    public static final String X_CUSTOM_TRACE_ID = "X-custom-traceid";
    public static final String REQUEST_ID = "RequestId";

    private final String appkey;
    private final String appsecret;
    private final OkHttpClient okHttpClient;
    private final RetryPolicy retryPolicy;
    private final int maxRetry;
    private final EndpointSelector endpointSelector;

    private YunxinApiSdkMetricsCollector metricsCollector;

    public YunxinHttpClient(String appkey, String appsecret, EndpointConfig endpointConfig, YunxinHttpClientConfig httpClientConfig, MetricsConfig metricsConfig) {
        this.appkey = appkey;
        this.appsecret = appsecret;
        this.retryPolicy = endpointConfig.getRetryPolicy();
        this.maxRetry = endpointConfig.getMaxRetry();
        this.endpointSelector = endpointConfig.getEndpointSelector();
        if (metricsConfig.isEnable()) {
            metricsCollector = new YunxinApiSdkMetricsCollector(metricsConfig.getCollectIntervalSeconds(), metricsConfig.getMetricsCallback());
        }
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(httpClientConfig.getMaxRequests());
        dispatcher.setMaxRequestsPerHost(httpClientConfig.getMaxRequestsPerHost());
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(httpClientConfig.getConnectTimeoutMillis(), TimeUnit.MILLISECONDS)
                .readTimeout(httpClientConfig.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
                .writeTimeout(httpClientConfig.getWriteTimeoutMillis(), TimeUnit.MILLISECONDS)
                .dispatcher(dispatcher)
                .connectionPool(new ConnectionPool(httpClientConfig.getMaxIdleConnections(), httpClientConfig.getKeepAliveSeconds(), TimeUnit.SECONDS))
                .build();
        this.endpointSelector.init(okHttpClient);
    }


    @Override
    public HttpResponse execute(HttpMethod method, ContextType contextType, ApiVersion apiVersion,
                                String uri, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        //trace-id
        String traceId = YunxinTraceId.get();
        if (traceId == null) {
            traceId = TraceIdUtils.gen();
        }
        try {
            //select endpoint
            String endpoint = endpointSelector.selectEndpoint(null);
            //context
            ExecuteContext executeContext = new ExecuteContext(endpoint, method, contextType, apiVersion, uri, path, queryString, data, traceId);
            String url;
            if (queryString == null || queryString.isEmpty()) {
                url = path;
            } else {
                ParamBuilder query = new ParamBuilder();
                for (Map.Entry<String, String> entry : queryString.entrySet()) {
                    query.addParam(entry.getKey(), entry.getValue());
                }
                url = path + "?" + query.build();
            }
            //exception
            YunxinSdkException exception = null;
            for (int i=0; i<=maxRetry; i++) {
                //request
                Request.Builder builder = new Request.Builder();
                if (method == HttpMethod.GET) {
                    builder.get();
                } else {
                    builder.method(method.name(), RequestBody.create(MediaType.parse(contextType.getValue()), data == null ? "" : data));
                }
                builder.url(endpoint + url);
                //add headers
                addHeaders(builder, apiVersion, traceId);
                //build request
                Request request = builder.build();
                //invoke
                long startTime = System.currentTimeMillis();
                try (Response response = okHttpClient.newCall(request).execute()) {
                    int code = response.code();
                    String string = response.body().string();
                    if (code != 200) {
                        throw new HttpCodeException(endpoint, code, string);
                    }
                    endpointSelector.update(endpoint, RequestResult.SUCCESS);
                    if (metricsCollector != null) {
                        metricsCollector.collect(endpoint, method, contextType, apiVersion, path, "success", System.currentTimeMillis() - startTime);
                    }
                    return new HttpResponse(endpoint, code, string, traceId);
                } catch (Exception e) {
                    RequestResult requestResult;
                    String result;
                    if (e instanceof HttpCodeException) {
                        int code = ((HttpCodeException) e).getCode();
                        result = "http_code_" + code;
                        if (code == 502) {
                            requestResult = RequestResult.HTTP_CODE_502;
                        } else if (code == 500) {
                            requestResult = RequestResult.HTTP_CODE_500;
                        } else if (code == 400) {
                            requestResult = RequestResult.HTTP_CODE_400;
                        } else {
                            requestResult = RequestResult.HTTP_CODE_NOT_200;
                        }
                    } else {
                        result = e.toString();
                        boolean connectError = ExceptionUtils.isConnectError(e);
                        if (connectError) {
                            requestResult = RequestResult.CONNECT_TIMEOUT;
                        } else {
                            if (ExceptionUtils.isTimeoutError(e)) {
                                requestResult = RequestResult.READ_WRITE_TIMEOUT;
                            } else {
                                requestResult = RequestResult.OTHER_ERRORS;
                            }
                        }
                    }
                    endpointSelector.update(endpoint, requestResult);
                    if (metricsCollector != null) {
                        metricsCollector.collect(endpoint, method, contextType, apiVersion, uri, result, System.currentTimeMillis() - startTime);
                    }
                    exception = new YunxinSdkException(executeContext, e);
                    RetryPolicy.RetryAction retryAction = retryPolicy.onError(executeContext, e);
                    if (!retryAction.isRetry()) {
                        throw exception;
                    }
                    if (retryAction.isNextEndpoint()) {
                        endpoint = endpointSelector.selectEndpoint(endpoint);
                    }
                }
            }
            if (exception != null) {
                throw exception;
            }
            throw new YunxinSdkException(executeContext, null);
        } finally {
            YunxinTraceId.clear();
        }
    }

    @Override
    public Stats getStats() {
        if (metricsCollector == null) {
            return null;
        }
        return metricsCollector.getStats();
    }

    private void addHeaders(Request.Builder builder, ApiVersion apiVersion, String traceId) {
        String curTime = String.valueOf(System.currentTimeMillis() / 1000);
        String nonce = UUID.randomUUID().toString().replace("-", "");
        builder.addHeader(APPKEY, appkey);
        builder.addHeader(CURTIME, curTime);
        builder.addHeader(NONCE, nonce);
        builder.addHeader(CHECKSUM, CheckSumBuilder.getCheckSum(appsecret, nonce, curTime));
        if (apiVersion == ApiVersion.V1) {
            builder.addHeader(REQUEST_ID, traceId);
        } else if (apiVersion == ApiVersion.V2) {
            builder.addHeader(X_CUSTOM_TRACE_ID, traceId);
        }
    }
}
