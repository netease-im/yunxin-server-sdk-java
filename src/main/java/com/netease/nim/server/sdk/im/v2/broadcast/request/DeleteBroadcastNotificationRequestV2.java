package com.netease.nim.server.sdk.im.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class DeleteBroadcastNotificationRequestV2 {

    private String broadcastId;

    public DeleteBroadcastNotificationRequestV2() {
    }

    public DeleteBroadcastNotificationRequestV2(String broadcastId) {
        this.broadcastId = broadcastId;
    }

    public String getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(String broadcastId) {
        this.broadcastId = broadcastId;
    }
} 