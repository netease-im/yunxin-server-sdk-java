
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