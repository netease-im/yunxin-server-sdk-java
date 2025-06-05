package com.netease.nim.server.sdk.im.v2.chatroom_member;

/**
 * URL context for Chatroom Member V2 API endpoints
 */
public class ChatroomMemberV2UrlContext {
    
    /**
     * Set chatroom member role endpoint
     */
    static final String SET_MEMBER_ROLE = "/im/v2/room_members/{account_id}";
    
    /**
     * Update chatroom online member information endpoint
     */
    static final String UPDATE_ONLINE_MEMBER_INFO = "/im/v2/room_members/{account_id}";
    
    /**
     * Ban/unban chatroom member from chatting endpoint
     */
    static final String TOGGLE_CHAT_BAN = "/im/v2/room_members/{account_id}/actions/chat_banned";
    
    /**
     * Modify chatroom online member tags endpoint
     */
    static final String MODIFY_MEMBER_TAGS = "/im/v2/room_members/{account_id}/actions/tags";
    
    /**
     * Query tagged members count endpoint
     */
    static final String QUERY_TAGGED_MEMBERS_COUNT = "/im/v2/room_members/{room_id}/actions/tagged_members_count";
    
    /**
     * List tagged members with pagination endpoint
     */
    static final String LIST_TAG_MEMBERS = "/im/v2/room_members/{room_id}/actions/list_tag_members";
    
    /**
     * Temporarily ban/unban chatroom member from chatting endpoint
     */
    static final String TOGGLE_TEMP_CHAT_BAN = "/im/v2/room_members/{account_id}/actions/temp_chat_banned";
    
    /**
     * Query chatroom ban list endpoint
     */
    static final String QUERY_CHATROOM_BAN_LIST = "/im/v2/room_members/{room_id}/actions/banned_members";
    
    /**
     * Block/unblock chatroom member endpoint
     */
    static final String TOGGLE_BLOCKED = "/im/v2/room_members/{account_id}/actions/blocked";
    
    /**
     * Query chatroom blacklist endpoint
     */
    static final String QUERY_CHATROOM_BLACKLIST = "/im/v2/room_members/{room_id}/actions/blocked";
    
    /**
     * Toggle chatroom tagged members chat ban endpoint
     */
    static final String TOGGLE_TAGGED_MEMBERS_CHAT_BAN = "/im/v2/room_members/actions/chat_banned_tagged_members";
    
    /**
     * Batch query chatroom fixed members information endpoint
     */
    static final String BATCH_QUERY_CHATROOM_MEMBERS = "/im/v2/room_members/{room_id}/actions/batch";
    
    /**
     * Add virtual members to chatroom endpoint
     */
    static final String ADD_VIRTUAL_MEMBERS = "/im/v2/room_members/actions/virtual_members";
    
    /**
     * Delete virtual members from chatroom endpoint
     */
    static final String DELETE_VIRTUAL_MEMBERS = "/im/v2/room_members/actions/virtual_members";
    
    /**
     * Clear all virtual members from chatroom endpoint
     */
    static final String CLEAR_VIRTUAL_MEMBERS = "/im/v2/room_members/actions/clear_virtual_members";
    
    /**
     * Query virtual members in chatroom endpoint
     */
    static final String QUERY_VIRTUAL_MEMBERS = "/im/v2/room_members/actions/virtual_members";
    
    /**
     * Query chat banned members endpoint
     */
    static final String QUERY_CHAT_BANNED = "/im/v2/room_members/{room_id}/actions/chat_banned";
} 