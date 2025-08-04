package com.netease.nim.server.sdk.im.v1.super_team.response;

public class SuperTeamInviteResponseV1 {

    private SuperTeamFailAccountList faccid = new SuperTeamFailAccountList();

    public SuperTeamFailAccountList getFaccid() {
        return faccid;
    }

    public void setFaccid(SuperTeamFailAccountList faccid) {
        this.faccid = faccid;
    }
}
