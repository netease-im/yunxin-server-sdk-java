package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;
import java.util.List;

/**
 * Request for retrieving specified queue elements from a chatroom
 */
public class QueueGetRequestV1 {

    @YunxinParam("roomid")
    private Long roomid;

    @YunxinParam("keys")
    private List<String> keys;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
} 