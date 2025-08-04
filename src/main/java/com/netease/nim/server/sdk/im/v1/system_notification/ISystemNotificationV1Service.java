package com.netease.nim.server.sdk.im.v1.system_notification;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.system_notification.request.SendAttachMsgRequestV1;
import com.netease.nim.server.sdk.im.v1.system_notification.request.SendBatchAttachMsgRequestV1;
import com.netease.nim.server.sdk.im.v1.system_notification.response.SendAttachMsgResponseV1;
import com.netease.nim.server.sdk.im.v1.system_notification.response.SendBatchAttachMsgResponseV1;

/**
 * 系统通知相关接口
 */
public interface ISystemNotificationV1Service {

    Result<SendAttachMsgResponseV1> sendAttachMsg(SendAttachMsgRequestV1 request) throws YunxinSdkException;

    Result<SendBatchAttachMsgResponseV1> sendBatchAttachMsg(SendBatchAttachMsgRequestV1 request) throws YunxinSdkException;
} 