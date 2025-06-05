package com.netease.nim.server.sdk.im.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for creating a chatroom
 * 
 * API: POST https://open.yunxinapi.com/im/v2/chatrooms
 */
public class CreateChatroomResponseV2 {
    
    @JSONField(name = "valid")
    private Boolean valid;                 // Chatroom status (true: open, false: closed)
    
    @JSONField(name = "creator")
    private String creator;                // Chatroom creator's account ID
    
    @JSONField(name = "room_name")
    private String roomName;               // Chatroom name
    
    @JSONField(name = "announcement")
    private String announcement;           // Chatroom announcement
    
    @JSONField(name = "live_url")
    private String liveUrl;                // Live broadcast URL
    
    @JSONField(name = "extension")
    private String extension;              // Custom extension field
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;            // Whether the chatroom is in all-user mute state
    
    @JSONField(name = "room_id")
    private Long roomId;                   // Chatroom ID
    
    @JSONField(name = "queue_level")
    private Integer queueLevel;            // Queue management permission level
    
    @JSONField(name = "delay_info")
    private DelayInfo delayInfo;           // Auto-close information
    
    /**
     * Default constructor
     */
    public CreateChatroomResponseV2() {
    }
    
    /**
     * Inner class for auto-close information
     */
    public static class DelayInfo {
        
        @JSONField(name = "delay_seconds")
        private Long delaySeconds;         // Auto-close time in seconds
        
        @JSONField(name = "delay_close_enable")
        private Boolean delayCloseEnable;  // Whether auto-close is enabled
        
        @JSONField(name = "start_time")
        private Long startTime;            // Chatroom start time timestamp
        
        @JSONField(name = "delay_close_policy")
        private Integer delayClosePolicy;  // Auto-close policy
        
        @JSONField(name = "status")
        private Integer status;            // Current status of the chatroom
        
        public Long getDelaySeconds() {
            return delaySeconds;
        }
        
        public void setDelaySeconds(Long delaySeconds) {
            this.delaySeconds = delaySeconds;
        }
        
        public Boolean getDelayCloseEnable() {
            return delayCloseEnable;
        }
        
        public void setDelayCloseEnable(Boolean delayCloseEnable) {
            this.delayCloseEnable = delayCloseEnable;
        }
        
        public Long getStartTime() {
            return startTime;
        }
        
        public void setStartTime(Long startTime) {
            this.startTime = startTime;
        }
        
        public Integer getDelayClosePolicy() {
            return delayClosePolicy;
        }
        
        public void setDelayClosePolicy(Integer delayClosePolicy) {
            this.delayClosePolicy = delayClosePolicy;
        }
        
        public Integer getStatus() {
            return status;
        }
        
        public void setStatus(Integer status) {
            this.status = status;
        }
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
    
    public DelayInfo getDelayInfo() {
        return delayInfo;
    }
    
    public void setDelayInfo(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }
} 