package com.netease.nim.server.sdk.im.v2.users;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.users.request.BatchGetUsersRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.GetUserOnlineStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.GetUserRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.UpdateUserRequestV2;
import com.netease.nim.server.sdk.im.v2.users.response.BatchGetUsersResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.GetUserOnlineStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.GetUserResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.UpdateUserResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation for User V2 operations
 */
public class UserV2Service implements IUserV2Service {

    private final YunxinApiHttpClient httpClient;

    public UserV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<UpdateUserResponseV2> updateUser(UpdateUserRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = UserV2UrlContext.UPDATE_USER.replace("{account_id}", request.getAccountId());
        
        // Make a copy of the request to avoid modifying the original
        JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(request));
        
        // Remove accountId from the request body as it's already in the URL
        data.remove("accountId");
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            UserV2UrlContext.UPDATE_USER,
            path,
            null,
            data.toString()
        );
        
        return ResultUtils.convert(apiResponse, UpdateUserResponseV2.class);
    }
    
    @Override
    public Result<GetUserResponseV2> getUser(GetUserRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = UserV2UrlContext.GET_USER.replace("{account_id}", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            UserV2UrlContext.GET_USER,
            path,
            null,
            null
        );
        
        return ResultUtils.convert(apiResponse, GetUserResponseV2.class);
    }
    
    @Override
    public Result<BatchGetUsersResponseV2> batchGetUsers(BatchGetUsersRequestV2 request) throws YunxinSdkException {
        // Convert the list of account IDs to a comma-separated string
        String accountIdsString = String.join(",", request.getAccountIds());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_ids", accountIdsString);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            UserV2UrlContext.BATCH_GET_USERS,
            UserV2UrlContext.BATCH_GET_USERS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, BatchGetUsersResponseV2.class);
    }
    
    @Override
    public Result<GetUserOnlineStatusResponseV2> getUsersOnlineStatus(GetUserOnlineStatusRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            UserV2UrlContext.GET_USERS_ONLINE_STATUS,
            UserV2UrlContext.GET_USERS_ONLINE_STATUS,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, GetUserOnlineStatusResponseV2.class);
    }
} 