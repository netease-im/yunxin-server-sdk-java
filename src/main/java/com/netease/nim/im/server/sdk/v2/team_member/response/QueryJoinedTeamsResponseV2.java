package com.netease.nim.im.server.sdk.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying an account's joined teams
 * 
 * This class represents the response containing the list of teams an account has joined.
 */
public class QueryJoinedTeamsResponseV2 {
    
    /**
     * Indicates if there are more results to fetch
     */
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    /**
     * Token for fetching the next page of results
     */
    @JSONField(name = "next_token")
    private String nextToken;
    
    /**
     * List of joined team information
     */
    @JSONField(name = "team_info_list")
    private List<TeamInfo> teamInfoList;
    
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
         * ID of the team owner
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
         * Number of members in the team
         */
        @JSONField(name = "member_count")
        private Integer memberCount;
        
        /**
         * Maximum number of members allowed in the team
         */
        @JSONField(name = "members_limit")
        private Integer membersLimit;
        
        /**
         * Team creation timestamp
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Team last update timestamp
         */
        @JSONField(name = "update_time")
        private Long updateTime;
        
        /**
         * Team configuration settings
         */
        @JSONField(name = "configuration")
        private TeamConfiguration configuration;
        
        /**
         * Member information in the team (if requested)
         */
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
    
    /**
     * Team configuration settings
     */
    public static class TeamConfiguration {
        
        /**
         * Join mode for the team
         * 0: No verification needed, direct join
         * 1: Need owner/admin verification to join
         * 2: No one is allowed to apply to join
         */
        @JSONField(name = "join_mode")
        private Integer joinMode;
        
        /**
         * Agree mode for invitations
         * 0: Invitee's consent required to join
         * 1: No consent needed, direct join
         */
        @JSONField(name = "agree_mode")
        private Integer agreeMode;
        
        /**
         * Invite permission mode
         * 0: Only owner and admins can invite
         * 1: All members can invite
         */
        @JSONField(name = "invite_mode")
        private Integer inviteMode;
        
        /**
         * Team info update permission mode
         * 0: Only owner and admins can update
         * 1: All members can update
         */
        @JSONField(name = "update_team_info_mode")
        private Integer updateTeamInfoMode;
        
        /**
         * Extension field update permission mode
         * 0: Only owner and admins can update
         * 1: All members can update
         */
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
    
    /**
     * Member information in the team
     */
    public static class MemberInfo {
        
        /**
         * Member role in the team
         * 0: Regular member
         * 1: Team owner
         * 2: Team admin
         */
        @JSONField(name = "member_role")
        private Integer memberRole;
        
        /**
         * Account ID of the member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Whether the member is banned from chatting
         */
        @JSONField(name = "chat_banned")
        private Boolean chatBanned;
        
        /**
         * Nickname of the member in this team
         */
        @JSONField(name = "team_nick")
        private String teamNick;
        
        /**
         * Timestamp when the member joined the team
         */
        @JSONField(name = "join_time")
        private Long joinTime;
        
        /**
         * Timestamp when the member information was last updated
         */
        @JSONField(name = "update_time")
        private Long updateTime;
        
        /**
         * List of specially followed account IDs when the team is muted
         */
        @JSONField(name = "follow_account_ids")
        private List<String> followAccountIds;
        
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