package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class CreateTeamRequestV2 {
    
    
    @JSONField(name = "owner_account_id")
    private String ownerAccountId;
    
    
    @JSONField(name = "team_type")
    private Integer teamType;
    
    
    @JSONField(name = "name")
    private String name;
    
    
    @JSONField(name = "icon")
    private String icon;
    
    
    @JSONField(name = "announcement")
    private String announcement;
    
    
    @JSONField(name = "intro")
    private String intro;
    
    
    @JSONField(name = "members_limit")
    private Integer membersLimit;
    
    
    @JSONField(name = "server_extension")
    private String serverExtension;
    
    
    @JSONField(name = "customer_extension")
    private String customerExtension;
    
    
    @JSONField(name = "invite_account_ids")
    private List<String> inviteAccountIds;
    
    
    @JSONField(name = "invite_msg")
    private String inviteMsg;
    
    
    @JSONField(name = "extension")
    private String extension;
    
    
    @JSONField(name = "configuration")
    private Configuration configuration;
    
    
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration;
    
    // Inner classes for nested objects
    
    
    public static class Configuration {
        
        
        @JSONField(name = "join_mode")
        private Integer joinMode;
        
        
        @JSONField(name = "agree_mode")
        private Integer agreeMode;
        
        
        @JSONField(name = "invite_mode")
        private Integer inviteMode;
        
        
        @JSONField(name = "update_team_info_mode")
        private Integer updateTeamInfoMode;
        
        
        @JSONField(name = "update_extension_mode")
        private Integer updateExtensionMode;
        
        public Integer getJoinMode() {
            return joinMode;
        }
        
        public void setJoinMode(Integer joinMode) {
            this.joinMode = joinMode;
        }
        
        public Integer getAgreeMode() {
            return agreeMode;
        }
        
        public void setAgreeMode(Integer agreeMode) {
            this.agreeMode = agreeMode;
        }
        
        public Integer getInviteMode() {
            return inviteMode;
        }
        
        public void setInviteMode(Integer inviteMode) {
            this.inviteMode = inviteMode;
        }
        
        public Integer getUpdateTeamInfoMode() {
            return updateTeamInfoMode;
        }
        
        public void setUpdateTeamInfoMode(Integer updateTeamInfoMode) {
            this.updateTeamInfoMode = updateTeamInfoMode;
        }
        
        public Integer getUpdateExtensionMode() {
            return updateExtensionMode;
        }
        
        public void setUpdateExtensionMode(Integer updateExtensionMode) {
            this.updateExtensionMode = updateExtensionMode;
        }
    }
    
    
    public static class AntispamConfiguration {
        
        
        @JSONField(name = "enabled")
        private Boolean enabled;
        
        
        @JSONField(name = "business_id_map")
        private List<BusinessIdMap> businessIdMap;
        
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
    
    public String getOwnerAccountId() {
        return ownerAccountId;
    }
    
    public void setOwnerAccountId(String ownerAccountId) {
        this.ownerAccountId = ownerAccountId;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getAnnouncement() {
        return announcement;
    }
    
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
    
    public String getIntro() {
        return intro;
    }
    
    public void setIntro(String intro) {
        this.intro = intro;
    }
    
    public Integer getMembersLimit() {
        return membersLimit;
    }
    
    public void setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
    }
    
    public String getServerExtension() {
        return serverExtension;
    }
    
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }
    
    public String getCustomerExtension() {
        return customerExtension;
    }
    
    public void setCustomerExtension(String customerExtension) {
        this.customerExtension = customerExtension;
    }
    
    public List<String> getInviteAccountIds() {
        return inviteAccountIds;
    }
    
    public void setInviteAccountIds(List<String> inviteAccountIds) {
        this.inviteAccountIds = inviteAccountIds;
    }
    
    public String getInviteMsg() {
        return inviteMsg;
    }
    
    public void setInviteMsg(String inviteMsg) {
        this.inviteMsg = inviteMsg;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public Configuration getConfiguration() {
        return configuration;
    }
    
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
    
    public AntispamConfiguration getAntispamConfiguration() {
        return antispamConfiguration;
    }
    
    public void setAntispamConfiguration(AntispamConfiguration antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
    }

    public static CreateTeamRequestV2 createAdvancedTeam(String ownerAccountId, String name, List<String> inviteAccountIds, String inviteMsg) {
        CreateTeamRequestV2 request = new CreateTeamRequestV2();
        request.setOwnerAccountId(ownerAccountId);
        request.setTeamType(1); // Advanced team
        request.setName(name);
        request.setInviteAccountIds(inviteAccountIds);
        request.setInviteMsg(inviteMsg);
        
        // Create and set default configuration
        Configuration config = new Configuration();
        config.setJoinMode(0); // No verification needed
        request.setConfiguration(config);
        
        return request;
    }

    public static CreateTeamRequestV2 createSuperTeam(String ownerAccountId, String name, List<String> inviteAccountIds, String inviteMsg) {
        CreateTeamRequestV2 request = new CreateTeamRequestV2();
        request.setOwnerAccountId(ownerAccountId);
        request.setTeamType(2); // Super team
        request.setName(name);
        request.setInviteAccountIds(inviteAccountIds);
        request.setInviteMsg(inviteMsg);
        
        // Create and set default configuration
        Configuration config = new Configuration();
        config.setJoinMode(0); // No verification needed
        request.setConfiguration(config);
        
        return request;
    }
} 