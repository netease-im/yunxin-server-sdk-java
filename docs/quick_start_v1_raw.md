
## 快速开始（v1接口，使用raw-client）

```java
import com.alibaba.fastjson2.JSONObject;
import exception.core.com.netease.nim.server.sdk.YunxinSdkException;
import core.com.netease.nim.server.sdk.YunxinApiHttpClient;
import core.com.netease.nim.server.sdk.YunxinApiResponse;

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
        // 全局一个YunxinApiHttpClient实例即可，务必不要每次请求都build一次，以免产生资源泄漏
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // 请求地址
        String path = "/user/create.action";

        // 请求参数
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accid", "zhangsan");

        // 执行请求
        YunxinApiResponse response;
        try {
            response = client.executeV1Api(path, paramMap);
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