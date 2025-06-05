package com.netease.nim.server.sdk.im.v2.users;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.users.request.BatchGetUsersRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.GetUserOnlineStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.GetUserRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.UpdateUserRequestV2;
import com.netease.nim.server.sdk.im.v2.users.response.BatchGetUsersResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.GetUserOnlineStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.GetUserResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.UpdateUserResponseV2;

/**
 * Interface for User V2 operations
 */
public interface IUserV2Service {

    /**
     * Update user information
     * @param request request containing user information to update
     * @return result containing the updated user information
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateUserResponseV2> updateUser(UpdateUserRequestV2 request) throws YunxinSdkException;
    
    /**
     * Get user information
     * @param request request containing the account ID to query
     * @return result containing the user information
     * @throws YunxinSdkException exception on network error
     */
    Result<GetUserResponseV2> getUser(GetUserRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch get users information
     * @param request request containing the list of account IDs to query (maximum 100)
     * @return result containing lists of successful and failed queries
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchGetUsersResponseV2> batchGetUsers(BatchGetUsersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Get users' online status
     * @param request request containing the list of account IDs to query (maximum 100)
     * @return result containing online status information and failed queries
     * @throws YunxinSdkException exception on network error
     */
    Result<GetUserOnlineStatusResponseV2> getUsersOnlineStatus(GetUserOnlineStatusRequestV2 request) throws YunxinSdkException;
} 