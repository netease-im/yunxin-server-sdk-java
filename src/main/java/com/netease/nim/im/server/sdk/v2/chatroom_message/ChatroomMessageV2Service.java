package com.netease.nim.im.server.sdk.v2.chatroom_message;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.BatchSendChatroomMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.RecallChatroomMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.SendChatroomMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.QueryChatroomHistoryMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.BatchSendChatroomMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.QueryChatroomHistoryMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.RecallChatroomMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.SendChatroomMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Chatroom Message V2 operations
 * 
 * This service provides methods for sending messages to chatrooms.
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class ChatroomMessageV2Service implements IChatroomMessageV2Service {

    private final YunxinApiHttpClient httpClient;

    /**
     * Constructor
     * 
     * @param httpClient the HTTP client to use for API calls
     */
    public ChatroomMessageV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Send a message to a chatroom (Compatibility method)
     * 
     * This is a backward compatibility method that takes the roomId as a separate parameter.
     * It creates a request object with the roomId and delegates to the new method.
     * 
     * @param roomId the ID of the chatroom
     * @param request the request containing message details
     * @return result containing the sent message information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    public Result<SendChatroomMessageResponseV2> sendChatroomMessage(Long roomId, SendChatroomMessageRequestV2 request) throws YunxinSdkException {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        // Set the roomId on the request
        request.setRoomId(roomId);
        
        // Call the new method
        return sendChatroomMessage(request);
    }
    
    /**
     * Send a message to a chatroom
     * 
     * API: POST https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/messages
     * 
     * This method sends a message to a chatroom. It supports various message types including
     * text, image, audio, video, location, file, tip, and custom messages. It also supports
     * sending directed messages (specifying message recipients) and spatial messages (specifying
     * spatial coordinates for recipients).
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * Chatroom message rate limiting mechanism:
     * - Regular messages: Each user can receive up to 20 messages per second.
     *   Messages exceeding this limit may be randomly dropped.
     * - High priority messages: Each user can receive up to 10 high priority messages per second.
     *   Messages exceeding this limit may be dropped.
     * 
     * Note on directed messages:
     * - Directed messages (when receiverIds is not empty) are not stored as history
     * - Directed messages do not support the messageConfig parameter
     * - Directed messages do not support spatial coordinates parameters
     * 
     * @param request the request containing chatroom ID and message details
     * @return result containing the sent message information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<SendChatroomMessageResponseV2> sendChatroomMessage(SendChatroomMessageRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getMessage() == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        
        if (request.getMessage().getMessageClientId() == null || request.getMessage().getMessageClientId().isEmpty()) {
            throw new IllegalArgumentException("Message client ID cannot be null or empty");
        }
        
        if (request.getMessage().getMessageType() == null) {
            throw new IllegalArgumentException("Message type cannot be null");
        }
        
        // Validate message content based on type
        Integer messageType = request.getMessage().getMessageType();
        if ((messageType == 0 || messageType == 10) && 
            (request.getMessage().getText() == null || request.getMessage().getText().isEmpty())) {
            throw new IllegalArgumentException("Text is required for text messages (type 0) and tip messages (type 10)");
        }
        
        if (messageType != 0 && messageType != 10 && request.getMessage().getAttachment() == null) {
            throw new IllegalArgumentException("Attachment is required for non-text/tip messages");
        }
        
        // Check for incompatible directed message features
        if (request.getReceiverIds() != null && !request.getReceiverIds().isEmpty()) {
            if (request.getMessageConfig() != null) {
                throw new IllegalArgumentException("Directed messages do not support message_config parameter");
            }
            
            if (request.getMessage().getLocationX() != null || 
                request.getMessage().getLocationY() != null || 
                request.getMessage().getLocationZ() != null) {
                throw new IllegalArgumentException("Directed messages do not support spatial coordinates parameters");
            }
        }
        
        // Check if custom message subtype is specified when required
        if (messageType == 100 && request.getMessage().getSubType() == null) {
            throw new IllegalArgumentException("Sub type is required for custom messages (type 100)");
        }
        
        // Check antispam configuration for custom messages
        if (messageType == 100 && 
            request.getAntispamConfig() != null && 
            Boolean.TRUE.equals(request.getAntispamConfig().getAntispamCustomMessageEnabled()) &&
            (request.getAntispamConfig().getAntispamCustomMessage() == null || 
             request.getAntispamConfig().getAntispamCustomMessage().isEmpty())) {
            throw new IllegalArgumentException("antispam_custom_message is required when antispam_custom_message_enabled is true");
        }
        
        // Replace the path parameter in the URL
        String endpoint = ChatroomMessageUrlContextV2.SEND_CHATROOM_MESSAGE.replace("{room_id}", request.getRoomId().toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomMessageUrlContextV2.SEND_CHATROOM_MESSAGE,
            endpoint,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendChatroomMessageResponseV2.class);
    }
    
    /**
     * Batch send messages to a chatroom
     * 
     * API: POST https://open.yunxinapi.com/im/v2/chatrooms/messages
     * 
     * This method sends multiple messages to a chatroom in a single request.
     * It supports batch sending of various message types including text, image, audio, video,
     * location, file, tip, and custom messages. It also supports sending directed messages
     * (specifying message recipients) and spatial messages.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * Message limitations:
     * - Maximum 20 messages can be sent in a single batch request
     * - Each message's size should not exceed 5KB
     * 
     * Chatroom message rate limiting mechanism:
     * - Regular messages: Each user can receive up to 20 messages per second.
     *   Messages exceeding this limit may be randomly dropped.
     * - High priority messages: Each user can receive up to 10 high priority messages per second.
     *   Messages exceeding this limit may be dropped.
     * 
     * @param request the request containing the chatroom ID, sender ID, and list of messages
     * @return result containing the sent message information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<BatchSendChatroomMessagesResponseV2> batchSendChatroomMessages(BatchSendChatroomMessagesRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getMessages() == null || request.getMessages().isEmpty()) {
            throw new IllegalArgumentException("Messages list cannot be null or empty");
        }
        
        if (request.getMessages().size() > 20) {
            throw new IllegalArgumentException("Maximum 20 messages can be sent in a single batch request");
        }
        
        // Validate each message in the batch
        for (int i = 0; i < request.getMessages().size(); i++) {
            BatchSendChatroomMessagesRequestV2.MessageBody message = request.getMessages().get(i);
            
            if (message.getMessageClientId() == null || message.getMessageClientId().isEmpty()) {
                throw new IllegalArgumentException("Message client ID cannot be null or empty (message index: " + i + ")");
            }
            
            if (message.getMessageType() == null) {
                throw new IllegalArgumentException("Message type cannot be null (message index: " + i + ")");
            }
            
            // Validate message content based on type
            Integer messageType = message.getMessageType();
            if ((messageType == 0 || messageType == 10) && 
                (message.getText() == null || message.getText().isEmpty())) {
                throw new IllegalArgumentException("Text is required for text messages (type 0) and tip messages (type 10) (message index: " + i + ")");
            }
            
            if (messageType != 0 && messageType != 10 && message.getAttachment() == null) {
                throw new IllegalArgumentException("Attachment is required for non-text/tip messages (message index: " + i + ")");
            }
            
            // Check if custom message subtype is specified when required
            if (messageType == 100 && message.getSubType() == null) {
                throw new IllegalArgumentException("Sub type is required for custom messages (type 100) (message index: " + i + ")");
            }
        }
        
        // Check for incompatible directed message features
        if (request.getReceiverIds() != null && !request.getReceiverIds().isEmpty()) {
            if (request.getMessageConfig() != null) {
                throw new IllegalArgumentException("Directed messages do not support message_config parameter");
            }
            
            // Check spatial coordinates for directed messages
            for (int i = 0; i < request.getMessages().size(); i++) {
                BatchSendChatroomMessagesRequestV2.MessageBody message = request.getMessages().get(i);
                if (message.getLocationX() != null || 
                    message.getLocationY() != null || 
                    message.getLocationZ() != null) {
                    throw new IllegalArgumentException("Directed messages do not support spatial coordinates parameters (message index: " + i + ")");
                }
            }
        }
        
        // Check antispam configuration for custom messages
        if (request.getAntispamConfig() != null && 
            Boolean.TRUE.equals(request.getAntispamConfig().getAntispamCustomMessageEnabled()) &&
            (request.getAntispamConfig().getAntispamCustomMessage() == null || 
             request.getAntispamConfig().getAntispamCustomMessage().isEmpty())) {
            throw new IllegalArgumentException("antispam_custom_message is required when antispam_custom_message_enabled is true");
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomMessageUrlContextV2.BATCH_SEND_CHATROOM_MESSAGES,
            ChatroomMessageUrlContextV2.BATCH_SEND_CHATROOM_MESSAGES,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchSendChatroomMessagesResponseV2.class);
    }

    /**
     * Recall or delete a chatroom message (Compatibility method)
     * 
     * This is a backward compatibility method that accepts individual parameters.
     * It creates a RecallChatroomMessageRequestV2 object and delegates to the new method.
     * 
     * @param roomId the ID of the chatroom
     * @param messageClientId the client ID of the message to recall/delete
     * @param operatorId the ID of the account performing the recall/delete operation
     * @param senderId the ID of the account that originally sent the message
     * @param createTime the timestamp when the message was created
     * @param notificationEnabled whether to send a notification (true for recall, false for delete)
     * @param notificationExtension optional extension field for the notification, JSON format,
     *                             max 1024 characters, only effective when notificationEnabled=true
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    public Result<Void> recallOrDeleteChatroomMessage(
            Long roomId,
            String messageClientId,
            String operatorId,
            String senderId,
            Long createTime,
            Boolean notificationEnabled,
            String notificationExtension) throws YunxinSdkException {
        
        // Create a request object
        RecallChatroomMessageRequestV2 request = new RecallChatroomMessageRequestV2();
        request.setRoomId(roomId);
        request.setMessageClientId(messageClientId);
        request.setOperatorId(operatorId);
        request.setSenderId(senderId);
        request.setCreateTime(createTime);
        request.setNotificationEnabled(notificationEnabled);
        request.setNotificationExtension(notificationExtension);
        
        // Call the new method and ignore its response data
        Result<RecallChatroomMessageResponseV2> result = recallChatroomMessage(request);
        
        // Create an empty Result with the same code and message
        return new Result<Void>(result.getEndpoint(), result.getCode(), result.getTraceId(), result.getMsg(), null);
    }
    
    /**
     * Recall or delete a chatroom message
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/messages/{message_client_id}
     * 
     * This method can recall or delete a message in a chatroom based on the notification_enabled parameter:
     * - When notification_enabled=true: It's a recall operation and a notification will be sent to clients.
     * - When notification_enabled=false: It's a delete operation and no notification will be sent.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing the recall parameters
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<RecallChatroomMessageResponseV2> recallChatroomMessage(RecallChatroomMessageRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getMessageClientId() == null || request.getMessageClientId().isEmpty()) {
            throw new IllegalArgumentException("Message client ID cannot be null or empty");
        }
        
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("Operator ID cannot be null or empty");
        }
        
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getCreateTime() == null) {
            throw new IllegalArgumentException("Create time cannot be null");
        }
        
        if (request.getNotificationEnabled() == null) {
            throw new IllegalArgumentException("Notification enabled cannot be null");
        }
        
        // Validate notification extension if specified for recall operation
        if (Boolean.TRUE.equals(request.getNotificationEnabled()) && 
            request.getNotificationExtension() != null && 
            request.getNotificationExtension().length() > 1024) {
            throw new IllegalArgumentException("Notification extension cannot exceed 1024 characters");
        }
        
        // Replace path parameters in the URL
        String endpoint = ChatroomMessageUrlContextV2.RECALL_OR_DELETE_CHATROOM_MESSAGE
                .replace("{room_id}", request.getRoomId().toString())
                .replace("{message_client_id}", request.getMessageClientId());
        
        // Prepare query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("operator_id", request.getOperatorId());
        queryParams.put("sender_id", request.getSenderId());
        queryParams.put("create_time", request.getCreateTime().toString());
        queryParams.put("notification_enabled", request.getNotificationEnabled().toString());
        
        if (Boolean.TRUE.equals(request.getNotificationEnabled()) && 
            request.getNotificationExtension() != null && 
            !request.getNotificationExtension().isEmpty()) {
            queryParams.put("notification_extension", request.getNotificationExtension());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ChatroomMessageUrlContextV2.RECALL_OR_DELETE_CHATROOM_MESSAGE,
            endpoint,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, RecallChatroomMessageResponseV2.class);
    }
    
    /**
     * Query chatroom history messages with pagination
     * 
     * API: GET https://open.yunxinapi.com/im/v2/chatrooms/{room_id}/messages
     * 
     * This method retrieves the historical messages of a specific account in a chatroom.
     * It supports pagination, filtering by message type, and sorting by time.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing query parameters for fetching history messages
     * @return result containing the paginated history messages
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<QueryChatroomHistoryMessagesResponseV2> queryChatroomHistoryMessages(
            QueryChatroomHistoryMessagesRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getSenderId() == null || request.getSenderId().isEmpty()) {
            throw new IllegalArgumentException("Sender ID cannot be null or empty");
        }
        
        if (request.getLimit() == null) {
            throw new IllegalArgumentException("Limit cannot be null");
        }
        
        if (request.getLimit() <= 0 || request.getLimit() > 100) {
            throw new IllegalArgumentException("Limit must be between 1 and 100");
        }
        
        // Replace path parameter in the URL
        String endpoint = ChatroomMessageUrlContextV2.QUERY_CHATROOM_HISTORY_MESSAGES.replace("{room_id}", request.getRoomId().toString());
        
        // Prepare query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("sender_id", request.getSenderId());
        queryParams.put("limit", request.getLimit().toString());
        
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getDescending() != null) {
            queryParams.put("descending", request.getDescending().toString());
        }
        
        if (request.getMessageTypes() != null && !request.getMessageTypes().isEmpty()) {
            queryParams.put("message_type", request.getMessageTypes());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            ChatroomMessageUrlContextV2.QUERY_CHATROOM_HISTORY_MESSAGES,
            endpoint,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryChatroomHistoryMessagesResponseV2.class);
    }
} 