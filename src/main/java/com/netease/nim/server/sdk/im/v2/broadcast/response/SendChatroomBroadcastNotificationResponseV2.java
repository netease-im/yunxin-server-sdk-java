package com.netease.nim.server.sdk.im.v2.broadcast.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Map;


public class SendChatroomBroadcastNotificationResponseV2 {

    
    @JSONField(name = "create_time")
    private Long createTime;

    
    @JSONField(name = "client_broadcast_id")
    private String clientBroadcastId;

    
    @JSONField(name = "sender_id")
    private String senderId;

    
    @JSONField(name = "from_nick")
    private String fromNick;

    
    @JSONField(name = "from_avatar")
    private String fromAvatar;
    
    @JSONField(name = "message_type")
    private Integer messageType;

    
    @JSONField(name = "text")
    private String text;

    /**
     * 
     */
    @JSONField(name = "attachment")
    private Map<?, ?> attachment;

    /**
     * 
     */
    @JSONField(name = "sender_client_type")
    private Integer senderClientType;

    /**
     * 
     */
    @JSONField(name = "high_priority")
    private Boolean highPriority;

    /**
     * 
     */
    @JSONField(name = "sub_type")
    private Integer subType;

    /**
     * 
     *
     * @return 
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 
     *
     * @param createTime 
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * id
     *
     * @return id
     */
    public String getClientBroadcastId() {
        return clientBroadcastId;
    }

    /**
     * id
     *
     * @param clientBroadcastId id
     */
    public void setClientBroadcastId(String clientBroadcastId) {
        this.clientBroadcastId = clientBroadcastId;
    }

    /**
     * id
     *
     * @return id
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * id
     *
     * @param senderId id
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    /**
     * 
     *
     * @return 
     */
    public String getFromNick() {
        return fromNick;
    }

    /**
     * 
     *
     * @param fromNick 
     */
    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    /**
     * 
     *
     * @return 
     */
    public String getFromAvatar() {
        return fromAvatar;
    }

    /**
     * 
     *
     * @param fromAvatar 
     */
    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }


    /**
     * 0 1
     *
     * @return 0 1
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     * 0 1
     *
     * @param messageType 0 1
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     * 
     *
     * @return 
     */
    public String getText() {
        return text;
    }

    /**
     * 
     *
     * @param text 
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     *
     * @return 
     */
    public Map<?, ?> getAttachment() {
        return attachment;
    }

    /**
     * 
     *
     * @param attachment 
     */
    public void setAttachment(Map<?, ?> attachment) {
        this.attachment = attachment;
    }


    public Boolean getHighPriority() {
        return highPriority;
    }

    
    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    
    public Integer getSubType() {
        return subType;
    }

    
    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getSenderClientType() {
        return senderClientType;
    }

    public void setSenderClientType(Integer senderClientType) {
        this.senderClientType = senderClientType;
    }
}