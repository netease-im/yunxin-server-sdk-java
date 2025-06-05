package com.netease.nim.server.sdk.im.v2.conversation_group;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.*;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.*;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service implementation for Conversation Group V2 operations
 */
public class ConversationGroupV2Service implements IConversationGroupV2Service {

    private final YunxinApiHttpClient httpClient;

    public ConversationGroupV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateConversationGroupResponseV2> createConversationGroup(CreateConversationGroupRequestV2 request) throws YunxinSdkException {
        // Convert request to JSON string
        String requestBody = JSON.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST, 
            ConversationGroupUrlContextV2.CREATE_CONVERSATION_GROUP, 
            ConversationGroupUrlContextV2.CREATE_CONVERSATION_GROUP, 
            null, 
            requestBody
        );
        return ResultUtils.convert(apiResponse, CreateConversationGroupResponseV2.class);
    }

    @Override
    public Result<UpdateConversationGroupResponseV2> updateConversationGroup(UpdateConversationGroupRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the groupId
        String path = ConversationGroupUrlContextV2.UPDATE_CONVERSATION_GROUP.replace("{group_id}", String.valueOf(request.getGroupId()));
        
        // Convert request to JSON string
        String requestBody = JSON.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH, 
            ConversationGroupUrlContextV2.UPDATE_CONVERSATION_GROUP, 
            path, 
            null, 
            requestBody
        );
        return ResultUtils.convert(apiResponse, UpdateConversationGroupResponseV2.class);
    }

    @Override
    public Result<DeleteConversationGroupResponseV2> deleteConversationGroup(DeleteConversationGroupRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the groupId
        String path = ConversationGroupUrlContextV2.DELETE_CONVERSATION_GROUP.replace("{group_id}", String.valueOf(request.getGroupId()));
        
        // For DELETE request, put the account_id in the query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE, 
            ConversationGroupUrlContextV2.DELETE_CONVERSATION_GROUP, 
            path, 
            queryParams, 
            null
        );
        return ResultUtils.convert(apiResponse, DeleteConversationGroupResponseV2.class);
    }

    @Override
    public Result<GetConversationGroupResponseV2> getConversationGroup(GetConversationGroupRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the groupId
        String path = ConversationGroupUrlContextV2.GET_CONVERSATION_GROUP.replace("{group_id}", String.valueOf(request.getGroupId()));
        
        // For GET request, put the account_id in the query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET, 
            ConversationGroupUrlContextV2.GET_CONVERSATION_GROUP, 
            path, 
            queryParams, 
            null
        );
        return ResultUtils.convert(apiResponse, GetConversationGroupResponseV2.class);
    }

    @Override
    public Result<BatchGetConversationGroupsResponseV2> batchGetConversationGroups(BatchGetConversationGroupsRequestV2 request) throws YunxinSdkException {
        // For GET request with multiple parameters, create query params from the request
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        System.out.println(request.getGroupIds().toString());
        List<Long> groupIds = request.getGroupIds();
        String collect = groupIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        queryParams.put("group_ids", String.join(",",collect));
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET, 
            ConversationGroupUrlContextV2.BATCH_GET_CONVERSATION_GROUPS, 
            ConversationGroupUrlContextV2.BATCH_GET_CONVERSATION_GROUPS, 
            queryParams, 
            null
        );
        return ResultUtils.convert(apiResponse, BatchGetConversationGroupsResponseV2.class);
    }

    @Override
    public Result<ListAllConversationGroupsResponseV2> listAllConversationGroups(ListAllConversationGroupsRequestV2 request) throws YunxinSdkException {
        // For GET request, put the account_id in the query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET, 
            ConversationGroupUrlContextV2.LIST_ALL_CONVERSATION_GROUPS, 
            ConversationGroupUrlContextV2.LIST_ALL_CONVERSATION_GROUPS, 
            queryParams, 
            null
        );
        return ResultUtils.convert(apiResponse, ListAllConversationGroupsResponseV2.class);
    }
} 