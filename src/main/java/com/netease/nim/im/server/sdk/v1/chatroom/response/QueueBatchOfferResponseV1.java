package com.netease.nim.im.server.sdk.v1.chatroom.response;

import java.util.List;

/**
 * Response for batch adding elements to chatroom queue
 */
public class QueueBatchOfferResponseV1 {
    
    /**
     * List of keys that failed to be added to the queue
     */
    private List<String> failedKeys;

    public List<String> getFailedKeys() {
        return failedKeys;
    }

    public void setFailedKeys(List<String> failedKeys) {
        this.failedKeys = failedKeys;
    }
} 