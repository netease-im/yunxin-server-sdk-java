
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
            YunxinTraceId.set("your_trace_id");//设置本次请求的traceId
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

* sdk初始化时会通过云信的调度服务器下发实际使用的api域名
* 调度域名默认使用全球化加速的域名
* 如果希望限制调度域名的dns解析结果到特定地区，可以初始化时增加region参数配置，如下

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
* 需要注意的是，TimeoutSetter#setTimeout方法只对接下来的一次请求生效，之后的请求会恢复为默认超时配置
* 特别的，对于批量类型的接口，如批量发送消息，建议调大超时参数

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
            TimeoutSetter.setTimeout(10000);//设置本次请求为10s超时
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


### 关于代理

* sdk初始化时支持设置代理
* 可以使用Proxy，也可以使用ProxySelector

```java

public class Test6 {

    public static void main(String[] args) {
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;

        Proxy proxy = new Proxy(Proxy.Type.SOCKS, "10.0.0.0", 1080);

        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .proxy(proxy)
                .build();
    }
}

```

```java

public class Test6 {

    public static void main(String[] args) {
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;

        ProxySelector proxySelector = new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                // your custom logic
                return null;
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                // your custom logic
            }
        };

        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .proxySelector(proxySelector)
                .build();
    }
}

```