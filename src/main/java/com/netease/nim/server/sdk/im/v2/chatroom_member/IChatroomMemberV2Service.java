package com.netease.nim.server.sdk.im.v2.chatroom_member;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.AddVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.BatchQueryChatroomMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ListTaggedMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ModifyMemberTagsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryChatBannedRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryChatroomBlacklistRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryTaggedMembersCountRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.SetMemberRoleRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleBlockedRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleTaggedMembersChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleTempChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.UpdateOnlineMemberInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.DeleteVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.AddVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.BatchQueryChatroomMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ListTaggedMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ModifyMemberTagsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryChatBannedResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryChatroomBlacklistResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryTaggedMembersCountResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.SetMemberRoleResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleBlockedResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleTaggedMembersChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleTempChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.UpdateOnlineMemberInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.DeleteVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ClearVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ClearVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.KickChatRoomMemberRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.KickChatRoomMemberResponseV2;

public interface IChatroomMemberV2Service {

    Result<SetMemberRoleResponseV2> setMemberRole(SetMemberRoleRequestV2 request) throws YunxinSdkException;

    Result<UpdateOnlineMemberInfoResponseV2> updateOnlineMemberInfo(UpdateOnlineMemberInfoRequestV2 request) throws YunxinSdkException;

    Result<ToggleChatBanResponseV2> toggleChatBan(ToggleChatBanRequestV2 request) throws YunxinSdkException;

    Result<ToggleTempChatBanResponseV2> toggleTempChatBan(ToggleTempChatBanRequestV2 request) throws YunxinSdkException;
    
    Result<ToggleBlockedResponseV2> toggleBlocked(ToggleBlockedRequestV2 request) throws YunxinSdkException;
    
    Result<ModifyMemberTagsResponseV2> modifyMemberTags(ModifyMemberTagsRequestV2 request) throws YunxinSdkException;

    Result<QueryTaggedMembersCountResponseV2> queryTaggedMembersCount(QueryTaggedMembersCountRequestV2 request) throws YunxinSdkException;
    
    Result<ListTaggedMembersResponseV2> listTaggedMembers(ListTaggedMembersRequestV2 request) throws YunxinSdkException;
    
    Result<QueryChatroomBlacklistResponseV2> queryChatroomBlacklist(QueryChatroomBlacklistRequestV2 request) throws YunxinSdkException;
    
    Result<ToggleTaggedMembersChatBanResponseV2> toggleTaggedMembersChatBan(ToggleTaggedMembersChatBanRequestV2 request) throws YunxinSdkException;

    Result<BatchQueryChatroomMembersResponseV2> batchQueryChatroomMembers(BatchQueryChatroomMembersRequestV2 request) throws YunxinSdkException;
    
    Result<AddVirtualMembersResponseV2> addVirtualMembers(AddVirtualMembersRequestV2 request) throws YunxinSdkException;
    
    Result<DeleteVirtualMembersResponseV2> deleteVirtualMembers(DeleteVirtualMembersRequestV2 request) throws YunxinSdkException;
    
    Result<ClearVirtualMembersResponseV2> clearVirtualMembers(ClearVirtualMembersRequestV2 request) throws YunxinSdkException;
    
    Result<QueryVirtualMembersResponseV2> queryVirtualMembers(QueryVirtualMembersRequestV2 request) throws YunxinSdkException;
    
    Result<QueryChatBannedResponseV2> queryChatBanned(QueryChatBannedRequestV2 request) throws YunxinSdkException;
    
    Result<KickChatRoomMemberResponseV2> kickMember(KickChatRoomMemberRequestV2 request) throws YunxinSdkException;
} 