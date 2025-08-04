package com.netease.nim.server.sdk.im.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class QueryJoinedTeamsResponseV2 {
    
    
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    
    @JSONField(name = "next_token")
    private String nextToken;
    
    
    @JSONField(name = "team_info_list")
    private List<TeamInfo> teamInfoList;
    
    
    public static class TeamInfo {
        
        
        @JSONField(name = "team_id")
        private Long teamId;
        
        
        @JSONField(name = "owner_account_id")
        private String ownerAccountId;
        
        
        @JSONField(name = "name")
        private String name;
        
        
        @JSONField(name = "icon")
        private String icon;
        
        
        @JSONField(name = "member_count")
        private Integer memberCount;
        
        
        @JSONField(name = "members_limit")
        private Integer membersLimit;
        
        
        @JSONField(name = "create_time")
        private Long createTime;
        
        
        @JSONField(name = "update_time")
        private Long updateTime;
        
        
        @JSONField(name = "configuration")
        private TeamConfiguration configuration;
        
        
        @JSONField(name = "member_info")
        private MemberInfo memberInfo;
        
        // Getters and Setters
        
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
        
        public Integer getMemberCount() {
            return memberCount;
        }
        
        public void setMemberCount(Integer memberCount) {
            this.memberCount = memberCount;
        }
        
        public Integer getMembersLimit() {
            return membersLimit;
        }
        
        public void setMembersLimit(Integer membersLimit) {
            this.membersLimit = membersLimit;
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
        
        public TeamConfiguration getConfiguration() {
            return configuration;
        }
        
        public void setConfiguration(TeamConfiguration configuration) {
            this.configuration = configuration;
        }
        
        public MemberInfo getMemberInfo() {
            return memberInfo;
        }
        
        public void setMemberInfo(MemberInfo memberInfo) {
            this.memberInfo = memberInfo;
        }
    }
    
    
    public static class TeamConfiguration {
        
        
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
    }
    
    
    public static class MemberInfo {
        
        
        @JSONField(name = "member_role")
        private Integer memberRole;
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "chat_banned")
        private Boolean chatBanned;
        
        
        @JSONField(name = "team_nick")
        private String teamNick;
        
        
        @JSONField(name = "join_time")
        private Long joinTime;
        
        
        @JSONField(name = "update_time")
        private Long updateTime;
        
        
        @JSONField(name = "follow_account_ids")
        private List<String> followAccountIds;

        @JSONField(name="invitor_account_id")
        private String invitorAccountId;

        @JSONField(name="server_extension")
        private String serverExtension;
        // Getters and Setters
        
        public Integer getMemberRole() {
            return memberRole;
        }
        
        public void setMemberRole(Integer memberRole) {
            this.memberRole = memberRole;
        }
        
        public String getAccountId() {
            return accountId;
        }
        
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        public Boolean getChatBanned() {
            return chatBanned;
        }
        
        public void setChatBanned(Boolean chatBanned) {
            this.chatBanned = chatBanned;
        }
        
        public String getTeamNick() {
            return teamNick;
        }
        
        public void setTeamNick(String teamNick) {
            this.teamNick = teamNick;
        }
        
        public Long getJoinTime() {
            return joinTime;
        }
        
        public void setJoinTime(Long joinTime) {
            this.joinTime = joinTime;
        }
        
        public Long getUpdateTime() {
            return updateTime;
        }
        
        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
        
        public List<String> getFollowAccountIds() {
            return followAccountIds;
        }
        
        public void setFollowAccountIds(List<String> followAccountIds) {
            this.followAccountIds = followAccountIds;
        }

        public String getInvitorAccountId() {
            return invitorAccountId;
        }

        public void setInvitorAccountId(String invitorAccountId) {
            this.invitorAccountId = invitorAccountId;
        }

        public String getServerExtension() {
            return serverExtension;
        }

        public void setServerExtension(String serverExtension) {
            this.serverExtension = serverExtension;
        }
    }
    
    // Getters and Setters for the root class
    
    public Boolean getHasMore() {
        return hasMore;
    }
    
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    public String getNextToken() {
        return nextToken;
    }
    
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    public List<TeamInfo> getTeamInfoList() {
        return teamInfoList;
    }
    
    public void setTeamInfoList(List<TeamInfo> teamInfoList) {
        this.teamInfoList = teamInfoList;
    }
} 