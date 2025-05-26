package com.netease.nim.im.server.sdk.v1.message;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.message.request.*;
import com.netease.nim.im.server.sdk.v1.message.response.*;

/**
 * Created by lx on 2025/04/28.
 */
public interface IMessageV1Service {

    /**
     * /msg/sendMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SendMessageResponseV1> sendMessage(SendMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/sendBatchMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SendBatchMessageResponseV1> sendBatchMessage(SendBatchMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/markReadMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<MarkReadMessageResponseV1> markReadMessage(MarkReadMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/markReadTeamMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<MarkReadTeamMessageResponseV1> markReadTeamMessage(MarkReadTeamMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/recall.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<RecallMessageResponseV1> recallMessage(RecallMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/delMsgOneWay.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteMessageOneWayResponseV1> deleteMessageOneWay(DeleteMessageOneWayRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/broadcastMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BroadcastMessageResponseV1> broadcastMessage(BroadcastMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /history/delBroadcastMsgById.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteBroadcastMessageByIdResponseV1> deleteBroadcastMessageById(DeleteBroadcastMessageByIdRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/upload.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UploadFileResponseV1> uploadFile(UploadFileRequestV1 request) throws YunxinSdkException;

    /**
     * /job/nos/del.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteFileResponseV1> deleteFile(DeleteFileRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/delMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteMessageResponseV1> deleteMessage(DeleteMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /msg/delRoamSession.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteRoamSessionResponseV1> deleteRoamSession(DeleteRoamSessionRequestV1 request) throws YunxinSdkException;

}
