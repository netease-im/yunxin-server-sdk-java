package com.netease.nim.im.server.sdk.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for updating a chatroom queue
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/room_queues/{room_id}
 */
public class UpdateChatroomQueueRequestV2 {
    
    /**
     * Chatroom ID
     */
    private Long roomId;
    
    /**
     * Operator account ID
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * List of queue elements to add or update
     */
    @JSONField(name = "element_list")
    private List<QueueElement> elementList;
    
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
    public UpdateChatroomQueueRequestV2() {
    }
    
    /**
     * Constructor with roomId and operatorAccountId
     * 
     * @param roomId chatroom ID
     * @param operatorAccountId operator account ID
     */
    public UpdateChatroomQueueRequestV2(Long roomId, String operatorAccountId) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
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
     * Get operator account ID
     * 
     * @return operator account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set operator account ID
     * 
     * @param operatorAccountId operator account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get queue elements list
     * 
     * @return queue elements list
     */
    public List<QueueElement> getElementList() {
        return elementList;
    }
    
    /**
     * Set queue elements list
     * 
     * @param elementList queue elements list
     */
    public void setElementList(List<QueueElement> elementList) {
        this.elementList = elementList;
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
     * Queue element for adding or updating
     */
    public static class QueueElement {
        
        /**
         * Element key
         */
        @JSONField(name = "element_key")
        private String elementKey;
        
        /**
         * Element value
         */
        @JSONField(name = "element_value")
        private String elementValue;
        
        /**
         * Element owner account ID
         * If not provided, it defaults to operatorAccountId
         */
        @JSONField(name = "element_account_id")
        private String elementAccountId;
        
        /**
         * Whether the element is removed when the owner leaves the chatroom
         * Default is false (persistent)
         */
        @JSONField(name = "element_transient")
        private Boolean elementTransient;
        
        /**
         * Element add policy
         * 0: Only add if key doesn't exist
         * 1: Only update if key exists
         * 2: Add or update (default)
         */
        @JSONField(name = "element_add_policy")
        private Integer elementAddPolicy;
        
        /**
         * Default constructor
         */
        public QueueElement() {
        }
        
        /**
         * Constructor with key and value
         * 
         * @param elementKey element key
         * @param elementValue element value
         */
        public QueueElement(String elementKey, String elementValue) {
            this.elementKey = elementKey;
            this.elementValue = elementValue;
        }
        
        /**
         * Get element key
         * 
         * @return element key
         */
        public String getElementKey() {
            return elementKey;
        }
        
        /**
         * Set element key
         * 
         * @param elementKey element key
         */
        public void setElementKey(String elementKey) {
            this.elementKey = elementKey;
        }
        
        /**
         * Get element value
         * 
         * @return element value
         */
        public String getElementValue() {
            return elementValue;
        }
        
        /**
         * Set element value
         * 
         * @param elementValue element value
         */
        public void setElementValue(String elementValue) {
            this.elementValue = elementValue;
        }
        
        /**
         * Get element owner account ID
         * 
         * @return element owner account ID
         */
        public String getElementAccountId() {
            return elementAccountId;
        }
        
        /**
         * Set element owner account ID
         * 
         * @param elementAccountId element owner account ID
         */
        public void setElementAccountId(String elementAccountId) {
            this.elementAccountId = elementAccountId;
        }
        
        /**
         * Get whether the element is removed when the owner leaves the chatroom
         * 
         * @return whether the element is removed when the owner leaves the chatroom
         */
        public Boolean getElementTransient() {
            return elementTransient;
        }
        
        /**
         * Set whether the element is removed when the owner leaves the chatroom
         * 
         * @param elementTransient whether the element is removed when the owner leaves the chatroom
         */
        public void setElementTransient(Boolean elementTransient) {
            this.elementTransient = elementTransient;
        }
        
        /**
         * Get element add policy
         * 
         * @return element add policy
         */
        public Integer getElementAddPolicy() {
            return elementAddPolicy;
        }
        
        /**
         * Set element add policy
         * 
         * @param elementAddPolicy element add policy
         */
        public void setElementAddPolicy(Integer elementAddPolicy) {
            this.elementAddPolicy = elementAddPolicy;
        }
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