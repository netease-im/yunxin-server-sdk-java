package com.netease.nim.im.server.sdk.v2.chatroom.request;

/**
 * Request for listing fixed chatroom members
 * 
 * This class encapsulates the parameters required to query fixed members in a chatroom.
 * Fixed members include the creator, administrators, and regular members.
 */
public class ListFixedMembersRequestV2 {

    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * Member roles to query (comma-separated)
     * 0: Regular users
     * 1: Creator
     * 2: Administrators
     * 
     * Default is "1,2,3" (all fixed member types)
     */
    private String memberRoles;
    
    /**
     * Default constructor
     */
    public ListFixedMembersRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId the ID of the chatroom
     */
    public ListFixedMembersRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param roomId the ID of the chatroom
     * @param memberRoles the member roles to query (comma-separated)
     */
    public ListFixedMembersRequestV2(Long roomId, String memberRoles) {
        this.roomId = roomId;
        this.memberRoles = memberRoles;
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
} 