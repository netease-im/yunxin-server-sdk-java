package com.netease.nim.im.server.sdk.v1.message.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class DeleteMessageRequestV1 {

    /**
     * 待删除的消息的 ID
     */
    @YunxinParam("deleteMsgid")
    private Long deleteMsgid;

    /**
     * 要删除消息的创建时间
     */
    @YunxinParam("timetag")
    private Long timetag;

    /**
     * 只能传入 7 或 8，7 表示删除单聊消息，8 表示删除群消息
     */
    @YunxinParam("type")
    private Integer type;

    /**
     * 消息发送方的云信 IM 账号（accid）
     */
    @YunxinParam("from")
    private String from;

    /**
     * 如果待删除的是单聊消息，需传入接收者的云信 IM 账号（accid）。如果待删除的是群消息，需传入对应的群 ID（即 tid）
     */
    @YunxinParam("to")
    private String to;

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
