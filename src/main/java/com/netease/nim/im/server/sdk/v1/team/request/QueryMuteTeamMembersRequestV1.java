package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryMuteTeamMembersRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("owner")
    private String owner;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
