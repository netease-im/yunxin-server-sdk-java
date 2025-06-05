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
import com.netease.nim.server.sdk.im.v2.chatroom.IChatroomV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom.request.CreateChatroomRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.CreateChatroomResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.IChatroomQueueV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.DeleteChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.InitializeChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.QueryChatroomQueueElementsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.request.UpdateChatroomQueueRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.DeleteChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.InitializeChatroomQueueResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.QueryChatroomQueueElementsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_queue.response.UpdateChatroomQueueResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for ChatroomQueueV2Service
 */
public class TestChatroomQueueV2 {

    private static YunxinV2ApiServices services;
    private static Long roomId;
    private static String roomCreator;
    
    // Test account IDs
    private static final String creatorId = "creator_" + System.currentTimeMillis();
    private static final String userId1 = "user1_" + System.currentTimeMillis();
    private static final String userId2 = "user2_" + System.currentTimeMillis();
    
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
        setupTestEnvironment();
    }
    
    /**
     * Setup test environment by creating account and chatroom
     */
    private static void setupTestEnvironment() throws YunxinSdkException {
        // Create test accounts
        System.out.println("\n==== Creating Test Accounts ====");
        createAccount(creatorId, "Chatroom Queue Creator");
        createAccount(userId1, "Chatroom Queue User 1");
        createAccount(userId2, "Chatroom Queue User 2");
        
        // Create a chatroom with the creator
        roomId = createChatroom();
        
        // Initialize the queue
        System.out.println("\n==== Initializing Chatroom Queue ====");
        initializeChatroomQueue(roomId, 500);
        
        // Add initial queue elements
        System.out.println("\n==== Adding Initial Queue Elements ====");
        addQueueElements();
    }
    
    /**
     * Initialize chatroom queue
     */
    private static void initializeChatroomQueue(Long roomId, int sizeLimit) throws YunxinSdkException {
        // Create request with custom queue size limit
        InitializeChatroomQueueRequestV2 request = new InitializeChatroomQueueRequestV2(roomId, sizeLimit);
        
        // Configure route settings for message forwarding
        InitializeChatroomQueueRequestV2.RouteConfig routeConfig = 
            new InitializeChatroomQueueRequestV2.RouteConfig(true, "test-environment");
        request.setRouteConfig(routeConfig);
        
        // Initialize the queue
        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
        Result<InitializeChatroomQueueResponseV2> result = queueService.initializeChatroomQueue(request);
        
        System.out.println("Initialize Chatroom Queue: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        System.out.println("Chatroom queue initialized successfully for room ID: " + roomId);
    }
    
    /**
     * Add initial queue elements to ensure they exist for tests
     */
    private static void addQueueElements() throws YunxinSdkException {
        // Create request with operator account ID
        UpdateChatroomQueueRequestV2 request = new UpdateChatroomQueueRequestV2(roomId, creatorId);
        
        // Create queue elements
        List<UpdateChatroomQueueRequestV2.QueueElement> elements = new ArrayList<>();
        
        // Add first element
        UpdateChatroomQueueRequestV2.QueueElement element1 = new UpdateChatroomQueueRequestV2.QueueElement("key1", "value1");
        element1.setElementAccountId(userId1);
        element1.setElementTransient(false);
        element1.setElementAddPolicy(2); // Add or update
        elements.add(element1);
        
        // Add second element
        UpdateChatroomQueueRequestV2.QueueElement element2 = new UpdateChatroomQueueRequestV2.QueueElement("key2", "value2");
        element2.setElementAccountId(userId2);
        element2.setElementTransient(true);
        element2.setElementAddPolicy(0); // Only add if key doesn't exist
        elements.add(element2);
        
        request.setElementList(elements);
        
        // Update the queue
        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
        Result<UpdateChatroomQueueResponseV2> result = queueService.updateChatroomQueue(request);
        
        System.out.println("Add Initial Queue Elements: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        System.out.println("Initial queue elements added successfully");
    }
    
    /**
     * Helper method to ensure queue elements exist before operations
     */
    private static void ensureQueueElements() throws YunxinSdkException {
        if (services == null || roomId == null) return;
        
        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
        
        // Step 1: Query to check if elements exist
        QueryChatroomQueueElementsRequestV2 queryRequest = new QueryChatroomQueueElementsRequestV2(roomId);
        Result<QueryChatroomQueueElementsResponseV2> queryResult = queueService.queryChatroomQueueElements(queryRequest);
        
        // If queue doesn't exist (error code 117404), initialize it first
        if (queryResult.getCode() == 117404 || queryResult.getMsg().contains("queue does not exist")) {
            System.out.println("Queue doesn't exist, initializing queue first...");
            initializeChatroomQueue(roomId, 500);
            
            // Always add elements after initializing the queue
            addQueueElements();
            return;
        }
        
        // Step 2: If queue exists but no elements or empty response, add elements
        boolean needsElements = true;
        if (queryResult.getCode() == 200 && queryResult.getResponse() != null) {
            if (queryResult.getResponse().getElementList() != null && 
                !queryResult.getResponse().getElementList().isEmpty()) {
                needsElements = false;
            }
        }
        
        if (needsElements) {
            System.out.println("Queue exists but elements not found, adding them now...");
            addQueueElements();
        }
    }
    
    /**
     * Test initializing a chatroom queue
     */
    @Test
    public void testInitializeChatroomQueue() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request with custom queue size limit
        InitializeChatroomQueueRequestV2 request = new InitializeChatroomQueueRequestV2(roomId, 500);
        
        // Configure route settings for message forwarding
        InitializeChatroomQueueRequestV2.RouteConfig routeConfig = 
            new InitializeChatroomQueueRequestV2.RouteConfig(true, "test-environment");
        request.setRouteConfig(routeConfig);
        
        // Initialize the queue
        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
        Result<InitializeChatroomQueueResponseV2> result = queueService.initializeChatroomQueue(request);
        
        System.out.println("Initialize Chatroom Queue: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        System.out.println("Chatroom queue initialized successfully for room ID: " + roomId);
    }
    
    /**
     * Test updating a chatroom queue by adding elements
     */
    @Test
    public void testUpdateChatroomQueue() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request with operator account ID
        UpdateChatroomQueueRequestV2 request = new UpdateChatroomQueueRequestV2(roomId, creatorId);
        
        // Create queue elements
        List<UpdateChatroomQueueRequestV2.QueueElement> elements = new ArrayList<>();
        
        // Add first element
        UpdateChatroomQueueRequestV2.QueueElement element1 = new UpdateChatroomQueueRequestV2.QueueElement("key1", "value1");
        element1.setElementAccountId(userId1);
        element1.setElementTransient(false);
        element1.setElementAddPolicy(2); // Add or update
        elements.add(element1);
        
        // Add second element
        UpdateChatroomQueueRequestV2.QueueElement element2 = new UpdateChatroomQueueRequestV2.QueueElement("key2", "value2");
        element2.setElementAccountId(userId2);
        element2.setElementTransient(true);
        element2.setElementAddPolicy(0); // Only add if key doesn't exist
        elements.add(element2);
        
        request.setElementList(elements);
        
        // Add notification config
        UpdateChatroomQueueRequestV2.NotificationConfig notificationConfig = new UpdateChatroomQueueRequestV2.NotificationConfig();
        notificationConfig.setNotificationEnabled(true);
        notificationConfig.setNotificationExtension("test_extension");
        request.setNotificationConfig(notificationConfig);
        
        // Update the queue
        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
        Result<UpdateChatroomQueueResponseV2> result = queueService.updateChatroomQueue(request);
        
        System.out.println("Update Chatroom Queue: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        UpdateChatroomQueueResponseV2 response = result.getResponse();
        Assert.assertEquals(roomId, response.getRoomId());
        Assert.assertNotNull(response.getQueueSize());
        

    }
    
    /**
     * Test querying chatroom queue elements
     */
    @Test
    public void testQueryChatroomQueueElements() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure queue elements exist before querying
        ensureQueueElements();
        
        // Create request with specific element keys to query
        QueryChatroomQueueElementsRequestV2 request = new QueryChatroomQueueElementsRequestV2(roomId);
        request.setElementKeyList(Arrays.asList("key1", "key2"));
        
        // Query the queue elements
        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
        Result<QueryChatroomQueueElementsResponseV2> result = queueService.queryChatroomQueueElements(request);
        
        System.out.println("Query Chatroom Queue Elements: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        QueryChatroomQueueElementsResponseV2 response = result.getResponse();
        Assert.assertNotNull(response.getQueueSize());
        Assert.assertNotNull(response.getElementList());

        System.out.println("Chatroom queue elements queried successfully");
    }
    
//    /**
//     * Test polling an element from the chatroom queue
//     */
//    @Test 需要在线才能插入元素无法测试
//    public void testPollChatroomQueueElement() throws YunxinSdkException {
//        if (services == null) return;
//
//        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
//
//        // First, make sure we have a queue
//        ensureQueueElements();
//
//        // Instead of trying to poll a specific element, let's poll any element
//        System.out.println("\n==== Testing Polling Any Queue Element ====");
//
//        // Ensure we have at least one element to poll
//        UpdateChatroomQueueRequestV2 addRequest = new UpdateChatroomQueueRequestV2(roomId, creatorId);
//        List<UpdateChatroomQueueRequestV2.QueueElement> elements = new ArrayList<>();
//        UpdateChatroomQueueRequestV2.QueueElement element = new UpdateChatroomQueueRequestV2.QueueElement("key3", "value3");
//        element.setElementAccountId(userId1);
//        elements.add(element);
//        addRequest.setElementList(elements);
//
//        Result<UpdateChatroomQueueResponseV2> updateResult = queueService.updateChatroomQueue(addRequest);
//        Assert.assertEquals(200, updateResult.getCode());
//        System.out.println("Added element key3 to queue");
//
//        // Create request to poll the first element (without specifying which one)
//        PollChatroomQueueElementRequestV2 request = new PollChatroomQueueElementRequestV2(roomId);
//
//        // Add notification config
//        PollChatroomQueueElementRequestV2.NotificationConfig notificationConfig = new PollChatroomQueueElementRequestV2.NotificationConfig();
//        notificationConfig.setNotificationEnabled(true);
//        request.setNotificationConfig(notificationConfig);
//
//        // Poll any element
//        Result<PollChatroomQueueElementResponseV2> result = queueService.pollChatroomQueueElement(request);
//
//        System.out.println("Poll Any Chatroom Queue Element: " + result.getMsg());
//        System.out.println("Response: " + JSON.toJSONString(result));
//
//        // Verify the result
//        Assert.assertEquals(200, result.getCode());
//        Assert.assertNotNull(result.getResponse());
//
//        PollChatroomQueueElementResponseV2 response = result.getResponse();
//        System.out.println("Successfully polled element: " + response.getElementKey() + " = " + response.getElementValue());
//
//        // Add more elements for a second poll
//        System.out.println("\n==== Adding More Elements And Testing Second Poll ====");
//        addRequest = new UpdateChatroomQueueRequestV2(roomId, creatorId);
//        elements = new ArrayList<>();
//
//        // Add multiple elements
//        element = new UpdateChatroomQueueRequestV2.QueueElement("key4", "value4");
//        element.setElementAccountId(userId1);
//        elements.add(element);
//
//        UpdateChatroomQueueRequestV2.QueueElement element2 = new UpdateChatroomQueueRequestV2.QueueElement("key5", "value5");
//        element2.setElementAccountId(userId2);
//        elements.add(element2);
//
//        addRequest.setElementList(elements);
//        updateResult = queueService.updateChatroomQueue(addRequest);
//        Assert.assertEquals(200, updateResult.getCode());
//        System.out.println("Added elements key4 and key5 to queue");
//
//        // Poll again using the same request
//        result = queueService.pollChatroomQueueElement(request);
//
//        System.out.println("Poll Second Chatroom Queue Element: " + result.getMsg());
//        System.out.println("Response: " + JSON.toJSONString(result));
//
//        // Verify the second poll
//        Assert.assertEquals(200, result.getCode());
//        Assert.assertNotNull(result.getResponse());
//
//        response = result.getResponse();
//        System.out.println("Successfully polled element: " + response.getElementKey() + " = " + response.getElementValue());
//    }
    
    /**
     * Test deleting a chatroom queue
     */
    @Test
    public void testDeleteChatroomQueue() throws YunxinSdkException {
        if (services == null) return;
        
        // Make sure the queue exists before trying to delete it
        ensureQueueElements();
        
        // Create request to delete the queue
        DeleteChatroomQueueRequestV2 request = new DeleteChatroomQueueRequestV2(roomId);
        
        // Add notification config
        DeleteChatroomQueueRequestV2.NotificationConfig notificationConfig = new DeleteChatroomQueueRequestV2.NotificationConfig();
        notificationConfig.setNotificationEnabled(true);
        request.setNotificationConfig(notificationConfig);
        
        // Delete the queue
        IChatroomQueueV2Service queueService = services.getChatroomQueueService();
        Result<DeleteChatroomQueueResponseV2> result = queueService.deleteChatroomQueue(request);
        
        System.out.println("Delete Chatroom Queue: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        DeleteChatroomQueueResponseV2 response = result.getResponse();
        Assert.assertEquals(roomId, response.getRoomId());
        Assert.assertNotNull(response.getQueueSize());
        
        System.out.println("Chatroom queue deleted successfully");
    }
    
    /**
     * Create a chatroom for testing
     * 
     * @return The ID of the created chatroom
     */
    private static Long createChatroom() throws YunxinSdkException {
        System.out.println("\n==== Creating Test Chatroom ====");
        
        // Create a chatroom with the creator
        String roomName = "Test Chatroom Queue " + System.currentTimeMillis();
        CreateChatroomRequestV2 request = new CreateChatroomRequestV2(creatorId, roomName);
        
        // Configure the chatroom
        request.setAnnouncement("Welcome to the test chatroom for queue operations!");
        request.setQueueLevel(1);
        request.setInOutNotification(true);
        
        // Create the chatroom
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<CreateChatroomResponseV2> result = chatroomService.createChatroom(request);
        
        System.out.println("Chatroom Creation: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify chatroom was created successfully
        Assert.assertEquals(200, result.getCode());
        CreateChatroomResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(creatorId, response.getCreator());
        Assert.assertEquals(roomName, response.getRoomName());
        Assert.assertNotNull(response.getRoomId());
        
        Long roomId = response.getRoomId();
        roomCreator = response.getCreator(); // Store the actual room creator
        
        System.out.println("Created chatroom:");
        System.out.println("  Room ID: " + roomId);
        System.out.println("  Creator: " + response.getCreator());
        System.out.println("  Room Name: " + response.getRoomName());
        
        return roomId;
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
        
        IAccountV2Service accountService = services.getAccountService();
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
} 