package com.netease.nim.server.sdk.im.v1.history;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.history.request.*;
import com.netease.nim.server.sdk.im.v1.history.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryV1Service implements IHistoryV1Service {

    private final YunxinApiHttpClient httpClient;

    public HistoryV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<QuerySessionHistoryMessageResponseV1> querySessionHistoryMessage(QuerySessionHistoryMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.QUERY_SESSION_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QuerySessionHistoryMessageResponseV1 response = new QuerySessionHistoryMessageResponseV1();
        if (object.containsKey("size")) {
            response.setSize(object.getInteger("size"));
        }
        if (object.containsKey("msgs")) {
            String msgsStr = object.getString("msgs");
            List<Message> messages = parseTeamMessages(msgsStr);
            response.setMsgs(messages);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryTeamHistoryMessageResponseV1> queryTeamHistoryMessage(QueryTeamHistoryMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.QUERY_TEAM_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QueryTeamHistoryMessageResponseV1 response = new QueryTeamHistoryMessageResponseV1();
        if (object.containsKey("size")) {
            response.setSize(object.getInteger("size"));
        }
        if (object.containsKey("msgs")) {
            String msgsStr = object.getString("msgs");
            List<Message> messages = parseTeamMessages(msgsStr);
            response.setMsgs(messages);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryChatroomHistoryMessageResponseV1> queryChatroomHistoryMessage(QueryChatroomHistoryMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.QUERY_CHATROOM_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QueryChatroomHistoryMessageResponseV1 response = new QueryChatroomHistoryMessageResponseV1();
        if (object.containsKey("size")) {
            response.setSize(object.getInteger("size"));
        }
        if (object.containsKey("msgs")) {
            String msgsStr = object.getString("msgs");
            List<ChatroomMessage> messages = parseChatroomMessages(msgsStr);
            response.setMsgs(messages);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    /**
     * Parse JSON string into a list of Message objects
     * 
     * @param msgsStr JSON string representation of team messages array
     * @return List of Message objects
     */
    private List<Message> parseTeamMessages(String msgsStr) {
        List<Message> messages = new ArrayList<>();
        if (msgsStr != null && !msgsStr.isEmpty()) {
            JSONArray msgsArray = JSONArray.parseArray(msgsStr);
            for (int i = 0; i < msgsArray.size(); i++) {
                JSONObject msgObject = msgsArray.getJSONObject(i);
                
                // Handle body as string
                if (msgObject.containsKey("body")) {
                    Object bodyObj = msgObject.get("body");
                    if (bodyObj instanceof JSONObject) {
                        msgObject.put("body", ((JSONObject) bodyObj).toJSONString());
                    } else if (bodyObj != null) {
                        msgObject.put("body", bodyObj.toString());
                    }
                }
                
                Message message = Message.fromJson(msgObject);
                messages.add(message);
            }
        }
        return messages;
    }

    /**
     * Parse JSON string into a list of ChatroomMessage objects
     * 
     * @param msgsStr JSON string representation of chatroom messages array
     * @return List of ChatroomMessage objects
     */
    private List<ChatroomMessage> parseChatroomMessages(String msgsStr) {
        List<ChatroomMessage> messages = new ArrayList<>();
        if (msgsStr != null && !msgsStr.isEmpty()) {
            JSONArray msgsArray = JSONArray.parseArray(msgsStr);
            for (int i = 0; i < msgsArray.size(); i++) {
                JSONObject msgObject = msgsArray.getJSONObject(i);
                
                // Handle body as string
                if (msgObject.containsKey("body")) {
                    Object bodyObj = msgObject.get("body");
                    if (bodyObj instanceof JSONObject) {
                        msgObject.put("body", ((JSONObject) bodyObj).toJSONString());
                    } else if (bodyObj != null) {
                        msgObject.put("body", bodyObj.toString());
                    }
                }
                
                ChatroomMessage message = ChatroomMessage.fromJson(msgObject);
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    public Result<DeleteChatroomHistoryMessageResponseV1> deleteChatroomHistoryMessage(DeleteChatroomHistoryMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.DELETE_CHATROOM_HISTORY_MESSAGE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        DeleteChatroomHistoryMessageResponseV1 response = new DeleteChatroomHistoryMessageResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), DeleteChatroomHistoryMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QuerySessionListResponseV1> querySessionList(QuerySessionListRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.QUERY_SESSION_LIST, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QuerySessionListResponseV1 response = new QuerySessionListResponseV1();
        if (object.containsKey("data")) {
            JSONObject dataObject = object.getJSONObject("data");
            
            // Parse hasMore field
            if (dataObject.containsKey("hasMore")) {
                response.setHasMore(dataObject.getBoolean("hasMore"));
            }
            
            // Parse sessions array and filter out null tid fields
            if (dataObject.containsKey("sessions")) {
                JSONArray sessionsArray = dataObject.getJSONArray("sessions");
                List<Session> sessions = new ArrayList<>();
                
                for (int i = 0; i < sessionsArray.size(); i++) {
                    JSONObject sessionObj = sessionsArray.getJSONObject(i);
                    Session session = new Session();
                    
                    // Parse sessionType
                    if (sessionObj.containsKey("sessionType")) {
                        session.setSessionType(sessionObj.getInteger("sessionType"));
                    }
                    
                    // Parse accid (only for point-to-point sessions)
                    if (sessionObj.containsKey("accid") && sessionObj.get("accid") != null) {
                        session.setAccid(sessionObj.getString("accid"));
                    }
                    
                    // Parse tid (only for group and super group sessions)
                    if (sessionObj.containsKey("tid") && sessionObj.get("tid") != null) {
                        session.setTid(sessionObj.getLong("tid"));
                    }
                    
                    // Parse other fields
                    if (sessionObj.containsKey("updateTime")) {
                        session.setUpdateTime(sessionObj.getLong("updateTime"));
                    }
                    
                    if (sessionObj.containsKey("ext")) {
                        session.setExt(sessionObj.getString("ext"));
                    }
                    
                    if (sessionObj.containsKey("lastMsgType")) {
                        session.setLastMsgType(sessionObj.getString("lastMsgType"));
                    }
                    
                    if (sessionObj.containsKey("lastMsg")) {
                        session.setLastMsg(sessionObj.getString("lastMsg"));
                    }
                    
                    sessions.add(session);
                }
                
                response.setSessions(sessions);
            }
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryBroadcastHistoryMessageByIdResponseV1> queryBroadcastHistoryMessageById(QueryBroadcastHistoryMessageByIdRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.QUERY_BROADCAST_MSG_BY_ID, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QueryBroadcastHistoryMessageByIdResponseV1 response = new QueryBroadcastHistoryMessageByIdResponseV1();
        if (object.containsKey("msg")) {
            JSONObject msgObject = object.getJSONObject("msg");
            QueryBroadcastHistoryMessageByIdResponseV1.BroadcastMessage broadcastMsg = 
                JSON.parseObject(msgObject.toJSONString(), QueryBroadcastHistoryMessageByIdResponseV1.BroadcastMessage.class);
            response.setMsg(broadcastMsg);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryBroadcastHistoryMessageResponseV1> queryBroadcastHistoryMessage(QueryBroadcastHistoryMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.QUERY_BROADCAST_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QueryBroadcastHistoryMessageResponseV1 response = new QueryBroadcastHistoryMessageResponseV1();
        if (object.containsKey("msgs")) {
            JSONArray msgsArray = object.getJSONArray("msgs");
            List<QueryBroadcastHistoryMessageResponseV1.BroadcastMessage> broadcastMsgs = new ArrayList<>();
            
            for (int i = 0; i < msgsArray.size(); i++) {
                JSONObject msgObject = msgsArray.getJSONObject(i);
                QueryBroadcastHistoryMessageResponseV1.BroadcastMessage broadcastMsg = 
                    JSON.parseObject(msgObject.toJSONString(), QueryBroadcastHistoryMessageResponseV1.BroadcastMessage.class);
                broadcastMsgs.add(broadcastMsg);
            }
            
            response.setMsgs(broadcastMsgs);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<QueryUserEventsResponseV1> queryUserEvents(QueryUserEventsRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(HistoryV1UrlContext.QUERY_USER_EVENTS, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QueryUserEventsResponseV1 response = new QueryUserEventsResponseV1();
        if(object.containsKey("events")){
            List<QueryUserEventsResponseV1.UserEvent> userEvents = new ArrayList<>();
            List<?> events = (List<?>) object.get("events");
            if (events != null) {
                for (Object evt : events) {
                    // evt 可能是 JSONObject，需要转成 UserEvent
                    QueryUserEventsResponseV1.UserEvent userEvent = JSON.toJavaObject(evt, QueryUserEventsResponseV1.UserEvent.class);
                    userEvents.add(userEvent);
                }
            }
            response.setEvents(userEvents);
        }
        if(object.containsKey("size")){
            response.setSize((Integer) object.get("size"));
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

}
