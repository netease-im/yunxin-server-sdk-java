package com.netease.nim.im.server.sdk.v2.broadcast.request;

/**
 * Request for querying a broadcast notification
 * 
 * API: GET https://open.yunxinapi.com/im/v2/broadcast_notification/{broadcast_id}
 */
public class QueryBroadcastNotificationRequestV2 {
    
    /**
     * Broadcast message ID to query
     */
    private String broadcastId;
    
    /**
     * Default constructor
     */
    public QueryBroadcastNotificationRequestV2() {
    }
    
    /**
     * Constructor with broadcastId
     * 
     * @param broadcastId broadcast message ID to query
     */
    public QueryBroadcastNotificationRequestV2(String broadcastId) {
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