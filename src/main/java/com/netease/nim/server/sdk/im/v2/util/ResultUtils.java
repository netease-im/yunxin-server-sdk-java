package com.netease.nim.server.sdk.im.v2.util;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiResponse;

/**
 * Created by caojiajun on 2024/12/11
 */
public class ResultUtils {

    public static <T> Result<T> convert(YunxinApiResponse apiResponse, Class<T> clazz) {
        JSONObject json = JSONObject.parseObject(apiResponse.getData());
        int code = json.getIntValue("code");
        String msg = json.getString("msg");
        T response = json.getObject("data", clazz);
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), msg, response);
    }
}
