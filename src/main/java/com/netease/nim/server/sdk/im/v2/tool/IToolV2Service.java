package com.netease.nim.server.sdk.im.v2.tool;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.tool.request.AsrRequestV2;
import com.netease.nim.server.sdk.im.v2.ai.request.ChatAssistRequestV2;
import com.netease.nim.server.sdk.im.v2.ai.response.ChatAssistResponseV2;
import com.netease.nim.server.sdk.im.v2.tool.response.AsrResponseV2;
import com.netease.nim.server.sdk.im.v2.translation.request.TranslateTextRequestV2;
import com.netease.nim.server.sdk.im.v2.translation.response.TranslateTextResponseV2;

/**
 * V2 tool service interface
 */
public interface IToolV2Service {
    /**
     * Speech-to-text
     *
     * @param request speech-to-text request
     * @return AsrResponseV2
     */
    Result<AsrResponseV2> asr(AsrRequestV2 request) throws YunxinSdkException;


    Result<TranslateTextResponseV2> translateText(TranslateTextRequestV2 request) throws YunxinSdkException;
}
