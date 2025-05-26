package com.netease.nim.im.server.sdk.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response object for message modification
 * 
 * API: POST https://open.yunxinapi.com/im/v2/messages/actions/modifyMsg
 */
public class ModifyMessageResponseV2 {

    /**
     * Account ID of the user who modified the message
     */
    @JSONField(name = "modify_account_id")
    private String modifyAccountId;

    /**
     * Message modification time
     */
    @JSONField(name = "modify_time")
    private Long modifyTime;

    /**
     * Server message ID
     */
    @JSONField(name = "message_server_id")
    private Long messageServerId;

    /**
     * Sender's account ID
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * Receiver's account ID
     */
    @JSONField(name = "receiver_id")
    private String receiverId;

    /**
     * Message creation timestamp
     */
    @JSONField(name = "create_time")
    private Long createTime;

    /**
     * Message type
     */
    @JSONField(name = "message_type")
    private Integer messageType;

    /**
     * Custom message subtype
     */
    @JSONField(name = "sub_type")
    private Integer subType;

    /**
     * Text content
     */
    @JSONField(name = "text")
    private String text;

    /**
     * Message attachment or custom message content
     */
    @JSONField(name = "attachment")
    private Object attachment;

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

    public Object getAttachment() {
        return attachment;
    }

    public void setAttachment(Object attachment) {
        this.attachment = attachment;
    }
} 