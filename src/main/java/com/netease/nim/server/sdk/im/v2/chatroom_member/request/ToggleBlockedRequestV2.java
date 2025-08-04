package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ToggleBlockedRequestV2 {
    
    
    @JSONField(serialize = false)
    private String accountId;
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    
    @JSONField(name = "blocked")
    private Boolean blocked;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    
    public ToggleBlockedRequestV2() {
    }
    
    
    public ToggleBlockedRequestV2(String accountId, Long roomId, String operatorAccountId, Boolean blocked) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.blocked = blocked;
    }
    
    
    public String getAccountId() {
        return accountId;
    }
    
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
    
    
    public Boolean getBlocked() {
        return blocked;
    }
    
    
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
    
    
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
} 