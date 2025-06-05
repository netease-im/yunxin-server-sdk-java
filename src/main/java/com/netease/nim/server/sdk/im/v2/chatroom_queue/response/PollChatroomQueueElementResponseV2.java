package com.netease.nim.server.sdk.im.v2.chatroom_queue.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for polling an element from a chatroom queue
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/room_queues/{room_id}/actions/poll
 */
public class PollChatroomQueueElementResponseV2 {
    
    /**
     * Element key that was polled
     */
    @JSONField(name = "element_key")
    private String elementKey;
    
    /**
     * Element value that was polled
     */
    @JSONField(name = "element_value")
    private String elementValue;
    
    /**
     * Account ID of the owner of the polled element
     */
    @JSONField(name = "element_account_id")
    private String elementAccountId;
    
    /**
     * Whether the element is removed when the owner leaves the chatroom
     */
    @JSONField(name = "element_transient")
    private Boolean elementTransient;
    
    /**
     * Default constructor
     */
    public PollChatroomQueueElementResponseV2() {
    }
    
    /**
     * Get element key
     * 
     * @return element key
     */
    public String getElementKey() {
        return elementKey;
    }
    
    /**
     * Set element key
     * 
     * @param elementKey element key
     */
    public void setElementKey(String elementKey) {
        this.elementKey = elementKey;
    }
    
    /**
     * Get element value
     * 
     * @return element value
     */
    public String getElementValue() {
        return elementValue;
    }
    
    /**
     * Set element value
     * 
     * @param elementValue element value
     */
    public void setElementValue(String elementValue) {
        this.elementValue = elementValue;
    }
    
    /**
     * Get account ID of the owner
     * 
     * @return account ID of the owner
     */
    public String getElementAccountId() {
        return elementAccountId;
    }
    
    /**
     * Set account ID of the owner
     * 
     * @param elementAccountId account ID of the owner
     */
    public void setElementAccountId(String elementAccountId) {
        this.elementAccountId = elementAccountId;
    }
    
    /**
     * Get whether the element is removed when the owner leaves the chatroom
     * 
     * @return whether the element is removed when the owner leaves the chatroom
     */
    public Boolean getElementTransient() {
        return elementTransient;
    }
    
    /**
     * Set whether the element is removed when the owner leaves the chatroom
     * 
     * @param elementTransient whether the element is removed when the owner leaves the chatroom
     */
    public void setElementTransient(Boolean elementTransient) {
        this.elementTransient = elementTransient;
    }
} 