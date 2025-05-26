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
    
    /**
     * Create a conversation group
     * 
     * API: POST https://open.yunxinapi.com/im/v2/conversation_groups
     * 
     * This endpoint creates a conversation group and optionally adds conversations to it.
     * Each account can create a limited number of conversation groups, and each conversation
     * can belong to up to 5 groups.
     * 
     * @param request request containing account ID, group name, and optional conversation IDs
     * @return result containing the created group details and success/failure lists
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateConversationGroupResponseV2> createConversationGroup(CreateConversationGroupRequestV2 request) throws YunxinSdkException;
    
    /**
     * Update a conversation group
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
     * 
     * This endpoint updates a conversation group's properties and optionally adds or removes
     * conversations from the group. Properties that can be updated include:
     * - Group name
     * - Server extension
     * - Adding or removing conversations from the group
     * 
     * Each conversation can belong to at most 5 conversation groups.
     * 
     * @param request request containing group ID, account ID, and updated properties
     * @return result containing the updated group details and success/failure lists
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateConversationGroupResponseV2> updateConversationGroup(UpdateConversationGroupRequestV2 request) throws YunxinSdkException;
    
    /**
     * Delete a conversation group
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
     * 
     * This endpoint deletes a conversation group for the specified account.
     * After deletion, all conversations that were in the group will have their
     * group_ids field updated accordingly.
     * 
     * @param request request containing group ID and account ID
     * @return result containing success status (empty response body)
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteConversationGroupResponseV2> deleteConversationGroup(DeleteConversationGroupRequestV2 request) throws YunxinSdkException;
    
    /**
     * Get conversation group information
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
     * 
     * This endpoint retrieves information about a specific conversation group.
     * 
     * @param request request containing group ID and account ID
     * @return result containing the conversation group details
     * @throws YunxinSdkException exception on network error
     */
    Result<GetConversationGroupResponseV2> getConversationGroup(GetConversationGroupRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch get conversation groups information
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/actions/group_ids
     * 
     * This endpoint retrieves information about multiple conversation groups in a single request.
     * 
     * @param request request containing account ID and list of group IDs
     * @return result containing the successful and failed conversation group retrievals
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchGetConversationGroupsResponseV2> batchGetConversationGroups(BatchGetConversationGroupsRequestV2 request) throws YunxinSdkException;
    
    /**
     * List all conversation groups for an account
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversation_groups
     * 
     * This endpoint retrieves all conversation groups for a specific account.
     * 
     * @param request request containing the account ID
     * @return result containing the list of all conversation groups
     * @throws YunxinSdkException exception on network error
     */
    Result<ListAllConversationGroupsResponseV2> listAllConversationGroups(ListAllConversationGroupsRequestV2 request) throws YunxinSdkException;

    /**
     * Batch send P2P messages to multiple receivers
     * 
     * API: POST https://open.yunxinapi.com/im/v2/conversations/messages
     * 
     * This endpoint sends a single message to multiple receivers in separate P2P conversations.
     * Maximum 100 receiver IDs can be specified in a single request.
     * 
     * @param request request containing sender ID, receiver IDs, and message content
     * @return result containing the successful and failed message deliveries
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchSendP2PMessageResponseV2> batchSendP2PMessage(BatchSendP2PMessageRequestV2 request) throws YunxinSdkException;
}