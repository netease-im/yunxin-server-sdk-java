

## 快速开始（使用面向对象client）

```java
public class Test16 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.LIVE, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinLiveApiServices services = new YunxinLiveApiServices(client);
        ILiveManageService liveManageService = services.getLiveManageService();

        //创建频道
        LiveCreateChannelRequest request = new LiveCreateChannelRequest();
        request.setName("xxxx");
        request.setType(0);
        Result<LiveCreateChannelResponse> result = liveManageService.createChannel(request);
        if (result.getCode() != 200) {
            System.out.println(result.getCode());
        } else {
            LiveCreateChannelResponse response = result.getResponse();
            System.out.println(JSONObject.toJSONString(response));
        }
    }
}
```