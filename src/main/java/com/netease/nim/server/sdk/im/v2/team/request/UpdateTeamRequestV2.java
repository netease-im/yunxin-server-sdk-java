package com.netease.nim.server.sdk.im.v2.team.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for updating a team
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2.1/teams/{team_id}
 */
public class UpdateTeamRequestV2 {
    
    /**
     * Operator's account ID (optional)
     * Must be a team owner or admin
     */
    @JSONField(name = "operator_id")
    private String operatorId;
    
    /**
     * Team type (required)
     * 1: Advanced team
     * 2: Super team
     */
    @JSONField(name = "team_type")
    private Integer teamType;
    
    /**
     * Team name (optional)
     * Maximum length: 64 characters
     */
    @JSONField(name = "name")
    private String name;
    
    /**
     * Team icon URL (optional)
     * Maximum length: 1024 characters
     */
    @JSONField(name = "icon")
    private String icon;
    
    /**
     * Team announcement (optional)
     * Maximum length: 1024 characters
     */
    @JSONField(name = "announcement")
    private String announcement;
    
    /**
     * Team introduction (optional)
     * Maximum length: 512 characters
     */
    @JSONField(name = "intro")
    private String intro;
    
    /**
     * Maximum number of members (including owner) (optional)
     * Default: 200
     * Range: [2-200] or [2-custom limit set in console]
     */
    @JSONField(name = "members_limit")
    private Integer membersLimit;
    
    /**
     * Custom server extension field (optional)
     * Recommended format: JSONObject {key:value}
     * Maximum length: 1024 characters
     */
    @JSONField(name = "server_extension")
    private String serverExtension;
    
    /**
     * Custom client extension field (optional)
     * Server API can set this, SDK only passes it through
     */
    @JSONField(name = "customer_extension")
    private String customerExtension;
    
    /**
     * Custom extension field for notification (optional)
     * Not persisted, JSON format
     * Maximum length: 512 characters
     * Only valid for advanced teams
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Team configuration (optional)
     */
    @JSONField(name = "configuration")
    private Configuration configuration;
    
    /**
     * Antispam configuration (optional)
     */
    @JSONField(name = "antispam_configuration")
    private AntispamConfiguration antispamConfiguration;
    
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
        
        /**
         * Chat ban mode - who can chat in the team
         * 0: No ban, everyone can chat (default)
         * 1: All members banned except owner and admins
         * 3: All members banned
         */
        @JSONField(name = "chat_banned_mode")
        private Integer chatBannedMode;
        
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
        
        public Integer getChatBannedMode() {
            return chatBannedMode;
        }
        
        public Configuration setChatBannedMode(Integer chatBannedMode) {
            this.chatBannedMode = chatBannedMode;
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
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public UpdateTeamRequestV2 setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }
    
    public Integer getTeamType() {
        return teamType;
    }
    
    public UpdateTeamRequestV2 setTeamType(Integer teamType) {
        this.teamType = teamType;
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public UpdateTeamRequestV2 setName(String name) {
        this.name = name;
        return this;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public UpdateTeamRequestV2 setIcon(String icon) {
        this.icon = icon;
        return this;
    }
    
    public String getAnnouncement() {
        return announcement;
    }
    
    public UpdateTeamRequestV2 setAnnouncement(String announcement) {
        this.announcement = announcement;
        return this;
    }
    
    public String getIntro() {
        return intro;
    }
    
    public UpdateTeamRequestV2 setIntro(String intro) {
        this.intro = intro;
        return this;
    }
    
    public Integer getMembersLimit() {
        return membersLimit;
    }
    
    public UpdateTeamRequestV2 setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
        return this;
    }
    
    public String getServerExtension() {
        return serverExtension;
    }
    
    public UpdateTeamRequestV2 setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
        return this;
    }
    
    public String getCustomerExtension() {
        return customerExtension;
    }
    
    public UpdateTeamRequestV2 setCustomerExtension(String customerExtension) {
        this.customerExtension = customerExtension;
        return this;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public UpdateTeamRequestV2 setExtension(String extension) {
        this.extension = extension;
        return this;
    }
    
    public Configuration getConfiguration() {
        return configuration;
    }
    
    public UpdateTeamRequestV2 setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }
    
    public AntispamConfiguration getAntispamConfiguration() {
        return antispamConfiguration;
    }
    
    public UpdateTeamRequestV2 setAntispamConfiguration(AntispamConfiguration antispamConfiguration) {
        this.antispamConfiguration = antispamConfiguration;
        return this;
    }
} 