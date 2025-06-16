
## 快速开始（使用raw-client）

```java
public class Test23 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.CUSTOM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .endpoint("https://rtc-ai.yunxinapi.com")
                .build();

        JSONObject request = new JSONObject();
        request.put("cname", "xx");
        request.put("taskType", 7);
        //other params

        YunxinApiResponse response = client.executeJson(HttpMethod.POST, "/v1/api/task/create", null, request.toJSONString());
        System.out.println(JSONObject.toJSONString(response));
    }
}
```