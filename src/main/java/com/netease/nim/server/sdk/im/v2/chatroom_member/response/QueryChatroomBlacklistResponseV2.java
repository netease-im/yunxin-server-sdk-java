package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying chatroom blacklist
 * 
 * This class represents the response from the API that queries the list of
 * blocked users in a chatroom.
 */
public class QueryChatroomBlacklistResponseV2 {
    
    /**
     * List of blocked items
     */
    @JSONField(name = "items")
    private List<BlacklistMemberInfoV2> items;
    
    /**
     * Get the list of blocked items
     * 
     * @return the list of blocked items
     */
    public List<BlacklistMemberInfoV2> getItems() {
        return items;
    }
    
    /**
     * Set the list of blocked items
     * 
     * @param items the list of blocked items to set
     */
    public void setItems(List<BlacklistMemberInfoV2> items) {
        this.items = items;
    }
    
    /**
     * Information about a blocked member in a chatroom
     */
    public static class BlacklistMemberInfoV2 {
        
        /**
         * Account ID of the blocked member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Nickname of the blocked member in the chatroom
         */
        @JSONField(name = "room_nick")
        private String roomNick;
        
        /**
         * Avatar URL of the blocked member in the chatroom
         */
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
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
         * @param accountId the account ID to set
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
         * @param roomNick the room nickname to set
         */
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }
        
        /**
         * Get the room avatar URL
         * 
         * @return the room avatar URL
         */
        public String getRoomAvatar() {
            return roomAvatar;
        }
        
        /**
         * Set the room avatar URL
         * 
         * @param roomAvatar the room avatar URL to set
         */
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }
    }
} 