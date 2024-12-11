package com.netease.nim.im.server.sdk.v1;

import com.netease.nim.im.server.sdk.core.EndpointConfig;
import com.netease.nim.im.server.sdk.core.YunxinHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinHttpClientConfig;
import com.netease.nim.im.server.sdk.core.endpoint.*;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkIOException;
import com.netease.nim.im.server.sdk.core.http.ContextType;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.core.http.HttpResponse;
import com.netease.nim.im.server.sdk.core.http.ParamBuilder;
import com.netease.nim.im.server.sdk.core.metrics.MetricsConfig;
import com.netease.nim.im.server.sdk.core.metrics.Stats;
import com.netease.nim.im.server.sdk.core.metrics.MetricsCallback;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;

import java.util.Map;

/**
 * Created by caojiajun on 2024/12/9
 */
public class YunxinV1ApiHttpClient {

    private final YunxinHttpClient httpClient;

    private YunxinV1ApiHttpClient(String appkey, String appsecret, EndpointConfig endpointConfig,
                                 YunxinHttpClientConfig httpClientConfig, MetricsConfig metricsConfig) {
        this.httpClient = new YunxinHttpClient(appkey, appsecret, endpointConfig, httpClientConfig, metricsConfig);
    }

    public static class Builder {

        private final String appkey;
        private final String appsecret;
        private final EndpointConfig endpointConfig = new EndpointConfig();
        private YunxinHttpClientConfig httpClientConfig = new YunxinHttpClientConfig();
        private final MetricsConfig metricsConfig = new MetricsConfig();

        public Builder(String appkey, String appsecret) {
            this.appkey = appkey;
            this.appsecret = appsecret;
        }

        public Builder maxRetry(int maxRetry) {
            if (maxRetry < 0) {
                throw new IllegalArgumentException("illegal maxRetry");
            }
            endpointConfig.setMaxRetry(maxRetry);
            return this;
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

        public YunxinV1ApiHttpClient build() {
            if (endpointConfig.getEndpointSelector() == null) {
                EndpointSelector endpointSelector = new DynamicEndpointSelector(new DynamicEndpointFetcher(appkey, ApiVersion.V1));
                endpointConfig.setEndpointSelector(endpointSelector);
            }
            return new YunxinV1ApiHttpClient(appkey, appsecret, endpointConfig, httpClientConfig, metricsConfig);
        }
    }

    /**
     * yunxin v1 api
     * post method with form_url_encoded
     * @param path path
     * @param paramMap param-map
     * @return response
     */
    public final YunxinV1ApiResponse execute(String path, Map<String, String> paramMap) throws YunxinSdkIOException {
        ParamBuilder builder = new ParamBuilder();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            builder.addParam(entry.getKey(), entry.getValue());
        }
        HttpResponse response = httpClient.execute(HttpMethod.POST, ContextType.form_url_encoded, ApiVersion.V1, path, path, builder.build());
        return new YunxinV1ApiResponse(response.getEndpoint(), response.getData(), response.getTraceId());
    }

    /**
     * get stats bean
     * @return stats
     */
    public final Stats getStats() {
        return httpClient.getStats();
    }
}
