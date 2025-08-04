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

    Result<SubscribeUserStatusResponseV2> subscribeUserStatus(SubscribeUserStatusRequestV2 request) throws YunxinSdkException;
            
    Result<UnsubscribeUserStatusResponseV2> unsubscribeUserStatus(UnsubscribeUserStatusRequestV2 request) throws YunxinSdkException;

    Result<QueryUserStatusSubscriptionResponseV2> queryUserStatusSubscription(QueryUserStatusSubscriptionRequestV2 request) throws YunxinSdkException;
} 