package com.netease.nim.im.server.sdk.v2.users.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request class for getting users' online status
 */
public class GetUserOnlineStatusRequestV2 {

    @JSONField(name = "account_ids")
    private List<String> accountIds;

    /**
     * Get the list of account IDs to query
     * @return list of account IDs
     */
    public List<String> getAccountIds() {
        return accountIds;
    }

    /**
     * Set the list of account IDs to query (maximum 100 accounts)
     * @param accountIds list of account IDs
     */
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 