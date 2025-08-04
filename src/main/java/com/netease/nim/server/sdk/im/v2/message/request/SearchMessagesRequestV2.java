package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.annotation.JSONField;

import java.util.ArrayList;

/**
 * Request for searching messages
 * 
 * API: GET https://open.yunxinapi.com/im/v2/messages/actions/search_messages
 */
public class SearchMessagesRequestV2 {
    
    @JSONField(name = "operator_id")
    private String operatorId;            // Required: Operator account ID
    
    @JSONField(name = "conversation_id")
    private String conversationId;        // Optional: Conversation ID to search in
    
    @JSONField(name = "sender_account_ids")
    private String senderAccountIds;      // Optional: Comma-separated sender account IDs, max 5
    
    @JSONField(name = "message_types")
    private String messageTypes;          // Optional: Comma-separated message types
    
    @JSONField(name = "message_sub_types")
    private String messageSubTypes;       // Optional: Comma-separated message sub-types
    
    @JSONField(name = "start_time")
    private Long startTime;               // Optional: Start time in milliseconds
    
    @JSONField(name = "time_period")
    private Long timePeriod;              // Optional: Time period in milliseconds from start time
    
    @JSONField(name = "keyword_list")
    private ArrayList<String> keywordList;         // Optional: Array of keywords, max 5
    
    @JSONField(name = "keyword_match_type")
    private Integer keywordMatchType;     // Optional: 0 for OR, 1 for AND
    
    @JSONField(name = "page_token")
    private String pageToken;             // Optional: Page token for pagination
    
    @JSONField(name = "limit")
    private Integer limit;                // Optional: Max number of results, max 100
    
    /**
     * 检索方向。0（默认）：从新到旧；1：从旧到新。
     */
    @JSONField(name = "direction")
    private Integer direction;
    
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
        if (keywordList == null || keywordList.isEmpty()) {
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
    
    public ArrayList<String> getKeywordList() {
        return keywordList;
    }
    
    public void setKeywordList(ArrayList<String> keywordList) {
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

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
} 