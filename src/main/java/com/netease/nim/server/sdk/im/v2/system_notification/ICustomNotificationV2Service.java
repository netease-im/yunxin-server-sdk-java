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

    Result<SendCustomNotificationResponseV2> sendCustomNotification(
            SendCustomNotificationRequestV2 request) throws YunxinSdkException;
            
    Result<SendBatchCustomNotificationResponseV2> sendBatchCustomNotification(
            SendBatchCustomNotificationRequestV2 request) throws YunxinSdkException;
} 