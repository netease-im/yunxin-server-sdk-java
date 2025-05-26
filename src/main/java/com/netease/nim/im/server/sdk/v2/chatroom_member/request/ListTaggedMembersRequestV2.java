package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

/**
 * Request for paginated querying of online members with a specific tag in a chatroom
 */
public class ListTaggedMembersRequestV2 {
    
    /**
     * The ID of the chatroom
     */
    private Long roomId;
    
    /**
     * The tag to query
     */
    private String tag;
    
    /**
     * The offset for pagination
     */
    private Long offset;
    
    /**
     * The limit of items per page
     */
    private Integer limit;
    
    /**
     * Default constructor
     */
    public ListTaggedMembersRequestV2() {
    }
    
    /**
     * Constructor with all fields
     * 
     * @param roomId the ID of the chatroom
     * @param tag the tag to query
     * @param offset the offset for pagination
     * @param limit the limit of items per page
     */
    public ListTaggedMembersRequestV2(Long roomId, String tag, Long offset, Integer limit) {
        this.roomId = roomId;
        this.tag = tag;
        this.offset = offset;
        this.limit = limit;
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
    
    /**
     * Get the offset
     * 
     * @return the offset
     */
    public Long getOffset() {
        return offset;
    }
    
    /**
     * Set the offset
     * 
     * @param offset the offset
     */
    public void setOffset(Long offset) {
        this.offset = offset;
    }
    
    /**
     * Get the limit
     * 
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * Set the limit
     * 
     * @param limit the limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 