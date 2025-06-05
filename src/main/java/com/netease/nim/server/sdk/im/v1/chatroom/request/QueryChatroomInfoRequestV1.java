package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryChatroomInfoRequestV1 {
    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("needOnlineUserCount")
    private Boolean needOnlineUserCount;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Boolean getNeedOnlineUserCount() {
        return needOnlineUserCount;
    }

    public void setNeedOnlineUserCount(Boolean needOnlineUserCount) {
        this.needOnlineUserCount = needOnlineUserCount;
    }
}
