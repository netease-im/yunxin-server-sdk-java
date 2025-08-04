package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ToggleChatBanRequestV2 {

    
    @JSONField(serialize = false)
    private String accountId;
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    
    public ToggleChatBanRequestV2() {
    }
    
    
    public ToggleChatBanRequestV2(Long roomId, String operatorAccountId, Boolean chatBanned) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
    }
    
    
    public ToggleChatBanRequestV2(String accountId, Long roomId, String operatorAccountId, Boolean chatBanned) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
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
    
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
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
    
    
    public String getAccountId() {
        return accountId;
    }
    
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 