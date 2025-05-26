package com.netease.nim.im.server.sdk.test;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.team.request.*;
import com.netease.nim.im.server.sdk.v1.team.response.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hekaijie
 * @date 2024/12/24
 */
public class TestTeam {
    public static void main(String[] args) {
        // 初始化
        String appkey = "";
        String appsecret = "";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV1ApiServices services = new YunxinV1ApiServices(client);

        //tid  30636265478
        // request

//        try {

//        CreateTeamRequestV1 request = new CreateTeamRequestV1();
//        request.setTname("hkjTeam");
//        JSONArray list = new JSONArray("hkjtest2","hkjtest3");
//        request.setMembers(list);
//        request.setOwner("hkjtest1");
//        request.setMsg("create");
//        request.setJoinMode(0);
//            Result<CreateTeamResponseV1> result = services.getTeamV1Service().createTeam(request);
//            if (result.isSuccess()) {
//                CreateTeamResponseV1 response = result.getResponse();
//                // 注册成功
//                System.out.println("register success, tid=" + response.getTid() + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            RemoveTeamRequestV1 request1 = new RemoveTeamRequestV1();
//            request1.setTid(30801662517L);
//            request1.setAttach("hkj");
//            request1.setOwner("hkjtest1");
//            Result<JSONObject> result = services.getTeamV1Service().removeTeam(request1);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code=" + result.getCode() + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            AddTeamRequestV1 request2 = new AddTeamRequestV1();
//            request2.setTid(30636265478L);
//            request2.setAttach("hkj");
//            request2.setOwner("hkjtest1");
//            request2.setMsg("1111");
//            JSONArray jsonArray = new JSONArray("hkjtest4");
//            request2.setMembers(jsonArray);
//            Result<TeamFailAccidResponseV1> result = services.getTeamV1Service().addTeam(request2);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code=" + result.getCode() + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            KickTeamRequestV1 request3 = new KickTeamRequestV1();
//            request3.setTid(30636265478L);
//            request3.setAttach("hkj");
//            request3.setOwner("hkjtest1");
//            JSONArray jsonArray = new JSONArray("hkjtest4");
//            request3.setMembers(jsonArray);
//            Result<TeamFailAccidResponseV1> result = services.getTeamV1Service().kickTeam(request3);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code=" + result.getCode() + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            UpdateTeamRequestV1 request4 = new UpdateTeamRequestV1();
//            request4.setTid(30636265478L);
//            request4.setAttach("hkj");
//            request4.setOwner("hkjtest1");
//            request4.setTname("hkj11111");
//            Result<UpdateTeamResponseV1> result = services.getTeamV1Service().updateTeam(request4);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code=" + result.getCode() + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            QueryTeamRequestV1 request4 = new QueryTeamRequestV1();
//            List<Long> tids = new ArrayList<>();
//            tids.add(30636265478L);
//            request4.setTids(tids);
//            request4.setOpe(1);
//            Result<QueryTeamResponseV1> result = services.getTeamV1Service().queryTeam(request4);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            ChangeOwnerTeamRequestV1 request4 = new ChangeOwnerTeamRequestV1();
//            request4.setNewOwner("hkjtest1");
//            request4.setLeave(2);
//            request4.setOwner("hkjtest2");
//            request4.setTid(30636265478L);
//            Result<ChangeOwnerTeamResponseV1> result = services.getTeamV1Service().changeOwnerTeam(request4);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

        try {
            AddManagerTeamRequestV1 request = new AddManagerTeamRequestV1();
            request.setOwner("hkjtest1");
            request.setTid(30636265478L);
            List<String> list = new ArrayList<>();
            list.add("hkjtest3");
            request.setMembers(list);
            Result<AddManagerTeamResponseV1> result = services.getTeamService().addManagerTeam(request);
            if (result.isSuccess()) {
                // 注册成功
                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
            } else {
                // 注册失败，如参数错误、重复注册等
                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
            }
        } catch (YunxinSdkException e) {//这是一个RuntimeException
            // 超时等异常
            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
        }

//        try {
//            RemoveManagerTeamRequestV1 request = new RemoveManagerTeamRequestV1();
//            request.setOwner("hkjtest1");
//            request.setTid(30636265478L);
//            request.setMembers(new JSONArray("hkjtest2"));
//            Result<RemoveManagerTeamResponseV1> result = services.getTeamV1Service().removeManagerTeam(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            JoinsTeamRequestV1 request = new JoinsTeamRequestV1();
//            request.setAccountId("hkjtest1");
//            Result<JoinsTeamResponseV1> result = services.getTeamV1Service().joinsTeam(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            UpdateTeamNickRequestV1 request = new UpdateTeamNickRequestV1();
//            request.setOwner("hkjtest1");
//            request.setTid(30636265478L);
//            request.setNick("nickTest");
//            request.setAccId("hkjtest2");
//            Result<UpdateTeamNickResponseV1> result = services.getTeamV1Service().updateTeamNick(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            LeaveTeamRequestV1 request = new LeaveTeamRequestV1();
//            request.setTid(30636265478L);
//            request.setAccId("hkjtest2");
//            Result<LeaveTeamResponseV1> result = services.getTeamV1Service().leaveTeam(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            MuteTeamRequestV1 request = new MuteTeamRequestV1();
//            request.setTid(30636265478L);
//            request.setAccId("hkjtest2");
//            Result<MuteTeamResponseV1> result = services.getTeamV1Service().muteTeamList(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            MuteTeamMemberRequestV1 request = new MuteTeamMemberRequestV1();
//            request.setTid(30636265478L);
//            request.setAccId("hkjtest3");
//            request.setOwner("hkjtest1");
//            request.setMute(1);
//            Result<MuteTeamMemberResponseV1> result = services.getTeamV1Service().muteTeamMember(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            MuteTeamListAllRequestV1 request = new MuteTeamListAllRequestV1();
//            request.setTid(30636265478L);
//            request.setOwner("hkjtest1");
//            request.setMute(false);
//            Result<MuteTeamListAllResponseV1> result = services.getTeamV1Service().muteTeamListAll(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            QueryMuteTeamMembersRequestV1 request = new QueryMuteTeamMembersRequestV1();
//            request.setTid(30636265478L);
//            request.setOwner("hkjtest1");
//            Result<QueryMuteTeamMembersResponseV1> result = services.getTeamV1Service().queryMuteTeamMembers(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            QueryTeamInfoDetailsRequestV1 request = new QueryTeamInfoDetailsRequestV1();
//            request.setTid(30636265478L);
//            Result<QueryTeamInfoDetailsResponseV1> result = services.getTeamV1Service().queryTeamInfoDetails(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            QueryTeamMsgMarkReadInfoRequestV1 request = new QueryTeamMsgMarkReadInfoRequestV1();
//            request.setTid(30636265478L);
//            request.setMsgId(30636265478L);
//            request.setFromAccid("hkjtest1");
//            Result<QueryTeamMsgMarkReadInfoResponseV1> result = services.getTeamV1Service().queryTeamMsgMarkReadInfo(request);
//            if (result.isSuccess()) {
//                // 注册成功
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            QueryAllJoinedTeamMemberInfoByAccIdRequestV1 request = new QueryAllJoinedTeamMemberInfoByAccIdRequestV1();
//            request.setAccId("hkjtest1");
//
//            Result<QueryAllJoinedTeamMemberInfoByAccIdResponseV1> result = services.getTeamV1Service().queryAllJoinedTeamMemberInfoByAccId(request);
//            if (result.isSuccess()) {
//                // 注册成功x
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

//        try {
//            QueryOnlineTeamMemberRequestV1 request = new QueryOnlineTeamMemberRequestV1();
//            request.setTid(30636265478L);
//
//            Result<QueryOnlineTeamMemberResponseV1> result = services.getTeamV1Service().queryOnlineTeamMember(request);
//            if (result.isSuccess()) {
//                // 注册成功x
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }

