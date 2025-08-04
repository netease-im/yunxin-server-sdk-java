package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class SuperTeamUpdateMemberInfoRequestV1 {

    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("nick")
    private String nick;

    @YunxinParam("silentType")
    private Integer silentType;

    @YunxinParam("custom")
    private String custom;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getSilentType() {
        return silentType;
    }

    public void setSilentType(Integer silentType) {
        this.silentType = silentType;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}
