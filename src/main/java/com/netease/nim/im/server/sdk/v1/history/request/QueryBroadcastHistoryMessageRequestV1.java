package com.netease.nim.im.server.sdk.v1.history.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class QueryBroadcastHistoryMessageRequestV1 {

    /**
     * 查询的起始ID，0表示查询最近的limit条。默认0
     */
    @YunxinParam("broadcastId")
    private Long broadcastId;

    /**
     * 查询的条数，最大100。默认100
     */
    @YunxinParam("limit")
    private Integer limit;

    /**
     * 查询的类型，1表示所有，2表示查询存离线的，3表示查询不存离线的。默认1
     */
    @YunxinParam("type")
    private Long type;

    public Long getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

}
