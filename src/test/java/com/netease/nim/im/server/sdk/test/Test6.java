package com.netease.nim.im.server.sdk.test;

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkIOException;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequest;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponse;
import com.netease.nim.im.server.sdk.v1.exception.YunxinSdkCodeException;

/**
 * Created by caojiajun on 2024/12/11
 */
public class Test6 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinV1ApiHttpClient client = new YunxinV1ApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV1ApiServices services = new YunxinV1ApiServices(client);

        // request
        CreateAccountRequest request = new CreateAccountRequest();
        request.setAccid("zhangsan");
        try {
            CreateAccountResponse response = services.getAccountService().createAccount(request);
            // 注册成功
            System.out.println("register success, accid = " + response.getAccid() + ", token = " + response.getAccid() + ", traceId=" + response.getTraceId());
        } catch (YunxinSdkIOException e) {
            // 超时等异常
            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
        } catch (YunxinSdkCodeException e) {
            // 错误码异常，如已经注册
            System.err.println("register fail, code=" + e.getCode() + ", endpoint = " + e.getEndpoint() + ", traceId=" + e.getTraceId() + ", msg=" + e.getMsg());
        } catch (YunxinSdkException e) {
            // 未知异常
            System.err.println("register error, traceId=" + e.getTraceId());
        }
    }
}
