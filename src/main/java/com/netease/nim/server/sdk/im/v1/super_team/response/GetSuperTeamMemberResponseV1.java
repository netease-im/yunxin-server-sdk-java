package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMemberResponseV1 {

    private List<SuperTeamMemberInfo> tlists;

    public List<SuperTeamMemberInfo> getTlists() {
        return tlists;
    }

    public void setTlists(List<SuperTeamMemberInfo> tlists) {
        this.tlists = tlists;
    }
}