package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

/**
 * Request for querying the count of online members with a specific tag in a chatroom
 */
public class QueryTaggedMembersCountRequestV2 {
    
    /**
     * The ID of the chatroom
     */
    private Long roomId;
    
    /**
     * The tag to query
     */
    private String tag;
    
    /**
     * Default constructor
     */
    public QueryTaggedMembersCountRequestV2() {
    }
    
    /**
     * Constructor with all fields
     * 
     * @param roomId the ID of the chatroom
     * @param tag the tag to query
     */
    public QueryTaggedMembersCountRequestV2(Long roomId, String tag) {
        this.roomId = roomId;
        this.tag = tag;
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
    
    /**
     * Get the tag
     * 
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
    
    /**
     * Set the tag
     * 
     * @param tag the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
} 