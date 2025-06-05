package com.netease.nim.server.sdk.im.v2.friend.request;

/**
 * Request class for getting friend information
 */
public class GetFriendRequestV2 {

    private String accountId;
    private String friendAccountId;

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID that initiates the query
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFriendAccountId() {
        return friendAccountId;
    }

    /**
     * Set the account ID of the friend to query
     * @param friendAccountId friend account ID
     */
    public void setFriendAccountId(String friendAccountId) {
        this.friendAccountId = friendAccountId;
    }
} 