package com.netease.nim.server.sdk.rtc.room;

import com.netease.nim.server.sdk.rtc.RtcResult;
import com.netease.nim.server.sdk.rtc.room.request.*;
import com.netease.nim.server.sdk.rtc.room.response.RtcAddMemberToKicklistResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcCreateRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcDeleteRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcGetRoomResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcListRoomMembersResponse;
import com.netease.nim.server.sdk.rtc.room.response.RtcMemberRightChangeResponse;

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

    RtcResult<RtcMemberRightChangeResponse> memberRightChangeV2(RtcMemberRightChangeRequestV2 request);

    RtcResult<RtcMemberRightChangeResponse> memberRightChangeV3(RtcMemberRightChangeRequestV3 request);

    RtcResult<RtcDeleteRoomResponse> deleteRoomV2(RtcDeleteRoomRequestV2 request);

    RtcResult<RtcDeleteRoomResponse> deleteRoomV3(RtcDeleteRoomRequestV3 request);
}
