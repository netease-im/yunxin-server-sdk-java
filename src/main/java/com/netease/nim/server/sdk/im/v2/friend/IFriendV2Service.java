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


public interface IFriendV2Service {

    Result<AddFriendResponseV2> addFriend(AddFriendRequestV2 request) throws YunxinSdkException;
    
    Result<DeleteFriendResponseV2> deleteFriend(DeleteFriendRequestV2 request) throws YunxinSdkException;
    
    Result<UpdateFriendResponseV2> updateFriend(UpdateFriendRequestV2 request) throws YunxinSdkException;

    Result<HandleFriendAdditionResponseV2> handleFriendAddition(HandleFriendAdditionRequestV2 request) throws YunxinSdkException;

    Result<GetFriendResponseV2> getFriend(GetFriendRequestV2 request) throws YunxinSdkException;

    Result<ListFriendsResponseV2> listFriends(ListFriendsRequestV2 request) throws YunxinSdkException;
} 