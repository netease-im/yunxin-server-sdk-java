package com.netease.nim.server.sdk.im.v2.subscription.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class SubscribeUserStatusRequestV2 {
    
    
    private String subscriberAccountId;
    
    
    private Long duration;
    
    
    @JSONField(name = "account_ids")
    private List<String> accountIds;
    
    
    public SubscribeUserStatusRequestV2() {
    }
    
    
    public SubscribeUserStatusRequestV2(String subscriberAccountId, Long duration, List<String> accountIds) {
        this.subscriberAccountId = subscriberAccountId;
        this.duration = duration;
        this.accountIds = accountIds;
    }
    
    
    public String getSubscriberAccountId() {
        return subscriberAccountId;
    }
    
    
    public void setSubscriberAccountId(String subscriberAccountId) {
        this.subscriberAccountId = subscriberAccountId;
    }
    
    
    public Long getDuration() {
        return duration;
    }
    
    
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    
    
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 