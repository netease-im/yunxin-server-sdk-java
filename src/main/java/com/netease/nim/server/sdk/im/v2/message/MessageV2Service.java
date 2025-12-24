package com.netease.nim.server.sdk.im.v2.message;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.message.request.AddQuickCommentRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.BatchQueryMessagesByIdRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.BatchQueryQuickCommentsRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.BatchSendP2PMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.DeleteConversationMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.DeleteQuickCommentRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.ModifyMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.QueryMessagesByPageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.QueryMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.QueryTeamReadReceiptRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.QueryThreadMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.SearchMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.SendMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.SendP2PReadReceiptRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.SendTeamReadReceiptRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.WithdrawMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.response.AddQuickCommentResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.BatchQueryMessagesByIdResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.BatchQueryQuickCommentsResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.BatchSendP2PMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.DeleteConversationMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.DeleteQuickCommentResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.ModifyMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.QueryMessagesByPageResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.QueryMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.QueryTeamReadReceiptResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.QueryThreadMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.SearchMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.SendMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.SendP2PReadReceiptResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.SendTeamReadReceiptResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.WithdrawMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;


import com.netease.nim.server.sdk.im.v2.message.request.StreamMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.response.StreamMessageResponseV2;

public class MessageV2Service implements IMessageV2Service {

    private final YunxinApiHttpClient httpClient;

