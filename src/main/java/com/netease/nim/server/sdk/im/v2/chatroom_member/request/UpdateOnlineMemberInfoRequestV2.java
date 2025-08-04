package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class UpdateOnlineMemberInfoRequestV2 {

    
    @JSONField(serialize = false)
    private String accountId;
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "persistence")
    private Boolean persistence;
    
    
    @JSONField(name = "room_nick")
    private String roomNick;
    
    
    @JSONField(name = "room_avatar")
    private String roomAvatar;
    
    
    @JSONField(name = "extension")
    private String extension;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration;
    
    
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
    
    
    public UpdateOnlineMemberInfoRequestV2() {
    }
    
    
    public UpdateOnlineMemberInfoRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public UpdateOnlineMemberInfoRequestV2(Long roomId, Boolean persistence) {
        this.roomId = roomId;
        this.persistence = persistence;
    }
    
    
    public UpdateOnlineMemberInfoRequestV2(String accountId, Long roomId) {
        this.accountId = accountId;
        this.roomId = roomId;
    }
    
    
    public UpdateOnlineMemberInfoRequestV2(String accountId, Long roomId, Boolean persistence) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.persistence = persistence;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Boolean getPersistence() {
        return persistence;
    }
    
    
    public void setPersistence(Boolean persistence) {
        this.persistence = persistence;
    }
    
    
    public String getRoomNick() {
        return roomNick;
    }
    
    
    public void setRoomNick(String roomNick) {
        this.roomNick = roomNick;
    }
    
    
    public String getRoomAvatar() {
        return roomAvatar;
    }
    
    
    public void setRoomAvatar(String roomAvatar) {
        this.roomAvatar = roomAvatar;
    }
    
    
    public String getExtension() {
        return extension;
    }
    
    
    public void setExtension(String extension) {
        this.extension = extension;
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
    
    
    public String getAccountId() {
        return accountId;
    }
    
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 