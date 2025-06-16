package com.netease.nim.server.sdk.meeting.user;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.meeting.MeetingResult;
import com.netease.nim.server.sdk.meeting.user.request.CreateMeetingAccountRequest;
import com.netease.nim.server.sdk.meeting.user.response.CreateMeetingAccountResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public class MeetingUserService implements IMeetingUserService {

    private final YunxinApiHttpClient httpClient;

    public MeetingUserService(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public MeetingResult<CreateMeetingAccountResponse> createAccount(CreateMeetingAccountRequest request) {
        String jsonString = JSONObject.toJSONString(request);
        YunxinApiResponse response = httpClient.executeJson(HttpMethod.POST, MeetingUserUrlContext.CREATE_USER, null, jsonString);
        JSONObject json = JSONObject.parseObject(response.getData());
        Integer code = json.getInteger("code");
        String requestId = json.getString("requestId");
        String cost = json.getString("cost");
        Long ts = json.getLong("ts");
        String msg = json.getString("msg");
        if (code != 0) {
            return new MeetingResult<>(response.getEndpoint(), code, response.getTraceId(), requestId, ts, cost, msg, null);
        }
        CreateMeetingAccountResponse meetingAccountResponse = json.getObject("data", CreateMeetingAccountResponse.class);
        return new MeetingResult<>(response.getEndpoint(), code, response.getTraceId(), requestId, ts, cost, msg, meetingAccountResponse);
    }
}
