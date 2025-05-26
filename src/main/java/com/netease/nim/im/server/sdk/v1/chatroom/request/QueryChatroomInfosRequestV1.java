package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryChatroomInfosRequestV1 {
    @YunxinParam("roomids")
    private List<Long> roomIds;

    @YunxinParam("needOnlineUserCount")
    private Boolean needOnlineUserCount;

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }

    public Boolean getNeedOnlineUserCount() {
        return needOnlineUserCount;
    }

    public void setNeedOnlineUserCount(Boolean needOnlineUserCount) {
        this.needOnlineUserCount = needOnlineUserCount;
    }
}
