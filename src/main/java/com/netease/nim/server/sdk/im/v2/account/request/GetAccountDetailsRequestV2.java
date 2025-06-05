package com.netease.nim.server.sdk.im.v2.account.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for getting account details
 */
public class GetAccountDetailsRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 