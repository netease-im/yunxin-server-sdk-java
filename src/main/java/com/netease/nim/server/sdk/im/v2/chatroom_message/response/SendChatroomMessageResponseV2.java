package com.netease.nim.server.sdk.im.v2.chatroom_message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for sending a message to a chatroom
 */
public class SendChatroomMessageResponseV2 {
    
    /**
     * Message details
     */
    @JSONField(name = "message")
    private MessageBody message;
    
    /**
     * List of accounts to which message sending failed
     */
    @JSONField(name = "failed_list")
    private List<FailedInfo> failedList;
    
    /**
     * Default constructor
     */
    public SendChatroomMessageResponseV2() {
    }
    
    /**
     * Get message details
     * 
     * @return message details
     */
    public MessageBody getMessage() {
        return message;
    }
    
    /**
     * Set message details
     * 
     * @param message message details
     */
    public void setMessage(MessageBody message) {
        this.message = message;
    }
    
    /**
     * Get list of accounts to which message sending failed
     * 
     * @return list of failed accounts
     */
    public List<FailedInfo> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of accounts to which message sending failed
     * 
     * @param failedList list of failed accounts
     */
    public void setFailedList(List<FailedInfo> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Message body details
     */
    public static class MessageBody {
        
        /**
         * Text content of the message
         */
        @JSONField(name = "text")
        private String text;
        
        /**
         * Client-generated message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;
        
        /**
         * Message creation timestamp
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Message type
         */
        @JSONField(name = "message_type")
        private Integer messageType;
        
        /**
         * Sender account ID
         */
        @JSONField(name = "sender_id")
        private String senderId;
        
        /**
         * Sender nickname
         */
        @JSONField(name = "sender_nick")
        private String senderNick;
        
        /**
         * Sender avatar URL
         */
        @JSONField(name = "sender_avatar")
        private String senderAvatar;
        
        /**
         * Chatroom ID
         */
        @JSONField(name = "room_id")
        private Long roomId;
        
        /**
         * Message attachment for non-text messages
         */
        @JSONField(name = "attachment")
        private Object attachment;
        
        /**
         * Whether the message was rate-limited and discarded
         */
        @JSONField(name = "msg_abandon")
        private Boolean msgAbandon;
        
        /**
         * Whether the message is high priority
         */
        @JSONField(name = "high_priority")
        private Boolean highPriority;
        
        /**
         * Default constructor
         */
        public MessageBody() {
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
         * Get client-generated message ID
         * 
         * @return client message ID
         */
        public String getMessageClientId() {
            return messageClientId;
        }
        
        /**
         * Set client-generated message ID
         * 
         * @param messageClientId client message ID
         */
        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
        
        /**
         * Get message creation timestamp
         * 
         * @return creation timestamp
         */
        public Long getCreateTime() {
            return createTime;
        }
        
        /**
         * Set message creation timestamp
         * 
         * @param createTime creation timestamp
         */
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
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
         * Get sender nickname
         * 
         * @return sender nickname
         */
        public String getSenderNick() {
            return senderNick;
        }
        
        /**
         * Set sender nickname
         * 
         * @param senderNick sender nickname
         */
        public void setSenderNick(String senderNick) {
            this.senderNick = senderNick;
        }
        
        /**
         * Get sender avatar URL
         * 
         * @return sender avatar URL
         */
        public String getSenderAvatar() {
            return senderAvatar;
        }
        
        /**
         * Set sender avatar URL
         * 
         * @param senderAvatar sender avatar URL
         */
        public void setSenderAvatar(String senderAvatar) {
            this.senderAvatar = senderAvatar;
        }
        
        /**
         * Get chatroom ID
         * 
         * @return chatroom ID
         */
        public Long getRoomId() {
            return roomId;
        }
        
        /**
         * Set chatroom ID
         * 
         * @param roomId chatroom ID
         */
        public void setRoomId(Long roomId) {
            this.roomId = roomId;
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
        
        /**
         * Check if message was rate-limited and discarded
         * 
         * @return true if message was discarded
         */
        public Boolean getMsgAbandon() {
            return msgAbandon;
        }
        
        /**
         * Set whether message was rate-limited and discarded
         * 
         * @param msgAbandon whether message was discarded
         */
        public void setMsgAbandon(Boolean msgAbandon) {
            this.msgAbandon = msgAbandon;
        }
        
        /**
         * Check if message is high priority
         * 
         * @return true if message is high priority
         */
        public Boolean getHighPriority() {
            return highPriority;
        }
        
        /**
         * Set whether message is high priority
         * 
         * @param highPriority whether message is high priority
         */
        public void setHighPriority(Boolean highPriority) {
            this.highPriority = highPriority;
        }
    }
    
    /**
     * Information about failed message deliveries
     */
    public static class FailedInfo {
        
        /**
         * Account ID that failed to receive the message
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error code for the failure
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message for the failure
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        /**
         * Default constructor
         */
        public FailedInfo() {
        }
        
        /**
         * Get account ID
         * 
         * @return account ID
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set account ID
         * 
         * @param accountId account ID
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get error code
         * 
         * @return error code
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set error code
         * 
         * @param errorCode error code
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
        
        /**
         * Get error message
         * 
         * @return error message
         */
        public String getErrorMsg() {
            return errorMsg;
        }
        
        /**
         * Set error message
         * 
         * @param errorMsg error message
         */
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
} 