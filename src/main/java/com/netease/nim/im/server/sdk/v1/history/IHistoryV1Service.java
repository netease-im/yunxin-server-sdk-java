package com.netease.nim.im.server.sdk.v1.history;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.history.request.*;
import com.netease.nim.im.server.sdk.v1.history.response.*;

/**
 * Created by lx on 2025/04/28.
 */
public interface IHistoryV1Service {

    /**
     * /history/querySessionMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QuerySessionHistoryMessageResponseV1> querySessionHistoryMessage(QuerySessionHistoryMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /history/queryTeamMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryTeamHistoryMessageResponseV1> queryTeamHistoryMessage(QueryTeamHistoryMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /history/queryChatroomMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryChatroomHistoryMessageResponseV1> queryChatroomHistoryMessage(QueryChatroomHistoryMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/deleteHistoryMessage.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteChatroomHistoryMessageResponseV1> deleteChatroomHistoryMessage(DeleteChatroomHistoryMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /history/querySessionList.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QuerySessionListResponseV1> querySessionList(QuerySessionListRequestV1 request) throws YunxinSdkException;

    /**
     * history/queryBroadcastMsgById.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryBroadcastHistoryMessageByIdResponseV1> queryBroadcastHistoryMessageById(QueryBroadcastHistoryMessageByIdRequestV1 request) throws YunxinSdkException;

    /**
     * /history/queryBroadcastMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryBroadcastHistoryMessageResponseV1> queryBroadcastHistoryMessage(QueryBroadcastHistoryMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /history/queryUserEvents.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryUserEventsResponseV1> queryUserEvents(QueryUserEventsRequestV1 request) throws YunxinSdkException;

}
