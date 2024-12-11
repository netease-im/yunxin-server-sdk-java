package com.netease.nim.im.server.sdk.core;


/**
 * Created by caojiajun on 2024/11/27
 */
public class YunxinHttpClientConfig {

    private long connectTimeoutMillis = Constants.Http.connectTimeoutMillis;
    private long readTimeoutMillis = Constants.Http.readTimeoutMillis;
    private long writeTimeoutMillis = Constants.Http.writeTimeoutMillis;
    private int maxRequests = Constants.Http.maxRequests;
    private int maxRequestsPerHost = Constants.Http.maxRequestsPerHost;
    private int keepAliveSeconds = Constants.Http.keepAliveSeconds;
    private int maxIdleConnections = Constants.Http.maxIdleConnections;

    public long getConnectTimeoutMillis() {
        return connectTimeoutMillis;
    }

    public void setConnectTimeoutMillis(long connectTimeoutMillis) {
        this.connectTimeoutMillis = connectTimeoutMillis;
    }

    public long getReadTimeoutMillis() {
        return readTimeoutMillis;
    }

    public void setReadTimeoutMillis(long readTimeoutMillis) {
        this.readTimeoutMillis = readTimeoutMillis;
    }

    public long getWriteTimeoutMillis() {
        return writeTimeoutMillis;
    }

    public void setWriteTimeoutMillis(long writeTimeoutMillis) {
        this.writeTimeoutMillis = writeTimeoutMillis;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public void setMaxRequests(int maxRequests) {
        this.maxRequests = maxRequests;
    }

    public int getMaxRequestsPerHost() {
        return maxRequestsPerHost;
    }

    public void setMaxRequestsPerHost(int maxRequestsPerHost) {
        this.maxRequestsPerHost = maxRequestsPerHost;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public void setMaxIdleConnections(int maxIdleConnections) {
        this.maxIdleConnections = maxIdleConnections;
    }
}
