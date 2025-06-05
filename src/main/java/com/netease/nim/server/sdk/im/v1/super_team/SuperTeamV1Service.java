package com.netease.nim.server.sdk.im.v1.super_team;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.super_team.request.*;
import com.netease.nim.server.sdk.im.v1.super_team.response.*;

import java.util.List;
import java.util.Map;


public class SuperTeamV1Service implements ISuperTeamV1Service {

    private final YunxinApiHttpClient httpClient;

    private final static String failAccId = "faccid";

    private final static String accId = "accid";

    private final static String msg = "msg";

    private final static String CODE = "code";

    private final static String DESC = "desc";

    private final static String TID = "tid";

    public SuperTeamV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateSuperTeamResponseV1> createTeam(SuperTeamCreateRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        // Convert List<String> inviteAccids to JSONArray format string if not null
        if (request.getInviteAccids() != null && !request.getInviteAccids().isEmpty()) {
            paramMap.put("inviteAccids", JSON.toJSONString(request.getInviteAccids()));
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.CREATE_TEAM, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        CreateSuperTeamResponseV1 response = new CreateSuperTeamResponseV1();
        Long tid = object.getLong(TID);
        response.setTid(tid);

        JSONObject failAccid = object.getJSONObject(failAccId);
        if (failAccid != null) {
            response.getFailAccountInfo().setMsg(failAccid.getString(msg));
            response.getFailAccountInfo().setAccIdList(JSON.parseArray(failAccid.getString(accId), String.class));
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SuperTeamInviteResponseV1> invite(SuperTeamInviteRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.INVITE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SuperTeamInviteResponseV1 response = new SuperTeamInviteResponseV1();
        JSONObject failAccid = object.getJSONObject(failAccId);
        if (failAccid != null) {
            response.getFailAccountInfo().setMsg(failAccid.getString(msg));
            response.getFailAccountInfo().setAccIdList(JSON.parseArray(failAccid.getString(accId), String.class));
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SuperTeamAddManagerResponseV1> addManager(SuperTeamAddManagerRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert managerAccids list to JSON string
        if (request.getManagerAccids() != null) {
            paramMap.put("managerAccids", JSON.toJSONString(request.getManagerAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.ADD_MANAGER, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SuperTeamAddManagerResponseV1 response = new SuperTeamAddManagerResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SuperTeamChangeOwnerResponseV1> changeOwner(SuperTeamChangeOwnerRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.CHANGE_OWNER, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SuperTeamChangeOwnerResponseV1 response = new SuperTeamChangeOwnerResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SuperTeamRemoveManagerResponseV1> removeManager(SuperTeamRemoveManagerRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert managerAccids list to JSON string
        if (request.getManagerAccids() != null) {
            paramMap.put("managerAccids", JSON.toJSONString(request.getManagerAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.REMOVE_MANAGER, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SuperTeamRemoveManagerResponseV1 response = new SuperTeamRemoveManagerResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SuperTeamMuteResponseV1> mute(SuperTeamMuteRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.MUTE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SuperTeamMuteResponseV1 response = new SuperTeamMuteResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SuperTeamMuteTlistResponseV1> muteTlist(SuperTeamMuteTlistRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert muteAccids list to JSON string
        if (request.getMuteAccids() != null && !request.getMuteAccids().isEmpty()) {
            paramMap.put("muteAccids", JSON.toJSONString(request.getMuteAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.MUTE_TEAM_MEMBER, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SuperTeamMuteTlistResponseV1 response = new SuperTeamMuteTlistResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> kick(SuperTeamKickMemberRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert kickAccids list to JSON string
        if (request.getKickAccids() != null) {
            paramMap.put("kickAccids", JSON.toJSONString(request.getKickAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.KICK, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> leave(SuperTeamMemberLeaveRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.LEAVE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> updateTeamNick(SuperTeamUpdateNickRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.UPDATE_TEAM_NICK, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> updateTinfo(SuperTeamUpdateRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.UPDATE_TEAM_INFO, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> updateTlist(SuperTeamUpdateMemberInfoRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.UPDATE_T_LIST, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }


    @Override
    public Result<SuperTeamDismissResponseV1> dismiss(SuperTeamDismissRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.DISMISS, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SuperTeamDismissResponseV1 response = new SuperTeamDismissResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> changeLevel(SuperTeamChangeLevelRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.CHANGE_LEVEL, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<GetSuperTeamResponseV1> getTinfos(GetSuperTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.GET_TEAM_INFO, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        GetSuperTeamResponseV1 response = new GetSuperTeamResponseV1();
        if (object.containsKey("tinfos")) {
            List<SuperTeamInfo> teamInfoList = JSON.parseArray(object.getString("tinfos"), SuperTeamInfo.class);
            response.setTinfos(teamInfoList);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<GetSuperTeamMemberResponseV1> getTlists(GetSuperTeamMemberRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.GET_TEAM_MEMBER_LIST, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        GetSuperTeamMemberResponseV1 response = new GetSuperTeamMemberResponseV1();
        if (object.containsKey("tlists")) {
            List<SuperTeamMemberInfo> teamInfoList = JSON.parseArray(object.getString("tlists"), SuperTeamMemberInfo.class);
            response.setTeamMemberInfoList(teamInfoList);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<GetSuperTeamMuteMemberResponseV1> getMuteTlists(GetSuperTeamMuteMemberRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.GET_MUTE_MEMBER_LIST, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        GetSuperTeamMuteMemberResponseV1 response = new GetSuperTeamMuteMemberResponseV1();
        if (object.containsKey("muteTlists")) {
            List<SuperTeamMuteMemberInfo> teamInfoList = JSON.parseArray(object.getString("muteTlists"), SuperTeamMuteMemberInfo.class);
            response.setTlists(teamInfoList);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<GetJoinSuperTeamResponseV1> joinTeams(GetJoinSuperTeamRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.JOIN_TEAMS, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        GetJoinSuperTeamResponseV1 response = new GetJoinSuperTeamResponseV1();
        if (object.containsKey("tlists")) {
            List<GetJoinSuperTeamInfo> teamInfoList = JSON.parseArray(object.getString("tlists"), GetJoinSuperTeamInfo.class);
            response.setTinfos(teamInfoList);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<GetSuperTeamMessageResponseV1> queryHistoryMsg(GetSuperTeamMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.QUERY_HISTORY_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        GetSuperTeamMessageResponseV1 response = new GetSuperTeamMessageResponseV1();
        response.setTid(request.getTid());
        response.setSize(object.getInteger("size"));
        if (object.containsKey("msgs")) {
            List<GetSuperTeamMessageResponse> teamInfoList = JSON.parseArray(object.getString("msgs"), GetSuperTeamMessageResponse.class);
            response.setMsgs(teamInfoList);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<GetSuperTeamMessageByIdsResponseV1> queryHistoryMsgByIds(GetSuperTeamMessageByIdsRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        // Convert List<Msg> msgs to JSONArray format string if not null
        if (request.getMsgs() != null && !request.getMsgs().isEmpty()) {
            paramMap.put("msgs", JSON.toJSONString(request.getMsgs()));
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.QUERY_HISTORY_MSG_BY_IDS, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        GetSuperTeamMessageByIdsResponseV1 response = new GetSuperTeamMessageByIdsResponseV1();
        if (object.containsKey("msgs")) {
            List<GetSuperTeamMessageResponse> teamInfoList = JSON.parseArray(object.getString("msgs"), GetSuperTeamMessageResponse.class);
            response.setMsgs(teamInfoList);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SendSuperTeamMessageResponseV1> sendMsg(SendSuperTeamMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert forcePushList list to JSON string
        if (request.getForcePushList() != null && !request.getForcePushList().isEmpty()) {
            paramMap.put("forcePushList", JSON.toJSONString(request.getForcePushList()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.SEND_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SendSuperTeamMessageResponseV1 response = new SendSuperTeamMessageResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), SendSuperTeamMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> sendAttachMsg(SendAttachSuperTeamMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert forcePushList list to JSON string
        if (request.getForcePushList() != null && !request.getForcePushList().isEmpty()) {
            paramMap.put("forcePushList", JSON.toJSONString(request.getForcePushList()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.SEND_ATTACH_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseSuperTeamResponseV1> recallMsg(RecallAttachSuperMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SuperTeamUrlContext.RECALL_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseSuperTeamResponseV1 response = new BaseSuperTeamResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
