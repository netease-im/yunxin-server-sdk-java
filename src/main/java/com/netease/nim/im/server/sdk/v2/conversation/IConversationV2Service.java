package com.netease.nim.im.server.sdk.v2.conversation;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.conversation.request.*;
import com.netease.nim.im.server.sdk.v2.conversation.response.*;

/**
 * Interface for Conversation V2 operations
 */
public interface IConversationV2Service {

    /**
     * Create a conversation
     * 
     * API: POST https://open.yunxinapi.com/im/v2/conversations
     * 
     * @param request request containing the conversation ID
     * @return result containing the created conversation details
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateConversationResponseV2> createConversation(CreateConversationRequestV2 request) throws YunxinSdkException;
    
    /**
     * Update a conversation
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/conversations/{conversation_id}
     * 
     * @param request request containing the conversation ID and updated conversation information
     * @return result containing the updated conversation details
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateConversationResponseV2> updateConversation(UpdateConversationRequestV2 request) throws YunxinSdkException;
    
    /**
     * Delete a conversation
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}
     * 
     * @param request request containing the conversation ID and deletion options
     * @return result containing success status
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteConversationResponseV2> deleteConversation(DeleteConversationRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch delete multiple conversations
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/conversations/actions/conversation_ids
     * 
     * @param request request containing the list of conversation IDs and deletion options
     * @return result containing successful and failed deletions
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchDeleteConversationsResponseV2> batchDeleteConversations(BatchDeleteConversationsRequestV2 request) throws YunxinSdkException;
    
    /**
     * Get a conversation by ID
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}
     * 
     * @param request request containing the conversation ID to retrieve
     * @return result containing the conversation details
     * @throws YunxinSdkException exception on network error
     */
    Result<GetConversationResponseV2> getConversation(GetConversationRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch get multiple conversations by their IDs
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversations/actions/conversation_ids
     * 
     * @param request request containing the list of conversation IDs to retrieve
     * @return result containing successful and failed retrievals
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchGetConversationsResponseV2> batchGetConversations(BatchGetConversationsRequestV2 request) throws YunxinSdkException;
    
    /**
     * List conversations for an account with pagination
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversations
     * 
     * @param request request containing the account ID, pagination token, and limit parameters
     * @return result containing paginated list of conversations
     * @throws YunxinSdkException exception on network error
     */
    Result<ListConversationsResponseV2> listConversations(ListConversationsRequestV2 request) throws YunxinSdkException;
    
    /**
     * Stick top (pin) or unstick (unpin) a conversation
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/actions/stick_top_conversation
     * 
     * @param request request containing the conversation ID to pin/unpin and the top type (1 for pin, 0 for unpin)
     * @return result containing success status
     * @throws YunxinSdkException exception on network error
     */
    Result<StickTopConversationResponseV2> stickTopConversation(StickTopConversationRequestV2 request) throws YunxinSdkException;
}