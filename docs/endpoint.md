

## 多域名切换机制

* 内置了多个api域名，并且会定时从云信服务器更新最新api域名列表
* sdk会定时探测各个api域名
* sdk会根据各个api域名的请求结果和探测结果来动态调度（选择延迟最低、成功率最高的api域名）
* 默认切换机制参考：`DynamicEndpointSelector.java` ，你也可以自定义

```java
import com.netease.nim.im.server.sdk.core.endpoint.*;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test3 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        // EndpointSelector可以自定义
        EndpointSelector endpointSelector = new DynamicEndpointSelector(new DynamicEndpointFetcher(appkey));
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .endpointSelector(endpointSelector)
                .build();

        //
    }
}

```
