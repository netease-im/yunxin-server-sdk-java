package com.netease.nim.server.sdk.im.v2.system_notification;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.system_notification.request.SendBatchCustomNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.system_notification.request.SendCustomNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.system_notification.response.SendBatchCustomNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.system_notification.response.SendCustomNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

/**
 * Implementation of the custom notification service
 */
public class CustomNotificationV2Service implements ICustomNotificationV2Service {

    private final YunxinApiHttpClient yunxinApiHttpClient;

    /**
     * Constructor
     *
     * @param yunxinApiHttpClient HTTP client for API calls
     */
    public CustomNotificationV2Service(YunxinApiHttpClient yunxinApiHttpClient) {
        this.yunxinApiHttpClient = yunxinApiHttpClient;
    }

    @Override
    public Result<SendCustomNotificationResponseV2> sendCustomNotification(SendCustomNotificationRequestV2 request) throws YunxinSdkException {
        
        // Convert to JSON string using JSONField annotations
        String jsonRequestBody = JSON.toJSONString(request);
        
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            CustomNotificationV2UrlContext.CUSTOM_NOTIFICATION,
            CustomNotificationV2UrlContext.CUSTOM_NOTIFICATION,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, SendCustomNotificationResponseV2.class);
    }
    
    @Override
    public Result<SendBatchCustomNotificationResponseV2> sendBatchCustomNotification(SendBatchCustomNotificationRequestV2 request) throws YunxinSdkException {
        
        // Convert to JSON string using JSONField annotations
        String jsonRequestBody = JSON.toJSONString(request);
        
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            CustomNotificationV2UrlContext.BATCH_CUSTOM_NOTIFICATION,
            CustomNotificationV2UrlContext.BATCH_CUSTOM_NOTIFICATION,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, SendBatchCustomNotificationResponseV2.class);
    }
} 