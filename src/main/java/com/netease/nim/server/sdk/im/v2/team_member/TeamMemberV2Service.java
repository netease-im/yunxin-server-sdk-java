package com.netease.nim.server.sdk.im.v2.team_member;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
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
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;


public class TeamMemberV2Service implements ITeamMemberV2Service {

    private final YunxinApiHttpClient httpClient;

    public TeamMemberV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public Result<InviteTeamMembersResponseV2> inviteTeamMembers(InviteTeamMembersRequestV2 request) throws YunxinSdkException {

        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            TeamMemberV2UrlContext.INVITE_TEAM_MEMBERS,
            TeamMemberV2UrlContext.INVITE_TEAM_MEMBERS,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, InviteTeamMembersResponseV2.class);
    }

    @Override
    public Result<KickTeamMembersResponseV2> kickTeamMembers(KickTeamMembersRequestV2 request) throws YunxinSdkException {
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
            TeamMemberV2UrlContext.KICK_TEAM_MEMBERS,
            TeamMemberV2UrlContext.KICK_TEAM_MEMBERS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, KickTeamMembersResponseV2.class);
    }

    @Override
    public Result<LeaveTeamResponseV2> leaveTeam(LeaveTeamRequestV2 request) throws YunxinSdkException {

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
            TeamMemberV2UrlContext.LEAVE_TEAM,
            TeamMemberV2UrlContext.LEAVE_TEAM,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, LeaveTeamResponseV2.class);
    }

    @Override
    public Result<UpdateTeamMemberResponseV2> updateTeamMember(UpdateTeamMemberRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = TeamMemberV2UrlContext.UPDATE_TEAM_MEMBER.replace("{account_id}", request.getAccountId());
        
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
            TeamMemberV2UrlContext.UPDATE_TEAM_MEMBER,
            path,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, UpdateTeamMemberResponseV2.class);
    }

    @Override
    public Result<BatchMuteTeamMembersResponseV2> batchMuteTeamMembers(BatchMuteTeamMembersRequestV2 request) throws YunxinSdkException {

        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH,
            TeamMemberV2UrlContext.BATCH_MUTE_TEAM_MEMBERS,
            TeamMemberV2UrlContext.BATCH_MUTE_TEAM_MEMBERS,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, BatchMuteTeamMembersResponseV2.class);
    }

    @Override
    public Result<QueryJoinedTeamsResponseV2> queryJoinedTeams(QueryJoinedTeamsRequestV2 request) throws YunxinSdkException {

        // Replace the path parameter in the URL
        String path = TeamMemberV2UrlContext.JOINED_TEAMS.replace("{account_id}", request.getAccountId());
        
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
            TeamMemberV2UrlContext.JOINED_TEAMS,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, QueryJoinedTeamsResponseV2.class);
    }
} 