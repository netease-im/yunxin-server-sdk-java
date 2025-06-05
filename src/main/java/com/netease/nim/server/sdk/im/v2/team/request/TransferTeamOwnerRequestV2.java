package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for transferring team ownership
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/teams/{team_id}/actions/transfer_owner
 */
public class TransferTeamOwnerRequestV2 {
    
    // Not included in JSON - used to construct the URL path
    private String teamId;                         // 必选: 群组 ID，用于构造请求URL，不会包含在请求体中

    @JSONField(name = "team_type")
    private Integer teamType;                      // 必选: 需要转让的群组类型。1：高级群。2：超大群
    
    @JSONField(name = "new_owner_account_id")
    private String newOwnerAccountId;              // 必选: 新群主的 IM 账号 ID
    
    @JSONField(name = "leave")
    private Integer leave;                         // 必选: 转让群主后，原群主是否退出该群组。1：退出。2：不退出，成为普通成员
    
    @JSONField(name = "extension")
    private String extension;                      // 可选: 自定义扩展字段，即自定义的通知字段，JSON 格式，不会持久化。长度上限 512 位字符。该字段仅针对高级群，对超大群无效
    
    /**
     * Default constructor
     */
    public TransferTeamOwnerRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param teamId Team ID
     * @param teamType Team type (1: Advanced team, 2: Super team)
     * @param newOwnerAccountId New owner's account ID
     * @param leave Whether the original owner leaves the team (1: Leave, 2: Stay as a regular member)
     */
    public TransferTeamOwnerRequestV2(String teamId, Integer teamType, String newOwnerAccountId, Integer leave) {
        this.teamId = teamId;
        this.teamType = teamType;
        this.newOwnerAccountId = newOwnerAccountId;
        this.leave = leave;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param teamId Team ID
     * @param teamType Team type (1: Advanced team, 2: Super team)
     * @param newOwnerAccountId New owner's account ID
     * @param leave Whether the original owner leaves the team (1: Leave, 2: Stay as a regular member)
     * @param extension Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     */
    public TransferTeamOwnerRequestV2(String teamId, Integer teamType, String newOwnerAccountId, Integer leave, String extension) {
        this.teamId = teamId;
        this.teamType = teamType;
        this.newOwnerAccountId = newOwnerAccountId;
        this.leave = leave;
        this.extension = extension;
    }
    
    // Getters and Setters
    
    public String getTeamId() {
        return teamId;
    }
    
    public void setTeamId(String teamId) {
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