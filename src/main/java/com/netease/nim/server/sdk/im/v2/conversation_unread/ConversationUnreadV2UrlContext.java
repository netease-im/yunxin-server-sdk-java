package com.netease.nim.server.sdk.im.v2.conversation_unread;

/**
 * URL context for Conversation Unread V2 API endpoints
 */
public class ConversationUnreadV2UrlContext {
    
    /**
     * Get conversation overview endpoint for an account
     */
    static final String OVERVIEWS_CONVERSATION = "/im/v2/conversation_overviews/{account_id}";
    
    /**
     * Clear conversation unread count endpoint
     */
    static final String CLEAR_CONVERSATION_UNREAD = "/im/v2/conversations/{conversation_id}/actions/clear_conversation_unread";
} 