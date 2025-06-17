
## 快速开始（使用面向对象client）

```java
public class Test12 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xxx";
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
            request.setUid(123);
            Result<RtcCreateRoomResponse> result = rtcRoomService.createRoom(request);
            System.out.println(JSONObject.toJSONString(result));
        }

        {
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
}
```