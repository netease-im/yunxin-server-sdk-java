package com.netease.nim.server.sdk.im.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class InitializeChatroomQueueRequestV2 {
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "queue_size_limit")
    private Integer queueSizeLimit;
    
    
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    
    public InitializeChatroomQueueRequestV2() {
    }
    
    
    public InitializeChatroomQueueRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public InitializeChatroomQueueRequestV2(Long roomId, Integer queueSizeLimit) {
        this.roomId = roomId;
        this.queueSizeLimit = queueSizeLimit;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Integer getQueueSizeLimit() {
        return queueSizeLimit;
    }
    
    
    public void setQueueSizeLimit(Integer queueSizeLimit) {
        this.queueSizeLimit = queueSizeLimit;
    }
    
    
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }
    
    
    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
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