package com.netease.nim.server.sdk.rtc.room.request;
/**
 * Created by DevDengChao on 2025/11/07
 *
 * See https://doc.yunxin.163.com/nertc/server-apis/jUzODcwODE?platform=server
 */
public class RtcListRoomMembersRequestV2 {
    private Long cid;
    private Number uid;
    private Number userRole;

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

    public Number getUserRole() {
        return userRole;
    }

    public void setUserRole(Number userRole) {
        this.userRole = userRole;
    }
}
