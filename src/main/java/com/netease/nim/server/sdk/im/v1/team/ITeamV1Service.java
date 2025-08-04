package com.netease.nim.server.sdk.im.v1.team;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.team.request.*;
import com.netease.nim.server.sdk.im.v1.team.response.*;

/**
 * Created by hekaijie on 2024/12/24
 */
public interface ITeamV1Service {

    Result<CreateTeamResponseV1> createTeam(CreateTeamRequestV1 request) throws YunxinSdkException;

    Result<DismissTeamResponseV1> dismissTeam(DismissTeamRequestV1 request) throws YunxinSdkException;

    Result<AddTeamResponseV1> addTeam(AddTeamRequestV1 request) throws YunxinSdkException;

    Result<KickTeamResponseV1> kickTeam(KickTeamRequestV1 request) throws YunxinSdkException;

    Result<UpdateTeamResponseV1> updateTeam(UpdateTeamRequestV1 request) throws YunxinSdkException;

    Result<QueryTeamResponseV1> queryTeam(QueryTeamRequestV1 request) throws YunxinSdkException;

    Result<ChangeOwnerTeamResponseV1> changeOwnerTeam(ChangeOwnerTeamRequestV1 request) throws YunxinSdkException;

    Result<AddManagerTeamResponseV1> addManagerTeam(AddManagerTeamRequestV1 request) throws YunxinSdkException;

    Result<RemoveManagerTeamResponseV1> removeManagerTeam(RemoveManagerTeamRequestV1 request) throws YunxinSdkException;

    Result<JoinsTeamResponseV1> queryJoinedTeamListByAccId(JoinsTeamRequestV1 request) throws YunxinSdkException;

    Result<UpdateTeamNickResponseV1> updateTeamMemberNick(UpdateTeamNickRequestV1 request) throws YunxinSdkException;

    Result<LeaveTeamResponseV1> leaveTeam(LeaveTeamRequestV1 request) throws YunxinSdkException;

    Result<MuteTeamResponseV1> muteTeam(MuteTeamRequestV1 request) throws YunxinSdkException;

    Result<MuteTeamTargetMemberResponseV1> muteTeamTargetMember(MuteTeamTargetMemberRequestV1 request) throws YunxinSdkException;

    Result<MuteTeamAllMemberResponseV1> muteTeamAllMember(MuteTeamAllMemberRequestV1 request) throws YunxinSdkException;

    Result<QueryMuteTeamMembersResponseV1> queryMuteTeamMembers(QueryMuteTeamMembersRequestV1 request) throws YunxinSdkException;

    Result<QueryTeamInfoDetailsResponseV1> queryTeamInfoDetails(QueryTeamInfoDetailsRequestV1 request) throws YunxinSdkException;

    Result<QueryTeamMsgMarkReadInfoResponseV1> queryTeamMsgMarkReadInfo(QueryTeamMsgMarkReadInfoRequestV1 request) throws YunxinSdkException;

    Result<QueryAllJoinedTeamMemberInfoByAccIdResponseV1> queryAllJoinedTeamMemberInfoByAccId(QueryAllJoinedTeamMemberInfoByAccIdRequestV1 request) throws YunxinSdkException;

    Result<QueryOnlineTeamMemberResponseV1> queryOnlineTeamMember(QueryOnlineTeamMemberRequestV1 request) throws YunxinSdkException;

    Result<BatchQueryOnlineTeamMemberCountResponseV1> batchQueryOnlineTeamMemberCount(BatchQueryOnlineTeamMemberCountRequestV1 request) throws YunxinSdkException;

}
