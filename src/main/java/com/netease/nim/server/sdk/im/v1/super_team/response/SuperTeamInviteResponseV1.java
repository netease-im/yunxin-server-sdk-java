package com.netease.nim.server.sdk.im.v1.super_team.response;

public class SuperTeamInviteResponseV1 {

    private SuperTeamFailAccountList failAccountInfo = new SuperTeamFailAccountList();

    public SuperTeamFailAccountList getFailAccountInfo() {
        return failAccountInfo;
    }

    public void setFailAccountInfo(SuperTeamFailAccountList failAccountInfo) {
        this.failAccountInfo = failAccountInfo;
    }
}
