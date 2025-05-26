package com.netease.nim.im.server.sdk.v2.conversation;

/**
 * URL context for Conversation V2 API endpoints
 */
public class ConversationUrlContextV2 {
    
    /**
     * Create conversation endpoint
     */
    static final String CREATE_CONVERSATION = "/im/v2/conversations";
    /**
     * Update conversation endpoint
     */
    static final String UPDATE_CONVERSATION = "/im/v2/conversations/{conversation_id}";
    /**
     * Delete conversation endpoint
     */
    static final String DELETE_CONVERSATION = "/im/v2/conversations/{conversation_id}";
    /**
     * Batch delete conversations endpoint
     */
    static final String BATCH_DELETE_CONVERSATIONS = "/im/v2/conversations/actions/conversation_ids";
    /**
     * Get conversation endpoint
     */
    static final String GET_CONVERSATION = "/im/v2/conversations/{conversation_id}";
    /**
     * Batch get conversations endpoint
     */
    static final String BATCH_GET_CONVERSATIONS = "/im/v2/conversations/actions/conversation_ids";
    /**
     * List conversations endpoint (paginated)
     */
    static final String LIST_CONVERSATIONS = "/im/v2/conversations";
    /**
     * Stick top conversation endpoint
     */
    static final String STICK_TOP_CONVERSATION = "/im/v2/conversations/{conversation_id}/actions/stick_top_conversation";
    /**
     * Get conversation overview endpoint for an account
     */
    static final String OVERVIEWS_CONVERSATION = "/im/v2/conversation_overviews/{account_id}";
    /**
     * Clear conversation unread count endpoint
     */
    static final String CLEAR_CONVERSATION_UNREAD = "/im/v2/conversations/{conversation_id}/actions/clear_conversation_unread";
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
    /**
     * Batch send P2P message endpoint
     */
    static final String BATCH_SEND_P2P_MESSAGE = "/im/v2/conversations/messages";
}