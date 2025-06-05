package com.netease.nim.server.sdk.im.v2.broadcast.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for paginated query of broadcast notifications
 */
public class QueryBroadcastNotificationListResponseV2 {
    
    /**
     * Whether there are more results available
     */
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    /**
     * Next page token for pagination
     */
    @JSONField(name = "next_token")
    private String nextToken;
    
    /**
     * List of broadcast notification items
     */
    @JSONField(name = "items")
    private List<BroadcastNotificationItem> items;
    
    /**
     * Get whether there are more results available
     * 
     * @return True if there are more results, false otherwise
     */
    public Boolean getHasMore() {
        return hasMore;
    }
    
    /**
     * Set whether there are more results available
     * 
     * @param hasMore True if there are more results, false otherwise
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    /**
     * Get next page token
     * 
     * @return Next page token for pagination
     */
    public String getNextToken() {
        return nextToken;
    }
    
    /**
     * Set next page token
     * 
     * @param nextToken Next page token for pagination
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    /**
     * Get list of broadcast notification items
     * 
     * @return List of broadcast notification items
     */
    public List<BroadcastNotificationItem> getItems() {
        return items;
    }
    
    /**
     * Set list of broadcast notification items
     * 
     * @param items List of broadcast notification items
     */
    public void setItems(List<BroadcastNotificationItem> items) {
        this.items = items;
    }
    
    /**
     * Broadcast notification item
     */
    public static class BroadcastNotificationItem {
        
        /**
         * Broadcast message ID
         */
        @JSONField(name = "broadcast_id")
        private String broadcastId;
        
        /**
         * Sender's account ID
         */
        @JSONField(name = "from_account_id")
        private String fromAccountId;
        
        /**
         * Broadcast message content
         */
        @JSONField(name = "content")
        private String content;
        
        /**
         * Whether the broadcast message is stored offline
         */
        @JSONField(name = "offline_enabled")
        private Boolean offlineEnabled;
        
        /**
         * Target operating systems
         */
        @JSONField(name = "target_os")
        private List<String> targetOs;
        
        /**
         * Creation timestamp of the broadcast message
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Expiration timestamp of the broadcast message
         */
        @JSONField(name = "expire_time")
        private Long expireTime;
        
        /**
         * Get broadcast message ID
         * 
         * @return Broadcast message ID
         */
        public String getBroadcastId() {
            return broadcastId;
        }
        
        /**
         * Set broadcast message ID
         * 
         * @param broadcastId Broadcast message ID
         */
        public void setBroadcastId(String broadcastId) {
            this.broadcastId = broadcastId;
        }
        
        /**
         * Get sender's account ID
         * 
         * @return Sender's account ID
         */
        public String getFromAccountId() {
            return fromAccountId;
        }
        
        /**
         * Set sender's account ID
         * 
         * @param fromAccountId Sender's account ID
         */
        public void setFromAccountId(String fromAccountId) {
            this.fromAccountId = fromAccountId;
        }
        
        /**
         * Get broadcast message content
         * 
         * @return Content of the broadcast message
         */
        public String getContent() {
            return content;
        }
        
        /**
         * Set broadcast message content
         * 
         * @param content Content of the broadcast message
         */
        public void setContent(String content) {
            this.content = content;
        }
        
        /**
         * Check if offline storage is enabled
         * 
         * @return True if offline storage is enabled, false otherwise
         */
        public Boolean getOfflineEnabled() {
            return offlineEnabled;
        }
        
        /**
         * Set whether the broadcast message is stored offline
         * 
         * @param offlineEnabled True if offline storage is enabled, false otherwise
         */
        public void setOfflineEnabled(Boolean offlineEnabled) {
            this.offlineEnabled = offlineEnabled;
        }
        
        /**
         * Get target operating systems
         * 
         * @return List of target operating systems
         */
        public List<String> getTargetOs() {
            return targetOs;
        }
        
        /**
         * Set target operating systems
         * 
         * @param targetOs List of target operating systems
         */
        public void setTargetOs(List<String> targetOs) {
            this.targetOs = targetOs;
        }
        
        /**
         * Get creation timestamp
         * 
         * @return Creation timestamp
         */
        public Long getCreateTime() {
            return createTime;
        }
        
        /**
         * Set creation timestamp
         * 
         * @param createTime Creation timestamp
         */
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        /**
         * Get expiration timestamp
         * 
         * @return Expiration timestamp
         */
        public Long getExpireTime() {
            return expireTime;
        }
        
        /**
         * Set expiration timestamp
         * 
         * @param expireTime Expiration timestamp
         */
        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }
    }
} 