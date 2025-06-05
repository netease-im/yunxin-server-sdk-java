package com.netease.nim.server.sdk.im.v1.history.request;

import com.alibaba.fastjson2.JSONObject;

/**
 * Base class for all message types
 */
public class Message {
    /**
     * 发送者账号
     */
    private String from;
    
    /**
     * 消息ID，服务端ID
     * 对于普通消息为Long类型，对于聊天室消息为String类型
     */
    private Object msgid; // Can be Long or String (for chatroom messages)
    
    /**
     * 客户端消息ID
     * 注意：聊天室消息没有此字段
     */
    private String msgidclient;
    
    /**
     * 发送时间，毫秒
     */
    private Long sendtime;
    
    /**
     * 消息类型
     * 0：文本消息
     * 1：图片消息
     * 2：语音消息
     * 3：视频消息
     * 4：地理位置消息
     * 5：通知消息
     * 6：文件消息
     * 10：提示消息
     * 100+：自定义消息
     */
    private Integer type;
    
    /**
     * 发送者客户端类型
     * 1：android
     * 2：iOS
     * 4：PC
     * 16：WEB
     * 32：REST
     * 64：MAC
     */
    private Integer fromclienttype;
    
    /**
     * 消息内容，以JSON字符串形式保存
     */
    private String body;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Object getMsgid() {
        return msgid;
    }

    public void setMsgid(Object msgid) {
        this.msgid = msgid;
    }

    public String getMsgidclient() {
        return msgidclient;
    }

    public void setMsgidclient(String msgidclient) {
        this.msgidclient = msgidclient;
    }

    public Long getSendtime() {
        return sendtime;
    }

    public void setSendtime(Long sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFromclienttype() {
        return fromclienttype;
    }

    public void setFromclienttype(Integer fromclienttype) {
        this.fromclienttype = fromclienttype;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Create a message object from JSON
     * 
     * @param jsonObject the JSON representation of a message
     * @return the message object
     */
    public static Message fromJson(JSONObject jsonObject) {
        Message message = new Message();
        message.setFrom(jsonObject.getString("from"));
        message.setMsgid(jsonObject.get("msgid"));
        message.setMsgidclient(jsonObject.getString("msgidclient"));
        message.setSendtime(jsonObject.getLong("sendtime"));
        message.setType(jsonObject.getInteger("type"));
        message.setFromclienttype(jsonObject.getInteger("fromclienttype"));
        
        // Convert body to string if it exists
        if (jsonObject.containsKey("body")) {
            Object bodyObj = jsonObject.get("body");
            if (bodyObj instanceof JSONObject) {
                message.setBody(((JSONObject) bodyObj).toJSONString());
            } else if (bodyObj != null) {
                message.setBody(bodyObj.toString());
            }
        }
        
        return message;
    }
} 