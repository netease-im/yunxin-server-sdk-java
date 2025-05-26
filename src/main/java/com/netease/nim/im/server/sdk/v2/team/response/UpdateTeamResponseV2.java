package com.netease.nim.im.server.sdk.v2.team.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for updating a team
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2.1/teams/{team_id}
 */
public class UpdateTeamResponseV2 {
    
    /**
     * Updated team information
     */
    @JSONField(name = "team_info")
    private TeamInfo teamInfo;
    
    /**
     * Team information
     */
    public static class TeamInfo {
        
        /**
         * Team ID, returned by server
         */
        @JSONField(name = "team_id")
        private Long teamId;
        
        /**
         * Team owner's account ID
         */
        @JSONField(name = "owner_account_id")
        private String ownerAccountId;
        
        /**
         * Team name
         */
        @JSONField(name = "name")
        private String name;
        
        /**
         * Team icon URL
         */
        @JSONField(name = "icon")
        private String icon;
        
        /**
         * Team announcement
         */
        @JSONField(name = "announcement")
        private String announcement;
        
        /**
         * Team introduction
         */
        @JSONField(name = "intro")
        private String intro;
        
        /**
         * Custom server extension field
         */
        @JSONField(name = "server_extension")
        private String serverExtension;
        
        /**
         * Custom client extension field
         */
        @JSONField(name = "customer_extension")
        private String customerExtension;
        
        /**
         * Team creation time
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Team update time
         */
        @JSONField(name = "update_time")
        private Long updateTime;
        
        /**
         * Team configuration
         */
        @JSONField(name = "configuration")
        private Configuration configuration;
        
        public Long getTeamId() {
            return teamId;
        }
        
        public void setTeamId(Long teamId) {
            this.teamId = teamId;
        }
        
        public String getOwnerAccountId() {
            return ownerAccountId;
        }
        
        public void setOwnerAccountId(String ownerAccountId) {
            this.ownerAccountId = ownerAccountId;
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
        
        public Long getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        public Long getUpdateTime() {
            return updateTime;
        }
        
        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
        
        public Configuration getConfiguration() {
            return configuration;
        }
        
        public void setConfiguration(Configuration configuration) {
            this.configuration = configuration;
        }
    }
    
    /**
     * Team configuration settings
     */
    public static class Configuration {
        
        /**
         * Join mode
         * 0: No verification needed
         * 1: Requires approval from owner or admin
         * 2: No one can apply to join
         */
        @JSONField(name = "join_mode")
        private Integer joinMode;
        
        /**
         * Agree mode
         * 0: Requires acceptance
         * 1: No acceptance needed
         */
        @JSONField(name = "agree_mode")
        private Integer agreeMode;
        
        /**
         * Invite mode
         * 0: Owner and admins only
         * 1: Everyone
         */
        @JSONField(name = "invite_mode")
        private Integer inviteMode;
        
        /**
         * Update team info mode
         * 0: Owner and admins only
         * 1: Everyone
         */
        @JSONField(name = "update_team_info_mode")
        private Integer updateTeamInfoMode;
        
        /**
         * Update extension mode
         * 0: Owner and admins only
         * 1: Everyone
         */
        @JSONField(name = "update_extension_mode")
        private Integer updateExtensionMode;
        
        /**
         * Chat ban mode
         * 0: No ban
         * 1: All members banned except owner and admins
         * 3: All members banned
         */
        @JSONField(name = "chat_banned_mode")
        private Integer chatBannedMode;
        
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
        
        public Integer getChatBannedMode() {
            return chatBannedMode;
        }
        
        public void setChatBannedMode(Integer chatBannedMode) {
            this.chatBannedMode = chatBannedMode;
        }
    }
    
    // Getters and setters
    
    public TeamInfo getTeamInfo() {
        return teamInfo;
    }
    
    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }
} 