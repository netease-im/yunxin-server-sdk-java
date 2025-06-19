package com.netease.nim.im.server.sdk.test.v2;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.IChatroomV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom.request.CreateChatroomRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.CreateChatroomResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.IChatroomMemberV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ListTaggedMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryChatBannedRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryChatroomBlacklistRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryTaggedMembersCountRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.SetMemberRoleRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleBlockedRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleTaggedMembersChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ToggleTempChatBanRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.BatchQueryChatroomMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ListTaggedMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryChatBannedResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryChatroomBlacklistResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryTaggedMembersCountResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.SetMemberRoleResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleBlockedResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleTaggedMembersChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ToggleTempChatBanResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.BatchQueryChatroomMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.AddVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.ClearVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.DeleteVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.request.QueryVirtualMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.AddVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.ClearVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.DeleteVirtualMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_member.response.QueryVirtualMembersResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Test class for ChatroomMemberV2Service
 */
public class TestChatroomMemberV2 {

    private static YunxinV2ApiServices services;
    private static Long roomId;
    private static String roomCreator;
    
    // Test account IDs
    private static final String creatorId = "creator_" + System.currentTimeMillis();
    private static final String adminId = "admin_" + System.currentTimeMillis();
    private static final String memberId = "member_" + System.currentTimeMillis();
    private static final String guestId = "guest_" + System.currentTimeMillis();
    
    // Test tags
    private static final String testTag1 = "test_tag_1";
    private static final String testTag2 = "test_tag_2";
    
    // Variables for virtual member tests
    private static String virtualMemberId1;
    private static String virtualMemberId2;
    
