package com.netease.nim.server.sdk.im.v2.signal;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.signal.request.CreateSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.DelaySignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.CloseSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.QuerySignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.SendSignalRoomControlRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.InviteSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.CancelSignalRoomInviteRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.KickSignalRoomMemberRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CreateSIgnalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.DelaySignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CloseSignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.QuerySignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.SendSignalRoomControlResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.InviteSignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CancelSignalRoomInviteResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.KickSignalRoomMemberResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 信令服务实现 V2
 */
public class SignalV2Service implements ISignalV2Service {

    private final YunxinApiHttpClient httpClient;

    public SignalV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateSIgnalRoomResponseV2> createRoom(CreateSignalRoomRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            SignalV2UrlContext.CREATE_ROOM,
            SignalV2UrlContext.CREATE_ROOM,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateSIgnalRoomResponseV2.class);
    }

    @Override
    public Result<DelaySignalRoomResponseV2> delayRoom(DelaySignalRoomRequestV2 request) throws YunxinSdkException {
        // 构建查询参数
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("channel_id", request.getChannelId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PUT,
            SignalV2UrlContext.DELAY_ROOM,
            SignalV2UrlContext.DELAY_ROOM,
            queryParams,
            null // PUT请求没有请求体
        );
        
        return ResultUtils.convert(apiResponse, DelaySignalRoomResponseV2.class);
    }

    @Override
    public Result<CloseSignalRoomResponseV2> closeRoom(CloseSignalRoomRequestV2 request) throws YunxinSdkException {
        // 构建查询参数
        Map<String, String> queryParams = new HashMap<>();
        
        // 必选参数
        queryParams.put("channel_id", request.getChannelId());
        queryParams.put("operator_account_id", request.getOperatorAccountId());
        
        // 可选参数
        if (request.getServerExtension() != null) {
            queryParams.put("server_extension", request.getServerExtension());
        }
        if (request.getOfflineEnabled() != null) {
            queryParams.put("offline_enabled", request.getOfflineEnabled().toString());
        }
        if (request.getRouteEnabled() != null) {
            queryParams.put("route_enabled", request.getRouteEnabled().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            SignalV2UrlContext.CLOSE_ROOM,
            SignalV2UrlContext.CLOSE_ROOM,
            queryParams,
            null // DELETE请求没有请求体
        );
        
        return ResultUtils.convert(apiResponse, CloseSignalRoomResponseV2.class);
    }

    @Override
    public Result<QuerySignalRoomResponseV2> queryRoom(QuerySignalRoomRequestV2 request) throws YunxinSdkException {
        // 构建查询参数
        Map<String, String> queryParams = new HashMap<>();
        
        // channel_id和channel_name二选一，优先使用channel_id
        if (request.getChannelId() != null && !request.getChannelId().trim().isEmpty()) {
            queryParams.put("channel_id", request.getChannelId());
        } else if (request.getChannelName() != null && !request.getChannelName().trim().isEmpty()) {
            queryParams.put("channel_name", request.getChannelName());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            SignalV2UrlContext.QUERY_ROOM,
            SignalV2UrlContext.QUERY_ROOM,
            queryParams,
            null // GET请求没有请求体
        );
        
        return ResultUtils.convert(apiResponse, QuerySignalRoomResponseV2.class);
    }

    @Override
    public Result<SendSignalRoomControlResponseV2> sendControl(SendSignalRoomControlRequestV2 request) throws YunxinSdkException {
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            SignalV2UrlContext.SEND_CONTROL,
            SignalV2UrlContext.SEND_CONTROL,
            null, // POST请求没有查询参数
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, SendSignalRoomControlResponseV2.class);
    }

    @Override
    public Result<InviteSignalRoomResponseV2> invite(InviteSignalRoomRequestV2 request) throws YunxinSdkException {
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            SignalV2UrlContext.INVITE,
            SignalV2UrlContext.INVITE,
            null, // POST请求没有查询参数
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, InviteSignalRoomResponseV2.class);
    }

    @Override
    public Result<CancelSignalRoomInviteResponseV2> cancelInvite(CancelSignalRoomInviteRequestV2 request) throws YunxinSdkException {
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            SignalV2UrlContext.CANCEL_INVITE,
            SignalV2UrlContext.CANCEL_INVITE,
            null, // POST请求没有查询参数
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CancelSignalRoomInviteResponseV2.class);
    }

    @Override
    public Result<KickSignalRoomMemberResponseV2> kickMember(KickSignalRoomMemberRequestV2 request) throws YunxinSdkException {
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            SignalV2UrlContext.KICK_MEMBER,
            SignalV2UrlContext.KICK_MEMBER,
            null, // POST请求没有查询参数
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, KickSignalRoomMemberResponseV2.class);
    }

}
