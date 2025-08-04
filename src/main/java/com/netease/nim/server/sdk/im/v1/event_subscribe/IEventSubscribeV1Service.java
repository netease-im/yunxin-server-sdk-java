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

    Result<AddEventSubscribeResponseV1> addEventSubscribe(AddEventSubscribeRequestV1 request) throws YunxinSdkException;

    Result<QueryEventSubscribeResponseV1> queryEventSubscribe(QueryEventSubscribeRequestV1 request) throws YunxinSdkException;

    Result<DeleteEventSubscribeResponseV1> deleteEventSubscribe(DeleteEventSubscribeRequestV1 request) throws YunxinSdkException;

    Result<BatchDeleteEventSubscribeResponseV1> batchDeleteEventSubscribe(BatchDeleteEventSubscribeRequestV1 request) throws YunxinSdkException;
} 