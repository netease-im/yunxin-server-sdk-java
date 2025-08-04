package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Map;


public class ModifyMessageResponseV2 {

    
    @JSONField(name = "modify_account_id")
    private String modifyAccountId;

    
    @JSONField(name = "modify_time")
    private Long modifyTime;

    
    @JSONField(name = "message_server_id")
    private Long messageServerId;

    
    @JSONField(name = "sender_id")
    private String senderId;

    
    @JSONField(name = "receiver_id")
    private String receiverId;

    
    @JSONField(name = "create_time")
    private Long createTime;

    
    @JSONField(name = "message_type")
    private Integer messageType;

    
    @JSONField(name = "sub_type")
    private Integer subType;

    
    @JSONField(name = "text")
    private String text;

    
    @JSONField(name = "attachment")
    private Map<?, ?> attachment;

    @JSONField(name = "extension")
    private String extension;

    // Getters and setters
    public String getModifyAccountId() {
        return modifyAccountId;
    }

    public void setModifyAccountId(String modifyAccountId) {
        this.modifyAccountId = modifyAccountId;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getMessageServerId() {
        return messageServerId;
    }

    public void setMessageServerId(Long messageServerId) {
        this.messageServerId = messageServerId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<?, ?> getAttachment() {
        return attachment;
    }

    public void setAttachment(Map<?, ?> attachment) {
        this.attachment = attachment;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
} 