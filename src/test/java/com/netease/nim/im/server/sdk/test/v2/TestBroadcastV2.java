package com.netease.nim.im.server.sdk.test.v2;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.IBroadcastV2Service;
import com.netease.nim.server.sdk.im.v2.broadcast.request.DeleteBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.QueryBroadcastNotificationListRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.QueryBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.SendBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.request.SendChatroomBroadcastNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.DeleteBroadcastNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.QueryBroadcastNotificationListResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.QueryBroadcastNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.SendBroadcastNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.broadcast.response.SendChatroomBroadcastNotificationResponseV2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for the BroadcastV2Service
 */
public class TestBroadcastV2 {

    private static YunxinV2ApiServices services;
    private static IBroadcastV2Service broadcastService;
    private static IAccountV2Service accountService;
    
    // Test account IDs for basic broadcast tests
    private static final String sender1 = "bcast_sender_" + System.currentTimeMillis();
    private static final String sender2 = "bcast_sender2_" + System.currentTimeMillis();
    private static final String sender3 = "bcast_sender3_" + System.currentTimeMillis();
    
    // Test account IDs for list and pagination tests
    private static final String listSender1 = "bcast_list_sender_" + System.currentTimeMillis();
    private static final String listSender2 = "bcast_list_sender2_" + System.currentTimeMillis();
    
