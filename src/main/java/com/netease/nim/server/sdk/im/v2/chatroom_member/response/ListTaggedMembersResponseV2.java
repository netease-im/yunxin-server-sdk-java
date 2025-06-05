package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response for paginated querying of online members with a specific tag in a chatroom
 */
public class ListTaggedMembersResponseV2 {
    
    /**
     * Offset for the next page
     */
    @JSONField(name = "offset")
    private Long offset;
    
    /**
     * Whether there are more results
     */
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    /**
     * List of tagged members
     */
    @JSONField(name = "items")
    private List<TaggedMemberInfoV2> items;
    
    /**
     * Default constructor
     */
    public ListTaggedMembersResponseV2() {
    }
    
    /**
     * Constructor with all fields
     * 
     * @param offset offset for the next page
     * @param hasMore whether there are more results
     * @param items list of tagged members
     */
    public ListTaggedMembersResponseV2(Long offset, Boolean hasMore, List<TaggedMemberInfoV2> items) {
        this.offset = offset;
        this.hasMore = hasMore;
        this.items = items;
    }
    
    /**
     * Get the offset
     * 
     * @return the offset
     */
    public Long getOffset() {
        return offset;
    }
    
    /**
     * Set the offset
     * 
     * @param offset the offset
     */
    public void setOffset(Long offset) {
        this.offset = offset;
    }
    
    /**
     * Get whether there are more results
     * 
     * @return whether there are more results
     */
    public Boolean getHasMore() {
        return hasMore;
    }
    
    /**
     * Set whether there are more results
     * 
     * @param hasMore whether there are more results
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    /**
     * Get the list of tagged members
     * 
     * @return the list of tagged members
     */
    public List<TaggedMemberInfoV2> getItems() {
        return items;
    }
    
    /**
     * Set the list of tagged members
     * 
     * @param items the list of tagged members
     */
    public void setItems(List<TaggedMemberInfoV2> items) {
        this.items = items;
    }

    /**
     * Information about a chatroom member with tag
     */
    public static class TaggedMemberInfoV2 {
        
        /**
         * Account ID of the member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Member's nickname in the chatroom
         */
        @JSONField(name = "room_nick")
        private String roomNick;
        
        /**
         * Member's avatar in the chatroom
         */
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        /**
         * Extension information
         */
        @JSONField(name = "extension")
        private String extension;
        
        /**
         * Member role type
         * 0: Regular user; 1: Creator; 2: Administrator; 3: Regular guest; 4: Anonymous guest
         */
        @JSONField(name = "member_role")
        private Integer memberRole;
        
        /**
         * Member level
         */
        @JSONField(name = "member_level")
        private Integer memberLevel;
        
        /**
         * Whether the member is online
         */
        @JSONField(name = "is_online")
        private Boolean isOnline;
        
        /**
         * Time when the member entered the chatroom
         */
        @JSONField(name = "enter_time")
        private Long enterTime;
        
        /**
         * Whether the member is in the chatroom blacklist
         */
        @JSONField(name = "blocked")
        private Boolean blocked;
        
        /**
         * Whether the member is banned from chatting
         */
        @JSONField(name = "chat_banned")
        private Boolean chatBanned;
        
        /**
         * Whether the member is temporarily banned from chatting
         */
        @JSONField(name = "temp_chat_banned")
        private Boolean tempChatBanned;
        
        /**
         * Duration of temporary chat ban in seconds
         */
        @JSONField(name = "temp_chat_banned_time")
        private Long tempChatBannedTime;
        
        /**
         * Member tags
         */
        @JSONField(name = "tags")
        private String tags;
        
        /**
         * Notify target tags
         */
        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;
        
        /**
         * Count of online clients for this member
         */
        @JSONField(name = "online_count")
        private Integer onlineCount;
        
        /**
         * List of online client information
         */
        @JSONField(name = "online_info_list")
        private List<OnlineInfoV2> onlineInfoList;
        
        /**
         * Default constructor
         */
        public TaggedMemberInfoV2() {
        }
        
        /**
         * Get the account ID
         * 
         * @return the account ID
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set the account ID
         * 
         * @param accountId the account ID
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get the room nickname
         * 
         * @return the room nickname
         */
        public String getRoomNick() {
            return roomNick;
        }
        
        /**
         * Set the room nickname
         * 
         * @param roomNick the room nickname
         */
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }
        
        /**
         * Get the room avatar
         * 
         * @return the room avatar
         */
        public String getRoomAvatar() {
            return roomAvatar;
        }
        
