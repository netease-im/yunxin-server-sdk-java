package com.netease.nim.im.server.sdk.v2.subscription.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for subscribing to user status events
 * 
 * API: POST https://open.yunxinapi.com/im/v2/subscription/{account_id}
 */
public class SubscribeUserStatusRequestV2 {
    
    /**
     * Subscriber's account ID
     * Note: This is passed as a path parameter, not in the request body
     */
    private String subscriberAccountId;
    
    /**
     * Subscription duration in seconds
     * Range: 60s to 2592000s (30 days)
     * Note: This is passed as a query parameter, not in the request body
     */
    private Long duration;
    
    /**
     * List of account IDs to subscribe to their status events
     * Maximum 100 accounts per request
     */
    @JSONField(name = "account_ids")
    private List<String> accountIds;
    
    /**
     * Default constructor
     */
    public SubscribeUserStatusRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param subscriberAccountId The account ID of the subscriber
     * @param duration Subscription duration in seconds (60-2592000)
     * @param accountIds List of account IDs to subscribe to
     */
    public SubscribeUserStatusRequestV2(String subscriberAccountId, Long duration, List<String> accountIds) {
        this.subscriberAccountId = subscriberAccountId;
        this.duration = duration;
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
     * Get subscription duration
     * 
     * @return Subscription duration in seconds
     */
    public Long getDuration() {
        return duration;
    }
    
    /**
     * Set subscription duration
     * 
     * @param duration Subscription duration in seconds (60-2592000)
     */
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    
    /**
     * Get account IDs to subscribe to
     * 
     * @return List of account IDs
     */
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    /**
     * Set account IDs to subscribe to
     * 
     * @param accountIds List of account IDs
     */
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
} 