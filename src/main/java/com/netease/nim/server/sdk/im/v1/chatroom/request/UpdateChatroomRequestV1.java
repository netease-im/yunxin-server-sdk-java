package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class UpdateChatroomRequestV1 {
    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("name")
    private String roomName;

    @YunxinParam("announcement")
    private String announcement;

    @YunxinParam("broadcasturl")
    private String liveUrl;

    @YunxinParam("ext")
    private String extension;

    @YunxinParam("needNotify")
    private Boolean needNotify;

    @YunxinParam("notifyExt")
    private String notifyExtension;

    @YunxinParam("queuelevel")
    private Integer queueLevel;

    @YunxinParam("bid")
    private String bid;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public Boolean getNeedNotify() {
        return needNotify;
    }

    public void setNeedNotify(Boolean needNotify) {
        this.needNotify = needNotify;
    }

    public String getNotifyExtension() {
        return notifyExtension;
    }

    public void setNotifyExtension(String notifyExtension) {
        this.notifyExtension = notifyExtension;
    }

    public Integer getQueueLevel() {
        return queueLevel;
    }

    public void setQueueLevel(Integer queueLevel) {
        this.queueLevel = queueLevel;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
