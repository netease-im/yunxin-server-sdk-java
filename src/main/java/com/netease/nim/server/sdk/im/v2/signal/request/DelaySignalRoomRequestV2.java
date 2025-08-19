package com.netease.nim.server.sdk.im.v2.signal.request;

/**
 * 延长信令房间有效期请求 V2
 * 用于延长一个信令房间有效期
 */
public class DelaySignalRoomRequestV2 {

    private String channelId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
} 