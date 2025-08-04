package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

public class SuperTeamKickMemberRequestV1 {

    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("owner")
    private String owner;

    private List<String> kickAccids;

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

    public List<String> getKickAccids() {
        return kickAccids;
    }

    public void setKickAccids(List<String> kickAccids) {
        this.kickAccids = kickAccids;
    }
}
