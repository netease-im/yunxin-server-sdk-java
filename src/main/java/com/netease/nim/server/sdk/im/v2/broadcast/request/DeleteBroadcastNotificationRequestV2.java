package com.netease.nim.server.sdk.im.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for deleting a broadcast notification
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/broadcast_notification/{broadcast_id}
 */
public class DeleteBroadcastNotificationRequestV2 {
    
    /**
     * Broadcast message ID to delete
     */
    private String broadcastId;
    
    /**
     * Default constructor
     */
    public DeleteBroadcastNotificationRequestV2() {
    }
    
    /**
     * Constructor with broadcastId
     * 
     * @param broadcastId broadcast message ID to delete
     */
    public DeleteBroadcastNotificationRequestV2(String broadcastId) {
        this.broadcastId = broadcastId;
    }
    
    /**
     * Get broadcast message ID
     * 
     * @return broadcast message ID
     */
    public String getBroadcastId() {
        return broadcastId;
    }
    
    /**
     * Set broadcast message ID
     * 
     * @param broadcastId broadcast message ID
     */
    public void setBroadcastId(String broadcastId) {
        this.broadcastId = broadcastId;
    }
} 