package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.rtc.RtcResult;
import com.netease.nim.server.sdk.rtc.YunxinRtcApiServices;
import com.netease.nim.server.sdk.rtc.room.IRtcRoomService;
import com.netease.nim.server.sdk.rtc.room.request.RtcCreateRoomRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCidRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCnameRequest;
import com.netease.nim.server.sdk.rtc.room.response.RtcCreateRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcGetRoomResponse;


/**
 * Created by caojiajun on 2025/6/13
 */
public class Test12 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xxxx";
        String appsecret = "xxx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.RTC, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinRtcApiServices services = new YunxinRtcApiServices(client);
        IRtcRoomService rtcRoomService = services.getRtcRoomService();

        {
            RtcCreateRoomRequest request = new RtcCreateRoomRequest();
            request.setChannelName("xxx");
            request.setMode(2);
            request.setUid(123L);
            RtcResult<RtcCreateRoomResponse> result = rtcRoomService.createRoom(request);
            if (result.isSuccess()) {
                System.out.println(JSONObject.toJSONString(result.getResponse()));
            } else {
                System.out.println(JSONObject.toJSONString(result));
            }
        }

        {
            //根据cname查询房间信息
            RtcGetRoomByCnameRequest request = new RtcGetRoomByCnameRequest();
            request.setCname("xxx");
            RtcResult<RtcGetRoomResponse> result = rtcRoomService.getRoomByCname(request);
            if (result.isSuccess()) {
                System.out.println(JSONObject.toJSONString(result.getResponse()));
            } else {
                System.out.println(JSONObject.toJSONString(result));
            }
        }

        {
            //根据cid查询房间信息
            RtcGetRoomByCidRequest request = new RtcGetRoomByCidRequest();
            request.setCid(123L);
            RtcResult<RtcGetRoomResponse> result = rtcRoomService.getRoomByCid(request);
            if (result.isSuccess()) {
                System.out.println(JSONObject.toJSONString(result.getResponse()));
            } else {
                System.out.println(JSONObject.toJSONString(result));
            }
        }
    }
}
