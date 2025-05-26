package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class KickMemberRequestV1 {

    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("targetAccid")
    private String targetAccid;

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("notifyExt")
    private String notifyExt;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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
