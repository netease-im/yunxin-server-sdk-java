package com.netease.nim.server.sdk.im.v1.super_team.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

public class SuperTeamRemoveManagerRequestV1 {

    @YunxinParam("tid")
    private Long tid;

    @YunxinParam("owner")
    private String owner;

    @YunxinParam("managerAccids")
    private List<String> managerAccids;

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

    public List<String> getManagerAccids() {
        return managerAccids;
    }

    public void setManagerAccids(List<String> managerAccids) {
        this.managerAccids = managerAccids;
    }
}
