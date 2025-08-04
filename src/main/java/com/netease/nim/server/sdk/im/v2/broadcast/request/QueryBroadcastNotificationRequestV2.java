package com.netease.nim.server.sdk.im.v2.broadcast.request;


public class QueryBroadcastNotificationRequestV2 {
    private String broadcastId;

    public QueryBroadcastNotificationRequestV2() {
    }

    public QueryBroadcastNotificationRequestV2(String broadcastId) {
        this.broadcastId = broadcastId;
    }

    public String getBroadcastId() {
        return broadcastId;
    }
    public void setBroadcastId(String broadcastId) {
        this.broadcastId = broadcastId;
    }
} 