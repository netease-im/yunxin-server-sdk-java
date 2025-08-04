package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Request for listing all elements in a chatroom queue in sorted order
 */
public class QueueListRequestV1 {

    @YunxinParam("roomid")
    private Long roomid;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }
}