package com.netease.nim.im.server.sdk.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for listing online team members
 * 
 * This class encapsulates parameters for the list online team members API.
 * Currently, this API only supports advanced teams (team_type = 1).
 */
public class ListOnlineTeamMembersRequestV2 {
    
    /**
     * Team ID
     * This field is not sent in the request body, but is used in the URL path
     */
    private String teamId;
    
    /**
     * Team type
     * Currently, only team_type = 1 (Advanced team) is supported
     */
    private Integer teamType;
    
    /**
     * Default constructor
     */
    public ListOnlineTeamMembersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamId Team ID
     * @param teamType Team type (must be 1 for Advanced team)
     */
    public ListOnlineTeamMembersRequestV2(String teamId, Integer teamType) {
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