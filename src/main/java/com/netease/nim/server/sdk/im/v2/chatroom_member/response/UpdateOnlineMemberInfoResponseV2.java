package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

public class UpdateOnlineMemberInfoResponseV2 {
    
    @JSONField(name = "extension")
    private String extension;
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    @JSONField(name = "account_id")
    private String accountId;
    
    @JSONField(name = "room_nick")
    private String roomNick;
    
    @JSONField(name = "room_avatar")
    private String roomAvatar;
    
    @JSONField(name = "member_role")
    private Integer memberRole;
    
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
    
    @JSONField(name = "online_info_list")
    private List<OnlineInfo> onlineInfoList;
    
    @JSONField(name = "online_count")
    private Integer onlineCount;

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

    public UpdateOnlineMemberInfoResponseV2() {
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public Integer getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(Integer memberRole) {
        this.memberRole = memberRole;
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