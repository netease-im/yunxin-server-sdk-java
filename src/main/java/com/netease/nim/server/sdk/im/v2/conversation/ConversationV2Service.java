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
 * - Batch sending P2P messages
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
            ConversationV2UrlContext.CREATE_CONVERSATION,
            ConversationV2UrlContext.CREATE_CONVERSATION,
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
        String endpoint = ConversationV2UrlContext.UPDATE_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationV2UrlContext.UPDATE_CONVERSATION,
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
        String endpoint = ConversationV2UrlContext.DELETE_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Add query parameter if clearMessage is set
        Map<String, String> queryParams = null;
        if (request.getClearMessage() != null) {
            queryParams = new HashMap<>();
            queryParams.put("clear_message", request.getClearMessage().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ConversationV2UrlContext.DELETE_CONVERSATION,
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
            ConversationV2UrlContext.BATCH_DELETE_CONVERSATIONS,
            ConversationV2UrlContext.BATCH_DELETE_CONVERSATIONS,
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
        String endpoint = ConversationV2UrlContext.GET_CONVERSATION.replace("{conversation_id}", conversationId);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ConversationV2UrlContext.GET_CONVERSATION,
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
            ConversationV2UrlContext.BATCH_GET_CONVERSATIONS,
            ConversationV2UrlContext.BATCH_GET_CONVERSATIONS,
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
            ConversationV2UrlContext.LIST_CONVERSATIONS,
            ConversationV2UrlContext.LIST_CONVERSATIONS,
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
        String endpoint = ConversationV2UrlContext.STICK_TOP_CONVERSATION.replace("{conversation_id}", conversationId);
        
        // Create a request body with only the top_type field
        Map<String, Integer> requestBodyMap = new HashMap<>();
        requestBodyMap.put("top_type", topType);
        String requestBody = JSONObject.toJSONString(requestBodyMap);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ConversationV2UrlContext.STICK_TOP_CONVERSATION,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, StickTopConversationResponseV2.class);
    }
} 