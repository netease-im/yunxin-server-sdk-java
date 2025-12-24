package com.netease.nim.server.sdk.im.v2.ai;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.ai.request.ChatAssistRequestV2;
import com.netease.nim.server.sdk.im.v2.ai.response.ChatAssistResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

public class AiService implements IAiSerivce{
    private final YunxinApiHttpClient yunxinApiHttpClient;

    public AiService(YunxinApiHttpClient yunxinApiHttpClient) {
        this.yunxinApiHttpClient = yunxinApiHttpClient;
    }

    @Override
    public Result<ChatAssistResponseV2> chatAssist(ChatAssistRequestV2 request) throws YunxinSdkException {
        String body = JSON.toJSONString(request);
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(HttpMethod.POST, AiUrlContext.CHAT_ASSIST_URL, AiUrlContext.CHAT_ASSIST_URL,null, body);
        return ResultUtils.convert(apiResponse,ChatAssistResponseV2.class);
    }
}