        /**
         * Set the room avatar
         * 
         * @param roomAvatar the room avatar
         */
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }
        
        /**
         * Get the extension
         * 
         * @return the extension
         */
        public String getExtension() {
            return extension;
        }
        
        /**
         * Set the extension
         * 
         * @param extension the extension
         */
        public void setExtension(String extension) {
            this.extension = extension;
        }
        
        /**
         * Get the member role
         * 
         * @return the member role
         */
        public Integer getMemberRole() {
            return memberRole;
        }
        
        /**
         * Set the member role
         * 
         * @param memberRole the member role
         */
        public void setMemberRole(Integer memberRole) {
            this.memberRole = memberRole;
        }
        
        /**
         * Get the member level
         * 
         * @return the member level
         */
        public Integer getMemberLevel() {
            return memberLevel;
        }
        
        /**
         * Set the member level
         * 
         * @param memberLevel the member level
         */
        public void setMemberLevel(Integer memberLevel) {
            this.memberLevel = memberLevel;
        }
        
        /**
         * Get whether the member is online
         * 
         * @return whether the member is online
         */
        public Boolean getIsOnline() {
            return isOnline;
        }
        
        /**
         * Set whether the member is online
         * 
         * @param isOnline whether the member is online
         */
        public void setIsOnline(Boolean isOnline) {
            this.isOnline = isOnline;
        }
        
        /**
         * Get the enter time
         * 
         * @return the enter time
         */
        public Long getEnterTime() {
            return enterTime;
        }
        
        /**
         * Set the enter time
         * 
         * @param enterTime the enter time
         */
        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }
        
        /**
         * Get whether the member is in the chatroom blacklist
         * 
         * @return whether the member is in the chatroom blacklist
         */
        public Boolean getBlocked() {
            return blocked;
        }
        
        /**
         * Set whether the member is in the chatroom blacklist
         * 
         * @param blocked whether the member is in the chatroom blacklist
         */
        public void setBlocked(Boolean blocked) {
            this.blocked = blocked;
        }
        
        /**
         * Get whether the member is banned from chatting
         * 
         * @return whether the member is banned from chatting
         */
        public Boolean getChatBanned() {
            return chatBanned;
        }
        
        /**
         * Set whether the member is banned from chatting
         * 
         * @param chatBanned whether the member is banned from chatting
         */
        public void setChatBanned(Boolean chatBanned) {
            this.chatBanned = chatBanned;
        }
        
        /**
         * Get whether the member is temporarily banned from chatting
         * 
         * @return whether the member is temporarily banned from chatting
         */
        public Boolean getTempChatBanned() {
            return tempChatBanned;
        }
        
        /**
         * Set whether the member is temporarily banned from chatting
         * 
         * @param tempChatBanned whether the member is temporarily banned from chatting
         */
        public void setTempChatBanned(Boolean tempChatBanned) {
            this.tempChatBanned = tempChatBanned;
        }
        
        /**
         * Get the duration of temporary chat ban in seconds
         * 
         * @return the duration of temporary chat ban in seconds
         */
        public Long getTempChatBannedTime() {
            return tempChatBannedTime;
        }
        
        /**
         * Set the duration of temporary chat ban in seconds
         * 
         * @param tempChatBannedTime the duration of temporary chat ban in seconds
         */
        public void setTempChatBannedTime(Long tempChatBannedTime) {
            this.tempChatBannedTime = tempChatBannedTime;
        }
        
        /**
         * Get the member tags
         * 
         * @return the member tags
         */
        public String getTags() {
            return tags;
        }
        
        /**
         * Set the member tags
         * 
         * @param tags the member tags
         */
        public void setTags(String tags) {
            this.tags = tags;
        }
        
        /**
         * Get the notify target tags
         * 
         * @return the notify target tags
         */
        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }
        
        /**
         * Set the notify target tags
         * 
         * @param notifyTargetTags the notify target tags
         */
        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
        
        /**
         * Get the count of online clients for this member
         * 
         * @return the count of online clients for this member
         */
        public Integer getOnlineCount() {
            return onlineCount;
        }
        
        /**
         * Set the count of online clients for this member
         * 
         * @param onlineCount the count of online clients for this member
         */
        public void setOnlineCount(Integer onlineCount) {
            this.onlineCount = onlineCount;
        }
        
        /**
         * Get the list of online client information
         * 
         * @return the list of online client information
         */
        public List<OnlineInfoV2> getOnlineInfoList() {
            return onlineInfoList;
        }
        
        /**
         * Set the list of online client information
         * 
         * @param onlineInfoList the list of online client information
         */
        public void setOnlineInfoList(List<OnlineInfoV2> onlineInfoList) {
            this.onlineInfoList = onlineInfoList;
        }
    }

    /**
     * Information about an online client for a chatroom member
     */
    public static class OnlineInfoV2 {

        /**
         * Member's nickname in this client
         */
        @JSONField(name = "room_nick")
        private String roomNick;

        /**
         * Member's avatar in this client
         */
        @JSONField(name = "room_avatar")
        private String roomAvatar;

        /**
         * Time when the member entered the chatroom using this client
         */
        @JSONField(name = "enter_time")
        private Long enterTime;

        /**
         * Type of client
         */
        @JSONField(name = "client_type")
        private Integer clientType;

        /**
         * Default constructor
         */
        public OnlineInfoV2() {
        }

        /**
         * Constructor with all fields
         *
         * @param roomNick member's nickname in this client
         * @param roomAvatar member's avatar in this client
         * @param enterTime time when the member entered the chatroom
         * @param clientType type of client
         */
        public OnlineInfoV2(String roomNick, String roomAvatar, Long enterTime, Integer clientType) {
            this.roomNick = roomNick;
            this.roomAvatar = roomAvatar;
            this.enterTime = enterTime;
            this.clientType = clientType;
        }

        /**
         * Get the room nickname
         *
         * @return the room nickname
         */
        public String getRoomNick() {
            return roomNick;
        }

        /**
         * Set the room nickname
         *
         * @param roomNick the room nickname
         */
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }

        /**
         * Get the room avatar
         *
         * @return the room avatar
         */
        public String getRoomAvatar() {
            return roomAvatar;
        }

        /**
         * Set the room avatar
         *
         * @param roomAvatar the room avatar
         */
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }

        /**
         * Get the enter time
         *
         * @return the enter time
         */
        public Long getEnterTime() {
            return enterTime;
        }

        /**
         * Set the enter time
         *
         * @param enterTime the enter time
         */
        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }

        /**
         * Get the client type
         *
         * @return the client type
         */
        public Integer getClientType() {
            return clientType;
        }

        /**
         * Set the client type
         *
         * @param clientType the client type
         */
        public void setClientType(Integer clientType) {
            this.clientType = clientType;
        }
    }
} 