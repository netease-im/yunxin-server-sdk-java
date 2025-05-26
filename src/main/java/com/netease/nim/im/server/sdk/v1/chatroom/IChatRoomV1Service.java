package com.netease.nim.im.server.sdk.v1.chatroom;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.chatroom.reponse.*;
import com.netease.nim.im.server.sdk.v1.chatroom.request.*;

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IChatRoomV1Service {

    /**
     * /chatroom/create.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateChatroomResponseV1> createChatroom(CreateChatroomRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/update.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateChatroomResponseV1> updateChatroom(UpdateChatroomRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/requestAddr.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryChatroomAddressResponseV1> queryChatroomAddress(QueryChatroomAddressRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/get.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryChatroomInfoResponseV1> queryChatroomInfo(QueryChatroomInfoRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/getBatch.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryChatroomInfosResponseV1> queryChatroomInfos(QueryChatroomInfosRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/toggleCloseStat.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<ToggleCloseChatroomStatResponseV1> toggleCloseChatroomStat(ToggleCloseChatroomStatRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/updateDelayClosePolicy.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateChatroomDelayClosePolicyResponseV1> updateDelayClosePolicy(UpdateChatroomDelayClosePolicyRequestV1 request) throws YunxinSdkException;


    /**
     * /chatroom/updateInOutNotification.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateChatroomInOutNotificationResponseV1> updateChatroomInOutNotification(UpdateChatroomInOutNotificationRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/kickMember.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<KickMemberResponseV1> kickMember(KickMemberRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/setMemberRole.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SetMemberRoleResponseV1> setMemberRole(SetMemberRoleRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/updateMyRoomRole.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateMyRoomRoleResponseV1> updateMyRoomRole(UpdateMyRoomRoleRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/membersByPage.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryMembersByPageResponseV1> membersByPage(QueryMembersByPageRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queryMembersByRole.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryMembersByRolesResponseV1> membersByRoles(QueryMembersByRolesRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queryMembers.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryMembersResponseV1> queryMembers(QueryMembersRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/addRobot.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<AddRobotResponseV1> addRobot(AddRobotRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/removeRobot.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<RemoveRobotResponseV1> removeRobot(RemoveRobotRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/cleanRobot.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<CleanRobotResponseV1> cleanRobot(CleanRobotRequestV1 request) throws YunxinSdkException;


    /**
     * /chatroom/temporaryMute.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<TemporaryMuteResponseV1> temporaryMute(TemporaryMuteRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/muteRoom.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<MuteRoomResponseV1> muteRoom(MuteRoomRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/tagTemporaryMute.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<TagTemporaryMuteResponseV1> tagTemporaryMute(TagTemporaryMuteRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/tagMembersCount.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<TagMembersCountResponseV1> tagMembersCount(TagMembersCountRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/tagMembersQuery.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<TagMembersQueryResponseV1> tagMembersQuery(TagMembersQueryRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queryTagHistoryMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryTagHistoryMsgResponseV1> queryTagHistoryMsg(QueryTagHistoryMsgRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/updateChatRoomRoleTag.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateChatRoomRoleTagResponseV1> updateChatRoomRoleTag(UpdateChatRoomRoleTagRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queryUserRoomIds.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryUserRoomIdsResponseV1> queryUserRoomIds(QueryUserRoomIdsRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queueInit.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueueInitResponseV1> queueInit(QueueInitRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queueDrop.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueueDropResponseV1> queueDrop(QueueDropRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queueOffer.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueueOfferResponseV1> queueOffer(QueueOfferRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queueBatchOffer.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueueBatchOfferResponseV1> queueBatchOffer(QueueBatchOfferRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queueBatchUpdate.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueueBatchUpdateResponseV1> queueBatchUpdate(QueueBatchUpdateRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queueList.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueueListResponseV1> queueList(QueueListRequestV1 request) throws YunxinSdkException;

    /**
     * /chatroom/queuePoll.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueuePollResponseV1> queuePoll(QueuePollRequestV1 request) throws YunxinSdkException;

    Result<QueueGetResponseV1> queueGet(QueueGetRequestV1 request) throws YunxinSdkException;

}
