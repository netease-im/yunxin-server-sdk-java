package com.netease.nim.server.sdk.im.v2.chatroom;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.chatroom.request.CreateChatroomRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.GetChatroomAddressRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.GetChatroomInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ListFixedMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ListOnlineMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.QueryOpenChatroomsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ToggleChatroomMuteRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ToggleInOutNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.UpdateChatroomInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.UpdateChatroomStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.CreateChatroomResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.GetChatroomAddressResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.GetChatroomInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ListFixedMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ListOnlineMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.QueryOpenChatroomsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ToggleChatroomMuteResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ToggleInOutNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.UpdateChatroomInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.UpdateChatroomStatusResponseV2;


public interface IChatroomV2Service {

    Result<CreateChatroomResponseV2> createChatroom(CreateChatroomRequestV2 request) throws YunxinSdkException;
    
    Result<GetChatroomAddressResponseV2> getChatroomAddress(GetChatroomAddressRequestV2 request) throws YunxinSdkException;

    Result<GetChatroomInfoResponseV2> getChatroomInfo(GetChatroomInfoRequestV2 request) throws YunxinSdkException;

    Result<UpdateChatroomInfoResponseV2> updateChatroomInfo(UpdateChatroomInfoRequestV2 request) throws YunxinSdkException;

    Result<UpdateChatroomStatusResponseV2> updateChatroomStatus(UpdateChatroomStatusRequestV2 request) throws YunxinSdkException;
    
    Result<ToggleChatroomMuteResponseV2> toggleChatroomMute(ToggleChatroomMuteRequestV2 request) throws YunxinSdkException;
    
    Result<ToggleInOutNotificationResponseV2> toggleInOutNotification(ToggleInOutNotificationRequestV2 request) throws YunxinSdkException;

    Result<QueryOpenChatroomsResponseV2> queryOpenChatrooms(QueryOpenChatroomsRequestV2 request) throws YunxinSdkException;
    
    Result<ListOnlineMembersResponseV2> listOnlineMembers(ListOnlineMembersRequestV2 request) throws YunxinSdkException;

    Result<ListFixedMembersResponseV2> listFixedMembers(ListFixedMembersRequestV2 request) throws YunxinSdkException;
} 