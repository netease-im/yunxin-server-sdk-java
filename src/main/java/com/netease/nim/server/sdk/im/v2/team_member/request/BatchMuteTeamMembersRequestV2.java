package com.netease.nim.server.sdk.im.v2.team_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchMuteTeamMembersRequestV2 {
    
    
    @JSONField(name = "operator_id")
    private String operatorId;
    
    
    @JSONField(name = "team_id")
    private Long teamId;
    
    
    @JSONField(name = "team_type")
    private Integer teamType;
    
    
    @JSONField(name = "chat_ban_account_ids")
    private List<String> chatBanAccountIds;
    
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    
    public BatchMuteTeamMembersRequestV2() {
    }
    
    
    public BatchMuteTeamMembersRequestV2(String operatorId, Long teamId, Integer teamType, 
            List<String> chatBanAccountIds) {
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.chatBanAccountIds = chatBanAccountIds;
    }
    
    
    public BatchMuteTeamMembersRequestV2(String operatorId, Long teamId, Integer teamType, 
            List<String> chatBanAccountIds, Boolean chatBanned) {
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.chatBanAccountIds = chatBanAccountIds;
        this.chatBanned = chatBanned;
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
    
    public List<String> getChatBanAccountIds() {
        return chatBanAccountIds;
    }
    
    public void setChatBanAccountIds(List<String> chatBanAccountIds) {
        this.chatBanAccountIds = chatBanAccountIds;
    }
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
} 