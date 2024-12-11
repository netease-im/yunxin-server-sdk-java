package com.netease.nim.im.server.sdk.v1.account;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.Result;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiResponse;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequest;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/11
 */
public class AccountService implements IAccountService {

    private final YunxinV1ApiHttpClient httpClient;

    public AccountService(YunxinV1ApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Result<CreateAccountResponse> createAccount(CreateAccountRequest request) throws YunxinSdkException {
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
        YunxinV1ApiResponse apiResponse = httpClient.execute("/user/create.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        CreateAccountResponse response = new CreateAccountResponse();
        JSONObject info = object.getJSONObject("info");
        response.setAccid(info.getString("accid"));
        response.setName(info.getString("name"));
        response.setToken(info.getString("token"));
        return new Result<>(code, apiResponse.getTraceId(), null, response);
    }

}
