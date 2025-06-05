package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for clearing all virtual members from a chatroom
 * 
 * This request allows removing all virtual members from a chatroom at once.
 */
public class ClearVirtualMembersRequestV2 {
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Whether to send notification about virtual members being removed
     * Default is true
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Default constructor
     */
    public ClearVirtualMembersRequestV2() {
    }
    
    /**
     * Constructor with required field
     * 
     * @param roomId chatroom ID
     */
    public ClearVirtualMembersRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get chatroom ID
     * 
     * @return chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set chatroom ID
     * 
     * @param roomId chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get notification enabled flag
     * 
     * @return true if notification is enabled, false otherwise
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set notification enabled flag
     * 
     * @param notificationEnabled notification enabled flag
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
} 