package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class UpdateChatroomInfoRequestV2 {

    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "room_name")
    private String roomName;
    
    
    @JSONField(name = "announcement")
    private String announcement;
    
    
    @JSONField(name = "live_url")
    private String liveUrl;
    
    
    @JSONField(name = "extension")
    private String extension;
    
    
    @JSONField(name = "queue_level")
    private Integer queueLevel;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration;
    
    
    public UpdateChatroomInfoRequestV2() {
    }
    
    
    public static class AntispamConfiguration {
        
        
        @JSONField(name = "enabled")
        private Boolean enabled;
        
        
        @JSONField(name = "business_id_map")
        private List<BusinessIdMap> businessIdMap;
        
        
        public AntispamConfiguration() {
        }
        
        
        public Boolean getEnabled() {
            return enabled;
        }
        
        
        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }
        
        
        public List<BusinessIdMap> getBusinessIdMap() {
            return businessIdMap;
        }
        
        
        public void setBusinessIdMap(List<BusinessIdMap> businessIdMap) {
            this.businessIdMap = businessIdMap;
        }
    }
    
    
    public static class BusinessIdMap {
        
        
        @JSONField(name = "type")
        private Integer type;
        
        
        @JSONField(name = "business_id")
        private String businessId;
        
        
        public BusinessIdMap() {
        }
        
        
        public Integer getType() {
            return type;
        }
        
        
        public void setType(Integer type) {
            this.type = type;
        }
        
        
        public String getBusinessId() {
            return businessId;
        }
        
        
        public void setBusinessId(String businessId) {
            this.businessId = businessId;
        }
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public String getRoomName() {
        return roomName;
    }
    
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    
    public String getAnnouncement() {
        return announcement;
    }
    
    
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
    
    
    public String getLiveUrl() {
        return liveUrl;
    }
    
    
    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }
    
    
    public String getExtension() {
        return extension;
    }
    
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    
    public Integer getQueueLevel() {
        return queueLevel;
    }
    
    
    public void setQueueLevel(Integer queueLevel) {
        this.queueLevel = queueLevel;
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
    
    
    public AntispamConfiguration getAntispamConfiguration() {
        return antispamConfiguration;
    }
    
    
    public void setAntispamConfiguration(AntispamConfiguration antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
    }
} 