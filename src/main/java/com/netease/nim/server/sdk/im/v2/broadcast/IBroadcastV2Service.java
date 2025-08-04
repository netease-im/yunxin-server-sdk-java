package com.netease.nim.server.sdk.im.v2.broadcast;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
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


public interface IBroadcastV2Service {


    Result<SendBroadcastNotificationResponseV2> sendBroadcastNotification(
            SendBroadcastNotificationRequestV2 request) throws YunxinSdkException;

    Result<DeleteBroadcastNotificationResponseV2> deleteBroadcastNotification(
            DeleteBroadcastNotificationRequestV2 request) throws YunxinSdkException;
            
    Result<QueryBroadcastNotificationResponseV2> queryBroadcastNotification(
            QueryBroadcastNotificationRequestV2 request) throws YunxinSdkException;
            
    Result<QueryBroadcastNotificationListResponseV2> queryBroadcastNotificationList(
            QueryBroadcastNotificationListRequestV2 request) throws YunxinSdkException;

    Result<SendChatroomBroadcastNotificationResponseV2> sendChatroomBroadcastNotification(
            SendChatroomBroadcastNotificationRequestV2 request) throws YunxinSdkException;
} 