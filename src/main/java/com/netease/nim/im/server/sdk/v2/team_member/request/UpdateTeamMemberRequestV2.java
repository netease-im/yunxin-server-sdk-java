package com.netease.nim.im.server.sdk.v2.team_member.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for updating team member information
 * 
 * This class encapsulates parameters for the update team member API.
 * It allows updating a team member's nickname, chat banned status,
 * message notification settings, and other information.
 */
public class UpdateTeamMemberRequestV2 {
    
    /**
     * Account ID of the team member to update
     * This is used in the URL path and not sent in the request body
     */
    private String accountId;
    
    /**
     * Operator account ID
     * The ID of the user performing the operation (must be team owner or admin)
     */
    @JSONField(name = "operator_id")
    private String operatorId;
    
    /**
     * Team ID
     */
    @JSONField(name = "team_id")
    private Long teamId;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    @JSONField(name = "team_type")
    private Integer teamType;
    
    /**
     * Member nickname in the team
     * This nickname is only effective in this team and doesn't affect other groups
     */
    @JSONField(name = "team_nick")
    private String teamNick;
    
    /**
     * Whether the member is banned from chatting in the team
     * false (default): Not banned
     * true: Banned
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * How this member is notified of new team messages
     * 0: No notifications (Do not disturb)
     * 1: Notify for all messages
     * 2: Only notify for messages from owner and managers
     */
    @JSONField(name = "message_notify_state")
    private Integer messageNotifyState;
    
    /**
     * Custom extension field (JSON format)
     * Maximum 512 characters
     * Only valid for advanced teams
     * This field is not persisted
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Server custom extension field (JSON format)
     * This field is persisted
     */
    @JSONField(name = "server_extension")
    private String serverExtension;
    
    /**
     * Default constructor
     */
    public UpdateTeamMemberRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param accountId ID of the team member to update
     * @param operatorId Operator account ID (must be team owner or admin)
     * @param teamId Team ID
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     */
    public UpdateTeamMemberRequestV2(String accountId, String operatorId, Long teamId, Integer teamType) {
        this.accountId = accountId;
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
    }
    
    // Getters and Setters
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public Long getTeamId() {
        return teamId;
    }
    
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
    
    public String getTeamNick() {
        return teamNick;
    }
    
    public void setTeamNick(String teamNick) {
        this.teamNick = teamNick;
    }
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    public Integer getMessageNotifyState() {
        return messageNotifyState;
    }
    
    public void setMessageNotifyState(Integer messageNotifyState) {
        this.messageNotifyState = messageNotifyState;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public String getServerExtension() {
        return serverExtension;
    }
    
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }
} 