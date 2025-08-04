package com.netease.nim.server.sdk.im.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class UpdateChatroomInfoResponseV2 {
    
    
    @JSONField(name = "valid")
    private Boolean valid;
    
    
    @JSONField(name = "creator")
    private String creator;
    
    
    @JSONField(name = "room_name")
    private String roomName;
    
    
    @JSONField(name = "announcement")
    private String announcement;
    
    
    @JSONField(name = "live_url")
    private String liveUrl;
    
    
    @JSONField(name = "extension")
    private String extension;
    
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "queue_level")
    private Integer queueLevel;

    @JSONField(name = "delay_info")
    private DelayInfo delayInfo;
    
    public static class DelayInfo {

        @JSONField(name = "delay_close_enable")
        private Boolean delayCloseEnable;

        @JSONField(name = "delay_close_policy")
        private Integer delayClosePolicy;

        @JSONField(name = "delay_seconds")
        private Long delaySeconds;

        @JSONField(name = "status")
        private Integer status;

        @JSONField(name = "start_time")
        private Long startTime;

        public Boolean getDelayCloseEnable() {
            return delayCloseEnable;
        }

        public void setDelayCloseEnable(Boolean delayCloseEnable) {
            this.delayCloseEnable = delayCloseEnable;
        }

        public Integer getDelayClosePolicy() {
            return delayClosePolicy;
        }

        public void setDelayClosePolicy(Integer delayClosePolicy) {
            this.delayClosePolicy = delayClosePolicy;
        }

        public Long getDelaySeconds() {
            return delaySeconds;
        }

        public void setDelaySeconds(Long delaySeconds) {
            this.delaySeconds = delaySeconds;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Long getStartTime() {
            return startTime;
        }

        public void setStartTime(Long startTime) {
            this.startTime = startTime;
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