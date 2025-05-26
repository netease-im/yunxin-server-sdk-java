package com.netease.nim.im.server.sdk.v2.conversation;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.conversation.request.*;
import com.netease.nim.im.server.sdk.v2.conversation.response.*;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.UnsupportedEncodingException;

/**
 * Implementation for Conversation V2 operations
 * 
 * This service provides methods for managing conversations, including:
 * - Creating conversations
 * - Updating conversations
 * - Deleting conversations
 * - Batch deleting multiple conversations
 * - Getting conversation details
 * - Batch getting multiple conversations
 * - Listing conversations for an account with pagination
 * - Pinning/unpinning conversations
 * - Creating conversation groups
 * - Updating conversation groups
 * - Deleting conversation groups
 * - Getting conversation group information
 * - Batch getting conversation groups information
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class ConversationV2Service implements IConversationV2Service {

    private final YunxinApiHttpClient httpClient;

    public ConversationV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Create a conversation
     * 
     * Note: The conversation ID must follow the format:
     * - sender_id|conversation_type|receiver_id (for P2P chat)
     * - sender_id|conversation_type|team_id (for team chat)
     * 
     * Where conversation_type is:
     * - 1 for P2P chat
     * - 2 for advanced team chat
     * - 3 for super team chat
     */
    @Override
    public Result<CreateConversationResponseV2> createConversation(CreateConversationRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ConversationUrlContextV2.CREATE_CONVERSATION,
            ConversationUrlContextV2.CREATE_CONVERSATION,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateConversationResponseV2.class);
    }
    
    /**
     * Update a conversation's server extension field
     *
     * This method allows updating the server extension field of an existing conversation.
     * If the conversation ID doesn't exist, a 414 error code will be returned.
     *
     * @param request the request containing conversation ID and updated server extension
     * @return result containing the updated conversation details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation ID is null or empty
     */
    @Override
    public Result<UpdateConversationResponseV2> updateConversation(UpdateConversationRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ConversationUrlContextV2.UPDATE_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationUrlContextV2.UPDATE_CONVERSATION,
            endpoint,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateConversationResponseV2.class);
    }
    
    /**
     * Delete a conversation
     * 
     * This method allows deleting an existing conversation.
     * Optionally, it can also delete the corresponding message history.
     * If the conversation ID doesn't exist, a 414 error code will be returned.
     *
     * @param request the request containing conversation ID and deletion options
     * @return result containing success status
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation ID is null or empty
     */
    @Override
    public Result<DeleteConversationResponseV2> deleteConversation(DeleteConversationRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ConversationUrlContextV2.DELETE_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Add query parameter if clearMessage is set
        Map<String, String> queryParams = null;
        if (request.getClearMessage() != null) {
            queryParams = new HashMap<>();
            queryParams.put("clear_message", request.getClearMessage().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ConversationUrlContextV2.DELETE_CONVERSATION,
            endpoint,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, DeleteConversationResponseV2.class);
    }
    
    /**
     * Batch delete multiple conversations
     * 
     * This method allows deleting multiple conversations in a single API call.
     * Optionally, it can also delete the corresponding message history.
     * Maximum 100 conversation IDs can be specified in a single request.
     *
     * @param request the request containing list of conversation IDs and deletion options
     * @return result containing successful and failed deletions
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation IDs list is null, empty, or exceeds the limit
     */
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
            ConversationUrlContextV2.BATCH_DELETE_CONVERSATIONS,
            ConversationUrlContextV2.BATCH_DELETE_CONVERSATIONS,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, BatchDeleteConversationsResponseV2.class);
    }

    /**
     * Get a conversation by ID
     * 
     * This method retrieves the details of a specific conversation.
     * If the conversation ID doesn't exist, a 414 error code will be returned.
     *
     * @param request the request containing the conversation ID to retrieve
     * @return result containing the conversation details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation ID is null or empty
     */
    @Override
    public Result<GetConversationResponseV2> getConversation(GetConversationRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ConversationUrlContextV2.GET_CONVERSATION.replace("{conversation_id}", conversationId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationUrlContextV2.GET_CONVERSATION,
            endpoint,
            null, // No query parameters
            null  // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, GetConversationResponseV2.class);
    }
    
    /**
     * Batch get multiple conversations by their IDs
     * 
     * This method retrieves the details of multiple conversations in a single API call.
     * Maximum 100 conversation IDs can be specified in a single request.
     * If some conversation IDs don't exist, they will be included in the failed list in the response.
     *
     * @param request the request containing list of conversation IDs to retrieve
     * @return result containing successful and failed retrievals
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation IDs list is null, empty, or exceeds the limit
     */
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
            ConversationUrlContextV2.BATCH_GET_CONVERSATIONS,
            ConversationUrlContextV2.BATCH_GET_CONVERSATIONS,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, BatchGetConversationsResponseV2.class);
    }
    
    /**
     * List conversations for an account with pagination
     * 
     * This method retrieves a paginated list of conversations for a specified account.
     * Supports pagination with a maximum of 100 items per page.
     * The API can retrieve up to 10,000 historical conversations in total.
     * Pinned conversations will be listed first.
     *
     * @param request the request containing account ID, pagination token, and limit parameters
     * @return result containing paginated list of conversations
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if account ID is null or empty
     */
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
            ConversationUrlContextV2.LIST_CONVERSATIONS,
            ConversationUrlContextV2.LIST_CONVERSATIONS,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, ListConversationsResponseV2.class);
    }
    
    /**
     * Stick top (pin) or unstick (unpin) a conversation
     * 
     * This method allows pinning or unpinning a conversation.
     * If the conversation ID doesn't exist, a 414 error code will be returned.
     *
     * @param request the request containing conversation ID to pin/unpin and top type (1 for pin, 0 for unpin)
     * @return result containing success status
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation ID is null or empty or if top type is invalid
     */
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
        String endpoint = ConversationUrlContextV2.STICK_TOP_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Create a request body with only the top_type field
        Map<String, Integer> requestBodyMap = new HashMap<>();
        requestBodyMap.put("top_type", topType);
        String requestBody = JSONObject.toJSONString(requestBodyMap);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationUrlContextV2.STICK_TOP_CONVERSATION,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, StickTopConversationResponseV2.class);
    }

    /**
     * Get a conversation overview for an account
     * 
     * This method retrieves the total unread count across all conversations for a specific account.
     *
     * @param request the request containing the account ID
     * @return result containing the account ID and total unread count
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if account ID is null or empty
     */
    @Override
    public Result<OverViewsConversationResponseV2> getConversationOverview(OverViewsConversationRequestV2 request) throws YunxinSdkException {
        String accountId = request.getAccountId();
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        String endpoint = ConversationUrlContextV2.OVERVIEWS_CONVERSATION.replace("{account_id}", accountId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationUrlContextV2.OVERVIEWS_CONVERSATION,
            endpoint,
            null, // No query parameters
            null  // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, OverViewsConversationResponseV2.class);
    }
    
    /**
     * Clear the unread count of a conversation
     * 
     * This method resets the unread count for a specific conversation to zero.
     * If the conversation ID doesn't exist, a 414 error code will be returned.
     *
     * @param request the request containing the conversation ID to clear unread count for
     * @return result containing success status (empty response body)
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation ID is null or empty
     */
    @Override
    public Result<ClearConversationUnreadResponseV2> clearConversationUnread(ClearConversationUnreadRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ConversationUrlContextV2.CLEAR_CONVERSATION_UNREAD.replace("{conversation_id}", conversationId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationUrlContextV2.CLEAR_CONVERSATION_UNREAD,
            endpoint,
            null, // No query parameters
            "{}" // Empty JSON object as request body
        );
        
        return ResultUtils.convert(apiResponse, ClearConversationUnreadResponseV2.class);
    }

    /**
     * Create a conversation group
     * 
     * This method creates a new conversation group for the specified account
     * and optionally adds conversations to it.
     * 
     * Each account can create a limited number of conversation groups,
     * and each conversation can belong to up to 5 groups.
     * 
     * @param request the request containing account ID, group name, and optional conversation IDs
     * @return result containing the created group details and success/failure lists
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<CreateConversationGroupResponseV2> createConversationGroup(CreateConversationGroupRequestV2 request) throws YunxinSdkException {
        // Validate request
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Conversation group name cannot be null or empty");
        }
        
        // If conversation IDs are specified, validate the limit
        if (request.getConversationIds() != null && request.getConversationIds().size() > 100) {
            throw new IllegalArgumentException("Maximum 100 conversation IDs can be specified in a single request");
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ConversationUrlContextV2.CREATE_CONVERSATION_GROUP,
            ConversationUrlContextV2.CREATE_CONVERSATION_GROUP,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateConversationGroupResponseV2.class);
    }

    /**
     * Update a conversation group
     * 
     * This method updates a conversation group's properties and optionally adds
     * or removes conversations from the group.
     * 
     * Properties that can be updated include:
     * - Group name
     * - Server extension
     * - Adding or removing conversations from the group
     * 
     * Each conversation can belong to at most 5 conversation groups.
     * 
     * @param request the request containing group ID, account ID, and updated properties
     * @return result containing the updated group details and success/failure lists
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<UpdateConversationGroupResponseV2> updateConversationGroup(UpdateConversationGroupRequestV2 request) throws YunxinSdkException {
        // Validate request
        Long groupId = request.getGroupId();
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
        
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        // Validate conversation operation if present
        if (request.getConversations() != null) {
            UpdateConversationGroupRequestV2.Conversations conversations = request.getConversations();
            
            if (conversations.getType() == null || (conversations.getType() != 1 && conversations.getType() != 2)) {
                throw new IllegalArgumentException("Conversation operation type must be 1 (add) or 2 (remove)");
            }
            
            List<String> conversationIds = conversations.getConversationIds();
            if (conversationIds == null || conversationIds.isEmpty()) {
                throw new IllegalArgumentException("Conversation IDs list cannot be null or empty when performing conversation operations");
            }

        }
        
        // Replace the path parameter in the URL
        String endpoint = ConversationUrlContextV2.UPDATE_CONVERSATION_GROUP.replace("{group_id}", groupId.toString());
        
        // Convert the request to JSON string
        // We need to exclude the groupId field since it's not part of the request body
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("account_id", request.getAccountId());
        
        if (request.getName() != null && !request.getName().isEmpty()) {
            requestMap.put("name", request.getName());
        }
        
        if (request.getServerExtension() != null && !request.getServerExtension().isEmpty()) {
            requestMap.put("server_extension", request.getServerExtension());
        }
        
        if (request.getConversations() != null) {
            Map<String, Object> conversationsMap = new HashMap<>();
            conversationsMap.put("type", request.getConversations().getType());
            conversationsMap.put("conversation_ids", request.getConversations().getConversationIds());
            requestMap.put("conversations", conversationsMap);
        }
        
        String requestBody = JSONObject.toJSONString(requestMap);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationUrlContextV2.UPDATE_CONVERSATION_GROUP,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateConversationGroupResponseV2.class);
    }

    /**
     * Delete a conversation group
     * 
     * This method deletes a conversation group for the specified account.
     * After deletion, all conversations that were in the group will have their
     * group_ids field updated accordingly.
     * 
     * @param request the request containing the group ID and account ID
     * @return result containing success status (empty response body)
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing
     */
    @Override
    public Result<DeleteConversationGroupResponseV2> deleteConversationGroup(DeleteConversationGroupRequestV2 request) throws YunxinSdkException {
        // Validate request
        Long groupId = request.getGroupId();
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
        
        String accountId = request.getAccountId();
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ConversationUrlContextV2.DELETE_CONVERSATION_GROUP.replace("{group_id}", groupId.toString());
        
        // Add account_id as a query parameter
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", accountId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ConversationUrlContextV2.DELETE_CONVERSATION_GROUP,
            endpoint,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, DeleteConversationGroupResponseV2.class);
    }

    /**
     * Get conversation group information
     * 
     * This method retrieves information about a specific conversation group.
     * 
     * @param request the request containing the group ID and account ID
     * @return result containing the conversation group details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing
     */
    @Override
    public Result<GetConversationGroupResponseV2> getConversationGroup(GetConversationGroupRequestV2 request) throws YunxinSdkException {
        // Validate request
        Long groupId = request.getGroupId();
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
        
        String accountId = request.getAccountId();
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ConversationUrlContextV2.GET_CONVERSATION_GROUP.replace("{group_id}", groupId.toString());
        
        // Add account_id as a query parameter
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", accountId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationUrlContextV2.GET_CONVERSATION_GROUP,
            endpoint,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, GetConversationGroupResponseV2.class);
    }

    /**
     * Batch get conversation groups information
     * 
     * This method retrieves information about multiple conversation groups in a single request.
     * 
     * @param request the request containing account ID and list of group IDs
     * @return result containing the successful and failed conversation group retrievals
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<BatchGetConversationGroupsResponseV2> batchGetConversationGroups(BatchGetConversationGroupsRequestV2 request) throws YunxinSdkException {
        // Validate request
        String accountId = request.getAccountId();
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        List<Long> groupIds = request.getGroupIds();
        if (groupIds == null || groupIds.isEmpty()) {
            throw new IllegalArgumentException("Group IDs list cannot be null or empty");
        }
        
        // Format group IDs as comma-separated string
        String groupIdsStr = groupIds.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        
        // Add query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", accountId);
        queryParams.put("group_ids", groupIdsStr);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationUrlContextV2.BATCH_GET_CONVERSATION_GROUPS,
            ConversationUrlContextV2.BATCH_GET_CONVERSATION_GROUPS,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, BatchGetConversationGroupsResponseV2.class);
    }

    /**
     * List all conversation groups for an account
     * 
     * This method retrieves all conversation groups for a specific account.
     * 
     * @param request the request containing the account ID
     * @return result containing the list of all conversation groups
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if account ID is null or empty
     */
    @Override
    public Result<ListAllConversationGroupsResponseV2> listAllConversationGroups(ListAllConversationGroupsRequestV2 request) throws YunxinSdkException {
        // Validate request
        String accountId = request.getAccountId();
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        // Add query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", accountId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationUrlContextV2.LIST_ALL_CONVERSATION_GROUPS,
            ConversationUrlContextV2.LIST_ALL_CONVERSATION_GROUPS,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, ListAllConversationGroupsResponseV2.class);
    }

    /**
     * Batch send P2P messages to multiple receivers
     * 
     * This method sends a single message to multiple receivers in separate P2P conversations.
     * Maximum 100 receiver IDs can be specified in a single request.
     * 
     * @param request the request containing sender ID, receiver IDs, and message content
     * @return result containing the successful and failed message deliveries
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<BatchSendP2PMessageResponseV2> batchSendP2PMessage(BatchSendP2PMessageRequestV2 request) throws YunxinSdkException {
        // Validate request
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        List<String> receiverIds = request.getReceiverIds();
        if (receiverIds == null || receiverIds.isEmpty()) {
            throw new IllegalArgumentException("Receiver IDs list cannot be null or empty");
        }
        
        if (request.getMessage() == null) {
            throw new IllegalArgumentException("Message content cannot be null");
        }
        
        if (request.getMessage().getMessageType() == null) {
            throw new IllegalArgumentException("Message type cannot be null");
        }
        
        // Check if sender and receiver are both set to no sense
        if (Boolean.TRUE.equals(request.getSenderNoSense()) && Boolean.TRUE.equals(request.getReceiverNoSense())) {
            throw new IllegalArgumentException("Sender and receiver cannot both be set to no sense (true)");
        }
        
        // For text or tip messages, text field is required
        Integer messageType = request.getMessage().getMessageType();
        if ((messageType == 0 || messageType == 10) && 
            (request.getMessage().getText() == null || request.getMessage().getText().isEmpty())) {
            throw new IllegalArgumentException("Text field is required for text messages (type 0) and tip messages (type 10)");
        }
        
        // For non-text/tip messages, attachment is required
        if (messageType != 0 && messageType != 10 && request.getMessage().getAttachment() == null) {
            throw new IllegalArgumentException("Attachment field is required for non-text/tip messages");
        }
        
        // For custom messages, subType is required
        if (messageType == 100 && request.getMessage().getSubType() == null) {
            throw new IllegalArgumentException("SubType field is required for custom messages (type 100)");
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ConversationUrlContextV2.BATCH_SEND_P2P_MESSAGE,
            ConversationUrlContextV2.BATCH_SEND_P2P_MESSAGE,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchSendP2PMessageResponseV2.class);
    }
} 