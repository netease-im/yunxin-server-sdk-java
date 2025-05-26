package com.netease.nim.im.server.sdk.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying chat-banned members in a chatroom
 * This represents members who are banned from chatting but still in the chatroom
 */
public class QueryChatBannedResponseV2 {
    
    /**
     * Total number of chat-banned members in the chatroom
     */
    @JSONField(name = "total")
    private Integer total;
    
    /**
     * Page number for pagination
     */
    @JSONField(name = "current_page")
    private Integer currentPage;
    
    /**
     * Number of items per page
     */
    @JSONField(name = "page_size")
    private Integer pageSize;
    
    /**
     * List of chat-banned members
     */
    @JSONField(name = "banned_members")
    private List<ChatBannedMemberInfoV2> bannedMembers;
    
    /**
     * Default constructor
     */
    public QueryChatBannedResponseV2() {
    }

    /**
     * Get total count of chat-banned members
     * 
     * @return total count
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Set total count of chat-banned members
     * 
     * @param total total count
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Get current page number
     * 
     * @return current page number
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * Set current page number
     * 
     * @param currentPage current page number
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Get page size
     * 
     * @return page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Set page size
     * 
     * @param pageSize page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Get list of chat-banned members
     * 
     * @return list of chat-banned members
     */
    public List<ChatBannedMemberInfoV2> getBannedMembers() {
        return bannedMembers;
    }

    /**
     * Set list of chat-banned members
     * 
     * @param bannedMembers list of chat-banned members
     */
    public void setBannedMembers(List<ChatBannedMemberInfoV2> bannedMembers) {
        this.bannedMembers = bannedMembers;
    }
    
    /**
     * Information about a member banned from chatting
     */
    public static class ChatBannedMemberInfoV2 {
        
        /**
         * Account ID of the chat-banned member
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
         * Time when the member was banned from chatting (Unix timestamp in seconds)
         */
        @JSONField(name = "chat_banned_time")
        private Long chatBannedTime;
        
        /**
         * Ban operator account ID
         */
        @JSONField(name = "operator_account_id")
        private String operatorAccountId;
        
        /**
         * Whether this is a temporary chat ban
         */
        @JSONField(name = "is_temporary")
        private Boolean isTemporary;
        
        /**
         * Mute (chat ban) duration in seconds, only set if isTemporary is true
         */
        @JSONField(name = "mute_duration")
        private Long muteDuration;
        
        /**
         * Default constructor
         */
        public ChatBannedMemberInfoV2() {
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
         * Get chat ban time
         * 
         * @return chat ban time
         */
        public Long getChatBannedTime() {
            return chatBannedTime;
        }

        /**
         * Set chat ban time
         * 
         * @param chatBannedTime chat ban time
         */
        public void setChatBannedTime(Long chatBannedTime) {
            this.chatBannedTime = chatBannedTime;
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
         * Get whether this is a temporary chat ban
         * 
         * @return whether this is a temporary chat ban
         */
        public Boolean getIsTemporary() {
            return isTemporary;
        }

        /**
         * Set whether this is a temporary chat ban
         * 
         * @param isTemporary whether this is a temporary chat ban
         */
        public void setIsTemporary(Boolean isTemporary) {
            this.isTemporary = isTemporary;
        }

        /**
         * Get mute (chat ban) duration in seconds
         * 
         * @return mute duration
         */
        public Long getMuteDuration() {
            return muteDuration;
        }

        /**
         * Set mute (chat ban) duration in seconds
         * 
         * @param muteDuration mute duration
         */
        public void setMuteDuration(Long muteDuration) {
            this.muteDuration = muteDuration;
        }
    }
} 