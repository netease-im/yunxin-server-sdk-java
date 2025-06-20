package com.netease.nim.server.sdk.im.v1.message;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.message.request.*;
import com.netease.nim.server.sdk.im.v1.message.response.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageV1Service implements IMessageV1Service {

    private final YunxinApiHttpClient httpClient;

    public MessageV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<SendMessageResponseV1> sendMessage(SendMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        // Convert List<String> forcepushlist to JSONArray format string if not null
        if (request.getForcepushlist() != null && !request.getForcepushlist().isEmpty()) {
            paramMap.put("forcepushlist", JSON.toJSONString(request.getForcepushlist()));
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.SEND_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        SendMessageResponseV1 response = new SendMessageResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), SendMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SendBatchMessageResponseV1> sendBatchMessage(SendBatchMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        // Convert List<String> toAccids to JSONArray format string if not null
        if (request.getToAccids() != null && !request.getToAccids().isEmpty()) {
            paramMap.put("toAccids", JSON.toJSONString(request.getToAccids()));
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.SEND_BATCH_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        SendBatchMessageResponseV1 response = new SendBatchMessageResponseV1();
        if (object.containsKey("unregister")) {
            // Parse unregister from JSON string to List<String>
            response.setUnregister(JSON.parseArray(object.getString("unregister"), String.class));
        }
        if (object.containsKey("timetag")) {
            response.setTimetag(object.getLong("timetag"));
        }
        if (object.containsKey("msgids")) {
            // Parse msgids from JSON object to Map<String, Long>
            JSONObject msgidsObj = object.getJSONObject("msgids");
            Map<String, Long> map = new HashMap<>();
            for (Map.Entry<String, Object> stringObjectEntry : msgidsObj.entrySet()) {
                map.put(stringObjectEntry.getKey(), Long.parseLong(stringObjectEntry.getValue().toString()));
            }
            response.setMsgids(map);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<MarkReadMessageResponseV1> markReadMessage(MarkReadMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.MARK_READ_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        MarkReadMessageResponseV1 response = new MarkReadMessageResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), MarkReadMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<MarkReadTeamMessageResponseV1> markReadTeamMessage(MarkReadTeamMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.MARK_READ_TEAM_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        MarkReadTeamMessageResponseV1 response = new MarkReadTeamMessageResponseV1();
        if (object.containsKey("data")) {
            JSONObject data = object.getJSONObject("data");
            JSONArray errMsgIds = data.getJSONArray("errMsgIds");
            List<Long> list = new ArrayList<>();
            for (Object errMsgId : errMsgIds) {
                list.add(Long.parseLong(errMsgId.toString()));
            }
            response.setErrMsgIds(list);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<RecallMessageResponseV1> recallMessage(RecallMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.RECALL_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        RecallMessageResponseV1 response = new RecallMessageResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), RecallMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DeleteMessageOneWayResponseV1> deleteMessageOneWay(DeleteMessageOneWayRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.DEL_MSG_ONE_WAY, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        DeleteMessageOneWayResponseV1 response = new DeleteMessageOneWayResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), DeleteMessageOneWayResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BroadcastMessageResponseV1> broadcastMessage(BroadcastMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        // Convert List<String> targetOs to JSONArray format string if not null
        if (request.getTargetOs() != null && !request.getTargetOs().isEmpty()) {
            paramMap.put("targetOs", JSON.toJSONString(request.getTargetOs()));
        }
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.BROADCAST_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        BroadcastMessageResponseV1 response = new BroadcastMessageResponseV1();
        if (object.containsKey("msg")) {
            JSONObject msgObj = object.getJSONObject("msg");
            // Parse the response fields
            if (msgObj.containsKey("broadcastId")) {
                response.setBroadcastId(msgObj.getLong("broadcastId"));
            }
            if (msgObj.containsKey("from")) {
                response.setFrom(msgObj.getString("from"));
            }
            if (msgObj.containsKey("body")) {
                response.setBody(msgObj.getString("body"));
            }
            if (msgObj.containsKey("targetOs")) {
                // Parse targetOs from JSON array to List<String>
                response.setTargetOs(JSON.parseArray(msgObj.getString("targetOs"), String.class));
            }
            if (msgObj.containsKey("isOffline")) {
                response.setOffline(msgObj.getBoolean("isOffline"));
            }
            if (msgObj.containsKey("createTime")) {
                response.setCreateTime(msgObj.getLong("createTime"));
            }
            if (msgObj.containsKey("expireTime")) {
                response.setExpireTime(msgObj.getLong("expireTime"));
            }
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DeleteBroadcastMessageByIdResponseV1> deleteBroadcastMessageById(DeleteBroadcastMessageByIdRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.DEL_BROADCAST_MSG_BY_ID, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        DeleteBroadcastMessageByIdResponseV1 response = new DeleteBroadcastMessageByIdResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), DeleteBroadcastMessageByIdResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<UploadFileResponseV1> uploadFile(UploadFileRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.UPLOAD, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        UploadFileResponseV1 response = new UploadFileResponseV1();
        if (object.containsKey("url")) {
            response.setUrl(object.getString("url"));
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DeleteFileResponseV1> deleteFile(DeleteFileRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.DELETE_FILE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        DeleteFileResponseV1 response = new DeleteFileResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), DeleteFileResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DeleteMessageResponseV1> deleteMessage(DeleteMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.DEL_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        DeleteMessageResponseV1 response = new DeleteMessageResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), DeleteMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DeleteRoamSessionResponseV1> deleteRoamSession(DeleteRoamSessionRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageV1UrlContext.DEL_ROAM_SESSION, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        DeleteRoamSessionResponseV1 response = new DeleteRoamSessionResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), DeleteRoamSessionResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

}
