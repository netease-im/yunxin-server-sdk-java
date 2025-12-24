package com.netease.nim.server.sdk.im.v2.broadcast;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.broadcast.request.DeleteBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.QueryBroadcastNotificationListRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.QueryBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.SendBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.SendChatroomBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.DeleteBroadcastNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.QueryBroadcastNotificationListResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.QueryBroadcastNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.SendBroadcastNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.SendChatroomBroadcastNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the broadcast notification service
 */
public class BroadcastV2Service implements IBroadcastV2Service {

    private final YunxinApiHttpClient yunxinApiHttpClient;

    /**
     * Constructor
     *
     * @param yunxinApiHttpClient HTTP client for API calls
     */
    public BroadcastV2Service(YunxinApiHttpClient yunxinApiHttpClient) {
        this.yunxinApiHttpClient = yunxinApiHttpClient;
    }

    @Override
    public Result<SendBroadcastNotificationResponseV2> sendBroadcastNotification(SendBroadcastNotificationRequestV2 request) throws YunxinSdkException {
        
        // Convert to JSON string using JSONField annotations
        String jsonRequestBody = JSON.toJSONString(request);
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            BroadcastV2UrlContext.BROADCAST_NOTIFICATION,
            BroadcastV2UrlContext.BROADCAST_NOTIFICATION,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, SendBroadcastNotificationResponseV2.class);
    }
    
    @Override
    public Result<DeleteBroadcastNotificationResponseV2> deleteBroadcastNotification(DeleteBroadcastNotificationRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = BroadcastV2UrlContext.DELETE_BROADCAST_NOTIFICATION
                .replace("{broadcast_id}", request.getBroadcastId());
        
        // Execute the API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.DELETE,
            BroadcastV2UrlContext.DELETE_BROADCAST_NOTIFICATION,
            path,
            null, // No query parameters
            null  // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, DeleteBroadcastNotificationResponseV2.class);
    }
    
    @Override
    public Result<QueryBroadcastNotificationResponseV2> queryBroadcastNotification(QueryBroadcastNotificationRequestV2 request) throws YunxinSdkException {
        
        // Replace the path parameter in the URL
        String path = BroadcastV2UrlContext.QUERY_BROADCAST_NOTIFICATION
                .replace("{broadcast_id}", request.getBroadcastId());
        
        // Execute the API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.GET,
            BroadcastV2UrlContext.QUERY_BROADCAST_NOTIFICATION,
            path,
            null, // No query parameters
            null  // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryBroadcastNotificationResponseV2.class);
    }
    
    @Override
    public Result<QueryBroadcastNotificationListResponseV2> queryBroadcastNotificationList(
            QueryBroadcastNotificationListRequestV2 request) throws YunxinSdkException {
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        if (request.getType() != null) {
            queryParams.put("type", request.getType().toString());
        }
        
        // Execute the API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.GET,
            BroadcastV2UrlContext.BROADCAST_NOTIFICATION,
            BroadcastV2UrlContext.BROADCAST_NOTIFICATION,
            queryParams,
            null  // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryBroadcastNotificationListResponseV2.class);
    }
    
    @Override
    public Result<SendChatroomBroadcastNotificationResponseV2> sendChatroomBroadcastNotification(SendChatroomBroadcastNotificationRequestV2 request) throws YunxinSdkException {
        
        // Convert to JSON string using JSONField annotations
        String jsonRequestBody = JSON.toJSONString(request);
        
        // Execute the API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            BroadcastV2UrlContext.CHATROOM_BROADCAST_NOTIFICATION,
            BroadcastV2UrlContext.CHATROOM_BROADCAST_NOTIFICATION,
            null,
            jsonRequestBody
        );

        return ResultUtils.convert(apiResponse, SendChatroomBroadcastNotificationResponseV2.class);

    }
} 