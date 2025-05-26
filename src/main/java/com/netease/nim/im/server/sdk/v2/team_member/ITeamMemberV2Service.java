package com.netease.nim.im.server.sdk.v2.team_member;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.team_member.request.BatchMuteTeamMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.team_member.request.InviteTeamMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.team_member.request.KickTeamMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.team_member.request.LeaveTeamRequestV2;
import com.netease.nim.im.server.sdk.v2.team_member.request.QueryJoinedTeamsRequestV2;
import com.netease.nim.im.server.sdk.v2.team_member.request.UpdateTeamMemberRequestV2;
import com.netease.nim.im.server.sdk.v2.team_member.response.BatchMuteTeamMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.team_member.response.InviteTeamMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.team_member.response.KickTeamMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.team_member.response.LeaveTeamResponseV2;
import com.netease.nim.im.server.sdk.v2.team_member.response.QueryJoinedTeamsResponseV2;
import com.netease.nim.im.server.sdk.v2.team_member.response.UpdateTeamMemberResponseV2;

/**
 * Interface for Team Member V2 operations
 */
public interface ITeamMemberV2Service {

    /**
     * Invite members to a team
     * 
     * API: POST https://open.yunxinapi.com/im/v2/team_members
     * 
     * This method allows team owners and admins to invite users to join a team.
     * Maximum 200 users can be invited in a single request.
     * 
     * @param request request containing the team ID, team type, operator ID, list of account IDs to invite, and invitation message
     * @return result containing the list of successfully invited accounts and any failed invitations
     * @throws YunxinSdkException exception on network error
     */
    Result<InviteTeamMembersResponseV2> inviteTeamMembers(InviteTeamMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Kick members from a team
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/team_members/actions/kick_member
     * 
     * This method allows team owners and admins to kick members from a team.
     * Maximum 10 members can be kicked in a single request.
     * Only owners can kick admins. Admins can only kick regular members.
     * 
     * @param request request containing the team ID, team type, operator ID, and list of account IDs to kick
     * @return result containing the list of successfully kicked accounts and any failed operations
     * @throws YunxinSdkException exception on network error
     */
    Result<KickTeamMembersResponseV2> kickTeamMembers(KickTeamMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Leave a team
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/team_members/actions/leave
     * 
     * This method allows a team member to voluntarily leave a team.
     * Any member except the team owner can leave directly.
     * Team owners must transfer ownership before leaving.
     * 
     * @param request request containing the account ID, team ID, and team type
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     */
    Result<LeaveTeamResponseV2> leaveTeam(LeaveTeamRequestV2 request) throws YunxinSdkException;
    
    /**
     * Update team member information
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/team_members/{account_id}
     * 
     * This method allows updating a team member's nickname, chat banned status,
     * message notification settings, and other information.
     * Only team owners and admins can update regular member info.
     * Only team owners can update admin info.
     * 
     * @param request request containing the account ID, team ID, team type, and optional fields to update
     * @return result containing the updated team member information
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateTeamMemberResponseV2> updateTeamMember(UpdateTeamMemberRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch mute team members
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/team_members/actions/batch_mute
     * 
     * This method allows batch muting/unmuting of multiple team members at once.
     * Maximum 10 members can be muted/unmuted in a single request.
     * 
     * For advanced teams, only the team owner can batch mute members.
     * For super teams, team owners and admins can mute regular members,
     * but only owners can mute admins.
     * 
     * @param request request containing the team ID, team type, operator ID, list of account IDs to mute, and mute flag
     * @return result containing the list of successfully muted accounts and any failed operations
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchMuteTeamMembersResponseV2> batchMuteTeamMembers(BatchMuteTeamMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Query teams an account has joined
     * 
     * API: GET https://open.yunxinapi.com/im/v2/team_members/{account_id}/actions/joined_teams
     * 
     * This method allows retrieving detailed information about all teams an account has joined,
     * including team name, owner, member count, and other configuration.
     * Results can be paginated with a maximum of 100 teams per page.
     * 
     * @param request request containing the account ID, team type, and optional pagination parameters
     * @return result containing the list of joined team information
     * @throws YunxinSdkException exception on network error
     */
    Result<QueryJoinedTeamsResponseV2> queryJoinedTeams(QueryJoinedTeamsRequestV2 request) throws YunxinSdkException;
} 