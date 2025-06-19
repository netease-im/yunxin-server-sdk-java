package com.netease.nim.server.sdk.im.v2.team;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.team.request.AddTeamManagersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.BatchQueryTeamInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.BatchQueryTeamOnlineMembersCountRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.CreateTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.DisbandTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.GetTeamInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.ListOnlineTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.ListTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.RemoveTeamManagersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.TransferTeamOwnerRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.UpdateTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.response.AddTeamManagersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.BatchQueryTeamInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.BatchQueryTeamOnlineMembersCountResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.CreateTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.DisbandTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.GetTeamInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.ListOnlineTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.ListTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.RemoveTeamManagersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.TransferTeamOwnerResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.UpdateTeamResponseV2;

/**
 * Interface for Team V2 operations
 */
public interface ITeamV2Service {

    /**
     * Create a team
     * 
     * API: POST https://open.yunxinapi.com/im/v2.1/teams
     * 
     * @param request request containing team information
     * @return result containing the created team details and failed accounts
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateTeamResponseV2> createTeam(CreateTeamRequestV2 request) throws YunxinSdkException;
    
    /**
     * Update a team
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2.1/teams/{team_id}
     * 
     * @param request request containing updated team information
     * @return result containing the updated team details
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateTeamResponseV2> updateTeam(UpdateTeamRequestV2 request) throws YunxinSdkException;
    
    /**
     * Disband a team
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/teams/{team_id}
     * 
     * This method allows disbanding of an advanced team or super team.
     * Only the team owner can disband a team.
     * 
     * @param request request containing team ID, team type and optional parameters
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     */
    Result<DisbandTeamResponseV2> disbandTeam(DisbandTeamRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch query team information
     * 
     * API: GET https://open.yunxinapi.com/im/v2/teams
     * 
     * This method allows querying detailed information for multiple teams at once.
     * For advanced teams, maximum 30 teams can be queried in a single request.
     * For super teams, maximum 20 teams can be queried in a single request.
     * 
     * @param request request containing list of team IDs and team type
     * @return result containing the list of team information and any invalid team IDs
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchQueryTeamInfoResponseV2> batchQueryTeamInfo(BatchQueryTeamInfoRequestV2 request) throws YunxinSdkException;
    
    /**
     * Transfer team ownership to a new owner
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/teams/{team_id}/actions/transfer_owner
     * 
     * This method allows transferring ownership of an advanced team or super team to a new owner.
     * The original owner can choose to leave the team or stay as a regular member.
     * 
     * @param request request containing transfer information including team ID
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     */
    Result<TransferTeamOwnerResponseV2> transferOwner(TransferTeamOwnerRequestV2 request) throws YunxinSdkException;
    
    /**
     * Add team managers
     * 
     * API: POST https://open.yunxinapi.com/im/v2/teams/{team_id}/actions/add_manager
     * 
     * This method allows adding team managers to advanced teams or super teams.
     * Only the team owner can add team managers.
     * Maximum 10 managers can be added in a single request.
     * 
     * @param request request containing the team ID and list of managers to add
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     */
    Result<AddTeamManagersResponseV2> addManagers(AddTeamManagersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Remove team managers
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/teams/{team_id}/actions/remove_manager
     * 
     * This method allows removing team managers from advanced teams or super teams.
     * Only the team owner can remove team managers.
     * Maximum 10 managers can be removed in a single request.
     * 
     * @param request request containing the team ID and list of managers to remove
     * @return result containing an empty data object on success
     * @throws YunxinSdkException exception on network error
     */
    Result<RemoveTeamManagersResponseV2> removeManagers(RemoveTeamManagersRequestV2 request) throws YunxinSdkException;

    /**
     * Get team information
     * 
     * API: GET https://open.yunxinapi.com/im/v2.1/teams/{team_id}
     * 
     * This method retrieves detailed information about a team, including its
     * properties and configuration.
     * 
     * @param request request containing query parameters including team ID and team type
     * @return result containing the team information
     * @throws YunxinSdkException exception on network error
     */
    Result<GetTeamInfoResponseV2> getTeamInfo(GetTeamInfoRequestV2 request) throws YunxinSdkException;
    
    /**
     * List team members
     * 
     * API: GET https://open.yunxinapi.com/im/v2/teams/{team_id}/actions/list_members
     * 
     * This method allows paginated querying of team members list. It can also filter
     * members by member type and chat banned status.
     * 
     * @param request request containing query parameters including team ID, team type, 
     *                filters, and pagination options
     * @return result containing the paginated team members list
     * @throws YunxinSdkException exception on network error
     */
    Result<ListTeamMembersResponseV2> listTeamMembers(ListTeamMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * List online team members
     * 
     * API: GET https://open.yunxinapi.com/im/v2/teams/{team_id}/actions/list_online_members
     * 
     * This method allows querying online members in an advanced team, including
     * information about their online status and login devices.
     * 
     * Note: This API is available only for IM Flagship Edition or above.
     * Currently, it only supports Advanced Teams (team_type = 1).
     * 
     * @param request request containing query parameters including team ID and team type
     * @return result containing the online team members list
     * @throws YunxinSdkException exception on network error
     */
    Result<ListOnlineTeamMembersResponseV2> listOnlineTeamMembers(ListOnlineTeamMembersRequestV2 request) 
            throws YunxinSdkException;
    
    /**
     * Batch query team online members count
     * 
     * API: GET https://open.yunxinapi.com/im/v2/teams/actions/online_members_count
     * 
     * This method allows batch querying of online members count in multiple advanced teams.
     * Maximum 100 teams can be queried in a single request.
     * 
     * Note: This API is available only for IM Flagship Edition or above.
     * Currently, it only supports Advanced Teams (team_type = 1).
     * 
     * @param request request containing team IDs and team type
     * @return result containing online and offline member counts for each team
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchQueryTeamOnlineMembersCountResponseV2> batchQueryTeamOnlineMembersCount(
            BatchQueryTeamOnlineMembersCountRequestV2 request) throws YunxinSdkException;
} 