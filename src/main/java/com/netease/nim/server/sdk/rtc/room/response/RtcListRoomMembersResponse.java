package com.netease.nim.server.sdk.rtc.room.response;

import java.util.List;

public class RtcListRoomMembersResponse {
    private String cname;
    private Long cid;
    private Integer total;
    private List<RtcRoomMember> members;
    private int code;
    private String requestId ;
    private String errmsg;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<RtcRoomMember> getMembers() {
        return members;
    }

    public void setMembers(List<RtcRoomMember> members) {
        this.members = members;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
