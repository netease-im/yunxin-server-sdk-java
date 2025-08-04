package com.netease.nim.server.sdk.im.v1.super_team.request;


import java.util.List;

public class GetSuperTeamRequestV1 {

    private List<Long> tids;

    public List<Long> getTids() {
        return tids;
    }

    public void setTids(List<Long> tids) {
        this.tids = tids;
    }
}
