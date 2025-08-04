package com.netease.nim.server.sdk.im.v2.chatroom_message;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.BatchSendChatroomMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.RecallChatroomMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.SendChatroomMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.QueryChatroomHistoryMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.BatchSendChatroomMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.QueryChatroomHistoryMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.RecallChatroomMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.SendChatroomMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;


public class ChatroomMessageV2Service implements IChatroomMessageV2Service {

    private final YunxinApiHttpClient httpClient;

    public ChatroomMessageV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public Result<SendChatroomMessageResponseV2> sendChatroomMessage(SendChatroomMessageRequestV2 request) throws YunxinSdkException {
        // Replace the path parameter in the URL
        String path = ChatroomMessageV2UrlContext.SEND_CHATROOM_MESSAGE.replace("{room_id}", request.getRoomId().toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomMessageV2UrlContext.SEND_CHATROOM_MESSAGE,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendChatroomMessageResponseV2.class);
    }

    @Override
    public Result<BatchSendChatroomMessagesResponseV2> batchSendChatroomMessages(BatchSendChatroomMessagesRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomMessageV2UrlContext.BATCH_SEND_CHATROOM_MESSAGES,
            ChatroomMessageV2UrlContext.BATCH_SEND_CHATROOM_MESSAGES,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchSendChatroomMessagesResponseV2.class);
    }

    @Override
    public Result<RecallChatroomMessageResponseV2> recallChatroomMessage(RecallChatroomMessageRequestV2 request) throws YunxinSdkException {
        // Replace path parameters in the URL
        String path = ChatroomMessageV2UrlContext.RECALL_OR_DELETE_CHATROOM_MESSAGE
                .replace("{room_id}", request.getRoomId().toString())
                .replace("{message_client_id}", request.getMessageClientId());
        
        // Prepare query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("operator_id", request.getOperatorId());
        queryParams.put("sender_id", request.getSenderId());
        queryParams.put("create_time", request.getCreateTime().toString());
        queryParams.put("notification_enabled", request.getNotificationEnabled().toString());
        
        if (Boolean.TRUE.equals(request.getNotificationEnabled()) && 
            request.getNotificationExtension() != null && 
            !request.getNotificationExtension().isEmpty()) {
            queryParams.put("notification_extension", request.getNotificationExtension());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ChatroomMessageV2UrlContext.RECALL_OR_DELETE_CHATROOM_MESSAGE,
            path,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, RecallChatroomMessageResponseV2.class);
    }

    @Override
    public Result<QueryChatroomHistoryMessagesResponseV2> queryChatroomHistoryMessages(
            QueryChatroomHistoryMessagesRequestV2 request) throws YunxinSdkException {
        // Replace path parameter in the URL
        String path = ChatroomMessageV2UrlContext.QUERY_CHATROOM_HISTORY_MESSAGES.replace("{room_id}", request.getRoomId().toString());
        
        // Prepare query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("sender_id", request.getSenderId());
        queryParams.put("limit", request.getLimit().toString());
        
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getDescending() != null) {
            queryParams.put("descending", request.getDescending().toString());
        }
        
        if (request.getMessageTypes() != null && !request.getMessageTypes().isEmpty()) {
            queryParams.put("message_type", request.getMessageTypes());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMessageV2UrlContext.QUERY_CHATROOM_HISTORY_MESSAGES,
            path,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryChatroomHistoryMessagesResponseV2.class);
    }
} 