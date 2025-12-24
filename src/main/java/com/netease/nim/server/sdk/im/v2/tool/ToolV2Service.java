package com.netease.nim.server.sdk.im.v2.tool;

import com.netease.nim.server.sdk.core.exception.YunxinSdkException;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;

import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.tool.request.AsrRequestV2;
import com.netease.nim.server.sdk.im.v2.tool.response.AsrResponseV2;
import com.netease.nim.server.sdk.im.v2.translation.request.TranslateTextRequestV2;
import com.netease.nim.server.sdk.im.v2.translation.response.TranslateTextResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;


/**
 * V2 tool service implementation
 */
public class ToolV2Service implements IToolV2Service {


    private final YunxinApiHttpClient yunxinApiHttpClient;

    public ToolV2Service(YunxinApiHttpClient yunxinApiHttpClient) {
        this.yunxinApiHttpClient = yunxinApiHttpClient;
    }

    @Override
    public Result<AsrResponseV2> asr(AsrRequestV2 request) throws YunxinSdkException {

        String body = JSON.toJSONString(request);
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
                HttpMethod.POST,
                ToolV2UrlContext.ASR_URL,
                ToolV2UrlContext.ASR_URL,
                null,
                body
        );
        return ResultUtils.convert(apiResponse, AsrResponseV2.class);
    }
    @Override
    public Result<TranslateTextResponseV2> translateText(TranslateTextRequestV2 request) throws YunxinSdkException {
        // Set default source language to "auto" if not provided
        if (request.getSourceLanguage() == null || request.getSourceLanguage().isEmpty()) {
            request.setSourceLanguage("auto");
        }

        // Convert request to JSON string
        String jsonRequestBody = JSON.toJSONString(request);

        // Execute API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
                HttpMethod.POST,
                ToolV2UrlContext.TRANSLATE_TEXT,
                ToolV2UrlContext.TRANSLATE_TEXT,
                null,
                jsonRequestBody
        );

        return ResultUtils.convert(apiResponse, TranslateTextResponseV2.class);
    }
}
