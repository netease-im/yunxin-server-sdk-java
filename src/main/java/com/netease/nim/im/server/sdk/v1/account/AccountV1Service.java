package com.netease.nim.im.server.sdk.v1.account;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/11
 */
public class AccountV1Service implements IAccountV1Service {

    private final YunxinApiHttpClient httpClient;

    public AccountV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateAccountResponseV1> createAccount(CreateAccountRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accid", request.getAccid());
        if (request.getToken() != null) {
            paramMap.put("token", request.getToken());
        }
        if (request.getName() != null) {
            paramMap.put("name", request.getName());
        }
        if (request.getIcon() != null) {
            paramMap.put("icon", request.getIcon());
        }
        if (request.getSign() != null) {
            paramMap.put("sign", request.getSign());
        }
        if (request.getEmail() != null) {
            paramMap.put("email", request.getEmail());
        }
        if (request.getBirth() != null) {
            paramMap.put("birth", request.getBirth());
        }
        if (request.getMobile() != null) {
            paramMap.put("mobile", request.getMobile());
        }
        if (request.getGender() != null) {
            paramMap.put("gender", request.getGender());
        }
        if (request.getEx() != null) {
            paramMap.put("ex", request.getEx());
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/create.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        CreateAccountResponseV1 response = new CreateAccountResponseV1();
        JSONObject info = object.getJSONObject("info");
        response.setAccid(info.getString("accid"));
        response.setName(info.getString("name"));
        response.setToken(info.getString("token"));
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

}
