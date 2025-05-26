package com.netease.nim.im.server.sdk.v2.chatroom_message.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for querying chatroom history messages
 * 
 * API: GET https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/messages
 */
public class QueryChatroomHistoryMessagesRequestV2 {
    
    /**
     * ID of the chatroom
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * ID of the account that sent the messages to query
     */
    @JSONField(name = "sender_id")
    private String senderId;
    
    /**
     * Pagination token for retrieving subsequent pages, null for the first page
     */
    @JSONField(name = "page_token")
    private String pageToken;
    
    /**
     * Maximum number of messages to return per page (max 100)
     */
    @JSONField(name = "limit")
    private Integer limit;
    
    /**
     * Whether to sort messages in descending order by time (default is true)
     */
    @JSONField(name = "descending")
    private Boolean descending;
    
    /**
     * Comma-separated list of message types to filter by (e.g., "0,1,2,3")
     * For example: "0" for text, "1" for image, "2" for audio, etc.
     * Null to query all message types
     */
    @JSONField(name = "message_type")
    private String messageTypes;
    
    /**
     * Default constructor
     */
    public QueryChatroomHistoryMessagesRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId ID of the chatroom
     * @param senderId ID of the account that sent the messages to query
     * @param limit maximum number of messages to return per page (max 100)
     */
    public QueryChatroomHistoryMessagesRequestV2(Long roomId, String senderId, Integer limit) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.limit = limit;
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
     * Get pagination token
     * 
     * @return pagination token
     */
    public String getPageToken() {
        return pageToken;
    }
    
    /**
     * Set pagination token
     * 
     * @param pageToken pagination token
     */
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
    
    /**
     * Get maximum number of messages per page
     * 
     * @return maximum number of messages per page
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * Set maximum number of messages per page
     * 
     * @param limit maximum number of messages per page
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    /**
     * Get whether to sort in descending order
     * 
     * @return whether to sort in descending order
     */
    public Boolean getDescending() {
        return descending;
    }
    
    /**
     * Set whether to sort in descending order
     * 
     * @param descending whether to sort in descending order
     */
    public void setDescending(Boolean descending) {
        this.descending = descending;
    }
    
    /**
     * Get message types filter
     * 
     * @return message types filter
     */
    public String getMessageTypes() {
        return messageTypes;
    }
    
    /**
     * Set message types filter
     * 
     * @param messageTypes message types filter
     */
    public void setMessageTypes(String messageTypes) {
        this.messageTypes = messageTypes;
    }
} 