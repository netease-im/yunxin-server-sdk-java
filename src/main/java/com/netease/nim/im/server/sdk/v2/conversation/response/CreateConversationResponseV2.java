package com.netease.nim.im.server.sdk.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for creating a conversation
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations
 */
public class CreateConversationResponseV2 {
    
    /**
     * Conversation ID
     */
    @JSONField(name = "conversation_id")
    private String conversationId;
    
    /**
     * Sender account ID
     */
    @JSONField(name = "sender_id")
    private String senderId;
    
    /**
     * Receiver account ID or team ID
     */
    @JSONField(name = "receiver_id")
    private String receiverId;
    
    /**
     * Conversation type
     * 1: P2P chat
     * 2: Advanced team chat
     * 3: Super team chat
     */
    @JSONField(name = "type")
    private Integer type;
    
    /**
     * Whether this conversation is pinned to the top
     */
    @JSONField(name = "stick_top")
    private Boolean stickTop;
    
    /**
     * Conversation group IDs
     */
    @JSONField(name = "group_ids")
    private List<Long> groupIds;
    
    /**
     * Server extension field
     */
    @JSONField(name = "server_extension")
    private String serverExtension;
    
    /**
     * Message state
     * 0: Normal message
     * 1: Recalled message
     */
    @JSONField(name = "message_state")
    private Integer messageState;
    
    /**
     * Last message in the conversation
     */
    @JSONField(name = "last_message")
    private MessageInfo lastMessage;
    
    /**
     * Recalled message information (only returned when message_state is 1)
     */
    @JSONField(name = "revoke_message")
    private RevokeMessageInfo revokeMessage;
    
    /**
     * Unread message count
     */
    @JSONField(name = "unread_count")
    private Integer unreadCount;
    
    /**
     * Sort order value
     */
    @JSONField(name = "sort_order")
    private Long sortOrder;
    
    /**
     * Conversation create time (milliseconds)
     */
    @JSONField(name = "create_time")
    private Long createTime;
    
    /**
     * Conversation update time (milliseconds)
     */
    @JSONField(name = "update_time")
    private Long updateTime;
    
    /**
     * Last read time (milliseconds)
     */
    @JSONField(name = "last_read_time")
    private Long lastReadTime;
    
    // Getters and setters
    
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
    
    public MessageInfo getLastMessage() {
        return lastMessage;
    }
    
    public void setLastMessage(MessageInfo lastMessage) {
        this.lastMessage = lastMessage;
    }
    
    public RevokeMessageInfo getRevokeMessage() {
        return revokeMessage;
    }
    
    public void setRevokeMessage(RevokeMessageInfo revokeMessage) {
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
    
    /**
     * Inner class for message information
     */
    public static class MessageInfo {
        // Placeholder for message information
        // The specific fields would depend on the API requirements
    }
    
    /**
     * Inner class for recalled message information
     */
    public static class RevokeMessageInfo {
        
        /**
         * ID of the recalled message
         */
        @JSONField(name = "server_id")
        private Long serverId;
        
        /**
         * Attachment information of the recalled message
         */
        @JSONField(name = "attach")
        private String attach;
        
        /**
         * Account ID of the user who recalled the message
         */
        @JSONField(name = "revoke_id")
        private String revokeId;
        
        /**
         * Custom information for the server recall
         */
        @JSONField(name = "custom_info")
        private String customInfo;
        
        /**
         * Message recall type
         * 0: Undefined
         * 1: P2P bidirectional recall
         * 2: Team bidirectional recall
         * 3: P2P unidirectional recall
         * 4: Team unidirectional recall
         */
        @JSONField(name = "revoke_type")
        private Integer revokeType;
        
        // Getters and setters
        
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
} 