package com.netease.nim.server.sdk.im.v1.chatroom_message;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.chatroom_message.request.*;
import com.netease.nim.server.sdk.im.v1.chatroom_message.response.*;

/**
 * Created by yangguoyong
 */
public interface IChatroomMessageV1Service {

    Result<SendChatroomMsgResponseV1> sendMsg(SendChatroomMsgRequestV1 request) throws YunxinSdkException;

    Result<BatchSendChatroomMsgResponseV1> batchSendMsg(BatchSendChatroomMsgRequestV1 request) throws YunxinSdkException;

    Result<RecallChatroomMsgResponseV1> recall(RecallChatroomMsgRequestV1 request) throws YunxinSdkException;

    Result<ChatroomTargetMsgResponseV1> sendMsgToSomeone(ChatroomTargetMsgRequestV1 request) throws YunxinSdkException;

    Result<BatchChatroomTargetMsgResponseV1> batchSendMsgToSomeone(BatchChatroomTargetMsgRequestV1 request) throws YunxinSdkException;

    Result<SendChatroomMsgResponseV1> broadcast(ChatroomBroadcastRequestV1 request) throws YunxinSdkException;
}
