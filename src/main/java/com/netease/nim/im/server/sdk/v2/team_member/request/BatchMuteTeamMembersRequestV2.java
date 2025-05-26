package com.netease.nim.im.server.sdk.v2.team_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for batch muting team members
 * 
 * This class encapsulates parameters for the batch mute team members API.
 * It allows muting/unmuting multiple members at once (up to 10).
 */
public class BatchMuteTeamMembersRequestV2 {
    
    /**
     * Operator account ID
     * The ID of the user performing the operation (must be team owner or admin)
     * For advanced teams, only the team owner can batch mute members.
     * For super teams, team owners and admins can mute regular members,
     * but only owners can mute admins.
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
     * List of account IDs to mute/unmute
     * Maximum 10 accounts can be processed in a single request
     */
    @JSONField(name = "chat_ban_account_ids")
    private List<String> chatBanAccountIds;
    
    /**
     * Whether to mute the members
     * true: Mute
     * false (default): Unmute
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * Default constructor
     */
    public BatchMuteTeamMembersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param operatorId Operator account ID (must be team owner or admin)
     * @param teamId Team ID
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     * @param chatBanAccountIds List of account IDs to mute/unmute (max 10)
     */
    public BatchMuteTeamMembersRequestV2(String operatorId, Long teamId, Integer teamType, 
            List<String> chatBanAccountIds) {
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.chatBanAccountIds = chatBanAccountIds;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param operatorId Operator account ID (must be team owner or admin)
     * @param teamId Team ID
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     * @param chatBanAccountIds List of account IDs to mute/unmute (max 10)
     * @param chatBanned Whether to mute (true) or unmute (false)
     */
    public BatchMuteTeamMembersRequestV2(String operatorId, Long teamId, Integer teamType, 
            List<String> chatBanAccountIds, Boolean chatBanned) {
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.chatBanAccountIds = chatBanAccountIds;
        this.chatBanned = chatBanned;
    }
    
    // Getters and Setters
    
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
    
    public List<String> getChatBanAccountIds() {
        return chatBanAccountIds;
    }
    
    public void setChatBanAccountIds(List<String> chatBanAccountIds) {
        this.chatBanAccountIds = chatBanAccountIds;
    }
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
} 