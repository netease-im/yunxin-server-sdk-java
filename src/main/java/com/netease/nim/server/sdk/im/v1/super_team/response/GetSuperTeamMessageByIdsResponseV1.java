package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMessageByIdsResponseV1 {

    private List<GetSuperTeamMessage> msgs;

    public List<GetSuperTeamMessage> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<GetSuperTeamMessage> msgs) {
        this.msgs = msgs;
    }
}