
## 快速开始（使用面向对象client）

```java
public class Test12 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xxxx";
        String appsecret = "xxx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.RTC, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinRtcApiServices services = new YunxinRtcApiServices(client);
        IRtcRoomService rtcRoomService = services.getRtcRoomService();

        {
            RtcCreateRoomRequest request = new RtcCreateRoomRequest();
            request.setChannelName("xxx");
            request.setMode(2);
            request.setUid(123L);
            RtcResult<RtcCreateRoomResponse> result = rtcRoomService.createRoom(request);
            if (result.isSuccess()) {
                System.out.println(JSONObject.toJSONString(result.getResponse()));
            } else {
                System.out.println(JSONObject.toJSONString(result));
            }
        }

        {
            //根据cname查询房间信息
            RtcGetRoomByCnameRequest request = new RtcGetRoomByCnameRequest();
            request.setCname("xxx");
            RtcResult<RtcGetRoomResponse> result = rtcRoomService.getRoomByCname(request);
            if (result.isSuccess()) {
                System.out.println(JSONObject.toJSONString(result.getResponse()));
            } else {
                System.out.println(JSONObject.toJSONString(result));
            }
        }

        {
            //根据cid查询房间信息
            RtcGetRoomByCidRequest request = new RtcGetRoomByCidRequest();
            request.setCid(123L);
            RtcResult<RtcGetRoomResponse> result = rtcRoomService.getRoomByCid(request);
            if (result.isSuccess()) {
                System.out.println(JSONObject.toJSONString(result.getResponse()));
            } else {
                System.out.println(JSONObject.toJSONString(result));
            }
        }
    }
}
```

* rtc相关api，http.code和业务code均可能非200，需要同时处理