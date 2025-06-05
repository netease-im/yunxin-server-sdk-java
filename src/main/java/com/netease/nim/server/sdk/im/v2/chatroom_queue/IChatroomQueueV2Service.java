package com.netease.nim.server.sdk.im.v2.chatroom_queue;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.DeleteChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.InitializeChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.PollChatroomQueueElementRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.QueryChatroomQueueElementsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.UpdateChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.DeleteChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.InitializeChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.PollChatroomQueueElementResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.QueryChatroomQueueElementsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.UpdateChatroomQueueResponseV2;

/**
 * Interface for Chatroom Queue V2 operations
 */
public interface IChatroomQueueV2Service {

    /**
     * Initialize a chatroom queue
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_queues/{room_id}
     * 
     * This method initializes a queue in the specified chatroom. Chatroom queues consist of
     * multiple key-value elements and are primarily used for scenarios such as voice chat room
     * connection and gift queue display in live streaming.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and queue configuration
     * @return result containing the operation result
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<InitializeChatroomQueueResponseV2> initializeChatroomQueue(InitializeChatroomQueueRequestV2 request) throws YunxinSdkException;
    
    /**
     * Query specific elements in a chatroom queue
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_queues/{room_id}/actions/query
     * 
     * This method queries specific elements in a chatroom queue by their keys.
     * If no element keys are specified, all elements in the queue will be returned.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and element keys to query
     * @return result containing the queried queue elements
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<QueryChatroomQueueElementsResponseV2> queryChatroomQueueElements(QueryChatroomQueueElementsRequestV2 request) throws YunxinSdkException;
    
    /**
     * Update chatroom queue by adding or updating elements
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_queues/{room_id}
     * 
     * This method updates a chatroom queue by adding or updating queue elements.
     * Elements can be added as new elements or update existing ones based on the specified policy.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID, operator account ID, and elements to add or update
     * @return result containing the operation result with lists of inserted and updated elements
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<UpdateChatroomQueueResponseV2> updateChatroomQueue(UpdateChatroomQueueRequestV2 request) throws YunxinSdkException;
    
    /**
     * Delete a chatroom queue
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/room_queues/{room_id}
     * 
     * This method deletes a queue in the specified chatroom.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and notification configuration
     * @return result containing information about the deleted queue
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<DeleteChatroomQueueResponseV2> deleteChatroomQueue(DeleteChatroomQueueRequestV2 request) throws YunxinSdkException;
    
    /**
     * Poll an element from a chatroom queue
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_queues/{room_id}/actions/poll
     * 
     * This method polls (retrieves and removes) an element from a chatroom queue.
     * If an element key is specified, that element will be polled.
     * If no element key is specified, the first element in the queue will be polled.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request the request containing chatroom ID and optional element key to poll
     * @return result containing the polled element details
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<PollChatroomQueueElementResponseV2> pollChatroomQueueElement(PollChatroomQueueElementRequestV2 request) throws YunxinSdkException;
} 