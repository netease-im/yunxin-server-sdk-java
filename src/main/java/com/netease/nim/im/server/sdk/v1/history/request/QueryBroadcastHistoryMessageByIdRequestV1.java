package com.netease.nim.im.server.sdk.v1.history.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class QueryBroadcastHistoryMessageByIdRequestV1 {

    /**
     * 广播消息ID
     */
    @YunxinParam("broadcastId")
    private Long broadcastId;

    public Long getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

}
