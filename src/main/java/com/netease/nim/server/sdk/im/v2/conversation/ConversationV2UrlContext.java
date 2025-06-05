package com.netease.nim.server.sdk.im.v2.conversation;

/**
 * URL context for Conversation V2 API endpoints
 */
public class ConversationV2UrlContext {
    
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
}