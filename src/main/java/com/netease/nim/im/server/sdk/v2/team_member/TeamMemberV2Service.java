package com.netease.nim.im.server.sdk.v2.team_member;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
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
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Team Member V2 operations
 * 
 * This service provides methods for managing team members, including:
 * - Inviting new members to teams
 * - Kicking members from teams
 * - Team members leaving teams voluntarily
 * - Updating team member information
 * - Batch muting/unmuting team members
 * - Querying teams an account has joined
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class TeamMemberV2Service implements ITeamMemberV2Service {

    private final YunxinApiHttpClient httpClient;

    public TeamMemberV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Invite members to a team
     * 
     * This method allows team owners and admins to invite users to join a team.
     * Maximum 200 users can be invited in a single request.
     * 
     * Required parameters:
     * - operatorId: The account ID of the operator (must be team owner/admin if invite_mode is 0)
     * - teamId: The ID of the team to invite users to
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * - inviteAccountIds: List of account IDs to invite (max 200)
     * - msg: Invitation message (max 150 chars)
     * 
     * Optional parameters:
     * - extension: Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     * 
     * @param request request containing invitation details
     * @return result containing the successfully invited accounts and any failed invitations
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<InviteTeamMembersResponseV2> inviteTeamMembers(InviteTeamMembersRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("Operator ID cannot be null or empty");
        }
        
        if (request.getTeamId() == null) {
            throw new IllegalArgumentException("Team ID cannot be null");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        if (request.getInviteAccountIds() == null || request.getInviteAccountIds().isEmpty()) {
            throw new IllegalArgumentException("Invite account IDs list cannot be null or empty");
        }
        
        if (request.getInviteAccountIds().size() > 200) {
            throw new IllegalArgumentException("Cannot invite more than 200 accounts in a single request");
        }
        
        if (request.getMsg() == null || request.getMsg().isEmpty()) {
            throw new IllegalArgumentException("Invitation message cannot be null or empty");
        }
        
        if (request.getMsg().length() > 150) {
            throw new IllegalArgumentException("Invitation message cannot exceed 150 characters");
        }
        
        // Validate extension field length if provided
        if (request.getExtension() != null && request.getExtension().length() > 512) {
            throw new IllegalArgumentException("Extension field cannot exceed 512 characters");
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            TeamMemberUrlContextV2.INVITE_TEAM_MEMBERS,
            TeamMemberUrlContextV2.INVITE_TEAM_MEMBERS,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, InviteTeamMembersResponseV2.class);
    }
    
    /**
     * Kick members from a team
     * 
     * This method allows team owners and admins to kick members from a team.
     * Maximum 10 members can be kicked in a single request.
     * Only owners can kick admins. Admins can only kick regular members.
     * 
     * Required parameters:
     * - operatorId: The account ID of the operator (must be team owner or admin)
     * - teamId: The ID of the team
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * - kickAccountIds: List of account IDs to kick (max 10)
     * 
     * Optional parameters:
     * - extension: Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     * 
     * @param request request containing kick operation details
     * @return result containing the successfully kicked accounts and any failed operations
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<KickTeamMembersResponseV2> kickTeamMembers(KickTeamMembersRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("Operator ID cannot be null or empty");
        }
        
        if (request.getTeamId() == null) {
            throw new IllegalArgumentException("Team ID cannot be null");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        if (request.getKickAccountIds() == null || request.getKickAccountIds().isEmpty()) {
            throw new IllegalArgumentException("Kick account IDs list cannot be null or empty");
        }
        
        if (request.getKickAccountIds().size() > 10) {
            throw new IllegalArgumentException("Cannot kick more than 10 accounts in a single request");
        }
        
        // Validate extension field length if provided
        if (request.getExtension() != null && request.getExtension().length() > 512) {
            throw new IllegalArgumentException("Extension field cannot exceed 512 characters");
        }
        
        // Set up query parameters - using query parameters instead of request body for DELETE request
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("operator_id", request.getOperatorId());
        queryParams.put("team_id", request.getTeamId().toString());
        queryParams.put("team_type", request.getTeamType().toString());
        queryParams.put("kick_account_ids", String.join(",", request.getKickAccountIds()));
        
        // Add extension if provided
        if (request.getExtension() != null && !request.getExtension().isEmpty()) {
            queryParams.put("extension", request.getExtension());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            TeamMemberUrlContextV2.KICK_TEAM_MEMBERS,
            TeamMemberUrlContextV2.KICK_TEAM_MEMBERS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, KickTeamMembersResponseV2.class);
    }
    
    /**
     * Leave a team voluntarily
     * 
     * This method allows a team member to voluntarily leave a team.
     * Any member except the team owner can leave directly.
     * Team owners must transfer ownership before leaving.
     * 
     * Required parameters:
     * - accountId: The account ID of the user who wants to leave the team
     * - teamId: The ID of the team
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * 
     * Optional parameters:
     * - extension: Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     * 
     * @param request request containing leave operation details
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<LeaveTeamResponseV2> leaveTeam(LeaveTeamRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getTeamId() == null) {
            throw new IllegalArgumentException("Team ID cannot be null");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        // Validate extension field length if provided
        if (request.getExtension() != null && request.getExtension().length() > 512) {
            throw new IllegalArgumentException("Extension field cannot exceed 512 characters");
        }
        
        // Set up query parameters - using query parameters instead of request body for DELETE request
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        queryParams.put("team_id", request.getTeamId().toString());
        queryParams.put("team_type", request.getTeamType().toString());
        
        // Add extension if provided
        if (request.getExtension() != null && !request.getExtension().isEmpty()) {
            queryParams.put("extension", request.getExtension());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            TeamMemberUrlContextV2.LEAVE_TEAM,
            TeamMemberUrlContextV2.LEAVE_TEAM,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, LeaveTeamResponseV2.class);
    }
    
    /**
     * Update team member information
     * 
     * This method allows updating a team member's nickname, chat banned status,
     * message notification settings, and other information.
     * Only team owners and admins can update regular member info.
     * Only team owners can update admin info.
     * 
     * Required parameters:
     * - accountId: The account ID of the team member to update
     * - operatorId: The account ID of the operator (must be team owner or admin)
     * - teamId: The ID of the team
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * 
     * Optional parameters:
     * - teamNick: Member nickname in the team
     * - chatBanned: Whether the member is banned from chatting
     * - messageNotifyState: How this member is notified of new team messages
     * - extension: Custom extension field (not persisted, max 512 chars, only valid for advanced teams)
     * - serverExtension: Server custom extension field (persisted)
     * 
     * @param request request containing update operation details
     * @return result containing the updated team member information
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<UpdateTeamMemberResponseV2> updateTeamMember(UpdateTeamMemberRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("Operator ID cannot be null or empty");
        }
        
        if (request.getTeamId() == null) {
            throw new IllegalArgumentException("Team ID cannot be null");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        // Validate message notify state if provided
        if (request.getMessageNotifyState() != null && 
                (request.getMessageNotifyState() < 0 || request.getMessageNotifyState() > 2)) {
            throw new IllegalArgumentException("Invalid message notify state: must be 0, 1, or 2");
        }
        
        // Validate extension field length if provided
        if (request.getExtension() != null && request.getExtension().length() > 512) {
            throw new IllegalArgumentException("Extension field cannot exceed 512 characters");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamMemberUrlContextV2.UPDATE_TEAM_MEMBER.replace("{account_id}", request.getAccountId());
        
        // Remove accountId from the JSON body as it's in the URL path
        UpdateTeamMemberRequestV2 requestBodyObj = new UpdateTeamMemberRequestV2();
        requestBodyObj.setOperatorId(request.getOperatorId());
        requestBodyObj.setTeamId(request.getTeamId());
        requestBodyObj.setTeamType(request.getTeamType());
        requestBodyObj.setTeamNick(request.getTeamNick());
        requestBodyObj.setChatBanned(request.getChatBanned());
        requestBodyObj.setMessageNotifyState(request.getMessageNotifyState());
        requestBodyObj.setExtension(request.getExtension());
        requestBodyObj.setServerExtension(request.getServerExtension());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(requestBodyObj);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            TeamMemberUrlContextV2.UPDATE_TEAM_MEMBER,
            endpoint,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateTeamMemberResponseV2.class);
    }
    
    /**
     * Batch mute team members
     * 
     * This method allows batch muting/unmuting of team members.
     * Maximum 10 members can be muted/unmuted in a single request.
     * 
     * For advanced teams, only the team owner can batch mute members.
     * For super teams, team owners and admins can mute regular members,
     * but only owners can mute admins.
     * 
     * Required parameters:
     * - operatorId: The account ID of the operator (must be team owner or admin)
     * - teamId: The ID of the team
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * - chatBanAccountIds: List of account IDs to mute/unmute (max 10)
     * 
     * Optional parameters:
     * - chatBanned: Whether to mute (true) or unmute (false) the members
     * 
     * @param request request containing batch mute operation details
     * @return result containing the successfully muted accounts and any failed operations
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<BatchMuteTeamMembersResponseV2> batchMuteTeamMembers(BatchMuteTeamMembersRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getOperatorId() == null || request.getOperatorId().isEmpty()) {
            throw new IllegalArgumentException("Operator ID cannot be null or empty");
        }
        
        if (request.getTeamId() == null) {
            throw new IllegalArgumentException("Team ID cannot be null");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        if (request.getChatBanAccountIds() == null || request.getChatBanAccountIds().isEmpty()) {
            throw new IllegalArgumentException("Chat ban account IDs list cannot be null or empty");
        }
        
        if (request.getChatBanAccountIds().size() > 10) {
            throw new IllegalArgumentException("Cannot mute/unmute more than 10 accounts in a single request");
        }
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            TeamMemberUrlContextV2.BATCH_MUTE_TEAM_MEMBERS,
            TeamMemberUrlContextV2.BATCH_MUTE_TEAM_MEMBERS,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchMuteTeamMembersResponseV2.class);
    }
    
    /**
     * Query teams an account has joined
     * 
     * This method retrieves detailed information about all teams an account has joined,
     * including team name, owner, member count, and other configuration.
     * Results can be paginated with a maximum of 100 teams per page.
     * 
     * Required parameters:
     * - accountId: The account ID to query joined teams for
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * 
     * Optional parameters:
     * - pageToken: Pagination token for fetching subsequent pages
     * - limit: Maximum number of teams to return per page (max 100)
     * - needReturnMemberInfo: Whether to return member info (0=no, 1=yes)
     * 
     * @param request request containing query parameters
     * @return result containing the list of joined teams
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<QueryJoinedTeamsResponseV2> queryJoinedTeams(QueryJoinedTeamsRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        // Validate limit if provided
        if (request.getLimit() != null) {
            if (request.getLimit() <= 0 || request.getLimit() > 100) {
                throw new IllegalArgumentException("Limit must be between 1 and 100");
            }
        }
        
        // Validate needReturnMemberInfo if provided
        if (request.getNeedReturnMemberInfo() != null && 
                request.getNeedReturnMemberInfo() != 0 && 
                request.getNeedReturnMemberInfo() != 1) {
            throw new IllegalArgumentException("Need return member info must be 0 or 1");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamMemberUrlContextV2.JOINED_TEAMS.replace("{account_id}", request.getAccountId());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        if (request.getNeedReturnMemberInfo() != null) {
            queryParams.put("need_return_member_info", request.getNeedReturnMemberInfo().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamMemberUrlContextV2.JOINED_TEAMS,
            endpoint,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, QueryJoinedTeamsResponseV2.class);
    }
} 