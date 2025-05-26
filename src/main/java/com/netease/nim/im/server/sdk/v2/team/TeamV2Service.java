package com.netease.nim.im.server.sdk.v2.team;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.team.request.AddTeamManagersRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.BatchQueryTeamInfoRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.BatchQueryTeamOnlineMembersCountRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.CreateTeamRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.DisbandTeamRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.GetTeamInfoRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.ListOnlineTeamMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.ListTeamMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.RemoveTeamManagersRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.TransferTeamOwnerRequestV2;
import com.netease.nim.im.server.sdk.v2.team.request.UpdateTeamRequestV2;
import com.netease.nim.im.server.sdk.v2.team.response.AddTeamManagersResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.BatchQueryTeamInfoResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.BatchQueryTeamOnlineMembersCountResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.CreateTeamResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.DisbandTeamResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.GetTeamInfoResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.ListOnlineTeamMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.ListTeamMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.RemoveTeamManagersResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.TransferTeamOwnerResponseV2;
import com.netease.nim.im.server.sdk.v2.team.response.UpdateTeamResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation for Team V2 operations
 * 
 * This service provides methods for managing teams, including:
 * - Creating teams
 * - Updating teams
 * - Disbanding teams
 * - Transferring team ownership
 * - Adding team managers
 * - Removing team managers
 * - Getting team information
 * - Listing team members
 * - Batch querying team information
 * - Listing online team members
 * - Batch querying online members count
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis
 * 
 * Note on rate limiting:
 * Default maximum call frequency is subject to the rate limiting rules.
 * Check the API documentation for specific limits.
 */
public class TeamV2Service implements ITeamV2Service {

    private final YunxinApiHttpClient httpClient;

