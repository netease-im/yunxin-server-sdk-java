package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class GetJoinSuperTeamResponseV1 {

    private List<GetJoinSuperTeamInfo> tinfos;

    public List<GetJoinSuperTeamInfo> getTinfos() {
        return tinfos;
    }

    public void setTinfos(List<GetJoinSuperTeamInfo> tinfos) {
        this.tinfos = tinfos;
    }
}

