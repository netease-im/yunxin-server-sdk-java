package com.netease.nim.server.sdk.im.v2.friend;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.friend.request.AddFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.DeleteFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.GetFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.HandleFriendAdditionRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.ListFriendsRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.UpdateFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.response.AddFriendResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.DeleteFriendResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.GetFriendResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.HandleFriendAdditionResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.ListFriendsResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.UpdateFriendResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Friend V2 operations
 */
public class FriendV2Service implements IFriendV2Service {

    private final YunxinApiHttpClient httpClient;

    public FriendV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<AddFriendResponseV2> addFriend(AddFriendRequestV2 request) throws YunxinSdkException {
        JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(request));
        
        // Add type as a query parameter if specified
        Map<String, String> queryParams = null;
        Integer type = request.getType();
        if (type != null) {
            queryParams = new HashMap<>();
            queryParams.put("type", type.toString());
            
            // Remove type from request body
            data.remove("type");
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST, 
            FriendV2UrlContext.FRIENDS,
            FriendV2UrlContext.FRIENDS,
            queryParams, 
            data.toString()
        );
        
        return ResultUtils.convert(apiResponse, AddFriendResponseV2.class);
    }
    
    @Override
    public Result<DeleteFriendResponseV2> deleteFriend(DeleteFriendRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = FriendV2UrlContext.DELETE_FRIEND.replace("{account_id}", request.getAccountId());
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("friend_account_id", request.getFriendAccountId());
        
        if (request.getDeleteAlias() != null) {
            queryParams.put("delete_alias", request.getDeleteAlias().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            FriendV2UrlContext.DELETE_FRIEND,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, DeleteFriendResponseV2.class);
    }
    
    @Override
    public Result<UpdateFriendResponseV2> updateFriend(UpdateFriendRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = FriendV2UrlContext.UPDATE_FRIEND.replace("{account_id}", request.getAccountId());
        
        // Make a copy of the request to avoid modifying the original
        JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(request));
        
        // Remove accountId from the request body as it's already in the URL
        data.remove("account_id");
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            FriendV2UrlContext.UPDATE_FRIEND,
            path,
            null,
            data.toString()
        );
        
        return ResultUtils.convert(apiResponse, UpdateFriendResponseV2.class);
    }
    
    @Override
    public Result<HandleFriendAdditionResponseV2> handleFriendAddition(HandleFriendAdditionRequestV2 request) throws YunxinSdkException {
        // Make a copy of the request to avoid modifying the original
        JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(request));
        
        // Build query parameters
        Map<String, String> queryParams = null;
        Integer type = request.getType();
        if (type != null) {
            queryParams = new HashMap<>();
            queryParams.put("type", type.toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            FriendV2UrlContext.HANDLE_FRIEND_ADDITION,
            FriendV2UrlContext.HANDLE_FRIEND_ADDITION,
            queryParams,
            data.toString()
        );
        
        return ResultUtils.convert(apiResponse, HandleFriendAdditionResponseV2.class);
    }
    
    @Override
    public Result<GetFriendResponseV2> getFriend(GetFriendRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = FriendV2UrlContext.GET_FRIEND.replace("{account_id}", request.getAccountId());
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("friend_account_id", request.getFriendAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            FriendV2UrlContext.GET_FRIEND,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, GetFriendResponseV2.class);
    }
    
    @Override
    public Result<ListFriendsResponseV2> listFriends(ListFriendsRequestV2 request) throws YunxinSdkException {
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        
        if (request.getPageToken() != null) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            FriendV2UrlContext.LIST_FRIENDS,
            FriendV2UrlContext.LIST_FRIENDS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListFriendsResponseV2.class);
    }
} 