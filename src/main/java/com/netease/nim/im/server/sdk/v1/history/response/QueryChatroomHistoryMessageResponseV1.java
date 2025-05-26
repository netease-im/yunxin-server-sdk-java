package com.netease.nim.im.server.sdk.v1.history.response;

public class QueryChatroomHistoryMessageResponseV1 {

    /**
     * 总共消息条数
     */
    private Integer size;

    /**
     * 消息集合，JSONArray
     */
    private String msgs;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMsgs() {
        return msgs;
    }

    public void setMsgs(String msgs) {
        this.msgs = msgs;
    }

}
