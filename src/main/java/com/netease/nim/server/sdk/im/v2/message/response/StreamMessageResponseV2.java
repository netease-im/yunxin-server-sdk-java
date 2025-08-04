package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import com.netease.nim.server.sdk.im.v2.message.request.StreamMessageRequestV2;

/**
 * Response object for sending a stream message.
 */
public class StreamMessageResponseV2 {

    /**
     * Server message ID.
     */
    @JSONField(name = "message_server_id")
    private Long messageServerId;

    /**
     * Client message ID.
     */
    @JSONField(name = "message_client_id")
    private String messageClientId;

    /**
     * Sender's account ID.
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * Conversation type.
     */
    @JSONField(name = "conversation_type")
    private Integer conversationType;

    /**
     * Receiver's account ID.
     */
    @JSONField(name = "receiver_id")
    private String receiverId;

    /**
     * Message creation time.
     */
    @JSONField(name = "create_time")
    private Long createTime;

    /**
     * Message type.
     */
    @JSONField(name = "message_type")
    private Integer messageType;

    /**
     * Message attachment.
     */
    @JSONField(name = "attachment")
    private StreamMessageRequestV2.StreamAttachment attachment;

    public Long getMessageServerId() {
        return messageServerId;
    }

    public void setMessageServerId(Long messageServerId) {
        this.messageServerId = messageServerId;
    }

    public String getMessageClientId() {
        return messageClientId;
    }

    public void setMessageClientId(String messageClientId) {
        this.messageClientId = messageClientId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Integer getConversationType() {
        return conversationType;
    }

    public void setConversationType(Integer conversationType) {
        this.conversationType = conversationType;
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

    public StreamMessageRequestV2.StreamAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(StreamMessageRequestV2.StreamAttachment attachment) {
        this.attachment = attachment;
    }
}
