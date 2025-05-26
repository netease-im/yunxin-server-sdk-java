package com.netease.nim.im.server.sdk.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for deleting a chatroom queue
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/room_queues/{room_id}
 */
public class DeleteChatroomQueueRequestV2 {
    
    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * Notification configuration
     */
    @JSONField(name = "notification_config")
    private NotificationConfig notificationConfig;
    
    /**
     * Route configuration for message forwarding
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    /**
     * Default constructor
     */
    public DeleteChatroomQueueRequestV2() {
    }
    
    /**
     * Constructor with roomId
     * 
     * @param roomId chatroom ID
     */
    public DeleteChatroomQueueRequestV2(Long roomId) {
        this.roomId = roomId;
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
     * Get notification configuration
     * 
     * @return notification configuration
     */
    public NotificationConfig getNotificationConfig() {
        return notificationConfig;
    }
    
    /**
     * Set notification configuration
     * 
     * @param notificationConfig notification configuration
     */
    public void setNotificationConfig(NotificationConfig notificationConfig) {
        this.notificationConfig = notificationConfig;
    }
    
    /**
     * Get route configuration
     * 
     * @return route configuration
     */
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }
    
    /**
     * Set route configuration
     * 
     * @param routeConfig route configuration
     */
    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
    
    /**
     * Notification configuration for chatroom queue changes
     */
    public static class NotificationConfig {
        
        /**
         * Whether to send change notifications
         * Default is true
         */
        @JSONField(name = "notification_enabled")
        private Boolean notificationEnabled;
        
        /**
         * Extension field for notification events
         * Maximum length is 2048 characters
         */
        @JSONField(name = "notification_extension")
        private String notificationExtension;
        
        /**
         * Whether to set the queue change notification as high priority
         * 0: Not required (normal message) - default
         * 1: Required (high priority message)
         */
        @JSONField(name = "high_priority")
        private Integer highPriority;
        
        /**
         * High priority message policy
         * 0: Automatically downgrade to normal message if flow control is exceeded (default)
         * 1: Return error code 416
         */
        @JSONField(name = "high_priority_policy")
        private Integer highPriorityPolicy;
        
        /**
         * Default constructor
         */
        public NotificationConfig() {
        }
        
        /**
         * Get whether to send change notifications
         * 
         * @return whether to send change notifications
         */
        public Boolean getNotificationEnabled() {
            return notificationEnabled;
        }
        
        /**
         * Set whether to send change notifications
         * 
         * @param notificationEnabled whether to send change notifications
         */
        public void setNotificationEnabled(Boolean notificationEnabled) {
            this.notificationEnabled = notificationEnabled;
        }
        
        /**
         * Get extension field for notification events
         * 
         * @return extension field for notification events
         */
        public String getNotificationExtension() {
            return notificationExtension;
        }
        
        /**
         * Set extension field for notification events
         * 
         * @param notificationExtension extension field for notification events
         */
        public void setNotificationExtension(String notificationExtension) {
            this.notificationExtension = notificationExtension;
        }
        
        /**
         * Get whether to set the queue change notification as high priority
         * 
         * @return whether to set the queue change notification as high priority
         */
        public Integer getHighPriority() {
            return highPriority;
        }
        
        /**
         * Set whether to set the queue change notification as high priority
         * 
         * @param highPriority whether to set the queue change notification as high priority
         */
        public void setHighPriority(Integer highPriority) {
            this.highPriority = highPriority;
        }
        
        /**
         * Get high priority message policy
         * 
         * @return high priority message policy
         */
        public Integer getHighPriorityPolicy() {
            return highPriorityPolicy;
        }
        
        /**
         * Set high priority message policy
         * 
         * @param highPriorityPolicy high priority message policy
         */
        public void setHighPriorityPolicy(Integer highPriorityPolicy) {
            this.highPriorityPolicy = highPriorityPolicy;
        }
    }
    
    /**
     * Route configuration for message forwarding
     */
    public static class RouteConfig {
        
        /**
         * Whether to forward messages to the application server
         * Default is true
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;
        
        /**
         * Environment to forward messages to
         * Corresponds to the custom environment name configured in the Yunxin console
         */
        @JSONField(name = "route_environment")
        private String routeEnvironment;
        
        /**
         * Default constructor
         */
        public RouteConfig() {
        }
        
        /**
         * Constructor with routeEnabled and routeEnvironment
         * 
         * @param routeEnabled whether to forward messages
         * @param routeEnvironment environment to forward messages to
         */
        public RouteConfig(Boolean routeEnabled, String routeEnvironment) {
            this.routeEnabled = routeEnabled;
            this.routeEnvironment = routeEnvironment;
        }
        
        /**
         * Get whether to forward messages
         * 
         * @return whether to forward messages
         */
        public Boolean getRouteEnabled() {
            return routeEnabled;
        }
        
        /**
         * Set whether to forward messages
         * 
         * @param routeEnabled whether to forward messages
         */
        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }
        
        /**
         * Get environment to forward messages to
         * 
         * @return environment to forward messages to
         */
        public String getRouteEnvironment() {
            return routeEnvironment;
        }
        
        /**
         * Set environment to forward messages to
         * 
         * @param routeEnvironment environment to forward messages to
         */
        public void setRouteEnvironment(String routeEnvironment) {
            this.routeEnvironment = routeEnvironment;
        }
    }
} 