package com.netease.nim.im.server.sdk.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for batch querying online members count in teams
 * 
 * This class encapsulates parameters for the batch query online members count API.
 * Currently, this API only supports advanced teams (team_type = 1).
 * The maximum number of teams that can be queried in a single request is 100.
 */
public class BatchQueryTeamOnlineMembersCountRequestV2 {
    
    /**
     * List of team IDs to query
     * Maximum 100 teams can be queried in a single request
     */
    private List<String> teamIds;
    
    /**
     * Team type
     * Currently, only team_type = 1 (Advanced team) is supported
     */
    private Integer teamType;
    
    /**
     * Default constructor
     */
    public BatchQueryTeamOnlineMembersCountRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamIds List of team IDs to query (max 100)
     * @param teamType Team type (must be 1 for Advanced team)
     */
    public BatchQueryTeamOnlineMembersCountRequestV2(List<String> teamIds, Integer teamType) {
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