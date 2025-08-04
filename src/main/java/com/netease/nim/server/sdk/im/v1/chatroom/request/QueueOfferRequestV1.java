package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Request for adding element to chatroom queue
 */
public class QueueOfferRequestV1 {

    /**
     * Chatroom ID
     */
    @YunxinParam("roomid")
    private Long roomid;
    
    /**
     * Queue element key
     */
    @YunxinParam("key")
    private String key;
    
    /**
     * Queue element value
     */
    @YunxinParam("value")
    private String value;
    
    /**
     * Operator account, operator must be online (in the chatroom)
     * Default is the creator of the chatroom.
     * If the specified operator is not online (not in the chatroom),
     * the operator must be the creator of the chatroom to successfully add or update elements, otherwise it returns 403 error.
     * If the operator account does not exist, it returns 404 error.
     */
    @YunxinParam("operator")
    private String operator;
    
    /**
     * Whether the added element needs to be deleted when the operator goes offline or leaves the chatroom.
     * true: needs to be deleted; false: does not need to be deleted (default).
     * If set to true and the operator is not currently in the chatroom, it returns 302 error.
     */
    @YunxinParam("transient")
    private Boolean transient_;
    
    /**
     * Whether to set as high priority message
     * 0: No (default); 1: Yes, high priority message
     */
    @YunxinParam("highPriority")
    private Integer highPriority;
    
    /**
     * High priority message policy: for high priority messages,
     * whether to downgrade to normal message when exceeding flow control or return 416 error code
     * 0: Downgrade to normal message (default); 1: Return 416 error code
     */
    @YunxinParam("highPriorityPolicy")
    private Integer highPriorityPolicy;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
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
    
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getTransient() {
        return transient_;
    }

    public void setTransient(Boolean value) {
        this.transient_ = value;
    }

    public Integer getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(Integer highPriority) {
        this.highPriority = highPriority;
    }

    public Integer getHighPriorityPolicy() {
        return highPriorityPolicy;
    }

    public void setHighPriorityPolicy(Integer highPriorityPolicy) {
        this.highPriorityPolicy = highPriorityPolicy;
    }
} 