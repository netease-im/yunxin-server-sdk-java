package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;
import java.util.ArrayList;

/**
 * Request for batch querying quick comments on messages
 * 
 * API: POST https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
 */
public class BatchQueryQuickCommentsRequestV2 {
    
    @JSONField(name = "messages")
    private List<Message> messages;
    
    /**
     * Message information for batch query
     */
    public static class Message {
        
        @JSONField(name = "conversation_type")
        private Integer conversationType;   // 必选: 会话类型 (1: 单聊, 2: 高级群, 3: 超大群)
        
        @JSONField(name = "sender_id")
        private String senderId;            // 必选: 消息的发送者 ID
        
        @JSONField(name = "receiver_id")
        private String receiverId;          // 必选: 消息的接收者 ID
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;       // 必选: 消息的服务器 ID
        
        @JSONField(name = "message_client_id")
        private String messageClientId;     // 必选: 消息的客户端 ID
        
        @JSONField(name = "create_time")
        private Long createTime;            // 必选: 消息的发送时间
        
        /**
         * Default constructor
         */
        public Message() {
        }
        
        /**
         * Full constructor
         * 
         * @param conversationType Conversation type (1: P2P, 2: Advanced team, 3: Super team)
         * @param senderId Message sender ID
         * @param receiverId Message receiver ID
         * @param messageServerId Message server ID
         * @param messageClientId Message client ID
         * @param createTime Message creation time
         */
        public Message(Integer conversationType, String senderId, String receiverId, 
                Long messageServerId, String messageClientId, Long createTime) {
            this.conversationType = conversationType;
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.messageServerId = messageServerId;
            this.messageClientId = messageClientId;
            this.createTime = createTime;
        }
        
        // Getters and Setters
        
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
        
        public String getReceiverId() {
            return receiverId;
        }
        
        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
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
        
        public Long getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
    }
    
    /**
     * Default constructor
     */
    public BatchQueryQuickCommentsRequestV2() {
        this.messages = new ArrayList<>();
    }
    
    /**
     * Constructor with messages list
     * 
     * @param messages List of messages to query comments for
     */
    public BatchQueryQuickCommentsRequestV2(List<Message> messages) {
        this.messages = messages;
    }
    
    public void addMessage(Message message) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(message);
    }
    
    // Getters and Setters
    
    public List<Message> getMessages() {
        return messages;
    }
    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
} 