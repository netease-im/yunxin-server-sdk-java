package com.netease.nim.server.sdk.im.v2.chatroom_message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;
import java.util.Map;


public class SendChatroomMessageResponseV2 {
    
    
    @JSONField(name = "message")
    private MessageBody message;
    
    
    @JSONField(name = "failed_list")
    private List<FailedInfo> failedList;
    
    
    public SendChatroomMessageResponseV2() {
    }
    
    
    public MessageBody getMessage() {
        return message;
    }
    
    
    public void setMessage(MessageBody message) {
        this.message = message;
    }
    
    
    public List<FailedInfo> getFailedList() {
        return failedList;
    }
    
    
    public void setFailedList(List<FailedInfo> failedList) {
        this.failedList = failedList;
    }
    
    
    public static class MessageBody {
        
        
        @JSONField(name = "text")
        private String text;
        
        
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
        
        
        @JSONField(name = "attachment")
        private Map<?, ?> attachment;
        
        
        @JSONField(name = "msg_abandon")
        private Boolean msgAbandon;
        
        
        @JSONField(name = "high_priority")
        private Boolean highPriority;

        @JSONField(name = "sub_type")
        private Integer subType;
        
        @JSONField(name = "replay_message")
        private ReplayMessage replayMessage;
        
        public String getText() {
            return text;
        }
        
        
        public void setText(String text) {
            this.text = text;
        }
        
        
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
        
        
        public Map<?, ?> getAttachment() {
            return attachment;
        }
        
        
        public void setAttachment(Map<?, ?> attachment) {
            this.attachment = attachment;
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

        public Integer getSubType() {
            return subType;
        }

        public void setSubType(Integer subType) {
            this.subType = subType;
        }
        
        public ReplayMessage getReplayMessage() {
            return replayMessage;
        }
        
        public void setReplayMessage(ReplayMessage replayMessage) {
            this.replayMessage = replayMessage;
        }
    }
    
    public static class ReplayMessage {
        
        @JSONField(name = "message_client_id")
        private String messageClientId;
        
        @JSONField(name = "create_time")
        private Long createTime;
        
        @JSONField(name = "sender_id")
        private String senderId;
        
        public ReplayMessage() {
        }
        
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
        
        public String getSenderId() {
            return senderId;
        }
        
        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }
    }
    
    public static class FailedInfo {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        
        public FailedInfo() {
        }
        
        
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
} 