package com.netease.nim.im.server.sdk.v2.chatroom_queue;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.request.DeleteChatroomQueueRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.request.InitializeChatroomQueueRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.request.PollChatroomQueueElementRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.request.QueryChatroomQueueElementsRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.request.UpdateChatroomQueueRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.response.DeleteChatroomQueueResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.response.InitializeChatroomQueueResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.response.PollChatroomQueueElementResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.response.QueryChatroomQueueElementsResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_queue.response.UpdateChatroomQueueResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for Chatroom Queue V2 operations
 * 
 * This service provides methods for managing chatroom queues.
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class ChatroomQueueV2Service implements IChatroomQueueV2Service {

    private final YunxinApiHttpClient httpClient;

    /**
     * Constructor
     * 
     * @param httpClient the HTTP client to use for API calls
     */
    public ChatroomQueueV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Initialize a chatroom queue
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_queues/{room_id}
     * 
     * This method initializes a queue in the specified chatroom. Chatroom queues consist of
     * multiple key-value elements and are primarily used for scenarios such as voice chat room
     * connection and gift queue display in live streaming.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and queue configuration
     * @return result containing the operation result
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<InitializeChatroomQueueResponseV2> initializeChatroomQueue(InitializeChatroomQueueRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Prepare request body
        JSONObject requestBody = new JSONObject();
        
        if (request.getQueueSizeLimit() != null) {
            requestBody.put("queue_size_limit", request.getQueueSizeLimit());
        }
        
        if (request.getRouteConfig() != null) {
            JSONObject routeConfig = new JSONObject();
            
            if (request.getRouteConfig().getRouteEnabled() != null) {
                routeConfig.put("route_enabled", request.getRouteConfig().getRouteEnabled());
            }
            
            if (request.getRouteConfig().getRouteEnvironment() != null) {
                routeConfig.put("route_environment", request.getRouteConfig().getRouteEnvironment());
            }
            
            if (!routeConfig.isEmpty()) {
                requestBody.put("route_config", routeConfig);
            }
        }
        
        // Replace path parameter in the URL
        String endpoint = ChatroomQueueUrlContextV2.INITIALIZE_CHATROOM_QUEUE.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomQueueUrlContextV2.INITIALIZE_CHATROOM_QUEUE,
            endpoint,
            null, // No query parameters
            requestBody.isEmpty() ? "{}" : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, InitializeChatroomQueueResponseV2.class);
    }

    
    /**
     * Query specific elements in a chatroom queue
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_queues/{room_id}/actions/query
     * 
     * This method queries specific elements in a chatroom queue by their keys.
     * If no element keys are specified, all elements in the queue will be returned.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and element keys to query
     * @return result containing the queried queue elements
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<QueryChatroomQueueElementsResponseV2> queryChatroomQueueElements(QueryChatroomQueueElementsRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Prepare request body
        JSONObject requestBody = new JSONObject();
        
        if (request.getElementKeyList() != null && !request.getElementKeyList().isEmpty()) {
            requestBody.put("element_key_list", request.getElementKeyList());
        }
        
        if (request.getRouteConfig() != null) {
            JSONObject routeConfig = new JSONObject();
            
            if (request.getRouteConfig().getRouteEnabled() != null) {
                routeConfig.put("route_enabled", request.getRouteConfig().getRouteEnabled());
            }
            
            if (request.getRouteConfig().getRouteEnvironment() != null) {
                routeConfig.put("route_environment", request.getRouteConfig().getRouteEnvironment());
            }
            
            if (!routeConfig.isEmpty()) {
                requestBody.put("route_config", routeConfig);
            }
        }
        
        // Replace path parameter in the URL
        String endpoint = ChatroomQueueUrlContextV2.QUERY_CHATROOM_QUEUE_ELEMENTS.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomQueueUrlContextV2.QUERY_CHATROOM_QUEUE_ELEMENTS,
            endpoint,
            null, // No query parameters
            requestBody.isEmpty() ? "{}" : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, QueryChatroomQueueElementsResponseV2.class);
    }
    
    /**
     * Update chatroom queue by adding or updating elements
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_queues/{room_id}
     * 
     * This method updates a chatroom queue by adding or updating queue elements.
     * Elements can be added as new elements or update existing ones based on the specified policy.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID, operator account ID, and elements to add or update
     * @return result containing the operation result with lists of inserted and updated elements
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<UpdateChatroomQueueResponseV2> updateChatroomQueue(UpdateChatroomQueueRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().trim().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getElementList() == null || request.getElementList().isEmpty()) {
            throw new IllegalArgumentException("Element list cannot be null or empty");
        }
        
        // Validate each element in the list
        for (UpdateChatroomQueueRequestV2.QueueElement element : request.getElementList()) {
            if (element.getElementKey() == null || element.getElementKey().trim().isEmpty()) {
                throw new IllegalArgumentException("Element key cannot be null or empty");
            }
            
            if (element.getElementValue() == null || element.getElementValue().trim().isEmpty()) {
                throw new IllegalArgumentException("Element value cannot be null or empty");
            }
            
            if (element.getElementAddPolicy() != null && 
                (element.getElementAddPolicy() < 0 || element.getElementAddPolicy() > 2)) {
                throw new IllegalArgumentException("Element add policy must be 0, 1, or 2");
            }
        }
        
        // Prepare request body
        JSONObject requestBody = new JSONObject();
        
        // Add operator account ID
        requestBody.put("operator_account_id", request.getOperatorAccountId());
        
        // Add element list
        List<JSONObject> elementList = new ArrayList<>();
        for (UpdateChatroomQueueRequestV2.QueueElement element : request.getElementList()) {
            JSONObject elementJson = new JSONObject();
            elementJson.put("element_key", element.getElementKey());
            elementJson.put("element_value", element.getElementValue());
            
            if (element.getElementAccountId() != null) {
                elementJson.put("element_account_id", element.getElementAccountId());
            }
            
            if (element.getElementTransient() != null) {
                elementJson.put("element_transient", element.getElementTransient());
            }
            
            if (element.getElementAddPolicy() != null) {
                elementJson.put("element_add_policy", element.getElementAddPolicy());
            }
            
            elementList.add(elementJson);
        }
        
        requestBody.put("element_list", elementList);
        
        // Add notification config if available
        if (request.getNotificationConfig() != null) {
            JSONObject notificationConfig = new JSONObject();
            
            if (request.getNotificationConfig().getNotificationEnabled() != null) {
                notificationConfig.put("notification_enabled", request.getNotificationConfig().getNotificationEnabled());
            }
            
            if (request.getNotificationConfig().getNotificationExtension() != null) {
                notificationConfig.put("notification_extension", request.getNotificationConfig().getNotificationExtension());
            }
            
            if (request.getNotificationConfig().getHighPriority() != null) {
                notificationConfig.put("high_priority", request.getNotificationConfig().getHighPriority());
            }
            
            if (request.getNotificationConfig().getHighPriorityPolicy() != null) {
                notificationConfig.put("high_priority_policy", request.getNotificationConfig().getHighPriorityPolicy());
            }
            
            if (!notificationConfig.isEmpty()) {
                requestBody.put("notification_config", notificationConfig);
            }
        }
        
        // Add route config if available
        if (request.getRouteConfig() != null) {
            JSONObject routeConfig = new JSONObject();
            
            if (request.getRouteConfig().getRouteEnabled() != null) {
                routeConfig.put("route_enabled", request.getRouteConfig().getRouteEnabled());
            }
            
            if (request.getRouteConfig().getRouteEnvironment() != null) {
                routeConfig.put("route_environment", request.getRouteConfig().getRouteEnvironment());
            }
            
            if (!routeConfig.isEmpty()) {
                requestBody.put("route_config", routeConfig);
            }
        }
        
        // Replace path parameter in the URL
        String endpoint = ChatroomQueueUrlContextV2.UPDATE_CHATROOM_QUEUE.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomQueueUrlContextV2.UPDATE_CHATROOM_QUEUE,
            endpoint,
            null, // No query parameters
            requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, UpdateChatroomQueueResponseV2.class);
    }
    
    /**
     * Delete a chatroom queue
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/room_queues/{room_id}
     * 
     * This method deletes a queue in the specified chatroom.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and notification configuration
     * @return result containing information about the deleted queue
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<DeleteChatroomQueueResponseV2> deleteChatroomQueue(DeleteChatroomQueueRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }
        
        // Prepare request body
        JSONObject requestBody = new JSONObject();
        
        // Add notification config if available
        if (request.getNotificationConfig() != null) {
            JSONObject notificationConfig = new JSONObject();
            
            if (request.getNotificationConfig().getNotificationEnabled() != null) {
                notificationConfig.put("notification_enabled", request.getNotificationConfig().getNotificationEnabled());
            }
            
            if (request.getNotificationConfig().getNotificationExtension() != null) {
                notificationConfig.put("notification_extension", request.getNotificationConfig().getNotificationExtension());
            }
            
            if (request.getNotificationConfig().getHighPriority() != null) {
                notificationConfig.put("high_priority", request.getNotificationConfig().getHighPriority());
            }
            
            if (request.getNotificationConfig().getHighPriorityPolicy() != null) {
                notificationConfig.put("high_priority_policy", request.getNotificationConfig().getHighPriorityPolicy());
            }
            
            if (!notificationConfig.isEmpty()) {
                requestBody.put("notification_config", notificationConfig);
            }
        }
        
        // Add route config if available
        if (request.getRouteConfig() != null) {
            JSONObject routeConfig = new JSONObject();
            
            if (request.getRouteConfig().getRouteEnabled() != null) {
                routeConfig.put("route_enabled", request.getRouteConfig().getRouteEnabled());
            }
            
            if (request.getRouteConfig().getRouteEnvironment() != null) {
                routeConfig.put("route_environment", request.getRouteConfig().getRouteEnvironment());
            }
            
            if (!routeConfig.isEmpty()) {
                requestBody.put("route_config", routeConfig);
            }
        }
        
        // Replace path parameter in the URL
        String endpoint = ChatroomQueueUrlContextV2.DELETE_CHATROOM_QUEUE.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ChatroomQueueUrlContextV2.DELETE_CHATROOM_QUEUE,
            endpoint,
            null, // No query parameters
            requestBody.isEmpty() ? null : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, DeleteChatroomQueueResponseV2.class);
    }
    
    /**
     * Poll an element from a chatroom queue
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_queues/{room_id}/actions/poll
     * 
     * This method polls (retrieves and removes) an element from a chatroom queue.
     * If an element key is specified, that element will be polled.
     * If no element key is specified, the first element in the queue will be polled.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and optional element key to poll
     * @return result containing the polled element details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<PollChatroomQueueElementResponseV2> pollChatroomQueueElement(PollChatroomQueueElementRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getRoomId() == null) {
            throw new IllegalArgumentException("Chatroom ID cannot be null");
        }

        
        // Prepare request body
        JSONObject requestBody = new JSONObject();
        
        // Add element key if specified
        if (request.getElementKey() != null) {
            requestBody.put("element_key", request.getElementKey());
        }
        
        // Add notification config if available
        if (request.getNotificationConfig() != null) {
            JSONObject notificationConfig = new JSONObject();
            
            if (request.getNotificationConfig().getNotificationEnabled() != null) {
                notificationConfig.put("notification_enabled", request.getNotificationConfig().getNotificationEnabled());
            }
            
            if (request.getNotificationConfig().getNotificationExtension() != null) {
                notificationConfig.put("notification_extension", request.getNotificationConfig().getNotificationExtension());
            }
            
            if (request.getNotificationConfig().getHighPriority() != null) {
                notificationConfig.put("high_priority", request.getNotificationConfig().getHighPriority());
            }
            
            if (request.getNotificationConfig().getHighPriorityPolicy() != null) {
                notificationConfig.put("high_priority_policy", request.getNotificationConfig().getHighPriorityPolicy());
            }
            
            if (!notificationConfig.isEmpty()) {
                requestBody.put("notification_config", notificationConfig);
            }
        }
        
        // Add route config if available
        if (request.getRouteConfig() != null) {
            JSONObject routeConfig = new JSONObject();
            
            if (request.getRouteConfig().getRouteEnabled() != null) {
                routeConfig.put("route_enabled", request.getRouteConfig().getRouteEnabled());
            }
            
            if (request.getRouteConfig().getRouteEnvironment() != null) {
                routeConfig.put("route_environment", request.getRouteConfig().getRouteEnvironment());
            }
            
            if (!routeConfig.isEmpty()) {
                requestBody.put("route_config", routeConfig);
            }
        }
        
        // Replace path parameter in the URL
        String endpoint = ChatroomQueueUrlContextV2.POLL_CHATROOM_QUEUE_ELEMENT.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomQueueUrlContextV2.POLL_CHATROOM_QUEUE_ELEMENT,
            endpoint,
            null, // No query parameters
            requestBody.isEmpty() ? "{}" : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, PollChatroomQueueElementResponseV2.class);
    }
} 