package com.netease.nim.server.sdk.im.v2.conversation_unread;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.conversation_unread.request.ClearConversationUnreadRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.request.OverViewsConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.response.ClearConversationUnreadResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.response.OverViewsConversationResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;

/**
 * Service implementation for Conversation Unread V2 operations
 */
public class ConversationUnreadV2Service implements IConversationUnreadV2Service {

    private final YunxinApiHttpClient httpClient;

    public ConversationUnreadV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<OverViewsConversationResponseV2> getConversationOverview(OverViewsConversationRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = ConversationUnreadV2UrlContext.OVERVIEWS_CONVERSATION.replace("{account_id}", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET, 
            ConversationUnreadV2UrlContext.OVERVIEWS_CONVERSATION,
            path, 
            null, 
            null
        );
        return ResultUtils.convert(apiResponse, OverViewsConversationResponseV2.class);
    }

    @Override
    public Result<ClearConversationUnreadResponseV2> clearConversationUnread(ClearConversationUnreadRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the conversationId
        String path = ConversationUnreadV2UrlContext.CLEAR_CONVERSATION_UNREAD.replace("{conversation_id}", request.getConversationId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH, 
            ConversationUnreadV2UrlContext.CLEAR_CONVERSATION_UNREAD,
            path, 
            null, 
            null
        );
        return ResultUtils.convert(apiResponse, ClearConversationUnreadResponseV2.class);
    }
} 