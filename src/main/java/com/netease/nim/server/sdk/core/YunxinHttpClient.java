package com.netease.nim.server.sdk.core;

import com.netease.nim.server.sdk.core.endpoint.EndpointSelector;
import com.netease.nim.server.sdk.core.endpoint.ExecuteContext;
import com.netease.nim.server.sdk.core.endpoint.RequestResult;
import com.netease.nim.server.sdk.core.endpoint.RetryPolicy;
import com.netease.nim.server.sdk.core.exception.HttpCodeException;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.ContextType;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.core.http.HttpResponse;
import com.netease.nim.server.sdk.core.http.ParamBuilder;
import com.netease.nim.server.sdk.core.metrics.MetricsConfig;
import com.netease.nim.server.sdk.core.metrics.Stats;
import com.netease.nim.server.sdk.core.metrics.YunxinApiSdkMetricsCollector;
import com.netease.nim.server.sdk.core.trace.*;
import com.netease.nim.server.sdk.core.utils.CheckSumBuilder;
import com.netease.nim.server.sdk.core.utils.ExceptionUtils;
import com.netease.nim.server.sdk.core.version.YunxinApiSdkVersion;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by caojiajun on 2024/11/27
 */
public class YunxinHttpClient implements HttpClient {

    private static final Logger logger = LoggerFactory.getLogger(YunxinHttpClient.class);

    private static final String APPKEY = "AppKey";
    private static final String NONCE = "Nonce";
    private static final String CURTIME = "CurTime";
    private static final String CHECKSUM = "CheckSum";
    private static final String X_CUSTOM_TRACE_ID = "X-custom-traceid";
    private static final String REQUEST_ID = "RequestId";

    private final BizName bizName;
    private final String appkey;
    private final String appsecret;
    private final OkHttpClient okHttpClient;
    private final RetryPolicy retryPolicy;
    private final EndpointSelector endpointSelector;

    private YunxinApiSdkMetricsCollector metricsCollector;
    private boolean running = true;

    public YunxinHttpClient(BizName bizName, String appkey, String appsecret, EndpointConfig endpointConfig,
                            YunxinHttpClientConfig httpClientConfig, MetricsConfig metricsConfig) {
        this.bizName = bizName;
        this.appkey = appkey;
        this.appsecret = appsecret;
        this.retryPolicy = endpointConfig.getRetryPolicy();
        this.endpointSelector = endpointConfig.getEndpointSelector();
        if (metricsConfig.isEnable()) {
            metricsCollector = new YunxinApiSdkMetricsCollector(bizName, metricsConfig.getCollectIntervalSeconds(), metricsConfig.getMetricsCallback());
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
        if (!running) {
            throw new IllegalStateException("yunxin http client has bean shutdown.");
        }
        //trace-id
        String traceId = YunxinTraceId.get();
        if (traceId == null) {
            traceId = TraceIdUtils.gen();
        }
        try {
            //select endpoint
            String endpoint = endpointSelector.selectEndpoint(null);
            //context
            ExecuteContext executeContext = new ExecuteContext(bizName, endpoint, method, contextType, apiVersion, uri, path, queryString, data, traceId);
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
            int maxRetry = retryPolicy.maxRetry();
            if (maxRetry <= 0) {
                maxRetry = 0;
            }
            if (maxRetry > 128) {
                maxRetry = 128;
            }
            Long timeoutMillis = TimeoutSetter.getAndClear();
            OkHttpClient client = client(timeoutMillis);

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
                if (logger.isDebugEnabled()) {
                    logger.debug("execute, bizName = {}, endpoint = {}, method = {}, contextType = {}, apiVersion= {}, uri = {}, path = {}, traceId = {}, queryString = {}, data = {}",
                            bizName, endpoint, method, contextType, apiVersion, uri, path, traceId, queryString, data);
                }
                try (Response response = client.newCall(request).execute()) {
                    int code = response.code();
                    String string = response.body().string();
                    if (bizName.isHttpCodeAlways200()) {
                        if (code != 200) {
                            throw new HttpCodeException(bizName, endpoint, code, string);
                        }
                    }
                    endpointSelector.update(endpoint, RequestResult.SUCCESS);
                    if (metricsCollector != null) {
                        metricsCollector.collect(endpoint, method, contextType, apiVersion, uri, "success", System.currentTimeMillis() - startTime);
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
                    RetryPolicy.RetryAction retryAction = retryPolicy.onError(executeContext, i, e);
                    if (!retryAction.isRetry()) {
                        throw exception;
                    }
                    long interval = retryPolicy.retryInterval(executeContext, i);
                    if (interval > 0) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(interval);
                        } catch (InterruptedException ex) {
                            logger.error(ex.getMessage(), ex);
                        }
                    }
                    if (retryAction.isNextEndpoint()) {
                        endpoint = endpointSelector.selectEndpoint(endpoint);
                    }
                }
            }
            throw exception;
        } finally {
            YunxinTraceId.clear();
        }
    }

    private OkHttpClient client(Long timeoutMillis) {
        if (timeoutMillis == null) {
            return okHttpClient;
        }
        return okHttpClient.newBuilder()
                .connectTimeout(timeoutMillis, TimeUnit.MILLISECONDS)
                .readTimeout(timeoutMillis, TimeUnit.MILLISECONDS)
                .writeTimeout(timeoutMillis, TimeUnit.MILLISECONDS)
                .build();
    }

    @Override
    public Stats getStats() {
        if (!running) {
            throw new IllegalStateException("yunxin http client has bean shutdown.");
        }
        if (metricsCollector == null) {
            return null;
        }
        return metricsCollector.getStats();
    }

    @Override
    public void shutdown() {
        if (metricsCollector != null) {
            metricsCollector.shutdown();
        }
        if (endpointSelector != null) {
            endpointSelector.shutdown();
        }
        running = false;
    }

    private void addHeaders(Request.Builder builder, ApiVersion apiVersion, String traceId) {
        String curTime = String.valueOf(System.currentTimeMillis() / 1000);
        String nonce = UUID.randomUUID().toString().replace("-", "");
        builder.addHeader(APPKEY, appkey);
        builder.addHeader(CURTIME, curTime);
        builder.addHeader(NONCE, nonce);
        builder.addHeader(CHECKSUM, CheckSumBuilder.getCheckSum(appsecret, nonce, curTime));
        if (bizName == BizName.IM) {
            if (apiVersion == ApiVersion.V1) {
                builder.addHeader(REQUEST_ID, traceId);
            } else if (apiVersion == ApiVersion.V2) {
                builder.addHeader(X_CUSTOM_TRACE_ID, traceId);
            }
        } else {
            builder.addHeader(X_CUSTOM_TRACE_ID, traceId);
        }
        builder.addHeader("User-Agent", "yunxin-server-sdk/" + YunxinApiSdkVersion.version);
    }
}
