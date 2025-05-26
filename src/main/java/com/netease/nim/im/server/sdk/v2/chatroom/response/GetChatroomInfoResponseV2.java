package com.netease.nim.im.server.sdk.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for getting chatroom information
 * 
 * This class encapsulates the response data containing chatroom details.
 */
public class GetChatroomInfoResponseV2 {
    
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
     * Whether entry/exit notifications are enabled
     * true: enabled, false: disabled
     */
    @JSONField(name = "in_out_notification")
    private Boolean inOutNotification;
    
    /**
     * Whether CDN messaging is enabled
     * true: enabled, false: disabled
     */
    @JSONField(name = "cdn_message_enable")
    private Boolean cdnMessageEnable;
    
    /**
     * Total number of online users
     */
    @JSONField(name = "online_user_count")
    private Long onlineUserCount;
    
    /**
     * Number of online iOS users
     */
    @JSONField(name = "ios_online_user_count")
    private Integer iosOnlineUserCount;
    
    /**
     * Number of online Android users
     */
    @JSONField(name = "android_online_user_count")
    private Integer androidOnlineUserCount;
    
    /**
     * Number of online PC users
     */
    @JSONField(name = "pc_online_user_count")
    private Integer pcOnlineUserCount;
    
    /**
     * Number of online Web users
     */
    @JSONField(name = "web_online_user_count")
    private Integer webOnlineUserCount;
    
    /**
     * Number of online Mac users
     */
    @JSONField(name = "mac_online_user_count")
    private Integer macOnlineUserCount;
    
    /**
     * Delay information for auto-close
     */
    @JSONField(name = "delay_info")
    private DelayInfo delayInfo;
    
    /**
     * Default constructor
     */
    public GetChatroomInfoResponseV2() {
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

    public Boolean getInOutNotification() {
        return inOutNotification;
    }

    public void setInOutNotification(Boolean inOutNotification) {
        this.inOutNotification = inOutNotification;
    }

    public Boolean getCdnMessageEnable() {
        return cdnMessageEnable;
    }

    public void setCdnMessageEnable(Boolean cdnMessageEnable) {
        this.cdnMessageEnable = cdnMessageEnable;
    }

    public Long getOnlineUserCount() {
        return onlineUserCount;
    }

    public void setOnlineUserCount(Long onlineUserCount) {
        this.onlineUserCount = onlineUserCount;
    }

    public Integer getIosOnlineUserCount() {
        return iosOnlineUserCount;
    }

    public void setIosOnlineUserCount(Integer iosOnlineUserCount) {
        this.iosOnlineUserCount = iosOnlineUserCount;
    }

    public Integer getAndroidOnlineUserCount() {
        return androidOnlineUserCount;
    }

    public void setAndroidOnlineUserCount(Integer androidOnlineUserCount) {
        this.androidOnlineUserCount = androidOnlineUserCount;
    }

    public Integer getPcOnlineUserCount() {
        return pcOnlineUserCount;
    }

    public void setPcOnlineUserCount(Integer pcOnlineUserCount) {
        this.pcOnlineUserCount = pcOnlineUserCount;
    }

    public Integer getWebOnlineUserCount() {
        return webOnlineUserCount;
    }

    public void setWebOnlineUserCount(Integer webOnlineUserCount) {
        this.webOnlineUserCount = webOnlineUserCount;
    }

    public Integer getMacOnlineUserCount() {
        return macOnlineUserCount;
    }

    public void setMacOnlineUserCount(Integer macOnlineUserCount) {
        this.macOnlineUserCount = macOnlineUserCount;
    }

    /**
     * Get the delay info
     * 
     * @return The delay info
     */
    public DelayInfo getDelayInfo() {
        return delayInfo;
    }
    
    /**
     * Set the delay info
     * 
     * @param delayInfo The delay info
     */
    public void setDelayInfo(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }

    /**
     * Nested class for delay information
     */
    public static class DelayInfo {
        
        /**
         * Delay seconds for auto-close
         */
        @JSONField(name = "delay_seconds")
        private Long delaySeconds;
        
        /**
         * Whether auto-close is enabled
         */
        @JSONField(name = "delay_close_enable")
        private Boolean delayCloseEnable;
        
        /**
         * Chatroom start time (timestamp)
         */
        @JSONField(name = "start_time")
        private Long startTime;
        
        /**
         * Auto-close policy
         * 0: Don't auto-close
         * 1: Close after a fixed time (regardless of whether users are still in the chatroom)
         * 2: Close after the chatroom has been idle (no users) for a fixed time
         */
        @JSONField(name = "delay_close_policy")
        private Integer delayClosePolicy;
        
        /**
         * Status of the auto-close task
         * 1: Initial state (task started)
         * 2: Waiting state
         * 3: Task completed
         * 4: Task cancelled
         */
        @JSONField(name = "status")
        private Integer status;
        
        /**
         * Get the delay seconds
         * 
         * @return The delay seconds
         */
        public Long getDelaySeconds() {
            return delaySeconds;
        }
        
        /**
         * Set the delay seconds
         * 
         * @param delaySeconds The delay seconds
         */
        public void setDelaySeconds(Long delaySeconds) {
            this.delaySeconds = delaySeconds;
        }
        
        /**
         * Get whether auto-close is enabled
         * 
         * @return Whether auto-close is enabled
         */
        public Boolean getDelayCloseEnable() {
            return delayCloseEnable;
        }
        
        /**
         * Set whether auto-close is enabled
         * 
         * @param delayCloseEnable Whether auto-close is enabled
         */
        public void setDelayCloseEnable(Boolean delayCloseEnable) {
            this.delayCloseEnable = delayCloseEnable;
        }
        
        /**
         * Get the start time
         * 
         * @return The start time
         */
        public Long getStartTime() {
            return startTime;
        }
        
        /**
         * Set the start time
         * 
         * @param startTime The start time
         */
        public void setStartTime(Long startTime) {
            this.startTime = startTime;
        }
        
        /**
         * Get the auto-close policy
         * 
         * @return The auto-close policy
         */
        public Integer getDelayClosePolicy() {
            return delayClosePolicy;
        }
        
        /**
         * Set the auto-close policy
         * 
         * @param delayClosePolicy The auto-close policy
         */
        public void setDelayClosePolicy(Integer delayClosePolicy) {
            this.delayClosePolicy = delayClosePolicy;
        }
        
        /**
         * Get the status
         * 
         * @return The status
         */
        public Integer getStatus() {
            return status;
        }
        
        /**
         * Set the status
         * 
         * @param status The status
         */
        public void setStatus(Integer status) {
            this.status = status;
        }
    }
} 