package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class KickMemberRequestV1 {

    @YunxinParam("roomid")
    private Long roomid;

    @YunxinParam("targetAccid")
    private String targetAccid;

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("notifyExt")
    private String notifyExt;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public String getTargetAccid() {
        return targetAccid;
    }

    public void setTargetAccid(String targetAccid) {
        this.targetAccid = targetAccid;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getNotifyExt() {
        return notifyExt;
    }

    public void setNotifyExt(String notifyExt) {
        this.notifyExt = notifyExt;
    }
}
