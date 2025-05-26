package com.netease.nim.im.server.sdk.v1.friend;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.friend.request.*;
import com.netease.nim.im.server.sdk.v1.friend.response.BaseFriendResponseV1;
import com.netease.nim.im.server.sdk.v1.friend.response.GetFriendListResponseV1;
import com.netease.nim.im.server.sdk.v1.friend.response.GetFriendRelationshipResponseV1;

/**
 * Created by yangguoyong
 */
public interface IFriendV1Service {

    /**
     * /friend/add.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseFriendResponseV1> add(AddFriendRequestV1 request) throws YunxinSdkException;

    /**
     * /friend/update.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseFriendResponseV1> update(UpdateFriendRequestV1 request) throws YunxinSdkException;

    /**
     * /friend/delete.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BaseFriendResponseV1> delete(DeleteFriendRequestV1 request) throws YunxinSdkException;

    /**
     * /friend/get.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetFriendListResponseV1> get(GetFriendListRequestV1 request) throws YunxinSdkException;


    /**
     * /friend/getByAccid.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<GetFriendRelationshipResponseV1> getByAccId(GetFriendRelationshipRequestV1 request) throws YunxinSdkException;

}
