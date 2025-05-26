package com.netease.nim.im.server.sdk.v2.system_notification.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for sending batch custom system notifications
 * 
 * API: POST https://open.yunxinapi.com/im/v2/custom_notification/batch
 */
public class SendBatchCustomNotificationRequestV2 {
    
    /**
     * Required. Sender's IM account ID
     */
    @JSONField(name = "sender_id")
    private String senderId;
    
    /**
     * Required. List of receiver account IDs
     * Maximum 500 accounts
     */
    @JSONField(name = "receiver_ids")
    private List<String> receiverIds;
    
    /**
     * Required. Custom notification content
     * Should be a JSON string, max length 4096 characters
     */
    @JSONField(name = "content")
    private String content;
    
    /**
     * Optional. Client local sound file name
     * Max length 30 characters
     */
    @JSONField(name = "sound")
    private String sound;
    
    /**
     * Optional. Notification configuration
     */
    @JSONField(name = "notification_config")
    private NotificationConfig notificationConfig;
    
    /**
     * Optional. Push configuration
     */
    @JSONField(name = "push_config")
    private PushConfig pushConfig;
    
    /**
     * Optional. Route configuration
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    /**
     * Default constructor
     */
    public SendBatchCustomNotificationRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param senderId Sender's IM account ID
     * @param receiverIds List of receiver account IDs
     * @param content Custom notification content
     */
    public SendBatchCustomNotificationRequestV2(String senderId, List<String> receiverIds, String content) {
        this.senderId = senderId;
        this.receiverIds = receiverIds;
        this.content = content;
    }
    
    /**
     * Get sender ID
     * 
     * @return Sender's IM account ID
     */
    public String getSenderId() {
        return senderId;
    }
    
    /**
     * Set sender ID
     * 
     * @param senderId Sender's IM account ID
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    
    /**
     * Get receiver IDs
     * 
     * @return List of receiver account IDs
     */
    public List<String> getReceiverIds() {
        return receiverIds;
    }
    
    /**
     * Set receiver IDs
     * 
     * @param receiverIds List of receiver account IDs
     */
    public void setReceiverIds(List<String> receiverIds) {
        this.receiverIds = receiverIds;
    }
    
    /**
     * Get notification content
     * 
     * @return Custom notification content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Set notification content
     * 
     * @param content Custom notification content
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * Get sound file name
     * 
     * @return Client local sound file name
     */
    public String getSound() {
        return sound;
    }
    
    /**
     * Set sound file name
     * 
     * @param sound Client local sound file name
     */
    public void setSound(String sound) {
        this.sound = sound;
    }
    
    /**
     * Get notification configuration
     * 
     * @return Notification configuration
     */
    public NotificationConfig getNotificationConfig() {
        return notificationConfig;
    }
    
    /**
     * Set notification configuration
     * 
     * @param notificationConfig Notification configuration
     */
    public void setNotificationConfig(NotificationConfig notificationConfig) {
        this.notificationConfig = notificationConfig;
    }
    
    /**
     * Get push configuration
     * 
     * @return Push configuration
     */
    public PushConfig getPushConfig() {
        return pushConfig;
    }
    
    /**
     * Set push configuration
     * 
     * @param pushConfig Push configuration
     */
    public void setPushConfig(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
    }
    
