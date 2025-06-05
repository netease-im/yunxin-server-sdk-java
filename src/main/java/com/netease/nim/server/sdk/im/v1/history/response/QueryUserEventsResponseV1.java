package com.netease.nim.server.sdk.im.v1.history.response;

public class QueryUserEventsResponseV1 {

    /**
     * 总共记录数
     */
    private Integer size;

    /**
     * 记录集合，JSONArray
     */
    private String events;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

}
