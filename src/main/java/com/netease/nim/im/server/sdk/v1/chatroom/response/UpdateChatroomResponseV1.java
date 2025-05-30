package com.netease.nim.im.server.sdk.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by hekaijie on 2024/12/24
 */
public class UpdateChatroomResponseV1 {
    @JSONField(name = "roomid")
    private Long roomId;
    private Boolean valid;
    private String announcement;
    @JSONField(name = "ext")
    private String extension;
    private String creator;
    @JSONField(name = "name")
    private String roomName;
    @JSONField(name = "broadcasturl")
    private String liveUrl;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
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
}
