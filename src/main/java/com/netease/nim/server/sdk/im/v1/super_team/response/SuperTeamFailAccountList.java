package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class SuperTeamFailAccountList {
    private List<String> accidList;
    private String msg;

    public List<String> getAccidList() {
        return accidList;
    }

    public void setAccidList(List<String> accidList) {
        this.accidList = accidList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
