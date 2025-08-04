package com.netease.nim.server.sdk.im.v2.chatroom.request;


public class GetChatroomAddressRequestV2 {

    
    private Long roomId;
    
    
    private String accountId;
    
    
    private String clientIp;
    
    
    private Integer clientType;
    
    
    private Integer ipType;
    
    
    public GetChatroomAddressRequestV2() {
    }
    
    
    public GetChatroomAddressRequestV2(Long roomId, String accountId, String clientIp) {
        this.roomId = roomId;
        this.accountId = accountId;
        this.clientIp = clientIp;
    }
    
    
    public GetChatroomAddressRequestV2(Long roomId, String accountId, String clientIp, Integer clientType, Integer ipType) {
        this.roomId = roomId;
        this.accountId = accountId;
        this.clientIp = clientIp;
        this.clientType = clientType;
        this.ipType = ipType;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public String getAccountId() {
        return accountId;
    }
    
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    
    public String getClientIp() {
        return clientIp;
    }
    
    
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
    
    
    public Integer getClientType() {
        return clientType;
    }
    
    
    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }
    
    
    public Integer getIpType() {
        return ipType;
    }
    
    
    public void setIpType(Integer ipType) {
        this.ipType = ipType;
    }
} 