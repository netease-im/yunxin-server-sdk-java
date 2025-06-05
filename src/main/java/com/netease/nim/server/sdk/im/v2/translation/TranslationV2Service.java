package com.netease.nim.server.sdk.im.v2.translation;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.translation.request.TranslateTextRequestV2;
import com.netease.nim.server.sdk.im.v2.translation.response.TranslateTextResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

/**
 * Implementation of the Translation V2 service
 * 
 * Supported language codes:
 * - "auto": Auto-detect language (for source_language only)
 * - "zh": Chinese
 * - "en": English
 * - "ja": Japanese
 * - "ko": Korean
 * - "fr": French
 * - "es": Spanish
 * - "pt": Portuguese
 * - "it": Italian
 * - "ru": Russian
 * - "de": German
 * And more may be supported by the API.
 */
public class TranslationV2Service implements ITranslationV2Service {

    private final YunxinApiHttpClient yunxinApiHttpClient;

    /**
     * Constructor
     *
     * @param yunxinApiHttpClient HTTP client for API calls
     */
    public TranslationV2Service(YunxinApiHttpClient yunxinApiHttpClient) {
        this.yunxinApiHttpClient = yunxinApiHttpClient;
    }

    @Override
    public Result<TranslateTextResponseV2> translateText(TranslateTextRequestV2 request) throws YunxinSdkException {
        // Validate required parameters
        if (request.getOperatorAccountId() == null || request.getOperatorAccountId().isEmpty()) {
            throw new IllegalArgumentException("Operator account ID cannot be null or empty");
        }
        
        if (request.getSourceText() == null || request.getSourceText().isEmpty()) {
            throw new IllegalArgumentException("Source text cannot be null or empty");
        }
        
        if (request.getTargetLanguage() == null || request.getTargetLanguage().isEmpty()) {
            throw new IllegalArgumentException("Target language cannot be null or empty");
        }
        
        // Set default source language to "auto" if not provided
        if (request.getSourceLanguage() == null || request.getSourceLanguage().isEmpty()) {
            request.setSourceLanguage("auto");
        }
        
        // Convert request to JSON string
        String jsonRequestBody = JSON.toJSONString(request);
        
        // Execute API call
        YunxinApiResponse apiResponse = yunxinApiHttpClient.executeV2Api(
            HttpMethod.POST,
            TranslationUrlContextV2.TRANSLATE_TEXT,
            TranslationUrlContextV2.TRANSLATE_TEXT,
            null,
            jsonRequestBody
        );
        
        return ResultUtils.convert(apiResponse, TranslateTextResponseV2.class);
    }
} 