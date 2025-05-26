package com.netease.nim.im.server.sdk.v1.chatroom.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Request for initializing a chatroom queue
 */
public class QueueInitRequestV1 {

    /**
     * Chatroom ID
     */
    @YunxinParam("roomid")
    private Long roomId;

    /**
     * Queue size limit, default is 50 if not specified
     */
    @YunxinParam("sizeLimit")
    private Integer sizeLimit;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(Integer sizeLimit) {
        this.sizeLimit = sizeLimit;
    }
} 