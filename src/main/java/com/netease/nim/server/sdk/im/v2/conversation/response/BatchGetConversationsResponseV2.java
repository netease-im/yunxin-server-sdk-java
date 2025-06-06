package com.netease.nim.server.sdk.im.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response object for batch get conversations API
 */
public class BatchGetConversationsResponseV2 {

    @JSONField(name = "success_list")
    private List<ConversationInfo> successList;

    @JSONField(name = "failed_list")
    private List<FailedItem> failedList;

    public List<ConversationInfo> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<ConversationInfo> successList) {
        this.successList = successList;
    }

    public List<FailedItem> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailedItem> failedList) {
        this.failedList = failedList;
    }

    /**
     * Successfully retrieved conversation information
     */
    public static class ConversationInfo {
        @JSONField(name = "conversation_id")
        private String conversationId;

        @JSONField(name = "sender_id")
        private String senderId;

        @JSONField(name = "receiver_id")
        private String receiverId;

        @JSONField(name = "type")
        private Integer type;

        @JSONField(name = "stick_top")
        private Boolean stickTop;

        @JSONField(name = "group_ids")
        private List<Long> groupIds;

        @JSONField(name = "server_extension")
        private String serverExtension;

        @JSONField(name = "message_state")
        private Integer messageState;

        @JSONField(name = "last_message")
        private LastMessage lastMessage;

        @JSONField(name = "revoke_message")
        private RevokeMessage revokeMessage;

        @JSONField(name = "unread_count")
        private Integer unreadCount;

        @JSONField(name = "sort_order")
        private Long sortOrder;

        @JSONField(name = "create_time")
        private Long createTime;

        @JSONField(name = "update_time")
        private Long updateTime;

        @JSONField(name = "last_read_time")
        private Long lastReadTime;

        public String getConversationId() {
            return conversationId;
        }

        public void setConversationId(String conversationId) {
            this.conversationId = conversationId;
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

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Boolean getStickTop() {
            return stickTop;
        }

        public void setStickTop(Boolean stickTop) {
            this.stickTop = stickTop;
        }

        public List<Long> getGroupIds() {
            return groupIds;
        }

        public void setGroupIds(List<Long> groupIds) {
            this.groupIds = groupIds;
        }

        public String getServerExtension() {
            return serverExtension;
        }

        public void setServerExtension(String serverExtension) {
            this.serverExtension = serverExtension;
        }

        public Integer getMessageState() {
            return messageState;
        }

        public void setMessageState(Integer messageState) {
            this.messageState = messageState;
        }

        public LastMessage getLastMessage() {
            return lastMessage;
        }

        public void setLastMessage(LastMessage lastMessage) {
            this.lastMessage = lastMessage;
        }

        public RevokeMessage getRevokeMessage() {
            return revokeMessage;
        }

        public void setRevokeMessage(RevokeMessage revokeMessage) {
            this.revokeMessage = revokeMessage;
        }

        public Integer getUnreadCount() {
            return unreadCount;
        }

        public void setUnreadCount(Integer unreadCount) {
            this.unreadCount = unreadCount;
        }

        public Long getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(Long sortOrder) {
            this.sortOrder = sortOrder;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        public Long getLastReadTime() {
            return lastReadTime;
        }

        public void setLastReadTime(Long lastReadTime) {
            this.lastReadTime = lastReadTime;
        }
    }

    /**
     * Last message in the conversation
     */
    public static class LastMessage {
        /**
         * Server message ID
         */
        @JSONField(name = "message_server_id")
        private Long messageServerId;
        
        /**
         * Message sender account ID
         */
        @JSONField(name = "sender_id")
        private String senderId;
        
        /**
         * Conversation type
         * 1: P2P chat
         * 2: Advanced team chat
         * 3: Super team chat
         */
        @JSONField(name = "conversation_type")
        private Integer conversationType;
        
        /**
         * Message receiver account ID
         */
        @JSONField(name = "receiver_id")
        private String receiverId;
        
        /**
         * Team ID (either team_id or receiver_id will be returned, not both)
         */
        @JSONField(name = "team_id")
        private Long teamId;
        
        /**
         * Message type
         * 0: Text
         * 1: Image
         * 2: Voice
         * 3: Video
         * 4: Location
         * 5: Notification
         * 6: File
         * 10: Tip
         * 11: Robot
         * 100: Custom
         */
        @JSONField(name = "message_type")
        private Integer messageType;
        
        /**
         * Custom message subtype
         */
        @JSONField(name = "sub_type")
        private Integer subType;
        
        /**
         * Message creation timestamp
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Text content or description of multimedia message (can be used for cloud-based keyword search)
         */
        @JSONField(name = "text")
        private String text;
        
        /**
         * Multimedia message attributes or custom message content
         */
        @JSONField(name = "attachment")
        private Object attachment;
        
        /**
         * Third-party extension field provided when sending the message
         */
        @JSONField(name = "extension")
        private String extension;
        
        // Getters and setters
        
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
        
        public Object getAttachment() {
            return attachment;
        }
        
        public void setAttachment(Object attachment) {
            this.attachment = attachment;
        }
        
        public String getExtension() {
            return extension;
        }
        
        public void setExtension(String extension) {
            this.extension = extension;
        }
    }

    /**
     * Revoke message details
     */
    public static class RevokeMessage {
        @JSONField(name = "server_id")
        private Long serverId;

        @JSONField(name = "attach")
        private String attach;

        @JSONField(name = "revoke_id")
        private String revokeId;

        @JSONField(name = "custom_info")
        private String customInfo;

        @JSONField(name = "revoke_type")
        private Integer revokeType;

        public Long getServerId() {
            return serverId;
        }

        public void setServerId(Long serverId) {
            this.serverId = serverId;
        }

        public String getAttach() {
            return attach;
        }

        public void setAttach(String attach) {
            this.attach = attach;
        }

        public String getRevokeId() {
            return revokeId;
        }

        public void setRevokeId(String revokeId) {
            this.revokeId = revokeId;
        }

        public String getCustomInfo() {
            return customInfo;
        }

        public void setCustomInfo(String customInfo) {
            this.customInfo = customInfo;
        }

        public Integer getRevokeType() {
            return revokeType;
        }

        public void setRevokeType(Integer revokeType) {
            this.revokeType = revokeType;
        }
    }

    /**
     * Failed item information
     */
    public static class FailedItem {
        @JSONField(name = "conversation_id")
        private String conversationId;

        @JSONField(name = "error_code")
        private Integer errorCode;

        @JSONField(name = "error_msg")
        private String errorMsg;

        public String getConversationId() {
            return conversationId;
        }

        public void setConversationId(String conversationId) {
            this.conversationId = conversationId;
        }

        public Integer getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
} 