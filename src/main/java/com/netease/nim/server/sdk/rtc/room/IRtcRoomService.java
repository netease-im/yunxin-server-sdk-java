package com.netease.nim.server.sdk.rtc.room;

import com.netease.nim.server.sdk.rtc.RtcResult;
import com.netease.nim.server.sdk.rtc.room.request.*;
import com.netease.nim.server.sdk.rtc.room.response.RtcAddMemberToKicklistResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcCreateRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcGetRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcListRoomMembersResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public interface IRtcRoomService {

    RtcResult<RtcCreateRoomResponse> createRoom(RtcCreateRoomRequest request);

    RtcResult<RtcGetRoomResponse> getRoomByCid(RtcGetRoomByCidRequest request);

    RtcResult<RtcGetRoomResponse> getRoomByCname(RtcGetRoomByCnameRequest request);

    RtcResult<RtcListRoomMembersResponse> listRoomMembersV2(RtcListRoomMembersRequestV2 request);

    RtcResult<RtcListRoomMembersResponse> listRoomMembersV3(RtcListRoomMembersRequestV3 request);

    RtcResult<RtcAddMemberToKicklistResponse> addMemberToKicklistV2(RtcAddMemberToKicklistRequestV2 request);

    RtcResult<RtcAddMemberToKicklistResponse> addMemberToKicklistV3(RtcAddMemberToKicklistRequestV3 request);
}
