package com.netease.nim.im.server.sdk.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for initializing a chatroom queue
 * 
 * API: POST https://open.yunxinapi.com/im/v2/room_queues/{room_id}
 */
public class InitializeChatroomQueueRequestV2 {
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Maximum number of elements in the queue
     * Value range: 0-1000, default is 100
     */
    @JSONField(name = "queue_size_limit")
    private Integer queueSizeLimit;
    
    /**
     * Route configuration for message forwarding
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    /**
     * Default constructor
     */
    public InitializeChatroomQueueRequestV2() {
    }
    
    /**
     * Constructor with roomId
     * 
     * @param roomId chatroom ID
     */
    public InitializeChatroomQueueRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Constructor with roomId and queueSizeLimit
     * 
     * @param roomId chatroom ID
     * @param queueSizeLimit maximum number of elements in the queue
     */
    public InitializeChatroomQueueRequestV2(Long roomId, Integer queueSizeLimit) {
        this.roomId = roomId;
        this.queueSizeLimit = queueSizeLimit;
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
     * Get queue size limit
     * 
     * @return queue size limit
     */
    public Integer getQueueSizeLimit() {
        return queueSizeLimit;
    }
    
    /**
     * Set queue size limit
     * 
     * @param queueSizeLimit queue size limit
     */
    public void setQueueSizeLimit(Integer queueSizeLimit) {
        this.queueSizeLimit = queueSizeLimit;
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