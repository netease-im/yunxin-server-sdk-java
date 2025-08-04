package com.netease.nim.server.sdk.im.v2.chatroom.request;


public class GetChatroomInfoRequestV2 {

    
    private Long roomId;
    
    
    private Boolean needOnlineUserCount;
    
    
    private Boolean onlineUserCountByType;
    
    
    public GetChatroomInfoRequestV2() {
    }
    
    
    public GetChatroomInfoRequestV2(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public GetChatroomInfoRequestV2(Long roomId, Boolean needOnlineUserCount, Boolean onlineUserCountByType) {
        this.roomId = roomId;
        this.needOnlineUserCount = needOnlineUserCount;
        this.onlineUserCountByType = onlineUserCountByType;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public Boolean getNeedOnlineUserCount() {
        return needOnlineUserCount;
    }
    
    
    public void setNeedOnlineUserCount(Boolean needOnlineUserCount) {
        this.needOnlineUserCount = needOnlineUserCount;
    }
    
    
    public Boolean getOnlineUserCountByType() {
        return onlineUserCountByType;
    }
    
    
    public void setOnlineUserCountByType(Boolean onlineUserCountByType) {
        this.onlineUserCountByType = onlineUserCountByType;
    }
} 