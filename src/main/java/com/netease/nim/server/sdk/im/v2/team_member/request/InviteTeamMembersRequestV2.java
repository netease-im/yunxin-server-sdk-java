package com.netease.nim.server.sdk.im.v2.team_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for inviting members to a team
 * 
 * This class encapsulates parameters for the invite team members API.
 * Maximum 200 account IDs can be invited in a single request.
 */
public class InviteTeamMembersRequestV2 {
    
    /**
     * Operator account ID
     * The ID of the user performing the operation
     * This must be the owner or admin if invite_mode is 0,
     * or any team member if invite_mode is 1
     */
    @JSONField(name = "operator_id")
    private String operatorId;
    
    /**
     * Team ID
     */
    @JSONField(name = "team_id")
    private Long teamId;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    @JSONField(name = "team_type")
    private Integer teamType;
    
    /**
     * List of account IDs to invite
     * Maximum 200 accounts can be invited in a single request
     */
    @JSONField(name = "invite_account_ids")
    private List<String> inviteAccountIds;
    
    /**
     * Invitation message
     * Maximum 150 characters
     */
    @JSONField(name = "msg")
    private String msg;
    
    /**
     * Custom extension field (JSON format)
     * Maximum 512 characters
     * Only valid for advanced teams
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Default constructor
     */
    public InviteTeamMembersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param operatorId Operator account ID
     * @param teamId Team ID
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     * @param inviteAccountIds List of account IDs to invite
     * @param msg Invitation message
     */
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