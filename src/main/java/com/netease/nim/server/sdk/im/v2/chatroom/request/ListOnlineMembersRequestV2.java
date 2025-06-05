package com.netease.nim.server.sdk.im.v2.chatroom.request;

/**
 * Request for listing online chatroom members
 * 
 * This class encapsulates the parameters required to query online members in a chatroom with pagination.
 */
public class ListOnlineMembersRequestV2 {

    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * Member roles to query (comma-separated)
     * 0: Regular users
     * 1: Creator
     * 2: Administrators
     * 3: Regular guests
     * 4: Anonymous guests
     * 
     * Default is "0,1,2,3,4" (all member types)
     */
    private String memberRoles;
    
    /**
     * Pagination offset
     * For the first query, set to 0
     * For subsequent queries, use the offset returned from the previous response
     */
    private Long offset;
    
    /**
     * Maximum number of members to return per page
     * Maximum value is 100
     */
    private Integer limit;
    
    /**
     * Default constructor
     */
    public ListOnlineMembersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId the ID of the chatroom
     * @param offset the pagination offset
     * @param limit the maximum number of members to return
     */
    public ListOnlineMembersRequestV2(Long roomId, Long offset, Integer limit) {
        this.roomId = roomId;
        this.offset = offset;
        this.limit = limit;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param roomId the ID of the chatroom
     * @param memberRoles the member roles to query (comma-separated)
     * @param offset the pagination offset
     * @param limit the maximum number of members to return
     */
    public ListOnlineMembersRequestV2(Long roomId, String memberRoles, Long offset, Integer limit) {
        this.roomId = roomId;
        this.memberRoles = memberRoles;
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
     * @param roomId the chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get the member roles to query
     * 
     * @return the member roles as a comma-separated string
     */
    public String getMemberRoles() {
        return memberRoles;
    }
    
    /**
     * Set the member roles to query
     * 
     * @param memberRoles the member roles as a comma-separated string
     */
    public void setMemberRoles(String memberRoles) {
        this.memberRoles = memberRoles;
    }
    
    /**
     * Get the pagination offset
     * 
     * @return the pagination offset
     */
    public Long getOffset() {
        return offset;
    }
    
    /**
     * Set the pagination offset
     * 
     * @param offset the pagination offset
     */
    public void setOffset(Long offset) {
        this.offset = offset;
    }
    
    /**
     * Get the maximum number of members to return
     * 
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * Set the maximum number of members to return
     * 
     * @param limit the limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 