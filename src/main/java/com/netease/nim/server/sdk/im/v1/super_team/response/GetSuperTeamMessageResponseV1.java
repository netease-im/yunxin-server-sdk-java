package com.netease.nim.server.sdk.im.v1.super_team.response;

import java.util.List;

public class GetSuperTeamMessageResponseV1 {

    /**
     * 历史消息数量
     */
    private Integer size;

    /**
     * 超大群 ID
     */
    private Long tid;

    /**
     * 历史消息的详细信息，JSON
     */
    private List<GetSuperTeamMessageResponse> msgs;


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

    public List<GetSuperTeamMessageResponse> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<GetSuperTeamMessageResponse> msgs) {
        this.msgs = msgs;
    }

}