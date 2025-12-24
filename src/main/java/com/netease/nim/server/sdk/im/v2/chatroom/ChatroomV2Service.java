package com.netease.nim.server.sdk.im.v2.chatroom;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.chatroom.request.CreateChatroomRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.GetChatroomAddressRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.GetChatroomInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ListFixedMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ListOnlineMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.QueryOpenChatroomsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ToggleChatroomMuteRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ToggleInOutNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.UpdateChatroomInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.UpdateChatroomStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.CreateChatroomResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.GetChatroomAddressResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.GetChatroomInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ListFixedMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ListOnlineMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.QueryOpenChatroomsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ToggleChatroomMuteResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ToggleInOutNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.UpdateChatroomInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.UpdateChatroomStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

public class ChatroomV2Service implements IChatroomV2Service {

    private final YunxinApiHttpClient httpClient;

    public ChatroomV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateChatroomResponseV2> createChatroom(CreateChatroomRequestV2 request) throws YunxinSdkException {

        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomV2UrlContext.CREATE_CHATROOM,
            ChatroomV2UrlContext.CREATE_CHATROOM,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateChatroomResponseV2.class);
    }

    @Override
    public Result<GetChatroomAddressResponseV2> getChatroomAddress(GetChatroomAddressRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.GET_CHATROOM_ADDRESS.replace("{room_id}", request.getRoomId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        queryParams.put("client_ip", request.getClientIp());
        
        if (request.getClientType() != null) {
            queryParams.put("client_type", request.getClientType().toString());
        }
        
        if (request.getIpType() != null) {
            queryParams.put("ip_type", request.getIpType().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomV2UrlContext.GET_CHATROOM_ADDRESS,
            path,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, GetChatroomAddressResponseV2.class);
    }

    @Override
    public Result<GetChatroomInfoResponseV2> getChatroomInfo(GetChatroomInfoRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.GET_CHATROOM_INFO.replace("{room_id}", request.getRoomId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        
        if (request.getNeedOnlineUserCount() != null) {
            queryParams.put("need_online_user_count", request.getNeedOnlineUserCount().toString());
        }
        
        if (request.getOnlineUserCountByType() != null) {
            queryParams.put("online_user_count_by_type", request.getOnlineUserCountByType().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomV2UrlContext.GET_CHATROOM_INFO,
            path,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, GetChatroomInfoResponseV2.class);
    }

    @Override
    public Result<UpdateChatroomInfoResponseV2> updateChatroomInfo(UpdateChatroomInfoRequestV2 request) throws YunxinSdkException {
        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.UPDATE_CHATROOM_INFO.replace("{room_id}", request.getRoomId().toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomV2UrlContext.UPDATE_CHATROOM_INFO,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateChatroomInfoResponseV2.class);
    }

    @Override
    public Result<UpdateChatroomStatusResponseV2> updateChatroomStatus(UpdateChatroomStatusRequestV2 request) throws YunxinSdkException {
        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.UPDATE_CHATROOM_STATUS.replace("{room_id}", String.valueOf(request.getRoomId()));
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomV2UrlContext.UPDATE_CHATROOM_STATUS,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateChatroomStatusResponseV2.class);
    }


    @Override
    public Result<ToggleChatroomMuteResponseV2> toggleChatroomMute(ToggleChatroomMuteRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.TOGGLE_CHATROOM_MUTE.replace("{room_id}", String.valueOf(request.getRoomId()));
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomV2UrlContext.TOGGLE_CHATROOM_MUTE,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleChatroomMuteResponseV2.class);
    }

    @Override
    public Result<ToggleInOutNotificationResponseV2> toggleInOutNotification(ToggleInOutNotificationRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.TOGGLE_IN_OUT_NOTIFICATION.replace("{room_id}", request.getRoomId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("in_out_notification", request.getInOutNotification().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomV2UrlContext.TOGGLE_IN_OUT_NOTIFICATION,
            path,
            queryParams,
            null // No request body for this API
        );
        
        return ResultUtils.convert(apiResponse, ToggleInOutNotificationResponseV2.class);
    }

    @Override
    public Result<QueryOpenChatroomsResponseV2> queryOpenChatrooms(QueryOpenChatroomsRequestV2 request) throws YunxinSdkException {

        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("creator_account_id", request.getCreatorAccountId());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomV2UrlContext.QUERY_OPEN_CHATROOMS,
            ChatroomV2UrlContext.QUERY_OPEN_CHATROOMS,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, QueryOpenChatroomsResponseV2.class);
    }

    @Override
    public Result<ListOnlineMembersResponseV2> listOnlineMembers(ListOnlineMembersRequestV2 request) throws YunxinSdkException {
        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.LIST_ONLINE_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("offset", request.getOffset().toString());
        queryParams.put("limit", request.getLimit().toString());
        
        if (request.getMemberRoles() != null && !request.getMemberRoles().isEmpty()) {
            queryParams.put("member_roles", request.getMemberRoles());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomV2UrlContext.LIST_ONLINE_MEMBERS,
            path,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, ListOnlineMembersResponseV2.class);
    }

    @Override
    public Result<ListFixedMembersResponseV2> listFixedMembers(ListFixedMembersRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = ChatroomV2UrlContext.LIST_FIXED_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        
        if (request.getMemberRoles() != null && !request.getMemberRoles().isEmpty()) {
            queryParams.put("member_roles", request.getMemberRoles());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomV2UrlContext.LIST_FIXED_MEMBERS,
            path,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, ListFixedMembersResponseV2.class);
    }
} 