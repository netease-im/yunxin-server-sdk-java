package com.netease.nim.im.server.sdk.v1.chatroom.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;
import java.util.List;

/**
 * Request for retrieving specified queue elements from a chatroom
 */
public class QueueGetRequestV1 {

    /**
     * Chatroom ID
     */
    @YunxinParam("roomid")
    private Long roomId;
    
    /**
     * List of queue element keys to retrieve, maximum 100
     * Example: ["key1", "key2", "key3"]
     */
    @YunxinParam("keys")
    private List<String> keys;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
} 