package com.netease.nim.server.sdk.im.v2.subscription.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class UnsubscribeUserStatusRequestV2 {
    
    
    private String subscriberAccountId;
    
    
    @JSONField(name = "account_ids")
    private List<String> accountIds;
    
    
    public UnsubscribeUserStatusRequestV2() {
    }
    
    
    public UnsubscribeUserStatusRequestV2(String subscriberAccountId, List<String> accountIds) {
        this.subscriberAccountId = subscriberAccountId;
        this.accountIds = accountIds;
    }
    
    
    public String getSubscriberAccountId() {
        return subscriberAccountId;
    }
    
    
    public void setSubscriberAccountId(String subscriberAccountId) {
        this.subscriberAccountId = subscriberAccountId;
    }
    
    
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 