package com.netease.nim.server.sdk.im.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class ListAllConversationGroupsRequestV2 {

    
    @JSONField(name = "account_id")
    private String accountId;

    
    public ListAllConversationGroupsRequestV2() {
    }

    
    public ListAllConversationGroupsRequestV2(String accountId) {
        this.accountId = accountId;
    }

    
    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 