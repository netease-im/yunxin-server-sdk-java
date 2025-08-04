package com.netease.nim.server.sdk.im.v1.chatroom.response;

import java.util.List;

/**
 * Response for batch adding elements to chatroom queue
 */
public class QueueBatchOfferResponseV1 {
    
    private Boolean highPriority;
    private List<String> failedKeys;

    public Boolean getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    public List<String> getFailedKeys() {
        return failedKeys;
    }

    public void setFailedKeys(List<String> failedKeys) {
        this.failedKeys = failedKeys;
    }
} 