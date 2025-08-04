package com.netease.nim.server.sdk.im.v2.conversation_unread;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.conversation_unread.request.ClearConversationUnreadRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.request.OverViewsConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.response.ClearConversationUnreadResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.response.OverViewsConversationResponseV2;

public interface IConversationUnreadV2Service {

    Result<OverViewsConversationResponseV2> getConversationOverview(OverViewsConversationRequestV2 request) throws YunxinSdkException;
    
    Result<ClearConversationUnreadResponseV2> clearConversationUnread(ClearConversationUnreadRequestV2 request) throws YunxinSdkException;
} 