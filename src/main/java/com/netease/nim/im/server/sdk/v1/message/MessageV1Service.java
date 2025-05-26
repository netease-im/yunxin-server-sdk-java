package com.netease.nim.im.server.sdk.v1.message;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.annotation.YunxinParamUtils;
import com.netease.nim.im.server.sdk.v1.message.request.*;
import com.netease.nim.im.server.sdk.v1.message.response.*;

import java.util.Map;

public class MessageV1Service implements IMessageV1Service {

    private final YunxinApiHttpClient httpClient;

    public MessageV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<SendMessageResponseV1> sendMessage(SendMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.SEND_MSG, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.SEND_BATCH_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        SendBatchMessageResponseV1 response = new SendBatchMessageResponseV1();
        if (object.containsKey("unregister")) {
            response.setUnregister(object.getString("unregister"));
        }
        if (object.containsKey("timetag")) {
            response.setTimetag(object.getLong("timetag"));
        }
        if (object.containsKey("msgids")) {
            response.setMsgids(object.getString("msgids"));
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<MarkReadMessageResponseV1> markReadMessage(MarkReadMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.MARK_READ_MSG, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.MARK_READ_TEAM_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        MarkReadTeamMessageResponseV1 response = new MarkReadTeamMessageResponseV1();
        if (object.containsKey("data")) {
            response = JSON.parseObject(object.getString("data"), MarkReadTeamMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<RecallMessageResponseV1> recallMessage(RecallMessageRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.RECALL_MSG, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.DEL_MSG_ONE_WAY, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.BROADCAST_MSG, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        BroadcastMessageResponseV1 response = new BroadcastMessageResponseV1();
        if (object.containsKey("msg")) {
            response = JSON.parseObject(object.getString("msg"), BroadcastMessageResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DeleteBroadcastMessageByIdResponseV1> deleteBroadcastMessageById(DeleteBroadcastMessageByIdRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.DEL_BROADCAST_MSG_BY_ID, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.UPLOAD, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.DELETE_FILE, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.DEL_MSG, paramMap);
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
        YunxinApiResponse apiResponse = httpClient.executeV1Api(MessageUrlContext.DEL_ROAM_SESSION, paramMap);
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
