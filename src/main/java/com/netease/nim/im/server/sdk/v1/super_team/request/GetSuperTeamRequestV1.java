package com.netease.nim.im.server.sdk.v1.super_team.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class GetSuperTeamRequestV1 {

    /**
     * 超大群 ID 列表（tids），如["3083","3084"]，一次最多查询 20 个超大群，最大长度 1024 位字符
     */
    @YunxinParam("tids")
    private String tids;

    public String getTids() {
        return tids;
    }

    public void setTids(String tids) {
        this.tids = tids;
    }
}
