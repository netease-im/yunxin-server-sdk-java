package com.netease.nim.server.sdk.im.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchGetConversationGroupsRequestV2 {

    
    @JSONField(name = "account_id")
    private String accountId;

    
    @JSONField(name = "group_ids")
    private List<Long> groupIds;

    
    public BatchGetConversationGroupsRequestV2() {
    }

    
    public BatchGetConversationGroupsRequestV2(String accountId, List<Long> groupIds) {
        this.accountId = accountId;
        this.groupIds = groupIds;
    }

    
    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    
    public List<Long> getGroupIds() {
        return groupIds;
    }

    
    public void setGroupIds(List<Long> groupIds) {
        this.groupIds = groupIds;
    }
} 