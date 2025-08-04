package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchQueryChatroomMembersResponseV2 {
    
    
    @JSONField(name = "success_list")
    private List<MemberInfoV2> successList;
    
    
    @JSONField(name = "failed_list")
    private List<FailedMemberInfoV2> failedList;
    
    
    public BatchQueryChatroomMembersResponseV2() {
    }
    
    
    public List<MemberInfoV2> getSuccessList() {
        return successList;
    }
    
    
    public void setSuccessList(List<MemberInfoV2> successList) {
        this.successList = successList;
    }
    
    
    public List<FailedMemberInfoV2> getFailedList() {
        return failedList;
    }
    
    
    public void setFailedList(List<FailedMemberInfoV2> failedList) {
        this.failedList = failedList;
    }
    
    
    public static class MemberInfoV2 {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "room_nick")
        private String roomNick;
        
        
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        
        @JSONField(name = "extension")
        private String extension;
        
        
        @JSONField(name = "member_role")
        private Integer memberRole;
        
        
        @JSONField(name = "member_level")
        private Integer memberLevel;
        
        
        @JSONField(name = "is_online")
        private Boolean isOnline;
        
        
        @JSONField(name = "enter_time")
        private Long enterTime;
        
        
        @JSONField(name = "blocked")
        private Boolean blocked;
        
        
        @JSONField(name = "chat_banned")
        private Boolean chatBanned;
        
        
        @JSONField(name = "temp_chat_banned")
        private Boolean tempChatBanned;
        
        
        @JSONField(name = "temp_chat_banned_time")
        private Long tempChatBannedTime;
        
        
        @JSONField(name = "tags")
        private String tags;
        
        
        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;
        
        
        @JSONField(name = "online_info_list")
        private List<OnlineInfo> onlineInfoList;
        
        
        @JSONField(name = "online_count")
        private Integer onlineCount;
        
        
        public MemberInfoV2() {
        }

        
        public String getAccountId() {
            return accountId;
        }

        
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        
        public String getRoomNick() {
            return roomNick;
        }

        
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }

        
        public String getRoomAvatar() {
            return roomAvatar;
        }

        
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }

        
        public String getExtension() {
            return extension;
        }

        
        public void setExtension(String extension) {
            this.extension = extension;
        }

        
        public Integer getMemberRole() {
            return memberRole;
        }

        
        public void setMemberRole(Integer memberRole) {
            this.memberRole = memberRole;
        }

        
        public Integer getMemberLevel() {
            return memberLevel;
        }

        
        public void setMemberLevel(Integer memberLevel) {
            this.memberLevel = memberLevel;
        }

        
        public Boolean getIsOnline() {
            return isOnline;
        }

        
        public void setIsOnline(Boolean isOnline) {
            this.isOnline = isOnline;
        }

        
        public Long getEnterTime() {
            return enterTime;
        }

        
        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }

        
        public Boolean getBlocked() {
            return blocked;
        }

        
        public void setBlocked(Boolean blocked) {
            this.blocked = blocked;
        }

        
        public Boolean getChatBanned() {
            return chatBanned;
        }

        
        public void setChatBanned(Boolean chatBanned) {
            this.chatBanned = chatBanned;
        }

        
        public Boolean getTempChatBanned() {
            return tempChatBanned;
        }

        
        public void setTempChatBanned(Boolean tempChatBanned) {
            this.tempChatBanned = tempChatBanned;
        }

        
        public Long getTempChatBannedTime() {
            return tempChatBannedTime;
        }

        
        public void setTempChatBannedTime(Long tempChatBannedTime) {
            this.tempChatBannedTime = tempChatBannedTime;
        }

        
        public String getTags() {
            return tags;
        }

        
        public void setTags(String tags) {
            this.tags = tags;
        }

        
        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }

        
        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
        
        
        public List<OnlineInfo> getOnlineInfoList() {
            return onlineInfoList;
        }
        
        
        public void setOnlineInfoList(List<OnlineInfo> onlineInfoList) {
            this.onlineInfoList = onlineInfoList;
        }
        
        
        public Integer getOnlineCount() {
            return onlineCount;
        }
        
        
        public void setOnlineCount(Integer onlineCount) {
            this.onlineCount = onlineCount;
        }
    }
    
    
    public static class OnlineInfo {
        
        
        @JSONField(name = "robot")
        private Boolean robot;
        
        
        @JSONField(name = "room_nick")
        private String roomNick;
        
        
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        
        @JSONField(name = "enter_time")
        private Long enterTime;
        
        
        @JSONField(name = "client_type")
        private Integer clientType;
        
        
        public OnlineInfo() {
        }
        
        
        public Boolean getRobot() {
            return robot;
        }
        
        
        public void setRobot(Boolean robot) {
            this.robot = robot;
        }
        
        
        public String getRoomNick() {
            return roomNick;
        }
        
        
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }
        
        
        public String getRoomAvatar() {
            return roomAvatar;
        }
        
        
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }
        
        
        public Long getEnterTime() {
            return enterTime;
        }
        
        
        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }
        
        
        public Integer getClientType() {
            return clientType;
        }
        
        
        public void setClientType(Integer clientType) {
            this.clientType = clientType;
        }
    }
    
    
    public static class FailedMemberInfoV2 {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        
        public FailedMemberInfoV2() {
        }

        
        public String getAccountId() {
            return accountId;
        }

        
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        
        public Integer getErrorCode() {
            return errorCode;
        }

        
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }

        
        public String getErrorMsg() {
            return errorMsg;
        }

        
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
} 