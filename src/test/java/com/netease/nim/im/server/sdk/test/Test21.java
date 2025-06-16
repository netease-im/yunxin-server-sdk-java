package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.meeting.MeetingResult;
import com.netease.nim.server.sdk.meeting.YunxinMeetingApiServices;
import com.netease.nim.server.sdk.meeting.user.IMeetingUserService;
import com.netease.nim.server.sdk.meeting.user.request.CreateMeetingAccountRequest;
import com.netease.nim.server.sdk.meeting.user.response.CreateMeetingAccountResponse;

import java.util.UUID;


/**
 * Created by caojiajun on 2025/6/16
 */
public class Test21 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.MEETING, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        YunxinMeetingApiServices meetingApiServices = new YunxinMeetingApiServices(client);
        IMeetingUserService meetingUserService = meetingApiServices.getMeetingUserService();

        CreateMeetingAccountRequest request = new CreateMeetingAccountRequest();
        request.setUserUuid(UUID.randomUUID().toString().replace("-", ""));
        request.setName("zhangsan");
        MeetingResult<CreateMeetingAccountResponse> result = meetingUserService.createAccount(request);
        if (result.isSuccess()) {
            System.out.println(JSONObject.toJSONString(result.getResponse()));
        } else {
            System.out.println(JSONObject.toJSONString(result));
        }
    }
}
