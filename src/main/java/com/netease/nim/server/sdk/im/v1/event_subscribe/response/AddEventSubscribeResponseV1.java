package com.netease.nim.server.sdk.im.v1.event_subscribe.response;

import java.util.List;

/**
 * Response object for adding online status event subscriptions
 */
public class AddEventSubscribeResponseV1 {
    /**
     * List of account IDs that failed to be subscribed
     */
    private List<String> failedAccid;

    public List<String> getFailedAccid() {
        return failedAccid;
    }

    public void setFailedAccid(List<String> failedAccid) {
        this.failedAccid = failedAccid;
    }
} 