package com.netease.nim.im.server.sdk.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for updating a conversation
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/conversations/{conversation_id}
 */
public class UpdateConversationResponseV2 {
    
    /**
     * Conversation ID
     */
    @JSONField(name = "conversation_id")
    private String conversationId;
    
    /**
     * Sender's account ID
     */
    @JSONField(name = "sender_id")
    private String senderId;
    
    /**
     * Receiver's account ID or team ID
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
     * Whether the conversation is pinned to top
     */
    @JSONField(name = "stick_top")
    private Boolean stickTop;
    
    /**
     * Group IDs that this conversation belongs to
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
     * This field is empty for recalled messages
     */
    @JSONField(name = "last_message")
    private Object lastMessage;
    
    /**
     * Recalled message notification
     * Returned when message_state is 1
     */
    @JSONField(name = "revoke_message")
    private RevokeMessage revokeMessage;
    
    /**
     * Unread message count
     */
    @JSONField(name = "unread_count")
    private Integer unreadCount;
    
    /**
     * Sort order for the conversation
     * By default, pinned conversations are sorted first
     * Multiple pinned conversations are sorted by creation time
     */
    @JSONField(name = "sort_order")
    private Long sortOrder;
    
    /**
     * Conversation creation time (milliseconds)
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
    
    /**
     * Recalled message information
     */
    public static class RevokeMessage {
        
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
         * Account ID of the person who recalled the message
         */
        @JSONField(name = "revoke_id")
        private String revokeId;
        
        /**
         * Custom information filled by the server during recall
         */
        @JSONField(name = "custom_info")
        private String customInfo;
        
        /**
         * Message recall type
         * 0: Undefined
         * 1: P2P chat two-way recall
         * 2: Team chat two-way recall
         * 3: P2P chat one-way recall
         * 4: Team chat one-way recall
         */
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
    
    public Object getLastMessage() {
        return lastMessage;
    }
    
    public void setLastMessage(Object lastMessage) {
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