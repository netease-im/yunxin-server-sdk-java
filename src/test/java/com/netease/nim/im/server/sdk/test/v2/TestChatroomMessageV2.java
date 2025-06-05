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
import com.netease.nim.server.sdk.im.v2.chatroom_message.IChatroomMessageV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.BatchSendChatroomMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.RecallChatroomMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.SendChatroomMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.request.QueryChatroomHistoryMessagesRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.BatchSendChatroomMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.QueryChatroomHistoryMessagesResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.RecallChatroomMessageResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom_message.response.SendChatroomMessageResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Test class for ChatroomMessageV2Service
 */
public class TestChatroomMessageV2 {

    private static YunxinV2ApiServices services;
    private static Long roomId;
    private static String roomCreator;
    
    // Test account IDs
    private static final String senderId = "sender_" + System.currentTimeMillis();
    private static final String receiverId = "receiver_" + System.currentTimeMillis();
    
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
     * Setup test environment by creating accounts and chatroom
     */
    public static void setupTestEnvironment() throws YunxinSdkException {
        // Create test accounts
        System.out.println("\n==== Creating Test Accounts ====");
        createAccount(senderId, "Message Sender");
        createAccount(receiverId, "Message Receiver");
        
        // Create a chatroom with the sender as creator
        roomId = createChatroom();
    }
    
    /**
     * Test sending a text message to a chatroom
     */
    @Test
    public void testSendTextMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create message body
        SendChatroomMessageRequestV2.MessageBody messageBody = new SendChatroomMessageRequestV2.MessageBody(
            UUID.randomUUID().toString(), // Client message ID
            0 // Text message type
        );
        messageBody.setText("This is a test message from the Java SDK");
        
        // Create message request
        SendChatroomMessageRequestV2 request = new SendChatroomMessageRequestV2(senderId, messageBody);
        request.setRoomId(roomId);
        
        // Configure message options
        SendChatroomMessageRequestV2.MessageConfig messageConfig = new SendChatroomMessageRequestV2.MessageConfig();
        messageConfig.setHighPriority(true);
        messageConfig.setHistoryEnabled(true);
        request.setMessageConfig(messageConfig);
        
        // Send the message
        IChatroomMessageV2Service messageService = services.getChatroomMessageService();
        Result<SendChatroomMessageResponseV2> result = messageService.sendChatroomMessage(request);
        
        System.out.println("Send Text Message: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Verify response contains data
        SendChatroomMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getMessage());
        Assert.assertEquals(Integer.valueOf(0), response.getMessage().getMessageType());
        Assert.assertEquals(senderId, response.getMessage().getSenderId());
        
