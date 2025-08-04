package com.netease.nim.server.sdk.im.v1.translations;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.translations.request.TextTranslationRequestV1;
import com.netease.nim.server.sdk.im.v1.translations.response.TextTranslationResponseV1;

/**
 * Created by yangguoyong
 */
public interface ITranslationV1Service {

    Result<TextTranslationResponseV1> translatorText(TextTranslationRequestV1 request) throws YunxinSdkException;
}
