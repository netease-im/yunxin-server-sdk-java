package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class SuperTeamFailAccountList {
    private List<String> accIdList;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getAccIdList() {
        return accIdList;
    }

    public void setAccIdList(List<String> accIdList) {
        this.accIdList = accIdList;
    }
}
