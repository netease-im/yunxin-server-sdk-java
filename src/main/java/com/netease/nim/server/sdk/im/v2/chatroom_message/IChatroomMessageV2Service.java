package com.netease.nim.server.sdk.im.v2.chatroom_message;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.BatchSendChatroomMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.QueryChatroomHistoryMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.RecallChatroomMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.SendChatroomMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.BatchSendChatroomMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.QueryChatroomHistoryMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.RecallChatroomMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.SendChatroomMessageResponseV2;


public interface IChatroomMessageV2Service {

    Result<SendChatroomMessageResponseV2> sendChatroomMessage(SendChatroomMessageRequestV2 request) throws YunxinSdkException;

    Result<BatchSendChatroomMessagesResponseV2> batchSendChatroomMessages(BatchSendChatroomMessagesRequestV2 request) throws YunxinSdkException;

    Result<RecallChatroomMessageResponseV2> recallChatroomMessage(RecallChatroomMessageRequestV2 request) throws YunxinSdkException;

    Result<QueryChatroomHistoryMessagesResponseV2> queryChatroomHistoryMessages(QueryChatroomHistoryMessagesRequestV2 request) throws YunxinSdkException;
} 