    /**
     * Initialize test environment once for all tests
     */
    @BeforeClass
    public static void setup() {
        if (services != null) {
            return;
        }
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        
        services = new YunxinV2ApiServices(client);
        broadcastService = services.getBroadcastService();
        accountService = services.getAccountService();
        
        // Create test accounts
        try {
            createAccount(sender1, "Broadcast Sender 1");
            createAccount(sender2, "Broadcast Sender 2");
            createAccount(sender3, "Broadcast Sender 3");
            createAccount(listSender1, "Broadcast List Sender 1");
            createAccount(listSender2, "Broadcast List Sender 2");
        } catch (Exception e) {
            System.err.println("Error creating test accounts: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Helper method to create an account
     */
    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        
        // Create and set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);
        
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        // If account already exists, it's not an error for our test
        if (result.getCode() == 200) {
            System.out.println("Created account: " + accountId + ", name: " + name);
            Assert.assertNotNull(result.getResponse());
            Assert.assertEquals(accountId, result.getResponse().getAccountId());
        } else if (result.getCode() == 414) {
            // 414 usually means account already exists
            System.out.println("Account already exists: " + accountId);
        } else {
            // Fail the test for other unexpected errors
            Assert.fail("Failed to create account: " + result.getMsg());
        }
    }
    
    /**
     * Test sending a basic broadcast notification with only required parameters
     */
    @Test
    public void testBasicBroadcastNotification() throws YunxinSdkException {
        if (services == null) return;
        
        // Create a basic broadcast with only required content
        String content = "This is a basic broadcast message at " + System.currentTimeMillis();
        SendBroadcastNotificationRequestV2 basicRequest = new SendBroadcastNotificationRequestV2(content);
        
        // Add sender account ID (non-required parameter)
        basicRequest.setFromAccountId(sender1);
        basicRequest.setOfflineEnabled(true);
        basicRequest.setTargetOs(Arrays.asList("ios", "aos", "pc", "web", "mac"));
        basicRequest.setTtl(24);
        
        // Send the broadcast notification
        Result<SendBroadcastNotificationResponseV2> basicResult = broadcastService.sendBroadcastNotification(basicRequest);
        
        System.out.println("Basic Broadcast Notification: " + basicResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(basicResult));
        
        // Verify broadcast was sent successfully
        Assert.assertEquals(200, basicResult.getCode());
        
        // Print the raw response for debugging
        System.out.println("Raw response code: " + basicResult.getCode());
        System.out.println("Raw response message: " + basicResult.getMsg());
        System.out.println("Raw response object: " + basicResult.getResponse());
        
        // Print broadcast details if response is available
        if (basicResult.getResponse() != null) {
            SendBroadcastNotificationResponseV2 basicResponse = basicResult.getResponse();
            
            System.out.println("Basic broadcast sent successfully:");
            
            if (basicResponse.getBroadcastId() != null) {
                System.out.println("  Broadcast ID: " + basicResponse.getBroadcastId());
            } else {
                System.out.println("  Broadcast ID: null");
            }
            
            if (basicResponse.getFromAccountId() != null) {
                System.out.println("  From Account: " + basicResponse.getFromAccountId());
            } else {
                System.out.println("  From Account: null");
            }
            
            if (basicResponse.getContent() != null) {
                System.out.println("  Content: " + basicResponse.getContent());
            } else {
                System.out.println("  Content: null");
            }
            
            if (basicResponse.getCreateTime() != null) {
                System.out.println("  Create Time: " + basicResponse.getCreateTime());
            } else {
                System.out.println("  Create Time: null");
            }
            
            if (basicResponse.getExpireTime() != null) {
                System.out.println("  Expire Time: " + basicResponse.getExpireTime());
            } else {
                System.out.println("  Expire Time: null");
            }
        } else {
            System.out.println("No response data available");
        }
    }
    
    /**
     * Test sending a broadcast notification with all parameters
     */
    @Test
    public void testFullBroadcastNotification() throws YunxinSdkException {
        if (services == null) return;
        
        // Create a full-featured broadcast with all parameters
        String content = "This is a full broadcast message at " + System.currentTimeMillis();
        SendBroadcastNotificationRequestV2 fullRequest = new SendBroadcastNotificationRequestV2(content);
        
        // Set sender account
        fullRequest.setFromAccountId(sender1);
        
        // Enable offline storage with custom TTL
        fullRequest.setOfflineEnabled(true);
        fullRequest.setTtl(72);  // 3 days
        
        // Target all platforms
        fullRequest.setTargetOs(Arrays.asList("ios", "aos", "pc", "web", "mac"));
        
        // Send the broadcast notification
        Result<SendBroadcastNotificationResponseV2> fullResult = broadcastService.sendBroadcastNotification(fullRequest);
        
        System.out.println("Full Broadcast Notification: " + fullResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(fullResult));
        
        // Verify broadcast was sent successfully
        Assert.assertEquals(200, fullResult.getCode());
        
        // Print the raw response for debugging
        System.out.println("Raw response code: " + fullResult.getCode());
        System.out.println("Raw response message: " + fullResult.getMsg());
        System.out.println("Raw response object: " + fullResult.getResponse());
        
        // Print broadcast details if response is available
        if (fullResult.getResponse() != null) {
            SendBroadcastNotificationResponseV2 fullResponse = fullResult.getResponse();
            
            System.out.println("Full broadcast sent successfully:");
            
            if (fullResponse.getBroadcastId() != null) {
                System.out.println("  Broadcast ID: " + fullResponse.getBroadcastId());
            } else {
                System.out.println("  Broadcast ID: null");
            }
            
            if (fullResponse.getFromAccountId() != null) {
                System.out.println("  From Account: " + fullResponse.getFromAccountId());
            } else {
                System.out.println("  From Account: null");
            }
            
            if (fullResponse.getContent() != null) {
                System.out.println("  Content: " + fullResponse.getContent());
            } else {
                System.out.println("  Content: null");
            }
            
            if (fullResponse.getOfflineEnabled() != null) {
                System.out.println("  Offline Enabled: " + fullResponse.getOfflineEnabled());
            } else {
                System.out.println("  Offline Enabled: null");
            }
            
            if (fullResponse.getTargetOs() != null) {
                System.out.println("  Target OS: " + fullResponse.getTargetOs());
            } else {
                System.out.println("  Target OS: null");
            }
            
            if (fullResponse.getCreateTime() != null) {
                System.out.println("  Create Time: " + fullResponse.getCreateTime());
            } else {
                System.out.println("  Create Time: null");
            }
            
            if (fullResponse.getExpireTime() != null) {
                System.out.println("  Expire Time: " + fullResponse.getExpireTime());
            } else {
                System.out.println("  Expire Time: null");
            }
        } else {
            System.out.println("No response data available");
        }
    }
    
    /**
     * Test sending a broadcast notification with offline storage enabled
     */
    @Test
    public void testBroadcastWithOfflineStorage() throws YunxinSdkException {
        if (services == null) return;
        // Create a broadcast with offline storage
        String content = "This is an offline broadcast message at " + System.currentTimeMillis();
        SendBroadcastNotificationRequestV2 offlineRequest = new SendBroadcastNotificationRequestV2(content);
        
        // Set sender account
        offlineRequest.setFromAccountId(sender2);
        
        // Enable offline storage with custom TTL
        offlineRequest.setOfflineEnabled(true);
        offlineRequest.setTtl(24);  // 1 day
        
        // Send the broadcast notification
        Result<SendBroadcastNotificationResponseV2> offlineResult = broadcastService.sendBroadcastNotification(offlineRequest);
        
        System.out.println("Offline Broadcast Notification: " + offlineResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(offlineResult));
        
        // Verify broadcast was sent successfully
        Assert.assertEquals(200, offlineResult.getCode());
        
        // Verify response contains expected values
        Assert.assertNotNull("Response should not be null", offlineResult.getResponse());
        Assert.assertNotNull("Broadcast ID should not be null", offlineResult.getResponse().getBroadcastId());
        Assert.assertEquals("Sender account should match", sender2, offlineResult.getResponse().getFromAccountId());
        Assert.assertEquals("Content should match", content, offlineResult.getResponse().getContent());
        Assert.assertEquals("Offline enabled should be true", true, offlineResult.getResponse().getOfflineEnabled());
    }
    
    /**
     * Test sending a broadcast notification to specific platforms
     */
    @Test
    public void testPlatformSpecificBroadcast() throws YunxinSdkException {
        // Test multiple platform combinations
        testSpecificPlatform("Mobile Only", Arrays.asList("ios", "aos"));
        testSpecificPlatform("Desktop Only", Arrays.asList("pc", "mac"));
        testSpecificPlatform("Web Only", Arrays.asList("web"));
        testSpecificPlatform("iOS Only", Arrays.asList("ios"));
    }
    
    /**
     * Helper method to test broadcasting to specific platforms
     */
    private void testSpecificPlatform(String testName, List<String> platforms) throws YunxinSdkException {
        if (services == null) return;
        System.out.println("\n---- Testing " + testName + " Broadcast ----");
        
        // Create a platform-specific broadcast
        String content = testName + " broadcast message at " + System.currentTimeMillis();
        SendBroadcastNotificationRequestV2 platformRequest = new SendBroadcastNotificationRequestV2(content);
        
        // Set sender account
        platformRequest.setFromAccountId(sender3);
        
        // Set specific platform targets
        platformRequest.setTargetOs(platforms);
        
        // Send the broadcast notification
        Result<SendBroadcastNotificationResponseV2> platformResult = broadcastService.sendBroadcastNotification(platformRequest);
        
        // Verify broadcast was sent successfully
        Assert.assertEquals(200, platformResult.getCode());
        Assert.assertNotNull("Response should not be null", platformResult.getResponse());
        
        // Verify platform settings
        if (platformResult.getResponse().getTargetOs() != null) {
            for (String platform : platforms) {
                Assert.assertTrue("Target OS should contain " + platform, 
                        platformResult.getResponse().getTargetOs().contains(platform));
            }
        }
        
        System.out.println(testName + " broadcast sent successfully with ID: " + 
                platformResult.getResponse().getBroadcastId());
    }
    
    /**
     * Test querying a broadcast notification
     */
    @Test
    public void testQueryBroadcastNotification() throws YunxinSdkException {
        if (services == null) return;
        // Create a new broadcast notification first
        String content = "This is a broadcast message to be queried at " + System.currentTimeMillis();
        SendBroadcastNotificationRequestV2 createRequest = new SendBroadcastNotificationRequestV2(content);
        createRequest.setFromAccountId(sender1);
        createRequest.setOfflineEnabled(true);
        createRequest.setTargetOs(Arrays.asList("ios", "aos", "pc"));
        
        // Send the broadcast notification
        Result<SendBroadcastNotificationResponseV2> createResult = broadcastService.sendBroadcastNotification(createRequest);
        
        // Verify broadcast was created successfully
        Assert.assertEquals(200, createResult.getCode());
        Assert.assertNotNull("Create response should not be null", createResult.getResponse());
        
        // Get the broadcast ID to query
        String broadcastId = createResult.getResponse().getBroadcastId();
        System.out.println("Created broadcast ID for query test: " + broadcastId);
        
        if (broadcastId == null || broadcastId.isEmpty()) {
            Assert.fail("Failed to get a valid broadcast ID for query test");
            return;
        }
        
        // Create the query request
        QueryBroadcastNotificationRequestV2 queryRequest = new QueryBroadcastNotificationRequestV2(broadcastId);
        
        // Query the broadcast notification
        Result<QueryBroadcastNotificationResponseV2> queryResult = broadcastService.queryBroadcastNotification(queryRequest);
        
        // Verify query was successful
        Assert.assertEquals("Query operation should return 200 status code", 200, queryResult.getCode());
        Assert.assertNotNull("Query response should not be null", queryResult.getResponse());
        
        // Verify the queried data
        QueryBroadcastNotificationResponseV2 queryResponse = queryResult.getResponse();
        Assert.assertEquals("Broadcast ID should match", broadcastId, queryResponse.getBroadcastId());
        Assert.assertEquals("Content should match", content, queryResponse.getContent());
        Assert.assertEquals("From account ID should match", sender1, queryResponse.getFromAccountId());
        Assert.assertEquals("Offline enabled should match", true, queryResponse.getOfflineEnabled());
        Assert.assertNotNull("Create time should not be null", queryResponse.getCreateTime());
        Assert.assertNotNull("Expire time should not be null", queryResponse.getExpireTime());
    }
    
    /**
     * Test querying a broadcast notification list
     */
    @Test
    public void testQueryBroadcastNotificationList() throws YunxinSdkException {
        if (services == null) return;
        // Create multiple broadcast notifications first
        List<String> broadcastIds = new ArrayList<>();
        
        // Create 3 broadcast messages for list testing
        for (int i = 0; i < 3; i++) {
            String content = "List test broadcast message " + i + " at " + System.currentTimeMillis();
            SendBroadcastNotificationRequestV2 createRequest = new SendBroadcastNotificationRequestV2(content);
            createRequest.setFromAccountId(sender2);
            createRequest.setOfflineEnabled(true);
            
            // Send the broadcast notification
            Result<SendBroadcastNotificationResponseV2> createResult = 
                broadcastService.sendBroadcastNotification(createRequest);
            
            // Verify broadcast was created successfully
            Assert.assertEquals(200, createResult.getCode());
            Assert.assertNotNull("Create response should not be null", createResult.getResponse());
            
            // Add broadcast ID to the list
            String broadcastId = createResult.getResponse().getBroadcastId();
            if (broadcastId != null && !broadcastId.isEmpty()) {
                broadcastIds.add(broadcastId);
                System.out.println("Created broadcast ID for list test: " + broadcastId);
            }
        }
        
        // Verify we have created some broadcasts
        Assert.assertFalse("Failed to create broadcasts for list test", broadcastIds.isEmpty());
        
        // Create the list query request
        QueryBroadcastNotificationListRequestV2 listRequest = new QueryBroadcastNotificationListRequestV2();
        listRequest.setLimit(10); // Request up to 10 broadcasts
        
        // Query the broadcast notification list
        Result<QueryBroadcastNotificationListResponseV2> listResult = 
            broadcastService.queryBroadcastNotificationList(listRequest);
        
        // Print the result
        System.out.println("Query Broadcast List Result: " + JSON.toJSONString(listResult));
        System.out.println("Query List Response Code: " + listResult.getCode());
        System.out.println("Query List Response Message: " + listResult.getMsg());
        
        // Verify query was successful
        Assert.assertEquals("Query list operation should return 200 status code", 200, listResult.getCode());
        Assert.assertNotNull("Query list response should not be null", listResult.getResponse());
        
        // Verify the queried data
        QueryBroadcastNotificationListResponseV2 listResponse = listResult.getResponse();
        Assert.assertNotNull("Broadcasts list should not be null", listResponse.getItems());
        
        // Print broadcast list details
        System.out.println("Queried broadcast list details:");
        System.out.println("  Total broadcasts: " + listResponse.getItems().size());
        
        if (listResponse.getItems().size() > 0) {
            System.out.println("  First broadcast ID: " + listResponse.getItems().get(0).getBroadcastId());
            System.out.println("  First broadcast content: " + listResponse.getItems().get(0).getContent());
        }
        
        if (listResponse.getNextToken() != null) {
            System.out.println("  Next page token: " + listResponse.getNextToken());
        } else {
            System.out.println("  Next page token: null (no more pages)");
        }
        
        // Test pagination if next page token is available
        if (listResponse.getNextToken() != null && !listResponse.getNextToken().isEmpty()) {
            System.out.println("\n---- Testing Pagination ----");
            
            // Create a new request with the next page token
            QueryBroadcastNotificationListRequestV2 nextPageRequest = new QueryBroadcastNotificationListRequestV2();
            nextPageRequest.setPageToken(listResponse.getNextToken());
            nextPageRequest.setLimit(10);
            
            // Query the next page
            Result<QueryBroadcastNotificationListResponseV2> nextPageResult = 
                broadcastService.queryBroadcastNotificationList(nextPageRequest);
            
            // Verify next page query was successful
            Assert.assertEquals("Next page query should return 200 status code", 200, nextPageResult.getCode());
            
            // Print next page details
            System.out.println("Next page broadcasts: " + 
                (nextPageResult.getResponse() != null ? 
                 nextPageResult.getResponse().getItems().size() : "null"));
        }
    }
    
    /**
     * Test deleting a broadcast notification
     */
    @Test
    public void testDeleteBroadcastNotification() throws YunxinSdkException {
        if (services == null) return;
        // Create a new broadcast notification first
        String content = "This is a broadcast message to be deleted at " + System.currentTimeMillis();
        SendBroadcastNotificationRequestV2 createRequest = new SendBroadcastNotificationRequestV2(content);
        createRequest.setFromAccountId(sender1);
        
        // Send the broadcast notification
        Result<SendBroadcastNotificationResponseV2> createResult = broadcastService.sendBroadcastNotification(createRequest);
        
        // Verify broadcast was created successfully
        Assert.assertEquals(200, createResult.getCode());
        Assert.assertNotNull("Create response should not be null", createResult.getResponse());
        
        // Get the broadcast ID to delete
        String broadcastId = createResult.getResponse().getBroadcastId();
        System.out.println("Created broadcast ID for deletion test: " + broadcastId);
        
        if (broadcastId == null || broadcastId.isEmpty()) {
            Assert.fail("Failed to get a valid broadcast ID for deletion test");
            return;
        }
        
        // Create the delete request
        DeleteBroadcastNotificationRequestV2 deleteRequest = new DeleteBroadcastNotificationRequestV2(broadcastId);
        
        // Delete the broadcast notification
        Result<DeleteBroadcastNotificationResponseV2> deleteResult = broadcastService.deleteBroadcastNotification(deleteRequest);
        
        // Print the result
        System.out.println("Delete Broadcast Result: " + JSON.toJSONString(deleteResult));
        System.out.println("Delete Response Code: " + deleteResult.getCode());
        System.out.println("Delete Response Message: " + deleteResult.getMsg());
        
        // Verify delete was successful
        Assert.assertEquals("Delete operation should return 200 status code", 200, deleteResult.getCode());
    }
    
    /**
     * Test sending a chatroom broadcast notification
     */
    @Test
    public void testSendChatroomBroadcastNotification() throws YunxinSdkException {
        if (services == null) return;

        // Create a unique client broadcast ID
        String clientBroadcastId = "chatroom_bcast_" + System.currentTimeMillis();
        
        // Create a chatroom broadcast message
        SendChatroomBroadcastNotificationRequestV2 chatroomRequest = new SendChatroomBroadcastNotificationRequestV2();
        chatroomRequest.setClientBroadcastId(clientBroadcastId);
        chatroomRequest.setSenderId(sender1);
        
        // Create a message object
        SendChatroomBroadcastNotificationRequestV2.Message message = 
            new SendChatroomBroadcastNotificationRequestV2.Message(100); // Custom message type
        message.setText("This is a chatroom broadcast at " + System.currentTimeMillis());
        
        // Set message to the request
        chatroomRequest.setMessage(message);
        
        // Send the chatroom broadcast notification
        Result<SendChatroomBroadcastNotificationResponseV2> chatroomResult = 
            broadcastService.sendChatroomBroadcastNotification(chatroomRequest);
        
        // Print the result
        System.out.println("Chatroom Broadcast Result: " + JSON.toJSONString(chatroomResult));
        System.out.println("Chatroom Response Code: " + chatroomResult.getCode());
        System.out.println("Chatroom Response Message: " + chatroomResult.getMsg());
        
        // Verify send was successful
        Assert.assertEquals("Chatroom broadcast should return 200 status code", 200, chatroomResult.getCode());
        Assert.assertNotNull("Chatroom response should not be null", chatroomResult.getResponse());
        
        // Verify the response data
        SendChatroomBroadcastNotificationResponseV2 chatroomResponse = chatroomResult.getResponse();
        
        // Print chatroom broadcast details
        System.out.println("Chatroom broadcast details:");
        System.out.println("  Client Broadcast ID: " + chatroomResponse.getClientBroadcastId());
        System.out.println("  Sender ID: " + chatroomResponse.getSenderId());
        System.out.println("  Message Type: " + chatroomResponse.getMessageType());
        System.out.println("  Text: " + chatroomResponse.getText());
        System.out.println("  Create Time: " + chatroomResponse.getCreateTime());
    }
} 