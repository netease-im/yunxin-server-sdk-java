package com.netease.nim.server.sdk.im.v1.super_team.response;

public class CreateSuperTeamResponseV1 {

    private Long tid;

    private SuperTeamFailAccountList faccid = new SuperTeamFailAccountList();

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public SuperTeamFailAccountList getFaccid() {
        return faccid;
    }

    public void setFaccid(SuperTeamFailAccountList faccid) {
        this.faccid = faccid;
    }
}

