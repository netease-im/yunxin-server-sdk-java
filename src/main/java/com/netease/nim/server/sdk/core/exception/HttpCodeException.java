package com.netease.nim.server.sdk.core.exception;

import com.netease.nim.server.sdk.core.BizName;

/**
 * Created by caojiajun on 2024/12/9
 */
public class HttpCodeException extends RuntimeException {

    private final BizName bizName;
    private final int code;
    private final String endpoint;

    public HttpCodeException(BizName bizName, String endpoint, int code, String data) {
        super("biz:" + bizName + ", endpoint: "+ endpoint + ", http.code: " + code + ", data: " + data);
        this.code = code;
        this.bizName = bizName;
        this.endpoint = endpoint;
    }

    public BizName getBizName() {
        return bizName;
    }

    public int getCode() {
        return code;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
