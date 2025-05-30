package com.netease.nim.im.server.sdk.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying the list of banned members in a chatroom
 * 
 * This class encapsulates the response containing the list of banned members in a chatroom.
 */
public class QueryChatBannedResponseV2 {

    /**
     * List of banned members
     */
    @JSONField(name = "items")
    private List<BannedMember> items;

    /**
     * Default constructor
     */
    public QueryChatBannedResponseV2() {
    }

    /**
     * Get the list of banned members
     *
     * @return the list of banned members
     */
    public List<BannedMember> getItems() {
        return items;
    }

    /**
     * Set the list of banned members
     *
     * @param items the list of banned members
     */
    public void setItems(List<BannedMember> items) {
        this.items = items;
    }

    /**
     * Class representing a banned member in a chatroom
     */
    public static class BannedMember {
        /**
         * Member account ID
         */
        @JSONField(name = "account_id")
        private String accountId;

        /**
         * Member nickname in the chatroom
         */
        @JSONField(name = "room_nick")
        private String roomNick;

        /**
         * Member avatar in the chatroom
         */
        @JSONField(name = "room_avatar")
        private String roomAvatar;

        /**
         * Default constructor
         */
        public BannedMember() {
        }

        /**
         * Get the member account ID
         *
         * @return the member account ID
         */
        public String getAccountId() {
            return accountId;
        }

        /**
         * Set the member account ID
         *
         * @param accountId the member account ID
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        /**
         * Get the member nickname in the chatroom
         *
         * @return the member nickname in the chatroom
         */
        public String getRoomNick() {
            return roomNick;
        }

        /**
         * Set the member nickname in the chatroom
         *
         * @param roomNick the member nickname in the chatroom
         */
        public void setRoomNick(String roomNick) {
            this.roomNick = roomNick;
        }

        /**
         * Get the member avatar in the chatroom
         *
         * @return the member avatar in the chatroom
         */
        public String getRoomAvatar() {
            return roomAvatar;
        }

        /**
         * Set the member avatar in the chatroom
         *
         * @param roomAvatar the member avatar in the chatroom
         */
        public void setRoomAvatar(String roomAvatar) {
            this.roomAvatar = roomAvatar;
        }
    }
} 