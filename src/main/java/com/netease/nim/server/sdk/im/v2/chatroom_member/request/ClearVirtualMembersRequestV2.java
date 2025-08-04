package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ClearVirtualMembersRequestV2 {
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    public ClearVirtualMembersRequestV2() {
    }
    
    
    public ClearVirtualMembersRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
} 