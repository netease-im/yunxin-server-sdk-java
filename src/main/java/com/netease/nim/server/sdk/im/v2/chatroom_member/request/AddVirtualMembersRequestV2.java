package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class AddVirtualMembersRequestV2 {
    
    @JSONField(name = "room_id")
    private Long roomId;

    @JSONField(name = "virtual_members")
    private List<VirtualMemberInfoV2> virtualMembers;

    @JSONField(name = "extension")
    private String extension;
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    
    public AddVirtualMembersRequestV2() {
    }
    
    
    public AddVirtualMembersRequestV2(Long roomId, List<VirtualMemberInfoV2> virtualMembers) {
        this.roomId = roomId;
        this.virtualMembers = virtualMembers;
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
    
    
    public List<VirtualMemberInfoV2> getVirtualMembers() {
        return virtualMembers;
    }
    
    
    public void setVirtualMembers(List<VirtualMemberInfoV2> virtualMembers) {
        this.virtualMembers = virtualMembers;
    }
    
    
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
    
    
    public static class VirtualMemberInfoV2 {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "room_nick")
        private String roomNick;
        
        
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        
        @JSONField(name = "extension")
        private String extension;
        
        
        public VirtualMemberInfoV2() {
        }
        
        
        public VirtualMemberInfoV2(String accountId) {
            this.accountId = accountId;
        }
        
        
        public VirtualMemberInfoV2(String accountId, String roomNick, String roomAvatar, String extension) {
            this.accountId = accountId;
            this.roomNick = roomNick;
            this.roomAvatar = roomAvatar;
            this.extension = extension;
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
    }
} 