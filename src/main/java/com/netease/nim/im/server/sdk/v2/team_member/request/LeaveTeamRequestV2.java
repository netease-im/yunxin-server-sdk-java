package com.netease.nim.im.server.sdk.v2.team_member.request;

/**
 * Request for leaving a team
 * 
 * This class encapsulates parameters for the leave team API.
 * Any team member except the owner can leave a team voluntarily.
 * Team owners must transfer ownership before leaving.
 */
public class LeaveTeamRequestV2 {
    
    /**
     * Account ID of the user who wants to leave the team
     */
    private String accountId;
    
    /**
     * Team ID
     */
    private Long teamId;
    
    /**
     * Team type
     * 1: Advanced team
     * 2: Super team
     */
    private Integer teamType;
    
    /**
     * Custom extension field (JSON format)
     * Maximum 512 characters
     * Only valid for advanced teams
     */
    private String extension;
    
    /**
     * Default constructor
     */
    public LeaveTeamRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param accountId Account ID of the user who wants to leave the team
     * @param teamId Team ID
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     */
    public LeaveTeamRequestV2(String accountId, Long teamId, Integer teamType) {
        this.accountId = accountId;
        this.teamId = teamId;
        this.teamType = teamType;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param accountId Account ID of the user who wants to leave the team
     * @param teamId Team ID
     * @param teamType Team type (1 for Advanced team, 2 for Super team)
     * @param extension Custom extension field (JSON format, max 512 chars, only for advanced teams)
     */
    public LeaveTeamRequestV2(String accountId, Long teamId, Integer teamType, String extension) {
        this.accountId = accountId;
        this.teamId = teamId;
        this.teamType = teamType;
        this.extension = extension;
    }
    
    // Getters and Setters
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
} 