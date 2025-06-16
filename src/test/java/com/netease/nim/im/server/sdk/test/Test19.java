package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.neroom.NeroomResult;
import com.netease.nim.server.sdk.neroom.YunxinNeroomApiServices;
import com.netease.nim.server.sdk.neroom.user.INeroomUserService;
import com.netease.nim.server.sdk.neroom.user.request.CreateNeroomAccountRequest;
import com.netease.nim.server.sdk.neroom.user.response.CreateNeroomAccountResponse;

import java.util.UUID;

/**
 * Created by caojiajun on 2025/6/16
 */
public class Test19 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.NEROOM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinNeroomApiServices neroomApiServices = new YunxinNeroomApiServices(client);
        INeroomUserService neroomUserService = neroomApiServices.getNeroomUserService();

        CreateNeroomAccountRequest request = new CreateNeroomAccountRequest();
        request.setUserUuid(UUID.randomUUID().toString().replace("-", ""));
        NeroomResult<CreateNeroomAccountResponse> result = neroomUserService.createAccount(request);
        if (result.isSuccess()) {
            System.out.println(JSONObject.toJSONString(result.getResponse()));
        } else {
            System.out.println(JSONObject.toJSONString(result));
        }
    }
}
