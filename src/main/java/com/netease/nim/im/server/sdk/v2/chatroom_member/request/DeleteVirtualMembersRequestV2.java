package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for deleting virtual members from a chatroom
 * 
 * This request allows batch deletion of virtual members from a chatroom.
 * A maximum of 100 virtual members can be deleted at once.
 */
public class DeleteVirtualMembersRequestV2 {
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * List of virtual member account IDs to delete (max 100)
     */
    @JSONField(name = "account_ids")
    private List<String> accountIds;
    
    /**
     * Whether to send notification about virtual members being removed
     * Default is true
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Default constructor
     */
    public DeleteVirtualMembersRequestV2() {
    }
    
    /**
     * Constructor with required fields
     * 
     * @param roomId chatroom ID
     * @param accountIds list of virtual member account IDs to delete
     */
    public DeleteVirtualMembersRequestV2(Long roomId, List<String> accountIds) {
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
     * Get list of account IDs to delete
     * 
     * @return list of account IDs
     */
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    /**
     * Set list of account IDs to delete
     * 
     * @param accountIds list of account IDs
     */
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
    
    /**
     * Get notification enabled flag
     * 
     * @return true if notification is enabled, false otherwise
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set notification enabled flag
     * 
     * @param notificationEnabled notification enabled flag
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
} 