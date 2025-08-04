package com.netease.nim.server.sdk.im.v2.chatroom_member.request;


public class QueryChatBannedRequestV2 {
    
    
    private Long roomId;
    
    
    public QueryChatBannedRequestV2() {
    }
    
    
    public QueryChatBannedRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
} 