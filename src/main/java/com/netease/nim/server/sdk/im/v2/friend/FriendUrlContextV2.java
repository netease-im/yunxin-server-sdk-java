package com.netease.nim.server.sdk.im.v2.friend;

/**
 * URL context for Friend V2 API endpoints
 */
public class FriendUrlContextV2 {
    
    /**
     * Base friend endpoint
     */
    static final String FRIENDS = "/im/v2/friends";
    
    /**
     * Delete friend endpoint
     */
    static final String DELETE_FRIEND = "/im/v2/friends/{account_id}";
    
    /**
     * Update friend endpoint
     */
    static final String UPDATE_FRIEND = "/im/v2/friends/{account_id}";
    
    /**
     * Get friend endpoint
     */
    static final String GET_FRIEND = "/im/v2/friends/{account_id}";
    
    /**
     * List friends endpoint
     */
    static final String LIST_FRIENDS = "/im/v2/friends";
    
    /**
     * Handle friend addition endpoint (accept/reject)
     */
    static final String HANDLE_FRIEND_ADDITION = "/im/v2/friends/actions/handle_friend_addition";
} 