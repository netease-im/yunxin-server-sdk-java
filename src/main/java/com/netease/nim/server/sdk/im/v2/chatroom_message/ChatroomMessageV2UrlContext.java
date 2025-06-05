package com.netease.nim.server.sdk.im.v2.chatroom_message;

/**
 * URL context for Chatroom Message V2 API endpoints
 */
public class ChatroomMessageV2UrlContext {
    
    /**
     * Send chatroom message endpoint
     */
    static final String SEND_CHATROOM_MESSAGE = "/im/v2/chatrooms/{room_id}/messages";
    
    /**
     * Batch send chatroom messages endpoint
     */
    static final String BATCH_SEND_CHATROOM_MESSAGES = "/im/v2/chatrooms/messages";

    /**
     * Recall or delete chatroom message endpoint
     */
    static final String RECALL_OR_DELETE_CHATROOM_MESSAGE = "/im/v2/chatrooms/{room_id}/messages/{message_client_id}";
    
    /**
     * Query chatroom history messages endpoint
     */
    static final String QUERY_CHATROOM_HISTORY_MESSAGES = "/im/v2/chatrooms/{room_id}/messages";
} 