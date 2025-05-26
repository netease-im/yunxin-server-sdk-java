package com.netease.nim.im.server.sdk.v1.super_team.response;

public class SuperTeamInviteResponseV1 {

    private SuperTeamFailAccountList failAccountInfo = new SuperTeamFailAccountList();

    public SuperTeamFailAccountList getFailAccountInfo() {
        return failAccountInfo;
    }

    public void setFailAccountInfo(SuperTeamFailAccountList failAccountInfo) {
        this.failAccountInfo = failAccountInfo;
    }
}
