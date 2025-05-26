package com.netease.nim.im.server.sdk.v2.team.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response for batch querying team information
 * 
 * This class represents the response from the batch query team info API.
 */
public class BatchQueryTeamInfoResponseV2 {
    
    /**
     * List of team info objects
     */
    @JSONField(name = "team_info_list")
    private List<TeamInfo> teamInfoList;
    
    /**
     * List of invalid team IDs
     * Contains IDs of teams that couldn't be queried
     */
    @JSONField(name = "invalid_tids")
    private List<Long> invalidTids;
    
    // Getters and Setters
    
    public List<TeamInfo> getTeamInfoList() {
        return teamInfoList;
    }
    
    public void setTeamInfoList(List<TeamInfo> teamInfoList) {
        this.teamInfoList = teamInfoList;
    }
    
    public List<Long> getInvalidTids() {
        return invalidTids;
    }
    
    public void setInvalidTids(List<Long> invalidTids) {
        this.invalidTids = invalidTids;
    }
    
    /**
     * Team information
     */
    public static class TeamInfo {
        /**
         * Team ID
         */
        @JSONField(name = "team_id")
        private Long teamId;
        
        /**
         * Team type
         * 1: Advanced team
         * 2: Super team
         */
        @JSONField(name = "team_type")
        private Integer teamType;
        
        /**
         * Number of team members
         */
        @JSONField(name = "member_count")
        private Integer memberCount;
        
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
         * Maximum number of members allowed
         */
        @JSONField(name = "members_limit")
        private Integer membersLimit;
        
        /**
         * Server-side extension
         * Custom extension field in JSON format
         */
        @JSONField(name = "server_extension")
        private String serverExtension;
        
        /**
         * Client-side extension
         * Custom extension field
         */
        @JSONField(name = "customer_extension")
        private String customerExtension;
        
        /**
         * Team creation time (timestamp)
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Team last update time (timestamp)
         */
        @JSONField(name = "update_time")
        private Long updateTime;
        
        /**
         * Team configuration
         */
        @JSONField(name = "configuration")
        private Configuration configuration;
        
        // Getters and Setters
        
        public Long getTeamId() {
            return teamId;
        }
        
        public void setTeamId(Long teamId) {
            this.teamId = teamId;
        }
        
        public Integer getTeamType() {
            return teamType;
        }
        
        public void setTeamType(Integer teamType) {
            this.teamType = teamType;
        }
        
        public Integer getMemberCount() {
            return memberCount;
        }
        
        public void setMemberCount(Integer memberCount) {
            this.memberCount = memberCount;
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
         * 0: No verification required
         * 1: Verification by owner/admin required
         * 2: No one can apply to join
         */
        @JSONField(name = "join_mode")
        private Integer joinMode;
        
        /**
         * Agree mode
         * 0: Invited person needs to agree
         * 1: Invited person joins automatically
         */
        @JSONField(name = "agree_mode")
        private Integer agreeMode;
        
        /**
         * Invite mode
         * 0: Only owner/admin can invite
         * 1: Anyone can invite
         */
        @JSONField(name = "invite_mode")
        private Integer inviteMode;
        
        /**
         * Update team info mode
         * 0: Only owner/admin can update
         * 1: Anyone can update
         */
        @JSONField(name = "update_team_info_mode")
        private Integer updateTeamInfoMode;
        
        /**
         * Update extension mode
         * 0: Only owner/admin can update
         * 1: Anyone can update
         */
        @JSONField(name = "update_extension_mode")
        private Integer updateExtensionMode;
        
        /**
         * Chat banned mode
         * 0: No chat ban
         * 1: All members banned except owner/admin
         * 3: All members banned including owner/admin
         */
        @JSONField(name = "chat_banned_mode")
        private String chatBannedMode;
        
        // Getters and Setters
        
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
        
        public String getChatBannedMode() {
            return chatBannedMode;
        }
        
        public void setChatBannedMode(String chatBannedMode) {
            this.chatBannedMode = chatBannedMode;
        }
    }
} 