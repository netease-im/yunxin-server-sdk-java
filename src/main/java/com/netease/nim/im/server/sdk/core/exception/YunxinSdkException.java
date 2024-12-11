package com.netease.nim.im.server.sdk.core.exception;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinSdkException extends Exception {

    private final String traceId;

    public YunxinSdkException(String traceId, String message, Throwable error) {
        super(message, error);
        this.traceId = traceId;
    }

    public YunxinSdkException(String traceId) {
        this.traceId = traceId;
    }

    public String getTraceId() {
        return traceId;
    }
}
