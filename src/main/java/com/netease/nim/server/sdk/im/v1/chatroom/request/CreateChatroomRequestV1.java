package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class CreateChatroomRequestV1 {
    @YunxinParam("creator")
    private String creator;

    @YunxinParam("name")
    private String name;

    @YunxinParam("announcement")
    private String announcement;

    @YunxinParam("broadcasturl")
    private String broadcasturl;

    @YunxinParam("ext")
    private String ext;

    @YunxinParam("bid")
    private String bid;

    @YunxinParam("delayClosePolicy")
    private Integer delayClosePolicy;

    @YunxinParam("delaySeconds")
    private Long delaySeconds;

    @YunxinParam("queuelevel")
    private Integer queueLevel;

    @YunxinParam("inOutNotification")
    private Integer inOutNotification;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getBroadcasturl() {
        return broadcasturl;
    }

    public void setBroadcasturl(String broadcasturl) {
        this.broadcasturl = broadcasturl;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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

    public Long getDelaySeconds() {
        return delaySeconds;
    }

    public void setDelaySeconds(Long delaySeconds) {
        this.delaySeconds = delaySeconds;
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
}
