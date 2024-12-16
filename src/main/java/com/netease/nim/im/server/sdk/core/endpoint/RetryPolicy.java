package com.netease.nim.im.server.sdk.core.endpoint;


/**
 * Created by caojiajun on 2024/12/9
 */
public interface RetryPolicy {

    long[] intervalArray = new long[] {0, 5, 10, 50, 100, 500, 1000, 5000};

    /**
     * 最大重试次数，0 代表不重试
     * 最大允许设置 128，如果超过 128 实际生效最多 128
     * @return 次数
     */
    default int maxRetry() {
        return 1;
    }

    /**
     * 重试间隔，单位ms
     * @param retryContext 重试上下文
     * @param retry 第几次重试，从0开始
     * @return 间隔
     */
    default long retryInterval(ExecuteContext retryContext, int retry) {
        if (retry >= intervalArray.length) {
            return intervalArray[intervalArray.length - 1];
        }
        return intervalArray[retry];
    }


    /**
     * 是否要重试
     * @param retryContext 重试上下文
     * @param retry 第几次重试，从0开始
     * @param error 依次
     * @return 重试操作
     */
    default RetryAction onError(ExecuteContext retryContext, int retry, Throwable error) {
        return RetryAction.NO_RETRY;
    }

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
