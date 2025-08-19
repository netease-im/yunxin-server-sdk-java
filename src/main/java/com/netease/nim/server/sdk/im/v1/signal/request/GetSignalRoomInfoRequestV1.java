package com.netease.nim.server.sdk.im.v1.signal.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 查询信令频道信息请求
 * channelName 与 channelId 至少填一个，若两者都填，则优先取 channelId 的值
 */
public class GetSignalRoomInfoRequestV1 {

    @YunxinParam("channelName")
    private String channelName;

    @YunxinParam("channelId")
    private String channelId;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
} 