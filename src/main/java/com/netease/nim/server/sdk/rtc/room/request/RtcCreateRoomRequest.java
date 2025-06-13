package com.netease.nim.server.sdk.rtc.room.request;

/**
 * Created by caojiajun on 2025/6/12
 */
public class RtcCreateRoomRequest {
    private String channelName;
    private int mode;
    private long uid;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
