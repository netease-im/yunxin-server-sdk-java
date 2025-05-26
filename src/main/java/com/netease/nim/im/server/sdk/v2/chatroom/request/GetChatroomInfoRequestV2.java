package com.netease.nim.im.server.sdk.v2.chatroom.request;

/**
 * Request for getting chatroom information
 * 
 * This class encapsulates the parameters required to get chatroom information.
 */
public class GetChatroomInfoRequestV2 {

    /**
     * Chatroom ID
     * The ID of the chatroom for which to retrieve information
     */
    private Long roomId;
    
    /**
     * Whether to return the number of online users in the chatroom
     * false (default): don't return
     * true: return
     */
    private Boolean needOnlineUserCount;
    
    /**
     * Whether to show the number of online users by client type
     * false (default): don't show
     * true: show
     */
    private Boolean onlineUserCountByType;
    
    /**
     * Default constructor
     */
    public GetChatroomInfoRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId The ID of the chatroom
     */
    public GetChatroomInfoRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param roomId The ID of the chatroom
     * @param needOnlineUserCount Whether to return the number of online users
     * @param onlineUserCountByType Whether to show the number of online users by client type
     */
    public GetChatroomInfoRequestV2(Long roomId, Boolean needOnlineUserCount, Boolean onlineUserCountByType) {
        this.roomId = roomId;
        this.needOnlineUserCount = needOnlineUserCount;
        this.onlineUserCountByType = onlineUserCountByType;
    }
    
    /**
     * Get the chatroom ID
     * 
     * @return The chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the chatroom ID
     * 
     * @param roomId The chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get whether to return the number of online users
     * 
     * @return Whether to return the number of online users
     */
    public Boolean getNeedOnlineUserCount() {
        return needOnlineUserCount;
    }
    
    /**
     * Set whether to return the number of online users
     * 
     * @param needOnlineUserCount Whether to return the number of online users
     */
    public void setNeedOnlineUserCount(Boolean needOnlineUserCount) {
        this.needOnlineUserCount = needOnlineUserCount;
    }
    
    /**
     * Get whether to show the number of online users by client type
     * 
     * @return Whether to show the number of online users by client type
     */
    public Boolean getOnlineUserCountByType() {
        return onlineUserCountByType;
    }
    
    /**
     * Set whether to show the number of online users by client type
     * 
     * @param onlineUserCountByType Whether to show the number of online users by client type
     */
    public void setOnlineUserCountByType(Boolean onlineUserCountByType) {
        this.onlineUserCountByType = onlineUserCountByType;
    }
} 