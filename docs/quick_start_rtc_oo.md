
## 快速开始（使用面向对象client）

```java
public class Test12 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.RTC, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinRtcApiServices services = new YunxinRtcApiServices(client);
        IRtcRoomService rtcRoomService = services.getRtcRoomService();

        //根据cname查询房间信息
        RtcGetRoomByCnameRequest request = new RtcGetRoomByCnameRequest();
        request.setCname("xxx");
        Result<RtcGetRoomResponse> result = rtcRoomService.getRoomByCname(request);
        if (result.getCode() != 200) {
            System.out.println(result.getCode());
        } else {
            RtcGetRoomResponse response = result.getResponse();
            System.out.println(JSONObject.toJSONString(response));
        }
    }
}
```