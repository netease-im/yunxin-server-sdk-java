package com.netease.nim.server.sdk.im.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for updating chatroom status (open/close)
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/update_status
 */
public class UpdateChatroomStatusResponseV2 {
    
    /**
     * Chatroom status
     * true: open, false: closed
     */
    @JSONField(name = "valid")
    private Boolean valid;
    
    /**
     * Chatroom creator account ID
     */
    @JSONField(name = "creator")
    private String creator;
    
    /**
     * Chatroom name
     */
    @JSONField(name = "room_name")
    private String roomName;
    
    /**
     * Chatroom announcement
     */
    @JSONField(name = "announcement")
    private String announcement;
    
    /**
     * Live URL
     */
    @JSONField(name = "live_url")
    private String liveUrl;
    
    /**
     * Custom extension field
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Whether the chatroom is in global mute state
     * true: muted, false: not muted
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Queue management permission level
     * 0: Everyone has permission to modify the queue
     * 1: Only administrators can modify the queue
     */
    @JSONField(name = "queue_level")
    private Integer queueLevel;
    
    /**
     * Default constructor
     */
    public UpdateChatroomStatusResponseV2() {
    }
    
    // Getters and setters
    
    public Boolean getValid() {
        return valid;
    }
    
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public String getAnnouncement() {
        return announcement;
    }
    
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
    
    public String getLiveUrl() {
        return liveUrl;
    }
    
    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    public Long getRoomId() {
        return roomId;
    }
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    public Integer getQueueLevel() {
        return queueLevel;
    }
    
    public void setQueueLevel(Integer queueLevel) {
        this.queueLevel = queueLevel;
    }
} 