package com.netease.nim.server.sdk.im.v1.translations;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.translations.request.TextTranslationRequest;
import com.netease.nim.server.sdk.im.v1.translations.response.TextTranslationResponse;

/**
 * Created by yangguoyong
 */
public interface ITranslationV1Service {

    /**
     * /translator/textMsg.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<TextTranslationResponse> translatorText(TextTranslationRequest request) throws YunxinSdkException;
}
