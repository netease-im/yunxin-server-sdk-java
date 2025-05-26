package com.netease.nim.im.server.sdk.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response object for sending a message
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
 */
public class SendMessageResponseV2 {

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
     * Sender account ID
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * Conversation type
     * 1: P2P chat
     * 2: Advanced team chat
     * 3: Super team chat
     */
    @JSONField(name = "conversation_type")
    private Integer conversationType;

    /**
     * Receiver account ID or team ID
     */
    @JSONField(name = "receiver_id")
    private String receiverId;

    /**
     * Message creation timestamp (milliseconds)
     */
    @JSONField(name = "create_time")
    private Long createTime;

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
     * Custom message subtype
     */
    @JSONField(name = "sub_type")
    private Integer subType;

    /**
     * Message text content
     */
    @JSONField(name = "text")
    private String text;

    /**
     * Message attachment
     */
    @JSONField(name = "attachment")
    private Object attachment;
    
    /**
     * Thread configuration information
     */
    @JSONField(name = "thread_config")
    private ThreadConfig threadConfig;

    /**
     * Inner class for thread configuration
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
        private Long messageServerId;

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

    public Object getAttachment() {
        return attachment;
    }

    public void setAttachment(Object attachment) {
        this.attachment = attachment;
    }
    
    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }
} 