    /**
     * Get route configuration
     * 
     * @return Route configuration
     */
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }
    
    /**
     * Set route configuration
     * 
     * @param routeConfig Route configuration
     */
    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
    
    /**
     * Notification configuration for custom notifications
     */
    public static class NotificationConfig {
        
        /**
         * Whether the notification should be stored offline
         * Default is true
         */
        @JSONField(name = "offline_enabled")
        private Boolean offlineEnabled;
        
        /**
         * Whether the notification should be counted in unread count
         * Default is true
         */
        @JSONField(name = "unread_enabled")
        private Boolean unreadEnabled;
        
        /**
         * Default constructor
         */
        public NotificationConfig() {
        }
        
        /**
         * Constructor with all parameters
         * 
         * @param offlineEnabled Whether the notification should be stored offline
         * @param unreadEnabled Whether the notification should be counted in unread count
         */
        public NotificationConfig(Boolean offlineEnabled, Boolean unreadEnabled) {
            this.offlineEnabled = offlineEnabled;
            this.unreadEnabled = unreadEnabled;
        }
        
        /**
         * Get offline enabled status
         * 
         * @return Whether the notification should be stored offline
         */
        public Boolean getOfflineEnabled() {
            return offlineEnabled;
        }
        
        /**
         * Set offline enabled status
         * 
         * @param offlineEnabled Whether the notification should be stored offline
         */
        public void setOfflineEnabled(Boolean offlineEnabled) {
            this.offlineEnabled = offlineEnabled;
        }
        
        /**
         * Get unread enabled status
         * 
         * @return Whether the notification should be counted in unread count
         */
        public Boolean getUnreadEnabled() {
            return unreadEnabled;
        }
        
        /**
         * Set unread enabled status
         * 
         * @param unreadEnabled Whether the notification should be counted in unread count
         */
        public void setUnreadEnabled(Boolean unreadEnabled) {
            this.unreadEnabled = unreadEnabled;
        }
    }
    
    /**
     * Push configuration for custom notifications
     */
    public static class PushConfig {
        
        /**
         * Whether to enable APNs push or Android system notification bar push
         * Default is true
         */
        @JSONField(name = "push_enabled")
        private Boolean pushEnabled;
        
        /**
         * Whether to include nickname in push content
         * Default is true
         */
        @JSONField(name = "push_nick_enabled")
        private Boolean pushNickEnabled;
        
        /**
         * Push content text, max length 500 characters
         */
        @JSONField(name = "push_content")
        private String pushContent;
        
        /**
         * Push payload in JSON format, max length 2048 characters
         */
        @JSONField(name = "push_payload")
        private String pushPayload;
        
        /**
         * Whether to enable force push (@ operation)
         * Default is false
         */
        @JSONField(name = "push_forcepush_enable")
        private Boolean pushForcepushEnable;
        
        /**
         * Whether to force push to all members in the group
         * Default is false
         */
        @JSONField(name = "push_forcepush_all")
        private Boolean pushForcepushAll;
        
        /**
         * List of account IDs to force push to
         * Max 100 accounts
         */
        @JSONField(name = "push_forcepush_ids")
        private List<String> pushForcepushIds;
        
        /**
         * Force push content text, max length 500 characters
         */
        @JSONField(name = "push_forcepush_content")
        private String pushForcepushContent;
        
        /**
         * Default constructor
         */
        public PushConfig() {
        }
        
        /**
         * Get push enabled status
         * 
         * @return Whether push is enabled
         */
        public Boolean getPushEnabled() {
            return pushEnabled;
        }
        
        /**
         * Set push enabled status
         * 
         * @param pushEnabled Whether push should be enabled
         */
        public void setPushEnabled(Boolean pushEnabled) {
            this.pushEnabled = pushEnabled;
        }
        
        /**
         * Get push nickname enabled status
         * 
         * @return Whether nickname should be included in push content
         */
        public Boolean getPushNickEnabled() {
            return pushNickEnabled;
        }
        
        /**
         * Set push nickname enabled status
         * 
         * @param pushNickEnabled Whether nickname should be included in push content
         */
        public void setPushNickEnabled(Boolean pushNickEnabled) {
            this.pushNickEnabled = pushNickEnabled;
        }
        
        /**
         * Get push content
         * 
         * @return Push content text
         */
        public String getPushContent() {
            return pushContent;
        }
        
        /**
         * Set push content
         * 
         * @param pushContent Push content text
         */
        public void setPushContent(String pushContent) {
            this.pushContent = pushContent;
        }
        
        /**
         * Get push payload
         * 
         * @return Push payload in JSON format
         */
        public String getPushPayload() {
            return pushPayload;
        }
        
        /**
         * Set push payload
         * 
         * @param pushPayload Push payload in JSON format
         */
        public void setPushPayload(String pushPayload) {
            this.pushPayload = pushPayload;
        }
        
        /**
         * Get force push enabled status
         * 
         * @return Whether force push is enabled
         */
        public Boolean getPushForcepushEnable() {
            return pushForcepushEnable;
        }
        
        /**
         * Set force push enabled status
         * 
         * @param pushForcepushEnable Whether force push should be enabled
         */
        public void setPushForcepushEnable(Boolean pushForcepushEnable) {
            this.pushForcepushEnable = pushForcepushEnable;
        }
        
        /**
         * Get force push to all status
         * 
         * @return Whether to force push to all group members
         */
        public Boolean getPushForcepushAll() {
            return pushForcepushAll;
        }
        
        /**
         * Set force push to all status
         * 
         * @param pushForcepushAll Whether to force push to all group members
         */
        public void setPushForcepushAll(Boolean pushForcepushAll) {
            this.pushForcepushAll = pushForcepushAll;
        }
        
        /**
         * Get force push account IDs
         * 
         * @return List of account IDs to force push to
         */
        public List<String> getPushForcepushIds() {
            return pushForcepushIds;
        }
        
        /**
         * Set force push account IDs
         * 
         * @param pushForcepushIds List of account IDs to force push to
         */
        public void setPushForcepushIds(List<String> pushForcepushIds) {
            this.pushForcepushIds = pushForcepushIds;
        }
        
        /**
         * Get force push content
         * 
         * @return Force push content text
         */
        public String getPushForcepushContent() {
            return pushForcepushContent;
        }
        
        /**
         * Set force push content
         * 
         * @param pushForcepushContent Force push content text
         */
        public void setPushForcepushContent(String pushForcepushContent) {
            this.pushForcepushContent = pushForcepushContent;
        }
    }
    
    /**
     * Route configuration for custom notifications
     */
    public static class RouteConfig {
        
        /**
         * Whether to enable message forwarding to application server
         * Default is true
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;
        
        /**
         * Environment name for message forwarding
         */
        @JSONField(name = "route_environment")
        private String routeEnvironment;
        
        /**
         * Default constructor
         */
        public RouteConfig() {
        }
        
        /**
         * Constructor with all parameters
         * 
         * @param routeEnabled Whether to enable message forwarding
         * @param routeEnvironment Environment name for message forwarding
         */
        public RouteConfig(Boolean routeEnabled, String routeEnvironment) {
            this.routeEnabled = routeEnabled;
            this.routeEnvironment = routeEnvironment;
        }
        
        /**
         * Get route enabled status
         * 
         * @return Whether message forwarding is enabled
         */
        public Boolean getRouteEnabled() {
            return routeEnabled;
        }
        
        /**
         * Set route enabled status
         * 
         * @param routeEnabled Whether message forwarding should be enabled
         */
        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }
        
        /**
         * Get route environment
         * 
         * @return Environment name for message forwarding
         */
        public String getRouteEnvironment() {
            return routeEnvironment;
        }
        
        /**
         * Set route environment
         * 
         * @param routeEnvironment Environment name for message forwarding
         */
        public void setRouteEnvironment(String routeEnvironment) {
            this.routeEnvironment = routeEnvironment;
        }
    }
} 