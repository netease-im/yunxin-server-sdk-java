package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

/**
 * Request for querying chatroom blacklist
 * 
 * This class represents the request parameters for the API to query the list of
 * blocked users in a chatroom.
 * 
 * The API defaults to returning only 100 blacklisted users. To retrieve more,
 * contact Yunxin technical support. The maximum can be extended to 1000 accounts.
 */
public class QueryChatroomBlacklistRequestV2 {
    
    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * Default constructor
     */
    public QueryChatroomBlacklistRequestV2() {
    }
    
    /**
     * Constructor with roomId
     * 
     * @param roomId the ID of the chatroom
     */
    public QueryChatroomBlacklistRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get the chatroom ID
     * 
     * @return the chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the chatroom ID
     * 
     * @param roomId the chatroom ID to set
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
} 