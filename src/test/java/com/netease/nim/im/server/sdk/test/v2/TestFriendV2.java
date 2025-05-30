package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v2.YunxinV2ApiServices;
import com.netease.nim.im.server.sdk.v2.account.IAccountV2Service;
import com.netease.nim.im.server.sdk.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.friend.IFriendV2Service;
import com.netease.nim.im.server.sdk.v2.friend.request.AddFriendRequestV2;
import com.netease.nim.im.server.sdk.v2.friend.request.DeleteFriendRequestV2;
import com.netease.nim.im.server.sdk.v2.friend.request.GetFriendRequestV2;
import com.netease.nim.im.server.sdk.v2.friend.request.HandleFriendAdditionRequestV2;
import com.netease.nim.im.server.sdk.v2.friend.request.ListFriendsRequestV2;
import com.netease.nim.im.server.sdk.v2.friend.request.UpdateFriendRequestV2;
import com.netease.nim.im.server.sdk.v2.friend.response.AddFriendResponseV2;
import com.netease.nim.im.server.sdk.v2.friend.response.DeleteFriendResponseV2;
import com.netease.nim.im.server.sdk.v2.friend.response.GetFriendResponseV2;
import com.netease.nim.im.server.sdk.v2.friend.response.HandleFriendAdditionResponseV2;
import com.netease.nim.im.server.sdk.v2.friend.response.ListFriendsResponseV2;
import com.netease.nim.im.server.sdk.v2.friend.response.UpdateFriendResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * Test class for FriendV2Service
 */
public class TestFriendV2 {

