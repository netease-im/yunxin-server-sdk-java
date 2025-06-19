package com.netease.nim.server.sdk.rtc;

import com.netease.nim.server.sdk.core.Result;

/**
 * Created by caojiajun on 2025/6/19
 */
public class RtcResult<T> extends Result<T> {

    private final int httpCode;
    private final String requestId;

    public RtcResult(String endpoint, int code, int httpCode, String requestId, String traceId, String msg, T response) {
        super(endpoint, code, traceId, msg, response);
        this.httpCode = httpCode;
        this.requestId = requestId;
    }

    @Override
    public boolean isSuccess() {
        return (getCode() == 200 || getCode() == 0) && httpCode == 200;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getRequestId() {
        return requestId;
    }
}
