package com.netease.nim.im.server.sdk.v2.message.request;

/**
 * Request for querying conversation messages with pagination
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
 */
public class QueryConversationMessagesRequestV2 {
    
    private String conversationId;          // Required: Conversation ID
    private Long beginTime;                 // Required: Begin time in milliseconds
    private Long endTime;                   // Required: End time in milliseconds
    private String pageToken;               // Optional: Page token for pagination
    private Integer limit;                  // Required: Max messages per page, max 100
    private Boolean descending;             // Optional: Sort order, true: ascending by time, false: descending by time
    private String messageType;             // Optional: Comma-separated message types
    private Boolean checkTeamValid;         // Optional: Check if team exists and user is a valid member, default true
    private Boolean includeNoSenseMsg;      // Optional: Include no sense messages, default false
    
    /**
     * Default constructor
     */
    public QueryConversationMessagesRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param conversationId Conversation ID
     * @param beginTime Begin time in milliseconds
     * @param endTime End time in milliseconds
     * @param limit Max messages per page
     */
    public QueryConversationMessagesRequestV2(String conversationId, Long beginTime, Long endTime, Integer limit) {
        this.conversationId = conversationId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
    }
    
    // Getters and Setters
    
    public String getConversationId() {
        return conversationId;
    }
    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    
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
    
    public String getMessageType() {
        return messageType;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    
    /**
     * Set comma-separated message types
     * 
     * @param types array of message type integers
     */
    public void setMessageTypeFromArray(int[] types) {
        if (types == null || types.length == 0) {
            this.messageType = null;
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.length; i++) {
            sb.append(types[i]);
            if (i < types.length - 1) {
                sb.append(",");
            }
        }
        this.messageType = sb.toString();
    }
    
    public Boolean getCheckTeamValid() {
        return checkTeamValid;
    }
    
    public void setCheckTeamValid(Boolean checkTeamValid) {
        this.checkTeamValid = checkTeamValid;
    }
    
    public Boolean getIncludeNoSenseMsg() {
        return includeNoSenseMsg;
    }
    
    public void setIncludeNoSenseMsg(Boolean includeNoSenseMsg) {
        this.includeNoSenseMsg = includeNoSenseMsg;
    }
} 