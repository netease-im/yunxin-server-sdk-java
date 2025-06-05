## 快速开始（v1接口，使用面向对象client）

```java

import exception.core.com.netease.nim.server.sdk.YunxinSdkException;
import core.com.netease.nim.server.sdk.YunxinApiHttpClient;
import core.com.netease.nim.server.sdk.Result;
import v1.im.com.netease.nim.server.sdk.YunxinV1ApiServices;
import request.account.v1.im.com.netease.nim.server.sdk.CreateAccountRequestV1;
import response.account.v1.im.com.netease.nim.server.sdk.CreateAccountResponseV1;

/**
 * Created by caojiajun on 2024/12/11
 */
public class Test6 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        // 全局一个YunxinApiHttpClient实例即可，务必不要每次请求都build一次，以免产生资源泄漏
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV1ApiServices services = new YunxinV1ApiServices(client);

        // request
        CreateAccountRequestV1 request = new CreateAccountRequest();
        request.setAccid("zhangsan");
        try {
            Result<CreateAccountResponseV1> result = services.getAccountService().createAccount(request);
            if (result.isSuccess()) {
                CreateAccountResponseV1 response = result.getResponse();
                // 注册成功
                System.out.println("register success, accid=" + response.getAccid() + ", token=" + response.getToken() + ", traceId=" + result.getTraceId());
            } else {
                // 注册失败，如参数错误、重复注册等
                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
            }
        } catch (YunxinSdkException e) {//这是一个RuntimeException
            // 超时等异常
            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
        }
    }
}


```