package com.netease.nim.server.sdk.im.v1.chatroom_message.response;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class ChatroomTargetMsgResponseV1 {

    /**
     * 发送消息的时间戳，毫秒级
     */
    @YunxinParam("time")
    private Long time;

    /**
     * 发送消息用户的头像
     */
    @YunxinParam("fromAvator")
    private String fromAvator;

    /**
     * 客户端的消息 ID
     */
    @YunxinParam("msgid_client")
    private String msgidClient;

    /**
     * 发送消息用户的客户端类型
     */
    @YunxinParam("fromClientType")
    private String fromClientType;

    /**
     * 聊天室 ID
     */
    @YunxinParam("roomId")
    private Long roomId;

    /**
     * 发送消息的用户账号，accid
     */
    @YunxinParam("fromAccount")
    private String fromAccount;

    /**
     * 发送消息的用户昵称
     */
    @YunxinParam("fromNick")
    private String fromNick;

    /**
     * 消息内容
     */
    @YunxinParam("attach")
    private String attach;

    /**
     * 消息类型
     */
    @YunxinParam("type")
    private Integer type;

    /**
     * 扩展字段
     */
    @YunxinParam("ext")
    private String ext;

    // Getters and Setters

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

    public String getMsgidClient() {
        return msgidClient;
    }

    public void setMsgidClient(String msgidClient) {
        this.msgidClient = msgidClient;
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

}
