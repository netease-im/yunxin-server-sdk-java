package com.netease.nim.im.server.sdk.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMessageByIdsResponseV1 {

    /**
     * 历史消息的详细信息，JSON
     */
    private List<GetSuperTeamMessageResponse> msgs;

    public List<GetSuperTeamMessageResponse> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<GetSuperTeamMessageResponse> msgs) {
        this.msgs = msgs;
    }
}