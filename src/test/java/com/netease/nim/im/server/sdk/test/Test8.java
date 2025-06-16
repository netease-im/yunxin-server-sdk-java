package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.request.BatchQueryAccountsRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.UpdateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.BatchQueryAccountsResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.UpdateAccountResponseV2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caojiajun on 2024/12/11
 */
public class Test8 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV2ApiServices services = new YunxinV2ApiServices(client);

        //创建账号
        {
            CreateAccountRequestV2 request = new CreateAccountRequestV2();
            request.setAccountId("zhangsan");
            //
            CreateAccountRequestV2.Configuration configuration = new CreateAccountRequestV2.Configuration();
            configuration.setChatroomChatBanned(true);
            request.setConfiguration(configuration);
            CreateAccountRequestV2.UserInformation userInformation = new CreateAccountRequestV2.UserInformation();
            userInformation.setEmail("xxx@126.com");
            request.setUserInformation(userInformation);

            try {
                Result<CreateAccountResponseV2> result = services.getAccountService().createAccount(request);
                if (result.isSuccess()) {
                    CreateAccountResponseV2 response = result.getResponse();
                    // 注册成功
                    System.out.println("register success, response=" + JSONObject.toJSONString(response) + ", traceId=" + result.getTraceId());
                } else {
                    // 注册失败，如参数错误、重复注册等
                    System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
                }
            } catch (YunxinSdkException e) {//这是一个RuntimeException
                // 超时等异常
                System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
            }
        }

        //更新账号
        {
            UpdateAccountRequestV2 request = new UpdateAccountRequestV2();
            request.setAccountId("zhangsan");

            UpdateAccountRequestV2.Configuration configuration = new UpdateAccountRequestV2.Configuration();
            configuration.setP2pChatBanned(true);
            request.setConfiguration(configuration);

            request.setNeedKick(true);
            request.setKickNotifyExtension("xxxx");

            try {
                Result<UpdateAccountResponseV2> result = services.getAccountService().updateAccount(request);
                if (result.isSuccess()) {
                    UpdateAccountResponseV2 response = result.getResponse();
                    // 更新成功
                    System.out.println("update success, response=" + JSONObject.toJSONString(response) + ", traceId=" + result.getTraceId());
                } else {
                    // 更新失败，如参数错误等
                    System.err.println("update fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
                }
            } catch (YunxinSdkException e) {//这是一个RuntimeException
                // 超时等异常
                System.err.println("update error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
            }
        }

        //批量查询账号
        {
            BatchQueryAccountsRequestV2 request = new BatchQueryAccountsRequestV2();
            List<String> accountList = new ArrayList<>();
            accountList.add("zhangsan");
            accountList.add("lisi");
            request.setAccountList(accountList);
            try {
                Result<BatchQueryAccountsResponseV2> result = services.getAccountService().batchQueryAccounts(request);
                if (result.isSuccess()) {
                    BatchQueryAccountsResponseV2 response = result.getResponse();
                    // 查询结果
                    System.out.println("query success, success_list=" + JSONObject.toJSONString(response.getSuccessList()) + ", traceId=" + result.getTraceId());
                    System.out.println("query success, failed_list=" + JSONObject.toJSONString(response.getFailedList()) + ", traceId=" + result.getTraceId());
                } else {
                    // 查询失败，如参数错误等
                    System.err.println("query fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
                }
            } catch (YunxinSdkException e) {//这是一个RuntimeException
                // 超时等异常
                System.err.println("query error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
            }
        }
    }
}
