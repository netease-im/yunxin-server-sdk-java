

## 快速开始（使用面向对象client）

```java
public class Test18 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.VOD,appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinVodApiServices vodApiServices = new YunxinVodApiServices(client);
        IVodUploadService vodUploadService = vodApiServices.getVodUploadService();

        VodUploadInitRequest request = new VodUploadInitRequest();
        request.setOriginFileName("xxxx");
        Result<VodUploadInitResponse> result = vodUploadService.uploadInit(request);
        if (result.isSuccess()) {
            System.out.println(JSONObject.toJSONString(result.getResponse()));
        } else {
            System.out.println(JSONObject.toJSONString(result));
        }
    }
}
```