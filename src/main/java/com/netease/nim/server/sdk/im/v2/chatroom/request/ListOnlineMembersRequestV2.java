package com.netease.nim.server.sdk.im.v2.chatroom.request;


public class ListOnlineMembersRequestV2 {

    
    private Long roomId;
    
    
    private String memberRoles;
    
    
    private Long offset;
    
    
    private Integer limit;
    
    
    public ListOnlineMembersRequestV2() {
    }
    
    
    public ListOnlineMembersRequestV2(Long roomId, Long offset, Integer limit) {
        this.roomId = roomId;
        this.offset = offset;
        this.limit = limit;
    }
    
    
    public ListOnlineMembersRequestV2(Long roomId, String memberRoles, Long offset, Integer limit) {
        this.roomId = roomId;
        this.memberRoles = memberRoles;
        this.offset = offset;
        this.limit = limit;
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
    
    
    public Long getOffset() {
        return offset;
    }
    
    
    public void setOffset(Long offset) {
        this.offset = offset;
    }
    
    
    public Integer getLimit() {
        return limit;
    }
    
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 