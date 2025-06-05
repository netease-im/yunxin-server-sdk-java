package com.netease.nim.server.sdk.core.metrics;

import com.netease.nim.server.sdk.core.Constants;

/**
 * Created by caojiajun on 2024/12/10
 */
public class MetricsConfig {

    private boolean enable = Constants.Metric.enable;
    private int collectIntervalSeconds = Constants.Metric.collectIntervalSeconds;
    private MetricsCallback metricsCallback;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getCollectIntervalSeconds() {
        return collectIntervalSeconds;
    }

    public void setCollectIntervalSeconds(int collectIntervalSeconds) {
        this.collectIntervalSeconds = collectIntervalSeconds;
    }

    public MetricsCallback getMetricsCallback() {
        return metricsCallback;
    }

    public void setMetricsCallback(MetricsCallback metricsCallback) {
        this.metricsCallback = metricsCallback;
    }
}
