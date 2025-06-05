package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for updating online chatroom member information
 * 
 * This class encapsulates the parameters required to update an online chatroom member's information,
 * including nickname, avatar, and extension data.
 */
public class UpdateOnlineMemberInfoRequestV2 {

    /**
     * Account ID of the member (not serialized to JSON)
     */
    private String accountId;
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Whether to modify the persistent information of fixed members
     * false (default): Do not persist
     * true: Persist
     * 
     * Note:
     * - This parameter only affects fixed members, not guests
     * - If a fixed member is offline and persistence is false, the API will return an error
     */
    @JSONField(name = "persistence")
    private Boolean persistence;
    
    /**
     * Member's nickname in the chatroom
     */
    @JSONField(name = "room_nick")
    private String roomNick;
    
    /**
     * Member's avatar in the chatroom
     */
    @JSONField(name = "room_avatar")
    private String roomAvatar;
    
    /**
     * Custom extension field, maximum 4096 characters
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Whether to send a notification after the operation
     * false (default): No notification
     * true: Send notification
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Notification extension field, JSON format, max length 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Antispam configuration
     */
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration;
    
    /**
     * Antispam configuration class
     */
    public static class AntispamConfiguration {
        
        /**
         * Whether to enable antispam
         * Default is true
         */
        @JSONField(name = "enabled")
        private Boolean enabled;
        
        /**
         * Business ID mapping
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
         * @return true if enabled, false otherwise
         */
        public Boolean getEnabled() {
            return enabled;
        }
        
        /**
         * Set whether antispam is enabled
         * 
         * @param enabled true to enable, false to disable
         */
        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }
        
        /**
         * Get business ID mapping
         * 
         * @return the list of business ID mappings
         */
        public List<BusinessIdMap> getBusinessIdMap() {
            return businessIdMap;
        }
        
        /**
         * Set business ID mapping
         * 
         * @param businessIdMap the list of business ID mappings
         */
        public void setBusinessIdMap(List<BusinessIdMap> businessIdMap) {
            this.businessIdMap = businessIdMap;
        }
    }
    
    /**
     * Business ID mapping class
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
         * Business ID
         */
        @JSONField(name = "business_id")
        private String businessId;
        
        /**
         * Default constructor
         */
        public BusinessIdMap() {
        }
        
        /**
         * Get detection type
         * 
         * @return the detection type
         */
        public Integer getType() {
            return type;
        }
        
        /**
         * Set detection type
         * 
         * @param type the detection type
         */
        public void setType(Integer type) {
            this.type = type;
        }
        
        /**
         * Get business ID
         * 
         * @return the business ID
         */
        public String getBusinessId() {
            return businessId;
        }
        
        /**
         * Set business ID
         * 
         * @param businessId the business ID
         */
        public void setBusinessId(String businessId) {
            this.businessId = businessId;
        }
    }
    
    /**
     * Default constructor
     */
    public UpdateOnlineMemberInfoRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId the chatroom ID
     */
    public UpdateOnlineMemberInfoRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Constructor with roomId and persistence flag
     * 
     * @param roomId the chatroom ID
     * @param persistence whether to persist changes for fixed members
     */
    public UpdateOnlineMemberInfoRequestV2(Long roomId, Boolean persistence) {
        this.roomId = roomId;
        this.persistence = persistence;
    }
    
    /**
     * Constructor with accountId and roomId
     * 
     * @param accountId the account ID of the member
     * @param roomId the chatroom ID
     */
    public UpdateOnlineMemberInfoRequestV2(String accountId, Long roomId) {
        this.accountId = accountId;
        this.roomId = roomId;
    }
    
    /**
     * Constructor with accountId, roomId and persistence flag
     * 
     * @param accountId the account ID of the member
     * @param roomId the chatroom ID
     * @param persistence whether to persist changes for fixed members
     */
    public UpdateOnlineMemberInfoRequestV2(String accountId, Long roomId, Boolean persistence) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.persistence = persistence;
    }
    
    /**
     * Get the chatroom ID
     * 
     * @return the chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the chatroom ID
     * 
     * @param roomId the chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Check if changes should be persisted for fixed members
     * 
     * @return true if changes should be persisted, false otherwise
     */
    public Boolean getPersistence() {
        return persistence;
    }
    
    /**
     * Set whether changes should be persisted for fixed members
     * 
     * @param persistence true to persist changes, false otherwise
     */
    public void setPersistence(Boolean persistence) {
        this.persistence = persistence;
    }
    
    /**
     * Get the room nickname
     * 
     * @return the room nickname
     */
    public String getRoomNick() {
        return roomNick;
    }
    
    /**
     * Set the room nickname
     * 
     * @param roomNick the room nickname
     */
    public void setRoomNick(String roomNick) {
        this.roomNick = roomNick;
    }
    
    /**
     * Get the room avatar
     * 
     * @return the room avatar
     */
    public String getRoomAvatar() {
        return roomAvatar;
    }
    
    /**
     * Set the room avatar
     * 
     * @param roomAvatar the room avatar
     */
    public void setRoomAvatar(String roomAvatar) {
        this.roomAvatar = roomAvatar;
    }
    
    /**
     * Get the extension
     * 
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }
    
    /**
     * Set the extension
     * 
     * @param extension the extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    /**
     * Check if notification is enabled
     * 
     * @return true if notification is enabled, false otherwise
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set whether notification is enabled
     * 
     * @param notificationEnabled true to enable notification, false to disable
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    /**
     * Get the notification extension
     * 
     * @return the notification extension
     */
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    /**
     * Set the notification extension
     * 
     * @param notificationExtension the notification extension
     */
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
    
    /**
     * Get the antispam configuration
     * 
     * @return the antispam configuration
     */
    public AntispamConfiguration getAntispamConfiguration() {
        return antispamConfiguration;
    }
    
    /**
     * Set the antispam configuration
     * 
     * @param antispamConfiguration the antispam configuration
     */
    public void setAntispamConfiguration(AntispamConfiguration antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
    }
    
    /**
     * Get the account ID
     * 
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Set the account ID
     * 
     * @param accountId the account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 