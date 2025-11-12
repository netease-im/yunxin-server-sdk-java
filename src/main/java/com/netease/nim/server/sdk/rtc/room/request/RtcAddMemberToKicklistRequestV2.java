package com.netease.nim.server.sdk.rtc.room.request;
/**
 * Created by DevDengChao on 2025/11/12
 *
 * See https://doc.yunxin.163.com/nertc/server-apis/TA5MTExNjg?platform=server
 */
public class RtcAddMemberToKicklistRequestV2 {
    private Long cid;
    private Number uid;
    private Number duration;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Number getUid() {
        return uid;
    }

    public void setUid(Number uid) {
        this.uid = uid;
    }

    public Number getDuration() {
        return duration;
    }

    public void setDuration(Number duration) {
        this.duration = duration;
    }
}
