package com.netease.nim.im.server.sdk.v2.chatroom;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.chatroom.request.CreateChatroomRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.request.GetChatroomAddressRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.request.GetChatroomInfoRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.request.ListFixedMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.request.ListOnlineMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.request.ToggleChatroomMuteRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.request.UpdateChatroomInfoRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.request.UpdateChatroomStatusRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.CreateChatroomResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.GetChatroomAddressResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.GetChatroomInfoResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.ListFixedMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.ListOnlineMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.QueryOpenChatroomsResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.ToggleChatroomMuteResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom.response.ToggleInOutNotificationResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Chatroom V2 operations
 * 
 * This service provides methods for managing chatrooms, including:
 * - Creating chatrooms
 * - Getting chatroom information
 * - Updating chatroom settings
 * - Toggling entry/exit event notifications
 * - Closing chatrooms
 * - Managing chatroom mute status
 * - Getting chatroom addresses
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class ChatroomV2Service implements IChatroomV2Service {

    private final YunxinApiHttpClient httpClient;

    public ChatroomV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Create a chatroom
     * 
     * API: POST https://open.yunxinapi.com/im/v2/chatrooms
     * 
     * This method creates a new chatroom. Chatrooms have no limit on the number of participants
     * and by default allow free entry and exit (blacklisted users can be prevented from entering).
     * By default, entry and exit events trigger notifications.
     * 
     * Note:
     * - Chatroom names and announcements are subject to anti-spam checks.
     * - The auto-close feature must be enabled in the Yunxin console before using it.
     * 
     * @param request request containing the chatroom creator, name, and configuration
     * @return result containing the created chatroom details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<CreateChatroomResponseV2> createChatroom(CreateChatroomRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getCreator() == null || request.getCreator().isEmpty()) {
            throw new IllegalArgumentException("Creator cannot be null or empty");
        }
        
        if (request.getRoomName() == null || request.getRoomName().isEmpty()) {
            throw new IllegalArgumentException("Room name cannot be null or empty");
        }
        
        // Validate room name length
        if (request.getRoomName().length() > 128) {
            throw new IllegalArgumentException("Room name cannot exceed 128 characters");
        }
        
        // Validate announcement length if provided
        if (request.getAnnouncement() != null && request.getAnnouncement().length() > 4096) {
            throw new IllegalArgumentException("Announcement cannot exceed 4096 characters");
        }
        
        // Validate live URL length if provided
        if (request.getLiveUrl() != null && request.getLiveUrl().length() > 1024) {
            throw new IllegalArgumentException("Live URL cannot exceed 1024 characters");
        }
        
        // Validate extension length if provided
        if (request.getExtension() != null && request.getExtension().length() > 4096) {
            throw new IllegalArgumentException("Extension cannot exceed 4096 characters");
        }
        
        // Validate delay close policy if provided
        if (request.getDelayClosePolicy() != null && 
                (request.getDelayClosePolicy() < 0 || request.getDelayClosePolicy() > 2)) {
            throw new IllegalArgumentException("Delay close policy must be 0, 1, or 2");
        }
        
        // Validate delay seconds if provided
        if (request.getDelaySeconds() != null && request.getDelaySeconds() > 7 * 24 * 3600) {
            throw new IllegalArgumentException("Delay seconds cannot exceed 7 days (604800 seconds)");
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomUrlContextV2.CREATE_CHATROOM,
            ChatroomUrlContextV2.CREATE_CHATROOM,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateChatroomResponseV2.class);
    }
    
    /**
     * Get chatroom address
     * 
     * API: GET https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/address
     * 
     * This method retrieves the address to enter a chatroom. After creating a chatroom,
     * users can enter it using the address obtained from this API. While the client SDK
     * can also get the chatroom address, using the server API is recommended.
     * 
     * The server will return the most suitable address based on the client's geographic
     * location determined by the client's IP address.
     * 
     * @param request request containing the chatroom ID, user account ID, and client information
     * @return result containing the list of chatroom addresses
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<GetChatroomAddressResponseV2> getChatroomAddress(GetChatroomAddressRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getClientIp() == null || request.getClientIp().isEmpty()) {
            throw new IllegalArgumentException("Client IP cannot be null or empty");
        }
        
        // Validate optional parameters
        if (request.getClientType() != null && (request.getClientType() < 1 || request.getClientType() > 3)) {
            throw new IllegalArgumentException("Client type must be 1, 2, or 3");
        }
        
        if (request.getIpType() != null && (request.getIpType() < 0 || request.getIpType() > 2)) {
            throw new IllegalArgumentException("IP type must be 0, 1, or 2");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.GET_CHATROOM_ADDRESS.replace("{room_id}", request.getRoomId().toString());
        
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
            ChatroomUrlContextV2.GET_CHATROOM_ADDRESS,
            endpoint,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, GetChatroomAddressResponseV2.class);
    }

    /**
     * Get chatroom information
     * 
     * API: GET https://open.yunxinapi.com/im/v2/chatrooms/{room_id}
     * 
     * This method retrieves information about a chatroom, including its name, announcement,
     * live URL, and other settings. It can also optionally return the number of online users,
     * including a breakdown by client type.
     * 
     * @param request request containing the chatroom ID and optional query parameters
     * @return result containing the chatroom information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<GetChatroomInfoResponseV2> getChatroomInfo(GetChatroomInfoRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.GET_CHATROOM_INFO.replace("{room_id}", request.getRoomId().toString());
        
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
            ChatroomUrlContextV2.GET_CHATROOM_INFO,
            endpoint,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, GetChatroomInfoResponseV2.class);
    }

    /**
     * Update chatroom information
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/chatrooms/{room_id}
     * 
     * This method updates information about a chatroom, including its name, announcement,
     * live URL, and other settings. All parameters are optional, and only the fields that are
     * provided will be updated.
     * 
     * Note:
     * - Chatroom names, announcements, and extensions are subject to anti-spam checks.
     * - You can optionally send a notification about the update to chatroom members.
     * 
     * @param roomId the ID of the chatroom to update
     * @param request request containing the fields to update
     * @return result containing the updated chatroom information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if roomId is null or invalid, or if any fields exceed their length limits
     */
    @Override
    public Result<GetChatroomInfoResponseV2> updateChatroomInfo(Long roomId, UpdateChatroomInfoRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (roomId == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Validate field lengths if provided
        if (request.getRoomName() != null && request.getRoomName().length() > 128) {
            throw new IllegalArgumentException("Room name cannot exceed 128 characters");
        }
        
        if (request.getAnnouncement() != null && request.getAnnouncement().length() > 4096) {
            throw new IllegalArgumentException("Announcement cannot exceed 4096 characters");
        }
        
        if (request.getLiveUrl() != null && request.getLiveUrl().length() > 1024) {
            throw new IllegalArgumentException("Live URL cannot exceed 1024 characters");
        }
        
        if (request.getExtension() != null && request.getExtension().length() > 4096) {
            throw new IllegalArgumentException("Extension cannot exceed 4096 characters");
        }
        
        if (request.getNotificationExtension() != null && request.getNotificationExtension().length() > 2048) {
            throw new IllegalArgumentException("Notification extension cannot exceed 2048 characters");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.UPDATE_CHATROOM_INFO.replace("{room_id}", roomId.toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomUrlContextV2.UPDATE_CHATROOM_INFO,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, GetChatroomInfoResponseV2.class);
    }

    /**
     * Update chatroom status (open/close)
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/update_status
     * 
     * This method can open or close a chatroom. When a chatroom is created, it is open by default.
     * If the chatroom is closed, all online members are kicked out. The chatroom creator can
     * reopen the chatroom using this method.
     * 
     * This method can also set up auto-close policies for the chatroom.
     * 
     * Note:
     * - Only the chatroom creator can open or close the chatroom.
     * - To use the auto-close feature, it must be enabled in the Yunxin console first.
     * 
     * @param roomId the ID of the chatroom to update
     * @param request request containing the parameters for updating chatroom status
     * @return result containing the updated chatroom information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if roomId is null or invalid, or if required parameters are missing
     */
    @Override
    public Result<GetChatroomInfoResponseV2> updateChatroomStatus(Long roomId, UpdateChatroomStatusRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (roomId == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getValid() == null) {
            throw new IllegalArgumentException("Valid status cannot be null");
        }
        
        // Validate optional parameters if provided
        if (request.getDelayClosePolicy() != null && 
                (request.getDelayClosePolicy() < 0 || request.getDelayClosePolicy() > 2)) {
            throw new IllegalArgumentException("Delay close policy must be 0, 1, or 2");
        }
        
        if (request.getDelaySeconds() != null && request.getDelaySeconds() > 7 * 24 * 3600) {
            throw new IllegalArgumentException("Delay seconds cannot exceed 7 days (604800 seconds)");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.UPDATE_CHATROOM_STATUS.replace("{room_id}", roomId.toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomUrlContextV2.UPDATE_CHATROOM_STATUS,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, GetChatroomInfoResponseV2.class);
    }

    /**
     * Toggle chatroom mute status (global mute)
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/chat_banned
     * 
     * This method toggles a chatroom's global mute status. When a chatroom is muted globally,
     * only the creator and administrators can send messages. This is different from individual
     * user muting, which restricts specific users from sending messages.
     * 
     * Note:
     * - Only the chatroom creator or administrators can toggle global mute status.
     * - You can optionally send a notification to chatroom members about the mute status change.
     * 
     * @param roomId the ID of the chatroom to toggle mute status
     * @param request request containing the parameters for toggling mute status
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if roomId is null or invalid, or if required parameters are missing
     */
    @Override
    public Result<ToggleChatroomMuteResponseV2> toggleChatroomMute(Long roomId, ToggleChatroomMuteRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (roomId == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getChatBanned() == null) {
            throw new IllegalArgumentException("Chat banned status cannot be null");
        }
        
        // Validate notification extension length if provided
        if (request.getNotificationExtension() != null && request.getNotificationExtension().length() > 2048) {
            throw new IllegalArgumentException("Notification extension cannot exceed 2048 characters");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.TOGGLE_CHATROOM_MUTE.replace("{room_id}", roomId.toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomUrlContextV2.TOGGLE_CHATROOM_MUTE,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ToggleChatroomMuteResponseV2.class);
    }
    
    /**
     * Toggle in/out notification for a chatroom
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/in_out_notification
     * 
     * This method enables or disables entry/exit event notifications in a chatroom.
     * When a chatroom is created, the entry/exit notifications are enabled by default.
     * This API allows changing this setting after the chatroom is created.
     * 
     * Entry/exit events include:
     * - User actively leaving the chatroom
     * - User disconnecting from the chatroom
     * - User entering the chatroom
     * 
     * @param roomId the ID of the chatroom to toggle in/out notification
     * @param inOutNotification whether to enable (true) or disable (false) entry/exit notifications
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if roomId is null or inOutNotification is null
     */
    @Override
    public Result<ToggleInOutNotificationResponseV2> toggleInOutNotification(Long roomId, Boolean inOutNotification) throws YunxinSdkException {
        // Validate required parameters
        if (roomId == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (inOutNotification == null) {
            throw new IllegalArgumentException("In/out notification status cannot be null");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.TOGGLE_IN_OUT_NOTIFICATION.replace("{room_id}", roomId.toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("in_out_notification", inOutNotification.toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomUrlContextV2.TOGGLE_IN_OUT_NOTIFICATION,
            endpoint,
            queryParams,
            null // No request body for this API
        );
        
        return ResultUtils.convert(apiResponse, ToggleInOutNotificationResponseV2.class);
    }
    
    /**
     * Query open chatrooms
     * 
     * API: GET https://open.yunxinapi.com/im/v2/chatrooms/actions/opend_chatrooms
     * 
     * This method retrieves a list of open chatrooms created by a specific account.
     * A chatroom is considered "open" when its status is set to valid.
     * 
     * @param creatorAccountId the account ID of the chatroom creator
     * @return result containing a list of open chatroom IDs
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if creatorAccountId is null or empty
     */
    @Override
    public Result<QueryOpenChatroomsResponseV2> queryOpenChatrooms(String creatorAccountId) throws YunxinSdkException {
        // Validate required parameters
        if (creatorAccountId == null || creatorAccountId.isEmpty()) {
            throw new IllegalArgumentException("Creator account ID cannot be null or empty");
        }
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("creator_account_id", creatorAccountId);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomUrlContextV2.QUERY_OPEN_CHATROOMS,
            ChatroomUrlContextV2.QUERY_OPEN_CHATROOMS,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, QueryOpenChatroomsResponseV2.class);
    }
    
    /**
     * List online chatroom members
     * 
     * API: GET https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/list_online_members
     * 
     * This method retrieves a paginated list of online members in a chatroom.
     * Chatroom members include permanent members (creator, administrators, and regular members)
     * and temporary members (regular guests and anonymous guests).
     * 
     * @param request request containing the chatroom ID, pagination parameters, and optional filters
     * @return result containing a paginated list of online chatroom members
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ListOnlineMembersResponseV2> listOnlineMembers(ListOnlineMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOffset() == null) {
            throw new IllegalArgumentException("Offset cannot be null");
        }
        
        if (request.getLimit() == null) {
            throw new IllegalArgumentException("Limit cannot be null");
        }
        
        // Validate limit value
        if (request.getLimit() <= 0 || request.getLimit() > 100) {
            throw new IllegalArgumentException("Limit must be between 1 and 100");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.LIST_ONLINE_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
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
            ChatroomUrlContextV2.LIST_ONLINE_MEMBERS,
            endpoint,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, ListOnlineMembersResponseV2.class);
    }

    /**
     * List fixed chatroom members
     * 
     * API: GET https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/actions/list_members
     * 
     * This method retrieves a list of fixed members in a chatroom.
     * Fixed members include permanent members: creator, administrators, and regular members.
     * 
     * @param request request containing the chatroom ID and optional filters
     * @return result containing a list of fixed chatroom members
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ListFixedMembersResponseV2> listFixedMembers(ListFixedMembersRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomUrlContextV2.LIST_FIXED_MEMBERS.replace("{room_id}", request.getRoomId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        
        if (request.getMemberRoles() != null && !request.getMemberRoles().isEmpty()) {
            queryParams.put("member_roles", request.getMemberRoles());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomUrlContextV2.LIST_FIXED_MEMBERS,
            endpoint,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, ListFixedMembersResponseV2.class);
    }
} 