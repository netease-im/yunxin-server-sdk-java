package com.netease.nim.server.sdk.im.v2.team_member.request;

import java.util.List;


public class KickTeamMembersRequestV2 {
    
    
    private String operatorId;
    
    
    private Long teamId;
    
    
    private Integer teamType;
    
    
    private List<String> kickAccountIds;
    
    
    private String extension;
    
    
    public KickTeamMembersRequestV2() {
    }
    
    
    public KickTeamMembersRequestV2(String operatorId, Long teamId, Integer teamType, 
            List<String> kickAccountIds) {
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.kickAccountIds = kickAccountIds;
    }
    
    // Getters and Setters
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
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
    
    public List<String> getKickAccountIds() {
        return kickAccountIds;
    }
    
    public void setKickAccountIds(List<String> kickAccountIds) {
        this.kickAccountIds = kickAccountIds;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 