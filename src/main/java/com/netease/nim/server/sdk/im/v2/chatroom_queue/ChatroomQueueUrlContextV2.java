package com.netease.nim.server.sdk.im.v2.chatroom_queue;

/**
 * URL context for Chatroom Queue V2 API endpoints
 */
public class ChatroomQueueUrlContextV2 {
    
    /**
     * Initialize chatroom queue endpoint
     */
    static final String INITIALIZE_CHATROOM_QUEUE = "/im/v2/room_queues/{room_id}";
    

    /**
     * Query chatroom queue elements endpoint
     */
    static final String QUERY_CHATROOM_QUEUE_ELEMENTS = "/im/v2/room_queues/{room_id}/actions/query";
    
    /**
     * Update chatroom queue endpoint
     */
    static final String UPDATE_CHATROOM_QUEUE = "/im/v2/room_queues/{room_id}";
    
    /**
     * Delete chatroom queue endpoint
     */
    static final String DELETE_CHATROOM_QUEUE = "/im/v2/room_queues/{room_id}";
    
    /**
     * Poll element from chatroom queue endpoint
     */
    static final String POLL_CHATROOM_QUEUE_ELEMENT = "/im/v2/room_queues/{room_id}/actions/poll";
} 