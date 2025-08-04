package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Map;


public class SendMessageResponseV2 {

    
    @JSONField(name = "message_server_id")
    private Long messageServerId;

    
    @JSONField(name = "message_client_id")
    private String messageClientId;

    
    @JSONField(name = "sender_id")
    private String senderId;

    
    @JSONField(name = "conversation_type")
    private Integer conversationType;

    
    @JSONField(name = "receiver_id")
    private String receiverId;

    
    @JSONField(name = "create_time")
    private Long createTime;

    
    @JSONField(name = "message_type")
    private Integer messageType;

    
    @JSONField(name = "sub_type")
    private Integer subType;

    
    @JSONField(name = "text")
    private String text;

    
    @JSONField(name = "attachment")
    private Map<?, ?> attachment;
    
    
    @JSONField(name = "thread_config")
    private ThreadConfig threadConfig;

    
    public static class ThreadConfig {
        
        
        @JSONField(name = "thread_root")
        private ThreadMessage threadRoot;

        
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

    
    public static class ThreadMessage {
        
        @JSONField(name = "sender_id")
        private String senderId;

        
        @JSONField(name = "receiver_id")
        private String receiverId;

        
        @JSONField(name = "create_time")
        private Long createTime;

        
        @JSONField(name = "message_server_id")
        private Long messageServerId;

        
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
    }

    // Getters and Setters
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

    public Map<?, ?> getAttachment() {
        return attachment;
    }

    public void setAttachment(Map<?, ?> attachment) {
        this.attachment = attachment;
    }
    
    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }
} 