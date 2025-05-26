package com.netease.nim.im.server.sdk.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for listing team members
 * 
 * This class encapsulates parameters for the team members listing API.
 */
public class ListTeamMembersRequestV2 {
    
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
     * Member type filter
     * 0: All members (default)
     * 1: Only owner and managers
     * 2: Only regular members
     */
    private Integer memberType;
    
    /**
     * Chat banned filter
     * 0: All members (default)
     * 1: Only banned members
     * 2: Only non-banned members
     */
    private Integer chatBannedType;
    
    /**
     * Sort order by join time
     * true: Descending (newest first)
     * false: Ascending (oldest first, default)
     */
    private Boolean descending;
    
    /**
     * Pagination token for continuing from a previous query
     */
    private String pageToken;
    
    /**
     * Maximum number of members to return per page (max 100)
     */
    private Integer limit;
    
    /**
     * Default constructor
     */
    public ListTeamMembersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamId Team ID
     * @param teamType Team type (1: Advanced team, 2: Super team)
     */
    public ListTeamMembersRequestV2(String teamId, Integer teamType) {
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
    
    public Integer getMemberType() {
        return memberType;
    }
    
    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }
    
    public Integer getChatBannedType() {
        return chatBannedType;
    }
    
    public void setChatBannedType(Integer chatBannedType) {
        this.chatBannedType = chatBannedType;
    }
    
    public Boolean getDescending() {
        return descending;
    }
    
    public void setDescending(Boolean descending) {
        this.descending = descending;
    }
    
    public String getPageToken() {
        return pageToken;
    }
    
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
    
    public Integer getLimit() {
        return limit;
    }
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 