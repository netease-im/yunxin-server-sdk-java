package com.netease.nim.server.sdk.im.v2.chatroom_queue;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.DeleteChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.InitializeChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.PollChatroomQueueElementRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.QueryChatroomQueueElementsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.UpdateChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.DeleteChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.InitializeChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.PollChatroomQueueElementResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.QueryChatroomQueueElementsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.UpdateChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.ArrayList;
import java.util.List;

public class ChatroomQueueV2Service implements IChatroomQueueV2Service {

    private final YunxinApiHttpClient httpClient;

    public ChatroomQueueV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

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
        String path = ChatroomQueueV2UrlContext.INITIALIZE_CHATROOM_QUEUE.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomQueueV2UrlContext.INITIALIZE_CHATROOM_QUEUE,
            path,
            null, // No query parameters
            requestBody.isEmpty() ? "{}" : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, InitializeChatroomQueueResponseV2.class);
    }


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
        String path = ChatroomQueueV2UrlContext.QUERY_CHATROOM_QUEUE_ELEMENTS.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            ChatroomQueueV2UrlContext.QUERY_CHATROOM_QUEUE_ELEMENTS,
            path,
            null, // No query parameters
            requestBody.isEmpty() ? "{}" : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, QueryChatroomQueueElementsResponseV2.class);
    }
    
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
        String path = ChatroomQueueV2UrlContext.UPDATE_CHATROOM_QUEUE.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomQueueV2UrlContext.UPDATE_CHATROOM_QUEUE,
            path,
            null, // No query parameters
            requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, UpdateChatroomQueueResponseV2.class);
    }

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
        String path = ChatroomQueueV2UrlContext.DELETE_CHATROOM_QUEUE.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            ChatroomQueueV2UrlContext.DELETE_CHATROOM_QUEUE,
            path,
            null, // No query parameters
            requestBody.isEmpty() ? null : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, DeleteChatroomQueueResponseV2.class);
    }

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
        String path = ChatroomQueueV2UrlContext.POLL_CHATROOM_QUEUE_ELEMENT.replace("{room_id}", request.getRoomId().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            ChatroomQueueV2UrlContext.POLL_CHATROOM_QUEUE_ELEMENT,
            path,
            null, // No query parameters
            requestBody.isEmpty() ? "{}" : requestBody.toString()
        );
        
        return ResultUtils.convert(apiResponse, PollChatroomQueueElementResponseV2.class);
    }
} 