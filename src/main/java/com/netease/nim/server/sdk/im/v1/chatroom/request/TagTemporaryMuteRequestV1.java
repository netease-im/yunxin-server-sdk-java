package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class TagTemporaryMuteRequestV1 {
    @YunxinParam("roomid")
    private Long roomid;

    @YunxinParam("operator")
    private String operator;

    @YunxinParam("targetTag")
    private String targetTag;

    @YunxinParam("needNotify")
    private Boolean needNotify;

    @YunxinParam("notifyExt")
    private String notifyExt;

    @YunxinParam("muteDuration")
    private Integer muteDuration;

    @YunxinParam("notifyTargetTags")
    private String notifyTargetTags;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTargetTag() {
        return targetTag;
    }

    public void setTargetTag(String targetTag) {
        this.targetTag = targetTag;
    }

    public Boolean getNeedNotify() {
        return needNotify;
    }

    public void setNeedNotify(Boolean needNotify) {
        this.needNotify = needNotify;
    }

    public String getNotifyExt() {
        return notifyExt;
    }

    public void setNotifyExt(String notifyExt) {
        this.notifyExt = notifyExt;
    }

    public Integer getMuteDuration() {
        return muteDuration;
    }

    public void setMuteDuration(Integer muteDuration) {
        this.muteDuration = muteDuration;
    }

    public String getNotifyTargetTags() {
        return notifyTargetTags;
    }

    public void setNotifyTargetTags(String notifyTargetTags) {
        this.notifyTargetTags = notifyTargetTags;
    }
}
