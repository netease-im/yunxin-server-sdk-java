package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying virtual members in a chatroom
 */
public class QueryVirtualMembersResponseV2 {
    
    /**
     * List of virtual members in the chatroom
     */
    @JSONField(name = "items")
    private List<VirtualMemberInfoV2> items;
    
    /**
     * Default constructor
     */
    public QueryVirtualMembersResponseV2() {
    }
    
    /**
     * Get list of virtual members
     * 
     * @return list of virtual members
     */
    public List<VirtualMemberInfoV2> getItems() {
        return items;
    }
    
    /**
     * Set list of virtual members
     * 
     * @param items list of virtual members
     */
    public void setItems(List<VirtualMemberInfoV2> items) {
        this.items = items;
    }
    
    /**
     * Virtual member information
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
         * Time when the virtual member entered the chatroom (Unix timestamp in seconds)
         */
        @JSONField(name = "enter_time")
        private Long enterTime;
        
        /**
         * Default constructor
         */
        public VirtualMemberInfoV2() {
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
    }
} 