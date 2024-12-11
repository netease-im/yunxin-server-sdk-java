

## metrics

* 默认开启，可以关闭
* 支持配置统计周期
* 有2个维度，一个是endpoint维度，一个是uri维度，统计了请求的成功/失败数量，耗时的平均、最大、分位数（p50/p75/p90/p99/p999）
* 支持以prometheus格式输出，也支持自定义输出
* 可以定时获取数据，也可以使用MetricsCallback主动接受数据推送
* 数据字段参考 `Stats.java` 和 `PrometheusConverter.java`

```java

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.metrics.MetricsCallback;
import com.netease.nim.im.server.sdk.core.metrics.PrometheusConverter;
import com.netease.nim.im.server.sdk.core.metrics.Stats;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test4 {
    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        MetricsCallback metricsCallback = stats -> {
            System.out.println("receive stats callback");
            System.out.println(JSONObject.toJSONString(stats));
        };
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .metricEnable(true)//默认true
                .metricCollectIntervalSeconds(60)//默认60s
                .metricsCallback(metricsCallback)//
                .build();

        //你可以60s调用一次getStats方法获取数据，也可以用MetricsCallback获取数据

        //java-bean形式暴露，可以自定义格式输出到监控系统
        Stats stats = client.getStats();
        System.out.println(JSONObject.toJSONString(stats));

        //转换为prometheus格式
        String string = PrometheusConverter.convert(stats);
        System.out.println(string);
    }
}


```

