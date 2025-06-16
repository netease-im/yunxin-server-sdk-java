package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.live.YunxinLiveApiServices;
import com.netease.nim.server.sdk.live.manage.ILiveManageService;
import com.netease.nim.server.sdk.live.manage.request.LiveCreateChannelRequest;
import com.netease.nim.server.sdk.live.manage.response.LiveCreateChannelResponse;

/**
 * Created by caojiajun on 2025/6/16
 */
public class Test16 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.LIVE, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinLiveApiServices services = new YunxinLiveApiServices(client);
        ILiveManageService liveManageService = services.getLiveManageService();

        //创建频道
        LiveCreateChannelRequest request = new LiveCreateChannelRequest();
        request.setName("xxxx");
        request.setType(0);
        Result<LiveCreateChannelResponse> result = liveManageService.createChannel(request);
        if (result.getCode() != 200) {
            System.out.println(result.getCode());
        } else {
            LiveCreateChannelResponse response = result.getResponse();
            System.out.println(JSONObject.toJSONString(response));
        }
    }
}
