package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class DeleteMessageOneWayRequestV1 {

    /**
     * 要撤回消息的消息 ID
     */
    @YunxinParam("deleteMsgid")
    private Long deleteMsgid;

    /**
     * 待撤回消息的创建时间
     */
    @YunxinParam("timetag")
    private Long timetag;

    /**
     * 待撤回消息的类型，只能传入 13 或 14。13 表示点对点消息撤回，14 表示群消息撤回
     */
    @YunxinParam("type")
    private Integer type;

    /**
     * 消息发送者的云信 IM 账号（accid）
     */
    @YunxinParam("from")
    private String from;

    /**
     * 消息接收方。如果待撤回消息为单聊消息，则需传入消息接收者的云信 IM 账号（accid）。如果是群消息，则需传入对应群的ID （tid）
     */
    @YunxinParam("to")
    private String to;

    /**
     * 消息撤回的相应描述，默认值为“撤回了一条信息”。最大长度 128 个字符
     */
    @YunxinParam("msg")
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
