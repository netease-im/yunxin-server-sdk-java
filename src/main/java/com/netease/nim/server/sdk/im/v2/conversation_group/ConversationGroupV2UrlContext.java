package com.netease.nim.server.sdk.im.v2.conversation_group;

/**
 * URL context for Conversation Group V2 API endpoints
 */
public class ConversationGroupV2UrlContext {
    
    /**
     * Create conversation group endpoint
     */
    static final String CREATE_CONVERSATION_GROUP = "/im/v2/conversation_groups";
    
    /**
     * Update conversation group endpoint
     */
    static final String UPDATE_CONVERSATION_GROUP = "/im/v2/conversation_groups/{group_id}";
    
    /**
     * Delete conversation group endpoint
     */
    static final String DELETE_CONVERSATION_GROUP = "/im/v2/conversation_groups/{group_id}";
    
    /**
     * Get conversation group endpoint
     */
    static final String GET_CONVERSATION_GROUP = "/im/v2/conversation_groups/{group_id}";
    
    /**
     * Batch get conversation groups endpoint
     */
    static final String BATCH_GET_CONVERSATION_GROUPS = "/im/v2/conversation_groups/actions/group_ids";
    
    /**
     * List all conversation groups endpoint
     */
    static final String LIST_ALL_CONVERSATION_GROUPS = "/im/v2/conversation_groups";
} 