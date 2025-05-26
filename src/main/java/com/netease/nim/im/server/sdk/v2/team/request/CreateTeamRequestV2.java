package com.netease.nim.im.server.sdk.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for creating a team
 * 
 * API: POST https://open.yunxinapi.com/im/v2.1/teams
 */
public class CreateTeamRequestV2 {
    
    /**
     * Team owner's account ID (required)
     */
    @JSONField(name = "owner_account_id")
    private String ownerAccountId;
    
    /**
     * Team type (required)
     * 1: Advanced team
     * 2: Super team
     */
    @JSONField(name = "team_type")
    private Integer teamType;
    
    /**
     * Team name (required)
     * Maximum length: 64 characters
     */
    @JSONField(name = "name")
    private String name;
    
    /**
     * Team icon URL
     * Maximum length: 1024 characters
     */
    @JSONField(name = "icon")
    private String icon;
    
    /**
     * Team announcement
     * Maximum length: 1024 characters
     */
    @JSONField(name = "announcement")
    private String announcement;
    
    /**
     * Team introduction
     * Maximum length: 512 characters
     */
    @JSONField(name = "intro")
    private String intro;
    
    /**
     * Maximum number of members (including owner)
     * Default: 200
     * Range: [2-200] or [2-custom limit set in console]
     */
    @JSONField(name = "members_limit")
    private Integer membersLimit;
    
    /**
     * Custom server extension field
     * Recommended format: JSONObject {key:value}
     * Maximum length: 1024 characters
     */
    @JSONField(name = "server_extension")
    private String serverExtension;
    
    /**
     * Custom client extension field
     * Server API can set this, SDK only passes it through
     */
    @JSONField(name = "customer_extension")
    private String customerExtension;
    
    /**
     * List of account IDs to invite
     * No need to include owner_account_id
     * Total number of members (including owner) should not exceed members_limit
     */
    @JSONField(name = "invite_account_ids")
    private List<String> inviteAccountIds;
    
    /**
     * Invitation message
     * Maximum length: 150 characters
     */
    @JSONField(name = "invite_msg")
    private String inviteMsg;
    
    /**
     * Custom extension field for notification
     * Not persisted, JSON format
     * Maximum length: 512 characters
     * Only valid for advanced teams
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Team configuration
     */
    @JSONField(name = "configuration")
    private Configuration configuration;
    
    /**
     * Antispam configuration
     */
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration;
    
    // Inner classes for nested objects
    
    /**
     * Team configuration settings
     */
    public static class Configuration {
        
        /**
         * Join mode - how to verify when applying to join via SDK
         * 0: No verification needed, join directly (default)
         * 1: Requires approval from owner or admin
         * 2: No one can apply to join
         */
        @JSONField(name = "join_mode")
        private Integer joinMode;
        
        /**
         * Agree mode - whether invited users need to accept invitation
         * 0: Requires acceptance (default)
         * 1: No acceptance needed, join directly
         */
        @JSONField(name = "agree_mode")
        private Integer agreeMode;
        
        /**
         * Invite mode - who can invite others
         * 0: Owner and admins only (default)
         * 1: Everyone
         */
        @JSONField(name = "invite_mode")
        private Integer inviteMode;
        
        /**
         * Update team info mode - who can modify team info
         * 0: Owner and admins only (default)
         * 1: Everyone
         */
        @JSONField(name = "update_team_info_mode")
        private Integer updateTeamInfoMode;
        
        /**
         * Update extension mode - who can modify custom extensions
         * 0: Owner and admins only (default)
         * 1: Everyone
         */
        @JSONField(name = "update_extension_mode")
        private Integer updateExtensionMode;
        
        public Integer getJoinMode() {
            return joinMode;
        }
        
        public Configuration setJoinMode(Integer joinMode) {
            this.joinMode = joinMode;
            return this;
        }
        
        public Integer getAgreeMode() {
            return agreeMode;
        }
        
        public Configuration setAgreeMode(Integer agreeMode) {
            this.agreeMode = agreeMode;
            return this;
        }
        
        public Integer getInviteMode() {
            return inviteMode;
        }
        
        public Configuration setInviteMode(Integer inviteMode) {
            this.inviteMode = inviteMode;
            return this;
        }
        
        public Integer getUpdateTeamInfoMode() {
            return updateTeamInfoMode;
        }
        
