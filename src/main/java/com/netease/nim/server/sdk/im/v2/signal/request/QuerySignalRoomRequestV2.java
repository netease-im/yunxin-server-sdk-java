package com.netease.nim.server.sdk.im.v2.signal.request;

/**
 * 查询信令房间请求 V2
 * 可以根据房间名称查询，也可以根据房间id查询
 * 信令房间id和信令房间名称，二选一，优先信令房间id
 */
public class QuerySignalRoomRequestV2 {

    /**
     * 信令房间id (可选，与channel_name二选一，优先使用此参数)
     */
    private String channelId;

    /**
     * 信令房间名称 (可选，与channel_id二选一)
     */
    private String channelName;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
} 