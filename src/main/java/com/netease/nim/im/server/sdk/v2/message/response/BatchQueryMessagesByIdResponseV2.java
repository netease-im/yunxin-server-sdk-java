package com.netease.nim.im.server.sdk.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for batch querying messages by message IDs
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/batch_messages
 */
public class BatchQueryMessagesByIdResponseV2 {

    @JSONField(name = "success_list")
    private List<SuccessMessage> successList;   // List of successfully queried messages
    
    @JSONField(name = "failed_list")
    private List<FailedMessage> failedList;     // List of failed message queries
    
    /**
     * Class representing a successfully queried message
     */
    public static class SuccessMessage {
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;       // Server message ID
        
        @JSONField(name = "conversation_type")
        private Integer conversationType;   // Conversation type (1: P2P, 2: Team, 3: Super Team)
        
        @JSONField(name = "sender_id")
        private String senderId;            // Sender's account ID
        
        @JSONField(name = "message_type")
        private Integer messageType;        // Message type
        
        @JSONField(name = "create_time")
        private Long createTime;            // Message creation time
        
        @JSONField(name = "message_client_id")
        private String messageClientId;     // Client message ID
        
        @JSONField(name = "sender_client_type")
        private String senderClientType;    // Sender client type
        
        @JSONField(name = "text")
        private String text;                // Message text content
        
        @JSONField(name = "attachment")
        private Object attachment;          // Message attachment
        
        @JSONField(name = "extension")
        private String extension;           // Message extension
        
        @JSONField(name = "team_id")
        private Long teamId;                // Team ID (for team messages)
        
        @JSONField(name = "receiver_id")
        private String receiverId;          // Receiver account ID (for P2P messages)
        
        @JSONField(name = "sub_type")
        private Integer subType;            // Message sub-type
        
        @JSONField(name = "modify_account_id")
        private String modifyAccountId;     // Account ID of the user who modified the message
        
        @JSONField(name = "modify_time")
        private Long modifyTime;            // Message modification time
        
        @JSONField(name = "thread_config")
        private ThreadConfig threadConfig;  // Thread message configuration
        
        // Getters and Setters
        
        public Long getMessageServerId() {
            return messageServerId;
        }
        
        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }
        
        public Integer getConversationType() {
            return conversationType;
        }
        
        public void setConversationType(Integer conversationType) {
            this.conversationType = conversationType;
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
        
        public String getSenderClientType() {
            return senderClientType;
        }
        
        public void setSenderClientType(String senderClientType) {
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
     * Class representing a failed message query
     */
    public static class FailedMessage {
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;      // Message server ID
        
        @JSONField(name = "create_time")
        private Long createTime;           // Message creation time
        
        @JSONField(name = "error_code")
        private Long errorCode;            // Error code
        
        @JSONField(name = "error_msg")
        private String errorMsg;           // Error message
        
        // Getters and Setters
        
        public Long getMessageServerId() {
            return messageServerId;
        }
        
        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }
        
        public Long getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        public Long getErrorCode() {
            return errorCode;
        }
        
        public void setErrorCode(Long errorCode) {
            this.errorCode = errorCode;
        }
        
        public String getErrorMsg() {
            return errorMsg;
        }
        
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
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
    
    public List<SuccessMessage> getSuccessList() {
        return successList;
    }
    
    public void setSuccessList(List<SuccessMessage> successList) {
        this.successList = successList;
    }
    
    public List<FailedMessage> getFailedList() {
        return failedList;
    }
    
    public void setFailedList(List<FailedMessage> failedList) {
        this.failedList = failedList;
    }
} 