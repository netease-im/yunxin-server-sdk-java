package com.netease.nim.im.server.sdk.v2.chatroom_message;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.BatchSendChatroomMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.QueryChatroomHistoryMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.RecallChatroomMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.request.SendChatroomMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.BatchSendChatroomMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.QueryChatroomHistoryMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.RecallChatroomMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_message.response.SendChatroomMessageResponseV2;

/**
 * Interface for Chatroom Message V2 operations
 * 
 * This service provides methods for sending messages to chatrooms.
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 */
public interface IChatroomMessageV2Service {

    /**
     * Send a message to a chatroom
     * 
     * @param request the request containing chatroom ID and message details
     * @return result containing the sent message information
     * @throws YunxinSdkException if a network or server error occurs
     */
    Result<SendChatroomMessageResponseV2> sendChatroomMessage(SendChatroomMessageRequestV2 request) throws YunxinSdkException;

    /**
     * Batch send messages to a chatroom
     * 
     * @param request the request containing the chatroom ID, sender ID, and list of messages
     * @return result containing the sent message information
     * @throws YunxinSdkException if a network or server error occurs
     */
    Result<BatchSendChatroomMessagesResponseV2> batchSendChatroomMessages(BatchSendChatroomMessagesRequestV2 request) throws YunxinSdkException;

    /**
     * Recall or delete a chatroom message
     * 
     * @param request the request containing the recall parameters
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     */
    Result<RecallChatroomMessageResponseV2> recallChatroomMessage(RecallChatroomMessageRequestV2 request) throws YunxinSdkException;

    /**
     * Query chatroom history messages with pagination
     * 
     * @param request the request containing query parameters for fetching history messages
     * @return result containing the paginated history messages
     * @throws YunxinSdkException if a network or server error occurs
     */
    Result<QueryChatroomHistoryMessagesResponseV2> queryChatroomHistoryMessages(QueryChatroomHistoryMessagesRequestV2 request) throws YunxinSdkException;
} 