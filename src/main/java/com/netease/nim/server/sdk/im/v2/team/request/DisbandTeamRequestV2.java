package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for disbanding a team
 * 
 * This class encapsulates parameters for the disband team API.
 * Only the team owner can disband a team.
 */
public class DisbandTeamRequestV2 {
    
    /**
     * Team ID
     * This field is not sent in the request body, but is used in the URL path
     */
    private String teamId;
    
    /**
     * Operator ID (optional)
     * The account ID of the operator (must be team owner)
     */
    @JSONField(name = "operator_id")
    private String operatorId;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    @JSONField(name = "team_type")
    private Integer teamType;
    
    /**
     * Extension field (optional)
     * Custom extension field, JSON format, max 512 chars
     * Only valid for advanced teams (team_type=1)
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Default constructor
     */
    public DisbandTeamRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamId Team ID
     * @param teamType Team type (1: Advanced team, 2: Super team)
     */
    public DisbandTeamRequestV2(String teamId, Integer teamType) {
        this.teamId = teamId;
        this.teamType = teamType;
    }
    
    // Getters and Setters
    
    public String getTeamId() {
        return teamId;
    }
    
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 