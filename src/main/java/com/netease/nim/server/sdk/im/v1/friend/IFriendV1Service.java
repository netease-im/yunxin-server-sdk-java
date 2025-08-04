package com.netease.nim.server.sdk.im.v1.friend;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.friend.request.*;
import com.netease.nim.server.sdk.im.v1.friend.response.*;

/**
 * Created by yangguoyong
 */
public interface IFriendV1Service {

    Result<AddFriendResponseV1> add(AddFriendRequestV1 request) throws YunxinSdkException;

    Result<UpdateFriendResponseV1> update(UpdateFriendRequestV1 request) throws YunxinSdkException;

    Result<DeleteFriendResponseV1> delete(DeleteFriendRequestV1 request) throws YunxinSdkException;

    Result<GetFriendListResponseV1> get(GetFriendListRequestV1 request) throws YunxinSdkException;

    Result<GetFriendRelationshipResponseV1> getByAccId(GetFriendRelationshipRequestV1 request) throws YunxinSdkException;

}
