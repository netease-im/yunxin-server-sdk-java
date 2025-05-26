package com.netease.nim.im.server.sdk.v1.super_team.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SuperTeamRemoveManagerRequestV1 {
    /**
     * 云信服务器产生，超大群唯一标识，最大长度 64 位长整型
     */
    @YunxinParam("tid")
    private Long tid;

    /**
     * 群主用户帐号，最大长度 32 位字符
     */
    @YunxinParam("owner")
    private String owner;

    /**
     * 需要移除的管理员用户账号，最大长度 1024 位字符，一次最多移除 10 人
     */
    @YunxinParam("managerAccids")
    private String managerAccids;

    // Getters and Setters
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

    public String getManagerAccids() {
        return managerAccids;
    }

    public void setManagerAccids(String managerAccids) {
        this.managerAccids = managerAccids;
    }
}
