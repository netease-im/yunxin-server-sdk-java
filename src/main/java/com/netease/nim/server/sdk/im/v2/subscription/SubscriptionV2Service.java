package com.netease.nim.server.sdk.im.v2.subscription;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.subscription.request.QueryUserStatusSubscriptionRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.request.SubscribeUserStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.request.UnsubscribeUserStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.QueryUserStatusSubscriptionResponseV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.SubscribeUserStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.UnsubscribeUserStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the user status subscription service
 */
public class SubscriptionV2Service implements ISubscriptionV2Service {

    private final YunxinApiHttpClient yunxinApiHttpClient;

    /**
     * Constructor
     *
     * @param yunxinApiHttpClient HTTP client for API calls
     */
    public SubscriptionV2Service(YunxinApiHttpClient yunxinApiHttpClient) {
        this.yunxinApiHttpClient = yunxinApiHttpClient;
    }

    @Override
    public Result<SubscribeUserStatusResponseV2> subscribeUserStatus(SubscribeUserStatusRequestV2 request) throws YunxinSdkException {
        
        // Create URL with path parameter
        String url = SubscriptionV2UrlContext.SUBSCRIBE_USER_STATUS.replace(
                "{account_id}", request.getSubscriberAccountId());
        
        // Create query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("duration", String.valueOf(request.getDuration()));
        
        // Convert request body to JSON string
        String jsonRequestBody = JSON.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            SubscriptionV2UrlContext.SUBSCRIBE_USER_STATUS,
            url,
            queryParams,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, SubscribeUserStatusResponseV2.class);
    }
    
    @Override
    public Result<UnsubscribeUserStatusResponseV2> unsubscribeUserStatus(UnsubscribeUserStatusRequestV2 request) throws YunxinSdkException {

        // Create URL with path parameter
        String url = SubscriptionV2UrlContext.UNSUBSCRIBE_USER_STATUS.replace(
                "{account_id}", request.getSubscriberAccountId());
        
        // Convert request body to JSON string
        String jsonRequestBody = JSON.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.DELETE,
            SubscriptionV2UrlContext.UNSUBSCRIBE_USER_STATUS,
            url,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, UnsubscribeUserStatusResponseV2.class);
    }
    
    @Override
    public Result<QueryUserStatusSubscriptionResponseV2> queryUserStatusSubscription(QueryUserStatusSubscriptionRequestV2 request) throws YunxinSdkException {

        // Create URL with path parameter
        String url = SubscriptionV2UrlContext.QUERY_USER_STATUS_SUBSCRIPTION.replace(
                "{account_id}", request.getSubscriberAccountId());
        
        // Convert request body to JSON string
        String jsonRequestBody = JSON.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.PATCH,
            SubscriptionV2UrlContext.QUERY_USER_STATUS_SUBSCRIPTION,
            url,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, QueryUserStatusSubscriptionResponseV2.class);
    }
} 