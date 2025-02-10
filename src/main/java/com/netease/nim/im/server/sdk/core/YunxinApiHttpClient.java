package com.netease.nim.im.server.sdk.core;

import com.netease.nim.im.server.sdk.core.endpoint.*;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.ContextType;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.core.http.HttpResponse;
import com.netease.nim.im.server.sdk.core.http.ParamBuilder;
import com.netease.nim.im.server.sdk.core.metrics.MetricsConfig;
import com.netease.nim.im.server.sdk.core.metrics.Stats;
import com.netease.nim.im.server.sdk.core.metrics.MetricsCallback;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by caojiajun on 2024/12/9
 */
public class YunxinApiHttpClient {

    private static final ConcurrentHashMap<String, YunxinApiHttpClient> clientMap = new ConcurrentHashMap<>();

    private final YunxinHttpClient httpClient;

    private YunxinApiHttpClient(String appkey, String appsecret, EndpointConfig endpointConfig,
                                YunxinHttpClientConfig httpClientConfig, MetricsConfig metricsConfig) {
        this.httpClient = new YunxinHttpClient(appkey, appsecret, endpointConfig, httpClientConfig, metricsConfig);
    }

    public static class Builder {

        private final String appkey;
        private final String appsecret;
        private final EndpointConfig endpointConfig = new EndpointConfig();
        private YunxinHttpClientConfig httpClientConfig = new YunxinHttpClientConfig();
        private final MetricsConfig metricsConfig = new MetricsConfig();
        private Region region;

        public Builder(String appkey, String appsecret) {
            this.appkey = appkey;
            this.appsecret = appsecret;
            String cacheKey = appkey + "/" + appsecret;
            YunxinApiHttpClient client = clientMap.get(cacheKey);
            if (client != null) {
                throw new IllegalStateException("YunxinApiHttpClient with appkey = [" + appkey + "] duplicate init");
            }
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
            String cacheKey = appkey + "/" + appsecret;
            YunxinApiHttpClient client = clientMap.get(cacheKey);
            if (client != null) {
                throw new IllegalStateException("YunxinApiHttpClient with appkey = [" + appkey + "] duplicate init");
            }
            if (endpointConfig.getEndpointSelector() == null) {
                EndpointSelector endpointSelector = new DynamicEndpointSelector(new DynamicEndpointFetcher(appkey, region));
                endpointConfig.setEndpointSelector(endpointSelector);
            }
            YunxinApiHttpClient yunxinApiHttpClient = new YunxinApiHttpClient(appkey, appsecret, endpointConfig, httpClientConfig, metricsConfig);
            clientMap.put(cacheKey, yunxinApiHttpClient);
            return yunxinApiHttpClient;
        }
    }

    /**
     * yunxin v1 api
     * post method with form_url_encoded
     * @param path path
     * @param paramMap param-map
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeV1Api(String path, Map<String, String> paramMap) throws YunxinSdkException {
        ParamBuilder builder = new ParamBuilder();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            builder.addParam(entry.getKey(), entry.getValue());
        }
        HttpResponse response = httpClient.execute(HttpMethod.POST, ContextType.form_url_encoded, ApiVersion.V1, path, path, null, builder.build());
        return new YunxinApiResponse(response.getEndpoint(), response.getData(), response.getTraceId());
    }

    /**
     * yunxin v2 api
     * @param method http method
     * @param uri only for metrics
     * @param path real path
     * @param queryString query string
     * @param data data
     * @return response
     * @throws YunxinSdkException exception
     */
    public final YunxinApiResponse executeV2Api(HttpMethod method, String uri, String path, Map<String, String> queryString, String data) throws YunxinSdkException {
        HttpResponse response = httpClient.execute(method, ContextType.json, ApiVersion.V2, uri, path, queryString, data);
        return new YunxinApiResponse(response.getEndpoint(), response.getData(), response.getTraceId());
    }

    /**
     * get stats bean
     * @return stats
     */
    public final Stats getStats() {
        return httpClient.getStats();
    }
}
