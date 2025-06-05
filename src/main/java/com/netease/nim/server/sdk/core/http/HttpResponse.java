package com.netease.nim.server.sdk.core.http;

/**
 * Created by caojiajun on 2024/11/27
 */
public class HttpResponse {

    private final String endpoint;
    private final int httpCode;
    private final String data;
    private final String traceId;

    public HttpResponse(String endpoint, int httpCode, String data, String traceId) {
        this.endpoint = endpoint;
        this.httpCode = httpCode;
        this.data = data;
        this.traceId = traceId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getData() {
        return data;
    }

    public String getTraceId() {
        return traceId;
    }
}
