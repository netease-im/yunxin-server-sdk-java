package com.netease.nim.im.server.sdk.v2.message;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.message.request.AddQuickCommentRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.BatchQueryMessagesByIdRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.BatchQueryQuickCommentsRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.BatchSendP2PMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.DeleteConversationMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.DeleteQuickCommentRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.ModifyMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryMessagesByPageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryTeamReadReceiptRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.QueryThreadMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SearchMessagesRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SendMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SendP2PReadReceiptRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.SendTeamReadReceiptRequestV2;
import com.netease.nim.im.server.sdk.v2.message.request.WithdrawMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.message.response.AddQuickCommentResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.BatchQueryMessagesByIdResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.BatchQueryQuickCommentsResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.BatchSendP2PMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.DeleteConversationMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.DeleteQuickCommentResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.ModifyMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryMessagesByPageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryTeamReadReceiptResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.QueryThreadMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SearchMessagesResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SendMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SendP2PReadReceiptResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.SendTeamReadReceiptResponseV2;
import com.netease.nim.im.server.sdk.v2.message.response.WithdrawMessageResponseV2;

/**
 * Interface for Message V2 operations
 */
public interface IMessageV2Service {

    /**
     * Send a message to a conversation (P2P or team chat)
     * 
     * API: POST https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
     * 
     * @param request request containing the conversation ID, message body, and message configuration
     * @return result containing the sent message details
     * @throws YunxinSdkException exception on network error
     */
    Result<SendMessageResponseV2> sendMessage(SendMessageRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch send P2P messages to multiple receivers
     * 
     * API: POST https://open.yunxinapi.com/im/v2/conversations/messages
     * 
     * This method allows sending the same message to multiple receivers in one API call.
     * Up to 100 receivers can be specified in a single request.
     * 
     * @param request request containing sender ID, list of receiver IDs, message content, and configuration
     * @return result containing lists of successfully sent messages and failed messages
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchSendP2PMessageResponseV2> batchSendP2PMessage(BatchSendP2PMessageRequestV2 request) throws YunxinSdkException;
    
    /**
     * Modify (update) a previously sent message
     * 
     * API: POST https://open.yunxinapi.com/im/v2/messages/actions/modifyMsg
     * 
     * Note: This API allows modifying messages sent within the last 7 days.
     * For the same message (identified by the message ID), you cannot update more than once per second,
     * otherwise error code 107449 will be returned.
     * 
     * Only the message sender and the team owner have permission to modify messages by default.
     * 
     * @param request request containing the original message details and modified content
     * @return result containing the modified message information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ModifyMessageResponseV2> modifyMessage(ModifyMessageRequestV2 request) throws YunxinSdkException;
    
    /**
     * Withdraw (recall or delete) a message from a conversation
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
     * 
     * This API supports three types of operations:
     * 1. Unilateral recall (type=1): Supports recalling a P2P or advanced team message within 30 days.
     *    After recall, the message receiver will receive a unilateral recall notification and the corresponding
     *    offline, roaming, and historical messages will be deleted. The message sender will not be notified
     *    and can continue to use the roaming and historical messages.
     * 
     * 2. Bilateral recall (type=2): Supports recalling P2P, advanced team, and super team messages within a
     *    configurable time (default 2 minutes, max 7 days). After recall, both the message receiver and sender
     *    will receive a recall notification, and the corresponding offline, roaming, and historical messages will be deleted.
     * 
     * 3. Delete message (type=3): Supports deleting P2P and advanced team messages within 30 days.
     *    When deleting a message, the corresponding offline, roaming, and historical messages will be deleted.
     *    The client will not be notified of the deletion.
     * 
     * Note: Only the message sender can recall messages by default.
     * 
     * @param request the request containing all parameters for the withdrawal operation
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<WithdrawMessageResponseV2> withdrawMessage(WithdrawMessageRequestV2 request) throws YunxinSdkException;
    
    /**
     * Delete all messages in a conversation
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
     * 
     * This method allows for deleting all messages in a conversation with different options:
     * 1. Delete all roaming messages
     * 2. Delete all history messages
     * 3. Delete both roaming and history messages
     * 
     * @param request the request containing conversation ID and deletion type
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<DeleteConversationMessagesResponseV2> deleteConversationMessages(
            DeleteConversationMessagesRequestV2 request) throws YunxinSdkException;
            
    /**
     * Send P2P read receipt to mark a message as read
     * 
     * API: POST https://open.yunxinapi.com/im/v2/messages/actions/p2p_read_receipt
     * 
     * This method allows you to mark a message as read in a P2P conversation.
     * The read receipt will be sent to the message sender.
     * 
     * @param request the request containing receipt sender, receiver, and message server ID
     * @return result containing the timestamp when the receipt was sent
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<SendP2PReadReceiptResponseV2> sendP2PReadReceipt(
            SendP2PReadReceiptRequestV2 request) throws YunxinSdkException;
            
    /**
     * Send team read receipt to mark messages as read in an advanced team conversation
     * 
     * API: POST https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
     * 
     * This method allows you to mark messages as read in an advanced team conversation.
     * 
     * Notes:
     * - The team read receipt feature must be enabled in the Yunxin console before using this API.
     * - By default, this feature is supported for teams with up to 200 members. This limit can be extended 
     *   to up to 500 members from the console.
     * - Up to 50 messages can be marked as read in a single request.
     * 
     * @param request the request containing receipt sender, team ID, and list of message server IDs
     * @return result containing lists of successfully processed and failed message IDs
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<SendTeamReadReceiptResponseV2> sendTeamReadReceipt(
            SendTeamReadReceiptRequestV2 request) throws YunxinSdkException;
            
    /**
     * Query read/unread details for a message in an advanced team
     * 
     * API: GET https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
     * 
     * This method allows you to query the read/unread details for a specific message in an advanced team,
     * including the number of users who have read or not read the message, and optionally the list of
     * those users' account IDs.
     * 
     * Notes:
     * - This API only supports advanced teams (team_type=1)
     * - The team read receipt feature must be enabled in the Yunxin console before using this API
     * 
     * @param request the request containing team ID, sender ID, and message server ID
     * @return result containing read/unread counts and optionally account ID lists
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<QueryTeamReadReceiptResponseV2> queryTeamReadReceipt(
            QueryTeamReadReceiptRequestV2 request) throws YunxinSdkException;
            
    /**
     * Query details of a single message in a conversation
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
     * 
     * This method allows you to query the details of a specific message in a conversation,
     * including the sender ID, message ID, message type, message content, etc.
     * 
     * @param request the request containing conversation ID, message server ID, and optional parameters
     * @return result containing the message details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<QueryMessageResponseV2> queryMessage(
            QueryMessageRequestV2 request) throws YunxinSdkException;
            
    /**
     * Search historical messages
     * 
     * API: GET https://open.yunxinapi.com/im/v2/messages/actions/search_messages
     * 
     * This method allows searching for historical messages based on sender, message type,
     * and keywords. Results can be filtered by conversation, time period, and other criteria.
     * 
     * Note:
     * - When searching with keywords, notification messages (type 5) cannot be searched.
     * - To search for non-text messages, the content must be included in the text field when constructing the message.
     * - Maximum of 100 results can be returned per query.
     * 
     * @param request request containing search criteria
     * @return result containing matching messages
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if request parameters are invalid
     */
    Result<SearchMessagesResponseV2> searchMessages(SearchMessagesRequestV2 request) throws YunxinSdkException;
    
    /**
     * Query conversation messages with pagination
     * 
     * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
     * 
     * This method allows you to paginate through historical messages in a conversation,
     * including P2P messages, advanced team messages, and super team messages.
     * 
     * Note:
     * - Begin time and end time parameters are required.
     * - Maximum of 100 messages can be returned per page.
     * - Setting descending to true will return messages in ascending order by time.
     * - Setting descending to false will return messages in descending order by time.
     * 
     * @param request request containing pagination parameters
     * @return result containing messages and pagination details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if request parameters are invalid
     */
    Result<QueryMessagesByPageResponseV2> queryConversationMessages(
            QueryMessagesByPageRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch query messages by message IDs
     * 
     * API: POST https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/batch_messages
     * 
     * This method allows you to query multiple historical messages by providing their message IDs,
     * including single chat messages, advanced team messages, and super team messages.
     * 
     * @param request request containing conversation ID and list of message IDs to query
     * @return result containing the successfully queried messages and any failed queries
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if request parameters are invalid
     */
    Result<BatchQueryMessagesByIdResponseV2> batchQueryMessages(
            BatchQueryMessagesByIdRequestV2 request) throws YunxinSdkException;
            
    /**
     * Query thread messages
     * 
     * API: GET https://open.yunxinapi.com/im/v2/messages/actions/thread_messages
     * 
     * This method allows you to query thread messages based on the thread root message,
     * with pagination support.
     * 
     * Note:
     * - Begin time and end time parameters are required.
     * - Maximum of 100 messages can be returned per page.
     * - Setting descending to true will return messages in ascending order by time.
     * - Setting descending to false will return messages in descending order by time.
     * 
     * @param request request containing thread root message details and query parameters
     * @return result containing the thread messages and pagination details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if request parameters are invalid
     */
    Result<QueryThreadMessagesResponseV2> queryThreadMessages(
            QueryThreadMessagesRequestV2 request) throws YunxinSdkException;
            
    /**
     * Add quick comment to a message
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
     * 
     * This method allows adding emoji reactions or other quick comments to existing messages.
     * Quick comments are typically used for emoji reactions but can be extended to other types
     * of lightweight interactions with messages.
     * 
     * @param request request containing operator ID, message details, comment index, and optional configuration
     * @return result containing the comment ID and timestamp
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<AddQuickCommentResponseV2> addQuickComment(
            AddQuickCommentRequestV2 request) throws YunxinSdkException;
            
    /**
     * Delete quick comment from a message
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
     * 
     * This method allows deleting emoji reactions or other quick comments from existing messages.
     * 
     * @param request request containing operator ID, message details, comment index, and optional configuration
     * @return result containing the timestamp when the comment was deleted
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<DeleteQuickCommentResponseV2> deleteQuickComment(
            DeleteQuickCommentRequestV2 request) throws YunxinSdkException;
            
    /**
     * Batch query quick comments for multiple messages
     * 
     * API: POST https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
     * 
     * This method allows querying quick comments for multiple messages in a single request.
     * The response includes both successfully queried comments and any messages for which
     * the query failed.
     * 
     * @param request request containing a list of messages to query comments for
     * @return result containing lists of successful queries with comments and failed queries with error details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<BatchQueryQuickCommentsResponseV2> batchQueryQuickComments(
            BatchQueryQuickCommentsRequestV2 request) throws YunxinSdkException;
} 