package com.netease.nim.im.server.sdk.v1.super_team.response;

public class GetJoinSuperTeamInfo {

    /**
     * 群主账号，accid
     */
    private String owner;

    /**
     * 超大群名称
     */
    private String tname;

    /**
     * 超大群人数上限
     */
    private Integer maxusers;

    /**
     * 超大群 ID
     */
    private Long tid;

    /**
     * 当前超大群有效成员数量
     */
    private Integer size;

    /**
     * 自定义信息
     */
    private String custom;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

