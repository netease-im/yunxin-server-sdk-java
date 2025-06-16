

## 快速开始（使用面向对象client）

```java
public class Test21 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.MEETING,appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinMeetingApiServices meetingApiServices = new YunxinMeetingApiServices(client);
        IMeetingUserService meetingUserService = meetingApiServices.getMeetingUserService();

        CreateMeetingAccountRequest request = new CreateMeetingAccountRequest();
        request.setUserUuid(UUID.randomUUID().toString().replace("-", ""));
        request.setName("zhangsan");
        MeetingResult<CreateMeetingAccountResponse> result = meetingUserService.createAccount(request);
        if (result.isSuccess()) {
            System.out.println(JSONObject.toJSONString(result.getResponse()));
        } else {
            System.out.println(JSONObject.toJSONString(result));
        }
    }
}

```