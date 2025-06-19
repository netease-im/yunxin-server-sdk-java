package com.netease.nim.server.sdk.rtc.room;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.rtc.RtcResult;
import com.netease.nim.server.sdk.rtc.room.request.RtcCreateRoomRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCidRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCnameRequest;
import com.netease.nim.server.sdk.rtc.room.response.RtcCreateRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcGetRoomResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2025/6/12
 */
public class RtcRoomService implements IRtcRoomService {

    private final YunxinApiHttpClient httpClient;

    public RtcRoomService(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public RtcResult<RtcCreateRoomResponse> createRoom(RtcCreateRoomRequest request) {
        String body = JSONObject.toJSONString(request);
        YunxinApiResponse response = httpClient.executeJson(HttpMethod.POST, RtcRoomUrlContext.CREATE_ROOM, null, body);
        int httpCode = response.getHttpCode();
        int code = 0;
        String requestId = null;
        String msg;
        RtcCreateRoomResponse createRoomResponse = null;
        try {
            JSONObject json = JSONObject.parseObject(response.getData());
            code = json.getIntValue("code");
            requestId = json.getString("requestId");
            msg = json.getString("errmsg");
            createRoomResponse = JSONObject.parseObject(response.getData(), RtcCreateRoomResponse.class);
        } catch (Exception e) {
            msg = response.getData();
        }
        return new RtcResult<>(response.getEndpoint(), code, httpCode, requestId, response.getTraceId(), msg, createRoomResponse);
    }

    @Override
    public RtcResult<RtcGetRoomResponse> getRoomByCid(RtcGetRoomByCidRequest request) {
        String path = RtcRoomUrlContext.GET_ROOM_BY_CID.replace("{cid}", String.valueOf(request.getCid()));
        YunxinApiResponse response = httpClient.executeJson(HttpMethod.GET, RtcRoomUrlContext.GET_ROOM_BY_CID, path, null, null);
        int httpCode = response.getHttpCode();
        int code = 0;
        String requestId = null;
        String msg;
        RtcGetRoomResponse getRoomResponse = null;
        try {
            JSONObject json = JSONObject.parseObject(response.getData());
            code = json.getIntValue("code");
            requestId = json.getString("requestId");
            msg = json.getString("errmsg");
            getRoomResponse = JSONObject.parseObject(response.getData(), RtcGetRoomResponse.class);
        } catch (Exception e) {
            msg = response.getData();
        }
        return new RtcResult<>(response.getEndpoint(), code, httpCode, requestId, response.getTraceId(), msg, getRoomResponse);
    }

    @Override
    public RtcResult<RtcGetRoomResponse> getRoomByCname(RtcGetRoomByCnameRequest request) {
        Map<String, String> queryString = new HashMap<>();
        queryString.put("cname", request.getCname());
        YunxinApiResponse response = httpClient.executeJson(HttpMethod.GET, RtcRoomUrlContext.GET_ROOM_BY_CNAME, queryString, null);
        int httpCode = response.getHttpCode();
        int code = 0;
        String requestId = null;
        String msg;
        RtcGetRoomResponse getRoomResponse = null;
        try {
            JSONObject json = JSONObject.parseObject(response.getData());
            code = json.getIntValue("code");
            requestId = json.getString("requestId");
            msg = json.getString("errmsg");
            getRoomResponse = JSONObject.parseObject(response.getData(), RtcGetRoomResponse.class);
        } catch (Exception e) {
            msg = response.getData();
        }
        return new RtcResult<>(response.getEndpoint(), code, httpCode, requestId, response.getTraceId(), msg, getRoomResponse);
    }
}
