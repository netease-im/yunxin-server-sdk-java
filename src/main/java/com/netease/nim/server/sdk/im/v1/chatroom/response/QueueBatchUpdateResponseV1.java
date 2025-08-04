package com.netease.nim.server.sdk.im.v1.chatroom.response;

import java.util.List;

/**
 * Response for batch updating elements in chatroom queue
 */
public class QueueBatchUpdateResponseV1 {
    
    private Boolean highPriority;
    private List<String> noExistElementKey;

    public Boolean getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    public List<String> getNoExistElementKey() {
        return noExistElementKey;
    }

    public void setNoExistElementKey(List<String> noExistElementKey) {
        this.noExistElementKey = noExistElementKey;
    }
} 