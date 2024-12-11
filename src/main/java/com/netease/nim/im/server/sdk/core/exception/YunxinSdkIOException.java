package com.netease.nim.im.server.sdk.core.exception;

import com.netease.nim.im.server.sdk.core.endpoint.ExecuteContext;

/**
 * Created by caojiajun on 2024/12/9
 */
public class YunxinSdkIOException extends YunxinSdkException {

    private final ExecuteContext context;

    public YunxinSdkIOException(ExecuteContext context, Exception e) {
        super(context.getTraceId(), "endpoint: " + context.getEndpoint() + ", trace-id: " + context.getTraceId() + ", message: " + e.getMessage(), e);
        this.context = context;
    }

    public ExecuteContext getContext() {
        return context;
    }
}
