package com.netease.nim.im.server.sdk.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for batch querying chatroom fixed members information
 * 
 * This response contains information about the queried fixed members,
 * including both successfully and unsuccessfully queried members.
 */
public class BatchQueryChatroomMembersResponseV2 {
    
    /**
     * List of members that were successfully queried
     */
    @JSONField(name = "success_list")
    private List<MemberInfoV2> successList;
    
    /**
     * List of members that failed to be queried
     */
    @JSONField(name = "failed_list")
    private List<FailedMemberInfoV2> failedList;
    
    /**
     * Default constructor
     */
    public BatchQueryChatroomMembersResponseV2() {
    }
    
    /**
     * Get list of successfully queried members
     * 
     * @return list of member information
     */
    public List<MemberInfoV2> getSuccessList() {
        return successList;
    }
    
    /**
     * Set list of successfully queried members
     * 
     * @param successList list of member information
     */
    public void setSuccessList(List<MemberInfoV2> successList) {
        this.successList = successList;
    }
    
    /**
     * Get list of members that failed to be queried
     * 
     * @return list of failed member information
     */
    public List<FailedMemberInfoV2> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of members that failed to be queried
     * 
     * @param failedList list of failed member information
     */
    public void setFailedList(List<FailedMemberInfoV2> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Information about a successfully queried chatroom member
     */
    public static class MemberInfoV2 {
        
        /**
         * Account ID of the member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Nickname of the member in the chatroom
         */
        @JSONField(name = "room_nick")
        private String roomNick;
        
        /**
         * Avatar URL of the member in the chatroom
         */
        @JSONField(name = "room_avator")
        private String roomAvatar;
        
        /**
         * Extension information for the member
         */
        @JSONField(name = "extension")
        private String extension;
        
        /**
         * Role of the member in the chatroom
         * 0: Regular member
         * 1: Creator
         * 2: Administrator
         * 3: Regular guest
         * 4: Anonymous guest
         */
        @JSONField(name = "member_role")
        private Integer memberRole;
        
        /**
         * Level of the member in the chatroom
         */
        @JSONField(name = "member_level")
        private Integer memberLevel;
        
        /**
         * Whether the member is currently online
         */
        @JSONField(name = "is_online")
        private Boolean isOnline;
        
        /**
         * Time when the member entered the chatroom (Unix timestamp in seconds)
         */
        @JSONField(name = "enter_time")
        private Long enterTime;
        
        /**
         * Whether the member is blocked (in blacklist)
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
         * Tags of the member (only for online members who specified tags at login)
         */
        @JSONField(name = "tags")
        private String tags;
        
        /**
         * Notification target tags (only for online members who specified tags at login)
         */
        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;
        
        /**
         * Default constructor
         */
        public MemberInfoV2() {
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
         * Get room nickname
         * 
         * @return room nickname
         */
        public String getRoomNick() {
            return roomNick;
        }

        /**
         * Set room nickname
         * 
         * @param roomNick room nickname
         */
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }

        /**
         * Get room avatar URL
         * 
         * @return room avatar URL
         */
        public String getRoomAvatar() {
            return roomAvatar;
        }

        /**
         * Set room avatar URL
         * 
         * @param roomAvatar room avatar URL
         */
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }

        /**
         * Get extension information
         * 
         * @return extension information
         */
        public String getExtension() {
            return extension;
        }

        /**
         * Set extension information
         * 
         * @param extension extension information
         */
        public void setExtension(String extension) {
            this.extension = extension;
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
         * Get member level
         * 
         * @return member level
         */
        public Integer getMemberLevel() {
            return memberLevel;
        }

        /**
         * Set member level
         * 
         * @param memberLevel member level
         */
        public void setMemberLevel(Integer memberLevel) {
            this.memberLevel = memberLevel;
        }

        /**
         * Get online status
         * 
         * @return true if member is online, false otherwise
         */
        public Boolean getIsOnline() {
            return isOnline;
        }

        /**
         * Set online status
         * 
         * @param isOnline online status
         */
        public void setIsOnline(Boolean isOnline) {
            this.isOnline = isOnline;
        }

        /**
         * Get enter time
         * 
         * @return enter time
         */
        public Long getEnterTime() {
            return enterTime;
        }

        /**
         * Set enter time
         * 
         * @param enterTime enter time
         */
        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }

        /**
         * Get blocked status
         * 
         * @return true if member is blocked, false otherwise
         */
        public Boolean getBlocked() {
            return blocked;
        }

        /**
         * Set blocked status
         * 
         * @param blocked blocked status
         */
        public void setBlocked(Boolean blocked) {
            this.blocked = blocked;
        }

        /**
         * Get chat banned status
         * 
         * @return true if member is banned from chatting, false otherwise
         */
        public Boolean getChatBanned() {
            return chatBanned;
        }

        /**
         * Set chat banned status
         * 
         * @param chatBanned chat banned status
         */
        public void setChatBanned(Boolean chatBanned) {
            this.chatBanned = chatBanned;
        }

        /**
         * Get temporary chat banned status
         * 
         * @return true if member is temporarily banned from chatting, false otherwise
         */
        public Boolean getTempChatBanned() {
            return tempChatBanned;
        }

        /**
         * Set temporary chat banned status
         * 
         * @param tempChatBanned temporary chat banned status
         */
        public void setTempChatBanned(Boolean tempChatBanned) {
            this.tempChatBanned = tempChatBanned;
        }

        /**
         * Get temporary chat banned time
         * 
         * @return temporary chat banned time in seconds
         */
        public Long getTempChatBannedTime() {
            return tempChatBannedTime;
        }

        /**
         * Set temporary chat banned time
         * 
         * @param tempChatBannedTime temporary chat banned time in seconds
         */
        public void setTempChatBannedTime(Long tempChatBannedTime) {
            this.tempChatBannedTime = tempChatBannedTime;
        }

        /**
         * Get tags
         * 
         * @return tags
         */
        public String getTags() {
            return tags;
        }

        /**
         * Set tags
         * 
         * @param tags tags
         */
        public void setTags(String tags) {
            this.tags = tags;
        }

        /**
         * Get notification target tags
         * 
         * @return notification target tags
         */
        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }

        /**
         * Set notification target tags
         * 
         * @param notifyTargetTags notification target tags
         */
        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
    }
    
    /**
     * Information about a member that failed to be queried
     */
    public static class FailedMemberInfoV2 {
        
        /**
         * Account ID of the member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error code for the failure
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message for the failure
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        /**
         * Default constructor
         */
        public FailedMemberInfoV2() {
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
         * Get error code
         * 
         * @return error code
         */
        public Integer getErrorCode() {
            return errorCode;
        }

        /**
         * Set error code
         * 
         * @param errorCode error code
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }

        /**
         * Get error message
         * 
         * @return error message
         */
        public String getErrorMsg() {
            return errorMsg;
        }

        /**
         * Set error message
         * 
         * @param errorMsg error message
         */
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
} 