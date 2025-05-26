package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryTagHistoryMsgRequestV1 {
    @YunxinParam("roomId")
    private Long roomId;

    @YunxinParam("tags")
    private List<String> tags;

    @YunxinParam("types")
    private String types;

    @YunxinParam("fromTime")
    private Long fromTime;

    @YunxinParam("toTime")
    private Long toTime;

    @YunxinParam("limit")
    private Integer limit;

    @YunxinParam("reverse")
    private Integer reverse;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Long getFromTime() {
        return fromTime;
    }

    public void setFromTime(Long fromTime) {
        this.fromTime = fromTime;
    }

    public Long getToTime() {
        return toTime;
    }

    public void setToTime(Long toTime) {
        this.toTime = toTime;
    }

    public Integer getReverse() {
        return reverse;
    }

    public void setReverse(Integer reverse) {
        this.reverse = reverse;
    }
}
