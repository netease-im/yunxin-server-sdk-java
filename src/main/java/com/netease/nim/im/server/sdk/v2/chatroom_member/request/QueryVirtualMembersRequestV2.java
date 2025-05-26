package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

/**
 * Request for querying virtual members in a chatroom
 * 
 * This request allows retrieving information about virtual members in a chatroom.
 */
public class QueryVirtualMembersRequestV2 {
    
    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * Default constructor
     */
    public QueryVirtualMembersRequestV2() {
    }
    
    /**
     * Constructor with required field
     * 
     * @param roomId chatroom ID
     */
    public QueryVirtualMembersRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get chatroom ID
     * 
     * @return chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set chatroom ID
     * 
     * @param roomId chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
} 