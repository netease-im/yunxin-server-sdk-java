package com.netease.nim.server.sdk.im.v1.chatroom.response;

/**
 * Response for retrieving (polling) an element from a chatroom queue
 */
public class QueuePollResponseV1 {
    
    /**
     * Element key
     */
    private String key;
    
    /**
     * Element value
     */
    private String value;

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