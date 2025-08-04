package com.netease.nim.server.sdk.im.v1.super_team;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.super_team.request.*;
import com.netease.nim.server.sdk.im.v1.super_team.response.*;

/**
 * Created by yangguoyong
 */
public interface ISuperTeamV1Service {

    Result<CreateSuperTeamResponseV1> createTeam(SuperTeamCreateRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamInviteResponseV1> invite(SuperTeamInviteRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamAddManagerResponseV1> addManager(SuperTeamAddManagerRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamChangeOwnerResponseV1> changeOwner(SuperTeamChangeOwnerRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamMuteResponseV1> mute(SuperTeamMuteRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamRemoveManagerResponseV1> removeManager(SuperTeamRemoveManagerRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamMuteTlistResponseV1> muteTlist(SuperTeamMuteTlistRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamKickMemberResponseV1> kick(SuperTeamKickMemberRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamMemberLeaveResponseV1> leave(SuperTeamMemberLeaveRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamUpdateNickResponseV1> updateTeamNick(SuperTeamUpdateNickRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamUpdateResponseV1> updateTinfo(SuperTeamUpdateRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamUpdateMemberInfoResponseV1> updateTlist(SuperTeamUpdateMemberInfoRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamDismissResponseV1> dismiss(SuperTeamDismissRequestV1 request) throws YunxinSdkException;

    Result<SuperTeamChangeLevelResponseV1> changeLevel(SuperTeamChangeLevelRequestV1 request) throws YunxinSdkException;

    Result<GetSuperTeamResponseV1> getTinfos(GetSuperTeamRequestV1 request) throws YunxinSdkException;

    Result<GetSuperTeamMemberResponseV1> getTlists(GetSuperTeamMemberRequestV1 request) throws YunxinSdkException;

    Result<GetSuperTeamMuteMemberResponseV1> getMuteTlists(GetSuperTeamMuteMemberRequestV1 request) throws YunxinSdkException;

    Result<GetJoinSuperTeamResponseV1> joinTeams(GetJoinSuperTeamRequestV1 request) throws YunxinSdkException;

    Result<GetSuperTeamMessageResponseV1> queryHistoryMsg(GetSuperTeamMessageRequestV1 request) throws YunxinSdkException;

    Result<GetSuperTeamMessageByIdsResponseV1> queryHistoryMsgByIds(GetSuperTeamMessageByIdsRequestV1 request) throws YunxinSdkException;

    Result<SendSuperTeamMessageResponseV1> sendMsg(SendSuperTeamMessageRequestV1 request) throws YunxinSdkException;

    Result<SendAttachSuperTeamMessageResponseV1> sendAttachMsg(SendAttachSuperTeamMessageRequestV1 request) throws YunxinSdkException;

    Result<RecallSuperTeamMessageResponseV1> recallMsg(RecallSuperTeamMessageRequestV1 request) throws YunxinSdkException;
}
