package com.netease.nim.server.sdk.im.v2.subscription;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.subscription.request.QueryUserStatusSubscriptionRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.request.SubscribeUserStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.request.UnsubscribeUserStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.QueryUserStatusSubscriptionResponseV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.SubscribeUserStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.UnsubscribeUserStatusResponseV2;

/**
 * Interface for user status subscription services
 */
public interface ISubscriptionV2Service {

    /**
     * Subscribe to user status events
     * 
     * Each account can subscribe to a maximum of 3000 other accounts.
     * Duplicate subscriptions within 1 minute will not take effect.
     *
     * @param request Request parameters for subscribing to user status events
     * @return Result containing the response with any failed subscriptions
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<SubscribeUserStatusResponseV2> subscribeUserStatus(
            SubscribeUserStatusRequestV2 request) throws YunxinSdkException;
            
    /**
     * Unsubscribe from user status events
     * 
     * @param request Request parameters for unsubscribing from user status events
     * @return Result containing the response with any failed unsubscriptions
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<UnsubscribeUserStatusResponseV2> unsubscribeUserStatus(
            UnsubscribeUserStatusRequestV2 request) throws YunxinSdkException;
            
    /**
     * Query user status subscription relationships
     * 
     * @param request Request parameters for querying user status subscriptions
     * @return Result containing the response with subscription details and any failed queries
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<QueryUserStatusSubscriptionResponseV2> queryUserStatusSubscription(
            QueryUserStatusSubscriptionRequestV2 request) throws YunxinSdkException;
} 