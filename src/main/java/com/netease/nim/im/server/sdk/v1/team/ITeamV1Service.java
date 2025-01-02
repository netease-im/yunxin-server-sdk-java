package com.netease.nim.im.server.sdk.v1.team;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.team.request.*;
import com.netease.nim.im.server.sdk.v1.team.response.*;

/**
 * Created by hekaijie on 2024/12/24
 */
public interface ITeamV1Service {

    /**
     * /team/create.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateTeamResponseV1> createTeam(CreateTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/remove.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DismissTeamResponseV1> dismissTeam(DismissTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/add.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<AddTeamResponseV1> addTeam(AddTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/kick.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<KickTeamResponseV1> kickTeam(KickTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/update.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateTeamResponseV1> updateTeam(UpdateTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/query.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryTeamResponseV1> queryTeam(QueryTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/changeOwner.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<ChangeOwnerTeamResponseV1> changeOwnerTeam(ChangeOwnerTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/addManager.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<AddManagerTeamResponseV1> addManagerTeam(AddManagerTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/removeManager.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<RemoveManagerTeamResponseV1> removeManagerTeam(RemoveManagerTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/joinTeams.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<JoinsTeamResponseV1> queryJoinedTeamListByAccId(JoinsTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/updateTeamNick.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateTeamNickResponseV1> updateTeamMemberNick(UpdateTeamNickRequestV1 request) throws YunxinSdkException;

    /**
     * /team/leave.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<LeaveTeamResponseV1> leaveTeam(LeaveTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/muteTeam.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<MuteTeamResponseV1> muteTeam(MuteTeamRequestV1 request) throws YunxinSdkException;

    /**
     * /team/muteTlist.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<MuteTeamTargetMemberResponseV1> muteTeamTargetMember(MuteTeamTargetMemberRequestV1 request) throws YunxinSdkException;

    /**
     * /team/muteTlistAll.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<MuteTeamAllMemberResponseV1> muteTeamAllMember(MuteTeamAllMemberRequestV1 request) throws YunxinSdkException;

    /**
     * Query the list of mute members of the team
     * /team/listTeamMute.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryMuteTeamMembersResponseV1> queryMuteTeamMembers(QueryMuteTeamMembersRequestV1 request) throws YunxinSdkException;

    /**
     * /team/queryDetail.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryTeamInfoDetailsResponseV1> queryTeamInfoDetails(QueryTeamInfoDetailsRequestV1 request) throws YunxinSdkException;

    /**
     * /team/getMarkReadInfo.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryTeamMsgMarkReadInfoResponseV1> queryTeamMsgMarkReadInfo(QueryTeamMsgMarkReadInfoRequestV1 request) throws YunxinSdkException;

    /**
     * /team/listMemberInfo.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryAllJoinedTeamMemberInfoByAccIdResponseV1> queryAllJoinedTeamMemberInfoByAccId(QueryAllJoinedTeamMemberInfoByAccIdRequestV1 request) throws YunxinSdkException;

    /**
     * /team/listOnlineUsers.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryOnlineTeamMemberResponseV1> queryOnlineTeamMember(QueryOnlineTeamMemberRequestV1 request) throws YunxinSdkException;

    /**
     * /team/listOnlineUserCount.action
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchQueryOnlineTeamMemberCountResponseV1> batchQueryOnlineTeamMemberCount(BatchQueryOnlineTeamMemberCountRequestV1 request) throws YunxinSdkException;

}
