package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.core.http.ParamBuilder;

/**
 * Created by caojiajun on 2025/6/16
 */
public class Test13 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.SMS, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        //发送短信验证码
        ParamBuilder builder = new ParamBuilder();
        builder.addParam("mobile", "13012340000");
        YunxinApiResponse apiResponse = client.executeForm(HttpMethod.POST, "/sendcode.action", null, builder.build());
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            System.out.println(JSONObject.toJSONString(apiResponse));
        } else {
            Long sendid = object.getLong("msg");
            String authCode = object.getString("obj");
            System.out.println("sendid=" + sendid + ",authcode=" + authCode);
        }
    }
}
