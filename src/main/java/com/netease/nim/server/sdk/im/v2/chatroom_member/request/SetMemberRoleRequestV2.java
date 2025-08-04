package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class SetMemberRoleRequestV2 {

    
    @JSONField(serialize = false)
    private String accountId;
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    
    @JSONField(name = "member_role")
    private Integer memberRole;
    
    
    @JSONField(name = "room_nick")
    private String roomNick;
    
    
    @JSONField(name = "room_avatar")
    private String roomAvatar;
    
    
    @JSONField(name = "member_level")
    private Integer memberLevel;
    
    
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
    
    
    public SetMemberRoleRequestV2() {
    }
    
    
    public SetMemberRoleRequestV2(Long roomId, Integer memberRole) {
        this.roomId = roomId;
        this.memberRole = memberRole;
    }
    
    
    public SetMemberRoleRequestV2(Long roomId, String operatorAccountId, Integer memberRole) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.memberRole = memberRole;
    }
    
    
    public SetMemberRoleRequestV2(String accountId, Long roomId, String operatorAccountId, Integer memberRole) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.memberRole = memberRole;
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
    
    
    public Integer getMemberRole() {
        return memberRole;
    }
    
    
    public void setMemberRole(Integer memberRole) {
        this.memberRole = memberRole;
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
    
    
    public Integer getMemberLevel() {
        return memberLevel;
    }
    
    
    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
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