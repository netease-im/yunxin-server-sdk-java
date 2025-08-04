package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class QueryVirtualMembersResponseV2 {
    
    
    @JSONField(name = "items")
    private List<VirtualMemberInfoV2> items;
    
    
    public QueryVirtualMembersResponseV2() {
    }
    
    
    public List<VirtualMemberInfoV2> getItems() {
        return items;
    }
    
    
    public void setItems(List<VirtualMemberInfoV2> items) {
        this.items = items;
    }
    
    
    public static class VirtualMemberInfoV2 {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "room_nick")
        private String roomNick;
        
        
        @JSONField(name = "room_avatar")
        private String roomAvatar;
        
        
        @JSONField(name = "enter_time")
        private Long enterTime;
        
        
        public VirtualMemberInfoV2() {
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
        
        
        public Long getEnterTime() {
            return enterTime;
        }
        
        
        public void setEnterTime(Long enterTime) {
            this.enterTime = enterTime;
        }
    }
} 