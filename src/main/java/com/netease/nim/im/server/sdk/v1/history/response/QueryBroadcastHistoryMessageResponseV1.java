package com.netease.nim.im.server.sdk.v1.history.response;

import com.netease.nim.im.server.sdk.v1.history.model.Message;
import java.util.List;

public class QueryBroadcastHistoryMessageResponseV1 {

    /**
     * 消息集合
     */
    private List<Message> msgs;

    public List<Message> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Message> msgs) {
        this.msgs = msgs;
    }

}
