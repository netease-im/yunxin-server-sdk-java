package com.netease.nim.im.server.sdk.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request for removing team managers
 * 
 * This class encapsulates parameters for the remove team managers API.
 * Only the team owner can remove managers from a team.
 */
public class RemoveTeamManagersRequestV2 {
    
    /**
     * Team ID
     * This field is not sent in the request body, but is used in the URL path
     */
    private String teamId;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    @JSONField(name = "team_type")
    private Integer teamType;
    
    /**
     * Operator ID (optional)
     * The account ID of the operator (must be team owner)
     */
    @JSONField(name = "operator_id")
    private String operatorId;
    
    /**
     * Managers to remove
     * List of account IDs to remove manager status from (max 10)
     */
    @JSONField(name = "managers")
    private List<String> managers;
    
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
    public RemoveTeamManagersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamId Team ID
     * @param teamType Team type (1: Advanced team, 2: Super team)
     * @param managers List of account IDs to remove manager status from
     */
    public RemoveTeamManagersRequestV2(String teamId, Integer teamType, List<String> managers) {
        this.teamId = teamId;
        this.teamType = teamType;
        this.managers = managers;
    }
    
    // Getters and Setters
    
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
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public List<String> getManagers() {
        return managers;
    }
    
    public void setManagers(List<String> managers) {
        this.managers = managers;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 