package com.netease.nim.im.server.sdk.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for adding team managers
 * 
 * This class represents the request to add team managers in either an advanced team or super team.
 * Only the team owner can add team managers.
 * You can add up to 10 managers in a single call.
 */
public class AddTeamManagersRequestV2 {
    
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
     * Operator ID (Team owner's account ID)
     * Optional field
     */
    @JSONField(name = "operator_id")
    private String operatorId;
    
    /**
     * List of account IDs to add as managers
     * Maximum 10 accounts per request
     */
    @JSONField(name = "managers")
    private List<String> managers;
    
    /**
     * Custom extension field (JSON format)
     * Maximum 512 characters
     * Only valid for advanced teams (teamType = 1)
     */
    @JSONField(name = "extension")
    private String extension;
    
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