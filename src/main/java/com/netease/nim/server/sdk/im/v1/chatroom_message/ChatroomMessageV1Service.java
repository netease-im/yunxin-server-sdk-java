package com.netease.nim.server.sdk.im.v1.chatroom_message;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.chatroom_message.request.*;
import com.netease.nim.server.sdk.im.v1.chatroom_message.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChatroomMessageV1Service implements IChatroomMessageV1Service {

    private final YunxinApiHttpClient httpClient;

    private final static String CODE = "code";
    private final static String DESC = "desc";

    public ChatroomMessageV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<SendChatroomMsgResponseV1> sendMsg(SendChatroomMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomMessageV1UrlContext.SEND_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SendChatroomMsgResponseV1 response = new SendChatroomMsgResponseV1();
        if (object.containsKey(DESC)) {
            response = JSON.parseObject(object.getString(DESC), SendChatroomMsgResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BatchSendChatroomMsgResponseV1> batchSendMsg(BatchSendChatroomMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert msgList from List<Message> to JSON string
        if (request.getMsgList() != null) {
            paramMap.put("msgList", JSON.toJSONString(request.getMsgList()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomMessageV1UrlContext.BATCH_SEND_MSG, paramMap);
        
        JSONObject jsonObject = JSONObject.parseObject(apiResponse.getData());
        int code = jsonObject.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), jsonObject.getString(DESC), null);
        }

        List<BatchSendChatroomMsgResponseV1.FailedMessage> failList = new ArrayList<>();
        if (jsonObject.containsKey("fail")) {
            JSONArray failArray = jsonObject.getJSONArray("fail");
            for (int i = 0; i < failArray.size(); i++) {
                JSONObject failObject = failArray.getJSONObject(i);
                for (String key : failObject.keySet()) {
                    BatchSendChatroomMsgResponseV1.FailedMessage failedMessage = new BatchSendChatroomMsgResponseV1.FailedMessage();
                    failedMessage.setClientMsgId(key);
                    failedMessage.setReason(failObject.getString(key));
                    failList.add(failedMessage);
                }
            }
        }

        List<BatchSendChatroomMsgResponseV1.SuccessfulMessage> successList = new ArrayList<>();
        if (jsonObject.containsKey("success")) {
            JSONArray successArray = jsonObject.getJSONArray("success");
            for (int i = 0; i < successArray.size(); i++) {
                JSONObject successObject = successArray.getJSONObject(i);
                for (String key : successObject.keySet()) {
                    BatchSendChatroomMsgResponseV1.SuccessfulMessage msg = JSONObject
                            .parseObject(successObject.getString(key), BatchSendChatroomMsgResponseV1.SuccessfulMessage.class);
                    msg.setClientMsgId(key);
                    successList.add(msg);
                }
            }
        }

        BatchSendChatroomMsgResponseV1 response = new BatchSendChatroomMsgResponseV1();
        response.setFailList(failList);
        response.setSuccessList(successList);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BaseChatroomMessageResponseV1> recall(RecallChatroomMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomMessageV1UrlContext.RECALL, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        BaseChatroomMessageResponseV1 response = new BaseChatroomMessageResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<ChatroomTargetMsgResponseV1> sendMsgToSomeone(ChatroomTargetMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert toAccids list to JSON string
        if (request.getToAccids() != null) {
            paramMap.put("toAccids", JSON.toJSONString(request.getToAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomMessageV1UrlContext.SEND_MSG_TO_SOMEONE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        ChatroomTargetMsgResponseV1 response = new ChatroomTargetMsgResponseV1();
        if (object.containsKey(DESC)) {
            response = JSON.parseObject(object.getString(DESC), ChatroomTargetMsgResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BatchChatroomTargetMsgResponseV1> batchSendMsgToSomeone(BatchChatroomTargetMsgRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        
        // Convert msgList from List<Message> to JSON string
        if (request.getMsgList() != null) {
            paramMap.put("msgList", JSON.toJSONString(request.getMsgList()));
        }
        
        // Convert toAccids list to JSON string
        if (request.getToAccids() != null) {
            paramMap.put("toAccids", JSON.toJSONString(request.getToAccids()));
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomMessageV1UrlContext.BATCH_SEND_MSG_TO_SOMEONE, paramMap);
        
        JSONObject jsonObject = JSONObject.parseObject(apiResponse.getData());
        int code = jsonObject.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), jsonObject.getString(DESC), null);
        }

        List<BatchChatroomTargetMsgResponseV1.FailedMessage> failList = new ArrayList<>();
        if (jsonObject.containsKey("fail")) {
            JSONArray failArray = jsonObject.getJSONArray("fail");
            for (int i = 0; i < failArray.size(); i++) {
                JSONObject failObject = failArray.getJSONObject(i);
                for (String key : failObject.keySet()) {
                    BatchChatroomTargetMsgResponseV1.FailedMessage failedMessage = new BatchChatroomTargetMsgResponseV1.FailedMessage();
                    failedMessage.setClientMsgId(key);
                    failedMessage.setReason(failObject.getString(key));
                    failList.add(failedMessage);
                }
            }
        }

        List<ChatroomTargetMsgResponseV1> successList = new ArrayList<>();
        if (jsonObject.containsKey("success")) {
            JSONArray successArray = jsonObject.getJSONArray("success");
            for (int i = 0; i < successArray.size(); i++) {
                JSONObject successObject = successArray.getJSONObject(i);
                for (String key : successObject.keySet()) {
                    ChatroomTargetMsgResponseV1 msg = JSONObject.parseObject(successObject.getString(key), ChatroomTargetMsgResponseV1.class);
                    msg.setMsgidClient(key);
                    successList.add(msg);
                }
            }
        }

        BatchChatroomTargetMsgResponseV1 response = new BatchChatroomTargetMsgResponseV1();
        response.setFailList(failList);
        response.setSuccessList(successList);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SendChatroomMsgResponseV1> broadcast(ChatroomBroadcastRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(ChatroomMessageV1UrlContext.BROADCAST, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SendChatroomMsgResponseV1 response = new SendChatroomMsgResponseV1();
        if (object.containsKey(DESC)) {
            response = JSON.parseObject(object.getString(DESC), SendChatroomMsgResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
