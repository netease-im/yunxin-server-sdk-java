package com.netease.nim.server.sdk.im.v1.signal;

/**
 * URL路径常量类，用于所有信令相关的API请求
 */
public class SignalV1UrlContext {

    // 创建信令频道
    static final String CREATE_ROOM = "/signal/createRoom.action";

    // 延长信令频道有效期
    static final String DELAY_ROOM = "/signal/delayRoom.action";

    // 关闭信令频道
    static final String CLOSE_ROOM = "/signal/closeRoom.action";

    // 查询信令频道信息
    static final String GET_ROOM_INFO = "/signal/getRoomInfo.action";

    // 发送控制指令
    static final String CTRL_ROOM = "/signal/ctrlRoom.action";

    // 邀请加入信令频道
    static final String INVITE = "/signal/invite.action";

    // 取消邀请加入信令频道
    static final String CANCEL_INVITE = "/signal/cancelInvite.action";

    // 将成员踢出信令频道
    static final String KICK = "/signal/kick.action";

} 