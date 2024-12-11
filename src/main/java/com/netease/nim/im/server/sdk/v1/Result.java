package com.netease.nim.im.server.sdk.v1;

/**
 * Created by caojiajun on 2024/12/11
 */
public class Result<T> {

    private final int code;
    private final String traceId;
    private final String msg;
    private final T response;

    public Result(int code, String traceId, String msg, T response) {
        this.code = code;
        this.traceId = traceId;
        this.msg = msg;
        this.response = response;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    public int getCode() {
        return code;
    }

    public String getTraceId() {
        return traceId;
    }

    public String getMsg() {
        return msg;
    }

    public T getResponse() {
        return response;
    }
}
