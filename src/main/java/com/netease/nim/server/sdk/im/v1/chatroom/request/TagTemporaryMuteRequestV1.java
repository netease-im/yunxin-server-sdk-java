package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class TagTemporaryMuteRequestV1 {
    @YunxinParam("roomid")
    private Long roomId;

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
    private Integer notifyTargetTags;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public Integer getNotifyTargetTags() {
        return notifyTargetTags;
    }

    public void setNotifyTargetTags(Integer notifyTargetTags) {
        this.notifyTargetTags = notifyTargetTags;
    }
}
