package com.netease.nim.server.sdk.im.v1.history.response;

import com.netease.nim.server.sdk.im.v1.history.request.ChatroomMessage;
import java.util.List;

public class QueryChatroomHistoryMessageResponseV1 {

    /**
     * 总共消息条数
     */
    private Integer size;

    /**
     * 聊天室消息集合
     */
    private List<ChatroomMessage> msgs;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<ChatroomMessage> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<ChatroomMessage> msgs) {
        this.msgs = msgs;
    }

}
