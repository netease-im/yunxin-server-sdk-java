package com.netease.nim.server.sdk.im.v1.chatroom.response;

/**
 * Response for adding element to chatroom queue
 */
public class QueueOfferResponseV1 {
    private Boolean highPriority;

    public Boolean getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }
}