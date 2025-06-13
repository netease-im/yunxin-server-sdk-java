package com.netease.nim.server.sdk.rtc.room.response;

/**
 * Created by caojiajun on 2025/6/12
 */
public class RtcCreateRoomResponse {

    private int code;
    private long cid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }
}
