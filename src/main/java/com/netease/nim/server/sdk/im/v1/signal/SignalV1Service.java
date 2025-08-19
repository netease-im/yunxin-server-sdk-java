package com.netease.nim.server.sdk.im.v1.signal;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.signal.request.CreateSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.DelaySignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CloseSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.GetSignalRoomInfoRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CtrlSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.InviteSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CancelSignalRoomInviteRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.KickSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CreateSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.DelaySignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CloseSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.GetSignalRoomInfoResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CtrlSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.InviteSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CancelSignalRoomInviteResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.KickSignalRoomResponseV1;

import java.util.Map;

/**
 * 信令服务实现
 */
public class SignalV1Service implements ISignalV1Service {

    private final YunxinApiHttpClient httpClient;

    public SignalV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateSignalRoomResponseV1> createRoom(CreateSignalRoomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.CREATE_ROOM, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        CreateSignalRoomResponseV1 response = object.getObject("data", CreateSignalRoomResponseV1.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<DelaySignalRoomResponseV1> delayRoom(DelaySignalRoomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.DELAY_ROOM, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        DelaySignalRoomResponseV1 response = object.getObject("data", DelaySignalRoomResponseV1.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<CloseSignalRoomResponseV1> closeRoom(CloseSignalRoomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.CLOSE_ROOM, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        // API返回空的data对象，直接创建空响应对象
        CloseSignalRoomResponseV1 response = new CloseSignalRoomResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<GetSignalRoomInfoResponseV1> getRoomInfo(GetSignalRoomInfoRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.GET_ROOM_INFO, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        GetSignalRoomInfoResponseV1 response = object.getObject("data", GetSignalRoomInfoResponseV1.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<CtrlSignalRoomResponseV1> ctrlRoom(CtrlSignalRoomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.CTRL_ROOM, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        // API返回空的data对象，直接创建空响应对象
        CtrlSignalRoomResponseV1 response = new CtrlSignalRoomResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<InviteSignalRoomResponseV1> invite(InviteSignalRoomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.INVITE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        // API返回空的data对象，直接创建空响应对象
        InviteSignalRoomResponseV1 response = new InviteSignalRoomResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<CancelSignalRoomInviteResponseV1> cancelInvite(CancelSignalRoomInviteRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.CANCEL_INVITE, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        // API返回空的data对象，直接创建空响应对象
        CancelSignalRoomInviteResponseV1 response = new CancelSignalRoomInviteResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<KickSignalRoomResponseV1> kick(KickSignalRoomRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SignalV1UrlContext.KICK, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        // API返回空的data对象，直接创建空响应对象
        KickSignalRoomResponseV1 response = new KickSignalRoomResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

}
