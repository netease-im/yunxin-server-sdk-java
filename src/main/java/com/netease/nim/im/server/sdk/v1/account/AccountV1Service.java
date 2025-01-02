package com.netease.nim.im.server.sdk.v1.account;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.v1.account.request.*;
import com.netease.nim.im.server.sdk.v1.account.response.*;
import com.netease.nim.im.server.sdk.v1.annotation.YunxinParamUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/11
 */
public class AccountV1Service implements IAccountV1Service {

    private final YunxinApiHttpClient httpClient;

    public AccountV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateAccountResponseV1> createAccount(CreateAccountRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/create.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        CreateAccountResponseV1 response = object.getObject("info", CreateAccountResponseV1.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<UpdateTokenResponseV1> updateToken(UpdateTokenRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/update.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new UpdateTokenResponseV1());
    }

    @Override
    public Result<RefreshTokenResponseV1> refreshToken(RefreshTokenRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/refreshToken.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        RefreshTokenResponseV1 response = object.getObject("info", RefreshTokenResponseV1.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<BlockAccountResponseV1> block(BlockAccountRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/block.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new BlockAccountResponseV1());
    }

    @Override
    public Result<UnBlockAccountResponseV1> unblock(UnBlockAccountRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/unblock.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new UnBlockAccountResponseV1());
    }

    @Override
    public Result<MuteAccountResponseV1> mute(MuteAccountRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/mute.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new MuteAccountResponseV1());
    }

    @Override
    public Result<MuteModuleResponseV1> muteModule(MuteModuleRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/muteModule.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        MuteModuleResponseV1 response = object.getObject("data", MuteModuleResponseV1.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<SetDonnopResponseV1> setDonnop(SetDonnopRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/setDonnop.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, new SetDonnopResponseV1());
    }

    @Override
    public Result<QueryAccountOnlineStatusResponseV1> queryOnlineStatus(QueryAccountOnlineStatusRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api("/user/userOnlineStatus.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"), null);
        }
        QueryAccountOnlineStatusResponseV1 response = new QueryAccountOnlineStatusResponseV1();
        JSONArray jsonArray = object.getJSONArray("invalidAccids");
        List<String> invalidAccids = new ArrayList<>();
        if (jsonArray != null) {
            for (Object o : jsonArray) {
                invalidAccids.add(String.valueOf(o));
            }
        }
        response.setInvalidAccids(invalidAccids);

        List<QueryAccountOnlineStatusResponseV1.OnlineStatus> onlineStatusList = new ArrayList<>();
        JSONObject statusJson = object.getJSONObject("status");
        if (statusJson != null) {
            for (Map.Entry<String, Object> entry : statusJson.entrySet()) {
                QueryAccountOnlineStatusResponseV1.OnlineStatus onlineStatus = new QueryAccountOnlineStatusResponseV1.OnlineStatus();
                onlineStatus.setAccid(entry.getKey());
                List<QueryAccountOnlineStatusResponseV1.Status> statusList = new ArrayList<>();
                JSONArray array = (JSONArray)entry.getValue();
                for (Object o : array) {
                    JSONObject json = (JSONObject) o;
                    QueryAccountOnlineStatusResponseV1.Status status = new QueryAccountOnlineStatusResponseV1.Status();
                    status.setClientType(json.getIntValue("clientType"));
                    status.setLoginTime(json.getLongValue("loginTime"));
                    statusList.add(status);
                }
                onlineStatus.setStatusList(statusList);
                onlineStatusList.add(onlineStatus);
            }
        }
        response.setOnlineStatusList(onlineStatusList);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
