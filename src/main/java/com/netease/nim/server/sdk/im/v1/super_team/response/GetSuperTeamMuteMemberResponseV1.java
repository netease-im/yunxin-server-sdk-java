package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMuteMemberResponseV1 {

    private List<SuperTeamMuteMemberInfo> tlists;

    public List<SuperTeamMuteMemberInfo> getTlists() {
        return tlists;
    }

    public void setTlists(List<SuperTeamMuteMemberInfo> tlists) {
        this.tlists = tlists;
    }
}