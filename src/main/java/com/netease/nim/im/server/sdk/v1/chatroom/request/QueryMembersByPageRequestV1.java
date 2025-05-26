package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryMembersByPageRequestV1 {

    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("type")
    private Integer type;

    @YunxinParam("endtime")
    private Long endTime;

    @YunxinParam("limit")
    private Long limit;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}
