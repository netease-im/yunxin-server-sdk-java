package com.netease.nim.im.server.sdk.v2.broadcast.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for sending broadcast notifications to all chatrooms
 */
public class SendChatroomBroadcastNotificationResponseV2 {

    /**
     * Chatroom broadcast message creation timestamp
     */
    @JSONField(name = "create_time")
    private Long createTime;

    /**
     * Chatroom broadcast message ID
     */
    @JSONField(name = "client_broadcast_id")
    private String clientBroadcastId;

    /**
     * Sender's account ID
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * Sender's nickname
     */
    @JSONField(name = "from_nick")
    private String fromNick;

    /**
     * Sender's avatar URL
     */
    @JSONField(name = "from_avator")
    private String fromAvatar;

    /**
     * Sender's chatroom ID
     */
    @JSONField(name = "room_id")
    private String roomId;

    /**
     * Message type
     */
    @JSONField(name = "message_type")
    private Integer messageType;

    /**
     * Message text content or description
     */
    @JSONField(name = "text")
    private String text;

    /**
     * Message attachment or custom message content
     */
    @JSONField(name = "attachment")
    private Object attachment;

    /**
     * Sender's client type
     */
    @JSONField(name = "from_client_type")
    private String fromClientType;

    /**
     * Whether this is a high priority message
     */
    @JSONField(name = "high_priority")
    private Boolean highPriority;

    /**
     * Custom message subtype
     */
    @JSONField(name = "sub_type")
    private Integer subType;

    /**
     * Get creation timestamp
     *
     * @return Creation timestamp
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * Set creation timestamp
     *
     * @param createTime Creation timestamp
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * Get client broadcast ID
     *
     * @return Client broadcast ID
     */
    public String getClientBroadcastId() {
        return clientBroadcastId;
    }

    /**
     * Set client broadcast ID
     *
     * @param clientBroadcastId Client broadcast ID
     */
    public void setClientBroadcastId(String clientBroadcastId) {
        this.clientBroadcastId = clientBroadcastId;
    }

    /**
     * Get sender ID
     *
     * @return Sender ID
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Set sender ID
     *
     * @param senderId Sender ID
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    /**
     * Get sender's nickname
     *
     * @return Sender's nickname
     */
    public String getFromNick() {
        return fromNick;
    }

    /**
     * Set sender's nickname
     *
     * @param fromNick Sender's nickname
     */
    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    /**
     * Get sender's avatar URL
     *
     * @return Sender's avatar URL
     */
    public String getFromAvatar() {
        return fromAvatar;
    }

    /**
     * Set sender's avatar URL
     *
     * @param fromAvatar Sender's avatar URL
     */
    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }

    /**
     * Get room ID
     *
     * @return Room ID
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * Set room ID
     *
     * @param roomId Room ID
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * Get message type
     *
     * @return Message type
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     * Set message type
     *
     * @param messageType Message type
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     * Get text
     *
     * @return Text
     */
    public String getText() {
        return text;
    }

    /**
     * Set text
     *
     * @param text Text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get attachment
     *
     * @return Attachment
     */
    public Object getAttachment() {
        return attachment;
    }

    /**
     * Set attachment
     *
     * @param attachment Attachment
     */
    public void setAttachment(Object attachment) {
        this.attachment = attachment;
    }

    /**
     * Get client type
     *
     * @return Client type
     */
    public String getFromClientType() {
        return fromClientType;
    }

    /**
     * Set client type
     *
     * @param fromClientType Client type
     */
    public void setFromClientType(String fromClientType) {
        this.fromClientType = fromClientType;
    }

    /**
     * Get high priority flag
     *
     * @return High priority flag
     */
    public Boolean getHighPriority() {
        return highPriority;
    }

    /**
     * Set high priority flag
     *
     * @param highPriority High priority flag
     */
    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
    }

    /**
     * Get subtype
     *
     * @return Subtype
     */
    public Integer getSubType() {
        return subType;
    }

    /**
     * Set subtype
     *
     * @param subType Subtype
     */
    public void setSubType(Integer subType) {
        this.subType = subType;
    }
} 