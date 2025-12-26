package com.netease.nim.server.sdk.im.v2.system_push;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.system_push.request.*;
import com.netease.nim.server.sdk.im.v2.system_push.response.*;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the system push service
 */
public class SystemPushV2Service implements ISystemPushV2Service {

    private final YunxinApiHttpClient yunxinApiHttpClient;

    /**
     * Constructor
     *
     * @param yunxinApiHttpClient HTTP client for API calls
     */
    public SystemPushV2Service(YunxinApiHttpClient yunxinApiHttpClient) {
        this.yunxinApiHttpClient = yunxinApiHttpClient;
    }
    
    @Override
    public Result<SendPushNotificationResponseV2> sendPushNotification(SendPushNotificationRequestV2 request) throws YunxinSdkException {
        
        String jsonRequestBody = JSON.toJSONString(request);
        
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            SystemPushV2UrlContext.PUSH_NOTIFICATION,
            SystemPushV2UrlContext.PUSH_NOTIFICATION,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, SendPushNotificationResponseV2.class);
    }
    
    @Override
    public Result<GetPushNotificationResponseV2> getPushNotification(GetPushNotificationRequestV2 request) throws YunxinSdkException {
        
        String url = SystemPushV2UrlContext.GET_PUSH_NOTIFICATION.replace(
                "{push_id}", String.valueOf(request.getPushId()));
        
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.GET,
            SystemPushV2UrlContext.GET_PUSH_NOTIFICATION,
            url,
            null,
            null
        );
        
        return ResultUtils.convert(apiResponse, GetPushNotificationResponseV2.class);
    }
    
    @Override
    public Result<ListPushNotificationsResponseV2> listPushNotifications(ListPushNotificationsRequestV2 request) throws YunxinSdkException {
        
        Map<String, String> queryParams = new HashMap<>();
        if (request.getPageToken() != null) {
            queryParams.put("page_token", request.getPageToken());
        }
        if (request.getLimit() != null) {
            queryParams.put("limit", String.valueOf(request.getLimit()));
        }
        if (request.getType() != null) {
            queryParams.put("type", String.valueOf(request.getType()));
        }
        
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.GET,
            SystemPushV2UrlContext.PUSH_NOTIFICATION,
            SystemPushV2UrlContext.PUSH_NOTIFICATION,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListPushNotificationsResponseV2.class);
    }
}

