package com.netease.nim.im.server.sdk.v2.system_notification;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.system_notification.request.SendBatchCustomNotificationRequestV2;
import com.netease.nim.im.server.sdk.v2.system_notification.request.SendCustomNotificationRequestV2;
import com.netease.nim.im.server.sdk.v2.system_notification.response.SendBatchCustomNotificationResponseV2;
import com.netease.nim.im.server.sdk.v2.system_notification.response.SendCustomNotificationResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

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
    public Result<SendCustomNotificationResponseV2> sendCustomNotification(
            SendCustomNotificationRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getType() == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }
        
        if (request.getType() < 1 || request.getType() > 3) {
            throw new IllegalArgumentException("Invalid notification type: must be 1 (P2P), 2 (Team), or 3 (Superteam)");
        }
        
        if (request.getReceiverId() == null || request.getReceiverId().isEmpty()) {
            throw new IllegalArgumentException("Receiver ID cannot be null or empty");
        }
        
        if (request.getContent() == null || request.getContent().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }

        
        // Convert to JSON string using JSONField annotations
        String jsonRequestBody = JSON.toJSONString(request);
        
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            CustomNotificationUrlContextV2.CUSTOM_NOTIFICATION,
            CustomNotificationUrlContextV2.CUSTOM_NOTIFICATION,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, SendCustomNotificationResponseV2.class);
    }
    
    @Override
    public Result<SendBatchCustomNotificationResponseV2> sendBatchCustomNotification(
            SendBatchCustomNotificationRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getReceiverIds() == null || request.getReceiverIds().isEmpty()) {
            throw new IllegalArgumentException("Receiver IDs cannot be null or empty");
        }

        if (request.getContent() == null || request.getContent().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        
        // Convert to JSON string using JSONField annotations
        String jsonRequestBody = JSON.toJSONString(request);
        
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            CustomNotificationUrlContextV2.BATCH_CUSTOM_NOTIFICATION,
            CustomNotificationUrlContextV2.BATCH_CUSTOM_NOTIFICATION,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, SendBatchCustomNotificationResponseV2.class);
    }
} 