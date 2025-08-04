package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ListOnlineTeamMembersRequestV2 {
    
    
    private Long teamId;
    
    
    private Integer teamType;
    
    
    public ListOnlineTeamMembersRequestV2() {
    }
    
    
    public ListOnlineTeamMembersRequestV2(Long teamId, Integer teamType) {
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
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
} 