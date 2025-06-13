package com.netease.nim.server.sdk.rtc.room;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.rtc.room.request.RtcCreateRoomRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCidRequest;
import com.netease.nim.server.sdk.rtc.room.request.RtcGetRoomByCnameRequest;
import com.netease.nim.server.sdk.rtc.room.response.RtcCreateRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcGetRoomResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface IRtcRoomService {

    Result<RtcCreateRoomResponse> createRoom(RtcCreateRoomRequest request);

    Result<RtcGetRoomResponse> getRoomByCid(RtcGetRoomByCidRequest request);

    Result<RtcGetRoomResponse> getRoomByCname(RtcGetRoomByCnameRequest request);
}
