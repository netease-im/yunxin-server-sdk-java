package com.netease.nim.server.sdk.core.exception;

/**
 * Created by caojiajun on 2024/12/10
 */
public class EndpointFetchException extends RuntimeException {

    public EndpointFetchException(String message) {
        super(message);
    }

    public EndpointFetchException(Throwable cause) {
        super(cause);
    }
}
