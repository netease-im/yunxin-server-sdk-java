package com.netease.nim.server.sdk.im.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class GetConversationGroupRequestV2 {

    
    @JSONField(name = "group_id")
    private Long groupId;

    
    @JSONField(name = "account_id")
    private String accountId;

    
    public GetConversationGroupRequestV2() {
    }

    
    public GetConversationGroupRequestV2(Long groupId, String accountId) {
        this.groupId = groupId;
        this.accountId = accountId;
    }

    
    public Long getGroupId() {
        return groupId;
    }

    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    
    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 