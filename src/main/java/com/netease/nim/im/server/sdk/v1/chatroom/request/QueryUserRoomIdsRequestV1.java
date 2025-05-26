package com.netease.nim.im.server.sdk.v1.chatroom.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Request for querying open chat rooms for a user
 */
public class QueryUserRoomIdsRequestV1 {

    /**
     * User account ID
     */
    @YunxinParam("creator")
    private String creator;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
} 