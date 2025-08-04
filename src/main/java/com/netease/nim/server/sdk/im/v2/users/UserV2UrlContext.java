package com.netease.nim.server.sdk.im.v2.users;

/**
 * URL context for User V2 API endpoints
 */
public class UserV2UrlContext {
    

    /**
     * Update user endpoint
     */
    static final String UPDATE_USER = "/im/v2/users/{account_id}";
    
    /**
     * Get user endpoint
     */
    static final String GET_USER = "/im/v2/users/{account_id}";
    
    /**
     * Batch get users endpoint
     */
    static final String BATCH_GET_USERS = "/im/v2/users";
    
    /**
     * Get users online status endpoint
     */
    static final String GET_USERS_ONLINE_STATUS = "/im/v2/users/actions/online_status";
} 