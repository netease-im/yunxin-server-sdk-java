package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for updating chatroom status (open/close)
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/update_status
 * 
 * This class encapsulates the parameters required to update a chatroom's status.
 * After creation, a chatroom is open by default. The creator can close it to prevent
 * users from joining, or reopen it later. This interface can also set auto-close policies.
 */
public class UpdateChatroomStatusRequestV2 {

    /**
     * Operator account ID (must be the chatroom creator)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Chatroom status
     * true: open, false: closed
     */
    @JSONField(name = "valid")
    private Boolean valid;
    
    /**
     * Auto-close policy
     * 0: Don't auto-close
     * 1: Close after fixed time (regardless of users)
     * 2: Close after being idle for a fixed time (when no users)
     * 
     * Note: To use this feature, it must be enabled in the Yunxin console first.
     */
    @JSONField(name = "delay_close_policy")
    private Integer delayClosePolicy;
    
    /**
     * Time in seconds after which the chatroom will be closed
     * Only effective when delay_close_policy is 1 or 2
     * Maximum value: 7x24x3600 seconds (7 days)
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
     * @param operatorAccountId The operator account ID (must be the chatroom creator)
     * @param valid The chatroom status (true: open, false: closed)
     */
    public UpdateChatroomStatusRequestV2(String operatorAccountId, Boolean valid) {
        this.operatorAccountId = operatorAccountId;
        this.valid = valid;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param operatorAccountId The operator account ID (must be the chatroom creator)
     * @param valid The chatroom status (true: open, false: closed)
     * @param delayClosePolicy The auto-close policy
     * @param delaySeconds The time in seconds after which the chatroom will be closed
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
     * Get the chatroom status
     * 
     * @return The chatroom status
     */
    public Boolean getValid() {
        return valid;
    }
    
    /**
     * Set the chatroom status
     * 
     * @param valid The chatroom status (true: open, false: closed)
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    
    /**
     * Get the auto-close policy
     * 
     * @return The auto-close policy
     */
    public Integer getDelayClosePolicy() {
        return delayClosePolicy;
    }
    
    /**
     * Set the auto-close policy
     * 
     * @param delayClosePolicy The auto-close policy (0: Don't auto-close, 1: Fixed time close, 2: Idle time close)
     */
    public void setDelayClosePolicy(Integer delayClosePolicy) {
        this.delayClosePolicy = delayClosePolicy;
    }
    
    /**
     * Get the delay seconds
     * 
     * @return The delay seconds
     */
    public Long getDelaySeconds() {
        return delaySeconds;
    }
    
    /**
     * Set the delay seconds
     * 
     * @param delaySeconds The time in seconds after which the chatroom will be closed
     */
    public void setDelaySeconds(Long delaySeconds) {
        this.delaySeconds = delaySeconds;
    }
} 