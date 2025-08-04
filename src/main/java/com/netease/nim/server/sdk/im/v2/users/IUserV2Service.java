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

    Result<UpdateUserResponseV2> updateUser(UpdateUserRequestV2 request) throws YunxinSdkException;

    Result<GetUserResponseV2> getUser(GetUserRequestV2 request) throws YunxinSdkException;
    
    Result<BatchGetUsersResponseV2> batchGetUsers(BatchGetUsersRequestV2 request) throws YunxinSdkException;
    
    Result<GetUserOnlineStatusResponseV2> getUsersOnlineStatus(GetUserOnlineStatusRequestV2 request) throws YunxinSdkException;
} 