package com.netease.nim.server.sdk.im.v2.subscription.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for unsubscribing from user status events
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/subscription/{account_id}
 */
public class UnsubscribeUserStatusRequestV2 {
    
    /**
     * Subscriber's account ID
     * Note: This is passed as a path parameter, not in the request body
     */
    private String subscriberAccountId;
    
    /**
     * List of account IDs to unsubscribe from their status events
     * Maximum 100 accounts per request
     * If null or empty, unsubscribes from all accounts
     */
    @JSONField(name = "account_ids")
    private List<String> accountIds;
    
    /**
     * Default constructor
     */
    public UnsubscribeUserStatusRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param subscriberAccountId The account ID of the subscriber
     * @param accountIds List of account IDs to unsubscribe from
     */
    public UnsubscribeUserStatusRequestV2(String subscriberAccountId, List<String> accountIds) {
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
     * Get account IDs to unsubscribe from
     * 
     * @return List of account IDs
     */
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    /**
     * Set account IDs to unsubscribe from
     * 
     * @param accountIds List of account IDs
     */
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 