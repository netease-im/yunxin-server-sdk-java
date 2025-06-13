package com.netease.nim.server.sdk.meeting;

import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.meeting.user.IMeetingUserService;
import com.netease.nim.server.sdk.meeting.user.MeetingUserService;

/**
 * Created by caojiajun on 2025/6/5
 */
public class YunxinMeetingApiServices {

    private final IMeetingUserService meetingUserService;

    public YunxinMeetingApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.meetingUserService = new MeetingUserService(yunxinApiHttpClient);
    }

    public IMeetingUserService getMeetingUserService() {
        return meetingUserService;
    }
}
