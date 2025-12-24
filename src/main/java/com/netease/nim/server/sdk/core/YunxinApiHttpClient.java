package com.netease.nim.server.sdk.core;

import com.netease.nim.server.sdk.core.endpoint.*;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.ContextType;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.core.http.HttpResponse;
import com.netease.nim.server.sdk.core.http.ParamBuilder;
import com.netease.nim.server.sdk.core.metrics.MetricsConfig;
import com.netease.nim.server.sdk.core.metrics.Stats;
import com.netease.nim.server.sdk.core.metrics.MetricsCallback;
import com.netease.nim.server.sdk.core.trace.ApiVersion;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by caojiajun on 2024/12/9
 */
public class YunxinApiHttpClient {

    private static final ConcurrentHashMap<String, YunxinApiHttpClient> clientMap = new ConcurrentHashMap<>();

    private final BizName bizName;
    private final YunxinHttpClient httpClient;
    private final String duplicateKey;

    private YunxinApiHttpClient(BizName bizName, String appkey, String appsecret, EndpointConfig endpointConfig,
                                YunxinHttpClientConfig httpClientConfig, MetricsConfig metricsConfig) {
        this.bizName = bizName;
        this.httpClient = new YunxinHttpClient(bizName, appkey, appsecret, endpointConfig, httpClientConfig, metricsConfig);
        this.duplicateKey = appkey + "/" + appsecret + "/" + bizName.getValue();
    }

    public static class Builder {

        private final BizName bizName;
        private final String appkey;
        private final String appsecret;
        private final EndpointConfig endpointConfig = new EndpointConfig();
        private YunxinHttpClientConfig httpClientConfig = new YunxinHttpClientConfig();
        private final MetricsConfig metricsConfig = new MetricsConfig();
        private Region region;

        public Builder(BizName bizName, String appkey, String appsecret) {
            this.bizName = bizName;
            this.appkey = appkey;
            this.appsecret = appsecret;
            if (bizName != BizName.CUSTOM) {
                String cacheKey = appkey + "/" + appsecret + "/" + bizName.getValue();
                YunxinApiHttpClient client = clientMap.get(cacheKey);
                if (client != null) {
                    throw new IllegalStateException("YunxinApiHttpClient with appkey = [" + appkey + "] and bizName = [" + bizName.name() + "] duplicate init");
                }
            }
            endpointConfig.setRetryPolicy(bizName.getDefaultRetryPolicy());
        }

        public Builder(String appkey, String appsecret) {
            this(BizName.IM, appkey, appsecret);
        }

        public Builder retryPolicy(RetryPolicy retryPolicy) {
            if (retryPolicy == null) {
                throw new IllegalArgumentException("retry policy null");
            }
            endpointConfig.setRetryPolicy(retryPolicy);
            return this;
        }

        public Builder endpoint(String endpoint) {
            if (endpoint == null) {
                throw new IllegalArgumentException("retry policy null");
            }
            endpointConfig.setEndpointSelector(new FixedEndpointSelector(endpoint));
            return this;
        }

        public Builder endpointSelector(EndpointSelector endpointSelector) {
            if (endpointSelector == null) {
                throw new IllegalArgumentException("endpointSelector null");
            }
            endpointConfig.setEndpointSelector(endpointSelector);
            return this;
        }

        public Builder timeoutMillis(int timeoutMillis) {
            if (timeoutMillis <= 0) {
                throw new IllegalArgumentException("illegal timeoutMillis");
            }
            httpClientConfig.setConnectTimeoutMillis(timeoutMillis);
            httpClientConfig.setReadTimeoutMillis(timeoutMillis);
            httpClientConfig.setWriteTimeoutMillis(timeoutMillis);
            return this;
        }

        public Builder httpClientConfig(YunxinHttpClientConfig httpClientConfig) {
            if (httpClientConfig == null) {
                throw new IllegalArgumentException("httpClientConfig null");
            }
            this.httpClientConfig = httpClientConfig;
            return this;
        }

        public Builder proxy(Proxy proxy) {
            if (proxy == null) {
                throw new IllegalArgumentException("proxy is null");
            }
            httpClientConfig.setProxy(proxy);
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new IllegalArgumentException("proxySelector is null");
            }
            httpClientConfig.setProxySelector(proxySelector);
            return this;
        }

        public Builder metricEnable(boolean enable) {
            this.metricsConfig.setEnable(enable);
            return this;
        }

        public Builder metricCollectIntervalSeconds(int collectIntervalSeconds) {
            if (collectIntervalSeconds <= 0) {
                throw new IllegalArgumentException("illegal collectIntervalSeconds");
            }
            this.metricsConfig.setCollectIntervalSeconds(collectIntervalSeconds);
            return this;
        }

        public Builder metricsCallback(MetricsCallback metricsCallback) {
            this.metricsConfig.setMetricsCallback(metricsCallback);
            return this;
        }

        public Builder region(Region region) {
            this.region = region;
            return this;
        }

