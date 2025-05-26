package com.netease.nim.im.server.sdk.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for updating online chatroom member information
 * 
 * This class encapsulates the response for updating a chatroom member's online information.
 * The response is typically empty, with success/failure indicated by the standard
 * Result object's code and message.
 */
public class UpdateOnlineMemberInfoResponseV2 {
    
    /**
     * Default constructor
     */
    public UpdateOnlineMemberInfoResponseV2() {
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