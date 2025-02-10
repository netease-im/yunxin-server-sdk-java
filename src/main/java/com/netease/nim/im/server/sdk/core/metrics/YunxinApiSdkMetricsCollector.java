package com.netease.nim.im.server.sdk.core.metrics;

import com.netease.nim.im.server.sdk.core.http.ContextType;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;
import com.netease.nim.im.server.sdk.core.utils.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * Created by caojiajun on 2024/12/10
 */
public class YunxinApiSdkMetricsCollector {

    private static final Logger logger = LoggerFactory.getLogger(YunxinApiSdkMetricsCollector.class);

    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("yunxin-im-sdk-metrics-collector"));
    private static final ThreadPoolExecutor callbackExecutor = new ThreadPoolExecutor(1, 1,
            0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), new NamedThreadFactory("yunxin-im-sdk-stats-callback"));

    private final ConcurrentHashMap<Key1, Statistics> map1 = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Key2, Statistics> map2 = new ConcurrentHashMap<>();

    private final MetricsCallback metricsCallback;

    private Stats stats = new Stats();

    public YunxinApiSdkMetricsCollector(int collectIntervalSeconds, MetricsCallback metricsCallback) {
        if (collectIntervalSeconds <= 0) {
            throw new IllegalArgumentException("illegal collectIntervalSeconds");
        }
        this.metricsCallback = metricsCallback;
        scheduler.scheduleAtFixedRate(this::calc, collectIntervalSeconds, collectIntervalSeconds, TimeUnit.SECONDS);
    }

    public void collect(String endpoint, HttpMethod method, ContextType contextType, ApiVersion apiVersion,
                        String uri, String result, long spendMs) {
        Key1 key1 = new Key1(endpoint, method, contextType, apiVersion, uri, result);
        Statistics statistics1 = map1.get(key1);
        if (statistics1 == null) {
            statistics1 = map1.computeIfAbsent(key1, k -> new Statistics());
        }
        statistics1.update(spendMs);

        Key2 key2 = new Key2(endpoint, result);
        Statistics statistics2 = map2.get(key2);
        if (statistics2 == null) {
            statistics2 = map2.computeIfAbsent(key2, k -> new Statistics());
        }
        statistics2.update(spendMs);
    }

    private void calc() {
        try {
            List<EndpointStats> endpointStatsList = new ArrayList<>();
            List<UriStats> uriStatsList = new ArrayList<>();
            for (Map.Entry<Key1, Statistics> entry : map1.entrySet()) {
                Key1 key = entry.getKey();
                StatsData data = entry.getValue().getStatsDataAndReset();
                if (data.getCount() == 0) {
                    continue;
                }
                UriStats uriStats = new UriStats();
                uriStats.setEndpoint(key.endpoint);
                uriStats.setMethod(key.method);
                uriStats.setContextType(key.contextType);
                uriStats.setApiVersion(key.apiVersion);
                uriStats.setUri(key.uri);
                uriStats.setResult(key.result);
                uriStats.setCount(data.getCount());
                uriStats.setAvg(data.getAvg());
                uriStats.setMax(data.getMax());
                uriStats.setP50(data.getP50());
                uriStats.setP75(data.getP75());
                uriStats.setP90(data.getP90());
                uriStats.setP95(data.getP95());
                uriStats.setP99(data.getP99());
                uriStats.setP999(data.getP999());
                uriStatsList.add(uriStats);
            }
            for (Map.Entry<Key2, Statistics> entry : map2.entrySet()) {
                Key2 key = entry.getKey();
                StatsData data = entry.getValue().getStatsDataAndReset();
                if (data.getCount() == 0) {
                    continue;
                }
                EndpointStats endpointStats = new EndpointStats();
                endpointStats.setEndpoint(key.endpoint);
                endpointStats.setResult(key.result);
                endpointStats.setCount(data.getCount());
                endpointStats.setAvg(data.getAvg());
                endpointStats.setMax(data.getMax());
                endpointStats.setP50(data.getP50());
                endpointStats.setP75(data.getP75());
                endpointStats.setP90(data.getP90());
                endpointStats.setP95(data.getP95());
                endpointStats.setP99(data.getP99());
                endpointStats.setP999(data.getP999());
                endpointStatsList.add(endpointStats);
            }
            Stats stats = new Stats();
            stats.setUriStatsList(uriStatsList);
            stats.setEndpointStatsList(endpointStatsList);
            this.stats = stats;
            if (metricsCallback != null) {
                callbackExecutor.submit(() -> {
                    try {
                        metricsCallback.callback(stats);
                    } catch (Exception e) {
                        logger.error("callback error", e);
                    }
                });
            }
        } catch (Exception e) {
            logger.error("calc metrics error", e);
        }
    }

    public Stats getStats() {
        return stats;
    }

    private static class Key1 {
        private final String endpoint;
        private final HttpMethod method;
        private final ContextType contextType;
        private final ApiVersion apiVersion;
        private final String uri;
        private final String result;

        public Key1(String endpoint, HttpMethod method, ContextType contextType, ApiVersion apiVersion, String uri, String result) {
            this.endpoint = endpoint;
            this.method = method;
            this.contextType = contextType;
            this.apiVersion = apiVersion;
            this.uri = uri;
            this.result = result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key1 key1 = (Key1) o;
            return Objects.equals(endpoint, key1.endpoint) && method == key1.method && contextType == key1.contextType
                    && apiVersion == key1.apiVersion && Objects.equals(uri, key1.uri) && Objects.equals(result, key1.result);
        }

        @Override
        public int hashCode() {
            return Objects.hash(endpoint, method, contextType, apiVersion, uri, result);
        }
    }

    private static class Key2 {
        private final String endpoint;
        private final String result;

        public Key2(String endpoint, String result) {
            this.endpoint = endpoint;
            this.result = result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key2 key2 = (Key2) o;
            return Objects.equals(endpoint, key2.endpoint) && Objects.equals(result, key2.result);
        }

        @Override
        public int hashCode() {
            return Objects.hash(endpoint, result);
        }
    }
}
