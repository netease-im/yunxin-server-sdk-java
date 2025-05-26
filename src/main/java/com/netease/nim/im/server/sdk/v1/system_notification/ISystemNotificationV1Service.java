package com.netease.nim.im.server.sdk.v1.system_notification;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.system_notification.request.SendAttachMsgRequestV1;
import com.netease.nim.im.server.sdk.v1.system_notification.request.SendBatchAttachMsgRequestV1;
import com.netease.nim.im.server.sdk.v1.system_notification.response.SendAttachMsgResponseV1;
import com.netease.nim.im.server.sdk.v1.system_notification.response.SendBatchAttachMsgResponseV1;

/**
 * 系统通知相关接口
 */
public interface ISystemNotificationV1Service {

    /**
     * 发送自定义系统通知
     * /msg/sendAttachMsg.action
     *
     * @param request 请求参数
     * @return 结果
     * @throws YunxinSdkException 网络异常时抛出
     */
    Result<SendAttachMsgResponseV1> sendAttachMsg(SendAttachMsgRequestV1 request) throws YunxinSdkException;
    
    /**
     * 批量发送自定义系统通知
     * /msg/sendBatchAttachMsg.action
     *
     * @param request 请求参数
     * @return 结果
     * @throws YunxinSdkException 网络异常时抛出
     */
    Result<SendBatchAttachMsgResponseV1> sendBatchAttachMsg(SendBatchAttachMsgRequestV1 request) throws YunxinSdkException;
} 