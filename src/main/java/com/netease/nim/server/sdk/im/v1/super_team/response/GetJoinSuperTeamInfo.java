package com.netease.nim.server.sdk.im.v1.super_team.response;

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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getMaxusers() {
        return maxusers;
    }

    public void setMaxusers(Integer maxusers) {
        this.maxusers = maxusers;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}

