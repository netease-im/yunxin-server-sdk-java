package com.netease.nim.im.server.sdk.v1.chatroom.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class CleanRobotRequestV1 {
    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("notify")
    private Boolean notify;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Boolean getNotify() {
        return notify;
    }

    public void setNotify(Boolean notify) {
        this.notify = notify;
    }
}
