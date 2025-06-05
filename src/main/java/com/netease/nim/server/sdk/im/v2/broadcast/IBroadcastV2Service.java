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

/**
 * Interface for broadcast notification services
 */
public interface IBroadcastV2Service {

    /**
     * Send a broadcast notification to all users in the app
     *
     * @param request Request parameters for sending broadcast notification
     * @return Result containing the response of the broadcast notification
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<SendBroadcastNotificationResponseV2> sendBroadcastNotification(
            SendBroadcastNotificationRequestV2 request) throws YunxinSdkException;
            
    /**
     * Delete a broadcast notification
     *
     * @param request Request parameters for deleting broadcast notification
     * @return Result containing the response of the delete operation
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<DeleteBroadcastNotificationResponseV2> deleteBroadcastNotification(
            DeleteBroadcastNotificationRequestV2 request) throws YunxinSdkException;
            
    /**
     * Query a broadcast notification's details
     *
     * @param request Request parameters for querying broadcast notification
     * @return Result containing the details of the broadcast notification
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<QueryBroadcastNotificationResponseV2> queryBroadcastNotification(
            QueryBroadcastNotificationRequestV2 request) throws YunxinSdkException;
            
    /**
     * Query a paginated list of broadcast notifications
     *
     * @param request Request parameters for querying broadcast notification list
     * @return Result containing the paginated list of broadcast notifications
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<QueryBroadcastNotificationListResponseV2> queryBroadcastNotificationList(
            QueryBroadcastNotificationListRequestV2 request) throws YunxinSdkException;
            
    /**
     * Send a broadcast notification to all chatrooms in the app
     *
     * @param request Request parameters for sending chatroom broadcast notification
     * @return Result containing the response of the chatroom broadcast notification
     * @throws YunxinSdkException If there is an error during the API call
     */
    Result<SendChatroomBroadcastNotificationResponseV2> sendChatroomBroadcastNotification(
            SendChatroomBroadcastNotificationRequestV2 request) throws YunxinSdkException;
} 