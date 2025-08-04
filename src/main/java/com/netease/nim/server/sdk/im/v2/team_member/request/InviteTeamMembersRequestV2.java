package com.netease.nim.server.sdk.im.v2.team_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class InviteTeamMembersRequestV2 {
    
    
    @JSONField(name = "operator_id")
    private String operatorId;
    
    
    @JSONField(name = "team_id")
    private Long teamId;
    
    
    @JSONField(name = "team_type")
    private Integer teamType;
    
    
    @JSONField(name = "invite_account_ids")
    private List<String> inviteAccountIds;
    
    
    @JSONField(name = "msg")
    private String msg;
    
    
    @JSONField(name = "extension")
    private String extension;
    
    
    public InviteTeamMembersRequestV2() {
    }
    
    
    public InviteTeamMembersRequestV2(String operatorId, Long teamId, Integer teamType, 
            List<String> inviteAccountIds, String msg) {
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.inviteAccountIds = inviteAccountIds;
        this.msg = msg;
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
    
    public List<String> getInviteAccountIds() {
        return inviteAccountIds;
    }
    
    public void setInviteAccountIds(List<String> inviteAccountIds) {
        this.inviteAccountIds = inviteAccountIds;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 