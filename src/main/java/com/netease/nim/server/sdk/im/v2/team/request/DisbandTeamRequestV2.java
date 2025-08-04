package com.netease.nim.server.sdk.im.v2.team.request;




public class DisbandTeamRequestV2 {
    
    // Not included in JSON - used to construct the URL path
    private Long teamId;
    
    
    private String operatorId;
    
    
    private Integer teamType;
    
    
    private String extension;
    
    
    public DisbandTeamRequestV2() {
    }
    
    
    public DisbandTeamRequestV2(Long teamId, Integer teamType) {
        this.teamId = teamId;
        this.teamType = teamType;
    }
    
    // Getters and Setters
    
    public Long getTeamId() {
        return teamId;
    }
    
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
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