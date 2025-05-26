package com.netease.nim.im.server.sdk.v2.chatroom_member;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.AddVirtualMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.BatchQueryChatroomMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.ListTaggedMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.ModifyMemberTagsRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.QueryChatroomBlacklistRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.QueryTaggedMembersCountRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.QueryVirtualMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.SetMemberRoleRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.ToggleBlockedRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.ToggleChatBanRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.ToggleTaggedMembersChatBanRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.ToggleTempChatBanRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.UpdateOnlineMemberInfoRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.DeleteVirtualMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.AddVirtualMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.BatchQueryChatroomMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.ListTaggedMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.ModifyMemberTagsResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.QueryChatroomBlacklistResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.QueryTaggedMembersCountResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.QueryVirtualMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.SetMemberRoleResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.ToggleBlockedResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.ToggleChatBanResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.ToggleTaggedMembersChatBanResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.ToggleTempChatBanResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.UpdateOnlineMemberInfoResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.DeleteVirtualMembersResponseV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.request.ClearVirtualMembersRequestV2;
import com.netease.nim.im.server.sdk.v2.chatroom_member.response.ClearVirtualMembersResponseV2;

/**
 * Interface for Chatroom Member V2 operations
 */
public interface IChatroomMemberV2Service {