        public Configuration setUpdateTeamInfoMode(Integer updateTeamInfoMode) {
            this.updateTeamInfoMode = updateTeamInfoMode;
            return this;
        }
        
        public Integer getUpdateExtensionMode() {
            return updateExtensionMode;
        }
        
        public Configuration setUpdateExtensionMode(Integer updateExtensionMode) {
            this.updateExtensionMode = updateExtensionMode;
            return this;
        }
    }
    
    /**
     * Antispam configuration
     */
    public static class AntispamConfiguration {
        
        /**
         * Whether to enable antispam
         * Default: true
         */
        @JSONField(name = "enabled")
        private Boolean enabled;
        
        /**
         * Business ID mappings for various types of content
         */
        @JSONField(name = "business_id_map")
        private List<BusinessIdMap> businessIdMap;
        
        public Boolean getEnabled() {
            return enabled;
        }
        
        public AntispamConfiguration setEnabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }
        
        public List<BusinessIdMap> getBusinessIdMap() {
            return businessIdMap;
        }
        
        public AntispamConfiguration setBusinessIdMap(List<BusinessIdMap> businessIdMap) {
            this.businessIdMap = businessIdMap;
            return this;
        }
    }
    
    /**
     * Antispam business ID mapping
     */
    public static class BusinessIdMap {
        
        /**
         * Content type to check
         * 1: Text
         * 2: Image
         */
        @JSONField(name = "type")
        private Integer type;
        
        /**
         * Antispam business ID
         */
        @JSONField(name = "business_id")
        private String businessId;
        
        public Integer getType() {
            return type;
        }
        
        public BusinessIdMap setType(Integer type) {
            this.type = type;
            return this;
        }
        
        public String getBusinessId() {
            return businessId;
        }
        
        public BusinessIdMap setBusinessId(String businessId) {
            this.businessId = businessId;
            return this;
        }
    }
    
    // Getters and setters
    
    public String getOwnerAccountId() {
        return ownerAccountId;
    }
    
    public CreateTeamRequestV2 setOwnerAccountId(String ownerAccountId) {
        this.ownerAccountId = ownerAccountId;
        return this;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public CreateTeamRequestV2 setTeamType(Integer teamType) {
        this.teamType = teamType;
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public CreateTeamRequestV2 setName(String name) {
        this.name = name;
        return this;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public CreateTeamRequestV2 setIcon(String icon) {
        this.icon = icon;
        return this;
    }
    
    public String getAnnouncement() {
        return announcement;
    }
    
    public CreateTeamRequestV2 setAnnouncement(String announcement) {
        this.announcement = announcement;
        return this;
    }
    
    public String getIntro() {
        return intro;
    }
    
    public CreateTeamRequestV2 setIntro(String intro) {
        this.intro = intro;
        return this;
    }
    
    public Integer getMembersLimit() {
        return membersLimit;
    }
    
    public CreateTeamRequestV2 setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
        return this;
    }
    
    public String getServerExtension() {
        return serverExtension;
    }
    
    public CreateTeamRequestV2 setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
        return this;
    }
    
    public String getCustomerExtension() {
        return customerExtension;
    }
    
    public CreateTeamRequestV2 setCustomerExtension(String customerExtension) {
        this.customerExtension = customerExtension;
        return this;
    }
    
    public List<String> getInviteAccountIds() {
        return inviteAccountIds;
    }
    
    public CreateTeamRequestV2 setInviteAccountIds(List<String> inviteAccountIds) {
        this.inviteAccountIds = inviteAccountIds;
        return this;
    }
    
    public String getInviteMsg() {
        return inviteMsg;
    }
    
    public CreateTeamRequestV2 setInviteMsg(String inviteMsg) {
        this.inviteMsg = inviteMsg;
        return this;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public CreateTeamRequestV2 setExtension(String extension) {
        this.extension = extension;
        return this;
    }
    
    public Configuration getConfiguration() {
        return configuration;
    }
    
    public CreateTeamRequestV2 setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }
    
    public AntispamConfiguration getAntispamConfiguration() {
        return antispamConfiguration;
    }
    
    public CreateTeamRequestV2 setAntispamConfiguration(AntispamConfiguration antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
        return this;
    }
    
    /**
     * Helper method for creating advanced team
     */
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
    
    /**
     * Helper method for creating super team
     */
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