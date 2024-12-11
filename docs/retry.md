
## 重试机制

* 默认最大重试1次，可以自定义最大重试次数，如果设置为0，则表示不重试
* 默认重试策略为 `DefaultRetryPolicy.java` ，此时 `http.code=502` 或者 `连接超时` 时重试，否则不重试
* 内置了 `AlwaysRetryPolicy.java` 和 `NeverRetryPolicy.java` 重试策略，按需选择
* 你也可以自定义重试策略

```java
import com.netease.nim.im.server.sdk.core.endpoint.DefaultRetryPolicy;
import com.netease.nim.im.server.sdk.core.endpoint.RetryPolicy;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test2 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        // 重试次数可以自定义
        int maxRetry = 1;
        // RetryPolicy可以自定义
        boolean retryOn502 = true;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(retryOn502);
        //
        YunxinV1ApiHttpClient client = new YunxinV1ApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .maxRetry(maxRetry)
                .retryPolicy(retryPolicy)
                .build();

        //
    }
}


```
