package com.netease.nim.server.sdk.im.v2.team_member.request;


public class QueryJoinedTeamsRequestV2 {
    
    
    private String accountId;
    
    
    private Integer teamType;
    
    
    private String pageToken;
    
    
    private Integer limit;
    
    
    private Integer needReturnMemberInfo;
    
    
    public QueryJoinedTeamsRequestV2() {
    }
    
    
    public QueryJoinedTeamsRequestV2(String accountId, Integer teamType) {
        this.accountId = accountId;
        this.teamType = teamType;
    }
    
    
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