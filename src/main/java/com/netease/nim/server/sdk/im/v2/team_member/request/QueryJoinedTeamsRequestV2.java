package com.netease.nim.server.sdk.im.v2.team_member.request;

/**
 * Request for querying an account's joined teams
 * 
 * This class encapsulates parameters for the query joined teams API.
 * It allows retrieving the detailed information of teams an account has joined.
 */
public class QueryJoinedTeamsRequestV2 {
    
    /**
     * Account ID
     * The ID of the user whose joined teams will be queried
     */
    private String accountId;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    private Integer teamType;
    
    /**
     * Page token for pagination
     * If empty, the query starts from the first page
     */
    private String pageToken;
    
    /**
     * Maximum number of teams to return per page
     * Maximum value is 100
     */
    private Integer limit;
    
    /**
     * Whether to return the user's membership information for each team
     * 0 (default): Do not return member info
     * 1: Return member info
     */
    private Integer needReturnMemberInfo;
    
    /**
     * Default constructor
     */
    public QueryJoinedTeamsRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param accountId Account ID whose joined teams will be queried
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     */
    public QueryJoinedTeamsRequestV2(String accountId, Integer teamType) {
        this.accountId = accountId;
        this.teamType = teamType;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param accountId Account ID whose joined teams will be queried
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     * @param pageToken Page token for pagination
     * @param limit Maximum number of teams to return per page (max 100)
     * @param needReturnMemberInfo Whether to return member info (0 or 1)
     */
    public QueryJoinedTeamsRequestV2(String accountId, Integer teamType, 
            String pageToken, Integer limit, Integer needReturnMemberInfo) {
        this.accountId = accountId;
        this.teamType = teamType;
        this.pageToken = pageToken;
        this.limit = limit;
        this.needReturnMemberInfo = needReturnMemberInfo;
    }
    
    // Getters and Setters
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
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
    
    public Integer getNeedReturnMemberInfo() {
        return needReturnMemberInfo;
    }
    
    public void setNeedReturnMemberInfo(Integer needReturnMemberInfo) {
        this.needReturnMemberInfo = needReturnMemberInfo;
    }
} 