        public YunxinApiHttpClient build() {
            String cacheKey = appkey + "/" + appsecret + "/" + bizName.getValue();
            if (bizName != BizName.CUSTOM) {
                YunxinApiHttpClient client = clientMap.get(cacheKey);
                if (client != null) {
                    throw new IllegalStateException("YunxinApiHttpClient with appkey = [" + appkey + "] and bizName = [" + bizName.name() + "] duplicate init");
                }
            }
            if (bizName == BizName.CUSTOM) {
                if (endpointConfig.getEndpointSelector() == null) {
                    throw new IllegalArgumentException("bizName with CUSTOM must specify endpoints");
                }
            }
            if (endpointConfig.getEndpointSelector() == null) {
                EndpointSelector endpointSelector = new DynamicEndpointSelector(bizName, new DynamicEndpointFetcher(bizName, appkey, region));
                endpointConfig.setEndpointSelector(endpointSelector);
            }
            YunxinApiHttpClient yunxinApiHttpClient = new YunxinApiHttpClient(bizName, appkey, appsecret, endpointConfig, httpClientConfig, metricsConfig);
            if (bizName != BizName.CUSTOM) {
                clientMap.put(cacheKey, yunxinApiHttpClient);
            }
            return yunxinApiHttpClient;
        }
    }

    /**
     * yunxin im v1 api
     * post method with form_url_encoded
     * @param path 请求的路径
     * @param paramMap param-map
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeV1Api(String path, Map<String, String> paramMap) throws YunxinSdkException {
        if (bizName != BizName.IM) {
            throw new IllegalStateException("only support bizName = IM");
        }
        ParamBuilder builder = new ParamBuilder();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                continue;
            }
            builder.addParam(entry.getKey(), entry.getValue());
        }
        HttpResponse response = httpClient.execute(HttpMethod.POST, ContextType.form_url_encoded, ApiVersion.V1, path, path, null, builder.build());
        return new YunxinApiResponse(response.getEndpoint(), response.getHttpCode(), response.getData(), response.getTraceId());
    }

    /**
     * yunxin im v2 api
     * @param method http method
     * @param uri 仅用于监控，一般来说uri和path是一样的，如果path中有路径参数，则每个请求的path都可能不一样，uri则相同，如，uri可能叫：/xxx/{id}，而path为：/xxx/123
     * @param path 请求的路径
     * @param queryString query string
     * @param data data
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeV2Api(HttpMethod method, String uri, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        if (bizName != BizName.IM) {
            throw new IllegalStateException("only support bizName = IM");
        }
        HttpResponse response = httpClient.execute(method, ContextType.json, ApiVersion.V2, uri, path, queryString, data);
        return new YunxinApiResponse(response.getEndpoint(), response.getHttpCode(), response.getData(), response.getTraceId());
    }

    /**
     * execute api request
     * @param method http-method
     * @param contextType content-Type
     * @param uri 仅用于监控，一般来说uri和path是一样的，如果path中有路径参数，则每个请求的path都可能不一样，uri则相同，如，uri可能叫：/xxx/{id}，而path为：/xxx/123
     * @param path 请求的路径
     * @param queryString query string
     * @param data data
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse execute(HttpMethod method, ContextType contextType, String uri, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        HttpResponse response = httpClient.execute(method, contextType, ApiVersion.V1, uri, path, queryString, data);
        return new YunxinApiResponse(response.getEndpoint(), response.getHttpCode(), response.getData(), response.getTraceId());
    }

    /**
     * execute api request for content-type=application/json
     * @param method http-method
     * @param uri 仅用于监控，一般来说uri和path是一样的，如果path中有路径参数，则每个请求的path都可能不一样，uri则相同，如，uri可能叫：/xxx/{id}，而path为：/xxx/123
     * @param path 请求的路径
     * @param queryString query string
     * @param data data
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeJson(HttpMethod method, String uri, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        HttpResponse response = httpClient.execute(method, ContextType.json, ApiVersion.V1, uri, path, queryString, data);
        return new YunxinApiResponse(response.getEndpoint(), response.getHttpCode(), response.getData(), response.getTraceId());
    }

    /**
     * execute api request for content-type=application/json
     * @param method http-method
     * @param path 请求的路径
     * @param queryString query string
     * @param data data
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeJson(HttpMethod method, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        HttpResponse response = httpClient.execute(method, ContextType.json, ApiVersion.V1, path, path, queryString, data);
        return new YunxinApiResponse(response.getEndpoint(), response.getHttpCode(), response.getData(), response.getTraceId());
    }

    /**
     * execute api request for content-type=application/x-www-form-urlencoded
     * @param method http-method
     * @param uri 仅用于监控，一般来说uri和path是一样的，如果path中有路径参数，则每个请求的path都可能不一样，uri则相同，如，uri可能叫：/xxx/{id}，而path为：/xxx/123
     * @param path 请求的路径
     * @param queryString query string
     * @param data data
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeForm(HttpMethod method, String uri, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        HttpResponse response = httpClient.execute(method, ContextType.form_url_encoded, ApiVersion.V1, uri, path, queryString, data);
        return new YunxinApiResponse(response.getEndpoint(), response.getHttpCode(), response.getData(), response.getTraceId());
    }

    /**
     * execute api request for content-type=application/x-www-form-urlencoded
     * @param method http-method
     * @param path 请求的路径
     * @param queryString query string
     * @param data data
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeForm(HttpMethod method, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        HttpResponse response = httpClient.execute(method, ContextType.form_url_encoded, ApiVersion.V1, path, path, queryString, data);
        return new YunxinApiResponse(response.getEndpoint(), response.getHttpCode(), response.getData(), response.getTraceId());
    }

    /**
     * get stats bean
     * @return stats
     */
    public final Stats getStats() {
        return httpClient.getStats();
    }

    /**
     * shutdown
     */
    public final void shutdown() {
        httpClient.shutdown();
        clientMap.remove(duplicateKey);
    }
}
