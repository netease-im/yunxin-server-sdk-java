package com.netease.nim.im.server.sdk.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class UpdateChatroomDelayClosePolicyResponseV1 {
    @JSONField(name = "roomid")
    private Long roomId;

    private Boolean valid;

    private String announcement;

    private String name;

    @JSONField(name = "broadcasturl")
    private String liveUrl;

    @JSONField(name = "ext")
    private String extension;

    @JSONField(name = "queuelevel")
    private Integer queueLevel;

    private Boolean muted;

    private String creator;

    private ToggleCloseChatroomStatResponseV1.DelayInfo delayInfo;

    public class DelayInfo {
        private Boolean delayCloseEnable;

        private Integer delayClosePolicy;

        private Long delaySeconds;

        private Integer status;

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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getQueueLevel() {
        return queueLevel;
    }

    public void setQueueLevel(Integer queueLevel) {
        this.queueLevel = queueLevel;
    }

    public Boolean getMuted() {
        return muted;
    }

    public void setMuted(Boolean muted) {
        this.muted = muted;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public ToggleCloseChatroomStatResponseV1.DelayInfo getDelayInfo() {
        return delayInfo;
    }

    public void setDelayInfo(ToggleCloseChatroomStatResponseV1.DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }
}
