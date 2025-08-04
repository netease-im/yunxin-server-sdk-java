package com.netease.nim.server.sdk.im.v2.chatroom_member.request;


public class QueryVirtualMembersRequestV2 {
    
    
    private Long roomId;
    
    
    public QueryVirtualMembersRequestV2() {
    }
    
    
    public QueryVirtualMembersRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
} 