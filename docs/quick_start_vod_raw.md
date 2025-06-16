
## 快速开始（使用raw-client）

```java
public class Test17 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.VOD, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        JSONObject request = new JSONObject();
        request.put("originFileName", "xxxx");
        YunxinApiResponse apiResponse = client.executeJson(HttpMethod.POST, "/app/vod/upload/init", null, request.toJSONString());
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            System.out.println(object);
        } else {
            JSONObject ret = object.getJSONObject("ret");
            System.out.println(ret);
        }
    }
}

```