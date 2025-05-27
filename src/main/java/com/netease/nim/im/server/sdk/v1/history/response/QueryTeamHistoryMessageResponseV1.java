package com.netease.nim.im.server.sdk.v1.history.response;

import com.netease.nim.im.server.sdk.v1.history.model.Message;
import java.util.List;

public class QueryTeamHistoryMessageResponseV1 {

    /**
     * 总共消息条数
     */
    private Integer size;

    /**
     * 消息集合
     */
    private List<Message> msgs;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Message> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Message> msgs) {
        this.msgs = msgs;
    }

}
