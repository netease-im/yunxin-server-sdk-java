package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryTeamRequestV1 {
    @YunxinParam("tids")
    private List<Long> tids;

    @YunxinParam("ope")
    private Integer ope;

    public List<Long> getTids() {
        return tids;
    }

    public void setTids(List<Long> tids) {
        this.tids = tids;
    }

    public Integer getOpe() {
        return ope;
    }

    public void setOpe(Integer ope) {
        this.ope = ope;
    }
}
