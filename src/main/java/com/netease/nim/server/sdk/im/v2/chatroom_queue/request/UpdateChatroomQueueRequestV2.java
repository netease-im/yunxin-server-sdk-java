package com.netease.nim.server.sdk.im.v2.chatroom_queue.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class UpdateChatroomQueueRequestV2 {
    
    
    private Long roomId;
    
    
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    
    @JSONField(name = "element_list")
    private List<QueueElement> elementList;
    
    
    @JSONField(name = "notification_config")
    private NotificationConfig notificationConfig;
    
    
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    
    public UpdateChatroomQueueRequestV2() {
    }
    
    
    public UpdateChatroomQueueRequestV2(Long roomId, String operatorAccountId) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    
    public List<QueueElement> getElementList() {
        return elementList;
    }
    
    
    public void setElementList(List<QueueElement> elementList) {
        this.elementList = elementList;
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
    
    
    public static class QueueElement {
        
        
        @JSONField(name = "element_key")
        private String elementKey;
        
        
        @JSONField(name = "element_value")
        private String elementValue;
        
        
        @JSONField(name = "element_account_id")
        private String elementAccountId;
        
        
        @JSONField(name = "element_transient")
        private Boolean elementTransient;
        
        
        @JSONField(name = "element_add_policy")
        private Integer elementAddPolicy;
        
        
        public QueueElement() {
        }
        
        
        public QueueElement(String elementKey, String elementValue) {
            this.elementKey = elementKey;
            this.elementValue = elementValue;
        }
        
        
        public String getElementKey() {
            return elementKey;
        }
        
        
        public void setElementKey(String elementKey) {
            this.elementKey = elementKey;
        }
        
        
        public String getElementValue() {
            return elementValue;
        }
        
        
        public void setElementValue(String elementValue) {
            this.elementValue = elementValue;
        }
        
        
        public String getElementAccountId() {
            return elementAccountId;
        }
        
        
        public void setElementAccountId(String elementAccountId) {
            this.elementAccountId = elementAccountId;
        }
        
        
        public Boolean getElementTransient() {
            return elementTransient;
        }
        
        
        public void setElementTransient(Boolean elementTransient) {
            this.elementTransient = elementTransient;
        }
        
        
        public Integer getElementAddPolicy() {
            return elementAddPolicy;
        }
        
        
        public void setElementAddPolicy(Integer elementAddPolicy) {
            this.elementAddPolicy = elementAddPolicy;
        }
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