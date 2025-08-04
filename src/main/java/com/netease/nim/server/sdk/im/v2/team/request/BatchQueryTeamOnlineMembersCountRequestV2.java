package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchQueryTeamOnlineMembersCountRequestV2 {
    
    
    private List<Long> teamIds;
    
    
    private Integer teamType;
    
    
    public BatchQueryTeamOnlineMembersCountRequestV2() {
    }
    
    
    public BatchQueryTeamOnlineMembersCountRequestV2(List<Long> teamIds, Integer teamType) {
        this.teamIds = teamIds;
        this.teamType = teamType;
    }
    
    // Getters and Setters
    
    public List<Long> getTeamIds() {
        return teamIds;
    }
    
    public void setTeamIds(List<Long> teamIds) {
        this.teamIds = teamIds;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
} 