package com.netease.nim.im.server.sdk.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response for listing fixed chatroom members
 * 
 * This class encapsulates the response for querying fixed members in a chatroom.
 * Fixed members include the creator, administrators, and regular members.
 */
public class ListFixedMembersResponseV2 {
    
    /**
     * Whether there are more members to retrieve
     */
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    /**
     * List of fixed members
     */
    @JSONField(name = "items")
    private List<ChatroomMemberInfo> items;
    
    /**
     * Total number of online members in the chatroom
     */
    @JSONField(name = "online_count")
    private Integer onlineCount;
    
    /**
     * Default constructor
     */
    public ListFixedMembersResponseV2() {
    }
    
    /**
     * Inner class representing a chatroom member's information
     */
    public static class ChatroomMemberInfo {
        
        /**
         * Member's account ID
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
        @JSONField(name = "room_avator")
        private String roomAvatar;
        
        /**
         * Member's extension information
         */
        @JSONField(name = "extension")
        private String extension;
        
        /**
         * Member's role in the chatroom
         * 0: Regular user
         * 1: Creator
         * 2: Administrator
         */
        @JSONField(name = "member_role")
        private String memberRole;
        
        /**
         * Member's level
         */
        @JSONField(name = "level")
        private Integer level;
        
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
         * Whether the member is in the blacklist
         */
        @JSONField(name = "blocked")
        private Boolean blocked;
        
        /**
         * Whether the member is muted (permanently)
         */
        @JSONField(name = "chat_banned")
        private Boolean chatBanned;
        
        /**
         * Whether the member is temporarily muted
         */
        @JSONField(name = "temp_chat_banned")
        private Boolean tempChatBanned;
        
        /**
         * Duration of temporary mute (in seconds)
         */
        @JSONField(name = "temp_chat_banned_time")
        private Long tempChatBannedTime;
        
        /**
         * Member's tags
         */
        @JSONField(name = "tags")
        private String tags;
        
        /**
         * Member's notification target tags
         */
        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;
        
        /**
         * List of online information for this member
         */
        @JSONField(name = "online_info_list")
        private List<OnlineInfo> onlineInfoList;
        
        /**
         * Default constructor
         */
        public ChatroomMemberInfo() {
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
         * Get the member's nickname in the chatroom
         * 
         * @return the room nickname
         */
        public String getRoomNick() {
            return roomNick;
        }
        
        /**
         * Set the member's nickname in the chatroom
         * 
         * @param roomNick the room nickname
         */
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }
        
        /**
         * Get the member's avatar in the chatroom
         * 
         * @return the room avatar
         */
        public String getRoomAvatar() {
            return roomAvatar;
        }
        
        /**
         * Set the member's avatar in the chatroom
         * 
         * @param roomAvatar the room avatar
         */
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }
        
        /**
         * Get the member's extension information
         * 
         * @return the extension
         */
        public String getExtension() {
            return extension;
        }
        
        /**
         * Set the member's extension information
         * 
         * @param extension the extension
         */
        public void setExtension(String extension) {
            this.extension = extension;
        }
        
        /**
         * Get the member's role in the chatroom
         * 
         * @return the member role
         */
        public String getMemberRole() {
            return memberRole;
        }
        
        /**
         * Set the member's role in the chatroom
         * 
         * @param memberRole the member role
         */
        public void setMemberRole(String memberRole) {
            this.memberRole = memberRole;
        }
        
        /**
         * Get the member's level
         * 
         * @return the level
         */
        public Integer getLevel() {
            return level;
        }
        
        /**
         * Set the member's level
         * 
         * @param level the level
         */
        public void setLevel(Integer level) {
            this.level = level;
        }
        
        /**
         * Check if the member is online
         * 
         * @return true if the member is online, false otherwise
         */
        public Boolean getIsOnline() {
            return isOnline;
        }
        
        /**
         * Set whether the member is online
         * 
         * @param isOnline true if the member is online, false otherwise
         */
        public void setIsOnline(Boolean isOnline) {
            this.isOnline = isOnline;
        }
        
        /**
         * Get the time when the member entered the chatroom
         * 
         * @return the enter time
         */
        public Long getEnterTime() {
            return enterTime;
        }
        
