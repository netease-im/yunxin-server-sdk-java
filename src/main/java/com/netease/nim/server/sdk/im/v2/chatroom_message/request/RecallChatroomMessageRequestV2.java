package com.netease.nim.server.sdk.im.v2.chatroom_message.request;


public class RecallChatroomMessageRequestV2 {
    
    private Long roomId;
    private String messageClientId;
    private String operatorId;
    private String senderId;
    private Long createTime;
    private Boolean notificationEnabled;
    private String notificationExtension;
    
    
    public RecallChatroomMessageRequestV2() {
    }
    
    
    public RecallChatroomMessageRequestV2(Long roomId, String messageClientId, String operatorId, 
                                          String senderId, Long createTime, Boolean notificationEnabled) {
        this.roomId = roomId;
        this.messageClientId = messageClientId;
        this.operatorId = operatorId;
        this.senderId = senderId;
        this.createTime = createTime;
        this.notificationEnabled = notificationEnabled;
    }
    
    public Long getRoomId() {
        return roomId;
    }
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getMessageClientId() {
        return messageClientId;
    }
    
    public void setMessageClientId(String messageClientId) {
        this.messageClientId = messageClientId;
    }
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public String getSenderId() {
        return senderId;
    }
    
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Long getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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