
## 重试机制

* 重试机制由三个部分组成，分别是最大重试次数（最多允许128次）、重试策略、重试间隔，由 `RetryPolicy.java` 定义
* 你可以自定义 `RetryPolicy.java`, 默认为 `DefaultRetryPolicy.java`，此时重试逻辑如下：
* 默认最大重试为：`1` 次，可以自定义最大重试次数，如果设置为 `0` ，则表示不重试
* IM、LIVE、VOD、MEETING、NEROOM，以上BizName，默认重试策略为：`http.code=502` 或者 `连接超时` 时重试，否则不重试
* RTC、SMS、CUSTOM，以上BizName，默认重试策略为：`连接超时` 时重试，否则不重试
* 默认重试间隔为：第一次重试没有间隔，之后重试间隔依次为 `5, 10, 50, 100, 500, 1000, 5000` ，超过则固定为5000ms

### RetryPolicy接口定义

```java
public interface RetryPolicy {

    long[] intervalArray = new long[]{0, 5, 10, 50, 100, 500, 1000, 5000};

    /**
     * 最大重试次数，0 代表不重试
     * 最大允许设置 128，如果超过 128 实际生效最多 128
     * @return 次数
     */
    default int maxRetry() {
        return 1;
    }

    /**
     * 重试间隔，单位ms
     * @param retryContext 重试上下文
     * @param retry 第几次重试，从0开始
     * @return 间隔
     */
    default long retryInterval(ExecuteContext retryContext, int retry) {
        if (retry >= intervalArray.length) {
            return intervalArray[intervalArray.length - 1];
        }
        return intervalArray[retry];
    }


    /**
     * 是否要重试
     * @param retryContext 重试上下文
     * @param retry 第几次重试，从0开始
     * @param error 依次
     * @return 重试操作
     */
    default RetryAction onError(ExecuteContext retryContext, int retry, Throwable error) {
        return RetryAction.NO_RETRY;
    }
}
```

### 初始化时设置自定义RetryPolicy

```java
public class Test2 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        // RetryPolicy可以自定义
        int maxRetry = 1;
        boolean retryOn502 = true;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(maxRetry, retryOn502);
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .retryPolicy(retryPolicy)
                .build();

        //
    }
}


```
