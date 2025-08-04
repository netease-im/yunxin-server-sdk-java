package com.netease.nim.server.sdk.im.v1.chatroom;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.chatroom.request.*;
import com.netease.nim.server.sdk.im.v1.chatroom.response.*;

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IChatRoomV1Service {

    Result<CreateChatroomResponseV1> createChatroom(CreateChatroomRequestV1 request) throws YunxinSdkException;

    Result<UpdateChatroomResponseV1> updateChatroom(UpdateChatroomRequestV1 request) throws YunxinSdkException;

    Result<QueryChatroomAddressResponseV1> queryChatroomAddress(QueryChatroomAddressRequestV1 request) throws YunxinSdkException;

    Result<QueryChatroomInfoResponseV1> queryChatroomInfo(QueryChatroomInfoRequestV1 request) throws YunxinSdkException;

    Result<QueryChatroomInfosResponseV1> queryChatroomInfos(QueryChatroomInfosRequestV1 request) throws YunxinSdkException;

    Result<ToggleCloseChatroomStatResponseV1> toggleCloseChatroomStat(ToggleCloseChatroomStatRequestV1 request) throws YunxinSdkException;

    Result<UpdateChatroomDelayClosePolicyResponseV1> updateDelayClosePolicy(UpdateChatroomDelayClosePolicyRequestV1 request) throws YunxinSdkException;

    Result<UpdateChatroomInOutNotificationResponseV1> updateChatroomInOutNotification(UpdateChatroomInOutNotificationRequestV1 request) throws YunxinSdkException;

    Result<KickMemberResponseV1> kickMember(KickMemberRequestV1 request) throws YunxinSdkException;

    Result<SetMemberRoleResponseV1> setMemberRole(SetMemberRoleRequestV1 request) throws YunxinSdkException;

    Result<UpdateMyRoomRoleResponseV1> updateMyRoomRole(UpdateMyRoomRoleRequestV1 request) throws YunxinSdkException;

    Result<QueryMembersByPageResponseV1> membersByPage(QueryMembersByPageRequestV1 request) throws YunxinSdkException;

    Result<QueryMembersByRolesResponseV1> membersByRoles(QueryMembersByRolesRequestV1 request) throws YunxinSdkException;

    Result<QueryMembersResponseV1> queryMembers(QueryMembersRequestV1 request) throws YunxinSdkException;

    Result<AddRobotResponseV1> addRobot(AddRobotRequestV1 request) throws YunxinSdkException;

    Result<RemoveRobotResponseV1> removeRobot(RemoveRobotRequestV1 request) throws YunxinSdkException;

    Result<CleanRobotResponseV1> cleanRobot(CleanRobotRequestV1 request) throws YunxinSdkException;

    Result<TemporaryMuteResponseV1> temporaryMute(TemporaryMuteRequestV1 request) throws YunxinSdkException;

    Result<MuteRoomResponseV1> muteRoom(MuteRoomRequestV1 request) throws YunxinSdkException;

    Result<TagTemporaryMuteResponseV1> tagTemporaryMute(TagTemporaryMuteRequestV1 request) throws YunxinSdkException;

    Result<TagMembersCountResponseV1> tagMembersCount(TagMembersCountRequestV1 request) throws YunxinSdkException;

    Result<TagMembersQueryResponseV1> tagMembersQuery(TagMembersQueryRequestV1 request) throws YunxinSdkException;

    Result<QueryTagHistoryMsgResponseV1> queryTagHistoryMsg(QueryTagHistoryMsgRequestV1 request) throws YunxinSdkException;

    Result<UpdateChatRoomRoleTagResponseV1> updateChatRoomRoleTag(UpdateChatRoomRoleTagRequestV1 request) throws YunxinSdkException;

    Result<QueryUserRoomIdsResponseV1> queryUserRoomIds(QueryUserRoomIdsRequestV1 request) throws YunxinSdkException;

    Result<QueueInitResponseV1> queueInit(QueueInitRequestV1 request) throws YunxinSdkException;

    Result<QueueDropResponseV1> queueDrop(QueueDropRequestV1 request) throws YunxinSdkException;

    Result<QueueOfferResponseV1> queueOffer(QueueOfferRequestV1 request) throws YunxinSdkException;

    Result<QueueBatchOfferResponseV1> queueBatchOffer(QueueBatchOfferRequestV1 request) throws YunxinSdkException;

    Result<QueueBatchUpdateResponseV1> queueBatchUpdate(QueueBatchUpdateRequestV1 request) throws YunxinSdkException;

    Result<QueueListResponseV1> queueList(QueueListRequestV1 request) throws YunxinSdkException;

    Result<QueuePollResponseV1> queuePoll(QueuePollRequestV1 request) throws YunxinSdkException;

    Result<QueueGetResponseV1> queueGet(QueueGetRequestV1 request) throws YunxinSdkException;

}
