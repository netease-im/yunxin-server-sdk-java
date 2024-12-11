package com.netease.nim.im.server.sdk.v1.exception;

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinSdkCodeException extends YunxinSdkException {

    private final String endpoint;
    private final int code;
    private final String msg;

    public YunxinSdkCodeException(String endpoint, int code, String traceId, String msg) {
        super("endpoint: " + endpoint + ", code: " + code + ", trace-id: " + traceId + ", msg: " + msg);
        this.endpoint = endpoint;
        this.code = code;
        this.msg = msg;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
