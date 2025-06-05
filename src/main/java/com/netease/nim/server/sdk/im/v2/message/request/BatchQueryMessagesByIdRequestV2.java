package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for batch querying messages by message IDs
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/batch_messages
 */
public class BatchQueryMessagesByIdRequestV2 {
    
    private String conversationId;          // Required: Conversation ID
    
    @JSONField(name = "messages")
    private List<MessageQuery> messages;    // Required: List of messages to query
    
    /**
     * Class representing a message query entry
     */
    public static class MessageQuery {
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;      // Required: Message server ID
        
        @JSONField(name = "create_time")
        private Long createTime;           // Required: Message creation time
        
        /**
         * Default constructor
         */
        public MessageQuery() {
        }
        
        /**
         * Constructor with parameters
         * 
         * @param messageServerId Message server ID
         * @param createTime Message creation time
         */
        public MessageQuery(Long messageServerId, Long createTime) {
            this.messageServerId = messageServerId;
            this.createTime = createTime;
        }
        
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
    }
    
    /**
     * Default constructor
     */
    public BatchQueryMessagesByIdRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param conversationId Conversation ID
     * @param messages List of messages to query
     */
    public BatchQueryMessagesByIdRequestV2(String conversationId, List<MessageQuery> messages) {
        this.conversationId = conversationId;
        this.messages = messages;
    }
    
    // Getters and Setters
    
    public String getConversationId() {
        return conversationId;
    }
    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    
    public List<MessageQuery> getMessages() {
        return messages;
    }
    
    public void setMessages(List<MessageQuery> messages) {
        this.messages = messages;
    }
} 