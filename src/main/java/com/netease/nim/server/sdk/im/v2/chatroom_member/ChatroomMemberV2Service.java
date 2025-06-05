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
import java.util.List;
import java.util.Map;

/**
 * Implementation for Chatroom Member V2 operations
 * 
 * This service provides methods for managing chatroom members, including:
 * - Setting member roles (creator, administrator, regular member, guest)
 * - Updating member profile information
 * - Updating online member information
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class ChatroomMemberV2Service implements IChatroomMemberV2Service {

    private final YunxinApiHttpClient httpClient;

    /**
     * Constructor
     * 
     * @param httpClient the HTTP client to use for API calls
     */
    public ChatroomMemberV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Set chatroom member role
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_members/{account_id}
     * 
     * This method sets the role of a chatroom member. It can also update the member's profile
     * information such as nickname, avatar, and custom extension data.
     * 
     * Chatroom member roles can be divided into two main categories:
     * 1. Fixed members: Creator, administrators, and regular members (retained in the chatroom 
     *    even when offline, up to 1000 members in total)
     * 2. Non-fixed members: Regular guests, anonymous guests, and fabricated users (only counted 
     *    when online, removed from the list after leaving)
     * 
     * Role permissions:
     * - Only the creator can set other members as administrators
     * - Creator and administrators can set members as regular members or guests
     * - Setting a member as a guest effectively removes their fixed member status
     * - The creator's role cannot be changed or reassigned
     * 
     * @param accountId the account ID of the member to set role
     * @param request request containing the role to set and optional profile information
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<SetMemberRoleResponseV2> setMemberRole(String accountId, SetMemberRoleRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getMemberRole() == null) {
            throw new IllegalArgumentException("Member role cannot be null");
        }

        // Replace the path parameter in the URL
        String endpoint = ChatroomMemberV2UrlContext.SET_MEMBER_ROLE.replace("{account_id}", accountId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomMemberV2UrlContext.SET_MEMBER_ROLE,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SetMemberRoleResponseV2.class);
    }
    
    /**
     * Update online chatroom member information
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}
     * 
     * This method updates the information of an online chatroom member, including nickname,
     * avatar, and extension field.
     * 
     * Member types:
     * - Fixed members: Can update online information and optionally persist changes.
     *   If a fixed member is offline and persistence is false, the API will return an error.
     * - Guests: Can only update online information. If a guest is offline, the API will return an error.
     * 
     * @param accountId the account ID of the member to update
     * @param request request containing the information to update
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<UpdateOnlineMemberInfoResponseV2> updateOnlineMemberInfo(String accountId, UpdateOnlineMemberInfoRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        

        
        // Replace the path parameter in the URL
        String endpoint = ChatroomMemberV2UrlContext.UPDATE_ONLINE_MEMBER_INFO.replace("{account_id}", accountId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.UPDATE_ONLINE_MEMBER_INFO,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateOnlineMemberInfoResponseV2.class);
    }
    
    /**
     * Ban or unban a chatroom member from chatting
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/chat_banned
     * 
     * This method sets or removes a chatroom member's banned status for chatting.
     * 
     * Permissions:
     * - Only the creator can ban/unban administrators
     * - Creator and administrators can ban/unban regular members
     * - Cannot ban/unban yourself
     * 
     * @param accountId the account ID of the member to ban/unban
     * @param request request containing ban parameters including operator and banned state
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ToggleChatBanResponseV2> toggleChatBan(String accountId, ToggleChatBanRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (accountId == null || accountId.isEmpty()) {
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
        if (accountId.equals(request.getOperatorAccountId())) {
            throw new IllegalArgumentException("Cannot ban/unban yourself");
        }
        

        // Replace the path parameter in the URL
        String endpoint = ChatroomMemberV2UrlContext.TOGGLE_CHAT_BAN.replace("{account_id}", accountId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.TOGGLE_CHAT_BAN,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleChatBanResponseV2.class);
    }
    
    /**
     * Modify online chatroom member tags
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/tags
     * 
     * This method modifies the tags of an online chatroom member. After modification,
     * you can choose whether to notify users with target tags.
     * 
     * For more information about chatroom tags, refer to the chatroom tags documentation.
     * 
     * Permissions:
     * - Only the creator or administrators can modify other online members' tags.
     * 
     * @param accountId the account ID of the member to modify tags
     * @param request request containing the tags to set and notification options
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ModifyMemberTagsResponseV2> modifyMemberTags(String accountId, ModifyMemberTagsRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getTags() == null || request.getTags().isEmpty()) {
            throw new IllegalArgumentException("Tags cannot be null or empty");
        }

        
        // Replace the path parameter in the URL
        String endpoint = ChatroomMemberV2UrlContext.MODIFY_MEMBER_TAGS.replace("{account_id}", accountId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.MODIFY_MEMBER_TAGS,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ModifyMemberTagsResponseV2.class);
    }
    
    /**
     * Query the count of online members with a specific tag in a chatroom
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/tagged_members_count
     * 
     * This method queries the number of online chatroom members that have a specific tag.
     * 
     * @param request request containing the room ID and tag to query
     * @return result containing the tag and count of online users with this tag
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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
        String endpoint = ChatroomMemberV2UrlContext.QUERY_TAGGED_MEMBERS_COUNT.replace("{room_id}", request.getRoomId().toString());
        
        // Add query parameter for tag
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("tag", request.getTag());
        
        // Execute API call (no request body for GET request)
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.QUERY_TAGGED_MEMBERS_COUNT,
            endpoint,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, QueryTaggedMembersCountResponseV2.class);
    }
    
    /**
     * List online members with a specific tag in a chatroom with pagination
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/list_tag_members
     * 
     * This method lists online chatroom members that have a specific tag with pagination support.
     * 
     * @param request request containing the room ID, tag, offset, and limit for pagination
     * @return result containing the list of tagged members and pagination information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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
        String endpoint = ChatroomMemberV2UrlContext.LIST_TAG_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
        // Add query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("tag", request.getTag());
        queryParams.put("offset", request.getOffset().toString());
        queryParams.put("limit", request.getLimit().toString());
        
        // Execute API call (no request body for GET request)
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.LIST_TAG_MEMBERS,
            endpoint,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListTaggedMembersResponseV2.class);
    }

    /**
     * Temporarily ban or unban a chatroom member from chatting
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/temp_chat_banned
     * 
     * This method sets or removes a chatroom member's temporary banned status for chatting.
     * The temporary ban will automatically expire after the specified duration.
     * 
     * Permissions:
     * - Only the creator can temporarily ban/unban administrators
     * - Creator and administrators can temporarily ban/unban regular members
     * - Cannot temporarily ban/unban yourself
     * 
     * @param request request containing temporary ban parameters including member account ID, operator,
     *               banned state, and duration
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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
        String endpoint = ChatroomMemberV2UrlContext.TOGGLE_TEMP_CHAT_BAN.replace("{account_id}", request.getAccountId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.TOGGLE_TEMP_CHAT_BAN,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleTempChatBanResponseV2.class);
    }

    /**
     * Block or unblock a chatroom member
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/blocked
     * 
     * This method blocks or unblocks a chatroom member. Blocked members are removed from the chatroom
     * and cannot rejoin as long as they remain blocked.
     * 
     * Permissions:
     * - Only the creator or administrators can block/unblock chatroom members
     * - Cannot block the creator
     * 
     * @param accountId the account ID of the member to block/unblock
     * @param request request containing block parameters including operator and blocked state
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ToggleBlockedResponseV2> toggleBlocked(String accountId, ToggleBlockedRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getBlocked() == null) {
            throw new IllegalArgumentException("Blocked state cannot be null");
        }
        
        // Check if trying to block/unblock themselves
        if (accountId.equals(request.getOperatorAccountId())) {
            throw new IllegalArgumentException("Cannot block/unblock yourself");
        }

        
        // Replace the path parameter in the URL
        String endpoint = ChatroomMemberV2UrlContext.TOGGLE_BLOCKED.replace("{account_id}", accountId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomMemberV2UrlContext.TOGGLE_BLOCKED,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleBlockedResponseV2.class);
    }

    /**
     * Query the blacklist members of a chatroom with pagination
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/blocked
     * 
     * This method retrieves a list of blocked members in a chatroom with pagination support.
     * Blocked members are users who have been permanently banned from joining the chatroom.
     * 
     * @param request request containing the room ID and pagination parameters
     * @return result containing the list of blocked members and pagination information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<QueryChatroomBlacklistResponseV2> queryChatroomBlacklist(QueryChatroomBlacklistRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomMemberV2UrlContext.QUERY_CHATROOM_BLACKLIST.replace("{room_id}", request.getRoomId().toString());

        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.QUERY_CHATROOM_BLACKLIST,
            endpoint,
            null,
            null // No request body for GET request
        );
        JSONObject json = JSONObject.parseObject(apiResponse.getData());
        List<QueryChatroomBlacklistResponseV2.BlacklistMemberInfoV2> data = json.getList("data", QueryChatroomBlacklistResponseV2.BlacklistMemberInfoV2.class);
        QueryChatroomBlacklistResponseV2 queryChatroomBlacklistResponseV2=new QueryChatroomBlacklistResponseV2();
        queryChatroomBlacklistResponseV2.setItems(data);
        Result<QueryChatroomBlacklistResponseV2> result = new Result<>(apiResponse.getEndpoint(),json.getIntValue("code"),json.getString("msg"),apiResponse.getTraceId(),queryChatroomBlacklistResponseV2);
        return result;
    }

    /**
     * Toggle chat ban on chatroom members with a specific tag
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/actions/chat_banned_tagged_members
     * 
     * This method sets or removes temporary chat ban for all members with a specific tag in a chatroom.
     * 
     * Permissions:
     * - Only the creator can ban/unban administrators
     * - Creator and administrators can ban/unban regular members
     * 
     * @param request request containing parameters including room ID, operator, target tag, ban state, and duration
     * @return result containing the mute duration if successful
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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

    /**
     * Batch query chatroom fixed members information
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/batch
     * 
     * This method retrieves information about multiple chatroom fixed members at once.
     * It returns both successfully and unsuccessfully queried members.
     * 
     * @param request request containing the room ID and list of account IDs to query
     * @return result containing the queried members information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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
        String endpoint = ChatroomMemberV2UrlContext.BATCH_QUERY_CHATROOM_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
        // Set query parameters - joining the account IDs as a comma-separated list
        Map<String, String> queryParams = new HashMap<>();
        String accountIdsParam = String.join(",", request.getAccountIds());
        queryParams.put("account_ids", accountIdsParam);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.BATCH_QUERY_CHATROOM_MEMBERS,
            endpoint,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryChatroomMembersResponseV2.class);
    }

    /**
     * Add virtual members to a chatroom
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_members/actions/virtual_members
     * 
     * This method adds virtual users to a chatroom. Virtual users are typically only used to increase 
     * the number of online users in a chatroom, not for normal communication.
     * 
     * The same virtual user account can join multiple different chatrooms simultaneously (no limit on the number).
     * Virtual users automatically exit the chatroom after 24 hours, and the countdown resets if they are 
     * added again within 24 hours.
     * 
     * @param request request containing the chatroom ID, list of virtual members, and notification options
     * @return result containing the lists of successfully and unsuccessfully added virtual members
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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

    /**
     * Delete virtual members from a chatroom
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/room_members/actions/virtual_members
     * 
     * This method deletes virtual users from a chatroom. A maximum of 100 virtual members
     * can be deleted at once.
     * 
     * @param request request containing the chatroom ID and list of virtual member account IDs to delete
     * @return result containing the lists of successfully and unsuccessfully deleted virtual members
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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

    /**
     * Clear all virtual members from a chatroom
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/room_members/actions/clear_virtual_members
     * 
     * This method removes all virtual users from a chatroom at once.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request request containing the chatroom ID and notification options
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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

    /**
     * Query virtual members in a chatroom
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/actions/virtual_members
     * 
     * This method retrieves information about virtual members in a chatroom.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request request containing the chatroom ID
     * @return result containing the list of virtual members in the chatroom
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
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
        JSONObject json = JSONObject.parseObject(apiResponse.getData());
        List<QueryVirtualMembersResponseV2.VirtualMemberInfoV2> data = json.getList("data", QueryVirtualMembersResponseV2.VirtualMemberInfoV2.class);
        QueryVirtualMembersResponseV2 queryVirtualMembersResponseV2=new QueryVirtualMembersResponseV2();
        queryVirtualMembersResponseV2.setItems(data);
        Result<QueryVirtualMembersResponseV2> result = new Result<>(apiResponse.getEndpoint(),json.getIntValue("code"),json.getString("msg"),apiResponse.getTraceId(),queryVirtualMembersResponseV2);
        return result;
    }

    /**
     * Query chat banned members in a chatroom
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/chat_banned
     * 
     * This method retrieves a list of members who are banned from chatting in a chatroom.
     * Chat banned members can still enter and view the chatroom but cannot send messages.
     * 
     * @param request request containing the chatroom ID
     * @return result containing the list of chat banned members
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<QueryChatBannedResponseV2> queryChatBanned(QueryChatBannedRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomMemberV2UrlContext.QUERY_CHAT_BANNED.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMemberV2UrlContext.QUERY_CHAT_BANNED,
            endpoint,
            null, // No query parameters
            null  // No request body for GET request
        );
        JSONObject json = JSONObject.parseObject(apiResponse.getData());
        List<QueryChatBannedResponseV2.BannedMember> data = json.getList("data", QueryChatBannedResponseV2.BannedMember.class);
        QueryChatBannedResponseV2 queryChatBannedResponseV2=new QueryChatBannedResponseV2();

        queryChatBannedResponseV2.setItems(data);
        Result<QueryChatBannedResponseV2> result = new Result<>(apiResponse.getEndpoint(),json.getIntValue("code"),json.getString("msg"),apiResponse.getTraceId(),queryChatBannedResponseV2);
        return result;
    }
}