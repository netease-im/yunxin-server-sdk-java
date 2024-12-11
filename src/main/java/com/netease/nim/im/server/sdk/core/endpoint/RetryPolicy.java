package com.netease.nim.im.server.sdk.core.endpoint;


/**
 * Created by caojiajun on 2024/12/9
 */
public interface RetryPolicy {

    RetryAction onError(ExecuteContext retryContext, Throwable error);

    class RetryAction {

        public static RetryAction NO_RETRY = new RetryAction(false, false);
        public static RetryAction RETRY_CURRENT = new RetryAction(true, false);
        public static RetryAction RETRY_NEXT = new RetryAction(true, true);

        private final boolean retry;
        private final boolean nextEndpoint;

        public RetryAction(boolean retry, boolean nextEndpoint) {
            this.retry = retry;
            this.nextEndpoint = nextEndpoint;
        }

        public boolean isRetry() {
            return retry;
        }

        public boolean isNextEndpoint() {
            return nextEndpoint;
        }
    }
}
