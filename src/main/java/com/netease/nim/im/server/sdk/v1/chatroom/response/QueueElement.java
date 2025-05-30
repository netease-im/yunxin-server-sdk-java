package com.netease.nim.im.server.sdk.v1.chatroom.response;

/**
 * Represents an element in a chatroom queue
 */
public class QueueElement {
    
    /**
     * Element key
     */
    private String key;
    
    /**
     * Element value
     */
    private String value;
    
    /**
     * Owner's account ID
     */
    private String accid;
    
    /**
     * Whether to delete when owner leaves the chatroom
     */
    private Boolean transient_;

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

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Boolean getTransient_() {
        return transient_;
    }

    public void setTransient_(Boolean transient_) {
        this.transient_ = transient_;
    }
} 