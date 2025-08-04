package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ListTeamMembersRequestV2 {
    
    // Not included in JSON - used to construct the URL path
    private Long teamId;
    
    
    private Integer teamType;
    
    
    private Integer memberType;
    
    
    private Integer chatBannedType;
    
    
    private Boolean descending;
    
    
    private String pageToken;
    
    
    private Integer limit;
    
    
    public ListTeamMembersRequestV2() {
    }
    
    
    public ListTeamMembersRequestV2(Long teamId, Integer teamType) {
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