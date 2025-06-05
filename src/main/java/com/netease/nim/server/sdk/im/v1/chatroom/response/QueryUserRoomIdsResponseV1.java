package com.netease.nim.server.sdk.im.v1.chatroom.response;

import java.util.List;

/**
 * Response for querying open chat rooms for a user
 */
public class QueryUserRoomIdsResponseV1 {
    
    /**
     * List of room ids that the user is in
     */
    private List<Long> roomIds;

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }
} 