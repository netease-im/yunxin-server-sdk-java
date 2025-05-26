package com.netease.nim.im.server.sdk.v1.super_team.response;

import java.util.List;

public class GetSuperTeamResponseV1 {
    private List<SuperTeamInfo> tinfos;

    public List<SuperTeamInfo> getTinfos() {
        return tinfos;
    }

    public void setTinfos(List<SuperTeamInfo> tinfos) {
        this.tinfos = tinfos;
    }
}
