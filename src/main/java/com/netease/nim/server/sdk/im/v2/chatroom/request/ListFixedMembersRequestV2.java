package com.netease.nim.server.sdk.im.v2.chatroom.request;


public class ListFixedMembersRequestV2 {

    
    private Long roomId;
    
    
    private String memberRoles;
    
    
    public ListFixedMembersRequestV2() {
    }
    
    
    public ListFixedMembersRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public ListFixedMembersRequestV2(Long roomId, String memberRoles) {
        this.roomId = roomId;
        this.memberRoles = memberRoles;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public String getMemberRoles() {
        return memberRoles;
    }
    
    
    public void setMemberRoles(String memberRoles) {
        this.memberRoles = memberRoles;
    }
} 