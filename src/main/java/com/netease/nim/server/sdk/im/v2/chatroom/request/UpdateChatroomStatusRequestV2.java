package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class UpdateChatroomStatusRequestV2 {

    @JSONField(serialize = false)
    private Long roomId;

    
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    
    @JSONField(name = "valid")
    private Boolean valid;
    
    
    @JSONField(name = "delay_close_policy")
    private Integer delayClosePolicy;
    
    
    @JSONField(name = "delay_seconds")
    private Long delaySeconds;
    
    
    public UpdateChatroomStatusRequestV2() {
    }
    
    
    public UpdateChatroomStatusRequestV2(String operatorAccountId, Boolean valid) {
        this.operatorAccountId = operatorAccountId;
        this.valid = valid;
    }
    
    
    public UpdateChatroomStatusRequestV2(String operatorAccountId, Boolean valid, Integer delayClosePolicy, Long delaySeconds) {
        this.operatorAccountId = operatorAccountId;
        this.valid = valid;
        this.delayClosePolicy = delayClosePolicy;
        this.delaySeconds = delaySeconds;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    
    public Boolean getValid() {
        return valid;
    }
    
    
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    
    
    public Integer getDelayClosePolicy() {
        return delayClosePolicy;
    }
    
    
    public void setDelayClosePolicy(Integer delayClosePolicy) {
        this.delayClosePolicy = delayClosePolicy;
    }
    
    
    public Long getDelaySeconds() {
        return delaySeconds;
    }
    
    
    public void setDelaySeconds(Long delaySeconds) {
        this.delaySeconds = delaySeconds;
    }
} 