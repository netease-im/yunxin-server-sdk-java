package com.netease.nim.server.sdk.im.v1.chatroom.response;

/**
 * Response for cleaning up (dropping) a chatroom queue
 */
public class QueueDropResponseV1 {
    private Boolean highPriority;

    public Boolean getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }
} 