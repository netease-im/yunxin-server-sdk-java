package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.sms.ISmsApiService;
import com.netease.nim.server.sdk.sms.YunxinSmsApiServices;
import com.netease.nim.server.sdk.sms.request.SmsSendCodeRequest;
import com.netease.nim.server.sdk.sms.response.SmsSendCodeResponse;

/**
 * Created by caojiajun on 2025/6/16
 */
public class Test14 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.SMS, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinSmsApiServices services = new YunxinSmsApiServices(client);
        ISmsApiService smsApiService = services.getSmsApiService();

        //发送验证码短信
        SmsSendCodeRequest request = new SmsSendCodeRequest();
        request.setMobile("13012340000");
        Result<SmsSendCodeResponse> result = smsApiService.sendCode(request);
        if (result.getCode() != 200) {
            System.out.println(result.getCode());
        } else {
            SmsSendCodeResponse response = result.getResponse();
            System.out.println(JSONObject.toJSONString(response));
        }
    }
}
