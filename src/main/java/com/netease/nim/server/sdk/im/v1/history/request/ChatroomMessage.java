package com.netease.nim.server.sdk.im.v1.history.request;

import com.alibaba.fastjson2.JSONObject;

/**
 * 聊天室消息类
 * 聊天室消息特点：
 * - msgid 为 String 类型
 * - 没有 msgidclient 字段
 */
public class ChatroomMessage {
    /**
     * 发送者账号
     */
    private String from;
    
    /**
     * 消息ID，服务端ID，对于聊天室消息为String类型
     */
    private String msgid;
    
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

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
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
     * Create a chatroom message object from JSON
     * 
     * @param jsonObject the JSON representation of a chatroom message
     * @return the chatroom message object
     */
    public static ChatroomMessage fromJson(JSONObject jsonObject) {
        ChatroomMessage message = new ChatroomMessage();
        message.setFrom(jsonObject.getString("from"));
        message.setMsgid(jsonObject.getString("msgid")); // 聊天室消息的msgid是String类型
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