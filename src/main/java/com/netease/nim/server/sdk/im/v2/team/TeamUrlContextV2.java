package com.netease.nim.server.sdk.im.v2.team;

/**
 * URL context for Team V2 APIs
 * 
 * This class holds the endpoint URLs for the Team V2 API operations.
 */
public class TeamUrlContextV2 {
    /**
     * Create Team endpoint
     */
    public static final String CREATE_TEAM = "/im/v2.1/teams";
    
    /**
     * Update Team endpoint
     */
    public static final String UPDATE_TEAM = "/im/v2.1/teams/{team_id}";
    
    /**
     * Disband Team endpoint
     */
    public static final String DISBAND_TEAM = "/im/v2/teams/{team_id}";
    
    /**
     * Batch Query Teams endpoint
     */
    public static final String BATCH_QUERY_TEAMS = "/im/v2/teams";
    
    /**
     * Transfer Team Owner endpoint
     */
    public static final String TRANSFER_OWNER = "/im/v2/teams/{team_id}/actions/transfer_owner";
    
    /**
     * Add Team Manager endpoint
     */
    public static final String ADD_MANAGER = "/im/v2/teams/{team_id}/actions/add_manager";
    
    /**
     * Remove Team Manager endpoint
     */
    public static final String REMOVE_MANAGER = "/im/v2/teams/{team_id}/actions/remove_manager";
    
    /**
     * Get Team Info endpoint
     */
    public static final String GET_TEAM_INFO = "/im/v2.1/teams/{team_id}";
    
    /**
     * List Team Members endpoint
     */
    public static final String LIST_TEAM_MEMBERS = "/im/v2/teams/{team_id}/actions/list_members";
    
    /**
     * List Online Team Members endpoint
     */
    public static final String LIST_ONLINE_TEAM_MEMBERS = "/im/v2/teams/{team_id}/actions/list_online_members";
    
    /**
     * Batch Query Team Online Members Count endpoint
     */
    public static final String BATCH_QUERY_TEAM_ONLINE_MEMBERS_COUNT = "/im/v2/teams/actions/online_members_count";
} 