package com.netease.nim.server.sdk.im.v1.chatroom_message.response;

public class SendChatroomMsgResponseV1 {

    /**
     * 发送消息的时间戳，毫秒级
     */
    private Long time;

    /**
     * 发送消息用户的头像
     */
    private String fromAvator;

    /**
     * 客户端的消息 ID
     */
    private String msgid_client;

    /**
     * 发送消息用户的客户端类型
     */
    private String fromClientType;

    /**
     * 聊天室 ID
     */
    private Long roomId;

    /**
     * 发送消息的用户账号，accid
     */
    private String fromAccount;

    /**
     * 发送消息的用户昵称
     */
    private String fromNick;

    /**
     * 消息内容
     */
    private String attach;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 扩展字段
     */
    private String ext;

    /**
     * 高优先级消息标记
     */
    private Integer highPriorityFlag;

    /**
     * 消息被丢弃标记
     */
    private Integer msgAbandonFlag;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getFromAvator() {
        return fromAvator;
    }

    public void setFromAvator(String fromAvator) {
        this.fromAvator = fromAvator;
    }

    public String getMsgid_client() {
        return msgid_client;
    }

    public void setMsgid_client(String msgid_client) {
        this.msgid_client = msgid_client;
    }

    public String getFromClientType() {
        return fromClientType;
    }

    public void setFromClientType(String fromClientType) {
        this.fromClientType = fromClientType;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
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

    public Integer getHighPriorityFlag() {
        return highPriorityFlag;
    }

    public void setHighPriorityFlag(Integer highPriorityFlag) {
        this.highPriorityFlag = highPriorityFlag;
    }

    public Integer getMsgAbandonFlag() {
        return msgAbandonFlag;
    }

    public void setMsgAbandonFlag(Integer msgAbandonFlag) {
        this.msgAbandonFlag = msgAbandonFlag;
    }
}