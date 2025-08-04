package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;
import java.util.Map;


public class QueryMessageResponseV2 {

    @JSONField(name = "message_server_id")
    private Long messageServerId;           // Server message ID

    @JSONField(name = "message_client_id")
    private String messageClientId;         // Client message ID

    @JSONField(name = "sender_id")
    private String senderId;                // Message sender account ID

    @JSONField(name = "conversation_type")
    private Integer conversationType;       // Conversation type (1: P2P, 2: Advanced team, 3: Super team)

    @JSONField(name = "receiver_id")
    private String receiverId;              // Message receiver account ID (for P2P)

    @JSONField(name = "team_id")
    private Long teamId;                    // Team ID (for team conversations)

    @JSONField(name = "message_type")
    private Integer messageType;            // Message type (0: Text, 1: Image, 2: Audio, etc.)

    @JSONField(name = "sub_type")
    private Integer subType;                // Custom message subtype

    @JSONField(name = "create_time")
    private Long createTime;                // Message creation timestamp

    @JSONField(name = "text")
    private String text;                    // Text content or description

    @JSONField(name = "attachment")
    private Map<?, ?> attachment;              // Multimedia or custom message attachment

    @JSONField(name = "extension")
    private String extension;               // Third-party extension field

    @JSONField(name = "modify_account_id")
    private String modifyAccountId;         // Account ID of the user who modified the message

    @JSONField(name = "modify_time")
    private Long modifyTime;                // Message modification timestamp

    @JSONField(name = "sender_client_type")
    private Integer senderClientType;       // Sender client type (1:Android, 2:iOS, 4:PC, 16:WEB, 32:REST, 64:MAC)

    @JSONField(name = "receiver_account_ids")
    private List<String> receiverAccountIds; // Directed message receiver account IDs

    @JSONField(name = "inclusive")
    private Boolean inclusive;              // Whether the receiver list is readable (1: readable, 2: unreadable)

    @JSONField(name = "new_member_visible")
    private Boolean newMemberVisible;       // Whether new group members can view the message (1: visible, 2: not visible)

    @JSONField(name = "thread_config")
    private QueryThreadMessagesResponseV2.ThreadConfig threadConfig;      // Thread message configuration


    public QueryMessageResponseV2() {
    }

    // Inner classes for thread configuration


    // Getters and setters for main class

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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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

    public Integer getSenderClientType() {
        return senderClientType;
    }

    public void setSenderClientType(Integer senderClientType) {
        this.senderClientType = senderClientType;
    }

    public List<String> getReceiverAccountIds() {
        return receiverAccountIds;
    }

    public void setReceiverAccountIds(List<String> receiverAccountIds) {
        this.receiverAccountIds = receiverAccountIds;
    }

    public Boolean getInclusive() {
        return inclusive;
    }

    public void setInclusive(Boolean inclusive) {
        this.inclusive = inclusive;
    }

    public Boolean getNewMemberVisible() {
        return newMemberVisible;
    }

    public void setNewMemberVisible(Boolean newMemberVisible) {
        this.newMemberVisible = newMemberVisible;
    }

    public QueryThreadMessagesResponseV2.ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(QueryThreadMessagesResponseV2.ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }
}