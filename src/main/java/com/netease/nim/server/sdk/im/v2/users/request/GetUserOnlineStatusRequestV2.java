package com.netease.nim.server.sdk.im.v2.users.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


public class GetUserOnlineStatusRequestV2 {

    @JSONField(name = "account_ids")
    private List<String> accountIds;

    
    public List<String> getAccountIds() {
        return accountIds;
    }

    
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 