package com.netease.nim.server.sdk.im.v2.team_member;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.team_member.request.BatchMuteTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.InviteTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.KickTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.LeaveTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.QueryJoinedTeamsRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.UpdateTeamMemberRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.BatchMuteTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.InviteTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.KickTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.LeaveTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.QueryJoinedTeamsResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.UpdateTeamMemberResponseV2;

/**
 * Interface for Team Member V2 operations
 */
public interface ITeamMemberV2Service {

    Result<InviteTeamMembersResponseV2> inviteTeamMembers(InviteTeamMembersRequestV2 request) throws YunxinSdkException;
    
    Result<KickTeamMembersResponseV2> kickTeamMembers(KickTeamMembersRequestV2 request) throws YunxinSdkException;
    
    Result<LeaveTeamResponseV2> leaveTeam(LeaveTeamRequestV2 request) throws YunxinSdkException;

    Result<UpdateTeamMemberResponseV2> updateTeamMember(UpdateTeamMemberRequestV2 request) throws YunxinSdkException;
    
    Result<BatchMuteTeamMembersResponseV2> batchMuteTeamMembers(BatchMuteTeamMembersRequestV2 request) throws YunxinSdkException;

    Result<QueryJoinedTeamsResponseV2> queryJoinedTeams(QueryJoinedTeamsRequestV2 request) throws YunxinSdkException;
} 