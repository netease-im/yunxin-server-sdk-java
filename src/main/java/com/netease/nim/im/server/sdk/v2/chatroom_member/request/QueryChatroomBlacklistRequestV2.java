package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

/**
 * Request for querying chatroom blacklist
 * 
 * This class represents the request parameters for the API to query the list of
 * blocked users in a chatroom.
 */
public class QueryChatroomBlacklistRequestV2 {
    
    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * Offset for pagination (starting from 0)
     */
    private Integer offset;
    
    /**
     * Limit for pagination (number of records to return)
     */
    private Integer limit;
    
    /**
     * Default constructor
     */
    public QueryChatroomBlacklistRequestV2() {
    }
    
    /**
     * Constructor with roomId, offset, and limit
     * 
     * @param roomId the ID of the chatroom
     * @param offset the offset for pagination (starting from 0)
     * @param limit the maximum number of records to return
     */
    public QueryChatroomBlacklistRequestV2(Long roomId, Integer offset, Integer limit) {
        this.roomId = roomId;
        this.offset = offset;
        this.limit = limit;
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
    
    /**
     * Get the offset for pagination
     * 
     * @return the offset
     */
    public Integer getOffset() {
        return offset;
    }
    
    /**
     * Set the offset for pagination
     * 
     * @param offset the offset to set
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    
    /**
     * Get the limit for pagination
     * 
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * Set the limit for pagination
     * 
     * @param limit the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 