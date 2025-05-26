package com.netease.nim.im.server.sdk.v1.message.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class DeleteRoamSessionRequestV1 {

    /**
     * 会话类型，1-单聊，2-高级群，3-超大群
     */
    @YunxinParam("type")
    private Integer type;

    /**
     * 发送者的云信 IM 账号（accid），最大长度 32 个字符
     */
    @YunxinParam("from")
    private String from;

    /**
     * 消息接收方。如果 type=1 则需传入消息接收者的云信 IM 账号（accid）。如果 type=2 则需传入高级群 ID （tid）。如果 type=3 则需传入超大群 ID （tid）。
     */
    @YunxinParam("to")
    private String to;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

}
