package com.netease.nim.server.sdk.rtc.room.request;

/**
 * Created by caojiajun on 2025/6/12
 */
public class RtcCreateRoomRequest {
    private String channelName;
    private Integer mode;
    private Long uid;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
