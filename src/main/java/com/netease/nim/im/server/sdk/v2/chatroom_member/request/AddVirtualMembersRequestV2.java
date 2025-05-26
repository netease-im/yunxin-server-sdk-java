package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for adding virtual members to a chatroom
 * 
 * Virtual users are typically only used to increase the number of online users in a chatroom,
 * not for normal communication. The same virtual user account can join multiple different
 * chatrooms simultaneously (no limit on the number). Virtual users automatically exit the
 * chatroom after 24 hours, and the countdown resets if they are added again within 24 hours.
 */
public class AddVirtualMembersRequestV2 {
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * List of virtual members to add (max 200)
     */
    @JSONField(name = "virtual_members")
    private List<VirtualMemberInfoV2> virtualMembers;
    
    /**
     * Whether to send notification about virtual members joining
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Extension data for the notification message
     * JSON format, max length 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Default constructor
     */
    public AddVirtualMembersRequestV2() {
    }
    
    /**
     * Constructor with required fields
     * 
     * @param roomId chatroom ID
     * @param virtualMembers list of virtual members to add
     */
    public AddVirtualMembersRequestV2(Long roomId, List<VirtualMemberInfoV2> virtualMembers) {
        this.roomId = roomId;
        this.virtualMembers = virtualMembers;
    }
    
    /**
     * Get chatroom ID
     * 
     * @return chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set chatroom ID
     * 
     * @param roomId chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get list of virtual members
     * 
     * @return list of virtual members
     */
    public List<VirtualMemberInfoV2> getVirtualMembers() {
        return virtualMembers;
    }
    
    /**
     * Set list of virtual members
     * 
     * @param virtualMembers list of virtual members
     */
    public void setVirtualMembers(List<VirtualMemberInfoV2> virtualMembers) {
        this.virtualMembers = virtualMembers;
    }
    
    /**
     * Get notification enabled flag
     * 
     * @return true if notification is enabled, false otherwise
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set notification enabled flag
     * 
     * @param notificationEnabled notification enabled flag
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    /**
     * Get notification extension
     * 
     * @return notification extension
     */
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    /**
     * Set notification extension
     * 
     * @param notificationExtension notification extension
     */
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
    
    /**
     * Information about a virtual member to add to the chatroom
     */
    public static class VirtualMemberInfoV2 {
        
        /**
         * Account ID of the virtual member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Nickname of the virtual member in the chatroom
         */
        @JSONField(name = "room_nick")
        private String roomNick;
        
        /**
         * Avatar URL of the virtual member in the chatroom
         */
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        /**
         * Extension information for the virtual member
         * JSON format, max length 4096 characters
         */
        @JSONField(name = "extension")
        private String extension;
        
        /**
         * Default constructor
         */
        public VirtualMemberInfoV2() {
        }
        
        /**
         * Constructor with account ID
         * 
         * @param accountId virtual member account ID
         */
        public VirtualMemberInfoV2(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Constructor with all fields
         * 
         * @param accountId virtual member account ID
         * @param roomNick virtual member nickname in the chatroom
         * @param roomAvatar virtual member avatar URL
         * @param extension virtual member extension information
         */
        public VirtualMemberInfoV2(String accountId, String roomNick, String roomAvatar, String extension) {
            this.accountId = accountId;
            this.roomNick = roomNick;
            this.roomAvatar = roomAvatar;
            this.extension = extension;
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
    }
} 