    public TeamV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Create a team
     * 
     * This method creates either an advanced team or a super team depending
     * on the teamType parameter in the request.
     * 
     * Required parameters:
     * - ownerAccountId: The team owner's account ID
     * - teamType: 1 for advanced team, 2 for super team
     * - name: The team name
     * - inviteAccountIds: List of account IDs to invite
     * - inviteMsg: Invitation message
     * - configuration: Team configuration settings
     */
    @Override
    public Result<CreateTeamResponseV2> createTeam(CreateTeamRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            TeamUrlContextV2.CREATE_TEAM,
            TeamUrlContextV2.CREATE_TEAM,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateTeamResponseV2.class);
    }
    
    /**
     * Update a team
     * 
     * This method updates an existing team's information and configuration.
     * 
     * Required parameters:
     * - teamId: The ID of the team to update (path parameter)
     * - teamType: 1 for advanced team, 2 for super team
     * 
     * Optional parameters:
     * - operatorId: The account ID of the operator (must be team owner or admin)
     * - name: Updated team name
     * - icon: Updated team icon URL
     * - announcement: Updated team announcement
     * - intro: Updated team introduction
     * - membersLimit: Updated maximum number of members
     * - configuration: Updated team configuration settings
     */
    @Override
    public Result<UpdateTeamResponseV2> updateTeam(Long teamId, UpdateTeamRequestV2 request) throws YunxinSdkException {
        if (teamId == null) {
            throw new IllegalArgumentException("Team ID cannot be null");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.UPDATE_TEAM.replace("{team_id}", teamId.toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            endpoint,
            endpoint,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateTeamResponseV2.class);
    }
    
    /**
     * Disband a team
     * 
     * This method allows disbanding of an advanced team or super team.
     * Only the team owner can disband a team.
     * 
     * Required parameters:
     * - teamId: The ID of the team to disband (in request, used in URL path)
     * - teamType: 1 for advanced team, 2 for super team
     * 
     * Optional parameters:
     * - operatorId: The account ID of the operator (must be team owner)
     * - extension: Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     * 
     * @param request request containing team ID, team type and optional parameters
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<DisbandTeamResponseV2> disbandTeam(DisbandTeamRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
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
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.DISBAND_TEAM.replace("{team_id}", request.getTeamId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            TeamUrlContextV2.DISBAND_TEAM,
            endpoint,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, DisbandTeamResponseV2.class);
    }
    
    /**
     * Batch query team information
     * 
     * This method allows querying detailed information for multiple teams at once.
     * For advanced teams, maximum 30 teams can be queried in a single request.
     * For super teams, maximum 20 teams can be queried in a single request.
     * 
     * Required parameters:
     * - teamIds: List of team IDs to query
     * - teamType: 1 for advanced team, 2 for super team
     * 
     * @param request request containing list of team IDs and team type
     * @return result containing the list of team information and any invalid team IDs
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<BatchQueryTeamInfoResponseV2> batchQueryTeamInfo(BatchQueryTeamInfoRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamIds() == null || request.getTeamIds().isEmpty()) {
            throw new IllegalArgumentException("Team IDs list cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        // Validate team IDs count based on team type
        int maxTeams = request.getTeamType() == 1 ? 30 : 20; // 30 for advanced teams, 20 for super teams
        if (request.getTeamIds().size() > maxTeams) {
            throw new IllegalArgumentException("Too many team IDs. Maximum " + maxTeams + " teams allowed for team type " + request.getTeamType());
        }
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        queryParams.put("team_ids", request.getTeamIds().toString());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamUrlContextV2.BATCH_QUERY_TEAMS,
            TeamUrlContextV2.BATCH_QUERY_TEAMS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryTeamInfoResponseV2.class);
    }
    
    /**
     * Transfer team ownership to a new owner
     * 
     * This method allows transferring ownership of an advanced team or super team to a new owner.
     * The original owner can choose to leave the team or stay as a regular member.
     * 
     * Required parameters:
     * - teamId: The ID of the team to transfer (in request)
     * - teamType: 1 for advanced team, 2 for super team
     * - newOwnerAccountId: The account ID of the new team owner
     * - leave: Whether the original owner leaves the team (1: Leave, 2: Stay as a regular member)
     * 
     * Optional parameters:
     * - extension: Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     * 
     * @param request request containing transfer information including team ID
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<TransferTeamOwnerResponseV2> transferOwner(TransferTeamOwnerRequestV2 request) 
            throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        if (request.getNewOwnerAccountId() == null || request.getNewOwnerAccountId().isEmpty()) {
            throw new IllegalArgumentException("New owner account ID cannot be null or empty");
        }
        
        if (request.getLeave() == null) {
            throw new IllegalArgumentException("Leave parameter cannot be null");
        }
        
        if (request.getLeave() != 1 && request.getLeave() != 2) {
            throw new IllegalArgumentException("Invalid leave parameter: must be 1 (Leave) or 2 (Stay as a regular member)");
        }
        
        // Validate extension field length if provided
        if (request.getExtension() != null && request.getExtension().length() > 512) {
            throw new IllegalArgumentException("Extension field cannot exceed 512 characters");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.TRANSFER_OWNER.replace("{team_id}", request.getTeamId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            TeamUrlContextV2.TRANSFER_OWNER,
            endpoint,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, TransferTeamOwnerResponseV2.class);
    }
    
    /**
     * Add team managers
     * 
     * This method allows adding team managers to advanced teams or super teams.
     * Only the team owner can add team managers.
     * Maximum 10 managers can be added in a single request.
     * 
     * Required parameters:
     * - teamId: The ID of the team (in request, used in URL path)
     * - teamType: 1 for advanced team, 2 for super team
     * - managers: List of account IDs to add as managers (max 10)
     * 
     * Optional parameters:
     * - operatorId: The account ID of the operator (must be team owner)
     * - extension: Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     * 
     * @param request request containing the team ID and list of managers to add
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<AddTeamManagersResponseV2> addManagers(AddTeamManagersRequestV2 request) 
            throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        if (request.getManagers() == null || request.getManagers().isEmpty()) {
            throw new IllegalArgumentException("Managers list cannot be null or empty");
        }
        
        if (request.getManagers().size() > 10) {
            throw new IllegalArgumentException("Cannot add more than 10 managers in a single request");
        }
        
        // Validate extension field length if provided
        if (request.getExtension() != null && request.getExtension().length() > 512) {
            throw new IllegalArgumentException("Extension field cannot exceed 512 characters");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.ADD_MANAGER.replace("{team_id}", request.getTeamId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            TeamUrlContextV2.ADD_MANAGER,
            endpoint,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, AddTeamManagersResponseV2.class);
    }
    
    /**
     * Remove team managers
     * 
     * This method allows removing team managers from advanced teams or super teams,
     * reverting them to regular team members.
     * Only the team owner can remove team managers.
     * Maximum 10 managers can be removed in a single request.
     * 
     * Required parameters:
     * - teamId: The ID of the team (in request, used in URL path)
     * - teamType: 1 for advanced team, 2 for super team
     * - managers: List of account IDs to remove as managers (max 10)
     * 
     * Optional parameters:
     * - operatorId: The account ID of the operator (must be team owner)
     * - extension: Custom extension field (JSON format, max 512 chars, only valid for advanced teams)
     * 
     * @param request request containing the team ID and list of managers to remove
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<RemoveTeamManagersResponseV2> removeManagers(RemoveTeamManagersRequestV2 request) 
            throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        if (request.getManagers() == null || request.getManagers().isEmpty()) {
            throw new IllegalArgumentException("Managers list cannot be null or empty");
        }
        
        if (request.getManagers().size() > 10) {
            throw new IllegalArgumentException("Cannot remove more than 10 managers in a single request");
        }
        
        // Validate extension field length if provided
        if (request.getExtension() != null && request.getExtension().length() > 512) {
            throw new IllegalArgumentException("Extension field cannot exceed 512 characters");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.REMOVE_MANAGER.replace("{team_id}", request.getTeamId());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            TeamUrlContextV2.REMOVE_MANAGER,
            endpoint,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, RemoveTeamManagersResponseV2.class);
    }
    
    /**
     * Get team information
     * 
     * This method retrieves detailed information about a team, including its
     * properties and configuration.
     * 
     * Required parameters:
     * - teamId: The ID of the team to query
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * 
     * @param teamId the ID of the team to query
     * @param teamType the team type (1 for advanced team, 2 for super team)
     * @return result containing the team information
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     * @deprecated Use {@link #getTeamInfo(GetTeamInfoRequestV2)} instead
     */
    @Override
    @Deprecated
    public Result<GetTeamInfoResponseV2> getTeamInfo(String teamId, Integer teamType) throws YunxinSdkException {
        // Create a request object and delegate to the new method
        GetTeamInfoRequestV2 request = new GetTeamInfoRequestV2(teamId, teamType);
        return getTeamInfo(request);
    }
    
    /**
     * Get team information
     * 
     * This method retrieves detailed information about a team, including its
     * properties and configuration.
     * 
     * Required parameters:
     * - teamId: The ID of the team to query
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * 
     * @param request request containing query parameters including team ID and team type
     * @return result containing the team information
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<GetTeamInfoResponseV2> getTeamInfo(GetTeamInfoRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.GET_TEAM_INFO.replace("{team_id}", request.getTeamId());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamUrlContextV2.GET_TEAM_INFO,
            endpoint,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, GetTeamInfoResponseV2.class);
    }
    
    /**
     * List team members
     * 
     * This method allows paginated querying of team members list. It can also filter
     * members by member type and chat banned status.
     * 
     * Required parameters:
     * - teamId: The ID of the team
     * - teamType: The team type (1 for advanced team, 2 for super team)
     * 
     * Optional parameters:
     * - memberType: Filter for member type (0: all, 1: owner/managers, 2: regular members)
     * - chatBannedType: Filter for chat banned status (0: all, 1: banned, 2: not banned)
     * - descending: Sort by join time (true: descending, false: ascending)
     * - pageToken: Pagination token for subsequent pages
     * - limit: Number of members to return per page (max 100)
     * 
     * @param request request containing query parameters
     * @return result containing the paginated team members list
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ListTeamMembersResponseV2> listTeamMembers(ListTeamMembersRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1 && request.getTeamType() != 2) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team) or 2 (Super team)");
        }
        
        // Validate optional parameters
        if (request.getMemberType() != null && (request.getMemberType() < 0 || request.getMemberType() > 2)) {
            throw new IllegalArgumentException("Invalid member type: must be 0 (All), 1 (Owner/Managers), or 2 (Regular members)");
        }
        
        if (request.getChatBannedType() != null && (request.getChatBannedType() < 0 || request.getChatBannedType() > 2)) {
            throw new IllegalArgumentException("Invalid chat banned type: must be 0 (All), 1 (Banned), or 2 (Not banned)");
        }
        
        if (request.getLimit() != null && (request.getLimit() <= 0 || request.getLimit() > 100)) {
            throw new IllegalArgumentException("Invalid limit: must be between 1 and 100");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.LIST_TEAM_MEMBERS.replace("{team_id}", request.getTeamId());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        
        // Add optional parameters if provided
        if (request.getMemberType() != null) {
            queryParams.put("member_type", request.getMemberType().toString());
        }
        
        if (request.getChatBannedType() != null) {
            queryParams.put("chat_banned_type", request.getChatBannedType().toString());
        }
        
        if (request.getDescending() != null) {
            queryParams.put("descending", request.getDescending().toString());
        }
        
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamUrlContextV2.LIST_TEAM_MEMBERS,
            endpoint,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListTeamMembersResponseV2.class);
    }

    /**
     * List online team members
     * 
     * This method allows querying online members in an advanced team, including
     * information about their online status and login devices.
     * 
     * Required parameters:
     * - teamId: The ID of the team
     * - teamType: Currently, only team_type = 1 (Advanced team) is supported
     * 
     * Note: This API is available only for IM Flagship Edition or above.
     * 
     * @param request request containing query parameters including team ID and team type
     * @return result containing the online team members list
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<ListOnlineTeamMembersResponseV2> listOnlineTeamMembers(ListOnlineTeamMembersRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null || request.getTeamId().isEmpty()) {
            throw new IllegalArgumentException("Team ID cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team). " +
                    "Currently, this API only supports Advanced Teams.");
        }
        
        // Replace the path parameter in the URL
        String endpoint = TeamUrlContextV2.LIST_ONLINE_TEAM_MEMBERS.replace("{team_id}", request.getTeamId());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamUrlContextV2.LIST_ONLINE_TEAM_MEMBERS,
            endpoint,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListOnlineTeamMembersResponseV2.class);
    }

    /**
     * Batch query team online members count
     * 
     * This method allows batch querying of online members count in multiple advanced teams.
     * Maximum 100 teams can be queried in a single request.
     * 
     * Required parameters:
     * - teamIds: List of team IDs to query (maximum 100)
     * - teamType: Currently, only team_type = 1 (Advanced team) is supported
     * 
     * Note: This API is available only for IM Flagship Edition or above.
     * 
     * @param request request containing team IDs and team type
     * @return result containing online and offline member counts for each team
     * @throws YunxinSdkException exception on network error
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    @Override
    public Result<BatchQueryTeamOnlineMembersCountResponseV2> batchQueryTeamOnlineMembersCount(
            BatchQueryTeamOnlineMembersCountRequestV2 request) throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamIds() == null || request.getTeamIds().isEmpty()) {
            throw new IllegalArgumentException("Team IDs list cannot be null or empty");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team). " +
                    "Currently, this API only supports Advanced Teams.");
        }
        
        // Validate team IDs count
        if (request.getTeamIds().size() > 100) {
            throw new IllegalArgumentException("Too many team IDs. Maximum 100 teams allowed in a single request.");
        }
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        queryParams.put("team_ids", String.join(",", request.getTeamIds()));
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamUrlContextV2.BATCH_QUERY_TEAM_ONLINE_MEMBERS_COUNT,
            TeamUrlContextV2.BATCH_QUERY_TEAM_ONLINE_MEMBERS_COUNT,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryTeamOnlineMembersCountResponseV2.class);
    }
} 