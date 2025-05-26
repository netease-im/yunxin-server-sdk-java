package com.netease.nim.im.server.sdk.v2.team.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for getting team information
 * 
 * This class represents the response containing detailed information about a team.
 */
public class GetTeamInfoResponseV2 {
    
    @JSONField(name = "team_info")
    private TeamInfo teamInfo;
    
    /**
     * Team information details
     */
    public static class TeamInfo {
        @JSONField(name = "team_id")
        private String teamId;
        
        @JSONField(name = "team_type")
        private Integer teamType;
        
        @JSONField(name = "member_count")
        private Integer memberCount;
        
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
        
        @JSONField(name = "create_time")
        private Long createTime;
        
        @JSONField(name = "update_time")
        private Long updateTime;
        
        @JSONField(name = "configuration")
        private Configuration configuration;
        
        // Getters and Setters
        
        public String getTeamId() {
            return teamId;
        }
        
        public void setTeamId(String teamId) {
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
    
    // Getters and Setters for the root class
    
    public TeamInfo getTeamInfo() {
        return teamInfo;
    }
    
    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }
} 