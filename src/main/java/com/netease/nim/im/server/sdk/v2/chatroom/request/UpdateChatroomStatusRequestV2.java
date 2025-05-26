package com.netease.nim.im.server.sdk.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for opening/closing a chatroom
 * 
 * This class encapsulates the parameters required to open or close a chatroom.
 */
public class UpdateChatroomStatusRequestV2 {

    /**
     * Operator account ID (must be the chatroom creator)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Whether the chatroom is open
     * true (default): Open
     * false: Closed
     */
    @JSONField(name = "valid")
    private Boolean valid;
    
    /**
     * Chatroom auto-close policy
     * 0: Don't auto-close
     * 1: Close after a fixed time (regardless of whether users are still in the chatroom)
     * 2: Close after the chatroom has been idle (no users) for a fixed time
     * 
     * Note: To use the auto-close feature, it must be enabled in the Yunxin console first.
     */
    @JSONField(name = "delay_close_policy")
    private Integer delayClosePolicy;
    
    /**
     * Delay seconds for auto-close
     * Maximum value: 7 days (604800 seconds)
     * 
     * This parameter is only effective when delay_close_policy is 1 or 2.
     * If not provided, the delay time configured in the console will be used.
     */
    @JSONField(name = "delay_seconds")
    private Long delaySeconds;
    
    /**
     * Default constructor
     */
    public UpdateChatroomStatusRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param operatorAccountId The account ID of the operator (must be the chatroom creator)
     * @param valid Whether the chatroom is open
     */
    public UpdateChatroomStatusRequestV2(String operatorAccountId, Boolean valid) {
        this.operatorAccountId = operatorAccountId;
        this.valid = valid;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param operatorAccountId The account ID of the operator (must be the chatroom creator)
     * @param valid Whether the chatroom is open
     * @param delayClosePolicy The chatroom auto-close policy
     * @param delaySeconds The delay seconds for auto-close
     */
    public UpdateChatroomStatusRequestV2(String operatorAccountId, Boolean valid, Integer delayClosePolicy, Long delaySeconds) {
        this.operatorAccountId = operatorAccountId;
        this.valid = valid;
        this.delayClosePolicy = delayClosePolicy;
        this.delaySeconds = delaySeconds;
    }
    
    /**
     * Get the operator account ID
     * 
     * @return The operator account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set the operator account ID
     * 
     * @param operatorAccountId The operator account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get whether the chatroom is open
     * 
     * @return Whether the chatroom is open
     */
    public Boolean getValid() {
        return valid;
    }
    
    /**
     * Set whether the chatroom is open
     * 
     * @param valid Whether the chatroom is open
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    
    /**
     * Get the chatroom auto-close policy
     * 
     * @return The chatroom auto-close policy
     */
    public Integer getDelayClosePolicy() {
        return delayClosePolicy;
    }
    
    /**
     * Set the chatroom auto-close policy
     * 
     * @param delayClosePolicy The chatroom auto-close policy
     */
    public void setDelayClosePolicy(Integer delayClosePolicy) {
        this.delayClosePolicy = delayClosePolicy;
    }
    
    /**
     * Get the delay seconds for auto-close
     * 
     * @return The delay seconds for auto-close
     */
    public Long getDelaySeconds() {
        return delaySeconds;
    }
    
    /**
     * Set the delay seconds for auto-close
     * 
     * @param delaySeconds The delay seconds for auto-close
     */
    public void setDelaySeconds(Long delaySeconds) {
        this.delaySeconds = delaySeconds;
    }
} 