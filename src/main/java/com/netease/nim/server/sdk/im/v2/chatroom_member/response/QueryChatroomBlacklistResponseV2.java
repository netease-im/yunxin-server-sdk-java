package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class QueryChatroomBlacklistResponseV2 {
    
    
    @JSONField(name = "items")
    private List<BlacklistMemberInfoV2> items;
    
    
    public List<BlacklistMemberInfoV2> getItems() {
        return items;
    }
    
    
    public void setItems(List<BlacklistMemberInfoV2> items) {
        this.items = items;
    }
    
    
    public static class BlacklistMemberInfoV2 {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "room_nick")
        private String roomNick;
        
        
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        
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
    }
} 