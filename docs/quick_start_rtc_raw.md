
## 快速开始（使用raw-client）

```java
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
```

* rtc相关api，http.code和业务code均可能非200，需要同时处理