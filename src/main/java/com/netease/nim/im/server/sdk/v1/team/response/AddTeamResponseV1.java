package com.netease.nim.im.server.sdk.v1.team.response;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class AddTeamResponseV1 {
    private List<String> accids;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getAccids() {
        return accids;
    }

    public void setAccids(List<String> accids) {
        this.accids = accids;
    }
}
