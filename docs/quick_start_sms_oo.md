

## 快速开始（使用面向对象client）

```java
public class Test14 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.SMS, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinSmsApiServices services = new YunxinSmsApiServices(client);
        ISmsApiService smsApiService = services.getSmsApiService();

        //发送验证码短信
        SmsSendCodeRequest request = new SmsSendCodeRequest();
        request.setMobile("13012340000");
        Result<SmsSendCodeResponse> result = smsApiService.sendCode(request);
        if (result.getCode() != 200) {
            System.out.println(result.getCode());
        } else {
            SmsSendCodeResponse response = result.getResponse();
            System.out.println(JSONObject.toJSONString(response));
        }
    }
}
```