package com.netease.nim.server.sdk.im.v2.team_member;

/**
 * URL context for Team Member V2 APIs
 * 
 * This class holds the endpoint URLs for the Team Member V2 API operations.
 */
public class TeamMemberV2UrlContext {
    /**
     * Invite Team Members endpoint
     */
    public static final String INVITE_TEAM_MEMBERS = "/im/v2/team_members";
    
    /**
     * Kick Team Members endpoint
     */
    public static final String KICK_TEAM_MEMBERS = "/im/v2/team_members/actions/kick_member";
    
    /**
     * Leave Team endpoint
     */
    public static final String LEAVE_TEAM = "/im/v2/team_members/actions/leave";
    
    /**
     * Update Team Member endpoint
     */
    public static final String UPDATE_TEAM_MEMBER = "/im/v2.1/team_members/{account_id}";
    
    /**
     * Batch Mute Team Members endpoint
     */
    public static final String BATCH_MUTE_TEAM_MEMBERS = "/im/v2/team_members/actions/batch_mute";
    
    /**
     * Query Joined Teams endpoint
     */
    public static final String JOINED_TEAMS = "/im/v2.1/team_members/{account_id}/actions/joined_teams";
} 