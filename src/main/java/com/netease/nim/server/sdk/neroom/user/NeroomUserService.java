package com.netease.nim.server.sdk.neroom.user;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.neroom.NeroomResult;
import com.netease.nim.server.sdk.neroom.user.request.CreateNeroomAccountRequest;
import com.netease.nim.server.sdk.neroom.user.response.CreateNeroomAccountResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public class NeroomUserService implements INeroomUserService {

    private final YunxinApiHttpClient httpClient;

    public NeroomUserService(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public NeroomResult<CreateNeroomAccountResponse> createAccount(CreateNeroomAccountRequest request) {
        String jsonString = JSONObject.toJSONString(request);
        YunxinApiResponse response = httpClient.executeJson(HttpMethod.POST, NeroomUserUrlContext.CREATE_USER, null, jsonString);
        JSONObject json = JSONObject.parseObject(response.getData());
        Integer code = json.getInteger("code");
        String requestId = json.getString("request_id");
        Long cost = json.getLong("cost");
        Long ts = json.getLong("ts");
        String msg = json.getString("msg");
        if (code != 200) {
            return new NeroomResult<>(response.getEndpoint(), code, response.getTraceId(), requestId, ts, cost, msg, null);
        }
        CreateNeroomAccountResponse neroomAccountResponse = json.getObject("data", CreateNeroomAccountResponse.class);
        return new NeroomResult<>(response.getEndpoint(), code, response.getTraceId(), requestId, ts, cost, msg, neroomAccountResponse);
    }
}
