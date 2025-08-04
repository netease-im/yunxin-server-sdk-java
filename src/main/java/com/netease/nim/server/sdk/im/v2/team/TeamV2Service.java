package com.netease.nim.server.sdk.im.v2.team;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
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
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

public class TeamV2Service implements ITeamV2Service {

    private final YunxinApiHttpClient httpClient;

    public TeamV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateTeamResponseV2> createTeam(CreateTeamRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            TeamV2UrlContext.CREATE_TEAM,
            TeamV2UrlContext.CREATE_TEAM,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, CreateTeamResponseV2.class);
    }

    @Override
    public Result<UpdateTeamResponseV2> updateTeam(UpdateTeamRequestV2 request) throws YunxinSdkException {
        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.UPDATE_TEAM.replace("{team_id}", String.valueOf(request.getTeamId()));
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            path,
            path,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateTeamResponseV2.class);
    }

    @Override
    public Result<DisbandTeamResponseV2> disbandTeam(DisbandTeamRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
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

        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.DISBAND_TEAM.replace("{team_id}", request.getTeamId().toString());

        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        if (request.getOperatorId() != null) {
            queryParams.put("operator_id", request.getOperatorId());
        }
        if (request.getTeamType() != null) {
            queryParams.put("team_type", String.valueOf(request.getTeamType()));
        }
        if (request.getExtension() != null) {
            queryParams.put("extension", request.getExtension());
        }

        YunxinApiResponse apiResponse = httpClient.executeV2Api(
                HttpMethod.DELETE,
                path,
                path,
                queryParams,
                null
        );

        return ResultUtils.convert(apiResponse, DisbandTeamResponseV2.class);
    }

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

        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        queryParams.put("team_ids", JSONObject.toJSONString(request.getTeamIds()));
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamV2UrlContext.BATCH_QUERY_TEAMS,
            TeamV2UrlContext.BATCH_QUERY_TEAMS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryTeamInfoResponseV2.class);
    }

    @Override
    public Result<TransferTeamOwnerResponseV2> transferOwner(TransferTeamOwnerRequestV2 request) 
            throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
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
        
        if (request.getNewOwnerAccountId() == null || request.getNewOwnerAccountId().isEmpty()) {
            throw new IllegalArgumentException("New owner account ID cannot be null or empty");
        }
        
        if (request.getLeave() == null) {
            throw new IllegalArgumentException("Leave parameter cannot be null");
        }
        
        if (request.getLeave() != 1 && request.getLeave() != 2) {
            throw new IllegalArgumentException("Invalid leave parameter: must be 1 (Leave) or 2 (Stay as a regular member)");
        }
        
        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.TRANSFER_OWNER.replace("{team_id}", request.getTeamId().toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            TeamV2UrlContext.TRANSFER_OWNER,
            path,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, TransferTeamOwnerResponseV2.class);
    }

    @Override
    public Result<AddTeamManagersResponseV2> addManagers(AddTeamManagersRequestV2 request) 
            throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
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
        
        if (request.getManagers() == null || request.getManagers().isEmpty()) {
            throw new IllegalArgumentException("Managers list cannot be null or empty");
        }

        
        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.ADD_MANAGER.replace("{team_id}", request.getTeamId().toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            TeamV2UrlContext.ADD_MANAGER,
            path,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, AddTeamManagersResponseV2.class);
    }

    @Override
    public Result<RemoveTeamManagersResponseV2> removeManagers(RemoveTeamManagersRequestV2 request) 
            throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
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
        
        if (request.getManagers() == null || request.getManagers().isEmpty()) {
            throw new IllegalArgumentException("Managers list cannot be null or empty");
        }


        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.REMOVE_MANAGER.replace("{team_id}", request.getTeamId().toString());
        
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            TeamV2UrlContext.REMOVE_MANAGER,
            path,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, RemoveTeamManagersResponseV2.class);
    }


    @Override
    public Result<GetTeamInfoResponseV2> getTeamInfo(GetTeamInfoRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
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
        
        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.GET_TEAM_INFO.replace("{team_id}", request.getTeamId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamV2UrlContext.GET_TEAM_INFO,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, GetTeamInfoResponseV2.class);
    }

    @Override
    public Result<ListTeamMembersResponseV2> listTeamMembers(ListTeamMembersRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
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
        
        // Validate optional parameters
        if (request.getMemberType() != null && (request.getMemberType() < 0 || request.getMemberType() > 2)) {
            throw new IllegalArgumentException("Invalid member type: must be 0 (All), 1 (Owner/Managers), or 2 (Regular members)");
        }
        
        if (request.getChatBannedType() != null && (request.getChatBannedType() < 0 || request.getChatBannedType() > 2)) {
            throw new IllegalArgumentException("Invalid chat banned type: must be 0 (All), 1 (Banned), or 2 (Not banned)");
        }
        
        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.LIST_TEAM_MEMBERS.replace("{team_id}", request.getTeamId().toString());
        
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
            TeamV2UrlContext.LIST_TEAM_MEMBERS,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListTeamMembersResponseV2.class);
    }

    @Override
    public Result<ListOnlineTeamMembersResponseV2> listOnlineTeamMembers(ListOnlineTeamMembersRequestV2 request) 
            throws YunxinSdkException {
        
        // Validate required parameters
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        
        if (request.getTeamId() == null) {
            throw new IllegalArgumentException("Team ID cannot be null");
        }
        
        if (request.getTeamType() == null) {
            throw new IllegalArgumentException("Team type cannot be null");
        }
        
        if (request.getTeamType() != 1) {
            throw new IllegalArgumentException("Invalid team type: must be 1 (Advanced team). " +
                    "Currently, this API only supports Advanced Teams.");
        }
        
        // Replace the path parameter in the URL
        String path = TeamV2UrlContext.LIST_ONLINE_TEAM_MEMBERS.replace("{team_id}", request.getTeamId().toString());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamV2UrlContext.LIST_ONLINE_TEAM_MEMBERS,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListOnlineTeamMembersResponseV2.class);
    }

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
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("team_type", request.getTeamType().toString());
        queryParams.put("team_ids", request.getTeamIds().stream()
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining(",")));
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            TeamV2UrlContext.BATCH_QUERY_TEAM_ONLINE_MEMBERS_COUNT,
            TeamV2UrlContext.BATCH_QUERY_TEAM_ONLINE_MEMBERS_COUNT,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, BatchQueryTeamOnlineMembersCountResponseV2.class);
    }
} 