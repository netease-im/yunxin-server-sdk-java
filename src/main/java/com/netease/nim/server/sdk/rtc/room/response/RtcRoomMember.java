package com.netease.nim.server.sdk.rtc.room.response;

/**
 *
 * See https://doc.yunxin.163.com/interactive-streaming/outdated_articles/zY5OTk5NTM?platform=client
 */
public class RtcRoomMember {
    private Long uid;
    private Long starttime;
    private Integer userRole;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}
