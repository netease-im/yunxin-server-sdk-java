package com.netease.nim.server.sdk.im.v2.chatroom_queue;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.DeleteChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.InitializeChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.PollChatroomQueueElementRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.QueryChatroomQueueElementsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.UpdateChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.DeleteChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.InitializeChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.PollChatroomQueueElementResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.QueryChatroomQueueElementsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.UpdateChatroomQueueResponseV2;

public interface IChatroomQueueV2Service {

    Result<InitializeChatroomQueueResponseV2> initializeChatroomQueue(InitializeChatroomQueueRequestV2 request) throws YunxinSdkException;
    
    Result<QueryChatroomQueueElementsResponseV2> queryChatroomQueueElements(QueryChatroomQueueElementsRequestV2 request) throws YunxinSdkException;
    
    Result<UpdateChatroomQueueResponseV2> updateChatroomQueue(UpdateChatroomQueueRequestV2 request) throws YunxinSdkException;
    
    Result<DeleteChatroomQueueResponseV2> deleteChatroomQueue(DeleteChatroomQueueRequestV2 request) throws YunxinSdkException;
    
    Result<PollChatroomQueueElementResponseV2> pollChatroomQueueElement(PollChatroomQueueElementRequestV2 request) throws YunxinSdkException;
} 