
## 快速开始（使用raw-client）

```java
public class Test20 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.NEROOM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        JSONObject request = new JSONObject();
        request.put("user_uuid", UUID.randomUUID().toString().replace("-", ""));
        YunxinApiResponse response = client.executeJson(HttpMethod.POST, "/neroom/v3/users", null, request.toJSONString());
        JSONObject json = JSONObject.parseObject(response.getData());
        Integer code = json.getInteger("code");
        if (code != 200) {
            System.out.println(json);
        } else {
            System.out.println(json.getJSONObject("data"));
        }
    }
}
```