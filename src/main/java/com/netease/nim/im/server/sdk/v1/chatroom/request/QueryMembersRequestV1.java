package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryMembersRequestV1 {

    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("accids")
    private List<String> accids;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public List<String> getAccids() {
        return accids;
    }

    public void setAccids(List<String> accids) {
        this.accids = accids;
    }
}
