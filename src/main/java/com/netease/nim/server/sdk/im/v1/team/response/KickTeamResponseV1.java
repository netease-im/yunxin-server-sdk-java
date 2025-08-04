package com.netease.nim.server.sdk.im.v1.team.response;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class KickTeamResponseV1 {
    private List<String> accid;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getAccid() {
        return accid;
    }

    public void setAccid(List<String> accid) {
        this.accid = accid;
    }
}
