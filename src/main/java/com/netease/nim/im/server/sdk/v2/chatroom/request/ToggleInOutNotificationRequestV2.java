package com.netease.nim.im.server.sdk.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for toggling in/out notification for a chatroom
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/in_out_notification
 * 
 * This class encapsulates the parameters required to enable or disable entry/exit
 * event notifications in a chatroom.
 */
public class ToggleInOutNotificationRequestV2 {

    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Whether to enable in/out notification
     * true: enable, false: disable
     */
    @JSONField(name = "in_out_notification")
    private Boolean inOutNotification;
    
    /**
     * Default constructor
     */
    public ToggleInOutNotificationRequestV2() {
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param roomId The chatroom ID
     * @param inOutNotification Whether to enable in/out notification
     */
    public ToggleInOutNotificationRequestV2(Long roomId, Boolean inOutNotification) {
        this.roomId = roomId;
        this.inOutNotification = inOutNotification;
    }
    
    /**
     * Get the chatroom ID
     * 
     * @return The chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the chatroom ID
     * 
     * @param roomId The chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get whether in/out notification is enabled
     * 
     * @return Whether in/out notification is enabled
     */
    public Boolean getInOutNotification() {
        return inOutNotification;
    }
    
    /**
     * Set whether in/out notification is enabled
     * 
     * @param inOutNotification Whether in/out notification is enabled
     */
    public void setInOutNotification(Boolean inOutNotification) {
        this.inOutNotification = inOutNotification;
    }
} 