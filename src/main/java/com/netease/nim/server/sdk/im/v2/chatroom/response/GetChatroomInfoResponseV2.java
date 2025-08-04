package com.netease.nim.server.sdk.im.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class GetChatroomInfoResponseV2 {
    
    
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
    
    
    @JSONField(name = "in_out_notification")
    private Integer inOutNotification;
    
    
    @JSONField(name = "cdn_message_enable")
    private Boolean cdnMessageEnable;
    
    
    @JSONField(name = "online_user_count")
    private Long onlineUserCount;
    
    
    @JSONField(name = "ios_online_user_count")
    private Long iosOnlineUserCount;
    
    
    @JSONField(name = "android_online_user_count")
    private Long androidOnlineUserCount;
    
    
    @JSONField(name = "pc_online_user_count")
    private Long pcOnlineUserCount;
    
    
    @JSONField(name = "web_online_user_count")
    private Long webOnlineUserCount;
    
    
    @JSONField(name = "mac_online_user_count")
    private Long macOnlineUserCount;

    @JSONField(name = "harmony_online_user_count")
    private Long harmonyOnlineUserCount;

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

    public Integer getInOutNotification() {
        return inOutNotification;
    }

    public void setInOutNotification(Integer inOutNotification) {
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

    public Long getIosOnlineUserCount() {
        return iosOnlineUserCount;
    }

    public void setIosOnlineUserCount(Long iosOnlineUserCount) {
        this.iosOnlineUserCount = iosOnlineUserCount;
    }

    public Long getAndroidOnlineUserCount() {
        return androidOnlineUserCount;
    }

    public void setAndroidOnlineUserCount(Long androidOnlineUserCount) {
        this.androidOnlineUserCount = androidOnlineUserCount;
    }

    public Long getPcOnlineUserCount() {
        return pcOnlineUserCount;
    }

    public void setPcOnlineUserCount(Long pcOnlineUserCount) {
        this.pcOnlineUserCount = pcOnlineUserCount;
    }

    public Long getWebOnlineUserCount() {
        return webOnlineUserCount;
    }

    public void setWebOnlineUserCount(Long webOnlineUserCount) {
        this.webOnlineUserCount = webOnlineUserCount;
    }

    public Long getMacOnlineUserCount() {
        return macOnlineUserCount;
    }

    public void setMacOnlineUserCount(Long macOnlineUserCount) {
        this.macOnlineUserCount = macOnlineUserCount;
    }

    public Long getHarmonyOnlineUserCount() {
        return harmonyOnlineUserCount;
    }

    public void setHarmonyOnlineUserCount(Long harmonyOnlineUserCount) {
        this.harmonyOnlineUserCount = harmonyOnlineUserCount;
    }

    public DelayInfo getDelayInfo() {
        return delayInfo;
    }

    public void setDelayInfo(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }
} 