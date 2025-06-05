package com.netease.nim.server.sdk.im.v1.super_team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class RecallAttachSuperMessageRequestV1 {

    /**
     * 要撤回消息的消息 ID，msgid，最大长度 64 位长整型
     */
    @YunxinParam("deleteMsgid")
    private Long deleteMsgid;

    /**
     * 需要撤回的消息的创建时间（创建时间为云信服务端生成的消息发送时间戳），毫秒时间戳
     */
    @YunxinParam("timetag")
    private Long timetag;

    /**
     * 消息发送方的用户账号，accid，最大长度 32 位字符
     */
    @YunxinParam("from")
    private String from;

    /**
     * 超大群 ID，tid，最大长度 64 位长整型
     */
    @YunxinParam("to")
    private Long to;

    /**
     * 1，表示忽略撤回时间检测；0，不忽略，默认为 0
     */
    @YunxinParam("ignoreTime")
    private Integer ignoreTime;

    /**
     * 推送文案，最大长度 500 位字符
     */
    @YunxinParam("pushContent")
    private String pushContent;

    /**
     * 推送对应的 payload，必须是 JSON 格式，不能超过 2048 字符
     */
    @YunxinParam("pushPayload")
    private String pushPayload;

    public Long getDeleteMsgid() {
        return deleteMsgid;
    }

    public void setDeleteMsgid(Long deleteMsgid) {
        this.deleteMsgid = deleteMsgid;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Integer getIgnoreTime() {
        return ignoreTime;
    }

    public void setIgnoreTime(Integer ignoreTime) {
        this.ignoreTime = ignoreTime;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getPushPayload() {
        return pushPayload;
    }

    public void setPushPayload(String pushPayload) {
        this.pushPayload = pushPayload;
    }
}