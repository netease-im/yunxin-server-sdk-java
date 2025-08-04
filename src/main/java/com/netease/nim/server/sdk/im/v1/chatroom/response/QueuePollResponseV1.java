package com.netease.nim.server.sdk.im.v1.chatroom.response;

/**
 * Response for retrieving (polling) an element from a chatroom queue
 */
public class QueuePollResponseV1 {

    private Boolean highPriority;
    private String key;
    private String value;

    public Boolean getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
} 