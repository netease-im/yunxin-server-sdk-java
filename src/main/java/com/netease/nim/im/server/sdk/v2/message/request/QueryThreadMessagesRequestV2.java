package com.netease.nim.im.server.sdk.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for querying thread messages
 * 
 * API: GET https://open.yunxinapi.com/im/v2/messages/actions/thread_messages
 */
public class QueryThreadMessagesRequestV2 {
    
    private Long beginTime;                 // Required: Begin time in milliseconds
    private Long endTime;                   // Required: End time in milliseconds
    private String pageToken;               // Optional: Page token for pagination
    private Integer limit;                  // Required: Max messages per page, max 100
    private Boolean descending;             // Optional: Sort order, true: ascending by time, false: descending by time
    
    @JSONField(name = "conversation_type")
    private Integer conversationType;       // Required: Thread root message's conversation type (1: P2P, 2: Team, 3: Super Team)
    
    @JSONField(name = "sender_id")
    private String senderId;                // Required: Thread root message's sender ID
    
    @JSONField(name = "receiver_id")
    private String receiverId;              // Required: Thread root message's receiver ID
    
    @JSONField(name = "message_server_id")
    private Long messageServerId;           // Required: Thread root message's server ID
    
    @JSONField(name = "message_client_id")
    private String messageClientId;         // Required: Thread root message's client ID
    
    @JSONField(name = "create_time")
    private Long createTime;                // Required: Thread root message's creation time in milliseconds
    
    /**
     * Default constructor
     */
    public QueryThreadMessagesRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param beginTime Query begin time in milliseconds
     * @param endTime Query end time in milliseconds
     * @param limit Max messages per page
     * @param conversationType Thread root message's conversation type
     * @param senderId Thread root message's sender ID
     * @param receiverId Thread root message's receiver ID
     * @param messageServerId Thread root message's server ID
     * @param messageClientId Thread root message's client ID
     * @param createTime Thread root message's creation time
     */
    public QueryThreadMessagesRequestV2(
            Long beginTime, 
            Long endTime, 
            Integer limit, 
            Integer conversationType, 
            String senderId, 
            String receiverId, 
            Long messageServerId, 
            String messageClientId, 
            Long createTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
        this.conversationType = conversationType;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageServerId = messageServerId;
        this.messageClientId = messageClientId;
        this.createTime = createTime;
    }
    
    // Getters and Setters
    
    public Long getBeginTime() {
        return beginTime;
    }
    
    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }
    
    public Long getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
    
    public String getPageToken() {
        return pageToken;
    }
    
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
    
    public Integer getLimit() {
        return limit;
    }
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    public Boolean getDescending() {
        return descending;
    }
    
    public void setDescending(Boolean descending) {
        this.descending = descending;
    }
    
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