package com.netease.nim.im.server.sdk.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for querying team message read receipt details
 * 
 * API: GET https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
 * 
 * This API allows you to query read/unread details for a specific message in an advanced team,
 * including the number of users who have read or not read the message, and optionally the list
 * of those users' account IDs.
 * 
 * Notes:
 * - This API only supports advanced teams (team_type=1)
 * - The team read receipt feature must be enabled in the Yunxin console before using this API
 */
public class QueryTeamReadReceiptRequestV2 {

    @JSONField(name = "team_id")
    private String teamId;              // ID of the advanced team
    
    @JSONField(name = "team_type")
    private Integer teamType;           // Team type, currently only supports 1 (advanced team)
    
    @JSONField(name = "sender_id")
    private String senderId;            // Account ID of the message sender
    
    @JSONField(name = "message_server_id")
    private Long messageServerId;       // Server ID of the message to query
    
    @JSONField(name = "snapshot")
    private Boolean snapshot;           // Whether to return account ID lists of read/unread members
    
    /**
     * Default constructor
     */
    public QueryTeamReadReceiptRequestV2() {
    }
    
    /**
     * Construct a team read receipt query request
     * 
     * @param teamId ID of the advanced team
     * @param senderId Account ID of the message sender
     * @param messageServerId Server ID of the message to query
     */
    public QueryTeamReadReceiptRequestV2(String teamId, String senderId, Long messageServerId) {
        this.teamId = teamId;
        this.teamType = 1;  // Currently only supports advanced team
        this.senderId = senderId;
        this.messageServerId = messageServerId;
        this.snapshot = false;  // Default to not returning account ID lists
    }
    
    /**
     * Construct a team read receipt query request with snapshot option
     * 
     * @param teamId ID of the advanced team
     * @param senderId Account ID of the message sender
     * @param messageServerId Server ID of the message to query
     * @param snapshot Whether to return account ID lists of read/unread members
     */
    public QueryTeamReadReceiptRequestV2(String teamId, String senderId, Long messageServerId, Boolean snapshot) {
        this.teamId = teamId;
        this.teamType = 1;  // Currently only supports advanced team
        this.senderId = senderId;
        this.messageServerId = messageServerId;
        this.snapshot = snapshot;
    }
    
    // Getters and setters
    
    public String getTeamId() {
        return teamId;
    }
    
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
    
    public String getSenderId() {
        return senderId;
    }
    
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    
    public Long getMessageServerId() {
        return messageServerId;
    }
    
    public void setMessageServerId(Long messageServerId) {
        this.messageServerId = messageServerId;
    }
    
    public Boolean getSnapshot() {
        return snapshot;
    }
    
    public void setSnapshot(Boolean snapshot) {
        this.snapshot = snapshot;
    }
} 