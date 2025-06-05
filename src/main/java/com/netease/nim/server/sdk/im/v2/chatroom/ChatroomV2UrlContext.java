package com.netease.nim.server.sdk.im.v2.chatroom;

/**
 * URL context for Chatroom V2 API endpoints
 */
public class ChatroomV2UrlContext {
    
    /**
     * Create chatroom endpoint
     */
    static final String CREATE_CHATROOM = "/im/v2/chatrooms";
    
    /**
     * Get chatroom info endpoint
     */
    static final String GET_CHATROOM_INFO = "/im/v2/chatrooms/{room_id}";
    
    /**
     * Update chatroom info endpoint
     */
    static final String UPDATE_CHATROOM_INFO = "/im/v2/chatrooms/{room_id}";
    
    /**
     * Toggle entry/exit event notification endpoint
     */
    static final String TOGGLE_NOTIFICATION = "/im/v2/chatrooms/{room_id}/notification";
    
    /**
     * Close chatroom endpoint
     */
    static final String CLOSE_CHATROOM = "/im/v2/chatrooms/{room_id}/status";
    
    /**
     * Toggle chatroom mute status endpoint
     */
    static final String TOGGLE_CHATROOM_MUTE = "/im/v2/chatrooms/{room_id}/actions/chat_banned";
    
    /**
     * Get chatroom address endpoint
     */
    static final String GET_CHATROOM_ADDRESS = "/im/v2/chatrooms/{room_id}/actions/address";
    
    /**
     * Update chatroom status endpoint (open/close)
     */
    static final String UPDATE_CHATROOM_STATUS = "/im/v2/chatrooms/{room_id}/actions/update_status";
    
    /**
     * Toggle in/out notification endpoint
     */
    static final String TOGGLE_IN_OUT_NOTIFICATION = "/im/v2/chatrooms/{room_id}/actions/in_out_notification";
    
    /**
     * Query open chatrooms endpoint
     */
    static final String QUERY_OPEN_CHATROOMS = "/im/v2/chatrooms/actions/opend_chatrooms";
    
    /**
     * List online chatroom members endpoint
     */
    static final String LIST_ONLINE_MEMBERS = "/im/v2/chatrooms/{room_id}/actions/list_online_members";
    
    /**
     * List fixed chatroom members endpoint
     */
    static final String LIST_FIXED_MEMBERS = "/im/v2/chatrooms/{room_id}/actions/list_members";
} 