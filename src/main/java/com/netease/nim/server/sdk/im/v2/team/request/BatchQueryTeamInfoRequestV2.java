package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


public class BatchQueryTeamInfoRequestV2 {
    
    @JSONField(name="team_ids")
    private List<Long> teamIds;
    
    @JSONField(name="team_type")
    private Integer teamType;
    
    
    public BatchQueryTeamInfoRequestV2() {
    }
    
    
    public BatchQueryTeamInfoRequestV2(List<Long> teamIds, Integer teamType) {
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