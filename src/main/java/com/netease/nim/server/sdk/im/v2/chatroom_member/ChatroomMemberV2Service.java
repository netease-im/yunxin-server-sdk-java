package com.netease.nim.server.sdk.im.v2.chatroom_member;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.AddVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.BatchQueryChatroomMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ClearVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.DeleteVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.KickChatRoomMemberRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ListTaggedMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ModifyMemberTagsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryChatBannedRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryChatroomBlacklistRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryTaggedMembersCountRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.SetMemberRoleRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleBlockedRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleTaggedMembersChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleTempChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.UpdateOnlineMemberInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.AddVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.BatchQueryChatroomMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ClearVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.DeleteVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.KickChatRoomMemberResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ListTaggedMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ModifyMemberTagsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryChatBannedResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryChatroomBlacklistResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryTaggedMembersCountResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.SetMemberRoleResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleBlockedResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleTaggedMembersChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleTempChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.UpdateOnlineMemberInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

public class ChatroomMemberV2Service implements IChatroomMemberV2Service {

    private final YunxinApiHttpClient httpClient;

    public ChatroomMemberV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<SetMemberRoleResponseV2> setMemberRole(SetMemberRoleRequestV2 request) throws YunxinSdkException {
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getMemberRole() == null) {
            throw new IllegalArgumentException("Member role cannot be null");
        }

        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.SET_MEMBER_ROLE.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomMemberV2UrlContext.SET_MEMBER_ROLE,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SetMemberRoleResponseV2.class);
    }

    @Override
    public Result<UpdateOnlineMemberInfoResponseV2> updateOnlineMemberInfo(UpdateOnlineMemberInfoRequestV2 request) throws YunxinSdkException {
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.UPDATE_ONLINE_MEMBER_INFO.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.UPDATE_ONLINE_MEMBER_INFO,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateOnlineMemberInfoResponseV2.class);
    }

    @Override
    public Result<ToggleChatBanResponseV2> toggleChatBan(ToggleChatBanRequestV2 request) throws YunxinSdkException {
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getChatBanned() == null) {
            throw new IllegalArgumentException("Chat banned state cannot be null");
        }

        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.TOGGLE_CHAT_BAN.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.TOGGLE_CHAT_BAN,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleChatBanResponseV2.class);
    }

    @Override
    public Result<ModifyMemberTagsResponseV2> modifyMemberTags(ModifyMemberTagsRequestV2 request) throws YunxinSdkException {
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getTags() == null || request.getTags().isEmpty()) {
            throw new IllegalArgumentException("Tags cannot be null or empty");
        }

        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.MODIFY_MEMBER_TAGS.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.MODIFY_MEMBER_TAGS,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ModifyMemberTagsResponseV2.class);
    }
    
    @Override
    public Result<QueryTaggedMembersCountResponseV2> queryTaggedMembersCount(QueryTaggedMembersCountRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getTag() == null || request.getTag().isEmpty()) {
            throw new IllegalArgumentException("Tag cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.QUERY_TAGGED_MEMBERS_COUNT.replace("{room_id}", request.getRoomId().toString());
        
        // Add query parameter for tag
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("tag", request.getTag());
        
        // Execute API call (no request body for GET request)
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.QUERY_TAGGED_MEMBERS_COUNT,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, QueryTaggedMembersCountResponseV2.class);
    }

    @Override
    public Result<ListTaggedMembersResponseV2> listTaggedMembers(ListTaggedMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getTag() == null || request.getTag().isEmpty()) {
            throw new IllegalArgumentException("Tag cannot be null or empty");
        }
        
        if (request.getOffset() == null) {
            throw new IllegalArgumentException("Offset cannot be null");
        }
        
        if (request.getLimit() == null) {
            throw new IllegalArgumentException("Limit cannot be null");
        }

        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.LIST_TAG_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
        // Add query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("tag", request.getTag());
        queryParams.put("offset", request.getOffset().toString());
        queryParams.put("limit", request.getLimit().toString());
        
        // Execute API call (no request body for GET request)
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.LIST_TAG_MEMBERS,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListTaggedMembersResponseV2.class);
    }

    @Override
    public Result<ToggleTempChatBanResponseV2> toggleTempChatBan(ToggleTempChatBanRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getChatBanned() == null) {
            throw new IllegalArgumentException("Chat banned state cannot be null");
        }
        
        // Check if trying to ban/unban themselves
        if (request.getAccountId().equals(request.getOperatorAccountId())) {
            throw new IllegalArgumentException("Cannot temporarily ban/unban yourself");
        }
        
        // If banning, chat ban duration is required and must be within limits
        if (Boolean.TRUE.equals(request.getChatBanned())) {
            if (request.getChatBannedDuration() == null) {
                throw new IllegalArgumentException("Chat banned duration is required when banning a member");
            }
        }

        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.TOGGLE_TEMP_CHAT_BAN.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.TOGGLE_TEMP_CHAT_BAN,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleTempChatBanResponseV2.class);
    }

    @Override
    public Result<ToggleBlockedResponseV2> toggleBlocked(ToggleBlockedRequestV2 request) throws YunxinSdkException {

        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getBlocked() == null) {
            throw new IllegalArgumentException("Blocked state cannot be null");
        }
        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.TOGGLE_BLOCKED.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.TOGGLE_BLOCKED,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleBlockedResponseV2.class);
    }

    @Override
    public Result<QueryChatroomBlacklistResponseV2> queryChatroomBlacklist(QueryChatroomBlacklistRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.QUERY_CHATROOM_BLACKLIST.replace("{room_id}", request.getRoomId().toString());

        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.QUERY_CHATROOM_BLACKLIST,
            path,
            null,
            null // No request body for GET request
        );
        return ResultUtils.convert(apiResponse, QueryChatroomBlacklistResponseV2.class);
    }

    @Override
    public Result<ToggleTaggedMembersChatBanResponseV2> toggleTaggedMembersChatBan(ToggleTaggedMembersChatBanRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getTargetTag() == null || request.getTargetTag().isEmpty()) {
            throw new IllegalArgumentException("Target tag cannot be null or empty");
        }
        
        if (request.getChatBanned() == null) {
            throw new IllegalArgumentException("Chat banned state cannot be null");
        }
        
        // If banning, chat ban duration is required and must be within limits
        if (Boolean.TRUE.equals(request.getChatBanned())) {
            if (request.getChatBannedDuration() == null) {
                throw new IllegalArgumentException("Chat banned duration is required when banning members");
            }
        }

        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.TOGGLE_TAGGED_MEMBERS_CHAT_BAN,
            ChatroomMemberV2UrlContext.TOGGLE_TAGGED_MEMBERS_CHAT_BAN,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleTaggedMembersChatBanResponseV2.class);
    }

    @Override
    public Result<BatchQueryChatroomMembersResponseV2> batchQueryChatroomMembers(BatchQueryChatroomMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getAccountIds() == null || request.getAccountIds().isEmpty()) {
            throw new IllegalArgumentException("Account IDs list cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.BATCH_QUERY_CHATROOM_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
        // Set query parameters - joining the account IDs as a comma-separated list
        Map<String, String> queryParams = new HashMap<>();
        String accountIdsParam = String.join(",", request.getAccountIds());
        queryParams.put("account_ids", accountIdsParam);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.BATCH_QUERY_CHATROOM_MEMBERS,
            path,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryChatroomMembersResponseV2.class);
    }


    @Override
    public Result<AddVirtualMembersResponseV2> addVirtualMembers(AddVirtualMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getVirtualMembers() == null || request.getVirtualMembers().isEmpty()) {
            throw new IllegalArgumentException("Virtual members list cannot be null or empty");
        }
        
        // Validate each virtual member has a valid account ID
        for (AddVirtualMembersRequestV2.VirtualMemberInfoV2 member : request.getVirtualMembers()) {
            if (member.getAccountId() == null || member.getAccountId().isEmpty()) {
                throw new IllegalArgumentException("Account ID of virtual member cannot be null or empty");
            }
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomMemberV2UrlContext.ADD_VIRTUAL_MEMBERS,
            ChatroomMemberV2UrlContext.ADD_VIRTUAL_MEMBERS,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, AddVirtualMembersResponseV2.class);
    }

    @Override
    public Result<DeleteVirtualMembersResponseV2> deleteVirtualMembers(DeleteVirtualMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getAccountIds() == null || request.getAccountIds().isEmpty()) {
            throw new IllegalArgumentException("Account IDs list cannot be null or empty");
        }

        
        // Validate each account ID
        for (String accountId : request.getAccountIds()) {
            if (accountId == null || accountId.isEmpty()) {
                throw new IllegalArgumentException("Account ID cannot be null or empty");
            }
        }
        
        // Set query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("room_id", request.getRoomId().toString());
        queryParams.put("account_ids", String.join(",", request.getAccountIds()));
        if (request.getNotificationEnabled() != null) {
            queryParams.put("notification_enabled", request.getNotificationEnabled().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ChatroomMemberV2UrlContext.DELETE_VIRTUAL_MEMBERS,
            ChatroomMemberV2UrlContext.DELETE_VIRTUAL_MEMBERS,
            queryParams,
            null // No request body for DELETE request
        );
        
        return ResultUtils.convert(apiResponse, DeleteVirtualMembersResponseV2.class);
    }

    @Override
    public Result<ClearVirtualMembersResponseV2> clearVirtualMembers(ClearVirtualMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Set query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("room_id", request.getRoomId().toString());
        if (request.getNotificationEnabled() != null) {
            queryParams.put("notification_enabled", request.getNotificationEnabled().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ChatroomMemberV2UrlContext.CLEAR_VIRTUAL_MEMBERS,
            ChatroomMemberV2UrlContext.CLEAR_VIRTUAL_MEMBERS,
            queryParams,
            null // No request body for DELETE request
        );
        
        return ResultUtils.convert(apiResponse, ClearVirtualMembersResponseV2.class);
    }

    @Override
    public Result<QueryVirtualMembersResponseV2> queryVirtualMembers(QueryVirtualMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Set query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("room_id", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.QUERY_VIRTUAL_MEMBERS,
            ChatroomMemberV2UrlContext.QUERY_VIRTUAL_MEMBERS,
            queryParams,
            null // No request body for GET request
        );
        return ResultUtils.convert(apiResponse, QueryVirtualMembersResponseV2.class);
    }

    @Override
    public Result<QueryChatBannedResponseV2> queryChatBanned(QueryChatBannedRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.QUERY_CHAT_BANNED.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.QUERY_CHAT_BANNED,
            path,
            null, // No query parameters
            null  // No request body for GET request
        );
        return ResultUtils.convert(apiResponse, QueryChatBannedResponseV2.class);
    }

    @Override
    public Result<KickChatRoomMemberResponseV2> kickMember(KickChatRoomMemberRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Room ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String path = ChatroomMemberV2UrlContext.KICK_MEMBER.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.KICK_MEMBER,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, KickChatRoomMemberResponseV2.class);
    }
}