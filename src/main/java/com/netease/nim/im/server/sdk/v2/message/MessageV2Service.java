package com.netease.nim.im.server.sdk.v2.message;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.message.request.AddQuickCommentRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.BatchQueryMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.BatchQueryQuickCommentsRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.DeleteConversationMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.DeleteQuickCommentRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.ModifyMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryConversationMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryTeamReadReceiptRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryThreadMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SearchMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SendMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SendP2PReadReceiptRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SendTeamReadReceiptRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.WithdrawMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.response.AddQuickCommentResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.BatchQueryMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.BatchQueryQuickCommentsResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.DeleteConversationMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.DeleteQuickCommentResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.ModifyMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryConversationMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryTeamReadReceiptResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryThreadMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SearchMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SendMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SendP2PReadReceiptResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SendTeamReadReceiptResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.WithdrawMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Message V2 operations
 * 
 * This service provides methods for sending and modifying messages, including:
 * - Sending text messages
 * - Sending image messages
 * - Sending audio messages
 * - Sending video messages
 * - Sending location messages
 * - Sending file messages
 * - Sending tip messages
 * - Sending custom messages
 * - Modifying previously sent messages
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class MessageV2Service implements IMessageV2Service {

    private final YunxinApiHttpClient httpClient;

    public MessageV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Send a message to a conversation (P2P or team chat)
     *
     * This method allows sending various types of messages to a conversation,
     * including text, image, audio, video, location, file, tip, and custom messages.
     *
     * @param request the request containing conversation ID, message content, and message configuration
     * @return result containing the sent message details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if conversation ID is null or empty
     */
    @Override
    public Result<SendMessageResponseV2> sendMessage(SendMessageRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        if (conversationId == null || conversationId.isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        if (request.getMessage() == null) {
            throw new IllegalArgumentException("Message body cannot be null");
        }
        
        if (request.getMessage().getMessageType() == null) {
            throw new IllegalArgumentException("Message type cannot be null");
        }
        
        // For text and tip messages, validate text content
        if ((request.getMessage().getMessageType() == 0 || request.getMessage().getMessageType() == 10) 
                && (request.getMessage().getText() == null || request.getMessage().getText().isEmpty())) {
            throw new IllegalArgumentException("Text content is required for text and tip messages");
        }
        
        // For non-text/tip messages, validate attachment
        if (request.getMessage().getMessageType() != 0 && request.getMessage().getMessageType() != 10 
                && request.getMessage().getAttachment() == null) {
            throw new IllegalArgumentException("Attachment is required for non-text/tip messages");
        }
        
        // Replace the path parameter in the URL
        String endpoint = MessageUrlContextV2.SEND_MESSAGE.replace("{conversation_id}", conversationId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageUrlContextV2.SEND_MESSAGE,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendMessageResponseV2.class);
    }
    
    /**
     * Modify (update) a previously sent message
     * 
     * This method allows modifying messages sent within the last 7 days.
     * For the same message (identified by the message ID), you cannot update more than once per second,
     * otherwise error code 107449 will be returned.
     * 
     * Only the message sender and the team owner have permission to modify messages by default.
     * 
     * @param request request containing the original message details and modified content
     * @return result containing the modified message details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ModifyMessageResponseV2> modifyMessage(ModifyMessageRequestV2 request) throws YunxinSdkException {
        // Validate request
        if (request.getOperator() == null || request.getOperator().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getType() == null) {
            throw new IllegalArgumentException("Conversation type cannot be null");
        }
        
        if (request.getType() < 1 || request.getType() > 3) {
            throw new IllegalArgumentException("Invalid conversation type: must be 1 (P2P), 2 (Advanced team), or 3 (Super team)");
        }
        
        if (request.getMessage() == null) {
            throw new IllegalArgumentException("Message content cannot be null");
        }
        
        // Validate message details
        if (request.getMessage().getMessageServerId() == null) {
            throw new IllegalArgumentException("Message server ID cannot be null");
        }
        
        if (request.getMessage().getSenderId() == null || request.getMessage().getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Message sender ID cannot be null or empty");
        }
        
        if (request.getMessage().getReceiverId() == null || request.getMessage().getReceiverId().isEmpty()) {
            throw new IllegalArgumentException("Message receiver ID cannot be null or empty");
        }
        
        if (request.getMessage().getTime() == null) {
            throw new IllegalArgumentException("Message time cannot be null");
        }
        
        if (request.getMessage().getMessageType() == null) {
            throw new IllegalArgumentException("Message type cannot be null");
        }
        
        // For text and tip messages, validate text content
        if ((request.getMessage().getMessageType() == 0 || request.getMessage().getMessageType() == 10) 
                && (request.getMessage().getText() == null || request.getMessage().getText().isEmpty())) {
            throw new IllegalArgumentException("Text content is required for text and tip messages");
        }
        
        // For custom messages, validate attachment and subtype
        if (request.getMessage().getMessageType() == 100) {
            if (request.getMessage().getAttachment() == null) {
                throw new IllegalArgumentException("Attachment is required for custom messages");
            }
            
            if (request.getMessage().getSubType() == null) {
                throw new IllegalArgumentException("Subtype is required for custom messages");
            }
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageUrlContextV2.MODIFY_MESSAGE,
            MessageUrlContextV2.MODIFY_MESSAGE,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ModifyMessageResponseV2.class);
    }
    
    /**
     * Withdraw (recall or delete) a message from a conversation
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
     * 
     * This API supports three types of operations:
     * 1. Unilateral recall (type=1): Supports recalling a P2P or advanced team message within 30 days.
     * 2. Bilateral recall (type=2): Supports recalling P2P, advanced team, and super team messages within a
     *    configurable time (default 2 minutes, max 7 days).
     * 3. Delete message (type=3): Supports deleting P2P and advanced team messages within 30 days.
     * 
     * @param request the request containing all parameters for the withdrawal operation
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<WithdrawMessageResponseV2> withdrawMessage(WithdrawMessageRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request.getConversationId() == null || request.getConversationId().isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        if (request.getMessageServerId() == null) {
            throw new IllegalArgumentException("Message server ID cannot be null");
        }
        
        if (request.getType() == null) {
            throw new IllegalArgumentException("Operation type cannot be null");
        }
        
        if (request.getType() < 1 || request.getType() > 3) {
            throw new IllegalArgumentException("Invalid operation type: must be 1 (unilateral recall), 2 (bilateral recall), or 3 (delete message)");
        }
        
        // Replace path parameters in the URL
        String endpoint = MessageUrlContextV2.WITHDRAW_MESSAGE
                .replace("{conversation_id}", request.getConversationId())
                .replace("{message_server_id}", request.getMessageServerId().toString());
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("type", request.getType().toString());
        
        if (request.getDescription() != null && !request.getDescription().isEmpty()) {
            queryParams.put("description", request.getDescription());
        }
        
        // Add optional parameters for bilateral recall (type=2)
        if (request.getType() == 2) {
            if (request.getPushContent() != null && !request.getPushContent().isEmpty()) {
                queryParams.put("push_content", request.getPushContent());
            }
            
            if (request.getPushPayload() != null && !request.getPushPayload().isEmpty()) {
                queryParams.put("push_payload", request.getPushPayload());
            }
            
            if (request.getRouteEnvironment() != null && !request.getRouteEnvironment().isEmpty()) {
                queryParams.put("route_environment", request.getRouteEnvironment());
            }
            
            if (request.getAttach() != null && !request.getAttach().isEmpty()) {
                queryParams.put("attach", request.getAttach());
            }
        }
        
        if (request.getCheckTeamMemberValid() != null) {
            queryParams.put("check_team_member_valid", request.getCheckTeamMemberValid().toString());
        }
        
        if (request.getMessageTime() != null) {
            queryParams.put("message_time", request.getMessageTime().toString());
        }
        
        if (request.getIgnoreRevokeTime() != null && request.getIgnoreRevokeTime()) {
            queryParams.put("ingore_revoke_time", "1"); // Note: API uses "ingore" not "ignore"
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            MessageUrlContextV2.WITHDRAW_MESSAGE,
            endpoint,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, WithdrawMessageResponseV2.class);
    }
    
    /**
     * Delete all messages in a conversation
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
     * 
     * This method allows for deleting all messages in a conversation with different options:
     * 1. Delete all roaming messages
     * 2. Delete all history messages
     * 3. Delete both roaming and history messages
     * 
     * @param request the request containing conversation ID and deletion type
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<DeleteConversationMessagesResponseV2> deleteConversationMessages(
            DeleteConversationMessagesRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request.getConversationId() == null || request.getConversationId().isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        if (request.getType() == null) {
            throw new IllegalArgumentException("Operation type cannot be null");
        }
        
        if (request.getType() < 1 || request.getType() > 3) {
            throw new IllegalArgumentException("Invalid operation type: must be 1 (roaming messages), " +
                    "2 (history messages), or 3 (both roaming and history messages)");
        }
        
        // Replace path parameter in the URL
        String endpoint = MessageUrlContextV2.DELETE_CONVERSATION_MESSAGES
                .replace("{conversation_id}", request.getConversationId());
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("type", request.getType().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            MessageUrlContextV2.DELETE_CONVERSATION_MESSAGES,
            endpoint,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, DeleteConversationMessagesResponseV2.class);
    }
    
    /**
     * Send P2P read receipt to mark a message as read
     * 
     * API: POST https://open.yunxinapi.com/im/v2/messages/actions/p2p_read_receipt
     * 
     * This method allows you to mark a message as read in a P2P conversation.
     * The read receipt will be sent to the message sender.
     * 
     * @param request the request containing receipt sender, receiver, and message server ID
     * @return result containing the timestamp when the receipt was sent
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<SendP2PReadReceiptResponseV2> sendP2PReadReceipt(
            SendP2PReadReceiptRequestV2 request) throws YunxinSdkException {
            
        // Validate required parameters
        if (request.getFromAccountId() == null || request.getFromAccountId().isEmpty()) {
            throw new IllegalArgumentException("From account ID (receipt sender) cannot be null or empty");
        }
        
        if (request.getToAccountId() == null || request.getToAccountId().isEmpty()) {
            throw new IllegalArgumentException("To account ID (receipt receiver) cannot be null or empty");
        }
        
        if (request.getMessageServerId() == null) {
            throw new IllegalArgumentException("Message server ID cannot be null");
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageUrlContextV2.SEND_P2P_READ_RECEIPT,
            MessageUrlContextV2.SEND_P2P_READ_RECEIPT,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendP2PReadReceiptResponseV2.class);
    }
    
    /**
     * Send team read receipt to mark messages as read in an advanced team conversation
     * 
     * API: POST https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
     * 
     * This method allows you to mark messages as read in an advanced team conversation.
     * 
     * Notes:
     * - The team read receipt feature must be enabled in the Yunxin console before using this API.
     * - By default, this feature is supported for teams with up to 200 members. This limit can be extended 
     *   to up to 500 members from the console.
     * - Up to 50 messages can be marked as read in a single request.
     * 
     * @param request the request containing receipt sender, team ID, and list of message server IDs
     * @return result containing lists of successfully processed and failed message IDs
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<SendTeamReadReceiptResponseV2> sendTeamReadReceipt(
            SendTeamReadReceiptRequestV2 request) throws YunxinSdkException {
            
        // Validate required parameters
        if (request.getFromAccountId() == null || request.getFromAccountId().isEmpty()) {
            throw new IllegalArgumentException("From account ID (receipt sender) cannot be null or empty");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getMessageServerIds() == null || request.getMessageServerIds().isEmpty()) {
            throw new IllegalArgumentException("Message server IDs list cannot be null or empty");
        }
        

        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageUrlContextV2.SEND_TEAM_READ_RECEIPT,
            MessageUrlContextV2.SEND_TEAM_READ_RECEIPT,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendTeamReadReceiptResponseV2.class);
    }
    
    /**
     * Query read/unread details for a message in an advanced team
     * 
     * API: GET https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
     * 
     * This method allows you to query the read/unread details for a specific message in an advanced team,
     * including the number of users who have read or not read the message, and optionally the list of
     * those users' account IDs.
     * 
     * Notes:
     * - This API only supports advanced teams (team_type=1)
     * - The team read receipt feature must be enabled in the Yunxin console before using this API
     * 
     * @param request the request containing team ID, sender ID, and message server ID
     * @return result containing read/unread counts and optionally account ID lists
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<QueryTeamReadReceiptResponseV2> queryTeamReadReceipt(
            QueryTeamReadReceiptRequestV2 request) throws YunxinSdkException {
            
        // Validate required parameters
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1) {
            throw new IllegalArgumentException("Only advanced team (team_type=1) is supported");
        }
        
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getMessageServerId() == null) {
            throw new IllegalArgumentException("Message server ID cannot be null");
        }
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_id", request.getTeamId());
        queryParams.put("team_type", request.getTeamType().toString());
        queryParams.put("sender_id", request.getSenderId());
        queryParams.put("message_server_id", request.getMessageServerId().toString());
        
        if (request.getSnapshot() != null) {
            queryParams.put("snapshot", request.getSnapshot().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MessageUrlContextV2.QUERY_TEAM_READ_RECEIPT,
            MessageUrlContextV2.QUERY_TEAM_READ_RECEIPT,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryTeamReadReceiptResponseV2.class);
    }
    
    /**
     * Query details of a single message in a conversation
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
     * 
     * This method allows you to query the details of a specific message in a conversation,
     * including the sender ID, message ID, message type, message content, etc.
     * 
     * @param request the request containing conversation ID, message server ID, and optional parameters
     * @return result containing the message details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<QueryMessageResponseV2> queryMessage(
            QueryMessageRequestV2 request) throws YunxinSdkException {
            
        // Validate required parameters
        if (request.getConversationId() == null || request.getConversationId().isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        if (request.getMessageServerId() == null) {
            throw new IllegalArgumentException("Message server ID cannot be null");
        }
        
        // Replace path parameters in the URL
        String endpoint = MessageUrlContextV2.QUERY_MESSAGE
                .replace("{conversation_id}", request.getConversationId())
                .replace("{message_server_id}", request.getMessageServerId().toString());
        
        // Log the constructed endpoint for debugging
        System.out.println("Querying message with endpoint: " + endpoint);
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        
        if (request.getMessageTime() != null) {
            queryParams.put("message_time", request.getMessageTime().toString());
        }
        
        if (request.getCheckTeamValid() != null) {
            queryParams.put("check_team_valid", request.getCheckTeamValid().toString());
        }
        
        if (request.getCheckTeamMemberValid() != null) {
            queryParams.put("check_team_member_valid", request.getCheckTeamMemberValid().toString());
        }
        
        // Log query parameters for debugging
        if (!queryParams.isEmpty()) {
            System.out.println("Query parameters: " + JSONObject.toJSONString(queryParams));
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MessageUrlContextV2.QUERY_MESSAGE,
            endpoint,
            queryParams,
            null // No request body for GET
        );
        
        // Log the raw API response for debugging
        System.out.println("Raw API response: " + JSONObject.toJSONString(apiResponse));
        
        return ResultUtils.convert(apiResponse, QueryMessageResponseV2.class);
    }
    
    @Override
    public Result<SearchMessagesResponseV2> searchMessages(SearchMessagesRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("Operator ID cannot be null or empty");
        }
        
        // Validate keyword list if sender and message type are not provided
        if ((request.getSenderAccountIds() == null || request.getSenderAccountIds().isEmpty()) 
                && (request.getMessageTypes() == null || request.getMessageTypes().isEmpty())) {
            if (request.getKeywordList() == null || request.getKeywordList().length == 0) {
                throw new IllegalArgumentException("At least one of sender IDs, message types, or keyword list must be provided");
            }
        }
        
        // Validate sender account IDs (max 5)
        if (request.getSenderAccountIds() != null && !request.getSenderAccountIds().isEmpty()) {
            String[] senderIds = request.getSenderAccountIds().split(",");
        }

        
        // Create query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("operator_id", request.getOperatorId());
        
        if (request.getConversationId() != null && !request.getConversationId().isEmpty()) {
            queryParams.put("conversation_id", request.getConversationId());
        }
        
        if (request.getSenderAccountIds() != null && !request.getSenderAccountIds().isEmpty()) {
            queryParams.put("sender_account_ids", request.getSenderAccountIds());
        }
        
        if (request.getMessageTypes() != null && !request.getMessageTypes().isEmpty()) {
            queryParams.put("message_types", request.getMessageTypes());
        }
        
        if (request.getMessageSubTypes() != null && !request.getMessageSubTypes().isEmpty()) {
            queryParams.put("message_sub_types", request.getMessageSubTypes());
        }
        
        if (request.getStartTime() != null) {
            queryParams.put("start_time", request.getStartTime().toString());
        }
        
        if (request.getTimePeriod() != null) {
            queryParams.put("time_period", request.getTimePeriod().toString());
        }
        
        if (request.getKeywordList() != null && request.getKeywordList().length > 0) {
            queryParams.put("keyword_list", request.getKeywordListAsJsonString());
        }
        
        if (request.getKeywordMatchType() != null) {
            queryParams.put("keyword_match_type", request.getKeywordMatchType().toString());
        }
        
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MessageUrlContextV2.SEARCH_MESSAGES,
            MessageUrlContextV2.SEARCH_MESSAGES,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, SearchMessagesResponseV2.class);
    }
    
    @Override
    public Result<QueryConversationMessagesResponseV2> queryConversationMessages(
            QueryConversationMessagesRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request.getConversationId() == null || request.getConversationId().isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        if (request.getBeginTime() == null) {
            throw new IllegalArgumentException("Begin time cannot be null");
        }
        
        if (request.getEndTime() == null) {
            throw new IllegalArgumentException("End time cannot be null");
        }
        
        if (request.getLimit() == null) {
            throw new IllegalArgumentException("Limit cannot be null");
        }
        
        if (request.getLimit() <= 0 || request.getLimit() > 100) {
            throw new IllegalArgumentException("Limit must be between 1 and 100");
        }
        
        // Replace path parameter in the URL
        String endpoint = MessageUrlContextV2.QUERY_CONVERSATION_MESSAGES
                .replace("{conversation_id}", request.getConversationId());
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("begin_time", request.getBeginTime().toString());
        queryParams.put("end_time", request.getEndTime().toString());
        queryParams.put("limit", request.getLimit().toString());
        
        if (request.getPageToken() != null) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getDescending() != null) {
            queryParams.put("descending", request.getDescending().toString());
        }
        
        if (request.getMessageType() != null) {
            queryParams.put("message_type", request.getMessageType());
        }
        
        if (request.getCheckTeamValid() != null) {
            queryParams.put("check_team_valid", request.getCheckTeamValid().toString());
        }
        
        if (request.getIncludeNoSenseMsg() != null) {
            queryParams.put("include_no_sense_msg", request.getIncludeNoSenseMsg().toString());
        }
        
        // Log the constructed endpoint and parameters for debugging
        System.out.println("Querying conversation messages with endpoint: " + endpoint);
        System.out.println("Query parameters: " + JSONObject.toJSONString(queryParams));
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MessageUrlContextV2.QUERY_CONVERSATION_MESSAGES,
            endpoint,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryConversationMessagesResponseV2.class);
    }
    
    /**
     * Batch query messages by message IDs
     * 
     * API: POST https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/batch_messages
     * 
     * This method allows you to query multiple historical messages by providing their message IDs,
     * including single chat messages, advanced team messages, and super team messages.
     * 
     * @param request request containing conversation ID and list of message IDs to query
     * @return result containing the successfully queried messages and any failed queries
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if request parameters are invalid
     */
    @Override
    public Result<BatchQueryMessagesResponseV2> batchQueryMessages(
            BatchQueryMessagesRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request.getConversationId() == null || request.getConversationId().isEmpty()) {
            throw new IllegalArgumentException("Conversation ID cannot be null or empty");
        }
        
        if (request.getMessages() == null || request.getMessages().isEmpty()) {
            throw new IllegalArgumentException("Messages list cannot be null or empty");
        }
        
        // Check if each message in the list has required parameters
        for (BatchQueryMessagesRequestV2.MessageQuery message : request.getMessages()) {
            if (message.getMessageServerId() == null) {
                throw new IllegalArgumentException("Message server ID cannot be null for any message in the list");
            }
            if (message.getCreateTime() == null) {
                throw new IllegalArgumentException("Message creation time cannot be null for any message in the list");
            }
        }
        
        // Replace path parameter in the URL
        String endpoint = MessageUrlContextV2.BATCH_QUERY_MESSAGES
                .replace("{conversation_id}", request.getConversationId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Log the constructed endpoint and request body for debugging
        System.out.println("Batch querying messages with endpoint: " + endpoint);
        System.out.println("Request body: " + requestBody);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageUrlContextV2.BATCH_QUERY_MESSAGES,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryMessagesResponseV2.class);
    }
    
    /**
     * Query thread messages
     * 
     * API: GET https://open.yunxinapi.com/im/v2/messages/actions/thread_messages
     * 
     * This method allows you to query thread messages based on the thread root message,
     * with pagination support.
     * 
     * @param request request containing thread root message details and query parameters
     * @return result containing the thread messages and pagination details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if request parameters are invalid
     */
    @Override
    public Result<QueryThreadMessagesResponseV2> queryThreadMessages(
            QueryThreadMessagesRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request.getBeginTime() == null) {
            throw new IllegalArgumentException("Begin time cannot be null");
        }
        
        if (request.getEndTime() == null) {
            throw new IllegalArgumentException("End time cannot be null");
        }
        
        if (request.getLimit() == null) {
            throw new IllegalArgumentException("Limit cannot be null");
        }
        
        if (request.getLimit() <= 0 || request.getLimit() > 100) {
            throw new IllegalArgumentException("Limit must be between 1 and 100");
        }
        
        if (request.getConversationType() == null) {
            throw new IllegalArgumentException("Conversation type cannot be null");
        }
        
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getReceiverId() == null || request.getReceiverId().isEmpty()) {
            throw new IllegalArgumentException("Receiver ID cannot be null or empty");
        }
        
        if (request.getMessageServerId() == null) {
            throw new IllegalArgumentException("Message server ID cannot be null");
        }
        
        if (request.getMessageClientId() == null || request.getMessageClientId().isEmpty()) {
            throw new IllegalArgumentException("Message client ID cannot be null or empty");
        }
        
        if (request.getCreateTime() == null) {
            throw new IllegalArgumentException("Create time cannot be null");
        }
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("begin_time", request.getBeginTime().toString());
        queryParams.put("end_time", request.getEndTime().toString());
        queryParams.put("limit", request.getLimit().toString());
        queryParams.put("conversation_type", request.getConversationType().toString());
        queryParams.put("sender_id", request.getSenderId());
        queryParams.put("receiver_id", request.getReceiverId());
        queryParams.put("message_server_id", request.getMessageServerId().toString());
        queryParams.put("message_client_id", request.getMessageClientId());
        queryParams.put("create_time", request.getCreateTime().toString());
        
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getDescending() != null) {
            queryParams.put("descending", request.getDescending().toString());
        }

        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MessageUrlContextV2.QUERY_THREAD_MESSAGES,
            MessageUrlContextV2.QUERY_THREAD_MESSAGES,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryThreadMessagesResponseV2.class);
    }
    
    /**
     * Add quick comment to a message
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
     * 
     * This method allows adding emoji reactions or other quick comments to existing messages.
     * Quick comments are typically used for emoji reactions but can be extended to other types
     * of lightweight interactions with messages.
     * 
     * @param request request containing operator ID, message details, comment index, and optional configuration
     * @return result containing the comment ID and timestamp
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<AddQuickCommentResponseV2> addQuickComment(
            AddQuickCommentRequestV2 request) throws YunxinSdkException {
        // 验证请求参数
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("操作者ID不能为空");
        }
        
        if (request.getIndex() == null || request.getIndex() <= 0) {
            throw new IllegalArgumentException("评论类型索引必须大于0");
        }
        
        if (request.getMessage() == null) {
            throw new IllegalArgumentException("消息信息不能为空");
        }
        
        // 验证消息详情
        if (request.getMessage().getConversationType() == null) {
            throw new IllegalArgumentException("会话类型不能为空");
        }
        
        if (request.getMessage().getConversationType() < 1 || request.getMessage().getConversationType() > 3) {
            throw new IllegalArgumentException("无效的会话类型: 必须为1(单聊), 2(高级群), 或3(超大群)");
        }
        
        if (request.getMessage().getSenderId() == null || request.getMessage().getSenderId().isEmpty()) {
            throw new IllegalArgumentException("消息发送者ID不能为空");
        }
        
        if (request.getMessage().getReceiverId() == null || request.getMessage().getReceiverId().isEmpty()) {
            throw new IllegalArgumentException("消息接收者ID不能为空");
        }
        
        if (request.getMessage().getMessageServerId() == null) {
            throw new IllegalArgumentException("消息服务器ID不能为空");
        }
        
        if (request.getMessage().getMessageClientId() == null || request.getMessage().getMessageClientId().isEmpty()) {
            throw new IllegalArgumentException("消息客户端ID不能为空");
        }
        
        if (request.getMessage().getCreateTime() == null) {
            throw new IllegalArgumentException("消息创建时间不能为空");
        }
        
        // 转换请求为JSON字符串
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            MessageUrlContextV2.ADD_QUICK_COMMENT,
            MessageUrlContextV2.ADD_QUICK_COMMENT,
            null, // 无查询参数
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, AddQuickCommentResponseV2.class);
    }
    
    /**
     * Delete quick comment from a message
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
     * 
     * This method allows deleting emoji reactions or other quick comments from existing messages.
     * 
     * @param request request containing operator ID, message details, comment index, and optional configuration
     * @return result containing the timestamp when the comment was deleted
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<DeleteQuickCommentResponseV2> deleteQuickComment(
            DeleteQuickCommentRequestV2 request) throws YunxinSdkException {
        // Validate request parameters
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("Operator ID cannot be null or empty");
        }
        
        if (request.getIndex() == null || request.getIndex() <= 0) {
            throw new IllegalArgumentException("Comment type index must be greater than 0");
        }
        
        if (request.getMessage() == null) {
            throw new IllegalArgumentException("Message information cannot be null");
        }
        
        // Validate message details
        if (request.getMessage().getConversationType() == null) {
            throw new IllegalArgumentException("Conversation type cannot be null");
        }
        
        if (request.getMessage().getConversationType() < 1 || request.getMessage().getConversationType() > 3) {
            throw new IllegalArgumentException("Invalid conversation type: must be 1 (P2P), 2 (Advanced team), or 3 (Super team)");
        }
        
        if (request.getMessage().getSenderId() == null || request.getMessage().getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Message sender ID cannot be null or empty");
        }
        
        if (request.getMessage().getReceiverId() == null || request.getMessage().getReceiverId().isEmpty()) {
            throw new IllegalArgumentException("Message receiver ID cannot be null or empty");
        }
        
        if (request.getMessage().getMessageServerId() == null) {
            throw new IllegalArgumentException("Message server ID cannot be null");
        }
        
        if (request.getMessage().getMessageClientId() == null || request.getMessage().getMessageClientId().isEmpty()) {
            throw new IllegalArgumentException("Message client ID cannot be null or empty");
        }
        
        if (request.getMessage().getCreateTime() == null) {
            throw new IllegalArgumentException("Message creation time cannot be null");
        }
        
        // Convert request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            MessageUrlContextV2.DELETE_QUICK_COMMENT,
            MessageUrlContextV2.DELETE_QUICK_COMMENT,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, DeleteQuickCommentResponseV2.class);
    }
    
    /**
     * Batch query quick comments for multiple messages
     * 
     * API: POST https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
     * 
     * This method allows querying quick comments for multiple messages in a single request.
     * The response includes both successfully queried comments and any messages for which
     * the query failed.
     * 
     * @param request request containing a list of messages to query comments for
     * @return result containing lists of successful queries with comments and failed queries with error details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<BatchQueryQuickCommentsResponseV2> batchQueryQuickComments(
            BatchQueryQuickCommentsRequestV2 request) throws YunxinSdkException {
        // Validate request parameters
        if (request.getMessages() == null || request.getMessages().isEmpty()) {
            throw new IllegalArgumentException("Messages list cannot be null or empty");
        }
        

        
        // Validate each message in the list
        for (BatchQueryQuickCommentsRequestV2.Message message : request.getMessages()) {
            if (message.getConversationType() == null) {
                throw new IllegalArgumentException("Conversation type cannot be null for any message");
            }
            
            if (message.getConversationType() < 1 || message.getConversationType() > 3) {
                throw new IllegalArgumentException("Invalid conversation type: must be 1 (P2P), 2 (Advanced team), or 3 (Super team)");
            }
            
            if (message.getSenderId() == null || message.getSenderId().isEmpty()) {
                throw new IllegalArgumentException("Sender ID cannot be null or empty for any message");
            }
            
            if (message.getReceiverId() == null || message.getReceiverId().isEmpty()) {
                throw new IllegalArgumentException("Receiver ID cannot be null or empty for any message");
            }
            
            if (message.getMessageServerId() == null) {
                throw new IllegalArgumentException("Message server ID cannot be null for any message");
            }
            
            if (message.getMessageClientId() == null || message.getMessageClientId().isEmpty()) {
                throw new IllegalArgumentException("Message client ID cannot be null or empty for any message");
            }
            
            if (message.getCreateTime() == null) {
                throw new IllegalArgumentException("Message creation time cannot be null for any message");
            }
        }
        
        // Convert request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageUrlContextV2.BATCH_QUERY_QUICK_COMMENTS,
            MessageUrlContextV2.BATCH_QUERY_QUICK_COMMENTS,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryQuickCommentsResponseV2.class);
    }
} 