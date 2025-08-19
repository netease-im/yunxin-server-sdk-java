package com.netease.nim.server.sdk.im.v2.signal;

/**
 * URL路径常量类，用于所有信令相关的API请求 V2
 */
public class SignalV2UrlContext {

    // 创建信令房间
    static final String CREATE_ROOM = "/im/v2/signalling_room";

    // 延长信令房间有效期 (同一个URL，不同HTTP方法)
    static final String DELAY_ROOM = "/im/v2/signalling_room";

    // 关闭信令房间 (同一个URL，不同HTTP方法)
    static final String CLOSE_ROOM = "/im/v2/signalling_room";

    // 查询信令房间 (同一个URL，不同HTTP方法)
    static final String QUERY_ROOM = "/im/v2/signalling_room";

    // 信令房间发送控制指令
    static final String SEND_CONTROL = "/im/v2/signalling_room/actions/control";

    // 邀请加入信令房间
    static final String INVITE = "/im/v2/signalling_room/actions/invite";

    // 取消邀请加入信令房间
    static final String CANCEL_INVITE = "/im/v2/signalling_room/actions/cancel_invite";

    // 将成员踢出信令房间
    static final String KICK_MEMBER = "/im/v2/signalling_room/actions/kick";

} 