    /**
     * Initialize test environment once for all tests
     */
    @BeforeClass
    public static void setup() throws Exception {
        // Get appkey and appsecret from system properties or environment variables
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        
        services = new YunxinV2ApiServices(client);
        
        // Initialize test environment
        // Create test accounts
        System.out.println("\n==== Creating Test Accounts ====");
        createAccount(creatorId, "Chatroom Creator");
        createAccount(adminId, "Admin User");
        createAccount(memberId, "Regular Member");
        createAccount(guestId, "Guest User");

        // Create a chatroom with the creator
        roomId = createChatroom(creatorId);
    }

    
    /**
     * Comprehensive test for all chatroom member operations
     * This test covers:
     * 1. Creating test accounts and chatroom
     * 2. Testing member role operations
     * 3. Testing ban/unban operations
     * 4. Testing member tags operations
     * 5. Test block/unblock operations
     * 6. Test tag-based chat ban operations
     */
    @Test
    public void testChatroomMemberOperations() throws Exception {
        if (services == null) {
            setup();
        }
        
        try {
            // Test tag-based chat ban operations
            testTaggedMembersChatBanOperations();
            // Test temporary ban/unban operations
            testChatroomMemberTempBanOperations();
            // Test setting member roles
            testChatroomMemberRoleOperations();

            // Test member tags operations
            testMemberTagsOperations();
            
            // Test block/unblock operations
            testBlockUnblockChatroomMember();

            // Test batch querying chatroom fixed members information
            testBatchQueryChatroomMembers();

            // Virtual members operations
            testVirtualMembersOperations();

            // Test query chat banned members
            testQueryChatBannedMembers();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }

    /**
     * Ensure member is added to the chatroom before operations
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID to add to the chatroom
     */
    private static void ensureMemberInChatroom(Long roomId, String accountId) throws YunxinSdkException {
        // Set member as a regular member to ensure they're in the chatroom
        SetMemberRoleRequestV2 request = new SetMemberRoleRequestV2(
            roomId,       // Chatroom ID
            roomCreator,  // Operator (must be creator)
            2             // Normal member role
        );
        
        // Set basic profile information
        request.setRoomNick("Member " + accountId);
        request.setNotificationEnabled(false);
        request.setAccountId(accountId);

        // Add member to chatroom by setting their role
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<SetMemberRoleResponseV2> result = memberService.setMemberRole(request);
        
        // If failed with code other than already exists, log the issue but continue
        if (result.getCode() != 200) {
            System.out.println("Warning: Failed to add member " + accountId + " to chatroom: " + result.getMsg());
        } else {
            System.out.println("Member " + accountId + " added to chatroom successfully");
        }
    }

    /**
     * Test tag-based chat ban operations
     */
    @Test
    public void testTaggedMembersChatBanOperations() throws YunxinSdkException {
        if (services == null) return;

        // Assign a tag to the member first by adding them to the chatroom
        ensureMemberInChatroom(roomId, memberId);
        
        // Set member role with tag
        SetMemberRoleRequestV2 tagRequest = new SetMemberRoleRequestV2(
            roomId,       // Chatroom ID
            roomCreator,  // Operator (creator)
            2             // Normal member role
        );
        tagRequest.setRoomNick("Test Tagged Member");
        tagRequest.setAccountId(memberId);
        
        // Set tag for the member
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<SetMemberRoleResponseV2> tagResult = memberService.setMemberRole(tagRequest);
        Assert.assertEquals(200, tagResult.getCode());
        
        // Now proceed with ban operations
        // Ban all members with testTag1 (by creator)
        testBanTaggedMembersFromChatting(roomId, testTag1, creatorId, true, 3600L);
        
        // Unban all members with testTag1 (by creator)
        testBanTaggedMembersFromChatting(roomId, testTag1, creatorId, false, null);
        
        // Ban all members with testTag1 (by admin)
        testBanTaggedMembersFromChatting(roomId, testTag1, adminId, true, 1800L);
        
        System.out.println("Tag-based chat ban operations completed successfully");
    }

    /**
     * Test temporary ban and unban operations for chatroom members
     */
    @Test
    public void testChatroomMemberTempBanOperations() throws YunxinSdkException {
        if (services == null) return;

        // Temporarily ban a member (by creator) for 1 hour (3600 seconds)
        testTempBanMemberFromChatting(roomId, memberId, creatorId, true, 3600L);
        
        // Unban a temporarily banned member (by creator)
        testTempBanMemberFromChatting(roomId, memberId, creatorId, false, null);
        
        // Temporarily ban a member (by admin) for 10 minutes (600 seconds)
        testTempBanMemberFromChatting(roomId, memberId, adminId, true, 600L);
        
        System.out.println("Temporary ban/unban operations completed successfully");
    }
    
    /**
     * Test chatroom member role operations
     */
    @Test
    public void testChatroomMemberRoleOperations() throws YunxinSdkException {
        if (services == null) return;

        // Update member profile
        testUpdateMemberProfile(roomId, memberId);
        
        // Set memberId as a guest (removing fixed member status)
        testSetMemberAsGuest(roomId, memberId);
        
        System.out.println("Role operations completed successfully");
    }
    

    
    /**
     * Test member tags operations
     */
    @Test
    public void testMemberTagsOperations() throws YunxinSdkException {
        if (services == null) return;

        // Query count of members with a specific tag (using request object)
        testQueryTaggedMembersCountWithRequest(roomId, testTag1);

        // List members with a specific tag
        testListTaggedMembers(roomId, testTag1, 0L, 10);

        System.out.println("Member tags operations completed successfully");
    }
    
    /**
     * Test comprehensive chatroom member operations including:
     * 1. Block a member (adding to blacklist)
     * 2. Query the chatroom blacklist
     * 3. Unblock a member (removing from blacklist)
     */
    @Test
    public void testBlockUnblockChatroomMember() throws YunxinSdkException {
        if (services == null) return;

        // Block a member (by creator)
        testBlockMemberFromChatroom(roomId, memberId, creatorId, true);
        
        // Immediately query the chatroom blacklist after blocking
        System.out.println("\n==== Querying Blacklist Immediately After Block Operation ====");
        QueryChatroomBlacklistRequestV2 request = new QueryChatroomBlacklistRequestV2(roomId);
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<QueryChatroomBlacklistResponseV2> result = memberService.queryChatroomBlacklist(request);
        System.out.println(result.getResponse());
        System.out.println("Query Chatroom Blacklist: " + result.getMsg());
        Assert.assertEquals(200, result.getCode());
        
        // Verify the blocked member is in the blacklist
        QueryChatroomBlacklistResponseV2 response = result.getResponse();
        if (response != null && response.getItems() != null) {
            boolean memberFound = false;
            for (QueryChatroomBlacklistResponseV2.BlacklistMemberInfoV2 member : response.getItems()) {
                if (member.getAccountId().equals(memberId)) {
                    memberFound = true;
                    System.out.println("Verified blocked member found in blacklist: " + memberId);
                    break;
                }
            }
            Assert.assertTrue("Blocked member should be in the blacklist", memberFound);
        }
        
        // Regular query to test the API method
        testQueryChatroomBlacklist(roomId);
        
        // Unblock a member (by creator)
        testBlockMemberFromChatroom(roomId, memberId, creatorId, false);
        
        System.out.println("Block/unblock operations completed successfully");
    }
    
    /**
     * Test batch querying chatroom fixed members information
     */
    @Test
    public void testBatchQueryChatroomMembers() throws YunxinSdkException {
        if (services == null) return;

        // Create request to batch query members
        BatchQueryChatroomMembersRequestV2 request = new BatchQueryChatroomMembersRequestV2(
            roomId,                                              // Chatroom ID
            Arrays.asList(creatorId, adminId, memberId, guestId) // Account IDs to query
        );
        
        // Batch query chatroom members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<BatchQueryChatroomMembersResponseV2> result = memberService.batchQueryChatroomMembers(request);
        
        System.out.println("Batch Query Chatroom Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Print query results
        BatchQueryChatroomMembersResponseV2 response = result.getResponse();
        if (response != null) {
            // Print successful queries
            List<BatchQueryChatroomMembersResponseV2.MemberInfoV2> successList = response.getSuccessList();
            if (successList != null && !successList.isEmpty()) {
                System.out.println("Successfully queried " + successList.size() + " members:");
                for (BatchQueryChatroomMembersResponseV2.MemberInfoV2 member : successList) {
                    System.out.println("  - " + member.getAccountId() + 
                        " (Role: " + member.getMemberRole() + 
                        ", Online: " + member.getIsOnline() + ")");
                }
            } else {
                System.out.println("No successful queries");
            }
            
            // Print failed queries
            List<BatchQueryChatroomMembersResponseV2.FailedMemberInfoV2> failedList = response.getFailedList();
            if (failedList != null && !failedList.isEmpty()) {
                System.out.println("Failed to query " + failedList.size() + " members:");
                for (BatchQueryChatroomMembersResponseV2.FailedMemberInfoV2 failed : failedList) {
                    System.out.println("  - " + failed.getAccountId() + 
                        " (Error code: " + failed.getErrorCode() + 
                        ", Error message: " + failed.getErrorMsg() + ")");
                }
            } else {
                System.out.println("No failed queries");
            }
        }
        
        System.out.println("Batch query completed successfully");
    }
    
    /**
     * Test virtual members operations (add, query, delete, clear)
     */
    @Test
    public void testVirtualMembersOperations() throws YunxinSdkException {
        if (services == null) return;
        
        // First, add virtual members
        testAddVirtualMembers();
        
        // Then query the virtual members
        testQueryVirtualMembers();
        
        // Delete some virtual members
        testDeleteVirtualMembers();
        
        // Clear all virtual members
        testClearVirtualMembers();
        
        System.out.println("Virtual members operations test completed successfully");
    }

    /**
     * Test updating member profile
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID to update profile
     */
    private static void testUpdateMemberProfile(Long roomId, String accountId) throws YunxinSdkException {

        // Create request to update member profile
        SetMemberRoleRequestV2 request = new SetMemberRoleRequestV2(
            roomId,       // Chatroom ID
            creatorId,    // Operator (creator)
            0             // Keep as regular member, just update profile
        );
        
        // Set updated profile information
        request.setRoomNick("Updated Nickname");
        request.setRoomAvatar("https://example.com/avatar.jpg");
        request.setMemberLevel(10);
        request.setExtension("{\"custom_field\":\"custom_value\",\"updated_at\":" + System.currentTimeMillis() + "}");
        request.setNotificationEnabled(false);  // Don't notify about this profile update
        
        // Update profile
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        request.setAccountId(accountId);
        Result<SetMemberRoleResponseV2> result = memberService.setMemberRole(request);
        
        System.out.println("Update Member Profile: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        System.out.println("Updated profile for " + accountId + " successfully");
    }
    
    /**
     * Test setting a member as guest (removing fixed member status)
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID to set as guest
     */
    private static void testSetMemberAsGuest(Long roomId, String accountId) throws YunxinSdkException {

        // Create request to set member as guest
        SetMemberRoleRequestV2 request = new SetMemberRoleRequestV2(
            roomId,       // Chatroom ID
            creatorId,    // Operator (creator)
            3             // Guest role (removes fixed member status)
        );
        
        // Set additional profile information
        request.setRoomNick("Guest User");
        request.setNotificationEnabled(true);
        request.setNotificationExtension("{\"action\":\"remove_fixed_status\",\"timestamp\":" + System.currentTimeMillis() + "}");
        
        // Set member role
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        request.setAccountId(accountId);
        Result<SetMemberRoleResponseV2> result = memberService.setMemberRole(request);
        
        System.out.println("Set Member as Guest: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        System.out.println("Set " + accountId + " as guest (removed fixed member status) successfully");
    }
    
    /**
     * Test querying the count of members with a specific tag using the request object
     * 
     * @param roomId The ID of the chatroom
     * @param tag The tag to query
     */
    private static void testQueryTaggedMembersCountWithRequest(Long roomId, String tag) throws YunxinSdkException {

        // Create the request
        QueryTaggedMembersCountRequestV2 request = new QueryTaggedMembersCountRequestV2(roomId, tag);
        
        // Query tagged members count
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<QueryTaggedMembersCountResponseV2> result = memberService.queryTaggedMembersCount(request);
        
        System.out.println("Query Tagged Members Count: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Verify response contains data
        QueryTaggedMembersCountResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(tag, response.getTag());
        Assert.assertNotNull(response.getOnlineUserCount());
        
        System.out.println("Count of members with tag '" + tag + "': " + response.getOnlineUserCount());
    }
    
    /**
     * Test listing members with a specific tag with pagination
     * 
     * @param roomId The ID of the chatroom
     * @param tag The tag to query
     * @param offset The offset for pagination
     * @param limit The limit of items per page
     */
    private static void testListTaggedMembers(Long roomId, String tag, Long offset, Integer limit) throws YunxinSdkException {

        // Create the request
        ListTaggedMembersRequestV2 request = new ListTaggedMembersRequestV2(roomId, tag, offset, limit);
        
        // List tagged members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<ListTaggedMembersResponseV2> result = memberService.listTaggedMembers(request);
        
        System.out.println("List Tagged Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Verify response contains data
        ListTaggedMembersResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getHasMore());
        
        // Print out the result information
        System.out.println("Listed members with tag '" + tag + "':");
        System.out.println("  Has more: " + response.getHasMore());
        if (response.getOffset() != null) {
            System.out.println("  Next offset: " + response.getOffset());
        }
        
        List<ListTaggedMembersResponseV2.TaggedMemberInfoV2> members = response.getItems();
        if (members != null && !members.isEmpty()) {
            System.out.println("  Found " + members.size() + " members:");
            for (ListTaggedMembersResponseV2.TaggedMemberInfoV2 member : members) {
                System.out.println("    - " + member.getAccountId() + " (Role: " + member.getMemberRole() + ")");
            }
        } else {
            System.out.println("  No members found with this tag (possibly due to online status)");
        }
    }
    
    /**
     * Test banning/unbanning a member from chatting
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID to ban/unban
     * @param operatorId The account ID of the operator (creator or admin)
     * @param ban true to ban, false to unban
     */
    private static void testBanMemberFromChatting(Long roomId, String accountId, String operatorId, boolean ban) throws YunxinSdkException {

        // Create request to ban/unban member from chatting
        ToggleChatBanRequestV2 request = new ToggleChatBanRequestV2(
            roomId,           // Chatroom ID
            roomCreator,   // Operator (creator or admin)
            ban               // Whether to ban or unban
        );
        
        // Set notification options
        request.setNotificationEnabled(true);
        request.setNotificationExtension("{\"action\":\"" + (ban ? "ban" : "unban") + "\",\"timestamp\":" + System.currentTimeMillis() + "}");
        
        // Ban/unban member
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        request.setAccountId(accountId);
        Result<ToggleChatBanResponseV2> result = memberService.toggleChatBan(request);
        
        System.out.println((ban ? "Ban" : "Unban") + " Member from Chatting: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());

    }

    /**
     * Test temporarily banning/unbanning a member from chatting
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID to ban/unban
     * @param operatorId The account ID of the operator (creator or admin)
     * @param ban true to ban, false to unban
     * @param duration The duration of the temporary ban in seconds, required when ban is true
     */
    private static void testTempBanMemberFromChatting(Long roomId, String accountId, String operatorId, boolean ban, Long duration) throws YunxinSdkException {

        // Always use the actual creator stored from the createChatroom response
        String actualOperator =roomCreator;
        System.out.println("==========");
        System.out.println(roomCreator);
        System.out.println("==========");
        // Create request to temporarily ban/unban member from chatting
        ToggleTempChatBanRequestV2 request = new ToggleTempChatBanRequestV2();
        request.setAccountId(accountId);
        request.setRoomId(roomId);
        request.setOperatorAccountId(actualOperator);
        request.setChatBanned(ban);
        
        if (ban && duration != null) {
            request.setChatBannedDuration(duration);
        }
        
        // Set notification options
        request.setNotificationEnabled(true);
        request.setNotificationExtension("{\"action\":\"" + (ban ? "temp_ban" : "unban") + "\",\"timestamp\":" + System.currentTimeMillis() + "}");
        
        // Temporarily ban/unban member
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<ToggleTempChatBanResponseV2> result = memberService.toggleTempChatBan(request);
        
        System.out.println((ban ? "Temporary Ban" : "Unban") + " Member from Chatting: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // If banning, verify the duration in the response
        if (ban && result.getResponse() != null) {
            Assert.assertNotNull(result.getResponse().getMuteDuration());
            System.out.println("Temporary ban duration: " + result.getResponse().getMuteDuration() + " seconds");
        }
        
        System.out.println((ban ? "Temporarily banned" : "Unbanned") + " " + accountId + " from chatting successfully by " + actualOperator + 
            (ban ? " for " + duration + " seconds" : ""));
    }
    
    /**
     * Test querying chatroom blacklist
     * 
     * @param roomId The ID of the chatroom
     */
    private static void testQueryChatroomBlacklist(Long roomId) throws YunxinSdkException {

        // Create request for querying chatroom blacklist
        QueryChatroomBlacklistRequestV2 request = new QueryChatroomBlacklistRequestV2(roomId);
        
        // Query chatroom blacklist
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<QueryChatroomBlacklistResponseV2> result = memberService.queryChatroomBlacklist(request);
        
        System.out.println("Query Chatroom Blacklist: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Print blacklist members
        QueryChatroomBlacklistResponseV2 response = result.getResponse();
        if (response != null && response.getItems() != null) {
            System.out.println("Total blacklist members: " + response.getItems().size());
            for (QueryChatroomBlacklistResponseV2.BlacklistMemberInfoV2 member : response.getItems()) {
                System.out.println("Blacklist member: " + member.getAccountId() + " (Nick: " + member.getRoomNick() + ")");
            }
        }
        
        System.out.println("Query blacklist for chatroom " + roomId + " successfully");
    }
    
    /**
     * Test blocking/unblocking a member from a chatroom
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID to block/unblock
     * @param operatorId The account ID of the operator (creator or admin)
     * @param block true to block, false to unblock
     */
    private static void testBlockMemberFromChatroom(Long roomId, String accountId, String operatorId, boolean block) throws YunxinSdkException {
        System.out.println("\n==== Testing " + (block ? "Block" : "Unblock") + " Member from Chatroom ====");
        
        // Create request to block/unblock member from chatroom
        ToggleBlockedRequestV2 request = new ToggleBlockedRequestV2();
        request.setAccountId(accountId);
        request.setRoomId(roomId);
        request.setOperatorAccountId(operatorId);
        request.setBlocked(block);
        
        // Set notification options
        request.setNotificationEnabled(true);
        request.setNotificationExtension("{\"action\":\"" + (block ? "block" : "unblock") + "\",\"timestamp\":" + System.currentTimeMillis() + "}");
        
        // Block/unblock member
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        request.setAccountId(accountId);
        Result<ToggleBlockedResponseV2> result = memberService.toggleBlocked(request);
        
        System.out.println((block ? "Block" : "Unblock") + " Member from Chatroom: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        System.out.println((block ? "Blocked" : "Unblocked") + " " + accountId + " from chatroom successfully by " + operatorId);
    }
    
    /**
     * Test banning/unbanning chatroom members with a specific tag
     * 
     * @param roomId The ID of the chatroom
     * @param targetTag The tag of members to ban/unban
     * @param operatorId The account ID of the operator (creator or admin)
     * @param ban true to ban, false to unban
     * @param duration The duration of the ban in seconds (only needed when ban is true)
     */
    private static void testBanTaggedMembersFromChatting(Long roomId, String targetTag, String operatorId, boolean ban, Long duration) throws YunxinSdkException {
        // Make sure we're using the actual room creator for the operation
        String actualOperator = roomCreator;
        if (!operatorId.equals(roomCreator) && operatorId.equals(adminId)) {
            // If operator is admin, ensure they have admin privileges first
            ensureMemberInChatroom(roomId, adminId);
            
            // Set admin role for adminId
            SetMemberRoleRequestV2 adminRequest = new SetMemberRoleRequestV2(
                roomId,       // Chatroom ID
                roomCreator,  // Operator (creator)
                2             // Admin role
            );
            IChatroomMemberV2Service memberService = services.getChatroomMemberService();
            adminRequest.setAccountId(adminId);
            Result<SetMemberRoleResponseV2> adminResult = memberService.setMemberRole(adminRequest);
            
            // Proceed with admin as operator if successful
            if (adminResult.getCode() == 200) {
                actualOperator = adminId;
            }
        }

        // Create request to ban/unban tagged members
        ToggleTaggedMembersChatBanRequestV2 request = new ToggleTaggedMembersChatBanRequestV2(
            roomId,           // Chatroom ID
            actualOperator,   // Operator (creator or admin)
            targetTag,        // Target tag
            ban               // Whether to ban or unban
        );
        
        // Set duration if banning
        if (ban && duration != null) {
            request.setChatBannedDuration(duration);
        }
        
        // Set notification options
        request.setNotificationEnabled(true);
        request.setNotificationExtension("{\"action\":\"" + (ban ? "tag_ban" : "tag_unban") + "\",\"timestamp\":" + System.currentTimeMillis() + "}");
        
        // Ban/unban tagged members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<ToggleTaggedMembersChatBanResponseV2> result = memberService.toggleTaggedMembersChatBan(request);
        
        System.out.println((ban ? "Ban" : "Unban") + " Tagged Members from Chatting: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Verify the duration if banning
        if (ban && result.getResponse() != null) {
            Assert.assertEquals(duration, result.getResponse().getMuteDuration());
            System.out.println("Temporary ban duration for tagged members: " + result.getResponse().getMuteDuration() + " seconds");
        }
        
        System.out.println((ban ? "Banned" : "Unbanned") + " all members with tag '" + targetTag + "' from chatting successfully by " + actualOperator +
            (ban ? " for " + duration + " seconds" : ""));
    }
    
    /**
     * Test adding virtual members to a chatroom
     */
    private static void testAddVirtualMembers() throws YunxinSdkException {
        // Create virtual members to add
        List<AddVirtualMembersRequestV2.VirtualMemberInfoV2> virtualMembers = new ArrayList<>();
        List<String> virtualAccountIds = new ArrayList<>();
        
        System.out.println("\n==== Creating Virtual Member Accounts ====");
        
        // First create the virtual member accounts in the system
        for (int i = 1; i <= 5; i++) {
            String accountId = "virtual_" + i + "_" + System.currentTimeMillis();
            virtualAccountIds.add(accountId);
            
            // Create the account
            createAccount(accountId, "Virtual Member " + i);
            
            // Create virtual member info
            AddVirtualMembersRequestV2.VirtualMemberInfoV2 member = new AddVirtualMembersRequestV2.VirtualMemberInfoV2();
            member.setAccountId(accountId);
            member.setRoomNick("Virtual Member " + i);
            member.setRoomAvatar("http://example.com/virtual_avatar" + i + ".jpg");
            member.setExtension("{\"virtual_id\":" + i + "}");
            virtualMembers.add(member);
            
            // Store the first virtual member ID for later use in delete
            if (i == 1) {
                virtualMemberId1 = accountId;
            } else if (i == 2) {
                virtualMemberId2 = accountId;
            }
        }
        
        // Create request to add virtual members
        AddVirtualMembersRequestV2 request = new AddVirtualMembersRequestV2(roomId, virtualMembers);
        request.setNotificationEnabled(true);
        request.setNotificationExtension("{\"action\":\"add_virtual_members\",\"timestamp\":" + System.currentTimeMillis() + "}");
        
        // Add virtual members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<AddVirtualMembersResponseV2> result = memberService.addVirtualMembers(request);
        
        System.out.println("Add Virtual Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Print add results
        AddVirtualMembersResponseV2 response = result.getResponse();
        if (response != null) {
            // Print successful additions
            List<String> successList = response.getSuccessList();
            if (successList != null && !successList.isEmpty()) {
                System.out.println("Successfully added " + successList.size() + " virtual members:");
                for (String accountId : successList) {
                    System.out.println("  - " + accountId);
                }
            } else {
                System.out.println("No virtual members were successfully added");
            }
            
            // Print failed additions
            List<AddVirtualMembersResponseV2.FailedMemberInfoV2> failedList = response.getFailedList();
            if (failedList != null && !failedList.isEmpty()) {
                System.out.println("Failed to add " + failedList.size() + " virtual members:");
                for (AddVirtualMembersResponseV2.FailedMemberInfoV2 failed : failedList) {
                    System.out.println("  - " + failed.getAccountId() + 
                        " (Error code: " + failed.getErrorCode() + 
                        ", Error message: " + failed.getErrorMsg() + ")");
                }
            } else {
                System.out.println("No failed additions");
            }
        }
        
        System.out.println("Add virtual members completed successfully");
    }
    
    /**
     * Test querying virtual members in a chatroom
     */
    private static void testQueryVirtualMembers() throws YunxinSdkException {
        // Create request to query virtual members
        QueryVirtualMembersRequestV2 request = new QueryVirtualMembersRequestV2(roomId);
        
        // Query virtual members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<QueryVirtualMembersResponseV2> result = memberService.queryVirtualMembers(request);
        
        System.out.println("Query Virtual Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Print virtual members
        QueryVirtualMembersResponseV2 response = result.getResponse();
        if (response != null && response.getItems() != null && !response.getItems().isEmpty()) {
            System.out.println("Found " + response.getItems().size() + " virtual members:");
            for (QueryVirtualMembersResponseV2.VirtualMemberInfoV2 member : response.getItems()) {
                System.out.println("  - Account ID: " + member.getAccountId());
                System.out.println("    Nickname: " + member.getRoomNick());
                System.out.println("    Avatar: " + member.getRoomAvatar());
                System.out.println("    Enter Time: " + member.getEnterTime());
            }
        } else {
            System.out.println("No virtual members found");
        }
        
        System.out.println("Query virtual members completed successfully");
    }
    
    /**
     * Test deleting virtual members from a chatroom
     */
    private static void testDeleteVirtualMembers() throws YunxinSdkException {
        System.out.println("\n---- Testing Delete Virtual Members ----");
        
        // Skip if we don't have virtual member IDs to delete
        if (virtualMemberId1 == null || virtualMemberId2 == null) {
            System.out.println("Skipping delete virtual members test - no member IDs available");
            return;
        }
        
        // Create request to delete virtual members
        List<String> accountIds = Arrays.asList(virtualMemberId1, virtualMemberId2);
        DeleteVirtualMembersRequestV2 request = new DeleteVirtualMembersRequestV2(roomId, accountIds);
        request.setNotificationEnabled(true);
        
        // Delete virtual members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<DeleteVirtualMembersResponseV2> result = memberService.deleteVirtualMembers(request);
        
        System.out.println("Delete Virtual Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Print delete results
        DeleteVirtualMembersResponseV2 response = result.getResponse();
        if (response != null) {
            // Print successful deletions
            List<String> successList = response.getSuccessList();
            if (successList != null && !successList.isEmpty()) {
                System.out.println("Successfully deleted " + successList.size() + " virtual members:");
                for (String accountId : successList) {
                    System.out.println("  - " + accountId);
                }
            } else {
                System.out.println("No virtual members were successfully deleted");
            }
            
            // Print failed deletions
            List<DeleteVirtualMembersResponseV2.FailedMemberInfoV2> failedList = response.getFailedList();
            if (failedList != null && !failedList.isEmpty()) {
                System.out.println("Failed to delete " + failedList.size() + " virtual members:");
                for (DeleteVirtualMembersResponseV2.FailedMemberInfoV2 failed : failedList) {
                    System.out.println("  - " + failed.getAccountId() + 
                        " (Error code: " + failed.getErrorCode() + 
                        ", Error message: " + failed.getErrorMsg() + ")");
                }
            } else {
                System.out.println("No failed deletions");
            }
        }
        
        System.out.println("Delete virtual members completed successfully");
    }
    
    /**
     * Test clearing all virtual members from a chatroom
     */
    private static void testClearVirtualMembers() throws YunxinSdkException {
        System.out.println("\n---- Testing Clear Virtual Members ----");
        
        // Create request to clear all virtual members
        ClearVirtualMembersRequestV2 request = new ClearVirtualMembersRequestV2(roomId);
        request.setNotificationEnabled(true);
        
        // Clear all virtual members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<ClearVirtualMembersResponseV2> result = memberService.clearVirtualMembers(request);
        
        System.out.println("Clear Virtual Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        System.out.println("Clear virtual members completed successfully");
    }

    /**
     * Test querying chat banned members in a chatroom
     */
    @Test
    public void testQueryChatBannedMembers() throws YunxinSdkException {
        if (services == null) return;
        
        System.out.println("\n==== Testing Query Chat Banned Members ====");
        
        // First ban a member to ensure there's at least one banned member
        testBanMemberFromChatting(roomId, memberId, roomCreator, true);
        
        // Create request for querying chat banned members
        QueryChatBannedRequestV2 request = new QueryChatBannedRequestV2(roomId);
        
        // Query chat banned members
        IChatroomMemberV2Service memberService = services.getChatroomMemberService();
        Result<QueryChatBannedResponseV2> result = memberService.queryChatBanned(request);
        System.out.println(result.getResponse());
        System.out.println("Query Chat Banned Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        QueryChatBannedResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        
        // Print banned members
        if (response.getItems() != null && !response.getItems().isEmpty()) {
            System.out.println("Chat banned members in chatroom " + roomId + ":");
            for (QueryChatBannedResponseV2.BannedMember member : response.getItems()) {
                System.out.println("  Account ID: " + member.getAccountId());
                System.out.println("  Nickname: " + member.getRoomNick());
                System.out.println("  Avatar: " + member.getRoomAvatar());
                System.out.println("  ----------------");
            }
            
            // Verify that our banned member is in the list
            boolean bannedMemberFound = false;
            for (QueryChatBannedResponseV2.BannedMember member : response.getItems()) {
                if (member.getAccountId().equals(memberId)) {
                    bannedMemberFound = true;
                    break;
                }
            }
            
            Assert.assertTrue("Banned member should be in the list", bannedMemberFound);
        } else {
            System.out.println("No chat banned members found in chatroom " + roomId);
        }
        
        // Clean up - unban the member
        testBanMemberFromChatting(roomId, memberId, roomCreator, false);
        
        System.out.println("Query chat banned members test completed successfully");
    }

    /**
     * Helper method to create a test account
     *
     * @param accountId the account ID to create
     * @param name the name for the account
     * @throws YunxinSdkException if an error occurs
     */
    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));

        // Set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);

        // Set configuration
        CreateAccountRequestV2.Configuration config = new CreateAccountRequestV2.Configuration();
        config.setEnabled(true);
        request.setConfiguration(config);

        Result<CreateAccountResponseV2> result = services.getAccountService().createAccount(request);

        System.out.println("createAccount(" + accountId + "):" + result.getMsg());
        if (result.getCode() == 200) {
            System.out.println("Created account: " + accountId);
        } else if (result.getCode() == 414) {
            // Account already exists
            System.out.println("Account already exists: " + accountId);
        } else {
            System.err.println("Failed to create account " + accountId + ": " + result.getMsg());
        }
    }
    /**
     * Test creating a basic chatroom with only required parameters
     *
     * @return The ID of the created chatroom
     */
    private static Long createChatroom(String accountId1) throws YunxinSdkException {
        System.out.println("\n==== Testing Basic Chatroom Creation ====");

        // Create a chatroom with only required parameters
        String roomName = "Test Chatroom " + System.currentTimeMillis();
        CreateChatroomRequestV2 basicRequest = new CreateChatroomRequestV2(accountId1, roomName);

        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<CreateChatroomResponseV2> basicResult = chatroomService.createChatroom(basicRequest);

        System.out.println("Basic Chatroom Creation: " + basicResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(basicResult));

        // Verify chatroom was created successfully
        Assert.assertEquals(200, basicResult.getCode());
        CreateChatroomResponseV2 basicResponse = basicResult.getResponse();
        Assert.assertNotNull(basicResponse);
        Assert.assertEquals(accountId1, basicResponse.getCreator());
        Assert.assertEquals(roomName, basicResponse.getRoomName());
        Assert.assertNotNull(basicResponse.getRoomId());

        Long roomId = basicResponse.getRoomId();
        System.out.println("Created basic chatroom:");
        System.out.println("  Room ID: " + roomId);
        System.out.println("  Creator: " + basicResponse.getCreator());
        System.out.println("  Room Name: " + basicResponse.getRoomName());
        roomCreator=accountId1;
        return roomId;
    }
} 