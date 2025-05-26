package com.netease.nim.im.server.sdk.v1.translations;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.annotation.YunxinParamUtils;
import com.netease.nim.im.server.sdk.v1.translations.request.TextTranslationRequest;
import com.netease.nim.im.server.sdk.v1.translations.response.TextTranslationResponse;

import java.util.Map;


public class TranslationV1Service implements ITranslationV1Service {

    private final YunxinApiHttpClient httpClient;

    private final static String DATA = "data";

    private final static String CODE = "code";

    private final static String DESC = "desc";


    public TranslationV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public Result<TextTranslationResponse> translatorText(TextTranslationRequest request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(TranslationUrlContext.TEXT_TRANSLATION, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        TextTranslationResponse response = new TextTranslationResponse();
        if (object.containsKey(DATA)) {
            response = JSON.parseObject(object.getString(DATA), TextTranslationResponse.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
