package com.netease.nim.server.sdk.im.v2.users.request;

/**
 * Request class for getting user information
 */
public class GetUserRequestV2 {

    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID to query
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 