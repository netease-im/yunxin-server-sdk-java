package com.netease.nim.server.sdk.im.v1.history;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.history.request.*;
import com.netease.nim.server.sdk.im.v1.history.response.*;

/**
 * Created by lx on 2025/04/28.
 */
public interface IHistoryV1Service {

    Result<QuerySessionHistoryMessageResponseV1> querySessionHistoryMessage(QuerySessionHistoryMessageRequestV1 request) throws YunxinSdkException;

    Result<QueryTeamHistoryMessageResponseV1> queryTeamHistoryMessage(QueryTeamHistoryMessageRequestV1 request) throws YunxinSdkException;

    Result<QueryChatroomHistoryMessageResponseV1> queryChatroomHistoryMessage(QueryChatroomHistoryMessageRequestV1 request) throws YunxinSdkException;

    Result<DeleteChatroomHistoryMessageResponseV1> deleteChatroomHistoryMessage(DeleteChatroomHistoryMessageRequestV1 request) throws YunxinSdkException;

    Result<QuerySessionListResponseV1> querySessionList(QuerySessionListRequestV1 request) throws YunxinSdkException;

    Result<QueryBroadcastHistoryMessageByIdResponseV1> queryBroadcastHistoryMessageById(QueryBroadcastHistoryMessageByIdRequestV1 request) throws YunxinSdkException;

    Result<QueryBroadcastHistoryMessageResponseV1> queryBroadcastHistoryMessage(QueryBroadcastHistoryMessageRequestV1 request) throws YunxinSdkException;

    Result<QueryUserEventsResponseV1> queryUserEvents(QueryUserEventsRequestV1 request) throws YunxinSdkException;

}
