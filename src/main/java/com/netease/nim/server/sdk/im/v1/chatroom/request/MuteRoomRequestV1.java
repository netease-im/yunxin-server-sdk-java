package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class MuteRoomRequestV1 {

    @YunxinParam("roomid")
    private long roomId;

    @YunxinParam("operator")
    private String operator;

    @YunxinParam("mute")
    private Boolean mute;

    @YunxinParam("needNotify")
    private Boolean needNotify;

    @YunxinParam("notifyExt")
    private String notifyExt;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getMute() {
        return mute;
    }

    public void setMute(Boolean mute) {
        this.mute = mute;
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
}
