package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryChatroomInfosRequestV1 {
    @YunxinParam("roomids")
    private List<Long> roomids;

    @YunxinParam("needOnlineUserCount")
    private Boolean needOnlineUserCount;

    public List<Long> getRoomids() {
        return roomids;
    }

    public void setRoomids(List<Long> roomids) {
        this.roomids = roomids;
    }

    public Boolean getNeedOnlineUserCount() {
        return needOnlineUserCount;
    }

    public void setNeedOnlineUserCount(Boolean needOnlineUserCount) {
        this.needOnlineUserCount = needOnlineUserCount;
    }
}
