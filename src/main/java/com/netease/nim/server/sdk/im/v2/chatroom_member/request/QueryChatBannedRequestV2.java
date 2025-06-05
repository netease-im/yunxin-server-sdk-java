package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

/**
 * Request for querying the list of banned members in a chatroom
 */
public class QueryChatBannedRequestV2 {
    
    /**
     * The ID of the chatroom
     */
    private Long roomId;
    
    /**
     * Default constructor
     */
    public QueryChatBannedRequestV2() {
    }
    
    /**
     * Constructor with room ID
     * 
     * @param roomId the ID of the chatroom
     */
    public QueryChatBannedRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get the room ID
     * 
     * @return the room ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the room ID
     * 
     * @param roomId the room ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
} 