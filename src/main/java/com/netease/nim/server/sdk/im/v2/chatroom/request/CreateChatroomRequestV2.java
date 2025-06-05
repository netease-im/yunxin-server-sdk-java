package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for creating a chatroom
 * 
 * API: POST https://open.yunxinapi.com/im/v2/chatrooms
 */
public class CreateChatroomRequestV2 {
    
    @JSONField(name = "creator")
    private String creator;                // Chatroom creator's account ID
    
    @JSONField(name = "room_name")
    private String roomName;               // Chatroom name (max 128 characters)
    
    @JSONField(name = "announcement")
    private String announcement;           // Chatroom announcement (max 4096 characters)
    
    @JSONField(name = "live_url")
    private String liveUrl;                // Live broadcast URL (max 1024 characters)
    
    @JSONField(name = "extension")
    private String extension;              // Custom extension field (max 4096 characters)
    
    @JSONField(name = "queue_level")
    private Integer queueLevel;            // Queue management permission level
    
    @JSONField(name = "delay_close_policy")
    private Integer delayClosePolicy;      // Chatroom auto-close policy
    
    @JSONField(name = "delay_seconds")
    private Long delaySeconds;             // Chatroom auto-close time in seconds
    
    @JSONField(name = "in_out_notification")
    private Boolean inOutNotification;     // Whether to enable entry/exit event notifications
    
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration; // Antispam configuration
    
    /**
     * Default constructor
     */
    public CreateChatroomRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param creator Chatroom creator's account ID
     * @param roomName Chatroom name
     */
    public CreateChatroomRequestV2(String creator, String roomName) {
        this.creator = creator;
        this.roomName = roomName;
    }
    
    /**
     * Inner class for antispam configuration
     */
    public static class AntispamConfiguration {
        
        @JSONField(name = "enabled")
        private Boolean enabled;           // Whether to enable antispam
        
        @JSONField(name = "business_id_map")
        private List<BusinessIdMap> businessIdMap; // Antispam business ID mappings
        
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
    
    /**
     * Inner class for antispam business ID mapping
     */
    public static class BusinessIdMap {
        
        @JSONField(name = "type")
        private Integer type;              // Detection type (1: text, 2: image)
        
        @JSONField(name = "business_id")
        private String businessId;         // Antispam business ID
        
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
    
    // Getters and setters
    
    public String getCreator() {
        return creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
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
    
    public Integer getDelayClosePolicy() {
        return delayClosePolicy;
    }
    
    public void setDelayClosePolicy(Integer delayClosePolicy) {
        this.delayClosePolicy = delayClosePolicy;
    }
    
    public Long getDelaySeconds() {
        return delaySeconds;
    }
    
    public void setDelaySeconds(Long delaySeconds) {
        this.delaySeconds = delaySeconds;
    }
    
    public Boolean getInOutNotification() {
        return inOutNotification;
    }
    
    public void setInOutNotification(Boolean inOutNotification) {
        this.inOutNotification = inOutNotification;
    }
    
    public AntispamConfiguration getAntispamConfiguration() {
        return antispamConfiguration;
    }
    
    public void setAntispamConfiguration(AntispamConfiguration antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
    }
} 