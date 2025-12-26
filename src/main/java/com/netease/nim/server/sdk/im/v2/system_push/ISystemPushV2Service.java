package com.netease.nim.server.sdk.im.v2.system_push;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.system_push.request.*;
import com.netease.nim.server.sdk.im.v2.system_push.response.*;

/**
 * Interface for system push services
 */
public interface ISystemPushV2Service {
    
    Result<SendPushNotificationResponseV2> sendPushNotification(
            SendPushNotificationRequestV2 request) throws YunxinSdkException;
    
    Result<GetPushNotificationResponseV2> getPushNotification(
            GetPushNotificationRequestV2 request) throws YunxinSdkException;
    
    Result<ListPushNotificationsResponseV2> listPushNotifications(
            ListPushNotificationsRequestV2 request) throws YunxinSdkException;
}

