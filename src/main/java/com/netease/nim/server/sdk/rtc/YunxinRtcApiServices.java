package com.netease.nim.server.sdk.rtc;

import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.rtc.room.IRtcRoomService;
import com.netease.nim.server.sdk.rtc.room.RtcRoomService;

/**
 * Created by caojiajun on 2025/6/12
 */
public class YunxinRtcApiServices {

    private final IRtcRoomService rtcRoomService;

    public YunxinRtcApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.rtcRoomService = new RtcRoomService(yunxinApiHttpClient);
    }

    public IRtcRoomService getRtcRoomService() {
        return rtcRoomService;
    }
}
