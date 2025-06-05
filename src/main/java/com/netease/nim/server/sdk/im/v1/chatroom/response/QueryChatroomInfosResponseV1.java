package com.netease.nim.server.sdk.im.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Created by hekaijie on 2024/12/24
 */
public class QueryChatroomInfosResponseV1 {

    List<Long> noExistRooms;

    @JSONField(name = "succRooms")
    List<RoomInfo> roomInfos;

    List<Long> failRooms;

    public List<Long> getNoExistRooms() {
        return noExistRooms;
    }

    public void setNoExistRooms(List<Long> noExistRooms) {
        this.noExistRooms = noExistRooms;
    }

    public List<RoomInfo> getRoomInfos() {
        return roomInfos;
    }

    public void setRoomInfos(List<RoomInfo> roomInfos) {
        this.roomInfos = roomInfos;
    }

    public List<Long> getFailRooms() {
        return failRooms;
    }

    public void setFailRooms(List<Long> failRooms) {
        this.failRooms = failRooms;
    }

    public class RoomInfo {
        @JSONField(name = "roomid")
        private Long roomId;

        private Boolean valid;

        private Boolean muted;

        private String announcement;

        private String name;

        @JSONField(name = "broadcasturl")
        private String liveUrl;

        @JSONField(name = "onlineusercount")
        private Integer onlineUserCount;

        @JSONField(name = "ext")
        private String extension;

        private String creator;

        @JSONField(name = "queuelevel")
        private Integer queueLevel;

        @JSONField(name = "ionotify")
        private Boolean ioNotify;

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

        public Boolean getMuted() {
            return muted;
        }

        public void setMuted(Boolean muted) {
            this.muted = muted;
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

        public Integer getOnlineUserCount() {
            return onlineUserCount;
        }

        public void setOnlineUserCount(Integer onlineUserCount) {
            this.onlineUserCount = onlineUserCount;
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

        public Integer getQueueLevel() {
            return queueLevel;
        }

        public void setQueueLevel(Integer queueLevel) {
            this.queueLevel = queueLevel;
        }

        public Boolean getIoNotify() {
            return ioNotify;
        }

        public void setIoNotify(Boolean ioNotify) {
            this.ioNotify = ioNotify;
        }
    }
}
