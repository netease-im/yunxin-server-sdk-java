package com.netease.nim.server.sdk.im.v1.team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryOnlineTeamMemberRequestV1 {
    @YunxinParam("tid")
    private Long tid;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
}