        try {
            BatchQueryOnlineTeamMemberCountRequestV1 request = new BatchQueryOnlineTeamMemberCountRequestV1();
            List<Long> list = new ArrayList<>();
            list.add(30636265478L);
            request.setTids(list);

            Result<BatchQueryOnlineTeamMemberCountResponseV1> result = services.getTeamService().batchQueryOnlineTeamMemberCount(request);
            if (result.isSuccess()) {
                // 注册成功x
                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
            } else {
                // 注册失败，如参数错误、重复注册等
                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
            }
        } catch (YunxinSdkException e) {//这是一个RuntimeException
            // 超时等异常
            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
        }
//        try {
//            BatchQueryOnlineTeamMemberCountRequestV1 request = new BatchQueryOnlineTeamMemberCountRequestV1();
//            List<Long> list = new ArrayList<>();
//            list.add(30636265478L);
//            request.setTids(list);
//
//            Result<BatchQueryOnlineTeamMemberCountResponseV1> result = services.getTeamV1Service().batchQueryOnlineTeamMemberCount(request);
//            if (result.isSuccess()) {
//                // 注册成功x
//                System.out.println("register success, code = " + result.getCode() + " response=" + JSONObject.toJSONString(result.getResponse())  + ", traceId=" + result.getTraceId());
//            } else {
//                // 注册失败，如参数错误、重复注册等
//                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
//            }
//        } catch (YunxinSdkException e) {//这是一个RuntimeException
//            // 超时等异常
//            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
//        }
    }
}
