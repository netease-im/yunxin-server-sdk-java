package com.netease.nim.im.server.sdk.v2.team_member.request;

import java.util.List;

/**
 * Request for kicking members from a team
 * 
 * This class encapsulates parameters for the kick team members API.
 * Maximum 10 account IDs can be kicked in a single request.
 */
public class KickTeamMembersRequestV2 {
    
    /**
     * Operator account ID
     * The ID of the user performing the operation
     * Must be the team owner or an admin
     */
    private String operatorId;
    
    /**
     * Team ID
     */
    private Long teamId;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    private Integer teamType;
    
    /**
     * List of account IDs to kick from the team
     * Maximum 10 accounts can be kicked in a single request
     */
    private List<String> kickAccountIds;
    
    /**
     * Custom extension field (JSON format)
     * Maximum 512 characters
     * Only valid for advanced teams
     */
    private String extension;
    
    /**
     * Default constructor
     */
    public KickTeamMembersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param operatorId Operator account ID (must be team owner or admin)
     * @param teamId Team ID
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     * @param kickAccountIds List of account IDs to kick (max 10)
     */
    public KickTeamMembersRequestV2(String operatorId, Long teamId, Integer teamType, 
            List<String> kickAccountIds) {
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.kickAccountIds = kickAccountIds;
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
    
    public List<String> getKickAccountIds() {
        return kickAccountIds;
    }
    
    public void setKickAccountIds(List<String> kickAccountIds) {
        this.kickAccountIds = kickAccountIds;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 