package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class DeleteBroadcastMessageByIdRequestV1 {

    /**
     * 广播消息 ID
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
