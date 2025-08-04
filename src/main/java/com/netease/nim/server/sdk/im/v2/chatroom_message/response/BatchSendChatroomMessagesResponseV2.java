package com.netease.nim.server.sdk.im.v2.chatroom_message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;
import java.util.Map;


public class BatchSendChatroomMessagesResponseV2 {

    @JSONField(name = "success_list")
    private List<SuccessMessage> successList;

    @JSONField(name = "failed_list")
    private List<FailMessage> failedList;

    public List<SuccessMessage> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<SuccessMessage> successList) {
        this.successList = successList;
    }

    public List<FailMessage> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailMessage> failedList) {
        this.failedList = failedList;
    }

    public static class SuccessMessage {

        @JSONField(name = "message_client_id")
        private String messageClientId;
        
        @JSONField(name = "create_time")
        private Long createTime;

        @JSONField(name = "message_type")
        private Integer messageType;

        @JSONField(name = "sender_id")
        private String senderId;

        @JSONField(name = "sender_nick")
        private String senderNick;

        @JSONField(name = "sender_avatar")
        private String senderAvatar;

        @JSONField(name = "room_id")
        private Long roomId;

        @JSONField(name = "msg_abandon")
        private Boolean msgAbandon;

        @JSONField(name = "high_priority")
        private Boolean highPriority;

        @JSONField(name = "text")
        private String text;

        @JSONField(name = "attachment")
        private Map<?, ?> attachment;

        @JSONField(name = "sub_type")
        private Integer subType;

        public String getMessageClientId() {
            return messageClientId;
        }

        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
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

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public String getSenderNick() {
            return senderNick;
        }

        public void setSenderNick(String senderNick) {
            this.senderNick = senderNick;
        }

        public String getSenderAvatar() {
            return senderAvatar;
        }

        public void setSenderAvatar(String senderAvatar) {
            this.senderAvatar = senderAvatar;
        }

        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }

        public Boolean getMsgAbandon() {
            return msgAbandon;
        }

        public void setMsgAbandon(Boolean msgAbandon) {
            this.msgAbandon = msgAbandon;
        }

        public Boolean getHighPriority() {
            return highPriority;
        }

        public void setHighPriority(Boolean highPriority) {
            this.highPriority = highPriority;
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

        public Integer getSubType() {
            return subType;
        }

        public void setSubType(Integer subType) {
            this.subType = subType;
        }
    }
    
    
    public static class FailMessage {

        @JSONField(name = "failed_account_ids")
        private List<FailedAccountId> failedAccount;

        @JSONField(name = "failed_messages")
        private List<FailedMessage> failedMessages;

        public List<FailedAccountId> getFailedAccount() {
            return failedAccount;
        }

        public void setFailedAccount(List<FailedAccountId> failedAccount) {
            this.failedAccount = failedAccount;
        }

        public List<FailedMessage> getFailedMessages() {
            return failedMessages;
        }

        public void setFailedMessages(List<FailedMessage> failedMessages) {
            this.failedMessages = failedMessages;
        }

        public static class FailedAccountId {

            @JSONField(name = "account_id")
            private String accountId;

            @JSONField(name = "error_code")
            private int errorCode;

            @JSONField(name = "error_msg")
            private String errorMsg;

            public String getAccountId() {
                return accountId;
            }

            public void setAccountId(String accountId) {
                this.accountId = accountId;
            }

            public int getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(int errorCode) {
                this.errorCode = errorCode;
            }

            public String getErrorMsg() {
                return errorMsg;
            }

            public void setErrorMsg(String errorMsg) {
                this.errorMsg = errorMsg;
            }
        }

        public static class FailedMessage {

            @JSONField(name = "message_client_id")
            private String msgId;

            @JSONField(name = "error_msg")
            private String errorMsg;

            @JSONField(name = "error_code")
            private Integer errorCode;

            public String getMsgId() {
                return msgId;
            }

            public void setMsgId(String msgId) {
                this.msgId = msgId;
            }

            public String getErrorMsg() {
                return errorMsg;
            }

            public void setErrorMsg(String errorMsg) {
                this.errorMsg = errorMsg;
            }

            public Integer getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(Integer errorCode) {
                this.errorCode = errorCode;
            }
        }

    }
} 