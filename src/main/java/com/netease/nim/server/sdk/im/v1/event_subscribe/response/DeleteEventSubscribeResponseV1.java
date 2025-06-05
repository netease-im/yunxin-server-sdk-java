package com.netease.nim.server.sdk.im.v1.event_subscribe.response;

import java.util.List;

/**
 * Response object for deleting online status event subscriptions
 */
public class DeleteEventSubscribeResponseV1 {
    /**
     * List of account IDs that failed to be unsubscribed
     */
    private List<String> failedAccid;

    public List<String> getFailedAccid() {
        return failedAccid;
    }

    public void setFailedAccid(List<String> failedAccid) {
        this.failedAccid = failedAccid;
    }
} 