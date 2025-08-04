package com.netease.nim.server.sdk.im.v2.chatroom_member.request;


public class QueryTaggedMembersCountRequestV2 {
    
    
    private Long roomId;
    
    
    private String tag;
    
    
    public QueryTaggedMembersCountRequestV2() {
    }
    
    
    public QueryTaggedMembersCountRequestV2(Long roomId, String tag) {
        this.roomId = roomId;
        this.tag = tag;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public String getTag() {
        return tag;
    }
    
    
    public void setTag(String tag) {
        this.tag = tag;
    }
} 