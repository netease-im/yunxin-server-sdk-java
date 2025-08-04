package com.netease.nim.server.sdk.im.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class PollChatroomQueueElementRequestV2 {
    
    
    private Long roomId;
    
    
    @JSONField(name = "element_key")
    private String elementKey;
    
    
    @JSONField(name = "notification_config")
    private NotificationConfig notificationConfig;
    
    
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    
    public PollChatroomQueueElementRequestV2() {
    }
    
    
    public PollChatroomQueueElementRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public PollChatroomQueueElementRequestV2(Long roomId, String elementKey) {
        this.roomId = roomId;
        this.elementKey = elementKey;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public String getElementKey() {
        return elementKey;
    }
    
    
    public void setElementKey(String elementKey) {
        this.elementKey = elementKey;
    }
    
    
    public NotificationConfig getNotificationConfig() {
        return notificationConfig;
    }
    
    
    public void setNotificationConfig(NotificationConfig notificationConfig) {
        this.notificationConfig = notificationConfig;
    }
    
    
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }
    
    
    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
    
    
    public static class NotificationConfig {
        
        
        @JSONField(name = "notification_enabled")
        private Boolean notificationEnabled;
        
        
        @JSONField(name = "notification_extension")
        private String notificationExtension;
        
        
        @JSONField(name = "high_priority")
        private Integer highPriority;
        
        
        @JSONField(name = "high_priority_policy")
        private Integer highPriorityPolicy;
        
        
        public NotificationConfig() {
        }
        
        
        public Boolean getNotificationEnabled() {
            return notificationEnabled;
        }
        
        
        public void setNotificationEnabled(Boolean notificationEnabled) {
            this.notificationEnabled = notificationEnabled;
        }
        
        
        public String getNotificationExtension() {
            return notificationExtension;
        }
        
        
        public void setNotificationExtension(String notificationExtension) {
            this.notificationExtension = notificationExtension;
        }
        
        
        public Integer getHighPriority() {
            return highPriority;
        }
        
        
        public void setHighPriority(Integer highPriority) {
            this.highPriority = highPriority;
        }
        
        
        public Integer getHighPriorityPolicy() {
            return highPriorityPolicy;
        }
        
        
        public void setHighPriorityPolicy(Integer highPriorityPolicy) {
            this.highPriorityPolicy = highPriorityPolicy;
        }
    }
    
    
    public static class RouteConfig {
        
        
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;
        
        
        @JSONField(name = "route_environment")
        private String routeEnvironment;
        
        
        public RouteConfig() {
        }
        
        
        public RouteConfig(Boolean routeEnabled, String routeEnvironment) {
            this.routeEnabled = routeEnabled;
            this.routeEnvironment = routeEnvironment;
        }
        
        
        public Boolean getRouteEnabled() {
            return routeEnabled;
        }
        
        
        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }
        
        
        public String getRouteEnvironment() {
            return routeEnvironment;
        }
        
        
        public void setRouteEnvironment(String routeEnvironment) {
            this.routeEnvironment = routeEnvironment;
        }
    }
} 