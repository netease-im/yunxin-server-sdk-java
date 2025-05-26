package com.netease.nim.im.server.sdk.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying chatroom ban list
 */
public class QueryChatroomBanListResponseV2 {
    
    /**
     * Total number of banned members in the chatroom
     */
    @JSONField(name = "total")
    private Integer total;
    
    /**
     * Marker for pagination
     * Use this marker in your next request to retrieve the next page of banned members
     * If this field is empty, there are no more banned members to retrieve
     */
    @JSONField(name = "marker")
    private String marker;
    
    /**
     * List of banned members
     */
    @JSONField(name = "banned_members")
    private List<BannedMemberInfoV2> bannedMembers;
    
    /**
     * Default constructor
     */
    public QueryChatroomBanListResponseV2() {
    }

    /**
     * Get total count of banned members
     * 
     * @return total count
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Set total count of banned members
     * 
     * @param total total count
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Get pagination marker
     * 
     * @return pagination marker
     */
    public String getMarker() {
        return marker;
    }

    /**
     * Set pagination marker
     * 
     * @param marker pagination marker
     */
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * Get list of banned members
     * 
     * @return list of banned members
     */
    public List<BannedMemberInfoV2> getBannedMembers() {
        return bannedMembers;
    }

    /**
     * Set list of banned members
     * 
     * @param bannedMembers list of banned members
     */
    public void setBannedMembers(List<BannedMemberInfoV2> bannedMembers) {
        this.bannedMembers = bannedMembers;
    }
    
    /**
     * Banned member information in chatroom
     */
    public static class BannedMemberInfoV2 {
        
        /**
         * Account ID of the banned member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Member nickname in the chatroom
         */
        @JSONField(name = "nick")
        private String nick;
        
        /**
         * Member avatar URL
         */
        @JSONField(name = "avatar")
        private String avatar;
        
        /**
         * Member role in the chatroom
         * 1: Owner/Creator
         * 2: Administrator
         * 3: Regular member
         * 10: Guest
         */
        @JSONField(name = "member_role")
        private Integer memberRole;
        
        /**
         * Join time of the member (Unix timestamp in seconds)
         */
        @JSONField(name = "join_time")
        private Long joinTime;
        
        /**
         * Ban time (Unix timestamp in seconds)
         */
        @JSONField(name = "ban_time")
        private Long banTime;
        
        /**
         * Ban operator account ID
         */
        @JSONField(name = "operator_account_id")
        private String operatorAccountId;
        
        /**
         * Whether this is a temporary ban
         */
        @JSONField(name = "is_temporary")
        private Boolean isTemporary;
        
        /**
         * Mute (ban) duration in seconds, only set if isTemporary is true
         */
        @JSONField(name = "mute_duration")
        private Long muteDuration;
        
        /**
         * Default constructor
         */
        public BannedMemberInfoV2() {
        }

        /**
         * Get account ID
         * 
         * @return account ID
         */
        public String getAccountId() {
            return accountId;
        }

        /**
         * Set account ID
         * 
         * @param accountId account ID
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        /**
         * Get member nickname
         * 
         * @return member nickname
         */
        public String getNick() {
            return nick;
        }

        /**
         * Set member nickname
         * 
         * @param nick member nickname
         */
        public void setNick(String nick) {
            this.nick = nick;
        }

        /**
         * Get member avatar URL
         * 
         * @return member avatar URL
         */
        public String getAvatar() {
            return avatar;
        }

        /**
         * Set member avatar URL
         * 
         * @param avatar member avatar URL
         */
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        /**
         * Get member role
         * 
         * @return member role
         */
        public Integer getMemberRole() {
            return memberRole;
        }

        /**
         * Set member role
         * 
         * @param memberRole member role
         */
        public void setMemberRole(Integer memberRole) {
            this.memberRole = memberRole;
        }

        /**
         * Get join time
         * 
         * @return join time
         */
        public Long getJoinTime() {
            return joinTime;
        }

        /**
         * Set join time
         * 
         * @param joinTime join time
         */
        public void setJoinTime(Long joinTime) {
            this.joinTime = joinTime;
        }

        /**
         * Get ban time
         * 
         * @return ban time
         */
        public Long getBanTime() {
            return banTime;
        }

        /**
         * Set ban time
         * 
         * @param banTime ban time
         */
        public void setBanTime(Long banTime) {
            this.banTime = banTime;
        }

        /**
         * Get ban operator account ID
         * 
         * @return ban operator account ID
         */
        public String getOperatorAccountId() {
            return operatorAccountId;
        }

        /**
         * Set ban operator account ID
         * 
         * @param operatorAccountId ban operator account ID
         */
        public void setOperatorAccountId(String operatorAccountId) {
            this.operatorAccountId = operatorAccountId;
        }

        /**
         * Get whether this is a temporary ban
         * 
         * @return whether this is a temporary ban
         */
        public Boolean getIsTemporary() {
            return isTemporary;
        }

        /**
         * Set whether this is a temporary ban
         * 
         * @param isTemporary whether this is a temporary ban
         */
        public void setIsTemporary(Boolean isTemporary) {
            this.isTemporary = isTemporary;
        }

        /**
         * Get mute (ban) duration in seconds
         * 
         * @return mute duration
         */
        public Long getMuteDuration() {
            return muteDuration;
        }

        /**
         * Set mute (ban) duration in seconds
         * 
         * @param muteDuration mute duration
         */
        public void setMuteDuration(Long muteDuration) {
            this.muteDuration = muteDuration;
        }
    }
} 