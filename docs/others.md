
## 杂七杂八

### 关于traceId

* 默认每次请求会自动随机生产一个traceId，如果想要指定，则可以请求之前调用如下方法 `YunxinTraceId.set(xxx)`
* 特别需要注意的，务必每次请求选择不同的traceId，因为云信服务器会根据traceId做请求的去重

```java


/**
 * Created by caojiajun on 2024/12/11
 */
public class Test6 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV1ApiServices services = new YunxinV1ApiServices(client);

        // request
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid("zhangsan");
        try {
            Result<CreateAccountResponseV1> result = services.getAccountService().createAccount(request);
            if (result.isSuccess()) {
                CreateAccountResponseV1 response = result.getResponse();
                // 注册成功
                System.out.println("register success, accid=" + response.getAccid() + ", token=" + response.getToken() + ", traceId=" + result.getTraceId());
            } else {
                // 注册失败，如参数错误、重复注册等
                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
            }
        } catch (YunxinSdkException e) {//这是一个RuntimeException
            // 超时等异常
            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
        }
    }
}

```


### 关于sdk的调度

* sdk初始化时会通过云信服务器下发实际使用的api域名
* 调度域名默认使用全球化加速的域名
* 如果希望限制调度服务的地区，可以初始化时增加region参数配置，如下

```java
public class Test9 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .region(Region.SG)//限制调度服务域名的地区，默认可以不填
                .build();
    }
}

```

### 关于超时

* sdk初始化时会配置接口的超时参数
* 如果对于某一次请求希望单独修改超时参数，则可以使用TimeoutSetter#setTimeout方法进行

```java
public class Test6 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV1ApiServices services = new YunxinV1ApiServices(client);

        // request
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid("zhangsan");
        try {
            Result<CreateAccountResponseV1> result = services.getAccountService().createAccount(request);
            if (result.isSuccess()) {
                CreateAccountResponseV1 response = result.getResponse();
                // 注册成功
                System.out.println("register success, accid=" + response.getAccid() + ", token=" + response.getToken() + ", traceId=" + result.getTraceId());
            } else {
                // 注册失败，如参数错误、重复注册等
                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
            }
        } catch (YunxinSdkException e) {//这是一个RuntimeException
            // 超时等异常
            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
        }
    }
}

```