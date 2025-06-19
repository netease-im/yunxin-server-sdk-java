package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2025/6/13
 */
public class Test11 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xxx";
        String appsecret = "xxx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.RTC, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        //根据cname查询房间信息
        Map<String, String> queryString = new HashMap<>();
        queryString.put("cname", "xxxxx");
        YunxinApiResponse response = client.executeJson(HttpMethod.GET, "/v3/api/rooms", queryString, null);
        int httpCode = response.getHttpCode();
        if (httpCode != 200) {
            System.out.println(JSONObject.toJSONString(response));
        } else {
            JSONObject jsonObject = JSONObject.parseObject(response.getData());
            Integer code = jsonObject.getInteger("code");
            if (code != 200) {
                System.out.println(response.getData());
            } else {
                System.out.println(jsonObject);
            }
        }
    }
}
