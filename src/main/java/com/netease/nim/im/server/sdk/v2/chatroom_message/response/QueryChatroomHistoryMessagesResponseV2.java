package com.netease.nim.im.server.sdk.v2.chatroom_message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying chatroom history messages
 * 
 * API: GET https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/messages
 */
public class QueryChatroomHistoryMessagesResponseV2 {
    
    /**
     * Whether there are more messages to retrieve in subsequent pages
     */
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    /**
     * Token for retrieving the next page of messages, null if there are no more pages
     */
    @JSONField(name = "next_token")
    private String nextToken;
    
    /**
     * List of history messages
     */
    @JSONField(name = "items")
    private List<MessageItem> items;
    
    /**
     * Default constructor
     */
    public QueryChatroomHistoryMessagesResponseV2() {
    }
    
    /**
     * Get whether there are more messages to retrieve
     * 
     * @return true if there are more messages, false otherwise
     */
    public Boolean getHasMore() {
        return hasMore;
    }
    
    /**
     * Set whether there are more messages to retrieve
     * 
     * @param hasMore true if there are more messages, false otherwise
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    /**
     * Get token for retrieving the next page of messages
     * 
     * @return next page token, null if there are no more pages
     */
    public String getNextToken() {
        return nextToken;
    }
    
    /**
     * Set token for retrieving the next page of messages
     * 
     * @param nextToken next page token
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    /**
     * Get list of history messages
     * 
     * @return list of history messages
     */
    public List<MessageItem> getItems() {
        return items;
    }
    
    /**
     * Set list of history messages
     * 
     * @param items list of history messages
     */
    public void setItems(List<MessageItem> items) {
        this.items = items;
    }
    
    /**
     * Represents a chatroom historical message item
     */
    public static class MessageItem {
        
        /**
         * ID of the account that sent the message
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
         * 5: Notification
         * 6: File message
         * 10: Tip message
         * 11: Robot message
         * 100: Custom message
         */
        @JSONField(name = "message_type")
        private Integer messageType;
        
        /**
         * Message creation timestamp (Unix timestamp in milliseconds)
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Client message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;
        
        /**
         * Client type of the message sender
         * 1: Android
         * 2: iOS
         * 4: PC
         * 16: Web
         * 32: REST
         * 64: MAC
         */
        @JSONField(name = "sender_client_type")
        private Integer senderClientType;
        
        /**
         * Text content for text/tip messages or description for other message types
         * This field can be used for cloud history message keyword search
         */
        @JSONField(name = "text")
        private String text;
        
        /**
         * Properties for non-text/tip messages or custom message content
         */
        @JSONField(name = "attachment")
        private Object attachment;
        
        /**
         * Extension field passed when sending the message
         */
        @JSONField(name = "extension")
        private String extension;
        
        /**
         * Default constructor
         */
        public MessageItem() {
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
         * Get sender client type
         * 
         * @return sender client type
         */
        public Integer getSenderClientType() {
            return senderClientType;
        }
        
        /**
         * Set sender client type
         * 
         * @param senderClientType sender client type
         */
        public void setSenderClientType(Integer senderClientType) {
            this.senderClientType = senderClientType;
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
        
        /**
         * Get extension field
         * 
         * @return extension field
         */
        public String getExtension() {
            return extension;
        }
        
        /**
         * Set extension field
         * 
         * @param extension extension field
         */
        public void setExtension(String extension) {
            this.extension = extension;
        }
    }
} 