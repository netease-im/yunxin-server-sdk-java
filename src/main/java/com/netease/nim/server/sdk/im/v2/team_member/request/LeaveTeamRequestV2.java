package com.netease.nim.server.sdk.im.v2.team_member.request;


public class LeaveTeamRequestV2 {
    
    
    private String accountId;
    
    
    private Long teamId;
    
    
    private Integer teamType;
    
    
    private String extension;
    
    
    public LeaveTeamRequestV2() {
    }
    
    
    public LeaveTeamRequestV2(String accountId, Long teamId, Integer teamType) {
        this.accountId = accountId;
        this.teamId = teamId;
        this.teamType = teamType;
    }
    
    
    public LeaveTeamRequestV2(String accountId, Long teamId, Integer teamType, String extension) {
        this.accountId = accountId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.extension = extension;
    }
    
    // Getters and Setters
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public Long getTeamId() {
        return teamId;
    }
    
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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