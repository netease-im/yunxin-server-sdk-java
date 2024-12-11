package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkIOException;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinV1ApiHttpClient client = new YunxinV1ApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // 请求地址
        String path = "/user/create.action";

        // 请求参数
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accid", "zhangsan");

        // 执行请求
        YunxinV1ApiResponse response;
        try {
            response = client.execute(path, paramMap);
        } catch (YunxinSdkIOException e) {
            // 请求失败
            System.err.println("register error, traceId = " + e.getTraceId());
            return;
        }

        // 获取结果
        String data = response.getData();
        // 解析结果
        JSONObject json = JSONObject.parseObject(data);
        int code = json.getIntValue("code");
        if (code != 200) {
            // 注册失败
            System.err.println("register fail, response = " + data + ", traceId=" + response.getTraceId());
        } else {
            // 注册成功
            JSONObject info = json.getJSONObject("info");
            String accid = info.getString("accid");
            String token = info.getString("token");
            System.out.println("register success, accid = " + accid + ", token = " + token + ", traceId=" + response.getTraceId());
        }
    }
}
