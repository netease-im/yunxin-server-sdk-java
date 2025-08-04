package com.netease.nim.server.sdk.im.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class DeleteChatroomQueueRequestV2 {
    
    
    private Long roomId;
    
    
    @JSONField(name = "notification_config")
    private NotificationConfig notificationConfig;
    
    
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    
    public DeleteChatroomQueueRequestV2() {
    }
    
    
    public DeleteChatroomQueueRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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