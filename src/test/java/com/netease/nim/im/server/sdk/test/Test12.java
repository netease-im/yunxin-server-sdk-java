package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.rtc.YunxinRtcApiServices;
import com.netease.nim.server.sdk.rtc.room.IRtcRoomService;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCnameRequest;
import com.netease.nim.server.sdk.rtc.room.response.RtcGetRoomResponse;


/**
 * Created by caojiajun on 2025/6/13
 */
public class Test12 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.RTC, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinRtcApiServices services = new YunxinRtcApiServices(client);
        IRtcRoomService rtcRoomService = services.getRtcRoomService();

        //根据cname查询房间信息
        RtcGetRoomByCnameRequest request = new RtcGetRoomByCnameRequest();
        request.setCname("xxx");
        Result<RtcGetRoomResponse> result = rtcRoomService.getRoomByCname(request);
        if (result.getCode() != 200) {
            System.out.println(result.getCode());
        } else {
            RtcGetRoomResponse response = result.getResponse();
            System.out.println(JSONObject.toJSONString(response));
        }
    }
}
