package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/11
 */
public class Test7 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // 创建账号
        {

            String uri = "/im/v2/accounts";//仅仅用于统计
            String path = "/im/v2/accounts";

            JSONObject request = new JSONObject();
            request.put("account_id", "zhangsan");

            YunxinApiResponse response;
            try {
                response = client.executeV2Api(HttpMethod.POST, uri, path, null, request.toString());
            } catch (YunxinSdkException e) {//这是一个RuntimeException
                // 请求失败
                System.err.println("register error, traceId = " + e.getTraceId());
                return;
            }

            // 获取结果
            String responseData = response.getData();
            // 解析结果
            JSONObject json = JSONObject.parseObject(responseData);
            int code = json.getIntValue("code");
            if (code != 200) {
                // 注册失败
                System.err.println("register fail, response = " + responseData + ", traceId=" + response.getTraceId());
            } else {
                // 注册成功
                JSONObject data = json.getJSONObject("data");
                String accid = data.getString("account_id");
                String token = data.getString("token");
                System.out.println("register success, accid = " + accid + ", token = " + token + ", traceId=" + response.getTraceId());
            }
        }

        // 更新账号
        {
            String uri = "/im/v2/accounts/{account_id}";//仅仅用于统计
            String path = "/im/v2/accounts/zhangsan";

            JSONObject request = new JSONObject();
            request.put("token", "abc");

            YunxinApiResponse response;
            try {
                response = client.executeV2Api(HttpMethod.PATCH, uri, path, null, request.toString());
            } catch (YunxinSdkException e) {//这是一个RuntimeException
                // 请求失败
                System.err.println("update error, traceId = " + e.getTraceId());
                return;
            }

            // 获取结果
            String responseData = response.getData();
            // 解析结果
            JSONObject json = JSONObject.parseObject(responseData);
            int code = json.getIntValue("code");
            if (code != 200) {
                // 更新失败
                System.err.println("update fail, response = " + responseData + ", traceId=" + response.getTraceId());
            } else {
                // 更新成功
                JSONObject data = json.getJSONObject("data");
                String accid = data.getString("account_id");
                String token = data.getString("token");
                System.out.println("update success, accid = " + accid + ", token = " + token + ", traceId=" + response.getTraceId());
            }
        }

        // 批量查询账号信息
        {
            String uri = "/im/v2/accounts";//仅仅用于统计
            String path = "/im/v2/accounts";

            Map<String, String> queryString = new HashMap<>();
            queryString.put("account_ids", "account1,account2,account3");

            YunxinApiResponse response;
            try {
                response = client.executeV2Api(HttpMethod.GET, uri, path, queryString, null);
            } catch (YunxinSdkException e) {//这是一个RuntimeException
                // 请求失败
                System.err.println("query error, traceId = " + e.getTraceId());
                return;
            }

            // 获取结果
            String responseData = response.getData();
            // 解析结果
            JSONObject json = JSONObject.parseObject(responseData);
            int code = json.getIntValue("code");
            if (code != 200) {
                // 查询失败
                System.err.println("query fail, response = " + responseData + ", traceId=" + response.getTraceId());
            } else {
                // 查询成功
                JSONObject data = json.getJSONObject("data");
                JSONArray successList = data.getJSONArray("success_list");
                System.out.println("success_list = " + successList);
                JSONArray failedList = data.getJSONArray("failed_list");
                System.out.println("failed_list = " + failedList);
            }
        }
    }
}
