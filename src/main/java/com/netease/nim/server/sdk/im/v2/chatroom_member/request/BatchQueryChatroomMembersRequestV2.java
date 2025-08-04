package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import java.util.List;


public class BatchQueryChatroomMembersRequestV2 {
    
    
    private Long roomId;
    
    
    private List<String> accountIds;
    
    
    public BatchQueryChatroomMembersRequestV2() {
    }
    
    
    public BatchQueryChatroomMembersRequestV2(Long roomId, List<String> accountIds) {
        this.roomId = roomId;
        this.accountIds = accountIds;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 