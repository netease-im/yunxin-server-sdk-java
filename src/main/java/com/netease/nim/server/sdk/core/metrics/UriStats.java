package com.netease.nim.server.sdk.core.metrics;

import com.netease.nim.server.sdk.core.http.ContextType;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.core.trace.ApiVersion;

/**
 * Created by caojiajun on 2024/12/10
 */
public class UriStats {
    private String endpoint;
    private HttpMethod method;
    private ContextType contextType;
    private ApiVersion apiVersion;
    private String uri;
    private String result;
    private long count;
    private double avg;
    private long max;
    private long p50;
    private long p75;
    private long p90;
    private long p95;
    private long p99;
    private long p999;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public ContextType getContextType() {
        return contextType;
    }

    public void setContextType(ContextType contextType) {
        this.contextType = contextType;
    }

    public ApiVersion getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getP50() {
        return p50;
    }

    public void setP50(long p50) {
        this.p50 = p50;
    }

    public long getP75() {
        return p75;
    }

    public void setP75(long p75) {
        this.p75 = p75;
    }

    public long getP90() {
        return p90;
    }

    public void setP90(long p90) {
        this.p90 = p90;
    }

    public long getP95() {
        return p95;
    }

    public void setP95(long p95) {
        this.p95 = p95;
    }

    public long getP99() {
        return p99;
    }

    public void setP99(long p99) {
        this.p99 = p99;
    }

    public long getP999() {
        return p999;
    }

    public void setP999(long p999) {
        this.p999 = p999;
    }
}
