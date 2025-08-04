package com.netease.nim.server.sdk.im.v2.friend.request;


public class GetFriendRequestV2 {

    private String accountId;
    private String friendAccountId;

    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFriendAccountId() {
        return friendAccountId;
    }

    
    public void setFriendAccountId(String friendAccountId) {
        this.friendAccountId = friendAccountId;
    }
} 