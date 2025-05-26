package com.netease.nim.im.server.sdk.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for updating team member information
 * 
 * This class represents the response containing the updated team member information.
 */
public class UpdateTeamMemberResponseV2 {
    
    /**
     * Member role in the team
     * 0: Owner
     * 1: Admin
     * 2: Regular member
     */
    @JSONField(name = "member_role")
    private Integer memberRole;
    
    /**
     * Account ID of the team member
     */
    @JSONField(name = "account_id")
    private String accountId;
    
    /**
     * Whether the member is banned from chatting in the team
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * Account ID of the user who invited this member to the team
     */
    @JSONField(name = "invitor_account_id")
    private String invitorAccountId;
    
    /**
     * Member nickname in the team
     */
    @JSONField(name = "team_nick")
    private String teamNick;
    
    /**
     * Timestamp when the member information was created
     */
    @JSONField(name = "create_time")
    private Long createTime;
    
    /**
     * Timestamp when the member information was last updated
     */
    @JSONField(name = "update_time")
    private Long updateTime;
    
    // Getters and Setters
    
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
    
    public String getInvitorAccountId() {
        return invitorAccountId;
    }
    
    public void setInvitorAccountId(String invitorAccountId) {
        this.invitorAccountId = invitorAccountId;
    }
    
    public String getTeamNick() {
        return teamNick;
    }
    
    public void setTeamNick(String teamNick) {
        this.teamNick = teamNick;
    }
    
    public Long getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    
    public Long getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
} 