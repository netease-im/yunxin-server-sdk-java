package com.netease.nim.im.server.sdk.v1.message.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class MarkReadMessageRequestV1 {

    /**
     * 已读回执的发送方（即消息接收方）IM 账号（accid）
     */
    @YunxinParam("from")
    private String from;

    /**
     * 已读回执的接收方（即消息发送方）的 IM 账号（accid）
     */
    @YunxinParam("to")
    private String to;

    /**
     * 需要标记为已读的消息的客户端消息 ID（clientId）
     */
    @YunxinParam("msgidClient")
    private String msgidClient;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsgidClient() {
        return msgidClient;
    }

    public void setMsgidClient(String msgidClient) {
        this.msgidClient = msgidClient;
    }

}
