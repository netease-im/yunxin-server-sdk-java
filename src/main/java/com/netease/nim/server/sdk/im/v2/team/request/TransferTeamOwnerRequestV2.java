package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class TransferTeamOwnerRequestV2 {
    
    // Not included in JSON - used to construct the URL path
    private Long teamId;                         // 必选: 群组 ID，用于构造请求URL，不会包含在请求体中

    @JSONField(name = "team_type")
    private Integer teamType;                      // 必选: 需要转让的群组类型。1：高级群。2：超大群
    
    @JSONField(name = "new_owner_account_id")
    private String newOwnerAccountId;              // 必选: 新群主的 IM 账号 ID
    
    @JSONField(name = "leave")
    private Integer leave;                         // 必选: 转让群主后，原群主是否退出该群组。1：退出。2：不退出，成为普通成员
    
    @JSONField(name = "extension")
    private String extension;                      // 可选: 自定义扩展字段，即自定义的通知字段，JSON 格式，不会持久化。长度上限 512 位字符。该字段仅针对高级群，对超大群无效
    
    
    public TransferTeamOwnerRequestV2() {
    }
    
    
    public TransferTeamOwnerRequestV2(Long teamId, Integer teamType, String newOwnerAccountId, Integer leave) {
        this.teamId = teamId;
        this.teamType = teamType;
        this.newOwnerAccountId = newOwnerAccountId;
        this.leave = leave;
    }
    
    
    public TransferTeamOwnerRequestV2(Long teamId, Integer teamType, String newOwnerAccountId, Integer leave, String extension) {
        this.teamId = teamId;
        this.teamType = teamType;
        this.newOwnerAccountId = newOwnerAccountId;
        this.leave = leave;
        this.extension = extension;
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
    
    public String getNewOwnerAccountId() {
        return newOwnerAccountId;
    }
    
    public void setNewOwnerAccountId(String newOwnerAccountId) {
        this.newOwnerAccountId = newOwnerAccountId;
    }
    
    public Integer getLeave() {
        return leave;
    }
    
    public void setLeave(Integer leave) {
        this.leave = leave;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 