package com.netease.nim.server.sdk.live.manage;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.live.manage.request.LiveCreateChannelRequest;
import com.netease.nim.server.sdk.live.manage.response.LiveCreateChannelResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public class LiveManageService implements ILiveManageService {

    private final YunxinApiHttpClient httpClient;

    public LiveManageService(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<LiveCreateChannelResponse> createChannel(LiveCreateChannelRequest request) {
        String jsonString = JSONObject.toJSONString(request);
        YunxinApiResponse apiResponse = httpClient.executeJson(HttpMethod.POST, LiveManageUrlContext.CREATE_CHANNEL, null, jsonString);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("msg"), null);
        }
        LiveCreateChannelResponse response = object.getObject("ret", LiveCreateChannelResponse.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
