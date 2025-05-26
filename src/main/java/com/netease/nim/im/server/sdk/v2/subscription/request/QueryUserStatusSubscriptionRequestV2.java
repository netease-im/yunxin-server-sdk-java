package com.netease.nim.im.server.sdk.v2.subscription.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for querying user status subscriptions
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/subscription/{account_id}
 */
public class QueryUserStatusSubscriptionRequestV2 {
    
    /**
     * Subscriber's account ID
     * Note: This is passed as a path parameter, not in the request body
     */
    private String subscriberAccountId;
    
    /**
     * List of account IDs to query subscription status
     * Maximum 100 accounts per request
     */
    @JSONField(name = "account_ids")
    private List<String> accountIds;
    
    /**
     * Default constructor
     */
    public QueryUserStatusSubscriptionRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param subscriberAccountId The account ID of the subscriber
     * @param accountIds List of account IDs to query subscription status
     */
    public QueryUserStatusSubscriptionRequestV2(String subscriberAccountId, List<String> accountIds) {
        this.subscriberAccountId = subscriberAccountId;
        this.accountIds = accountIds;
    }
    
    /**
     * Get subscriber's account ID
     * 
     * @return Subscriber's account ID
     */
    public String getSubscriberAccountId() {
        return subscriberAccountId;
    }
    
    /**
     * Set subscriber's account ID
     * 
     * @param subscriberAccountId Subscriber's account ID
     */
    public void setSubscriberAccountId(String subscriberAccountId) {
        this.subscriberAccountId = subscriberAccountId;
    }
    
    /**
     * Get account IDs to query subscription status
     * 
     * @return List of account IDs
     */
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    /**
     * Set account IDs to query subscription status
     * 
     * @param accountIds List of account IDs
     */
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 