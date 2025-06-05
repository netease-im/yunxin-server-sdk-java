package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.JSONArray;

/**
 * Request for searching messages
 * 
 * API: GET https://open.yunxinapi.com/im/v2/messages/actions/search_messages
 */
public class SearchMessagesRequestV2 {
    
    private String operatorId;            // Required: Operator account ID
    private String conversationId;        // Optional: Conversation ID to search in
    private String senderAccountIds;      // Optional: Comma-separated sender account IDs, max 5
    private String messageTypes;          // Optional: Comma-separated message types
    private String messageSubTypes;       // Optional: Comma-separated message sub-types
    private Long startTime;               // Optional: Start time in milliseconds
    private Long timePeriod;              // Optional: Time period in milliseconds from start time
    private String[] keywordList;         // Optional: Array of keywords, max 5
    private Integer keywordMatchType;     // Optional: 0 for OR, 1 for AND
    private String pageToken;             // Optional: Page token for pagination
    private Integer limit;                // Optional: Max number of results, max 100
    
    /**
     * Default constructor
     */
    public SearchMessagesRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param operatorId Operator account ID
     */
    public SearchMessagesRequestV2(String operatorId) {
        this.operatorId = operatorId;
    }
    
    /**
     * Get keywords as JSON array string
     * 
     * @return JSON array string of keywords
     */
    public String getKeywordListAsJsonString() {
        if (keywordList == null || keywordList.length == 0) {
            return null;
        }
        return JSONArray.toJSONString(keywordList);
    }
    
    // Getters and Setters
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public String getConversationId() {
        return conversationId;
    }
    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    
    public String getSenderAccountIds() {
        return senderAccountIds;
    }
    
    public void setSenderAccountIds(String senderAccountIds) {
        this.senderAccountIds = senderAccountIds;
    }
    
    /**
     * Set comma-separated sender account IDs
     * 
     * @param senderIds array of sender account IDs
     */
    public void setSenderAccountIdsFromArray(String[] senderIds) {
        if (senderIds == null || senderIds.length == 0) {
            this.senderAccountIds = null;
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < senderIds.length; i++) {
            sb.append(senderIds[i]);
            if (i < senderIds.length - 1) {
                sb.append(",");
            }
        }
        this.senderAccountIds = sb.toString();
    }
    
    public String getMessageTypes() {
        return messageTypes;
    }
    
    public void setMessageTypes(String messageTypes) {
        this.messageTypes = messageTypes;
    }
    
    /**
     * Set comma-separated message types
     * 
     * @param types array of message type integers
     */
    public void setMessageTypesFromArray(int[] types) {
        if (types == null || types.length == 0) {
            this.messageTypes = null;
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.length; i++) {
            sb.append(types[i]);
            if (i < types.length - 1) {
                sb.append(",");
            }
        }
        this.messageTypes = sb.toString();
    }
    
    public String getMessageSubTypes() {
        return messageSubTypes;
    }
    
    public void setMessageSubTypes(String messageSubTypes) {
        this.messageSubTypes = messageSubTypes;
    }
    
    /**
     * Set comma-separated message sub-types
     * 
     * @param subTypes array of message sub-type integers
     */
    public void setMessageSubTypesFromArray(int[] subTypes) {
        if (subTypes == null || subTypes.length == 0) {
            this.messageSubTypes = null;
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subTypes.length; i++) {
            sb.append(subTypes[i]);
            if (i < subTypes.length - 1) {
                sb.append(",");
            }
        }
        this.messageSubTypes = sb.toString();
    }
    
    public Long getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    
    public Long getTimePeriod() {
        return timePeriod;
    }
    
    public void setTimePeriod(Long timePeriod) {
        this.timePeriod = timePeriod;
    }
    
    public String[] getKeywordList() {
        return keywordList;
    }
    
    public void setKeywordList(String[] keywordList) {
        this.keywordList = keywordList;
    }
    
    public Integer getKeywordMatchType() {
        return keywordMatchType;
    }
    
    public void setKeywordMatchType(Integer keywordMatchType) {
        this.keywordMatchType = keywordMatchType;
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
} 