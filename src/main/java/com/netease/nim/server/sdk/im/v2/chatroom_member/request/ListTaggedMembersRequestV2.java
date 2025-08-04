package com.netease.nim.server.sdk.im.v2.chatroom_member.request;


public class ListTaggedMembersRequestV2 {
    
    
    private Long roomId;
    
    
    private String tag;
    
    
    private Long offset;
    
    
    private Integer limit;
    
    
    public ListTaggedMembersRequestV2() {
    }
    
    
    public ListTaggedMembersRequestV2(Long roomId, String tag, Long offset, Integer limit) {
        this.roomId = roomId;
        this.tag = tag;
        this.offset = offset;
        this.limit = limit;
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