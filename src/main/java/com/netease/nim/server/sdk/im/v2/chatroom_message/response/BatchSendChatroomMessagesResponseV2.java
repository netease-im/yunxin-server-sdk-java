package com.netease.nim.server.sdk.im.v2.chatroom_message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for batch sending messages to a chatroom
 * 
 * API: POST https://open.yunxinapi.com/im/v2/chatrooms/messages
 */
public class BatchSendChatroomMessagesResponseV2 {
    
    /**
     * List of successfully sent messages
     */
    @JSONField(name = "success_list")
    private List<SuccessMessage> successList;
    
    /**
     * List of failed messages
     */
    @JSONField(name = "failed_list")
    private List<FailedMessage> failedList;
    
    /**
     * Default constructor
     */
    public BatchSendChatroomMessagesResponseV2() {
    }
    
    /**
     * Get list of successfully sent messages
     * 
     * @return list of successfully sent messages
     */
    public List<SuccessMessage> getSuccessList() {
        return successList;
    }
    
    /**
     * Set list of successfully sent messages
     * 
     * @param successList list of successfully sent messages
     */
    public void setSuccessList(List<SuccessMessage> successList) {
        this.successList = successList;
    }
    
    /**
     * Get list of failed messages
     * 
     * @return list of failed messages
     */
    public List<FailedMessage> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of failed messages
     * 
     * @param failedList list of failed messages
     */
    public void setFailedList(List<FailedMessage> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Represents a successfully sent message
     */
    public static class SuccessMessage {
        
        /**
         * Server message ID
         */
        @JSONField(name = "message_server_id")
        private Long messageServerId;
        
        /**
         * Client message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;
        
        /**
         * Message creation timestamp (Unix timestamp in milliseconds)
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Sender account ID
         */
        @JSONField(name = "sender_id")
        private String senderId;
        
        /**
         * Message type
         * 0: Text message
         * 1: Image message
         * 2: Audio message
         * 3: Video message
         * 4: Location message
         * 6: File message
         * 10: Tip message
         * 100: Custom message
         */
        @JSONField(name = "message_type")
        private Integer messageType;
        
        /**
         * Custom message subtype, valid when messageType = 100
         */
        @JSONField(name = "sub_type")
        private Integer subType;
        
        /**
         * Text content
         */
        @JSONField(name = "text")
        private String text;
        
        /**
         * Message attachment or custom message content
         */
        @JSONField(name = "attachment")
        private Object attachment;
        
        /**
         * Default constructor
         */
        public SuccessMessage() {
        }
        
        /**
         * Get server message ID
         * 
         * @return server message ID
         */
        public Long getMessageServerId() {
            return messageServerId;
        }
        
        /**
         * Set server message ID
         * 
         * @param messageServerId server message ID
         */
        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }
        
        /**
         * Get client message ID
         * 
         * @return client message ID
         */
        public String getMessageClientId() {
            return messageClientId;
        }
        
        /**
         * Set client message ID
         * 
         * @param messageClientId client message ID
         */
        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
        
        /**
         * Get message creation timestamp
         * 
         * @return message creation timestamp
         */
        public Long getCreateTime() {
            return createTime;
        }
        
        /**
         * Set message creation timestamp
         * 
         * @param createTime message creation timestamp
         */
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        /**
         * Get sender account ID
         * 
         * @return sender account ID
         */
        public String getSenderId() {
            return senderId;
        }
        
        /**
         * Set sender account ID
         * 
         * @param senderId sender account ID
         */
        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }
        
        /**
         * Get message type
         * 
         * @return message type
         */
        public Integer getMessageType() {
            return messageType;
        }
        
        /**
         * Set message type
         * 
         * @param messageType message type
         */
        public void setMessageType(Integer messageType) {
            this.messageType = messageType;
        }
        
        /**
         * Get custom message subtype
         * 
         * @return custom message subtype
         */
        public Integer getSubType() {
            return subType;
        }
        
        /**
         * Set custom message subtype
         * 
         * @param subType custom message subtype
         */
        public void setSubType(Integer subType) {
            this.subType = subType;
        }
        
        /**
         * Get text content
         * 
         * @return text content
         */
        public String getText() {
            return text;
        }
        
        /**
         * Set text content
         * 
         * @param text text content
         */
        public void setText(String text) {
            this.text = text;
        }
        
        /**
         * Get message attachment
         * 
         * @return message attachment
         */
        public Object getAttachment() {
            return attachment;
        }
        
        /**
         * Set message attachment
         * 
         * @param attachment message attachment
         */
        public void setAttachment(Object attachment) {
            this.attachment = attachment;
        }
    }
    
    /**
     * Represents a failed message
     */
    public static class FailedMessage {
        
        /**
         * Client message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;
        
        /**
         * Failure reason description
         */
        @JSONField(name = "reason")
        private String reason;
        
        /**
         * Default constructor
         */
        public FailedMessage() {
        }
        
        /**
         * Get client message ID
         * 
         * @return client message ID
         */
        public String getMessageClientId() {
            return messageClientId;
        }
        
        /**
         * Set client message ID
         * 
         * @param messageClientId client message ID
         */
        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
        
        /**
         * Get failure reason
         * 
         * @return failure reason
         */
        public String getReason() {
            return reason;
        }
        
        /**
         * Set failure reason
         * 
         * @param reason failure reason
         */
        public void setReason(String reason) {
            this.reason = reason;
        }
    }
} 