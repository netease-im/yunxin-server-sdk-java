package com.netease.nim.server.sdk.im.v1.chatroom;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.chatroom.request.*;
import com.netease.nim.server.sdk.im.v1.chatroom.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/11
 */
public class ChatRoomV1Service implements IChatRoomV1Service {

    private final YunxinApiHttpClient httpClient;

    private final static String msg = "msg";

    private final static String CODE = "code";

    private final static String DESC = "desc";

    private final static String DATA = "data";

    public ChatRoomV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateChatroomResponseV1> createChatroom(CreateChatroomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.CREATE, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        CreateChatroomResponseV1 response = object.getObject("chatroom", CreateChatroomResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<UpdateChatroomResponseV1> updateChatroom(UpdateChatroomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.UPDATE, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        UpdateChatroomResponseV1 response = object.getObject("chatroom", UpdateChatroomResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryChatroomAddressResponseV1> queryChatroomAddress(QueryChatroomAddressRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.REQUEST_ADDR, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryChatroomAddressResponseV1 response = new QueryChatroomAddressResponseV1();
        String addr = object.getString("addr");
        if (addr != null && !addr.isEmpty()) {
            response.setChatroomAddress(JSON.parseArray(addr, String.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryChatroomInfoResponseV1> queryChatroomInfo(QueryChatroomInfoRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.GET, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryChatroomInfoResponseV1 response = object.getObject("chatroom", QueryChatroomInfoResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryChatroomInfosResponseV1> queryChatroomInfos(QueryChatroomInfosRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.GET_BATCH, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryChatroomInfosResponseV1 response = new QueryChatroomInfosResponseV1();
        String array = object.getString("succRooms");
        if (array != null && !array.isEmpty()) {
            response.setRoomInfos(JSONArray.parseArray(array, QueryChatroomInfosResponseV1.RoomInfo.class));
        }

        String noExistArray = object.getString("noExistRooms");
        if (noExistArray != null && !noExistArray.isEmpty()) {
            response.setNoExistRooms(JSONArray.parseArray(noExistArray, Long.class));
        }

        String failArray = object.getString("failRooms");
        if (failArray != null && !failArray.isEmpty()) {
            response.setFailRooms(JSONArray.parseArray(failArray, Long.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<ToggleCloseChatroomStatResponseV1> toggleCloseChatroomStat(ToggleCloseChatroomStatRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.TOGGLE_CLOSE_STAT, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        ToggleCloseChatroomStatResponseV1 response = object.getObject("desc", ToggleCloseChatroomStatResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<UpdateChatroomDelayClosePolicyResponseV1> updateDelayClosePolicy(UpdateChatroomDelayClosePolicyRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.UPDATE_DELAY_CLOSE_POLICY, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        UpdateChatroomDelayClosePolicyResponseV1 response = object.getObject("chatroom", UpdateChatroomDelayClosePolicyResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<UpdateChatroomInOutNotificationResponseV1> updateChatroomInOutNotification(UpdateChatroomInOutNotificationRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.UPDATE_IN_OUT_NOTIFICATION, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new UpdateChatroomInOutNotificationResponseV1());
    }

    @Override
    public Result<KickMemberResponseV1> kickMember(KickMemberRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.KICK_MEMBER, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new KickMemberResponseV1());

    }

    @Override
    public Result<SetMemberRoleResponseV1> setMemberRole(SetMemberRoleRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.SET_MEMBER_ROLE, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        SetMemberRoleResponseV1 response = object.getObject(DESC, SetMemberRoleResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<UpdateMyRoomRoleResponseV1> updateMyRoomRole(UpdateMyRoomRoleRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.UPDATE_MY_ROOM_ROLE, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new UpdateMyRoomRoleResponseV1());

    }

    @Override
    public Result<QueryMembersByPageResponseV1> membersByPage(QueryMembersByPageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.MEMBERS_BY_PAGE, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryMembersByPageResponseV1 response = new QueryMembersByPageResponseV1();
        String array = object.getString(DESC);

        if (array != null && !array.isEmpty()) {
            JSONObject js = JSONObject.parseObject(array);
            if (!js.isEmpty() && js.containsKey("data")) {
                response.setData(JSON.parseArray(js.getString("data"), QueryMembersByPageResponseV1.QueryMembersByPage.class));
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryMembersByRolesResponseV1> membersByRoles(QueryMembersByRolesRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUERY_MEMBERS_BY_ROLE, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryMembersByRolesResponseV1 response = new QueryMembersByRolesResponseV1();
        String array = object.getString(DESC);

        if (array != null && !array.isEmpty()) {
            JSONObject js = JSONObject.parseObject(array);
            if (!js.isEmpty() && js.containsKey("data")) {
                response.setData(JSON.parseArray(js.getString("data"), QueryMembersByRolesResponseV1.QueryMembersByRoles.class));
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryMembersResponseV1> queryMembers(QueryMembersRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        paramMap.put("accids", JSONArray.toJSONString(request.getAccids()));
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUERY_MEMBERS, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryMembersResponseV1 response = new QueryMembersResponseV1();
        String array = object.getString(DESC);

        if (array != null && !array.isEmpty()) {
            JSONObject js = JSONObject.parseObject(array);
            if (!js.isEmpty() && js.containsKey("data")) {
                response.setData(JSON.parseArray(js.getString("data"), QueryMembersResponseV1.QueryMembers.class));
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<AddRobotResponseV1> addRobot(AddRobotRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        paramMap.put("accids", JSONArray.toJSONString(request.getAccids()));
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.ADD_ROBOT, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        AddRobotResponseV1 response = new AddRobotResponseV1();
        String array = object.getString(DESC);

        if (array != null && !array.isEmpty()) {
            JSONObject js = JSONObject.parseObject(array);
            if (js != null && !js.isEmpty() && js.containsKey("failAccids")) {
                response.setFailAccids(JSON.parseArray(js.getString("failAccids"), String.class));
            }
            if (js != null && !js.isEmpty() && js.containsKey("successAccids")) {
                response.setSuccessAccids(JSON.parseArray(js.getString("successAccids"), String.class));
            }
            if (js != null && !js.isEmpty() && js.containsKey("oldAccids")) {
                response.setOldAccids(JSON.parseArray(js.getString("oldAccids"), String.class));
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<RemoveRobotResponseV1> removeRobot(RemoveRobotRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        paramMap.put("accids", JSONArray.toJSONString(request.getAccids()));
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.REMOVE_ROBOT, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        RemoveRobotResponseV1 response = new RemoveRobotResponseV1();
        String array = object.getString(DESC);

        if (array != null && !array.isEmpty()) {
            JSONObject js = JSONObject.parseObject(array);
            if (js != null && !js.isEmpty() && js.containsKey("failAccids")) {
                response.setFailAccids(JSON.parseArray(js.getString("failAccids"), String.class));
            }
            if (js != null && !js.isEmpty() && js.containsKey("successAccids")) {
                response.setSuccessAccids(JSON.parseArray(js.getString("successAccids"), String.class));
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<CleanRobotResponseV1> cleanRobot(CleanRobotRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.CLEAN_ROBOT, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        CleanRobotResponseV1 response = new CleanRobotResponseV1();
        if (object.containsKey(DESC)) {
            response = JSON.parseObject(object.getString(DESC),CleanRobotResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<TemporaryMuteResponseV1> temporaryMute(TemporaryMuteRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.TEMPORARY_MUTE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        TemporaryMuteResponseV1 response = new TemporaryMuteResponseV1();
        if (object.containsKey(DESC)) {
            response = JSON.parseObject(object.getString(DESC),TemporaryMuteResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<MuteRoomResponseV1> muteRoom(MuteRoomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.MUTE_ROOM, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        MuteRoomResponseV1 response = new MuteRoomResponseV1();
        if (object.containsKey(DESC)) {
            response = JSON.parseObject(object.getString(DESC), MuteRoomResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<TagTemporaryMuteResponseV1> tagTemporaryMute(TagTemporaryMuteRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.TAG_MUTE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        TagTemporaryMuteResponseV1 response = new TagTemporaryMuteResponseV1();
        if (object.containsKey(DESC)) {
            response = JSON.parseObject(object.getString(DESC), TagTemporaryMuteResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<TagMembersCountResponseV1> tagMembersCount(TagMembersCountRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.TAG_COUNT, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        TagMembersCountResponseV1 response = new TagMembersCountResponseV1();
        if (object.containsKey(DATA)) {
            response = JSON.parseObject(object.getString(DATA),TagMembersCountResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<TagMembersQueryResponseV1> tagMembersQuery(TagMembersQueryRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.TAG_QUERY, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        TagMembersQueryResponseV1 response = new TagMembersQueryResponseV1();
        String array = object.getString(DESC);

        if (array != null && !array.isEmpty()) {
            JSONObject js = JSONObject.parseObject(array);
            if (js != null && !js.isEmpty() && js.containsKey(DATA)) {
                response.setData(JSON.parseArray(js.getString(DATA), TagMembersQueryResponseV1.TagMemberQueryBean.class));
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<QueryTagHistoryMsgResponseV1> queryTagHistoryMsg(QueryTagHistoryMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        paramMap.put("tags", JSONArray.toJSONString(request.getTags()));
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUERY_TAG_MSG, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueryTagHistoryMsgResponseV1 response = new QueryTagHistoryMsgResponseV1();
        String array = object.getString("msgs");

        if (array != null && !array.isEmpty()) {
            response.setMsgs(JSON.parseArray(array, QueryTagHistoryMsgResponseV1.TagMsgBean.class));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);

    }

    @Override
    public Result<UpdateChatRoomRoleTagResponseV1> updateChatRoomRoleTag(UpdateChatRoomRoleTagRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        paramMap.put("tags", JSONArray.toJSONString(request.getTags()));

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.UPDATE_CHAT_ROOM_ROLE_TAG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new UpdateChatRoomRoleTagResponseV1());

    }

    @Override
    public Result<QueryUserRoomIdsResponseV1> queryUserRoomIds(QueryUserRoomIdsRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUERY_USER_ROOM_IDS, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        JSONObject desc = object.getJSONObject(DESC);

        QueryUserRoomIdsResponseV1 response = new QueryUserRoomIdsResponseV1();
        String roomIdsString = desc.getString("roomids");
        if (roomIdsString != null && !roomIdsString.isEmpty()) {
            JSONArray array = JSONArray.parseArray(roomIdsString);
            List<Long> roomIds = new ArrayList<>();
            for (Object o : array) {
                roomIds.add(Long.parseLong(String.valueOf(o)));
            }
            response.setRoomIds(roomIds);
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueueInitResponseV1> queueInit(QueueInitRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_INIT, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueueInitResponseV1 response = new QueueInitResponseV1();

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueueDropResponseV1> queueDrop(QueueDropRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_DROP, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueueDropResponseV1 response = object.getObject(DESC, QueueDropResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueueOfferResponseV1> queueOffer(QueueOfferRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_OFFER, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueueOfferResponseV1 response = object.getObject(DESC, QueueOfferResponseV1.class);

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueueBatchOfferResponseV1> queueBatchOffer(QueueBatchOfferRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Handle elements parameter, which is a list of objects
        if (request.getElements() != null && !request.getElements().isEmpty()) {
            paramMap.put("elements", JSONArray.toJSONString(request.getElements()));
        }

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_BATCH_OFFER, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueueBatchOfferResponseV1 response = new QueueBatchOfferResponseV1();

        JSONObject desc = object.getJSONObject(DESC);
        
        // Parse failed keys if available
        String failedKeysStr = desc.getString("failedKeys");
        if (failedKeysStr != null && !failedKeysStr.isEmpty()) {
            response.setFailedKeys(JSON.parseArray(failedKeysStr, String.class));
        }
        response.setHighPriority(desc.getBoolean("highPriority"));

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueueBatchUpdateResponseV1> queueBatchUpdate(QueueBatchUpdateRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Handle elements parameter, which is a map of key-value pairs
        if (request.getElements() != null && !request.getElements().isEmpty()) {
            paramMap.put("elements", JSON.toJSONString(request.getElements()));
        }

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_BATCH_UPDATE, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueueBatchUpdateResponseV1 response = new QueueBatchUpdateResponseV1();
        
        // Get the original desc string
        String descStr = object.getString(DESC);
        
        // Parse response details
        if (descStr != null && !descStr.isEmpty()) {
            JSONObject descObj = JSONObject.parseObject(descStr);
            
            // Check for non-existent element keys
            if (descObj.containsKey("noExistElementKey")) {
                String noExistKeysStr = descObj.getString("noExistElementKey");
                if (noExistKeysStr != null && !noExistKeysStr.isEmpty()) {
                    response.setNoExistElementKey(JSON.parseArray(noExistKeysStr, String.class));
                } else {
                    JSONArray jsonArray = descObj.getJSONArray("noExistElementKey");
                    if (jsonArray != null) {
                        response.setNoExistElementKey(jsonArray.toJavaList(String.class));
                    }
                }
            }
            response.setHighPriority(descObj.getBoolean("highPriority"));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueueListResponseV1> queueList(QueueListRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_LIST, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueueListResponseV1 response = new QueueListResponseV1();
        String descStr = object.getString(DESC);
        
        // Parse response details
        if (descStr != null && !descStr.isEmpty()) {
            JSONObject descObj = JSONObject.parseObject(descStr);
            
            // Get the list of elements
            if (descObj.containsKey("list")) {
                JSONArray jsonArray = descObj.getJSONArray("list");
                List<QueueListResponseV1.QueueElement> list = new ArrayList<>();
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) o;
                    QueueListResponseV1.QueueElement element = null;
                    for (Map.Entry<String, Object> entry : json.entrySet()) {
                        element = new QueueListResponseV1.QueueElement(entry.getKey(), entry.getValue().toString());
                    }
                    list.add(element);
                }
                response.setList(list);
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueuePollResponseV1> queuePoll(QueuePollRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_POLL, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueuePollResponseV1 response = new QueuePollResponseV1();
        String descStr = object.getString(DESC);
        
        // Parse response details
        if (descStr != null && !descStr.isEmpty()) {
            JSONObject descObj = JSONObject.parseObject(descStr);
            
            // Get the key and value of the polled element
            if (descObj.containsKey("key")) {
                response.setKey(descObj.getString("key"));
            }
            if (descObj.containsKey("value")) {
                response.setValue(descObj.getString("value"));
            }
            response.setHighPriority(descObj.getBoolean("highPriority"));
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueueGetResponseV1> queueGet(QueueGetRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert the keys list to JSON array string
        if (request.getKeys() != null && !request.getKeys().isEmpty()) {
            paramMap.put("keys", JSONArray.toJSONString(request.getKeys()));
        }

        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomV1UrlContext.QUEUE_MULTI_GET, paramMap);

        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);

        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }

        QueueGetResponseV1 response = new QueueGetResponseV1();
        String descStr = object.getString(DESC);
        
        // Parse response details
        if (descStr != null && !descStr.isEmpty()) {
            JSONObject descObj = JSONObject.parseObject(descStr);
            
            // Get the list of elements
            if (descObj.containsKey("list")) {
                JSONArray jsonArray = descObj.getJSONArray("list");
                List<QueueGetResponseV1.QueueElement> list = new ArrayList<>();
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) o;
                    QueueGetResponseV1.QueueElement element = null;
                    for (Map.Entry<String, Object> entry : json.entrySet()) {
                        element = new QueueGetResponseV1.QueueElement(entry.getKey(), entry.getValue().toString());
                    }
                    list.add(element);
                }
                response.setList(list);
            }
        }

        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
