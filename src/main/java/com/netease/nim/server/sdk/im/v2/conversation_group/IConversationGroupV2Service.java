package com.netease.nim.server.sdk.im.v2.conversation_group;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.*;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.*;

/**
 * Interface for Conversation Group V2 operations
 */
public interface IConversationGroupV2Service {

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
} 