package com.netease.nim.server.sdk.im.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class UpdateTeamMemberResponseV2 {
    
    @JSONField(name = "team_id")
    private Long teamId;
    
    @JSONField(name = "member_role")
    private Integer memberRole;
    
    @JSONField(name = "account_id")
    private String accountId;
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    @JSONField(name = "team_nick")
    private String teamNick;
    
    @JSONField(name = "server_extension")
    private String serverExtension;
    
    @JSONField(name = "join_time")
    private Long joinTime;
    
    @JSONField(name = "update_time")
    private Long updateTime;

    @JSONField(name="invitor_account_id")
    private String invitorAccountId;
    // Getters and Setters
    
    public Long getTeamId() {
        return teamId;
    }
    
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public Integer getMemberRole() {
        return memberRole;
    }
    
    public void setMemberRole(Integer memberRole) {
        this.memberRole = memberRole;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    public String getTeamNick() {
        return teamNick;
    }
    
    public void setTeamNick(String teamNick) {
        this.teamNick = teamNick;
    }
    
    public String getServerExtension() {
        return serverExtension;
    }
    
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }
    
    public Long getJoinTime() {
        return joinTime;
    }
    
    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }
    
    public Long getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        return "UpdateTeamMemberResponseV2{" +
                "teamId=" + teamId +
                ", memberRole=" + memberRole +
                ", accountId='" + accountId + '\'' +
                ", chatBanned=" + chatBanned +
                ", teamNick='" + teamNick + '\'' +
                ", serverExtension='" + serverExtension + '\'' +
                ", joinTime=" + joinTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getInvitorAccountId() {
        return invitorAccountId;
    }

    public void setInvitorAccountId(String invitorAccountId) {
        this.invitorAccountId = invitorAccountId;
    }
}