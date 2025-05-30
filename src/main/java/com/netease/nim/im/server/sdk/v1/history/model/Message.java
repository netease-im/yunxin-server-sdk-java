package com.netease.nim.im.server.sdk.v1.history.model;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;

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
     * 消息内容，根据不同消息类型有不同的结构
     */
    private Object body;

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

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    /**
     * Create a specific message object based on type
     * 
     * @param jsonObject the JSON representation of a message
     * @return the appropriate message type object
     */
    public static Message fromJson(JSONObject jsonObject) {
        Integer type = jsonObject.getInteger("type");
        Message message;
        
        // Create the appropriate message type based on the message type
        if (type == null) {
            message = new Message();
        } else switch (type) {
            case 0:
                message = jsonObject.to(TextMessage.class);
                break;
            case 1:
                message = jsonObject.to(ImageMessage.class);
                break;
            case 2:
                message = jsonObject.to(AudioMessage.class);
                break;
            case 3:
                message = jsonObject.to(VideoMessage.class);
                break;
            case 4:
                message = jsonObject.to(LocationMessage.class);
                break;
            case 5:
                // Check if it's a team notification or chatroom notification
                if (jsonObject.getJSONObject("body") != null && 
                    jsonObject.getJSONObject("body").containsKey("tid")) {
                    message = jsonObject.to(TeamNotificationMessage.class);
                } else {
                    message = jsonObject.to(ChatroomNotificationMessage.class);
                }
                break;
            case 6:
                message = jsonObject.to(FileMessage.class);
                break;
            case 10:
                message = jsonObject.to(TipMessage.class);
                break;
            default:
                if (type >= 100) {
                    message = jsonObject.to(CustomMessage.class);
                } else {
                    message = new Message();
                }
                break;
        }
        
        return message;
    }
} 