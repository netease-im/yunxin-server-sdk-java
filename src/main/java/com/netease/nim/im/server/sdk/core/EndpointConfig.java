package com.netease.nim.im.server.sdk.core;

import com.netease.nim.im.server.sdk.core.endpoint.EndpointSelector;
import com.netease.nim.im.server.sdk.core.endpoint.RetryPolicy;


/**
 * Created by caojiajun on 2024/12/9
 */
public class EndpointConfig {

    private int maxRetry = Constants.Retry.maxRetry;
    private RetryPolicy retryPolicy = Constants.Retry.retryPolicy;
    private EndpointSelector endpointSelector;

    public int getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public RetryPolicy getRetryPolicy() {
        return retryPolicy;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
    }

    public EndpointSelector getEndpointSelector() {
        return endpointSelector;
    }

    public void setEndpointSelector(EndpointSelector endpointSelector) {
        this.endpointSelector = endpointSelector;
    }
}
