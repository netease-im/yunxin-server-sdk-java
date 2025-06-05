package com.netease.nim.server.sdk.core.exception;

import com.netease.nim.server.sdk.core.endpoint.ExecuteContext;

/**
 * Created by caojiajun on 2024/12/9
 */
public class YunxinSdkException extends RuntimeException {

    private final ExecuteContext context;

    public YunxinSdkException(ExecuteContext context, Exception e) {
        super("biz:" + context.getBizName() + "endpoint: " + context.getEndpoint() + ", trace-id: " + context.getTraceId() + ", message: " + e.getMessage(), e);
        this.context = context;
    }

    public ExecuteContext getContext() {
        return context;
    }

    public String getTraceId() {
        return context.getTraceId();
    }
}
