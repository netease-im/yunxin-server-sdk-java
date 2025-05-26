package com.netease.nim.im.server.sdk.v1.chatroom.reponse;


import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class CreateChatroomResponseV1 {
    @JSONField(name = "roomid")
    private long roomId;
    private boolean valid;
    private String announcement;
    @JSONField(name = "ext")
    private String extension;
    private String creator;
    @JSONField(name = "name")
    private String roomName;
    @JSONField(name = "broadcasturl")
    private String liveUrl;
    @JSONField(name = "queuelevel")
    private Integer queueLevel;
    @JSONField(name = "muted")
    private boolean muted;
    private DelayInfo delayInfo;


    public static class DelayInfo {
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

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public Integer getQueueLevel() {
        return queueLevel;
    }

    public void setQueueLevel(Integer queueLevel) {
        this.queueLevel = queueLevel;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public DelayInfo getDelayInfo() {
        return delayInfo;
    }

    public void setDelayInfo(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }
}
