package com.netease.nim.server.sdk.im.v1.chatroom.response;

import java.util.List;

/**
 * Response for batch updating elements in chatroom queue
 */
public class QueueBatchUpdateResponseV1 {
    
    /**
     * List of keys that don't exist in the queue
     */
    private List<String> noExistElementKey;

    public List<String> getNoExistElementKey() {
        return noExistElementKey;
    }

    public void setNoExistElementKey(List<String> noExistElementKey) {
        this.noExistElementKey = noExistElementKey;
    }
} 