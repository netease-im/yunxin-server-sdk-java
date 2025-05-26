package com.netease.nim.im.server.sdk.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for querying a single message details
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
 */
public class QueryMessageRequestV2 {

    private String conversationId;        // Conversation ID
    private Long messageServerId;         // Server message ID
    
    @JSONField(name = "message_time")
    private Long messageTime;             // Message sending timestamp
    
    @JSONField(name = "check_team_valid")
    private Boolean checkTeamValid;       // Whether to check team validity
    
    @JSONField(name = "check_team_member_valid")
    private Boolean checkTeamMemberValid; // Whether to check team member validity
    
    /**
     * Default constructor
     */
    public QueryMessageRequestV2() {
    }
    
    /**
     * Construct a query message request with required parameters
     * 
     * @param conversationId Conversation ID
     * @param messageServerId Server message ID
     */
    public QueryMessageRequestV2(String conversationId, Long messageServerId) {
        this.conversationId = conversationId;
        this.messageServerId = messageServerId;
    }
    
    /**
     * Construct a query message request with all parameters
     * 
     * @param conversationId Conversation ID
     * @param messageServerId Server message ID
     * @param messageTime Message sending timestamp
     * @param checkTeamValid Whether to check team validity
     * @param checkTeamMemberValid Whether to check team member validity
     */
    public QueryMessageRequestV2(String conversationId, Long messageServerId, Long messageTime, 
            Boolean checkTeamValid, Boolean checkTeamMemberValid) {
        this.conversationId = conversationId;
        this.messageServerId = messageServerId;
        this.messageTime = messageTime;
        this.checkTeamValid = checkTeamValid;
        this.checkTeamMemberValid = checkTeamMemberValid;
    }
    
    // Getters and setters
    
    public String getConversationId() {
        return conversationId;
    }
    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    
    public Long getMessageServerId() {
        return messageServerId;
    }
    
    public void setMessageServerId(Long messageServerId) {
        this.messageServerId = messageServerId;
    }
    
    public Long getMessageTime() {
        return messageTime;
    }
    
    public void setMessageTime(Long messageTime) {
        this.messageTime = messageTime;
    }
    
    public Boolean getCheckTeamValid() {
        return checkTeamValid;
    }
    
    public void setCheckTeamValid(Boolean checkTeamValid) {
        this.checkTeamValid = checkTeamValid;
    }
    
    public Boolean getCheckTeamMemberValid() {
        return checkTeamMemberValid;
    }
    
    public void setCheckTeamMemberValid(Boolean checkTeamMemberValid) {
        this.checkTeamMemberValid = checkTeamMemberValid;
    }
} 