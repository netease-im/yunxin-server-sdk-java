package com.netease.nim.im.server.sdk.v1.super_team.response;

public class GetSuperTeamMessageResponse {
    /**
     * 服务端消息 ID
     */
    private Long msgid;

    /**
     * 消息发送时间
     */
    private Long sendtime;

    /**
     * 消息发送方账号，accid
     */
    private String from;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 第三方扩展字段
     */
    private String ext;

    /**
     * 消息体，根据消息类型的不同而不同
     */
    private Object body;

    // Getters and Setters
    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public Long getSendtime() {
        return sendtime;
    }

    public void setSendtime(Long sendtime) {
        this.sendtime = sendtime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
