package com.netease.nim.server.sdk.im.v1.chatroom_message.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class RecallChatroomMsgRequestV1 {

    /**
     * 聊天室 ID
     */
    @YunxinParam("roomid")
    private Long roomId;

    /**
     * 被撤回消息的时间戳，毫秒级
     */
    @YunxinParam("msgTimetag")
    private Long msgTimetag;

    /**
     * 被撤回的消息 ID
     */
    @YunxinParam("msgId")
    private String msgId;

    /**
     * 被撤回的消息的发送者账号，accid
     */
    @YunxinParam("fromAcc")
    private String fromAcc;

    /**
     * 撤回消息的操作者账号，accid
     */
    @YunxinParam("operatorAcc")
    private String operatorAcc;

    /**
     * 撤回消息的通知扩展字段，最大长度 1024 位字符
     */
    @YunxinParam("notifyExt")
    private String notifyExt;

    // Getters and Setters

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getMsgTimetag() {
        return msgTimetag;
    }

    public void setMsgTimetag(Long msgTimetag) {
        this.msgTimetag = msgTimetag;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(String fromAcc) {
        this.fromAcc = fromAcc;
    }

    public String getOperatorAcc() {
        return operatorAcc;
    }

    public void setOperatorAcc(String operatorAcc) {
        this.operatorAcc = operatorAcc;
    }

    public String getNotifyExt() {
        return notifyExt;
    }

    public void setNotifyExt(String notifyExt) {
        this.notifyExt = notifyExt;
    }
}