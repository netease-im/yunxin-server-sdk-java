package com.netease.nim.im.server.sdk.v1.chatroom.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Request for listing all elements in a chatroom queue in sorted order
 */
public class QueueListRequestV1 {

    /**
     * Chatroom ID
     */
    @YunxinParam("roomid")
    private Long roomId;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
} 