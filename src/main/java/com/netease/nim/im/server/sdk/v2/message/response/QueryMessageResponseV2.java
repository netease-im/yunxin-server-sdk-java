package com.netease.nim.im.server.sdk.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for querying a single message details
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
 */
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
    private Object attachment;              // Multimedia or custom message attachment
    
    @JSONField(name = "extension")
    private String extension;               // Third-party extension field
    
    @JSONField(name = "modify_account_id")
    private String modifyAccountId;         // Account ID of the user who modified the message
    
    @JSONField(name = "modify_time")
    private Long modifyTime;                // Message modification timestamp
    
    @JSONField(name = "thread_config")
    private ThreadConfig threadConfig;      // Thread message configuration
    
    /**
     * Default constructor
     */
    public QueryMessageResponseV2() {
    }
    
    // Inner classes for thread configuration
    
    /**
     * Class representing thread configuration
     */
    public static class ThreadConfig {
        /**
         * Thread root message information
         */
        @JSONField(name = "thread_root")
        private ThreadMessage threadRoot;

        /**
         * Reply message information
         */
        @JSONField(name = "thread_reply")
        private ThreadMessage threadReply;

        public ThreadMessage getThreadRoot() {
            return threadRoot;
        }

        public void setThreadRoot(ThreadMessage threadRoot) {
            this.threadRoot = threadRoot;
        }

        public ThreadMessage getThreadReply() {
            return threadReply;
        }

        public void setThreadReply(ThreadMessage threadReply) {
            this.threadReply = threadReply;
        }
    }
    
    /**
     * Inner class for thread message information
     */
    public static class ThreadMessage {
        /**
         * Sender ID
         */
        @JSONField(name = "sender_id")
        private String senderId;

        /**
         * Receiver ID
         */
        @JSONField(name = "receiver_id")
        private String receiverId;

        /**
         * Message creation time
         */
        @JSONField(name = "create_time")
        private Long createTime;

        /**
         * Server message ID
         */
        @JSONField(name = "message_server_id")
        private String messageServerId;

        /**
         * Client message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;

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

        public String getMessageServerId() {
            return messageServerId;
        }

        public void setMessageServerId(String messageServerId) {
            this.messageServerId = messageServerId;
        }

        public String getMessageClientId() {
            return messageClientId;
        }

        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
    }
    
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
    
    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }
    
    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }
} 