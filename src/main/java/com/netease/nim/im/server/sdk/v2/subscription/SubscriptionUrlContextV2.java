package com.netease.nim.im.server.sdk.v2.subscription;

/**
 * URL context for user status subscription API V2
 */
public class SubscriptionUrlContextV2 {

    /**
     * URL template for subscribing to user status events
     * {account_id} should be replaced with the subscriber's account ID
     */
    public static final String SUBSCRIBE_USER_STATUS = "/im/v2/subscription/{account_id}";
    
    /**
     * URL template for unsubscribing from user status events
     * {account_id} should be replaced with the subscriber's account ID
     * Note: This uses the same URL as subscribe but with DELETE method
     */
    public static final String UNSUBSCRIBE_USER_STATUS = "/im/v2/subscription/{account_id}";
    
    /**
     * URL template for querying user status subscriptions
     * {account_id} should be replaced with the subscriber's account ID
     * Note: This uses the same URL as subscribe/unsubscribe but with PATCH method
     */
    public static final String QUERY_USER_STATUS_SUBSCRIPTION = "/im/v2/subscription/{account_id}";
} 