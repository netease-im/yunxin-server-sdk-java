package com.netease.nim.im.server.sdk.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for getting team information
 * 
 * This class encapsulates parameters for the team info API.
 */
public class GetTeamInfoRequestV2 {
    
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
    private Integer teamType;
    
    /**
     * Default constructor
     */
    public GetTeamInfoRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamId Team ID
     * @param teamType Team type (1: Advanced team, 2: Super team)
     */
    public GetTeamInfoRequestV2(String teamId, Integer teamType) {
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
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
} 