    /**
     * Set chatroom member role
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_members/{account_id}
     * 
     * This method sets the role of a chatroom member. It can also update the member's profile
     * information such as nickname, avatar, and custom extension data.
     * 
     * Chatroom member roles can be divided into two main categories:
     * 1. Fixed members: Creator, administrators, and regular members (retained in the chatroom 
     *    even when offline, up to 1000 members in total)
     * 2. Non-fixed members: Regular guests, anonymous guests, and fabricated users (only counted 
     *    when online, removed from the list after leaving)
     * 
     * Role permissions:
     * - Only the creator can set other members as administrators
     * - Creator and administrators can set members as regular members or guests
     * - Setting a member as a guest effectively removes their fixed member status
     * - The creator's role cannot be changed or reassigned
     * 
     * @param accountId the account ID of the member to set role
     * @param request request containing the role to set and optional profile information
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<SetMemberRoleResponseV2> setMemberRole(String accountId, SetMemberRoleRequestV2 request) throws YunxinSdkException;
    
    /**
     * Update online chatroom member information
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}
     * 
     * This method updates the information of an online chatroom member, including nickname,
     * avatar, and extension field.
     * 
     * Member types:
     * - Fixed members: Can update online information and optionally persist changes.
     *   If a fixed member is offline and persistence is false, the API will return an error.
     * - Guests: Can only update online information. If a guest is offline, the API will return an error.
     * 
     * @param accountId the account ID of the member to update
     * @param request request containing the information to update
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<UpdateOnlineMemberInfoResponseV2> updateOnlineMemberInfo(String accountId, UpdateOnlineMemberInfoRequestV2 request) throws YunxinSdkException;
    
    /**
     * Ban or unban a chatroom member from chatting
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/chat_banned
     * 
     * This method sets or removes a chatroom member's banned status for chatting.
     * 
     * Permissions:
     * - Only the creator can ban/unban administrators
     * - Creator and administrators can ban/unban regular members
     * - Cannot ban/unban yourself
     * 
     * @param accountId the account ID of the member to ban/unban
     * @param request request containing ban parameters including operator and banned state
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ToggleChatBanResponseV2> toggleChatBan(String accountId, ToggleChatBanRequestV2 request) throws YunxinSdkException;
    
    /**
     * Temporarily ban or unban a chatroom member from chatting
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/temp_chat_banned
     * 
     * This method sets or removes a chatroom member's temporary banned status for chatting.
     * The temporary ban will automatically expire after the specified duration.
     * 
     * Permissions:
     * - Only the creator can temporarily ban/unban administrators
     * - Creator and administrators can temporarily ban/unban regular members
     * - Cannot temporarily ban/unban yourself
     * 
     * @param request request containing temporary ban parameters including member account ID, operator,
     *               banned state, and duration
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ToggleTempChatBanResponseV2> toggleTempChatBan(ToggleTempChatBanRequestV2 request) throws YunxinSdkException;
    
    /**
     * Block or unblock a chatroom member
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/blocked
     * 
     * This method blocks or unblocks a chatroom member. Blocked members are removed from the chatroom
     * and cannot rejoin as long as they remain blocked.
     * 
     * Permissions:
     * - Only the creator or administrators can block/unblock chatroom members
     * - Cannot block the creator
     * 
     * @param accountId the account ID of the member to block/unblock
     * @param request request containing block parameters including operator and blocked state
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ToggleBlockedResponseV2> toggleBlocked(String accountId, ToggleBlockedRequestV2 request) throws YunxinSdkException;
    
    /**
     * Modify online chatroom member tags
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/{account_id}/actions/tags
     * 
     * This method modifies the tags of an online chatroom member. After modification,
     * you can choose whether to notify users with target tags.
     * 
     * For more information about chatroom tags, refer to the chatroom tags documentation.
     * 
     * Permissions:
     * - Only the creator or administrators can modify other online members' tags.
     * 
     * @param accountId the account ID of the member to modify tags
     * @param request request containing the tags to set and notification options
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ModifyMemberTagsResponseV2> modifyMemberTags(String accountId, ModifyMemberTagsRequestV2 request) throws YunxinSdkException;
    
    /**
     * Query the count of online members with a specific tag in a chatroom
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/tagged_members_count
     * 
     * This method queries the number of online chatroom members that have a specific tag.
     * 
     * @param request request containing the room ID and tag to query
     * @return result containing the tag and count of online users with this tag
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<QueryTaggedMembersCountResponseV2> queryTaggedMembersCount(QueryTaggedMembersCountRequestV2 request) throws YunxinSdkException;
    
    /**
     * List online members with a specific tag in a chatroom with pagination
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/list_tag_members
     * 
     * This method lists online chatroom members that have a specific tag with pagination support.
     * 
     * @param request request containing the room ID, tag, offset, and limit for pagination
     * @return result containing the list of tagged members and pagination information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ListTaggedMembersResponseV2> listTaggedMembers(ListTaggedMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Query the blacklist members of a chatroom with pagination
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/blacklist
     * 
     * This method retrieves a list of blocked members in a chatroom with pagination support.
     * Blocked members are users who have been permanently banned from joining the chatroom.
     * 
     * @param request request containing the room ID and pagination parameters
     * @return result containing the list of blocked members and pagination information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<QueryChatroomBlacklistResponseV2> queryChatroomBlacklist(QueryChatroomBlacklistRequestV2 request) throws YunxinSdkException;
    
    /**
     * Toggle chat ban on chatroom members with a specific tag
     * 
     * API: PATCH https://open.yunxinapi.com/im/v2/room_members/actions/chat_banned_tagged_members
     * 
     * This method sets or removes temporary chat ban for all members with a specific tag in a chatroom.
     * 
     * Permissions:
     * - Only the creator can ban/unban administrators
     * - Creator and administrators can ban/unban regular members
     * 
     * @param request request containing parameters including room ID, operator, target tag, ban state, and duration
     * @return result containing the mute duration if successful
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ToggleTaggedMembersChatBanResponseV2> toggleTaggedMembersChatBan(ToggleTaggedMembersChatBanRequestV2 request) throws YunxinSdkException;
    
    /**
     * Batch query chatroom fixed members information
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/batch
     * 
     * This method retrieves information about multiple chatroom fixed members at once.
     * It returns both successfully and unsuccessfully queried members.
     * 
     * @param request request containing the room ID and list of account IDs to query
     * @return result containing the queried members information
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<BatchQueryChatroomMembersResponseV2> batchQueryChatroomMembers(BatchQueryChatroomMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Add virtual members to a chatroom
     * 
     * API: POST https://open.yunxinapi.com/im/v2/room_members/actions/virtual_members
     * 
     * This method adds virtual users to a chatroom. Virtual users are typically only used to increase 
     * the number of online users in a chatroom, not for normal communication.
     * 
     * The same virtual user account can join multiple different chatrooms simultaneously (no limit on the number).
     * Virtual users automatically exit the chatroom after 24 hours, and the countdown resets if they are 
     * added again within 24 hours.
     * 
     * @param request request containing the chatroom ID, list of virtual members, and notification options
     * @return result containing the lists of successfully and unsuccessfully added virtual members
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<AddVirtualMembersResponseV2> addVirtualMembers(AddVirtualMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Delete virtual members from a chatroom
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/room_members/actions/virtual_members
     * 
     * This method deletes virtual users from a chatroom. A maximum of 100 virtual members
     * can be deleted at once.
     * 
     * @param request request containing the chatroom ID and list of virtual member account IDs to delete
     * @return result containing the lists of successfully and unsuccessfully deleted virtual members
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<DeleteVirtualMembersResponseV2> deleteVirtualMembers(DeleteVirtualMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Clear all virtual members from a chatroom
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/room_members/actions/clear_virtual_members
     * 
     * This method removes all virtual users from a chatroom at once.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request request containing the chatroom ID and notification options
     * @return result indicating success or failure
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<ClearVirtualMembersResponseV2> clearVirtualMembers(ClearVirtualMembersRequestV2 request) throws YunxinSdkException;
    
    /**
     * Query virtual members in a chatroom
     * 
     * API: GET https://open.yunxinapi.com/im/v2/room_members/actions/virtual_members
     * 
     * This method retrieves information about virtual members in a chatroom.
     * 
     * Rate limiting:
     * Single application default maximum call frequency, please refer to rate limit documentation.
     * 
     * @param request request containing the chatroom ID
     * @return result containing the list of virtual members in the chatroom
     * @throws YunxinSdkException if a network or server error occurs
     * @throws IllegalArgumentException if required parameters are missing or invalid
     */
    Result<QueryVirtualMembersResponseV2> queryVirtualMembers(QueryVirtualMembersRequestV2 request) throws YunxinSdkException;
} 