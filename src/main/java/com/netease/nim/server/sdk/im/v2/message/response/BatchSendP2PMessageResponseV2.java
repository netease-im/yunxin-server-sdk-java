package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response object for batch sending P2P messages
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations/messages
 */
public class BatchSendP2PMessageResponseV2 {

    /**
     * List of successfully sent messages
     */
    @JSONField(name = "success_list")
    private List<SuccessItem> successList;

    /**
     * List of failed messages
     */
    @JSONField(name = "failed_list")
    private List<FailedItem> failedList;

    /**
     * Successful message item
     */
    public static class SuccessItem {
        /**
         * Server message ID
         */
        @JSONField(name = "message_server_id")
        private Long messageServerId;

        /**
         * Sender's account ID
         */
        @JSONField(name = "sender_id")
        private String senderId;

        /**
         * Conversation type (1 for P2P)
         */
        @JSONField(name = "conversation_type")
        private Integer conversationType;

        /**
         * Receiver's account ID
         */
        @JSONField(name = "receiver_id")
        private String receiverId;

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
         * Custom message subtype
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

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
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
    }

    /**
     * Failed message item
     */
    public static class FailedItem {
        /**
         * The account ID that failed to receive the message
         */
        @JSONField(name = "account_id")
        private String accountId;

        /**
         * Error code
         */
        @JSONField(name = "error_code")
        private Integer errorCode;

        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
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

    // Existing getters and setters
    public List<SuccessItem> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<SuccessItem> successList) {
        this.successList = successList;
    }

    public List<FailedItem> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailedItem> failedList) {
        this.failedList = failedList;
    }
} 