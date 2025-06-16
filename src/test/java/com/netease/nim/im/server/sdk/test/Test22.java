package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;

import java.util.UUID;

/**
 * Created by caojiajun on 2025/6/16
 */
public class Test22 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.MEETING, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        JSONObject request = new JSONObject();
        request.put("userUuid", UUID.randomUUID().toString().replace("-", ""));
        request.put("name", "zhangsan");

        YunxinApiResponse response = client.executeJson(HttpMethod.POST, "/scene/meeting/api/v2/add-user", null, request.toJSONString());
        JSONObject json = JSONObject.parseObject(response.getData());
        Integer code = json.getInteger("code");
        if (code != 0) {
            System.out.println(json);
        } else {
            System.out.println(json.getJSONObject("data"));
        }
    }
}
