package com.netease.nim.server.sdk.im.v1.event_subscribe;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.AddEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.BatchDeleteEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.DeleteEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.QueryEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.AddEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.BatchDeleteEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.DeleteEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.QueryEventSubscribeResponseV1;

/**
 * Service interface for online status event subscription operations
 */
public interface IEventSubscribeV1Service {

    /**
     * Add online status event subscription
     *
     * @param request The subscription request
     * @return Result containing subscription response
     * @throws YunxinSdkException if an error occurs during the API call
     */
    Result<AddEventSubscribeResponseV1> addEventSubscribe(AddEventSubscribeRequestV1 request) throws YunxinSdkException;

    /**
     * Query online status event subscription
     *
     * @param request The query request
     * @return Result containing subscription information
     * @throws YunxinSdkException if an error occurs during the API call
     */
    Result<QueryEventSubscribeResponseV1> queryEventSubscribe(QueryEventSubscribeRequestV1 request) throws YunxinSdkException;

    /**
     * Delete specific online status event subscriptions
     *
     * @param request The deletion request
     * @return Result containing deletion response
     * @throws YunxinSdkException if an error occurs during the API call
     */
    Result<DeleteEventSubscribeResponseV1> deleteEventSubscribe(DeleteEventSubscribeRequestV1 request) throws YunxinSdkException;

    /**
     * Delete all online status event subscriptions for a user
     *
     * @param request The batch deletion request
     * @return Result containing batch deletion response
     * @throws YunxinSdkException if an error occurs during the API call
     */
    Result<BatchDeleteEventSubscribeResponseV1> batchDeleteEventSubscribe(BatchDeleteEventSubscribeRequestV1 request) throws YunxinSdkException;
} 