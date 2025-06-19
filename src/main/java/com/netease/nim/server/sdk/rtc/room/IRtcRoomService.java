package com.netease.nim.server.sdk.rtc.room;

import com.netease.nim.server.sdk.rtc.RtcResult;
import com.netease.nim.server.sdk.rtc.room.request.RtcCreateRoomRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCidRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCnameRequest;
import com.netease.nim.server.sdk.rtc.room.response.RtcCreateRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcGetRoomResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface IRtcRoomService {

    RtcResult<RtcCreateRoomResponse> createRoom(RtcCreateRoomRequest request);

    RtcResult<RtcGetRoomResponse> getRoomByCid(RtcGetRoomByCidRequest request);

    RtcResult<RtcGetRoomResponse> getRoomByCname(RtcGetRoomByCnameRequest request);
}
