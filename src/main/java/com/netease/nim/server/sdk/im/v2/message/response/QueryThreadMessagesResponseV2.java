package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying thread messages
 * 
 * API: GET https://open.yunxinapi.com/im/v2/messages/actions/thread_messages
 */
public class QueryThreadMessagesResponseV2 {

    @JSONField(name = "has_more")
    private Boolean hasMore;                // Whether there are more messages
    
    @JSONField(name = "next_token")
    private String nextToken;               // Token for pagination
    
    @JSONField(name = "thread_root")
    private MessageItem threadRoot;         // Thread root message
    
    private Long total;                     // Total number of messages in the thread
    
    private Long timestamp;                 // Query timestamp
    
    private List<MessageItem> messages;     // List of thread messages
    
    /**
     * Message item representing a message in the thread
     */
    public static class MessageItem {
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;        // Server message ID
        
        @JSONField(name = "sender_id")
        private String senderId;             // Sender's account ID
        
        @JSONField(name = "message_type")
        private Integer messageType;         // Message type
        
        @JSONField(name = "create_time")
        private Long createTime;             // Message creation time
        
        @JSONField(name = "message_client_id")
        private String messageClientId;      // Client message ID
        
        @JSONField(name = "sender_client_type")
        private Integer senderClientType;    // Sender client type
        
        @JSONField(name = "text")
        private String text;                 // Message text content
        
        @JSONField(name = "attachment")
        private Object attachment;           // Message attachment
        
        @JSONField(name = "extension")
        private String extension;            // Message extension
        
        @JSONField(name = "team_id")
        private Long teamId;                 // Team ID (for team messages)
        
        @JSONField(name = "receiver_id")
        private String receiverId;           // Receiver account ID (for P2P messages)
        
        @JSONField(name = "sub_type")
        private Integer subType;             // Message sub-type
        
        @JSONField(name = "modify_account_id")
        private String modifyAccountId;      // Account ID of user who modified the message
        
        @JSONField(name = "modify_time")
        private Long modifyTime;             // Message modification time
        
        @JSONField(name = "thread_config")
        private ThreadConfig threadConfig;    // Thread message configuration
        
        // Getters and Setters
        
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
        
        public Integer getMessageType() {
            return messageType;
        }
        
        public void setMessageType(Integer messageType) {
            this.messageType = messageType;
        }
        
        public Long getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        public String getMessageClientId() {
            return messageClientId;
        }
        
        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
        
        public Integer getSenderClientType() {
            return senderClientType;
        }
        
        public void setSenderClientType(Integer senderClientType) {
            this.senderClientType = senderClientType;
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
        
        public Long getTeamId() {
            return teamId;
        }
        
        public void setTeamId(Long teamId) {
            this.teamId = teamId;
        }
        
        public String getReceiverId() {
            return receiverId;
        }
        
        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }
        
        public Integer getSubType() {
            return subType;
        }
        
        public void setSubType(Integer subType) {
            this.subType = subType;
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
    
    // Getters and Setters for main class
    
    public Boolean getHasMore() {
        return hasMore;
    }
    
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    public String getNextToken() {
        return nextToken;
    }
    
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    public MessageItem getThreadRoot() {
        return threadRoot;
    }
    
    public void setThreadRoot(MessageItem threadRoot) {
        this.threadRoot = threadRoot;
    }
    
    public Long getTotal() {
        return total;
    }
    
    public void setTotal(Long total) {
        this.total = total;
    }
    
    public Long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    public List<MessageItem> getMessages() {
        return messages;
    }
    
    public void setMessages(List<MessageItem> messages) {
        this.messages = messages;
    }
} 