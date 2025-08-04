package com.netease.nim.server.sdk.im.v1.history.response;

import com.netease.nim.server.sdk.im.v1.history.request.Message;

import java.util.List;

/**
 * 查询单聊云端历史消息响应
 * 
 * 单聊消息格式与群聊消息格式相同：
 * - msgid 为 Long 类型
 * - 包含 msgidclient 字段
 */
public class QuerySessionHistoryMessageResponseV1 {

    /**
     * 总共消息条数
     */
    private Integer size;

    /**
     * 单聊消息集合
     * 单聊消息与群聊消息格式相同，都使用Message类型
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
