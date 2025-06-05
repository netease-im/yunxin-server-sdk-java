package com.netease.nim.server.sdk.im.v2.friend;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.friend.request.AddFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.DeleteFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.GetFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.HandleFriendAdditionRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.ListFriendsRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.request.UpdateFriendRequestV2;
import com.netease.nim.server.sdk.im.v2.friend.response.AddFriendResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.DeleteFriendResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.GetFriendResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.HandleFriendAdditionResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.ListFriendsResponseV2;
import com.netease.nim.server.sdk.im.v2.friend.response.UpdateFriendResponseV2;

/**
 * Interface for Friend V2 operations
 */
public interface IFriendV2Service {

    /**
     * Add a friend
     * @param request request containing account IDs and friendship details
     * @return result containing the friend information
     * @throws YunxinSdkException exception on network error
     */
    Result<AddFriendResponseV2> addFriend(AddFriendRequestV2 request) throws YunxinSdkException;
    
    /**
     * Delete a friend
     * @param request request containing the account ID, friend account ID and deletion options
     * @return result containing empty data on success
     * @throws YunxinSdkException exception on network error
     */
    Result<DeleteFriendResponseV2> deleteFriend(DeleteFriendRequestV2 request) throws YunxinSdkException;
    
    /**
     * Update friend information
     * @param request request containing account ID, friend account ID and information to update
     * @return result containing the updated friend information
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateFriendResponseV2> updateFriend(UpdateFriendRequestV2 request) throws YunxinSdkException;
    
    /**
     * Handle friend addition request (accept or reject)
     * @param request request containing details for accepting or rejecting a friend request
     * @return result containing the friend information if accepted
     * @throws YunxinSdkException exception on network error
     */
    Result<HandleFriendAdditionResponseV2> handleFriendAddition(HandleFriendAdditionRequestV2 request) throws YunxinSdkException;
    
    /**
     * Get friend information
     * @param request request containing account ID and friend account ID
     * @return result containing the friend information
     * @throws YunxinSdkException exception on network error
     */
    Result<GetFriendResponseV2> getFriend(GetFriendRequestV2 request) throws YunxinSdkException;
    
    /**
     * List friends with pagination
     * @param request request containing account ID and pagination parameters
     * @return result containing the list of friends and pagination information
     * @throws YunxinSdkException exception on network error
     */
    Result<ListFriendsResponseV2> listFriends(ListFriendsRequestV2 request) throws YunxinSdkException;
} 