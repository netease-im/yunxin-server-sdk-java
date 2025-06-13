package com.netease.nim.server.sdk.core;

/**
 * Created by caojiajun on 2024/12/10
 */
public class YunxinApiResponse {
    private final String endpoint;
    private final int httpCode;
    private final String data;
    private final String traceId;

    public YunxinApiResponse(String endpoint, int httpCode, String data, String traceId) {
        this.endpoint = endpoint;
        this.httpCode = httpCode;
        this.data = data;
        this.traceId = traceId;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getData() {
        return data;
    }

    public String getTraceId() {
        return traceId;
    }
}
