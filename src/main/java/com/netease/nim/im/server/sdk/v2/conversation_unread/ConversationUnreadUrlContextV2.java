package com.netease.nim.im.server.sdk.v2.conversation_unread;

/**
 * URL context for Conversation Unread V2 API endpoints
 */
public class ConversationUnreadUrlContextV2 {
    
    /**
     * Get conversation overview endpoint for an account
     */
    static final String OVERVIEWS_CONVERSATION = "/im/v2/conversation_overviews/{account_id}";
    
    /**
     * Clear conversation unread count endpoint
     */
    static final String CLEAR_CONVERSATION_UNREAD = "/im/v2/conversations/{conversation_id}/actions/clear_conversation_unread";
} 