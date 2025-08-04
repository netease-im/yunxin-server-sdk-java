package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ToggleTaggedMembersChatBanRequestV2 {
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    
    @JSONField(name = "target_tag")
    private String targetTag;
    
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    
    @JSONField(name = "chat_banned_duration")
    private Long chatBannedDuration;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    
    @JSONField(name = "notification_target_tags")
    private String notificationTargetTags;
    
    
    public ToggleTaggedMembersChatBanRequestV2() {
    }
    
    
    public ToggleTaggedMembersChatBanRequestV2(Long roomId, String operatorAccountId, String targetTag, Boolean chatBanned) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.targetTag = targetTag;
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
    
    
    public String getTargetTag() {
        return targetTag;
    }
    
    
    public void setTargetTag(String targetTag) {
        this.targetTag = targetTag;
    }
    
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    
    public Long getChatBannedDuration() {
        return chatBannedDuration;
    }
    
    
    public void setChatBannedDuration(Long chatBannedDuration) {
        this.chatBannedDuration = chatBannedDuration;
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
    
    
    public String getNotificationTargetTags() {
        return notificationTargetTags;
    }
    
    
    public void setNotificationTargetTags(String notificationTargetTags) {
        this.notificationTargetTags = notificationTargetTags;
    }
} 