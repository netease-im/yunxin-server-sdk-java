package com.netease.nim.server.sdk.im.v1.super_team.response;

public class CreateSuperTeamResponseV1 {

    private Long tid;

    /**
     * 由于加群数量超限导致无法正常加入超大群的用户列表，包含用户的账号和附言（msg）
     **/
    private SuperTeamFailAccountList failAccountInfo = new SuperTeamFailAccountList();

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public SuperTeamFailAccountList getFailAccountInfo() {
        return failAccountInfo;
    }

    public void setFailAccountInfo(SuperTeamFailAccountList failAccountInfo) {
        this.failAccountInfo = failAccountInfo;
    }
}

