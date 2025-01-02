package com.netease.nim.im.server.sdk.v1.team;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.annotation.YunxinParamUtils;
import com.netease.nim.im.server.sdk.v1.team.request.*;
import com.netease.nim.im.server.sdk.v1.team.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hekaijie on 2024/12/24
 */
public class TeamV1Service implements ITeamV1Service {

    private final YunxinApiHttpClient httpClient;

    private final static String teamUri = "/team/";

    private final static String failAccId = "faccid";

    private final static String accId = "accid";

    private final static String msg = "msg";

    private final static String CODE = "code";

    private final static String DESC = "desc";

    private final static String TID = "tid";

    public TeamV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateTeamResponseV1> createTeam(CreateTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        if (request.getMembers() != null && !request.getMembers().isEmpty()) {
            JSONArray jsonArray = (JSONArray) JSON.toJSON(request.getMembers());
            paramMap.put("members", jsonArray.toJSONString());
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/create.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        CreateTeamResponseV1 response = new CreateTeamResponseV1();
        Long tid = object.getLong(TID);
        response.setTid(tid);
        JSONObject failAccid = object.getJSONObject(failAccId);
        if (failAccid != null) {
            response.getFailAccidList().setMsg(failAccid.getString(msg));
            response.getFailAccidList().setAccid(JSON.parseArray(failAccid.getString(accId), String.class));
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DismissTeamResponseV1> dismissTeam(DismissTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/remove.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new DismissTeamResponseV1());
    }

    @Override
    public Result<AddTeamResponseV1> addTeam(AddTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        if (request.getMembers() != null && !request.getMembers().isEmpty()) {
            JSONArray jsonArray = (JSONArray) JSON.toJSON(request.getMembers());
            paramMap.put("members", jsonArray.toJSONString());
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/add.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        AddTeamResponseV1 response = new AddTeamResponseV1();
        JSONObject failAccid = object.getJSONObject(failAccId);
        if (failAccid != null) {
            response.setMsg(failAccid.getString(msg));
            response.setAccids(JSON.parseArray(failAccid.getString(accId), String.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<KickTeamResponseV1> kickTeam(KickTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        if (request.getMembers() != null && !request.getMembers().isEmpty()) {
            JSONArray jsonArray = (JSONArray) JSON.toJSON(request.getMembers());
            paramMap.put("members", jsonArray.toJSONString());
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/kick.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        KickTeamResponseV1 response = new KickTeamResponseV1();
        JSONObject failAccid = object.getJSONObject(failAccId);
        if (failAccid != null) {
            response.setMsg(failAccid.getString(msg));
            response.setAccid(JSON.parseArray(failAccid.getString(accId), String.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<UpdateTeamResponseV1> updateTeam(UpdateTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/update.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new UpdateTeamResponseV1());
    }

    @Override
    public Result<QueryTeamResponseV1> queryTeam(QueryTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/query.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryTeamResponseV1 response = new QueryTeamResponseV1();
        String array = object.getString("tinfos");
        if (array != null && !array.isEmpty()) {
            response.setTinfos(JSON.parseArray(array, QueryTeamResponseV1.TeamInfoV1.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<ChangeOwnerTeamResponseV1> changeOwnerTeam(ChangeOwnerTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/changeOwner.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new ChangeOwnerTeamResponseV1());

    }

    @Override
    public Result<AddManagerTeamResponseV1> addManagerTeam(AddManagerTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        if (request.getMembers() != null && !request.getMembers().isEmpty()) {
            JSONArray jsonArray = (JSONArray) JSON.toJSON(request.getMembers());
            paramMap.put("members", jsonArray.toJSONString());
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/addManager.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new AddManagerTeamResponseV1());

    }

    @Override
    public Result<RemoveManagerTeamResponseV1> removeManagerTeam(RemoveManagerTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        if (request.getMembers() != null && !request.getMembers().isEmpty()) {
            JSONArray jsonArray = (JSONArray) JSON.toJSON(request.getMembers());
            paramMap.put("members", jsonArray.toJSONString());
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/removeManager.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new RemoveManagerTeamResponseV1());

    }

    @Override
    public Result<JoinsTeamResponseV1> queryJoinedTeamListByAccId(JoinsTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/joinTeams.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        JoinsTeamResponseV1 response = new JoinsTeamResponseV1();
        String array = object.getString("infos");
        if (array != null && !array.isEmpty()) {
            response.setInfos(JSON.parseArray(array, JoinsTeamResponseV1.JoinsTinfo.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<UpdateTeamNickResponseV1> updateTeamMemberNick(UpdateTeamNickRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/updateTeamNick.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new UpdateTeamNickResponseV1());

    }

    @Override
    public Result<LeaveTeamResponseV1> leaveTeam(LeaveTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/leave.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new LeaveTeamResponseV1());

    }

    @Override
    public Result<MuteTeamResponseV1> muteTeam(MuteTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/muteTeam.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new MuteTeamResponseV1());

    }

    @Override
    public Result<MuteTeamTargetMemberResponseV1> muteTeamTargetMember(MuteTeamTargetMemberRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/muteTlist.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new MuteTeamTargetMemberResponseV1());

    }

    @Override
    public Result<MuteTeamAllMemberResponseV1> muteTeamAllMember(MuteTeamAllMemberRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/muteTlistAll.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new MuteTeamAllMemberResponseV1());

    }

    @Override
    public Result<QueryMuteTeamMembersResponseV1> queryMuteTeamMembers(QueryMuteTeamMembersRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/listTeamMute.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryMuteTeamMembersResponseV1 response = new QueryMuteTeamMembersResponseV1();
        String array = object.getString("mutes");
        if (array != null && !array.isEmpty()) {
            response.setMutes(JSON.parseArray(array, QueryMuteTeamMembersResponseV1.muteInfo.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryTeamInfoDetailsResponseV1> queryTeamInfoDetails(QueryTeamInfoDetailsRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/queryDetail.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryTeamInfoDetailsResponseV1 response = new QueryTeamInfoDetailsResponseV1();
        JSONObject tInfo = object.getJSONObject("tinfo");
        if (tInfo != null && !tInfo.isEmpty()) {
            response.setTinfo(JSONObject.parseObject(tInfo.toJSONString(), QueryTeamInfoDetailsResponseV1.TeamInfo.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryTeamMsgMarkReadInfoResponseV1> queryTeamMsgMarkReadInfo(QueryTeamMsgMarkReadInfoRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/getMarkReadInfo.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryTeamMsgMarkReadInfoResponseV1 response = new QueryTeamMsgMarkReadInfoResponseV1();
        JSONObject data = object.getJSONObject("data");
        if (data != null && !data.isEmpty()) {
            response.setData(JSONObject.parseObject(data.toJSONString(), QueryTeamMsgMarkReadInfoResponseV1.TeamMsgMarkReadInfo.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryAllJoinedTeamMemberInfoByAccIdResponseV1> queryAllJoinedTeamMemberInfoByAccId(QueryAllJoinedTeamMemberInfoByAccIdRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/listMemberInfo.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryAllJoinedTeamMemberInfoByAccIdResponseV1 response = new QueryAllJoinedTeamMemberInfoByAccIdResponseV1();
        String data = object.getString("data");
        if (data != null && !data.isEmpty()) {
            response.setData(JSON.parseArray(data, QueryAllJoinedTeamMemberInfoByAccIdResponseV1.TeamMemberInfo.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryOnlineTeamMemberResponseV1> queryOnlineTeamMember(QueryOnlineTeamMemberRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/listOnlineUsers.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryOnlineTeamMemberResponseV1 response = new QueryOnlineTeamMemberResponseV1();
        JSONObject data = object.getJSONObject("data");
        if (data != null) {
            response.setCount(data.getIntValue("count"));

            List<QueryOnlineTeamMemberResponseV1.OnlineStatus> onlineStatusList= new ArrayList<>();
            JSONObject onlineStatus = data.getJSONObject("status");
            if (onlineStatus != null) {
                for (Map.Entry<String, Object> entry : onlineStatus.entrySet()) {
                    QueryOnlineTeamMemberResponseV1.OnlineStatus OnlineStatus = new QueryOnlineTeamMemberResponseV1.OnlineStatus();
                    List<QueryOnlineTeamMemberResponseV1.Status> statusList = new ArrayList<>();
                    String accId = entry.getKey();
                    OnlineStatus.setAccid(accId);

                    JSONArray array = (JSONArray)entry.getValue();
                    for (Object o : array) {
                        JSONObject json = (JSONObject) o;
                        QueryOnlineTeamMemberResponseV1.Status status = new QueryOnlineTeamMemberResponseV1.Status();
                        status.setClientType(json.getIntValue("clientType"));
                        status.setLoginTime(json.getLongValue("loginTime"));
                        statusList.add(status);
                    }
                    OnlineStatus.setStatusList(statusList);
                    onlineStatusList.add(OnlineStatus);
                }
            }
            response.setStatus(onlineStatusList);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<BatchQueryOnlineTeamMemberCountResponseV1> batchQueryOnlineTeamMemberCount(BatchQueryOnlineTeamMemberCountRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(teamUri + "/listOnlineUserCount.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        BatchQueryOnlineTeamMemberCountResponseV1 response = new BatchQueryOnlineTeamMemberCountResponseV1();
        String data = object.getString("data");
        if (data != null && !data.isEmpty()) {
            response.setData(JSON.parseArray(data, BatchQueryOnlineTeamMemberCountResponseV1.teamOnlineCount.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

}
