package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.metrics.MetricsCallback;
import com.netease.nim.server.sdk.core.metrics.PrometheusConverter;
import com.netease.nim.server.sdk.core.metrics.Stats;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;

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
