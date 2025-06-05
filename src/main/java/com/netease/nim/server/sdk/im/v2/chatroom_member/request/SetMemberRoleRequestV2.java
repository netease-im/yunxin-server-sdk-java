package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for setting chatroom member role
 * 
 * This class encapsulates the parameters required to set a chatroom member's role and attributes.
 */
public class SetMemberRoleRequestV2 {

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
     * Operator account ID
     * Only the chatroom creator or administrators can set other users' roles
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Member role to set
     * 0: Regular member (can be set by creator or admin)
     * 2: Administrator (can only be set by creator)
     * 3: Guest (removing fixed member status, can be set by creator or admin)
     */
    @JSONField(name = "member_role")
    private Integer memberRole;
    
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
     * Member's level
     */
    @JSONField(name = "member_level")
    private Integer memberLevel;
    
    /**
     * Custom extension field
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
    public SetMemberRoleRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId the chatroom ID
     * @param memberRole the role to set
     */
    public SetMemberRoleRequestV2(Long roomId, Integer memberRole) {
        this.roomId = roomId;
        this.memberRole = memberRole;
    }
    
    /**
     * Constructor with roomId, memberRole and operatorAccountId
     * 
     * @param roomId the chatroom ID
     * @param operatorAccountId the operator account ID
     * @param memberRole the role to set
     */
    public SetMemberRoleRequestV2(Long roomId, String operatorAccountId, Integer memberRole) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.memberRole = memberRole;
    }
    
    /**
     * Constructor with accountId, roomId, operatorAccountId, and memberRole
     * 
     * @param accountId the account ID of the member
     * @param roomId the chatroom ID
     * @param operatorAccountId the operator account ID
     * @param memberRole the role to set
     */
    public SetMemberRoleRequestV2(String accountId, Long roomId, String operatorAccountId, Integer memberRole) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.memberRole = memberRole;
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
     * Get the operator account ID
     * 
     * @return the operator account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set the operator account ID
     * 
     * @param operatorAccountId the operator account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get the member role to set
     * 
     * @return the member role
     */
    public Integer getMemberRole() {
        return memberRole;
    }
    
    /**
     * Set the member role
     * 
     * @param memberRole the member role
     */
    public void setMemberRole(Integer memberRole) {
        this.memberRole = memberRole;
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
     * Get the member level
     * 
     * @return the member level
     */
    public Integer getMemberLevel() {
        return memberLevel;
    }
    
    /**
     * Set the member level
     * 
     * @param memberLevel the member level
     */
    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
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