    private static YunxinV2ApiServices services = null;
    private static String accountId1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String accountId2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String accountId3 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String accountId4 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);
        CreateAccounts();
    }

    /**
     * Test for creating accounts for friendship testing
     */

    public static void CreateAccounts() throws YunxinSdkException {
        if (services == null) return;
        
        String name1 = "testUser1-" + UUID.randomUUID();
        String name2 = "testUser2-" + UUID.randomUUID();
        String name3 = "testUser3-" + UUID.randomUUID();
        String name4 = "testUser4-" + UUID.randomUUID();
        
        createAccount(accountId1, name1);
        createAccount(accountId2, name2);
        createAccount(accountId3, name3);
        createAccount(accountId4, name4);
    }
    
    /**
     * Test direct friend addition (without verification)
     */
    @Test
    public void testAddFriendDirect() throws YunxinSdkException {
        if (services == null) return;
        
        // Test direct friend addition
        addFriendDirect(accountId1, accountId2);
    }
    
    /**
     * Test getting friend information
     */
    @Test
    public void testGetFriend() throws YunxinSdkException {
        if (services == null) return;
        
        // Make sure friendship exists
        testAddFriendDirect();
        
        // Test getting friend information
        getFriend(accountId1, accountId2);
    }
    
    /**
     * Test updating friend information
     */
    @Test
    public void testUpdateFriend() throws YunxinSdkException {
        if (services == null) return;
        
        // Make sure friendship exists
        testAddFriendDirect();
        
        // Test updating friend
        updateFriend(accountId1, accountId2);
    }
    
    /**
     * Test friend request that requires verification
     */
    @Test
    public void testSendFriendRequest() throws YunxinSdkException {
        if (services == null) return;
        // Test friend request with verification
        sendFriendRequest(accountId3, accountId1);
    }
    
    /**
     * Test accepting friend request
     */
    @Test
    public void testAcceptFriendRequest() throws YunxinSdkException {
        if (services == null) return;
        
        // Make sure friend request exists
        testSendFriendRequest();
        
        // Test accepting friend request
        acceptFriendRequest(accountId1, accountId3);
    }
    
    /**
     * Test rejecting friend request
     */
    @Test
    public void testRejectFriendRequest() throws YunxinSdkException {
        if (services == null) return;
        
        // Send a friend request to reject
        sendFriendRequest(accountId4, accountId1);
        
        // Test rejecting friend request
        rejectFriendRequest(accountId1, accountId4);
    }
    
    /**
     * Test listing friends
     */
    @Test
    public void testListFriends() throws YunxinSdkException {
        if (services == null) return;
        
        // Make sure we have some friends
        testAddFriendDirect();
        testAcceptFriendRequest();
        
        // Test listing friends
        listFriends(accountId1);
    }
    
    /**
     * Test deleting a friend
     */
    @Test
    public void testDeleteFriend() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure friendship exists
        testAddFriendDirect();
        
        // Test deleting friend
        deleteFriend(accountId1, accountId2);
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
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        System.out.println("createAccount(" + accountId + "):" + result.getMsg());
        Assert.assertEquals(200, result.getCode());
    }
    
    /**
     * Test adding a friend directly (without verification)
     * 
     * @param fromAccountId the account initiating the direct friend addition
     * @param toAccountId the account to be added as a friend
     * @throws YunxinSdkException if an error occurs
     */
    private static void addFriendDirect(String fromAccountId, String toAccountId) throws YunxinSdkException {
        AddFriendRequestV2 request = new AddFriendRequestV2();
        request.setAccountId(fromAccountId);
        request.setFriendAccountId(toAccountId);
        
        // Set type 1 to add friend directly without verification
        request.setType(1);
        
        // Set optional fields
        request.setAlias("Friend Test Alias");
        request.setExtension("{\"custom_key\":\"custom_value\"}");
        
        IFriendV2Service friendService = services.getFriendService();
        Result<AddFriendResponseV2> result = friendService.addFriend(request);
        
        System.out.println("addFriendDirect:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        AddFriendResponseV2 response = result.getResponse();
        Assert.assertEquals(toAccountId, response.getFriendAccountId());
        
        // Print response details
        System.out.println("Added friend directly: " + response.getFriendAccountId());
        if (response.getAlias() != null) {
            System.out.println("Alias: " + response.getAlias());
        }
        if (response.getExtension() != null) {
            System.out.println("Extension: " + response.getExtension());
        }
    }
    
    /**
     * Test getting friend information
     * 
     * @param accountId the account initiating the query
     * @param friendAccountId the friend account to query
     * @throws YunxinSdkException if an error occurs
     */
    private static void getFriend(String accountId, String friendAccountId) throws YunxinSdkException {
        GetFriendRequestV2 request = new GetFriendRequestV2();
        request.setAccountId(accountId);
        request.setFriendAccountId(friendAccountId);
        
        IFriendV2Service friendService = services.getFriendService();
        Result<GetFriendResponseV2> result = friendService.getFriend(request);
        
        System.out.println("getFriend:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        GetFriendResponseV2 response = result.getResponse();
        Assert.assertEquals(friendAccountId, response.getFriendAccountId());
        
        // Print response details
        System.out.println("Got friend information: " + response.getFriendAccountId());
        if (response.getAlias() != null) {
            System.out.println("Alias: " + response.getAlias());
        }
        if (response.getExtension() != null) {
            System.out.println("Extension: " + response.getExtension());
        }
        if (response.getCustomerExtension() != null) {
            System.out.println("Customer extension: " + response.getCustomerExtension());
        }
    }
    
    /**
     * Test listing friends with pagination
     * 
     * @param accountId the account to list friends for
     * @throws YunxinSdkException if an error occurs
     */
    private static void listFriends(String accountId) throws YunxinSdkException {
        ListFriendsRequestV2 request = new ListFriendsRequestV2();
        request.setAccountId(accountId);
        
        // Optional parameters
        request.setLimit(20); // Request 20 items per page
        // request.setPageToken(null); // Start from the beginning
        
        IFriendV2Service friendService = services.getFriendService();
        Result<ListFriendsResponseV2> result = friendService.listFriends(request);
        
        System.out.println("listFriends:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        ListFriendsResponseV2 response = result.getResponse();
        
        // Print pagination information
        System.out.println("Has more: " + response.getHasMore());
        if (response.getNextToken() != null) {
            System.out.println("Next token: " + response.getNextToken());
        }
        
        // Print friend list
        List<ListFriendsResponseV2.FriendItemV2> friends = response.getItems();
        if (friends != null) {
            System.out.println("Found " + friends.size() + " friends:");
            for (ListFriendsResponseV2.FriendItemV2 friend : friends) {
                System.out.println(" - Friend account: " + friend.getFriendAccountId());
                if (friend.getAlias() != null) {
                    System.out.println("   Alias: " + friend.getAlias());
                }
                if (friend.getExtension() != null) {
                    System.out.println("   Extension: " + friend.getExtension());
                }
            }
        } else {
            System.out.println("No friends found");
        }
        
        // Demonstrate how to fetch next page if available
        if (response.getHasMore() != null && response.getHasMore() && response.getNextToken() != null) {
            System.out.println("Fetching next page...");
            
            ListFriendsRequestV2 nextRequest = new ListFriendsRequestV2();
            nextRequest.setAccountId(accountId);
            nextRequest.setLimit(20);
            nextRequest.setPageToken(response.getNextToken());
            
            Result<ListFriendsResponseV2> nextResult = friendService.listFriends(nextRequest);
            
            if (nextResult.getCode() == 200 && nextResult.getResponse() != null) {
                List<ListFriendsResponseV2.FriendItemV2> nextFriends = nextResult.getResponse().getItems();
                if (nextFriends != null) {
                    System.out.println("Next page has " + nextFriends.size() + " more friends");
                }
            }
        }
    }
    
    /**
     * Send a friend request that requires verification
     * 
     * @param fromAccountId the account initiating the friend request
     * @param toAccountId the account to receive the friend request
     * @throws YunxinSdkException if an error occurs
     */
    private static void sendFriendRequest(String fromAccountId, String toAccountId) throws YunxinSdkException {
        AddFriendRequestV2 request = new AddFriendRequestV2();
        request.setAccountId(fromAccountId);
        request.setFriendAccountId(toAccountId);
        
        // Set type 2 to require verification
        request.setType(2);
        
        // Set postscript for verification
        request.setPostscript("Would you like to be my friend?");
        
        // Set optional fields
        request.setAlias("Friend Request Alias");
        request.setExtension("{\"request_key\":\"request_value\"}");
        
        IFriendV2Service friendService = services.getFriendService();
        Result<AddFriendResponseV2> result = friendService.addFriend(request);
        
        System.out.println("sendFriendRequest:" + result.getMsg());
        
        // Note: For friend requests requiring verification, the response may not have all fields
        // until the request is accepted
        Assert.assertEquals(200, result.getCode());
        
        // Print operation details
        System.out.println("Sent friend request: " + fromAccountId + " -> " + toAccountId);
    }
    
    /**
     * Test updating friend information
     * 
     * @param accountId the account initiating the update
     * @param friendAccountId the friend account to be updated
     * @throws YunxinSdkException if an error occurs
     */
    private static void updateFriend(String accountId, String friendAccountId) throws YunxinSdkException {
        UpdateFriendRequestV2 request = new UpdateFriendRequestV2();
        request.setAccountId(accountId);
        request.setFriendAccountId(friendAccountId);
        
        // Set updated fields
        request.setAlias("Updated Friend Alias");
        request.setExtension("{\"updated_key\":\"updated_value\"}");
        request.setCustomerExtension("{\"server_key\":\"server_value\"}");
        
        IFriendV2Service friendService = services.getFriendService();
        Result<UpdateFriendResponseV2> result = friendService.updateFriend(request);
        
        System.out.println("updateFriend:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        UpdateFriendResponseV2 response = result.getResponse();
        Assert.assertEquals(friendAccountId, response.getFriendAccountId());
        Assert.assertEquals("Updated Friend Alias", response.getAlias());
        
        // Print response details
        System.out.println("Updated friend: " + response.getFriendAccountId());
        if (response.getAlias() != null) {
            System.out.println("New alias: " + response.getAlias());
        }
        if (response.getExtension() != null) {
            System.out.println("New extension: " + response.getExtension());
        }
        if (response.getCustomerExtension() != null) {
            System.out.println("New customer extension: " + response.getCustomerExtension());
        }
    }
    
    /**
     * Accept a friend request
     * 
     * @param accountId the account accepting the request
     * @param friendAccountId the friend account who sent the request
     * @throws YunxinSdkException if an error occurs
     */
    private static void acceptFriendRequest(String accountId, String friendAccountId) throws YunxinSdkException {
        HandleFriendAdditionRequestV2 request = new HandleFriendAdditionRequestV2();
        request.setAccountId(accountId);
        request.setFriendAccountId(friendAccountId);
        
        // Set type to accept
        request.setType(HandleFriendAdditionRequestV2.TYPE_ACCEPT);
        
        // Set optional fields for acceptance
        request.setAlias("Accepted Friend Alias");
        request.setExtension("{\"acceptance_key\":\"acceptance_value\"}");
        request.setCustomerExtension("{\"server_acceptance_key\":\"server_value\"}");
        request.setPostscript("I'm happy to accept your friend request!");
        
        IFriendV2Service friendService = services.getFriendService();
        Result<HandleFriendAdditionResponseV2> result = friendService.handleFriendAddition(request);
        
        System.out.println("acceptFriendRequest:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        
        if (result.getResponse() != null) {
            HandleFriendAdditionResponseV2 response = result.getResponse();
            Assert.assertEquals(friendAccountId, response.getFriendAccountId());
            
            // Print response details
            System.out.println("Accepted friend: " + response.getFriendAccountId());
            if (response.getAlias() != null) {
                System.out.println("Alias: " + response.getAlias());
            }
            if (response.getExtension() != null) {
                System.out.println("Extension: " + response.getExtension());
            }
            if (response.getCustomerExtension() != null) {
                System.out.println("Customer extension: " + response.getCustomerExtension());
            }
        }
    }
    
    /**
     * Reject a friend request
     * 
     * @param accountId the account rejecting the request
     * @param friendAccountId the friend account who sent the request
     * @throws YunxinSdkException if an error occurs
     */
    private static void rejectFriendRequest(String accountId, String friendAccountId) throws YunxinSdkException {
        HandleFriendAdditionRequestV2 request = new HandleFriendAdditionRequestV2();
        request.setAccountId(accountId);
        request.setFriendAccountId(friendAccountId);
        
        // Set type to reject
        request.setType(HandleFriendAdditionRequestV2.TYPE_REJECT);
        
        // Set postscript message for rejection
        request.setPostscript("Sorry, I cannot accept your friend request at this time.");
        
        IFriendV2Service friendService = services.getFriendService();
        Result<HandleFriendAdditionResponseV2> result = friendService.handleFriendAddition(request);
        
        System.out.println("rejectFriendRequest:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        
        // Print operation details
        System.out.println("Rejected friend request from: " + friendAccountId);
    }
    
    /**
     * Test deleting a friend
     * 
     * @param fromAccountId the account initiating the deletion
     * @param toAccountId the friend account to be deleted
     * @throws YunxinSdkException if an error occurs
     */
    private static void deleteFriend(String fromAccountId, String toAccountId) throws YunxinSdkException {
        DeleteFriendRequestV2 request = new DeleteFriendRequestV2();
        request.setAccountId(fromAccountId);
        request.setFriendAccountId(toAccountId);
        request.setDeleteAlias(true);
        
        IFriendV2Service friendService = services.getFriendService();
        Result<DeleteFriendResponseV2> result = friendService.deleteFriend(request);
        
        System.out.println("deleteFriend:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        
        // Print operation details
        System.out.println("Deleted friend relationship: " + fromAccountId + " -> " + toAccountId);
    }
} 