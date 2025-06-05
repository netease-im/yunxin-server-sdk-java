package com.netease.nim.server.sdk.im.v1.super_team;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.super_team.request.*;
import com.netease.nim.server.sdk.im.v1.super_team.response.*;

/**
 * Created by yangguoyong
 */
public interface ISuperTeamV1Service {

    /**
     * /superteam/create.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateSuperTeamResponseV1> createTeam(SuperTeamCreateRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/invite.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SuperTeamInviteResponseV1> invite(SuperTeamInviteRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/addManager.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SuperTeamAddManagerResponseV1> addManager(SuperTeamAddManagerRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/changeOwner.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SuperTeamChangeOwnerResponseV1> changeOwner(SuperTeamChangeOwnerRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/mute.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SuperTeamMuteResponseV1> mute(SuperTeamMuteRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/removeManager.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SuperTeamRemoveManagerResponseV1> removeManager(SuperTeamRemoveManagerRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/muteTlist.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SuperTeamMuteTlistResponseV1> muteTlist(SuperTeamMuteTlistRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/kick.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> kick(SuperTeamKickMemberRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/leave.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> leave(SuperTeamMemberLeaveRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/updateTeamNick.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> updateTeamNick(SuperTeamUpdateNickRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/updateTinfo.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> updateTinfo(SuperTeamUpdateRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/updateTlist.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> updateTlist(SuperTeamUpdateMemberInfoRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/dismiss.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SuperTeamDismissResponseV1> dismiss(SuperTeamDismissRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/changeLevel.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> changeLevel(SuperTeamChangeLevelRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/getTinfos.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetSuperTeamResponseV1> getTinfos(GetSuperTeamRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/getTlists.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetSuperTeamMemberResponseV1> getTlists(GetSuperTeamMemberRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/getMuteTlists.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetSuperTeamMuteMemberResponseV1> getMuteTlists(GetSuperTeamMuteMemberRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/joinTeams.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetJoinSuperTeamResponseV1> joinTeams(GetJoinSuperTeamRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/queryHistoryMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetSuperTeamMessageResponseV1> queryHistoryMsg(GetSuperTeamMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/queryHistoryMsgByIds.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetSuperTeamMessageByIdsResponseV1> queryHistoryMsgByIds(GetSuperTeamMessageByIdsRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/sendMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SendSuperTeamMessageResponseV1> sendMsg(SendSuperTeamMessageRequestV1 request) throws YunxinSdkException;


    /**
     * /superteam/sendAttachMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> sendAttachMsg(SendAttachSuperTeamMessageRequestV1 request) throws YunxinSdkException;

    /**
     * /superteam/recallMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseSuperTeamResponseV1> recallMsg(RecallAttachSuperMessageRequestV1 request) throws YunxinSdkException;
}
