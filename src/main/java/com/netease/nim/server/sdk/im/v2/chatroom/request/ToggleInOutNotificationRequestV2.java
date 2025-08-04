package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ToggleInOutNotificationRequestV2 {

    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "in_out_notification")
    private Boolean inOutNotification;
    
    
    public ToggleInOutNotificationRequestV2() {
    }
    
    
    public ToggleInOutNotificationRequestV2(Long roomId, Boolean inOutNotification) {
        this.roomId = roomId;
        this.inOutNotification = inOutNotification;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Boolean getInOutNotification() {
        return inOutNotification;
    }
    
    
    public void setInOutNotification(Boolean inOutNotification) {
        this.inOutNotification = inOutNotification;
    }
} 