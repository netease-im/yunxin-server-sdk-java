package com.netease.nim.server.sdk.im.v2.team_member.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class UpdateTeamMemberRequestV2 {
    
    
    private String accountId;
    
    
    @JSONField(name = "operator_id")
    private String operatorId;
    
    
    @JSONField(name = "team_id")
    private Long teamId;
    
    
    @JSONField(name = "team_type")
    private Integer teamType;
    
    
    @JSONField(name = "team_nick")
    private String teamNick;
    
    
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    
    @JSONField(name = "message_notify_state")
    private Integer messageNotifyState;
    
    
    @JSONField(name = "extension")
    private String extension;
    
    
    @JSONField(name = "server_extension")
    private String serverExtension;
    
    
    public UpdateTeamMemberRequestV2() {
    }
    
    
    public UpdateTeamMemberRequestV2(String accountId, String operatorId, Long teamId, Integer teamType) {
        this.accountId = accountId;
        this.operatorId = operatorId;
        this.teamId = teamId;
        this.teamType = teamType;
    }
    
    // Getters and Setters
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
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
    
    public String getTeamNick() {
        return teamNick;
    }
    
    public void setTeamNick(String teamNick) {
        this.teamNick = teamNick;
    }
    
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    public Integer getMessageNotifyState() {
        return messageNotifyState;
    }
    
    public void setMessageNotifyState(Integer messageNotifyState) {
        this.messageNotifyState = messageNotifyState;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public String getServerExtension() {
        return serverExtension;
    }
    
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }
} 