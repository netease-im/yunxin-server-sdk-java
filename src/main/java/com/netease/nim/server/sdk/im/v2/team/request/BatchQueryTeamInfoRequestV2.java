package com.netease.nim.server.sdk.im.v2.team.request;

import java.util.List;

/**
 * Request for batch querying team information
 * 
 * This class encapsulates parameters for the batch query team info API.
 */
public class BatchQueryTeamInfoRequestV2 {
    
    /**
     * List of team IDs to query
     * For advanced teams, maximum 30 teams per request
     * For super teams, maximum 20 teams per request
     */
    private List<String> teamIds;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    private Integer teamType;
    
    /**
     * Default constructor
     */
    public BatchQueryTeamInfoRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamIds List of team IDs to query
     * @param teamType Team type (1: Advanced team, 2: Super team)
     */
    public BatchQueryTeamInfoRequestV2(List<String> teamIds, Integer teamType) {
        this.teamIds = teamIds;
        this.teamType = teamType;
    }
    
    // Getters and Setters
    
    public List<String> getTeamIds() {
        return teamIds;
    }
    
    public void setTeamIds(List<String> teamIds) {
        this.teamIds = teamIds;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
} 