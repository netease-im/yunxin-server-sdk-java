package com.netease.nim.server.sdk.im.v1.event_subscribe;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.AddEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.BatchDeleteEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.DeleteEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.QueryEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.AddEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.BatchDeleteEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.DeleteEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.QueryEventSubscribeResponseV1;

import java.util.Map;

/**
 * Service implementation for online status event subscription operations
 */
public class EventSubscribeV1Service implements IEventSubscribeV1Service {

    private final YunxinApiHttpClient httpClient;

    public EventSubscribeV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<AddEventSubscribeResponseV1> addEventSubscribe(AddEventSubscribeRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert publisherAccids list to JSON string
        // API expects a JSONArray string format
        if (request.getPublisherAccids() != null) {
            paramMap.put("publisherAccids", JSON.toJSONString(request.getPublisherAccids()));
        }
        
        // Add timeout parameter to prevent long-running requests
        YunxinApiResponse apiResponse = httpClient.executeV1Api(EventSubscribeV1UrlContext.ADD_EVENT_SUBSCRIBE, paramMap);
        
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        
        AddEventSubscribeResponseV1 response = new AddEventSubscribeResponseV1();
        if (object.containsKey("failedAccid")) {
            response.setFailedAccid(object.getList("failedAccid", String.class));
        }
        
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryEventSubscribeResponseV1> queryEventSubscribe(QueryEventSubscribeRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert publisherAccids list to JSON string
        // API expects a JSONArray string format
        if (request.getPublisherAccids() != null) {
            paramMap.put("publisherAccids", JSON.toJSONString(request.getPublisherAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(EventSubscribeV1UrlContext.QUERY_EVENT_SUBSCRIBE, paramMap);
        
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        
        QueryEventSubscribeResponseV1 response = new QueryEventSubscribeResponseV1();
        if (object.containsKey("subscribes")) {
            response.setSubscribes(JSON.parseArray(object.getString("subscribes"), QueryEventSubscribeResponseV1.Subscription.class));
        }
        
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DeleteEventSubscribeResponseV1> deleteEventSubscribe(DeleteEventSubscribeRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert publisherAccids list to JSON string
        // API expects a JSONArray string format
        if (request.getPublisherAccids() != null) {
            paramMap.put("publisherAccids", JSON.toJSONString(request.getPublisherAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(EventSubscribeV1UrlContext.DELETE_EVENT_SUBSCRIBE, paramMap);
        
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        
        DeleteEventSubscribeResponseV1 response = new DeleteEventSubscribeResponseV1();
        if (object.containsKey("failedAccid")) {
            response.setFailedAccid(object.getList("failedAccid", String.class));
        }
        
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BatchDeleteEventSubscribeResponseV1> batchDeleteEventSubscribe(BatchDeleteEventSubscribeRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(EventSubscribeV1UrlContext.BATCH_DELETE_EVENT_SUBSCRIBE, paramMap);
        
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        
        BatchDeleteEventSubscribeResponseV1 response = new BatchDeleteEventSubscribeResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
} 