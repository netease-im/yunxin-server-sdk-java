package com.netease.nim.server.sdk.im.v2.system_notification;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.system_notification.request.SendBatchCustomNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.system_notification.request.SendCustomNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.system_notification.response.SendBatchCustomNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.system_notification.response.SendCustomNotificationResponseV2;

/**
 * Interface for custom notification services
 */
public interface ICustomNotificationV2Service {

    /**
     * Send a custom system notification
     *
     * @param request Request parameters for sending custom notification
     * @return Result containing the response of the custom notification
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<SendCustomNotificationResponseV2> sendCustomNotification(
            SendCustomNotificationRequestV2 request) throws YunxinSdkException;
            
    /**
     * Send batch custom system notifications
     *
     * @param request Request parameters for sending batch custom notifications
     * @return Result containing the response of the batch custom notifications
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<SendBatchCustomNotificationResponseV2> sendBatchCustomNotification(
            SendBatchCustomNotificationRequestV2 request) throws YunxinSdkException;
} 