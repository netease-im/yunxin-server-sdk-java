package com.netease.nim.server.sdk.im.v1.message;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.message.request.*;
import com.netease.nim.server.sdk.im.v1.message.response.*;

/**
 * Created by lx on 2025/04/28.
 */
public interface IMessageV1Service {

    Result<SendMessageResponseV1> sendMessage(SendMessageRequestV1 request) throws YunxinSdkException;

    Result<SendBatchMessageResponseV1> sendBatchMessage(SendBatchMessageRequestV1 request) throws YunxinSdkException;

    Result<MarkReadMessageResponseV1> markReadMessage(MarkReadMessageRequestV1 request) throws YunxinSdkException;

    Result<MarkReadTeamMessageResponseV1> markReadTeamMessage(MarkReadTeamMessageRequestV1 request) throws YunxinSdkException;

    Result<RecallMessageResponseV1> recallMessage(RecallMessageRequestV1 request) throws YunxinSdkException;

    Result<DeleteMessageOneWayResponseV1> deleteMessageOneWay(DeleteMessageOneWayRequestV1 request) throws YunxinSdkException;

    Result<BroadcastMessageResponseV1> broadcastMessage(BroadcastMessageRequestV1 request) throws YunxinSdkException;

    Result<DeleteBroadcastMessageByIdResponseV1> deleteBroadcastMessageById(DeleteBroadcastMessageByIdRequestV1 request) throws YunxinSdkException;

    Result<UploadFileResponseV1> uploadFile(UploadFileRequestV1 request) throws YunxinSdkException;

    Result<DeleteFileResponseV1> deleteFile(DeleteFileRequestV1 request) throws YunxinSdkException;

    Result<DeleteMessageResponseV1> deleteMessage(DeleteMessageRequestV1 request) throws YunxinSdkException;

    Result<DeleteRoamSessionResponseV1> deleteRoamSession(DeleteRoamSessionRequestV1 request) throws YunxinSdkException;

}
