package com.netease.nim.server.sdk.im.v1.signal;

import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.im.v1.signal.request.CreateSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.DelaySignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CloseSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.GetSignalRoomInfoRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CtrlSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.InviteSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CancelSignalRoomInviteRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.KickSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CreateSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.DelaySignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CloseSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.GetSignalRoomInfoResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CtrlSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.InviteSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CancelSignalRoomInviteResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.KickSignalRoomResponseV1;

/**
 * 信令服务接口
 */
public interface ISignalV1Service {

    /**
     * 创建信令频道
     * @param request 创建信令频道请求
     * @return 创建信令频道响应
     * @throws YunxinSdkException SDK异常
     */
    Result<CreateSignalRoomResponseV1> createRoom(CreateSignalRoomRequestV1 request) throws YunxinSdkException;

    /**
     * 延长信令频道有效期
     * @param request 延长信令频道有效期请求
     * @return 延长信令频道有效期响应
     * @throws YunxinSdkException SDK异常
     */
    Result<DelaySignalRoomResponseV1> delayRoom(DelaySignalRoomRequestV1 request) throws YunxinSdkException;

    /**
     * 关闭信令频道
     * @param request 关闭信令频道请求
     * @return 关闭信令频道响应
     * @throws YunxinSdkException SDK异常
     */
    Result<CloseSignalRoomResponseV1> closeRoom(CloseSignalRoomRequestV1 request) throws YunxinSdkException;

    /**
     * 查询信令频道信息
     * @param request 查询信令频道信息请求
     * @return 查询信令频道信息响应
     * @throws YunxinSdkException SDK异常
     */
    Result<GetSignalRoomInfoResponseV1> getRoomInfo(GetSignalRoomInfoRequestV1 request) throws YunxinSdkException;

    /**
     * 发送控制指令
     * @param request 发送控制指令请求
     * @return 发送控制指令响应
     * @throws YunxinSdkException SDK异常
     */
    Result<CtrlSignalRoomResponseV1> ctrlRoom(CtrlSignalRoomRequestV1 request) throws YunxinSdkException;

    /**
     * 邀请加入信令频道
     * @param request 邀请加入信令频道请求
     * @return 邀请加入信令频道响应
     * @throws YunxinSdkException SDK异常
     */
    Result<InviteSignalRoomResponseV1> invite(InviteSignalRoomRequestV1 request) throws YunxinSdkException;

    /**
     * 取消邀请加入信令频道
     * @param request 取消邀请加入信令频道请求
     * @return 取消邀请加入信令频道响应
     * @throws YunxinSdkException SDK异常
     */
    Result<CancelSignalRoomInviteResponseV1> cancelInvite(CancelSignalRoomInviteRequestV1 request) throws YunxinSdkException;

    /**
     * 将成员踢出信令频道
     * @param request 将成员踢出信令频道请求
     * @return 将成员踢出信令频道响应
     * @throws YunxinSdkException SDK异常
     */
    Result<KickSignalRoomResponseV1> kick(KickSignalRoomRequestV1 request) throws YunxinSdkException;

}
