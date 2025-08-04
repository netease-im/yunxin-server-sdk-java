package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ToggleChatroomMuteRequestV2 {

    @JSONField(serialize = false)
    private Long roomId;

    
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    
    public ToggleChatroomMuteRequestV2() {
    }
    
    
    public ToggleChatroomMuteRequestV2(String operatorAccountId, Boolean chatBanned) {
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
    }
    
    
    public ToggleChatroomMuteRequestV2(String operatorAccountId, Boolean chatBanned, 
            Boolean notificationEnabled, String notificationExtension) {
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
        this.notificationEnabled = notificationEnabled;
        this.notificationExtension = notificationExtension;
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
} 