package com.netease.nim.server.sdk.im.v2.conversation;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.conversation.request.*;
import com.netease.nim.server.sdk.im.v2.conversation.response.*;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversationV2Service implements IConversationV2Service {

    private final YunxinApiHttpClient httpClient;

    public ConversationV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateConversationResponseV2> createConversation(CreateConversationRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ConversationV2UrlContext.CREATE_CONVERSATION,
            ConversationV2UrlContext.CREATE_CONVERSATION,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateConversationResponseV2.class);
    }
    
    @Override
    public Result<UpdateConversationResponseV2> updateConversation(UpdateConversationRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String path = ConversationV2UrlContext.UPDATE_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationV2UrlContext.UPDATE_CONVERSATION,
            path,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateConversationResponseV2.class);
    }
    
    @Override
    public Result<DeleteConversationResponseV2> deleteConversation(DeleteConversationRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String path = ConversationV2UrlContext.DELETE_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Add query parameter if clearMessage is set
        Map<String, String> queryParams = null;
        if (request.getClearMessage() != null) {
            queryParams = new HashMap<>();
            queryParams.put("clear_message", request.getClearMessage().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ConversationV2UrlContext.DELETE_CONVERSATION,
            path,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, DeleteConversationResponseV2.class);
    }

    @Override
    public Result<BatchDeleteConversationsResponseV2> batchDeleteConversations(BatchDeleteConversationsRequestV2 request) throws YunxinSdkException {
        List<String> conversationIds = request.getConversationIds();
        if (conversationIds == null || conversationIds.isEmpty()) {
            throw new IllegalArgumentException("Conversation IDs list cannot be null or empty");
        }

        // Each ID is joined with commas
        String conversationIdsParam = String.join(",", conversationIds);
        
        // Add query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("conversation_ids", conversationIdsParam);
        
        // Add clearMessage parameter if set
        if (request.getClearMessage() != null) {
            queryParams.put("clear_message", request.getClearMessage().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ConversationV2UrlContext.BATCH_DELETE_CONVERSATIONS,
            ConversationV2UrlContext.BATCH_DELETE_CONVERSATIONS,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, BatchDeleteConversationsResponseV2.class);
    }

    @Override
    public Result<GetConversationResponseV2> getConversation(GetConversationRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String path = ConversationV2UrlContext.GET_CONVERSATION.replace("{conversation_id}", conversationId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationV2UrlContext.GET_CONVERSATION,
            path,
            null, // No query parameters
            null  // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, GetConversationResponseV2.class);
    }

    @Override
    public Result<BatchGetConversationsResponseV2> batchGetConversations(BatchGetConversationsRequestV2 request) throws YunxinSdkException {
        List<String> conversationIds = request.getConversationIds();
        if (conversationIds == null || conversationIds.isEmpty()) {
            throw new IllegalArgumentException("Conversation IDs list cannot be null or empty");
        }
        // Each ID is joined with commas
        String conversationIdsParam = String.join(",", conversationIds);
        
        // Add query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("conversation_ids", conversationIdsParam);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationV2UrlContext.BATCH_GET_CONVERSATIONS,
            ConversationV2UrlContext.BATCH_GET_CONVERSATIONS,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, BatchGetConversationsResponseV2.class);
    }

    @Override
    public Result<ListConversationsResponseV2> listConversations(ListConversationsRequestV2 request) throws YunxinSdkException {
        String accountId = request.getAccountId();
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        // Add query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", accountId);
        
        // Add page token if provided
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        // Add limit if provided
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationV2UrlContext.LIST_CONVERSATIONS,
            ConversationV2UrlContext.LIST_CONVERSATIONS,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, ListConversationsResponseV2.class);
    }

    @Override
    public Result<StickTopConversationResponseV2> stickTopConversation(StickTopConversationRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        Integer topType = request.getTopType();
        if (topType == null || (topType != 0 && topType != 1)) {
            throw new IllegalArgumentException("Top type must be 1 (pin) or 0 (unpin)");
        }
        
        // Replace the path parameter in the URL
        String path = ConversationV2UrlContext.STICK_TOP_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Create a request body with only the top_type field
        Map<String, Integer> requestBodyMap = new HashMap<>();
        requestBodyMap.put("top_type", topType);
        String requestBody = JSONObject.toJSONString(requestBodyMap);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationV2UrlContext.STICK_TOP_CONVERSATION,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, StickTopConversationResponseV2.class);
    }
} 