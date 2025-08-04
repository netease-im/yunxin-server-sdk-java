package com.netease.nim.server.sdk.im.v1.translations;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.translations.request.TextTranslationRequestV1;
import com.netease.nim.server.sdk.im.v1.translations.response.TextTranslationResponseV1;

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
    public Result<TextTranslationResponseV1> translatorText(TextTranslationRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(TranslationV1UrlContext.TEXT_TRANSLATION, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        TextTranslationResponseV1 response = new TextTranslationResponseV1();
        if (object.containsKey(DATA)) {
            response = JSON.parseObject(object.getString(DATA), TextTranslationResponseV1.class);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
