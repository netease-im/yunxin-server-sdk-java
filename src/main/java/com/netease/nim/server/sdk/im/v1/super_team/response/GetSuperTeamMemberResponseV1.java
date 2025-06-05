package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMemberResponseV1 {
    /**
     * 群成员信息列表
     */
    private List<SuperTeamMemberInfo> teamMemberInfoList;

    public List<SuperTeamMemberInfo> getTeamMemberInfoList() {
        return teamMemberInfoList;
    }

    public void setTeamMemberInfoList(List<SuperTeamMemberInfo> teamMemberInfoList) {
        this.teamMemberInfoList = teamMemberInfoList;
    }
}