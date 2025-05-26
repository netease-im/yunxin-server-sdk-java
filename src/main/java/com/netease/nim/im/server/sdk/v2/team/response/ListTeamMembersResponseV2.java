package com.netease.nim.im.server.sdk.v2.team.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for listing team members
 * 
 * This class represents the response containing paginated team members list.
 */
public class ListTeamMembersResponseV2 {
    
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    @JSONField(name = "next_token")
    private String nextToken;
    
    @JSONField(name = "items")
    private List<TeamMember> items;
    
    /**
     * Team member information
     */
    public static class TeamMember {
        @JSONField(name = "team_id")
        private Long teamId;
        
        @JSONField(name = "account_id")
        private String accountId;
        
        @JSONField(name = "member_role")
        private Integer memberRole;
        
        @JSONField(name = "team_nick")
        private String teamNick;
        
        @JSONField(name = "server_extension")
        private String serverExtension;
        
        @JSONField(name = "chat_banned")
        private Boolean chatBanned;
        
        @JSONField(name = "join_time")
        private Long joinTime;
        
        @JSONField(name = "update_time")
        private Long updateTime;
        
        // Getters and Setters
        
        public Long getTeamId() {
            return teamId;
        }
        
        public void setTeamId(Long teamId) {
            this.teamId = teamId;
        }
        
        public String getAccountId() {
            return accountId;
        }
        
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        public Integer getMemberRole() {
            return memberRole;
        }
        
        public void setMemberRole(Integer memberRole) {
            this.memberRole = memberRole;
        }
        
        public String getTeamNick() {
            return teamNick;
        }
        
        public void setTeamNick(String teamNick) {
            this.teamNick = teamNick;
        }
        
        public String getServerExtension() {
            return serverExtension;
        }
        
        public void setServerExtension(String serverExtension) {
            this.serverExtension = serverExtension;
        }
        
        public Boolean getChatBanned() {
            return chatBanned;
        }
        
        public void setChatBanned(Boolean chatBanned) {
            this.chatBanned = chatBanned;
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
    
    public List<TeamMember> getItems() {
        return items;
    }
    
    public void setItems(List<TeamMember> items) {
        this.items = items;
    }
} 