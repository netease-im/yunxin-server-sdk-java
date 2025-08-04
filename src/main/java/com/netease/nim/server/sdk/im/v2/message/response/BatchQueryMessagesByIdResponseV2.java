package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;
import java.util.Map;


public class BatchQueryMessagesByIdResponseV2 {

    @JSONField(name = "success_list")
    private List<SuccessMessage> successList;   // List of successfully queried messages
    
    @JSONField(name = "failed_list")
    private List<FailedMessage> failedList;     // List of failed message queries
    
    
    public static class SuccessMessage {
        
        @JSONField(name = "receiver_account_ids")
        private List<String> receiverAccountIds;

        @JSONField(name = "inclusive")
        private Boolean inclusive;

        @JSONField(name = "new_member_visible")
        private Boolean newMemberVisible;
        
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
        private Integer senderClientType;    // Sender client type
        
        @JSONField(name = "text")
        private String text;                // Message text content
        
        @JSONField(name = "attachment")
        private Map<?, ?> attachment;          // Message attachment
        
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
        private QueryThreadMessagesResponseV2.ThreadConfig threadConfig;  // Thread message configuration
        
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
        
        public QueryThreadMessagesResponseV2.ThreadConfig getThreadConfig() {
            return threadConfig;
        }
        
        public void setThreadConfig(QueryThreadMessagesResponseV2.ThreadConfig threadConfig) {
            this.threadConfig = threadConfig;
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
    }
    
    
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