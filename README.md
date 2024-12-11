# 云信im-server-sdk

## 核心特性

* 基于okhttp封装了云信服务器api的sdk
* 支持重试，支持配置不同的重试策略，也支持自定义重试策略
* 支持多域名高可用，故障自动切换
* 支持trace-id，方便问题排查
* 支持metrics，支持prometheus格式输出
* 支持使用raw-client直接发起请求，也支持使用面向对象的client发起请求
* 支持云信的v1-api，也支持v2-api
* 支持云信私有化环境使用

## 架构图

<img src="docs/img.png" width="60%" height="60%">

## 快速开始（v1接口，使用raw-client）

```java
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
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
        } catch (YunxinSdkException e) {//这是一个RuntimeException
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



```

## 快速开始（v1接口，使用面向对象client）

```java

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.Result;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequest;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponse;

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
            Result<CreateAccountResponse> result = services.getAccountService().createAccount(request);
            if (result.isSuccess()) {
                CreateAccountResponse response = result.getResponse();
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

所有模块见：

* [账号](docs/v1/account.md)
* [消息](docs/v1/message.md)
* [群组](docs/v1/team.md)
* [聊天室](docs/v1/chatroom.md)


## 快速开始（v2接口，使用raw-client）

todo


## 快速开始（v2接口，使用面向对象client）

todo


## 关于重试

具体见：[retry](docs/retry.md)


## 关于多域名

具体见：[endpoint](docs/endpoint.md)


## 关于监控

具体见：[metrics](docs/metrics.md)


## 关于私有化

具体见：[privatization](docs/privatization.md)