package com.netease.nim.im.server.sdk.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for updating chatroom information
 * 
 * This class encapsulates the parameters required to update chatroom information.
 */
public class UpdateChatroomInfoRequestV2 {

    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Chatroom name
     * Maximum length: 128 characters
     * Subject to anti-spam checks
     */
    @JSONField(name = "room_name")
    private String roomName;
    
    /**
     * Chatroom announcement
     * Maximum length: 4096 characters
     * Subject to anti-spam checks
     */
    @JSONField(name = "announcement")
    private String announcement;
    
    /**
     * Live URL
     * Maximum length: 1024 characters
     */
    @JSONField(name = "live_url")
    private String liveUrl;
    
    /**
     * Custom extension field
     * Recommended to be in JSON format {key:value}
     * Maximum length: 4096 characters
     * Subject to anti-spam checks
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Queue management permission level
     * 0 (default): Everyone has permission to modify the queue
     * 1: Only administrators can modify the queue
     */
    @JSONField(name = "queue_level")
    private Integer queueLevel;
    
    /**
     * Whether to send chatroom update notification
     * false (default): Don't send
     * true: Send
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Notification event extension field
     * Maximum length: 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Antispam configuration
     */
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration;
    
    /**
     * Default constructor
     */
    public UpdateChatroomInfoRequestV2() {
    }
    
    /**
     * Nested class for antispam configuration
     */
    public static class AntispamConfiguration {
        
        /**
         * Whether to enable antispam
         * Default is true (enabled)
         */
        @JSONField(name = "enabled")
        private Boolean enabled;
        
        /**
         * Antispam business ID maps
         */
        @JSONField(name = "business_id_map")
        private List<BusinessIdMap> businessIdMap;
        
        /**
         * Default constructor
         */
        public AntispamConfiguration() {
        }
        
        /**
         * Get whether antispam is enabled
         * 
         * @return Whether antispam is enabled
         */
        public Boolean getEnabled() {
            return enabled;
        }
        
        /**
         * Set whether antispam is enabled
         * 
         * @param enabled Whether antispam is enabled
         */
        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }
        
        /**
         * Get the business ID maps
         * 
         * @return The business ID maps
         */
        public List<BusinessIdMap> getBusinessIdMap() {
            return businessIdMap;
        }
        
        /**
         * Set the business ID maps
         * 
         * @param businessIdMap The business ID maps
         */
        public void setBusinessIdMap(List<BusinessIdMap> businessIdMap) {
            this.businessIdMap = businessIdMap;
        }
    }
    
    /**
     * Nested class for business ID map
     */
    public static class BusinessIdMap {
        
        /**
         * Detection type
         * 1: Text
         * 2: Image
         */
        @JSONField(name = "type")
        private Integer type;
        
        /**
         * Business ID for the antispam service
         */
        @JSONField(name = "business_id")
        private String businessId;
        
        /**
         * Default constructor
         */
        public BusinessIdMap() {
        }
        
        /**
         * Get the detection type
         * 
         * @return The detection type
         */
        public Integer getType() {
            return type;
        }
        
        /**
         * Set the detection type
         * 
         * @param type The detection type (1: Text, 2: Image)
         */
        public void setType(Integer type) {
            this.type = type;
        }
        
        /**
         * Get the business ID
         * 
         * @return The business ID
         */
        public String getBusinessId() {
            return businessId;
        }
        
        /**
         * Set the business ID
         * 
         * @param businessId The business ID
         */
        public void setBusinessId(String businessId) {
            this.businessId = businessId;
        }
    }
    
    /**
     * Get the chatroom ID
     * 
     * @return The chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the chatroom ID
     * 
     * @param roomId The chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get the chatroom name
     * 
     * @return The chatroom name
     */
    public String getRoomName() {
        return roomName;
    }
    
    /**
     * Set the chatroom name
     * 
     * @param roomName The chatroom name
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    /**
     * Get the chatroom announcement
     * 
     * @return The chatroom announcement
     */
    public String getAnnouncement() {
        return announcement;
    }
    
    /**
     * Set the chatroom announcement
     * 
     * @param announcement The chatroom announcement
     */
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
    
    /**
     * Get the live URL
     * 
     * @return The live URL
     */
    public String getLiveUrl() {
        return liveUrl;
    }
    
    /**
     * Set the live URL
     * 
     * @param liveUrl The live URL
     */
    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }
    
    /**
     * Get the custom extension
     * 
     * @return The custom extension
     */
    public String getExtension() {
        return extension;
    }
    
    /**
     * Set the custom extension
     * 
     * @param extension The custom extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    /**
     * Get the queue level
     * 
     * @return The queue level
     */
    public Integer getQueueLevel() {
        return queueLevel;
    }
    
    /**
     * Set the queue level
     * 
     * @param queueLevel The queue level (0: Everyone, 1: Only admins)
     */
    public void setQueueLevel(Integer queueLevel) {
        this.queueLevel = queueLevel;
    }
    
    /**
     * Get whether notification is enabled
     * 
     * @return Whether notification is enabled
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set whether notification is enabled
     * 
     * @param notificationEnabled Whether notification is enabled
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    /**
     * Get the notification extension
     * 
     * @return The notification extension
     */
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    /**
     * Set the notification extension
     * 
     * @param notificationExtension The notification extension
     */
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
    
    /**
     * Get the antispam configuration
     * 
     * @return The antispam configuration
     */
    public AntispamConfiguration getAntispamConfiguration() {
        return antispamConfiguration;
    }
    
    /**
     * Set the antispam configuration
     * 
     * @param antispamConfiguration The antispam configuration
     */
    public void setAntispamConfiguration(AntispamConfiguration antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
    }
} 