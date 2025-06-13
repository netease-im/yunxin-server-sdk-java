package com.netease.nim.server.sdk.vod.upload;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.vod.upload.request.VodUploadInitRequest;
import com.netease.nim.server.sdk.vod.upload.response.VodUploadInitResponse;

/**
 * Created by caojiajun on 2025/6/12
 */
public class VodUploadService implements IVodUploadService {

    private final YunxinApiHttpClient httpClient;

    public VodUploadService(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<VodUploadInitResponse> uploadInit(VodUploadInitRequest request) {
        String jsonString = JSONObject.toJSONString(request);
        YunxinApiResponse apiResponse = httpClient.executeJson(HttpMethod.POST, VodUploadUrlContext.UPLOAD_INIT, null, jsonString);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("msg"), null);
        }
        VodUploadInitResponse response = object.getObject("ret", VodUploadInitResponse.class);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
