package com.netease.nim.im.server.sdk.core.endpoint;

import com.netease.nim.im.server.sdk.core.exception.HttpCodeException;
import com.netease.nim.im.server.sdk.core.utils.ExceptionUtils;

/**
 * Created by caojiajun on 2024/12/9
 */
public class DefaultRetryPolicy implements RetryPolicy {

    private final boolean retryOn502;

    public DefaultRetryPolicy(boolean retryOn502) {
        this.retryOn502 = retryOn502;
    }

    @Override
    public RetryAction onError(ExecuteContext retryContext, Throwable error) {
        if (error instanceof HttpCodeException) {
            if (((HttpCodeException) error).getCode() == 502 && retryOn502) {
                return RetryAction.RETRY_NEXT;
            }
        }
        if (ExceptionUtils.isConnectError(error)) {
            return RetryAction.RETRY_NEXT;
        }
        return RetryAction.NO_RETRY;
    }
}
