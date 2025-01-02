package com.netease.nim.im.server.sdk.v1.team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class BatchQueryOnlineTeamMemberCountRequestV1 {
    @YunxinParam("tids")
    private List<Long> tids;

    public List<Long> getTids() {
        return tids;
    }

    public void setTids(List<Long> tids) {
        this.tids = tids;
    }
}
