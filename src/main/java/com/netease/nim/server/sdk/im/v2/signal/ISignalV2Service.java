package com.netease.nim.server.sdk.im.v2.signal;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.signal.request.CreateSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.DelaySignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.CloseSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.QuerySignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.SendSignalRoomControlRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.InviteSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.CancelSignalRoomInviteRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.KickSignalRoomMemberRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CreateSIgnalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.DelaySignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CloseSignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.QuerySignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.SendSignalRoomControlResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.InviteSignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CancelSignalRoomInviteResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.KickSignalRoomMemberResponseV2;

/**
 * 信令服务接口 V2
 */
public interface ISignalV2Service {

    /**
     * 创建信令房间
     * @param request 创建信令房间请求
     * @return 创建信令房间响应
     * @throws YunxinSdkException SDK异常
     */
    Result<CreateSIgnalRoomResponseV2> createRoom(CreateSignalRoomRequestV2 request) throws YunxinSdkException;

    /**
     * 延长信令房间有效期
     * @param request 延长信令房间有效期请求
     * @return 延长信令房间有效期响应
     * @throws YunxinSdkException SDK异常
     */
    Result<DelaySignalRoomResponseV2> delayRoom(DelaySignalRoomRequestV2 request) throws YunxinSdkException;

    /**
     * 关闭信令房间
     * @param request 关闭信令房间请求
     * @return 关闭信令房间响应
     * @throws YunxinSdkException SDK异常
     */
    Result<CloseSignalRoomResponseV2> closeRoom(CloseSignalRoomRequestV2 request) throws YunxinSdkException;

    /**
     * 查询信令房间
     * @param request 查询信令房间请求
     * @return 查询信令房间响应
     * @throws YunxinSdkException SDK异常
     */
    Result<QuerySignalRoomResponseV2> queryRoom(QuerySignalRoomRequestV2 request) throws YunxinSdkException;

    /**
     * 信令房间发送控制指令
     * @param request 发送控制指令请求
     * @return 发送控制指令响应
     * @throws YunxinSdkException SDK异常
     */
    Result<SendSignalRoomControlResponseV2> sendControl(SendSignalRoomControlRequestV2 request) throws YunxinSdkException;

    /**
     * 邀请加入信令房间
     * @param request 邀请加入信令房间请求
     * @return 邀请加入信令房间响应
     * @throws YunxinSdkException SDK异常
     */
    Result<InviteSignalRoomResponseV2> invite(InviteSignalRoomRequestV2 request) throws YunxinSdkException;

    /**
     * 取消邀请加入信令房间
     * @param request 取消邀请加入信令房间请求
     * @return 取消邀请加入信令房间响应
     * @throws YunxinSdkException SDK异常
     */
    Result<CancelSignalRoomInviteResponseV2> cancelInvite(CancelSignalRoomInviteRequestV2 request) throws YunxinSdkException;

    /**
     * 将成员踢出信令房间
     * @param request 将成员踢出信令房间请求
     * @return 将成员踢出信令房间响应
     * @throws YunxinSdkException SDK异常
     */
    Result<KickSignalRoomMemberResponseV2> kickMember(KickSignalRoomMemberRequestV2 request) throws YunxinSdkException;

}
