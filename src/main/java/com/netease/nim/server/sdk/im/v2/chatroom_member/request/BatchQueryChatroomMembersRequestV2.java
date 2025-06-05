package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import java.util.List;

/**
 * Request for batch querying chatroom fixed members information
 * 
 * This request is used to query information about multiple fixed members in a chatroom at once.
 */
public class BatchQueryChatroomMembersRequestV2 {
    
    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * List of account IDs to query (max 200)
     */
    private List<String> accountIds;
    
    /**
     * Default constructor
     */
    public BatchQueryChatroomMembersRequestV2() {
    }
    
    /**
     * Constructor with required fields
     * 
     * @param roomId chatroom ID
     * @param accountIds list of account IDs to query
     */
    public BatchQueryChatroomMembersRequestV2(Long roomId, List<String> accountIds) {
        this.roomId = roomId;
        this.accountIds = accountIds;
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
    
    /**
     * Get list of account IDs to query
     * 
     * @return list of account IDs
     */
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    /**
     * Set list of account IDs to query
     * 
     * @param accountIds list of account IDs
     */
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 