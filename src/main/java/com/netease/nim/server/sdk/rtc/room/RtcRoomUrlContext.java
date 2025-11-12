package com.netease.nim.server.sdk.rtc.room;

/**
 * Created by caojiajun on 2025/6/12
 */
public class RtcRoomUrlContext {

    static final String CREATE_ROOM = "/v2/api/room";

    static final String GET_ROOM_BY_CID = "/v2/api/rooms/{cid}";

    static final String GET_ROOM_BY_CNAME = "/v3/api/rooms";

    static final String LIST_MEMBERS_V2 = "/v2/api/rooms/{cid}/members";

    static final String LIST_MEMBERS_V3 = "/v3/api/rooms/members";

    static final String ADD_MEMBER_TO_KICKLIST_V2 = "/v2/api/kicklist/{cid}/members/{uid}";

    static final String ADD_MEMBER_TO_KICKLIST_V2_WITH_DURATION = "/v2/api/kicklist/{cid}/members/{uid}/{duration}";

    static final String ADD_MEMBER_TO_KICKLIST_V3 = "/v3/api/kicklist/members";
}
