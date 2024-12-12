
## 杂七杂八

### 关于traceId

* 默认每次请求会自动随机生产一个traceId，如果想要指定，则可以请求之前调用如下方法 `YunxinTraceId.set(xxx)`
* 特别需要注意的，务必每次请求选择不同的traceId，因为云信服务器会根据traceId做请求的去重

```java
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;

import java.util.UUID;

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
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV1ApiServices services = new YunxinV1ApiServices(client);

        // request
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid("zhangsan");
        try {
            //调用之前可以手动设置traceId
            //特别需要注意的，务必每次请求选择不同的traceId，因为云信服务器可能根据traceId做请求的去重
            YunxinTraceId.set(UUID.randomUUID().toString().replace("-", ""));
            //
            Result<CreateAccountResponseV1> result = services.getAccountService().createAccount(request);
            //...
        } catch (YunxinSdkException e) {
            //...
        }
    }
}
```


### 关于sdk的调度

* sdk初始化时会通过云信服务器下发实际使用的api域名
* 调度域名默认使用全球化加速的域名
* 如果希望限制调度服务的地区，可以初始化时增加region参数配置，如下

```java
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.endpoint.Region;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test9 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .region(Region.SG)//限制调度服务域名的地区，默认可以不填
                .build();
    }
}

```