        System.out.println("Text message sent successfully with client ID: " + 
            response.getMessage().getMessageClientId());
    }
    
    /**
     * Test sending a directed message to specific recipients
     */
    @Test
    public void testSendDirectedMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create message body
        SendChatroomMessageRequestV2.MessageBody messageBody = new SendChatroomMessageRequestV2.MessageBody(
            UUID.randomUUID().toString(), // Client message ID
            0 // Text message type
        );
        messageBody.setText("This is a directed message to a specific recipient");
        
        // Create message request with specific receivers
        SendChatroomMessageRequestV2 request = new SendChatroomMessageRequestV2(senderId, messageBody);
        request.setRoomId(roomId);
        request.setReceiverIds(Arrays.asList(receiverId));
        
        // Send the message
        IChatroomMessageV2Service messageService = services.getChatroomMessageService();
        Result<SendChatroomMessageResponseV2> result = messageService.sendChatroomMessage(request);
        
        System.out.println("Send Directed Message: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Verify response contains data
        SendChatroomMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getMessage());
        
        System.out.println("Directed message sent successfully to recipient: " + receiverId);
    }
    
    /**
     * Test sending a custom message
     */
    @Test
    public void testSendCustomMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create custom attachment
        Map<String, Object> attachment = new HashMap<>();
        attachment.put("customType", "notification");
        attachment.put("title", "Test Notification");
        attachment.put("content", "This is a test custom message from the Java SDK");
        attachment.put("timestamp", System.currentTimeMillis());
        
        // Create message body
        SendChatroomMessageRequestV2.MessageBody messageBody = new SendChatroomMessageRequestV2.MessageBody(
            UUID.randomUUID().toString(), // Client message ID
            100 // Custom message type
        );
        messageBody.setSubType(1); // Custom subtype
        messageBody.setText("Custom message description for search");
        messageBody.setAttachment(attachment);
        
        // Create message request
        SendChatroomMessageRequestV2 request = new SendChatroomMessageRequestV2(senderId, messageBody);
        request.setRoomId(roomId);
        
        // Send the message
        IChatroomMessageV2Service messageService = services.getChatroomMessageService();
        Result<SendChatroomMessageResponseV2> result = messageService.sendChatroomMessage(request);
        
        System.out.println("Send Custom Message: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Verify response contains data
        SendChatroomMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getMessage());
        Assert.assertEquals(Integer.valueOf(100), response.getMessage().getMessageType());
        
        System.out.println("Custom message sent successfully with client ID: " + 
            response.getMessage().getMessageClientId());
    }
    
    /**
     * Test batch sending multiple messages to a chatroom
     */
    @Test
    public void testBatchSendMessages() throws YunxinSdkException {
        if (services == null) return;
        
        // Create a list of messages to send
        List<BatchSendChatroomMessagesRequestV2.MessageBody> messages = new ArrayList<>();
        
        // Text message
        BatchSendChatroomMessagesRequestV2.MessageBody textMessage = new BatchSendChatroomMessagesRequestV2.MessageBody(
            UUID.randomUUID().toString(), // Client message ID
            0 // Text message type
        );
        textMessage.setText("This is a batch text message from the Java SDK");
        messages.add(textMessage);
        
        // Tip message
        BatchSendChatroomMessagesRequestV2.MessageBody tipMessage = new BatchSendChatroomMessagesRequestV2.MessageBody(
            UUID.randomUUID().toString(), // Client message ID
            10 // Tip message type
        );
        tipMessage.setText("This is a system notification tip message");
        messages.add(tipMessage);
        
        // Custom message
        Map<String, Object> attachment = new HashMap<>();
        attachment.put("customType", "batchNotification");
        attachment.put("title", "Batch Notification");
        attachment.put("content", "This is a batch custom message");
        attachment.put("timestamp", System.currentTimeMillis());
        
        BatchSendChatroomMessagesRequestV2.MessageBody customMessage = new BatchSendChatroomMessagesRequestV2.MessageBody(
            UUID.randomUUID().toString(), // Client message ID
            100 // Custom message type
        );
        customMessage.setSubType(2); // Custom subtype
        customMessage.setText("Batch custom message description");
        customMessage.setAttachment(attachment);
        messages.add(customMessage);
        
        // Create batch message request
        BatchSendChatroomMessagesRequestV2 request = new BatchSendChatroomMessagesRequestV2(
            roomId,      // Room ID
            senderId,    // Sender ID
            messages     // List of messages
        );
        
        // Configure message options
        BatchSendChatroomMessagesRequestV2.MessageConfig messageConfig = new BatchSendChatroomMessagesRequestV2.MessageConfig();
        messageConfig.setHighPriority(true);
        messageConfig.setHistoryEnabled(true);
        request.setMessageConfig(messageConfig);
        
        // Send the batch of messages
        IChatroomMessageV2Service messageService = services.getChatroomMessageService();
        Result<BatchSendChatroomMessagesResponseV2> result = messageService.batchSendChatroomMessages(request);
        
        System.out.println("Batch Send Messages: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        
        // Verify response contains data
        BatchSendChatroomMessagesResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        
        // Verify successful messages
        Assert.assertNotNull(response.getSuccessList());
        Assert.assertFalse(response.getSuccessList().isEmpty());
        
        // Print successful messages
        System.out.println("Successfully sent " + response.getSuccessList().size() + " messages:");
        for (BatchSendChatroomMessagesResponseV2.SuccessMessage successMessage : response.getSuccessList()) {
            System.out.println("  - Message client ID: " + successMessage.getMessageClientId() + 
                ", Type: " + successMessage.getMessageType());
        }
        
        // Check for any failed messages
        if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
            System.out.println("Failed to send " + response.getFailedList().size() + " messages:");
            for (BatchSendChatroomMessagesResponseV2.FailedMessage failedMessage : response.getFailedList()) {
                System.out.println("  - Message client ID: " + failedMessage.getMessageClientId() + 
                    ", Reason: " + failedMessage.getReason());
            }
        }
    }
    
    /**
     * Test recalling and deleting chatroom messages
     */
    @Test
    public void testRecallAndDeleteMessages() throws YunxinSdkException {
        if (services == null) return;
        
        // 1. First, send a message to recall
        String recallMessageClientId = UUID.randomUUID().toString();
        SendChatroomMessageRequestV2.MessageBody recallMessageBody = new SendChatroomMessageRequestV2.MessageBody(
            recallMessageClientId,
            0 // Text message type
        );
        recallMessageBody.setText("This message will be recalled");
        
        SendChatroomMessageRequestV2 recallRequest = new SendChatroomMessageRequestV2(senderId, recallMessageBody);
        recallRequest.setRoomId(roomId);
        
        IChatroomMessageV2Service messageService = services.getChatroomMessageService();
        Result<SendChatroomMessageResponseV2> recallResult = messageService.sendChatroomMessage(recallRequest);
        
        // Verify message was sent successfully
        Assert.assertEquals(200, recallResult.getCode());
        SendChatroomMessageResponseV2 recallResponse = recallResult.getResponse();
        Assert.assertNotNull(recallResponse);
        Assert.assertNotNull(recallResponse.getMessage());
        
        Long recallMessageCreateTime = recallResponse.getMessage().getCreateTime();
        System.out.println("Message to recall sent with client ID: " + recallMessageClientId);
        
        // 2. Send a message to delete
        String deleteMessageClientId = UUID.randomUUID().toString();
        SendChatroomMessageRequestV2.MessageBody deleteMessageBody = new SendChatroomMessageRequestV2.MessageBody(
            deleteMessageClientId,
            0 // Text message type
        );
        deleteMessageBody.setText("This message will be deleted");
        
        SendChatroomMessageRequestV2 deleteRequest = new SendChatroomMessageRequestV2(senderId, deleteMessageBody);
        deleteRequest.setRoomId(roomId);
        
        Result<SendChatroomMessageResponseV2> deleteResult = messageService.sendChatroomMessage(deleteRequest);
        
        // Verify message was sent successfully
        Assert.assertEquals(200, deleteResult.getCode());
        SendChatroomMessageResponseV2 deleteResponse = deleteResult.getResponse();
        Assert.assertNotNull(deleteResponse);
        Assert.assertNotNull(deleteResponse.getMessage());
        
        Long deleteMessageCreateTime = deleteResponse.getMessage().getCreateTime();
        System.out.println("Message to delete sent with client ID: " + deleteMessageClientId);
        
        // 3. Test recall message (with notification)
        Map<String, String> extensionMap = new HashMap<>();
        extensionMap.put("operatorNick", "Admin");
        extensionMap.put("reason", "Test recall functionality");
        String notificationExtension = JSON.toJSONString(extensionMap);
        
        // Create recall request
        RecallChatroomMessageRequestV2 recallMessageRequest = new RecallChatroomMessageRequestV2();
        recallMessageRequest.setRoomId(roomId);
        recallMessageRequest.setMessageClientId(recallMessageClientId);
        recallMessageRequest.setOperatorId(senderId);
        recallMessageRequest.setSenderId(senderId);
        recallMessageRequest.setCreateTime(recallMessageCreateTime);
        recallMessageRequest.setNotificationEnabled(true);
        recallMessageRequest.setNotificationExtension(notificationExtension);
        
        Result<RecallChatroomMessageResponseV2> recallMessageResult = messageService.recallChatroomMessage(recallMessageRequest);
        
        // Verify recall operation was successful
        Assert.assertEquals(200, recallMessageResult.getCode());
        System.out.println("Message recalled successfully: " + recallMessageClientId);
        
        // 4. Test delete message (without notification)
        RecallChatroomMessageRequestV2 deleteMessageRequest = new RecallChatroomMessageRequestV2();
        deleteMessageRequest.setRoomId(roomId);
        deleteMessageRequest.setMessageClientId(deleteMessageClientId);
        deleteMessageRequest.setOperatorId(senderId);
        deleteMessageRequest.setSenderId(senderId);
        deleteMessageRequest.setCreateTime(deleteMessageCreateTime);
        deleteMessageRequest.setNotificationEnabled(false);
        
        Result<RecallChatroomMessageResponseV2> deleteMessageResult = messageService.recallChatroomMessage(deleteMessageRequest);
        
        // Verify delete operation was successful
        Assert.assertEquals(200, deleteMessageResult.getCode());
        System.out.println("Message deleted successfully: " + deleteMessageClientId);
    }
    
    /**
     * Test querying chatroom history messages
     */
    @Test
    public void testQueryChatroomHistoryMessages() throws YunxinSdkException {
        if (services == null) return;
        
        // First, send multiple messages to create some history
        for (int i = 0; i < 5; i++) {
            SendChatroomMessageRequestV2.MessageBody messageBody = new SendChatroomMessageRequestV2.MessageBody(
                UUID.randomUUID().toString(),
                0 // Text message type
            );
            messageBody.setText("History message " + (i + 1) + " for testing pagination");
            
            SendChatroomMessageRequestV2 request = new SendChatroomMessageRequestV2(senderId, messageBody);
            request.setRoomId(roomId);
            
            // Enable history storage
            SendChatroomMessageRequestV2.MessageConfig messageConfig = new SendChatroomMessageRequestV2.MessageConfig();
            messageConfig.setHistoryEnabled(true);
            request.setMessageConfig(messageConfig);
            
            // Set extension for identification
            request.setExtension("history-test-" + i);
            
            IChatroomMessageV2Service messageService = services.getChatroomMessageService();
            Result<SendChatroomMessageResponseV2> result = messageService.sendChatroomMessage(request);
            
            // Verify message was sent successfully
            Assert.assertEquals(200, result.getCode());
            System.out.println("History message " + (i + 1) + " sent successfully");
            
            // Add a small delay to ensure messages have different timestamps
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Ignore
            }
        }
        
        // Now query the history messages
        IChatroomMessageV2Service messageService = services.getChatroomMessageService();
        
        // 1. Test querying with default parameters (ascending order, no message type filter)
        QueryChatroomHistoryMessagesRequestV2 firstPageRequest = new QueryChatroomHistoryMessagesRequestV2(
            roomId,
            senderId,
            3       // Limit to 3 messages per page
        );
        firstPageRequest.setDescending(false);  // Ascending order by time
        
        Result<QueryChatroomHistoryMessagesResponseV2> firstPageResult = 
            messageService.queryChatroomHistoryMessages(firstPageRequest);
        
        // Verify query was successful
        Assert.assertEquals(200, firstPageResult.getCode());
        
        // Verify response contains data
        QueryChatroomHistoryMessagesResponseV2 firstPageResponse = firstPageResult.getResponse();
        Assert.assertNotNull(firstPageResponse);
        Assert.assertNotNull(firstPageResponse.getItems());
        
        // Print the results
        System.out.println("First page query results (" + firstPageResponse.getItems().size() + " messages):");
        for (QueryChatroomHistoryMessagesResponseV2.MessageItem item : firstPageResponse.getItems()) {
            System.out.println("  - Message client ID: " + item.getMessageClientId() + 
                ", Text: " + item.getText() + 
                ", Create time: " + item.getCreateTime());
        }
        
        // Check if there are more pages
        Assert.assertNotNull(firstPageResponse.getHasMore());
        if (Boolean.TRUE.equals(firstPageResponse.getHasMore())) {
            System.out.println("There are more messages available. Next page token: " + 
                firstPageResponse.getNextToken());
            
            // 2. Test querying the next page
            QueryChatroomHistoryMessagesRequestV2 secondPageRequest = new QueryChatroomHistoryMessagesRequestV2(
                roomId,
                senderId,
                3       // Limit to 3 messages per page
            );
            secondPageRequest.setDescending(false);  // Ascending order by time
            secondPageRequest.setPageToken(firstPageResponse.getNextToken());
            
            Result<QueryChatroomHistoryMessagesResponseV2> secondPageResult = 
                messageService.queryChatroomHistoryMessages(secondPageRequest);
            
            // Verify query was successful
            Assert.assertEquals(200, secondPageResult.getCode());
            
            // Verify response contains data
            QueryChatroomHistoryMessagesResponseV2 secondPageResponse = secondPageResult.getResponse();
            Assert.assertNotNull(secondPageResponse);
            Assert.assertNotNull(secondPageResponse.getItems());
            
            // Print the results
            System.out.println("Second page query results (" + secondPageResponse.getItems().size() + " messages):");
            for (QueryChatroomHistoryMessagesResponseV2.MessageItem item : secondPageResponse.getItems()) {
                System.out.println("  - Message client ID: " + item.getMessageClientId() + 
                    ", Text: " + item.getText() + 
                    ", Create time: " + item.getCreateTime());
            }
        }
        
        // 3. Test querying with message type filter
        QueryChatroomHistoryMessagesRequestV2 filteredRequest = new QueryChatroomHistoryMessagesRequestV2(
            roomId,
            senderId,
            10      // Higher limit to get all messages
        );
        filteredRequest.setDescending(true);  // Descending order by time (newest first)
        filteredRequest.setMessageTypes("0");  // Only text messages (type 0)
        
        Result<QueryChatroomHistoryMessagesResponseV2> filteredResult = 
            messageService.queryChatroomHistoryMessages(filteredRequest);
        
        // Verify query was successful
        Assert.assertEquals(200, filteredResult.getCode());
        
        // Verify response contains data
        QueryChatroomHistoryMessagesResponseV2 filteredResponse = filteredResult.getResponse();
        Assert.assertNotNull(filteredResponse);
        Assert.assertNotNull(filteredResponse.getItems());
        
        // Print the results
        System.out.println("Filtered query results - text messages only (" + 
            filteredResponse.getItems().size() + " messages):");
        for (QueryChatroomHistoryMessagesResponseV2.MessageItem item : filteredResponse.getItems()) {
            System.out.println("  - Message client ID: " + item.getMessageClientId() + 
                ", Text: " + item.getText() + 
                ", Create time: " + item.getCreateTime());
            
            // Verify all returned messages are text messages
            Assert.assertEquals(Integer.valueOf(0), item.getMessageType());
        }
    }
    
    /**
     * Create a chatroom for testing
     * 
     * @return The ID of the created chatroom
     */
    private static Long createChatroom() throws YunxinSdkException {
        System.out.println("\n==== Creating Test Chatroom ====");
        
        // Create a chatroom with the sender as creator
        String roomName = "Test Chatroom " + System.currentTimeMillis();
        CreateChatroomRequestV2 request = new CreateChatroomRequestV2(senderId, roomName);
        
        // Configure the chatroom
        request.setAnnouncement("Welcome to the test chatroom!");
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
        Assert.assertEquals(senderId, response.getCreator());
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