package com.netease.nim.im.server.sdk.core.exception;

/**
 * Created by caojiajun on 2024/12/9
 */
public class HttpCodeException extends RuntimeException {

    private final int code;
    private final String endpoint;

    public HttpCodeException(String endpoint, int code, String data) {
        super("endpoint: "+ endpoint + ", http.code: " + code + ", data: " + data);
        this.code = code;
        this.endpoint = endpoint;
    }

    public int getCode() {
        return code;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
