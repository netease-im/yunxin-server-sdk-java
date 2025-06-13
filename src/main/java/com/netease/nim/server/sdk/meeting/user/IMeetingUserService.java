package com.netease.nim.server.sdk.meeting.user;

import com.netease.nim.server.sdk.meeting.MeetingResult;
import com.netease.nim.server.sdk.meeting.user.request.CreateMeetingAccountRequest;
import com.netease.nim.server.sdk.meeting.user.response.CreateMeetingAccountResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface IMeetingUserService {

    MeetingResult<CreateMeetingAccountResponse> createAccount(CreateMeetingAccountRequest request);
}
