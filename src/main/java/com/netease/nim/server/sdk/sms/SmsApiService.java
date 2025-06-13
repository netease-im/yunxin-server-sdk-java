package com.netease.nim.server.sdk.sms;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.core.http.ParamBuilder;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.sms.request.SmsSendCodeRequest;
import com.netease.nim.server.sdk.sms.response.SmsSendCodeResponse;

import java.util.Map;

/**
 * Created by caojiajun on 2025/6/12
 */
public class SmsApiService implements ISmsApiService {

    private final YunxinApiHttpClient httpClient;

    public SmsApiService(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<SmsSendCodeResponse> sendCode(SmsSendCodeRequest request) {
        YunxinApiResponse apiResponse = httpClient.executeForm(HttpMethod.POST, SmsUrlContext.SEND_CODE, null, toData(request));
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, null);
        }
        Long sendid = object.getLong("msg");
        String authCode = object.getString("obj");
        SmsSendCodeResponse response = new SmsSendCodeResponse();
        response.setAuthCode(authCode);
        response.setSendid(sendid);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    private String toData(Object request) {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        ParamBuilder builder = new ParamBuilder();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            builder.addParam(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }
}
