package com.netease.nim.server.sdk.im.v2.account.request;

/**
 * Request for refreshing account token
 */
public class RefreshTokenRequestV2 {
    /**
     * Account ID
     */
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 