        /**
         * Set the time when the member entered the chatroom
         * 
         * @param enterTime the enter time
         */
        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }
        
        /**
         * Check if the member is in the blacklist
         * 
         * @return true if the member is blocked, false otherwise
         */
        public Boolean getBlocked() {
            return blocked;
        }
        
        /**
         * Set whether the member is in the blacklist
         * 
         * @param blocked true if the member is blocked, false otherwise
         */
        public void setBlocked(Boolean blocked) {
            this.blocked = blocked;
        }
        
        /**
         * Check if the member is muted (permanently)
         * 
         * @return true if the member is muted, false otherwise
         */
        public Boolean getChatBanned() {
            return chatBanned;
        }
        
        /**
         * Set whether the member is muted (permanently)
         * 
         * @param chatBanned true if the member is muted, false otherwise
         */
        public void setChatBanned(Boolean chatBanned) {
            this.chatBanned = chatBanned;
        }
        
        /**
         * Check if the member is temporarily muted
         * 
         * @return true if the member is temporarily muted, false otherwise
         */
        public Boolean getTempChatBanned() {
            return tempChatBanned;
        }
        
        /**
         * Set whether the member is temporarily muted
         * 
         * @param tempChatBanned true if the member is temporarily muted, false otherwise
         */
        public void setTempChatBanned(Boolean tempChatBanned) {
            this.tempChatBanned = tempChatBanned;
        }
        
        /**
         * Get the duration of temporary mute
         * 
         * @return the temporary mute duration in seconds
         */
        public Long getTempChatBannedTime() {
            return tempChatBannedTime;
        }
        
        /**
         * Set the duration of temporary mute
         * 
         * @param tempChatBannedTime the temporary mute duration in seconds
         */
        public void setTempChatBannedTime(Long tempChatBannedTime) {
            this.tempChatBannedTime = tempChatBannedTime;
        }
        
        /**
         * Get the member's tags
         * 
         * @return the tags
         */
        public String getTags() {
            return tags;
        }
        
        /**
         * Set the member's tags
         * 
         * @param tags the tags
         */
        public void setTags(String tags) {
            this.tags = tags;
        }
        
        /**
         * Get the member's notification target tags
         * 
         * @return the notification target tags
         */
        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }
        
        /**
         * Set the member's notification target tags
         * 
         * @param notifyTargetTags the notification target tags
         */
        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
        
        /**
         * Get the list of online information for this member
         * 
         * @return the online information list
         */
        public List<OnlineInfo> getOnlineInfoList() {
            return onlineInfoList;
        }
        
        /**
         * Set the list of online information for this member
         * 
         * @param onlineInfoList the online information list
         */
        public void setOnlineInfoList(List<OnlineInfo> onlineInfoList) {
            this.onlineInfoList = onlineInfoList;
        }
    }
    
    /**
     * Inner class representing online information for a member
     */
    public static class OnlineInfo {
        
        /**
         * Nickname in this client
         */
        @JSONField(name = "room_nick")
        private String roomNick;
        
        /**
         * Avatar in this client
         */
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        /**
         * Time when the member entered the chatroom
         */
        @JSONField(name = "enter_time")
        private Long enterTime;
        
        /**
         * Client type
         */
        @JSONField(name = "client_type")
        private Integer clientType;
        
        /**
         * Default constructor
         */
        public OnlineInfo() {
        }
        
        /**
         * Get the nickname in this client
         * 
         * @return the room nickname
         */
        public String getRoomNick() {
            return roomNick;
        }
        
        /**
         * Set the nickname in this client
         * 
         * @param roomNick the room nickname
         */
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }
        
        /**
         * Get the avatar in this client
         * 
         * @return the room avatar
         */
        public String getRoomAvatar() {
            return roomAvatar;
        }
        
        /**
         * Set the avatar in this client
         * 
         * @param roomAvatar the room avatar
         */
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }
        
        /**
         * Get the time when the member entered the chatroom
         * 
         * @return the enter time
         */
        public Long getEnterTime() {
            return enterTime;
        }
        
        /**
         * Set the time when the member entered the chatroom
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
    
    /**
     * Check if there are more members to retrieve
     * 
     * @return true if there are more members, false otherwise
     */
    public Boolean getHasMore() {
        return hasMore;
    }
    
    /**
     * Set whether there are more members to retrieve
     * 
     * @param hasMore true if there are more members, false otherwise
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    /**
     * Get the list of fixed members
     * 
     * @return the list of member information
     */
    public List<ChatroomMemberInfo> getItems() {
        return items;
    }
    
    /**
     * Set the list of fixed members
     * 
     * @param items the list of member information
     */
    public void setItems(List<ChatroomMemberInfo> items) {
        this.items = items;
    }
    
    /**
     * Get the total number of online members in the chatroom
     * 
     * @return the online count
     */
    public Integer getOnlineCount() {
        return onlineCount;
    }
    
    /**
     * Set the total number of online members in the chatroom
     * 
     * @param onlineCount the online count
     */
    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }
} 