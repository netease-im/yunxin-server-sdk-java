

## 快速开始（使用面向对象client）

```java
public class Test19 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.NEROOM,appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinNeroomApiServices neroomApiServices = new YunxinNeroomApiServices(client);
        INeroomUserService neroomUserService = neroomApiServices.getNeroomUserService();

        CreateNeroomAccountRequest request = new CreateNeroomAccountRequest();
        request.setUserUuid(UUID.randomUUID().toString().replace("-", ""));
        NeroomResult<CreateNeroomAccountResponse> result = neroomUserService.createAccount(request);
        if (result.isSuccess()) {
            System.out.println(JSONObject.toJSONString(result.getResponse()));
        } else {
            System.out.println(JSONObject.toJSONString(result));
        }
    }
}
```