    public MessageV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<StreamMessageResponseV2> streamMessage(StreamMessageRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();
        String path = MessageV2UrlContext.STREAM_MESSAGE.replace("{conversation_id}", conversationId);
        String requestBody = JSONObject.toJSONString(request);
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.STREAM_MESSAGE,
            path,
            null,
            requestBody
        );
        return ResultUtils.convert(apiResponse, StreamMessageResponseV2.class);
    }

    public Result<SendMessageResponseV2> sendMessage(SendMessageRequestV2 request) throws YunxinSdkException {
        String conversationId = request.getConversationId();

        // Replace the path parameter in the URL
        String path = MessageV2UrlContext.SEND_MESSAGE.replace("{conversation_id}", conversationId);
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.SEND_MESSAGE,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendMessageResponseV2.class);
    }

    @Override
    public Result<BatchSendP2PMessageResponseV2> batchSendP2PMessage(BatchSendP2PMessageRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.BATCH_SEND_P2P_MESSAGE,
            MessageV2UrlContext.BATCH_SEND_P2P_MESSAGE,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchSendP2PMessageResponseV2.class);
    }

    @Override
    public Result<ModifyMessageResponseV2> modifyMessage(ModifyMessageRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.MODIFY_MESSAGE,
            MessageV2UrlContext.MODIFY_MESSAGE,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, ModifyMessageResponseV2.class);
    }
    
    @Override
    public Result<WithdrawMessageResponseV2> withdrawMessage(WithdrawMessageRequestV2 request) throws YunxinSdkException {
        // Replace path parameters in the URL
        String path = MessageV2UrlContext.WITHDRAW_MESSAGE
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
        
        if (request.getIgnoreRevokeTime() != null) {
            queryParams.put("ignore_revoke_time", request.getIgnoreRevokeTime().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            MessageV2UrlContext.WITHDRAW_MESSAGE,
            path,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, WithdrawMessageResponseV2.class);
    }

    @Override
    public Result<DeleteConversationMessagesResponseV2> deleteConversationMessages(
            DeleteConversationMessagesRequestV2 request) throws YunxinSdkException {
        // Replace path parameter in the URL
        String path = MessageV2UrlContext.DELETE_CONVERSATION_MESSAGES
                .replace("{conversation_id}", request.getConversationId());
        
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("type", request.getType().toString());
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            MessageV2UrlContext.DELETE_CONVERSATION_MESSAGES,
            path,
            queryParams,
            null // No request body for DELETE
        );
        
        return ResultUtils.convert(apiResponse, DeleteConversationMessagesResponseV2.class);
    }
    
    @Override
    public Result<SendP2PReadReceiptResponseV2> sendP2PReadReceipt(
            SendP2PReadReceiptRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.SEND_P2P_READ_RECEIPT,
            MessageV2UrlContext.SEND_P2P_READ_RECEIPT,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendP2PReadReceiptResponseV2.class);
    }

    @Override
    public Result<SendTeamReadReceiptResponseV2> sendTeamReadReceipt(
            SendTeamReadReceiptRequestV2 request) throws YunxinSdkException {
            
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.SEND_TEAM_READ_RECEIPT,
            MessageV2UrlContext.SEND_TEAM_READ_RECEIPT,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendTeamReadReceiptResponseV2.class);
    }

    @Override
    public Result<QueryTeamReadReceiptResponseV2> queryTeamReadReceipt(
            QueryTeamReadReceiptRequestV2 request) throws YunxinSdkException {

        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_id", request.getTeamId().toString());
        queryParams.put("team_type", request.getTeamType().toString());
        queryParams.put("sender_id", request.getSenderId());
        queryParams.put("message_server_id", request.getMessageServerId().toString());
        
        if (request.getSnapshot() != null) {
            queryParams.put("snapshot", request.getSnapshot().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MessageV2UrlContext.QUERY_TEAM_READ_RECEIPT,
            MessageV2UrlContext.QUERY_TEAM_READ_RECEIPT,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryTeamReadReceiptResponseV2.class);
    }

    @Override
    public Result<QueryMessageResponseV2> queryMessage(
            QueryMessageRequestV2 request) throws YunxinSdkException {

        // Replace path parameters in the URL
        String path = MessageV2UrlContext.QUERY_MESSAGE
                .replace("{conversation_id}", request.getConversationId())
                .replace("{message_server_id}", request.getMessageServerId().toString());

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
            MessageV2UrlContext.QUERY_MESSAGE,
            path,
            queryParams,
            null // No request body for GET
        );
        
        // Log the raw API response for debugging
        System.out.println("Raw API response: " + JSONObject.toJSONString(apiResponse));
        
        return ResultUtils.convert(apiResponse, QueryMessageResponseV2.class);
    }
    
    @Override
    public Result<SearchMessagesResponseV2> searchMessages(SearchMessagesRequestV2 request) throws YunxinSdkException {
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
        
        if (request.getKeywordList() != null && !request.getKeywordList().isEmpty()) {
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
            MessageV2UrlContext.SEARCH_MESSAGES,
            MessageV2UrlContext.SEARCH_MESSAGES,
            queryParams,
            null // No request body for GET request
        );
        
        return ResultUtils.convert(apiResponse, SearchMessagesResponseV2.class);
    }
    
    @Override
    public Result<QueryMessagesByPageResponseV2> queryMessagesByPage(
            QueryMessagesByPageRequestV2 request) throws YunxinSdkException {

        // Replace path parameter in the URL
        String path = MessageV2UrlContext.QUERY_CONVERSATION_MESSAGES
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
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MessageV2UrlContext.QUERY_CONVERSATION_MESSAGES,
            path,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryMessagesByPageResponseV2.class);
    }
    
    @Override
    public Result<BatchQueryMessagesByIdResponseV2> batchQueryMessages(
            BatchQueryMessagesByIdRequestV2 request) throws YunxinSdkException {

        // Replace path parameter in the URL
        String path = MessageV2UrlContext.BATCH_QUERY_MESSAGES
                .replace("{conversation_id}", request.getConversationId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        

        System.out.println("Request body: " + requestBody);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.BATCH_QUERY_MESSAGES,
            path,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryMessagesByIdResponseV2.class);
    }
    
    @Override
    public Result<QueryThreadMessagesResponseV2> queryThreadMessages(
            QueryThreadMessagesRequestV2 request) throws YunxinSdkException {
        
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
            MessageV2UrlContext.QUERY_THREAD_MESSAGES,
            MessageV2UrlContext.QUERY_THREAD_MESSAGES,
            queryParams,
            null // No request body for GET
        );
        
        return ResultUtils.convert(apiResponse, QueryThreadMessagesResponseV2.class);
    }
    
    @Override
    public Result<AddQuickCommentResponseV2> addQuickComment(
            AddQuickCommentRequestV2 request) throws YunxinSdkException {

        // 转换请求为JSON字符串
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            MessageV2UrlContext.ADD_QUICK_COMMENT,
            MessageV2UrlContext.ADD_QUICK_COMMENT,
            null, // 无查询参数
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, AddQuickCommentResponseV2.class);
    }

    @Override
    public Result<DeleteQuickCommentResponseV2> deleteQuickComment(
            DeleteQuickCommentRequestV2 request) throws YunxinSdkException {
        // Convert request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            MessageV2UrlContext.DELETE_QUICK_COMMENT,
            MessageV2UrlContext.DELETE_QUICK_COMMENT,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, DeleteQuickCommentResponseV2.class);
    }
    
    @Override
    public Result<BatchQueryQuickCommentsResponseV2> batchQueryQuickComments(
            BatchQueryQuickCommentsRequestV2 request) throws YunxinSdkException {

        // Convert request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MessageV2UrlContext.BATCH_QUERY_QUICK_COMMENTS,
            MessageV2UrlContext.BATCH_QUERY_QUICK_COMMENTS,
            null, // No query parameters
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryQuickCommentsResponseV2.class);
    }
} 