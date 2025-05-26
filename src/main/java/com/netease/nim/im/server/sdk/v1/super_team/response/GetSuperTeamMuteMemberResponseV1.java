package com.netease.nim.im.server.sdk.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMuteMemberResponseV1 {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 被禁言的群成员列表
     */
    private List<SuperTeamMuteMemberInfo> tlists;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<SuperTeamMuteMemberInfo> getTlists() {
        return tlists;
    }

    public void setTlists(List<SuperTeamMuteMemberInfo> tlists) {
        this.tlists = tlists;
    }
}