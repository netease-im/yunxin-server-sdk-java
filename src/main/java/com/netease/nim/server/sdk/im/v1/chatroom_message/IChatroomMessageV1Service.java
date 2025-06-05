package com.netease.nim.server.sdk.im.v1.chatroom_message;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.chatroom_message.request.*;
import com.netease.nim.server.sdk.im.v1.chatroom_message.response.*;

/**
 * Created by yangguoyong
 */
public interface IChatroomMessageV1Service {


    /**
     * /chatroom/sendMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SendChatroomMsgResponseV1> sendMsg(SendChatroomMsgRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/batchSendMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchSendChatroomMsgResponseV1> batchSendMsg(BatchSendChatroomMsgRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/recall.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseChatroomMessageResponseV1> recall(RecallChatroomMsgRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/recall.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<ChatroomTargetMsgResponseV1> sendMsgToSomeone(ChatroomTargetMsgRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/batchSendMsgToSomeone.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchChatroomTargetMsgResponseV1> batchSendMsgToSomeone(BatchChatroomTargetMsgRequestV1 request) throws YunxinSdkException;


    /**
     * /chatroom/broadcast.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SendChatroomMsgResponseV1> broadcast(ChatroomBroadcastRequestV1 request) throws YunxinSdkException;
}
