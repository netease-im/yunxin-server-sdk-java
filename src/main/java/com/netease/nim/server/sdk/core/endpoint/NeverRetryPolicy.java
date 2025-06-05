package com.netease.nim.server.sdk.core.endpoint;

/**
 * Created by caojiajun on 2024/12/9
 */
public class NeverRetryPolicy implements RetryPolicy {

    @Override
    public RetryAction onError(ExecuteContext retryContext, int retry, Throwable error) {
        return RetryAction.NO_RETRY;
    }
}
