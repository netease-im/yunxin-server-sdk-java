package com.netease.nim.server.sdk.im.v2.ai;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.ai.request.ChatAssistRequestV2;
import com.netease.nim.server.sdk.im.v2.ai.response.ChatAssistResponseV2;

public interface IAiSerivce {

    /**
     * AI Chat Assistant.
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException sdk exception
     */
    Result<ChatAssistResponseV2> chatAssist(ChatAssistRequestV2 request) throws YunxinSdkException;

}
