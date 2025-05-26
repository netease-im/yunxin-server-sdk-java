package com.netease.nim.im.server.sdk.v2.translation;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.translation.request.TranslateTextRequestV2;
import com.netease.nim.im.server.sdk.v2.translation.response.TranslateTextResponseV2;

/**
 * Interface for Translation V2 operations
 */
public interface ITranslationV2Service {

    /**
     * Translate text
     * 
     * @param request Request containing the text to translate and language options
     * @return Result containing the translated text and language information
     * @throws YunxinSdkException If there's an error during the API call
     */
    Result<TranslateTextResponseV2> translateText(TranslateTextRequestV2 request) throws YunxinSdkException;
} 