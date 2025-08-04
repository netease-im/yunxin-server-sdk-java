package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


public class RemoveTeamManagersRequestV2 {
    
    // Not included in JSON - used to construct the URL path
    private Long teamId;
    
    
    @JSONField(name = "team_type")
    private Integer teamType;
    
    
    @JSONField(name = "operator_id")
    private String operatorId;
    
    
    @JSONField(name = "managers")
    private List<String> managers;
    
    
    @JSONField(name = "extension")
    private String extension;
    
    
    public RemoveTeamManagersRequestV2() {
    }
    
    
    public RemoveTeamManagersRequestV2(Long teamId, Integer teamType, List<String> managers) {
        this.teamId = teamId;
        this.teamType = teamType;
        this.managers = managers;
    }
    
    // Getters and Setters
    
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
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public List<String> getManagers() {
        return managers;
    }
    
    public void setManagers(List<String> managers) {
        this.managers = managers;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 