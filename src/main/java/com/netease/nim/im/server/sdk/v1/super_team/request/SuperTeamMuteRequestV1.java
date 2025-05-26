package com.netease.nim.im.server.sdk.v1.super_team.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SuperTeamMuteRequestV1 {
    /**
     * 云信服务器产生，超大群唯一标识，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 群主帐号，最大长度 32 位字符
     */
    @YunxinParam("owner")
    private String owner;

    /**
     * 禁言类型，0表示解除禁言，1表示禁言普通成员，3表示禁言整个超大群（包括群主）
     */
    @YunxinParam("muteType")
    private Integer muteType;

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

    public Integer getMuteType() {
        return muteType;
    }

    public void setMuteType(Integer muteType) {
        this.muteType = muteType;
    }
}
