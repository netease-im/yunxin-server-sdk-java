package com.netease.nim.server.sdk.im.v2.conversation_unread;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.conversation_unread.request.ClearConversationUnreadRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.request.OverViewsConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.response.ClearConversationUnreadResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_unread.response.OverViewsConversationResponseV2;

/**
 * Interface for Conversation Unread V2 operations
 */
public interface IConversationUnreadV2Service {

    /**
     * Get a conversation overview for an account
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversation_overviews/{account_id}
     * 
     * This endpoint retrieves the total unread count across all conversations for a specific account.
     * 
     * @param request request containing the account ID
     * @return result containing the account ID and total unread count
     * @throws YunxinSdkException exception on network error
     */
    Result<OverViewsConversationResponseV2> getConversationOverview(OverViewsConversationRequestV2 request) throws YunxinSdkException;
    
    /**
     * Clear the unread count of a conversation
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/actions/clear_conversation_unread
     * 
     * This endpoint resets the unread count for a specific conversation to zero.
     * If the conversation ID doesn't exist, a 414 error code will be returned.
     * 
     * @param request request containing the conversation ID to clear unread count for
     * @return result containing success status (empty response body)
     * @throws YunxinSdkException exception on network error
     */
    Result<ClearConversationUnreadResponseV2> clearConversationUnread(ClearConversationUnreadRequestV2 request) throws YunxinSdkException;
} 