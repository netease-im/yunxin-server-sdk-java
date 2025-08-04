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

    Result<CreateTeamResponseV2> createTeam(CreateTeamRequestV2 request) throws YunxinSdkException;
    
    Result<UpdateTeamResponseV2> updateTeam(UpdateTeamRequestV2 request) throws YunxinSdkException;

    Result<DisbandTeamResponseV2> disbandTeam(DisbandTeamRequestV2 request) throws YunxinSdkException;

    Result<BatchQueryTeamInfoResponseV2> batchQueryTeamInfo(BatchQueryTeamInfoRequestV2 request) throws YunxinSdkException;

    Result<TransferTeamOwnerResponseV2> transferOwner(TransferTeamOwnerRequestV2 request) throws YunxinSdkException;
    
    Result<AddTeamManagersResponseV2> addManagers(AddTeamManagersRequestV2 request) throws YunxinSdkException;

    Result<RemoveTeamManagersResponseV2> removeManagers(RemoveTeamManagersRequestV2 request) throws YunxinSdkException;

    Result<GetTeamInfoResponseV2> getTeamInfo(GetTeamInfoRequestV2 request) throws YunxinSdkException;
    
    Result<ListTeamMembersResponseV2> listTeamMembers(ListTeamMembersRequestV2 request) throws YunxinSdkException;

    Result<ListOnlineTeamMembersResponseV2> listOnlineTeamMembers(ListOnlineTeamMembersRequestV2 request) throws YunxinSdkException;

    Result<BatchQueryTeamOnlineMembersCountResponseV2> batchQueryTeamOnlineMembersCount(BatchQueryTeamOnlineMembersCountRequestV2 request) throws YunxinSdkException;
} 