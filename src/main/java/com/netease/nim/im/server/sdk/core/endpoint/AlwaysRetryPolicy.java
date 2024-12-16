package com.netease.nim.im.server.sdk.core.endpoint;

/**
 * Created by caojiajun on 2024/12/9
 */
public class AlwaysRetryPolicy implements RetryPolicy {

    private final int maxRetry;

    public AlwaysRetryPolicy(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public int maxRetry() {
        return maxRetry;
    }

    @Override
    public RetryAction onError(ExecuteContext retryContext, int retry, Throwable error) {
        return RetryAction.RETRY_NEXT;
    }
}
