package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMessageResponseV1 {

    private Integer size;

    private Long tid;

    private List<GetSuperTeamMessage> msgs;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public List<GetSuperTeamMessage> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<GetSuperTeamMessage> msgs) {
        this.msgs = msgs;
    }

}