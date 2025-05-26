package com.netease.nim.im.server.sdk.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for querying chatroom queue elements
 */
public class QueryChatroomQueueElementsRequestV2 {
    
    private Long roomId;
    private List<String> elementKeyList;
    private RouteConfig routeConfig;
    
    public QueryChatroomQueueElementsRequestV2() {}
    
    public QueryChatroomQueueElementsRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    public Long getRoomId() {
        return roomId;
    }
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    @JSONField(name = "element_key_list")
    public List<String> getElementKeyList() {
        return elementKeyList;
    }
    
    public void setElementKeyList(List<String> elementKeyList) {
        this.elementKeyList = elementKeyList;
    }
    
    @JSONField(name = "route_config")
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }
    
    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
    
    public static class RouteConfig {
        private Boolean routeEnabled;
        private String routeEnvironment;
        
        public RouteConfig() {}
        
        @JSONField(name = "route_enabled")
        public Boolean getRouteEnabled() {
            return routeEnabled;
        }
        
        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }
        
        @JSONField(name = "route_environment")
        public String getRouteEnvironment() {
            return routeEnvironment;
        }
        
        public void setRouteEnvironment(String routeEnvironment) {
            this.routeEnvironment = routeEnvironment;
        }
    }
} 