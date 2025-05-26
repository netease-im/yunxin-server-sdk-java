package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class CreateChatroomRequestV1 {
    @YunxinParam("creator")
    private String creator;

    @YunxinParam("name")
    private String roomName;

    @YunxinParam("announcement")
    private String announcement;

    @YunxinParam("broadcasturl")
    private String liveUrl;

    @YunxinParam("ext")
    private String extension;

    @YunxinParam("bid")
    private String bid;

    @YunxinParam("delayClosePolicy")
    private Integer delayClosePolicy;

    @YunxinParam("delaySeconds")
    private String delaySeconds;

    @YunxinParam("queuelevel")
    private Integer queueLevel;

    @YunxinParam("inOutNotification")
    private Boolean inOutNotification;

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

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Integer getDelayClosePolicy() {
        return delayClosePolicy;
    }

    public void setDelayClosePolicy(Integer delayClosePolicy) {
        this.delayClosePolicy = delayClosePolicy;
    }

    public String getDelaySeconds() {
        return delaySeconds;
    }

    public void setDelaySeconds(String delaySeconds) {
        this.delaySeconds = delaySeconds;
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
}
