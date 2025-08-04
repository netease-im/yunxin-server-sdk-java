package com.netease.nim.server.sdk.im.v2.message;

/**
 * URL context for Message V2 API endpoints
 */
public class MessageV2UrlContext {
    
    /**
     * Send message endpoint
     */
    static final String SEND_MESSAGE = "/im/v2/conversations/{conversation_id}/messages";
    
    /**
     * Batch send P2P messages endpoint
     */
    static final String BATCH_SEND_P2P_MESSAGE = "/im/v2/conversations/messages";
    
    /**
     * Modify (update) message endpoint
     */
    static final String MODIFY_MESSAGE = "/im/v2/messages/actions/modifyMsg";
    
    /**
     * Withdraw (recall or delete) message endpoint
     */
    static final String WITHDRAW_MESSAGE = "/im/v2/conversations/{conversation_id}/messages/{message_server_id}";
    
    /**
     * Delete all messages in a conversation endpoint
     */
    static final String DELETE_CONVERSATION_MESSAGES = "/im/v2/conversations/{conversation_id}/messages";
    
    /**
     * Send P2P read receipt endpoint
     */
    static final String SEND_P2P_READ_RECEIPT = "/im/v2/messages/actions/p2p_read_receipt";
    
    /**
     * Send team read receipt endpoint
     */
    static final String SEND_TEAM_READ_RECEIPT = "/im/v2/messages/actions/team_read_receipt";
    
    /**
     * Query team message read receipt details endpoint
     */
    static final String QUERY_TEAM_READ_RECEIPT = "/im/v2/messages/actions/team_read_receipt";

    /**
     * Send streaming message endpoint
     */
    static final String STREAM_MESSAGE = "/im/v2/conversations/{conversation_id}/messages/actions/stream_message";
    
    /**
     * Query single message details endpoint
     */
    static final String QUERY_MESSAGE = "/im/v2.1/conversations/{conversation_id}/messages/{message_server_id}";
    
    /**
     * Search messages endpoint
     */
    static final String SEARCH_MESSAGES = "/im/v2.1/messages/actions/search_messages";
    
    /**
     * Query conversation messages with pagination endpoint
     */
    static final String QUERY_CONVERSATION_MESSAGES = "/im/v2.1/conversations/{conversation_id}/messages";
    
    /**
     * Batch query messages by message IDs endpoint
     */
    static final String BATCH_QUERY_MESSAGES = "/im/v2.1/conversations/{conversation_id}/batch_messages";
    
    /**
     * Query thread messages endpoint
     */
    static final String QUERY_THREAD_MESSAGES = "/im/v2.1/messages/actions/thread_messages";
    
    /**
     * Add quick comment to message endpoint
     */
    static final String ADD_QUICK_COMMENT = "/im/v2/messages/actions/quick_comment";
    
    /**
     * Delete quick comment from message endpoint
     */
    static final String DELETE_QUICK_COMMENT = "/im/v2/messages/actions/quick_comment";
    
    /**
     * Batch query quick comments endpoint
     */
    static final String BATCH_QUERY_QUICK_COMMENTS = "/im/v2/messages/actions/quick_comment";
} 