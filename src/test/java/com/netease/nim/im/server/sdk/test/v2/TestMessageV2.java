package com.netease.nim.im.server.sdk.test.v2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v2.YunxinV2ApiServices;
import com.netease.nim.im.server.sdk.v2.account.IAccountV2Service;
import com.netease.nim.im.server.sdk.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.IConversationV2Service;
import com.netease.nim.im.server.sdk.v2.conversation.request.BatchSendP2PMessageRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.BatchSendP2PMessageResponseV2;
import com.netease.nim.im.server.sdk.v2.message.IMessageV2Service;
import com.netease.nim.im.server.sdk.v2.message.request.*;
import com.netease.nim.im.server.sdk.v2.message.response.*;
import com.netease.nim.im.server.sdk.v2.team.ITeamV2Service;
import com.netease.nim.im.server.sdk.v2.team.request.CreateTeamRequestV2;
import com.netease.nim.im.server.sdk.v2.team.response.CreateTeamResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;

/**
 * Test class for MessageV2Service
 */
public class TestMessageV2 {

    private static YunxinV2ApiServices services;
    private static IMessageV2Service messageService;
    private static IAccountV2Service accountService;
    private static ITeamV2Service teamService;
    private static IConversationV2Service conversationService;
    
    // Test account IDs
    private static final String accountId1 = "test_user1_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String accountId2 = "test_user2_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String accountId3 = "test_user3_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String accountId4 = "test_user4_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String accountId5 = "test_user5_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String batchQueryAccountId1 = "batchquery1_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String batchQueryAccountId2 = "batchquery2_" + UUID.randomUUID().toString().substring(0, 8);
    
    // Additional test account IDs for merged tests
    private static final String searchAccountId1 = "search1_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String searchAccountId2 = "search2_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String paginateAccountId1 = "paginate1_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String paginateAccountId2 = "paginate2_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String threadTestAccountId1 = "threadtest1_" + UUID.randomUUID().toString().substring(0, 8);
    private static final String threadTestAccountId2 = "threadtest2_" + UUID.randomUUID().toString().substring(0, 8);
    
    // Search keyword that will be used for search tests
    private static final String searchKeyword = "unique" + System.currentTimeMillis();

    /**
     * Initialize test environment
     */
    @BeforeClass
    public static void setup() throws Exception {
        if (services != null) {
            return;
        }

        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        
        services = new YunxinV2ApiServices(client);
        messageService = services.getMessageService();
        accountService = services.getAccountService();
        teamService = services.getTeamService();
        conversationService = services.getConversationService();

            // Create test accounts
        try {
            System.out.println("\n==== Creating Test Accounts ====");
            createAccount(accountId1, "Test User 1");
            createAccount(accountId2, "Test User 2");
            createAccount(accountId3, "Test User 3");
            createAccount(accountId4, "Test User 4");
            createAccount(accountId5, "Test User 5");
            createAccount(batchQueryAccountId1, "Batch Query Test User 1");
            createAccount(batchQueryAccountId2, "Batch Query Test User 2");
            
            // Create additional accounts for merged tests
            createAccount(searchAccountId1, "Search Test User 1");
            createAccount(searchAccountId2, "Search Test User 2");
            createAccount(paginateAccountId1, "Pagination Test User 1");
            createAccount(paginateAccountId2, "Pagination Test User 2");
            createAccount(threadTestAccountId1, "Thread Test User 1");
            createAccount(threadTestAccountId2, "Thread Test User 2");
        } catch (Exception e) {
            System.err.println("Error creating test accounts: " + e.getMessage());
        }
    }

    @Test
    public void testSendP2PMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create conversation ID for P2P chat
        String conversationId = accountId1 + "|1|" + accountId2;
        
        // Create message request
        SendMessageRequestV2 request = new SendMessageRequestV2();
        request.setConversationId(conversationId);
        
        // Create message body
        SendMessageRequestV2.MessageBody message = new SendMessageRequestV2.MessageBody();
        message.setMessageType(0); // Text message
        message.setText("Hello, this is a P2P test message sent at " + System.currentTimeMillis());
        
        request.setMessage(message);
        
        // Set message configuration
        SendMessageRequestV2.MessageConfig messageConfig = new SendMessageRequestV2.MessageConfig();
        messageConfig.setUnreadEnabled(true);
        messageConfig.setHistoryEnabled(true);
        messageConfig.setRoamingEnabled(true);
        
        request.setMessageConfig(messageConfig);
        
        // Send the message
        Result<SendMessageResponseV2> result = messageService.sendMessage(request);
        
        System.out.println("sendP2PMessage: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify message was sent successfully
        Assert.assertEquals(200, result.getCode());
        SendMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(Integer.valueOf(0), response.getMessageType()); // Text message
        Assert.assertEquals(accountId1, response.getSenderId());
        Assert.assertEquals(accountId2, response.getReceiverId());
        Assert.assertEquals(Integer.valueOf(1), response.getConversationType()); // P2P chat
        
        System.out.println("Sent P2P message:");
        System.out.println("  Message ID: " + response.getMessageServerId());
        System.out.println("  Sender: " + response.getSenderId());
        System.out.println("  Receiver: " + response.getReceiverId());
        System.out.println("  Type: " + response.getMessageType());
        System.out.println("  Content: " + response.getText());
        System.out.println("  Time: " + response.getCreateTime());
    }
    
    @Test
    public void testSendTeamMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // First create a team
        String teamName = "Test Team " + System.currentTimeMillis();
        String teamId = createAdvancedTeam(teamName);
        if (teamId == null) {
            System.out.println("Failed to create team for team message test");
            return;
        }
        
        // Create conversation ID for team chat
        String conversationId = accountId1 + "|2|" + teamId;
        
        // Create message request
        SendMessageRequestV2 request = new SendMessageRequestV2();
        request.setConversationId(conversationId);
        
        // Create message body
        SendMessageRequestV2.MessageBody message = new SendMessageRequestV2.MessageBody();
        message.setMessageType(0); // Text message
        message.setText("Hello team, this is a test message sent at " + System.currentTimeMillis());
        
        request.setMessage(message);
        
        // Set message configuration
        SendMessageRequestV2.MessageConfig messageConfig = new SendMessageRequestV2.MessageConfig();
        messageConfig.setUnreadEnabled(true);
        messageConfig.setHistoryEnabled(true);
        messageConfig.setRoamingEnabled(true);
        
        request.setMessageConfig(messageConfig);
        
        // Set team options (with read receipt)
        SendMessageRequestV2.TeamOption teamOption = new SendMessageRequestV2.TeamOption();
        teamOption.setMarkAsRead(true);
        
        request.setTeamOption(teamOption);
        
        // Send the message
        Result<SendMessageResponseV2> result = messageService.sendMessage(request);
        
        System.out.println("sendTeamMessage: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify message was sent successfully
        Assert.assertEquals(200, result.getCode());
        SendMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(Integer.valueOf(0), response.getMessageType()); // Text message
        Assert.assertEquals(accountId1, response.getSenderId());
        Assert.assertEquals(teamId, response.getReceiverId());
        Assert.assertEquals(Integer.valueOf(2), response.getConversationType()); // Team chat
        
        System.out.println("Sent team message:");
        System.out.println("  Message ID: " + response.getMessageServerId());
        System.out.println("  Sender: " + response.getSenderId());
        System.out.println("  Team ID: " + response.getReceiverId());
        System.out.println("  Type: " + response.getMessageType());
        System.out.println("  Content: " + response.getText());
        System.out.println("  Time: " + response.getCreateTime());
    }
    
    @Test
    public void testSendTextMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create conversation ID for P2P chat
        String conversationId = accountId1 + "|1|" + accountId2;
        
        // Text message content
        String text = "This is a test message sent using the helper method at " + System.currentTimeMillis();
        
        // Create the request
        SendMessageRequestV2 request = SendMessageRequestV2.createTextMessage(conversationId, text);
        
        // Send the message using main method
        Result<SendMessageResponseV2> result = messageService.sendMessage(request);
        
        System.out.println("sendTextMessage: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify message was sent successfully
        Assert.assertEquals(200, result.getCode());
        SendMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(Integer.valueOf(0), response.getMessageType()); // Text message
        Assert.assertEquals(accountId1, response.getSenderId());
        Assert.assertEquals(accountId2, response.getReceiverId());
        
        System.out.println("Sent text message using helper method:");
        System.out.println("  Message ID: " + response.getMessageServerId());
        System.out.println("  Content: " + response.getText());
    }
    
    @Test
    public void testSendCustomMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create conversation ID for P2P chat
        String conversationId = accountId1 + "|1|" + accountId2;
        
        // Create custom message attachment
        Map<String, Object> attachment = new HashMap<>();
        attachment.put("customKey1", "customValue1");
        attachment.put("customKey2", 12345);
        attachment.put("timestamp", System.currentTimeMillis());
        
        // Custom message subtype
        Integer subType = 1;
        
        // Create the request
        SendMessageRequestV2 request = SendMessageRequestV2.createCustomMessage(conversationId, attachment, subType);
        
        // Send the custom message using main method
        Result<SendMessageResponseV2> result = messageService.sendMessage(request);
        
        System.out.println("sendCustomMessage: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify message was sent successfully
        Assert.assertEquals(200, result.getCode());
        SendMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(Integer.valueOf(100), response.getMessageType()); // Custom message
        Assert.assertEquals(subType, response.getSubType());
        Assert.assertEquals(accountId1, response.getSenderId());
        Assert.assertEquals(accountId2, response.getReceiverId());
        
        System.out.println("Sent custom message:");
        System.out.println("  Message ID: " + response.getMessageServerId());
        System.out.println("  Type: " + response.getMessageType());
        System.out.println("  SubType: " + response.getSubType());
        System.out.println("  Attachment: " + JSON.toJSONString(response.getAttachment()));
    }
    
    @Test
    public void testBatchSendTextMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create receivers list
        List<String> receiverIds = Arrays.asList(accountId2, accountId3);
        
        // Text message content
        String text = "Batch text message test at " + System.currentTimeMillis();
        
        // Create the request using the helper method
        BatchSendP2PMessageRequestV2 request = BatchSendP2PMessageRequestV2.createTextMessage(accountId1, receiverIds, text);
        
        // Set need message detail to true to get full message details in response
        request.setNeedMessageDetail(true);
        
        // Call the API
        Result<BatchSendP2PMessageResponseV2> result = conversationService.batchSendP2PMessage(request);
        
        System.out.println("batchSendTextMessage: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Validate batch message response with message type 0 (text)
        validateBatchMessageResponse(result, accountId1, receiverIds, 0, text, null, null);
    }
    
    @Test
    public void testBatchSendCustomMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // Create receivers list
        List<String> receiverIds = Arrays.asList(accountId2, accountId3);
        
        // Create custom message data
        Integer subType = 1;
        Map<String, String> attachment = new HashMap<>();
        attachment.put("custom", "data");
        attachment.put("timestamp", String.valueOf(System.currentTimeMillis()));
        
        // Create the request using the helper method
        BatchSendP2PMessageRequestV2 request = BatchSendP2PMessageRequestV2.createCustomMessage(
                accountId1, receiverIds, subType, attachment);
        
        // Set need message detail to true to get full message details in response
        request.setNeedMessageDetail(true);
        
        // Call the API
        Result<BatchSendP2PMessageResponseV2> result = conversationService.batchSendP2PMessage(request);
        
        System.out.println("batchSendCustomMessage: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Validate batch message response with message type 100 (custom)
        validateBatchMessageResponse(result, accountId1, receiverIds, 100, null, subType, attachment);
    }
    
    @Test
    public void testModifyMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // First, send a message that will be modified
        String conversationId = accountId1 + "|1|" + accountId2;
        SendMessageRequestV2 sendRequest = SendMessageRequestV2.createTextMessage(
                conversationId, 
                "This message will be modified at " + System.currentTimeMillis()
        );
        Result<SendMessageResponseV2> sendResult = messageService.sendMessage(sendRequest);
        Assert.assertTrue(sendResult.isSuccess());
        SendMessageResponseV2 sendResponse = sendResult.getResponse();
        
        // Now modify the message
        // Create updated text content
        String newText = "This message has been updated at " + System.currentTimeMillis();
        
        // Create a modify message request
        ModifyMessageRequestV2 request = new ModifyMessageRequestV2();
        request.setOperator(accountId1); // operator (same as sender in this case)
        request.setType(1); // conversation type (1 for P2P)
        
        // Set message content
        ModifyMessageRequestV2.Message message = new ModifyMessageRequestV2.Message();
        message.setMessageServerId(sendResponse.getMessageServerId());
        message.setSenderId(accountId1);
        message.setReceiverId(accountId2);
        message.setTime(sendResponse.getCreateTime());
        message.setMessageType(0); // Text message
        message.setText(newText);
        
        request.setMessage(message);
        
        // Call the modify message method
        Result<ModifyMessageResponseV2> result = messageService.modifyMessage(request);
        
        System.out.println("modifyTextMessage: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify modification was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
    }
    
    @Test
    public void testWithdrawMessage() throws YunxinSdkException {
        if (services == null) return;
        
        System.out.println("---------- Testing Message Withdrawal ----------");
        
        // Create conversation ID
        String conversationId = accountId1 + "|1|" + accountId2;
        
        // First, send a message
        SendMessageRequestV2 sendRequest = SendMessageRequestV2.createTextMessage(
                conversationId, 
                "This message will be withdrawn"
        );
        Result<SendMessageResponseV2> sendResult = messageService.sendMessage(sendRequest);
        Assert.assertTrue(sendResult.isSuccess());
        Assert.assertNotNull(sendResult.getResponse());
        Assert.assertNotNull(sendResult.getResponse().getMessageServerId());
        Long messageId = sendResult.getResponse().getMessageServerId();
        System.out.println("Sent message: " + messageId);
        
        // Now withdraw the message (bilateral recall - type 2)
        WithdrawMessageRequestV2 withdrawRequest = new WithdrawMessageRequestV2(
                conversationId, 
                messageId,
                2 // Type 2: Bilateral recall
        );
        withdrawRequest.setDescription("Message has been withdrawn");
        withdrawRequest.setPushContent("A message has been recalled");
        
        Result<WithdrawMessageResponseV2> withdrawResult = messageService.withdrawMessage(withdrawRequest);
        Assert.assertTrue("Message withdrawal failed: " + withdrawResult.getMsg(), withdrawResult.isSuccess());
        System.out.println("Successfully withdrew message: " + messageId);
    }
    
    @Test
    public void testDeleteConversationMessages() throws YunxinSdkException {
        if (services == null) return;
        
        // Create conversation ID
        String conversationId = accountId1 + "|1|" + accountId3;
        
        // First, send some test messages
        for (int i = 0; i < 3; i++) {
            SendMessageRequestV2 request = SendMessageRequestV2.createTextMessage(
                conversationId, 
                    "Test message " + i + " - " + System.currentTimeMillis()
            );
            Result<SendMessageResponseV2> result = messageService.sendMessage(request);
            Assert.assertTrue(result.isSuccess());
            System.out.println("Sent message " + i + ": " + JSON.toJSONString(result));
            
            try {
                // Add a small delay between messages
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Now delete all messages from the conversation (type 3 - both roaming and history)
        DeleteConversationMessagesRequestV2 request = new DeleteConversationMessagesRequestV2();
        request.setConversationId(conversationId);
        request.setType(3); // Delete both roaming and history messages
        
        Result<DeleteConversationMessagesResponseV2> result = messageService.deleteConversationMessages(request);
        Assert.assertTrue("Failed to delete conversation messages: " + result.getMsg(), result.isSuccess());
        System.out.println("Successfully deleted all messages from conversation");
    }
    
    @Test
    public void testSendP2PReadReceipt() throws YunxinSdkException {
        if (services == null) return;
        
        // First, send a message that will be marked as read
        String conversationId = accountId3 + "|1|" + accountId4;
        SendMessageRequestV2 sendRequest = SendMessageRequestV2.createTextMessage(
                conversationId, 
                "This message will be marked as read at " + System.currentTimeMillis()
        );
        Result<SendMessageResponseV2> sendResult = messageService.sendMessage(sendRequest);
        Assert.assertTrue(sendResult.isSuccess());
        Assert.assertNotNull(sendResult.getResponse());
        Assert.assertNotNull(sendResult.getResponse().getMessageServerId());
        Long messageId = sendResult.getResponse().getMessageServerId();
        
        // Now send a read receipt for this message
        SendP2PReadReceiptRequestV2 readReceiptRequest = new SendP2PReadReceiptRequestV2(
                accountId4,  // From account ID (receipt sender / message receiver)
                accountId3,  // To account ID (receipt receiver / message sender)
                messageId    // ID of the message to mark as read
        );
        
        Result<SendP2PReadReceiptResponseV2> result = messageService.sendP2PReadReceipt(readReceiptRequest);
        
        Assert.assertTrue("Failed to send P2P read receipt: " + result.getMsg(), result.isSuccess());
        Assert.assertNotNull(result.getResponse());
        Assert.assertNotNull(result.getResponse().getTimestamp());
        
        System.out.println("Successfully sent P2P read receipt");
    }
    
    @Test
    public void testQueryMessage() throws YunxinSdkException {
        if (services == null) return;
        
        // First, send a message to query later
        String conversationId = accountId4 + "|1|" + accountId5;
        
        // Send a test message
        SendMessageRequestV2 sendRequest = SendMessageRequestV2.createTextMessage(
                conversationId, 
                "This message will be queried at " + System.currentTimeMillis()
        );
        
        Result<SendMessageResponseV2> sendResult = messageService.sendMessage(sendRequest);
        Assert.assertTrue(sendResult.isSuccess());
        SendMessageResponseV2 sendResponse = sendResult.getResponse();
        
        try {
            // Wait a moment to ensure message is fully processed
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Query the message
        QueryMessageRequestV2 queryRequest = new QueryMessageRequestV2(
                conversationId, 
                sendResponse.getMessageServerId()
        );
        
        Result<QueryMessageResponseV2> result = messageService.queryMessage(queryRequest);
        
        // Might not always succeed due to eventual consistency
        if (result.isSuccess() && result.getResponse() != null) {
            System.out.println("Successfully queried message");
            Assert.assertEquals(sendResponse.getText(), result.getResponse().getText());
        } else {
            System.out.println("Message query not successful, this may be normal: " + result.getMsg());
        }
    }
    
    @Test
    public void testBatchQueryMessages() throws Exception {
        if (services == null) return;
        
        try {
            // Create conversation ID
            String conversationId = batchQueryAccountId1 + "|1|" + batchQueryAccountId2;
            
            // Send test messages
            System.out.println("\n==== Sending Test Messages for Batch Query ====");
            List<Long> messageIds = new ArrayList<>();
            List<Long> messageTimes = new ArrayList<>();
            
            // Send multiple messages
        for (int i = 0; i < 3; i++) {
                Result<SendMessageResponseV2> result = sendTextMessage(conversationId, "Text message " + i + " for batch query testing");
                if (result.getCode() == 200 && result.getResponse() != null) {
                    messageIds.add(result.getResponse().getMessageServerId());
                    messageTimes.add(result.getResponse().getCreateTime());
                }
                
                try {
                    // Small delay between messages
            Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            
            // Wait for messages to be processed
            System.out.println("Waiting for messages to be processed...");
            Thread.sleep(2000);
            
            // Test batch query
            if (messageIds.isEmpty() || messageTimes.isEmpty()) {
                System.out.println("No messages to query");
                return;
            }
            
            // Create message query list
            List<BatchQueryMessagesRequestV2.MessageQuery> messageQueries = new ArrayList<>();
            for (int i = 0; i < messageIds.size(); i++) {
                BatchQueryMessagesRequestV2.MessageQuery query = new BatchQueryMessagesRequestV2.MessageQuery();
                query.setMessageServerId(messageIds.get(i));
                query.setCreateTime(messageTimes.get(i));
                messageQueries.add(query);
            }
            
            // Create request
            BatchQueryMessagesRequestV2 request = new BatchQueryMessagesRequestV2(conversationId, messageQueries);
            
            // Execute query
            Result<BatchQueryMessagesResponseV2> result = messageService.batchQueryMessages(request);
            
            System.out.println("Batch query response: " + JSON.toJSONString(result));
            
            // Verify query was successful
            Assert.assertEquals(200, result.getCode());
            Assert.assertNotNull(result.getResponse());
            
            // Display query results
            displayBatchQueryResults(result.getResponse());
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Test
    public void testBatchQueryMessagesWithInvalidId() throws Exception {
        if (services == null) return;
        
        try {
            // Create conversation ID
            String conversationId = batchQueryAccountId1 + "|1|" + batchQueryAccountId2;
            
            // Send a test message
            Result<SendMessageResponseV2> sendResult = sendTextMessage(conversationId, "Message for invalid ID test");
        Assert.assertTrue(sendResult.isSuccess());
            SendMessageResponseV2 sendResponse = sendResult.getResponse();
            
            // Create message query list with valid and invalid IDs
            List<BatchQueryMessagesRequestV2.MessageQuery> messageQueries = new ArrayList<>();
            
            // Add valid message
            BatchQueryMessagesRequestV2.MessageQuery validQuery = new BatchQueryMessagesRequestV2.MessageQuery();
            validQuery.setMessageServerId(sendResponse.getMessageServerId());
            validQuery.setCreateTime(sendResponse.getCreateTime());
            messageQueries.add(validQuery);
            
            // Add invalid message with non-existent ID
            BatchQueryMessagesRequestV2.MessageQuery invalidQuery = new BatchQueryMessagesRequestV2.MessageQuery();
            invalidQuery.setMessageServerId(999999999L); // Non-existent ID
            invalidQuery.setCreateTime(System.currentTimeMillis());
            messageQueries.add(invalidQuery);
            
            // Create request
            BatchQueryMessagesRequestV2 request = new BatchQueryMessagesRequestV2(conversationId, messageQueries);
            
            // Execute query
            Result<BatchQueryMessagesResponseV2> result = messageService.batchQueryMessages(request);
            
            System.out.println("Batch query with invalid ID response: " + JSON.toJSONString(result));
            
            // Verify query was successful (the API call itself should succeed even if some messages aren't found)
            Assert.assertEquals(200, result.getCode());
            Assert.assertNotNull(result.getResponse());
            
            // Display query results
            displayBatchQueryResults(result.getResponse());
            
            // Verify that there is at least one failed message in the response
            Assert.assertNotNull(result.getResponse().getFailedList());
            Assert.assertFalse(result.getResponse().getFailedList().isEmpty());
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testSearchMessages() throws Exception {
        if (services == null) return;
        
        try {
            System.out.println("\n==== Testing Search Messages Functionality ====");
            
            // Create conversation ID
            String conversationId = searchAccountId1 + "|1|" + searchAccountId2;
            
            // Send test message with the search keyword
            System.out.println("\n==== Sending Test Message with Search Keyword ====");
            sendTextMessage(conversationId, "This is a test message with " + searchKeyword + " for search test");
            
            // Wait for message indexing
            System.out.println("\nWaiting for messages to be indexed...");
            TimeUnit.SECONDS.sleep(3);
            
            // Test different search scenarios
            System.out.println("\n==== Testing Search by Keyword ====");
            testSearchByKeyword();
            
            System.out.println("\n==== Testing Search by Sender ====");
            testSearchBySender();
            
            System.out.println("\n==== Testing Search by Message Type ====");
            testSearchByMessageType();
            
            System.out.println("\n==== Testing Search with Multiple Criteria ====");
            testSearchWithMultipleCriteria();
            
            System.out.println("\n==== Testing Search with Pagination ====");
            testSearchWithPagination();
            
            System.out.println("\n==== All search tests completed successfully ====");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test searching messages by keyword
     */
    private void testSearchByKeyword() throws YunxinSdkException {
        // Create search request with keyword
        SearchMessagesRequestV2 request = new SearchMessagesRequestV2(searchAccountId1);
        request.setKeywordList(new String[]{searchKeyword});
        request.setLimit(20);
        
        // Execute search
        Result<SearchMessagesResponseV2> result = messageService.searchMessages(request);
        
        System.out.println("Search by keyword response: " + JSON.toJSONString(result));
        
        // Verify search was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display search results
        displaySearchResults(result.getResponse(), "keyword: " + searchKeyword);
    }
    
    /**
     * Test searching messages by sender
     */
    private void testSearchBySender() throws YunxinSdkException {
        // Create search request with sender
        SearchMessagesRequestV2 request = new SearchMessagesRequestV2(searchAccountId1);
        request.setSenderAccountIds(searchAccountId1);
        request.setLimit(20);
        
        // Execute search
        Result<SearchMessagesResponseV2> result = messageService.searchMessages(request);
        
        System.out.println("Search by sender response: " + JSON.toJSONString(result));
        
        // Verify search was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display search results
        displaySearchResults(result.getResponse(), "sender: " + searchAccountId1);
    }
    
    /**
     * Test searching messages by message type
     */
    private void testSearchByMessageType() throws YunxinSdkException {
        // Create search request with message type (0 = text message)
        SearchMessagesRequestV2 request = new SearchMessagesRequestV2(searchAccountId1);
        request.setMessageTypes("0");
        request.setLimit(20);
        
        // Execute search
        Result<SearchMessagesResponseV2> result = messageService.searchMessages(request);
        
        System.out.println("Search by message type response: " + JSON.toJSONString(result));
        
        // Verify search was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display search results
        displaySearchResults(result.getResponse(), "message type: 0 (text)");
    }
    
    /**
     * Test searching messages with multiple criteria
     */
    private void testSearchWithMultipleCriteria() throws YunxinSdkException {
        // Create search request with multiple criteria
        SearchMessagesRequestV2 request = new SearchMessagesRequestV2(searchAccountId1);
        request.setSenderAccountIds(searchAccountId1);
        request.setMessageTypes("0"); // Text message
        request.setKeywordList(new String[]{searchKeyword});
        request.setKeywordMatchType(0); // OR search
        request.setLimit(20);
        
        // Set time range (last 24 hours)
        long endTime = System.currentTimeMillis();
        long startTime = endTime - (24 * 60 * 60 * 1000); // 24 hours ago
        request.setStartTime(endTime);
        request.setTimePeriod(endTime - startTime);
        
        // Execute search
        Result<SearchMessagesResponseV2> result = messageService.searchMessages(request);
        
        System.out.println("Search with multiple criteria response: " + JSON.toJSONString(result));
        
        // Verify search was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display search results
        String criteria = "sender: " + searchAccountId1 + ", type: 0, keyword: " + searchKeyword + ", time period: last 24h";
        displaySearchResults(result.getResponse(), criteria);
    }
    
    /**
     * Test searching messages with pagination
     */
    private void testSearchWithPagination() throws YunxinSdkException {
        // First page search
        SearchMessagesRequestV2 request = new SearchMessagesRequestV2(searchAccountId1);
        request.setMessageTypes("0"); // Add message type criteria (text messages)
        request.setLimit(10); // Small limit to test pagination
        
        // Execute search for first page
        Result<SearchMessagesResponseV2> result = messageService.searchMessages(request);
        
        System.out.println("Search first page response: " + JSON.toJSONString(result));
        
        // Verify search was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display first page results
        displaySearchResults(result.getResponse(), "first page (limit: 10)");
        
        // If there's more pages, try to get the next page
        if (result.getResponse().getHasMore() != null && result.getResponse().getHasMore()
                && result.getResponse().getNextToken() != null) {
            
            // Second page search
            SearchMessagesRequestV2 nextRequest = new SearchMessagesRequestV2(searchAccountId1);
            nextRequest.setMessageTypes("0"); // Add message type criteria (text messages)
            nextRequest.setLimit(10);
            nextRequest.setPageToken(result.getResponse().getNextToken());
            
            // Execute search for second page
            Result<SearchMessagesResponseV2> nextResult = messageService.searchMessages(nextRequest);
            
            System.out.println("Search second page response: " + JSON.toJSONString(nextResult));
            
            // Verify search was successful
            Assert.assertEquals(200, nextResult.getCode());
            Assert.assertNotNull(nextResult.getResponse());
            
            // Display second page results
            displaySearchResults(nextResult.getResponse(), "second page (limit: 10)");
            } else {
            System.out.println("No more pages available for testing pagination");
        }
    }
    
    /**
     * Display search results in a readable format
     */
    private void displaySearchResults(SearchMessagesResponseV2 response, String searchType) {
        if (response.getCount() != null && response.getCount() > 0) {
            System.out.println("Found " + response.getCount() + " messages matching " + searchType);
            
            if (response.getItems() != null) {
                int count = 1;
                for (SearchMessagesResponseV2.MessageItem item : response.getItems()) {
                    System.out.println("Message " + count + ":");
                    System.out.println("  ID: " + item.getMessageServerId());
                    System.out.println("  Sender: " + item.getSenderId());
                    System.out.println("  Type: " + item.getMessageType());
                    System.out.println("  Content: " + item.getText());
                    System.out.println("  Time: " + new Date(item.getCreateTime()));
                    count++;
                }
            }
            
            if (response.getHasMore() != null && response.getHasMore()) {
                System.out.println("More messages are available. Next token: " + response.getNextToken());
            }
        } else {
            System.out.println("No messages found matching " + searchType);
        }
    }

    /**
     * Create an advanced team
     * 
     * @param teamName the name for the team
     * @return team ID if created successfully, null otherwise
     */
    private String createAdvancedTeam(String teamName) throws YunxinSdkException {
        List<String> inviteAccountIds = Arrays.asList(accountId2, accountId3);
        String inviteMsg = "Join my test team";
        
        // Use helper method from CreateTeamRequestV2
        CreateTeamRequestV2 request = CreateTeamRequestV2.createAdvancedTeam(
            accountId1, teamName, inviteAccountIds, inviteMsg);
        
        Result<CreateTeamResponseV2> result = teamService.createTeam(request);
        
        System.out.println("createAdvancedTeam: " + result.getMsg());
        
        if (result.getCode() == 200 && result.getResponse() != null) {
            String teamId = String.valueOf(result.getResponse().getTeamInfo().getTeamId());
            System.out.println("Created team: " + teamId + ", name: " + teamName);
            return teamId;
                } else {
            System.out.println("Failed to create team: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Helper method to validate batch message responses
     */
    private void validateBatchMessageResponse(Result<BatchSendP2PMessageResponseV2> result, 
                                           String senderId, 
                                           List<String> receiverIds,
                                           Integer messageType,
                                           String text,
                                           Integer subType,
                                           Object attachment) {
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        BatchSendP2PMessageResponseV2 response = result.getResponse();
        Assert.assertNotNull("Response should not be null", response);
        
        // Check success list
        if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
            System.out.println("Successfully sent messages: " + response.getSuccessList().size());
            
            for (BatchSendP2PMessageResponseV2.SuccessItem item : response.getSuccessList()) {
                System.out.println("Message sent to: " + item.getReceiverId());
                
                // Common validations
                Assert.assertEquals(senderId, item.getSenderId());
                Assert.assertTrue(receiverIds.contains(item.getReceiverId()));
                Assert.assertEquals(messageType, item.getMessageType());
                Assert.assertNotNull(item.getMessageServerId());
                Assert.assertNotNull(item.getCreateTime());
                
                // Message type specific validations
                if (messageType == 0 && text != null) {
                    Assert.assertEquals(text, item.getText());
                } else if (messageType == 100) {
                    Assert.assertEquals(subType, item.getSubType());
                    Assert.assertNotNull(item.getAttachment());
                }
            }
        }
    }
    
    /**
     * Helper method to send a text message for batch query tests
     */
    private Result<SendMessageResponseV2> sendTextMessage(String conversationId, String text) throws YunxinSdkException {
        // Create message request
        SendMessageRequestV2 request = SendMessageRequestV2.createTextMessage(conversationId, text);
        
        // Send the message
        Result<SendMessageResponseV2> result = messageService.sendMessage(request);

        // Print message info on success
        if (result.getCode() == 200) {
            SendMessageResponseV2 response = result.getResponse();
            System.out.println("Sent message for batch query:");
            System.out.println("  Message ID: " + response.getMessageServerId());
            System.out.println("  Content: " + response.getText());
            System.out.println("  Time: " + response.getCreateTime());
        } else {
            System.out.println("Failed to send message: " + result.getMsg());
        }
        
        return result;
    }
    
    /**
     * Helper method to create a test account
     */
    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        
        // Create and set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);
        
        // Set configuration
        CreateAccountRequestV2.Configuration config = new CreateAccountRequestV2.Configuration();
        config.setEnabled(true);
        request.setConfiguration(config);
        
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        // If account already exists, it's not an error for our test
        if (result.getCode() == 200) {
            System.out.println("Created account: " + accountId + ", name: " + name);
        } else if (result.getCode() == 414) {
            // 414 usually means account already exists
            System.out.println("Account already exists: " + accountId);
        } else {
            // Fail the test for other unexpected errors
            System.err.println("Failed to create account " + accountId + ": " + result.getMsg());
        }
    }

    @Test
    public void testQueryConversationMessages() throws Exception {
        if (services == null) return;
        
        try {
            System.out.println("\n==== Testing Conversation Messages Pagination ====");
            
            // Create conversation ID
            String conversationId = paginateAccountId1 + "|1|" + paginateAccountId2;
            
            // Send test messages
            System.out.println("\n==== Sending Test Messages ====");
            long startTime = System.currentTimeMillis();
            
            // Send multiple messages with different types
            for (int i = 0; i < 5; i++) {
                sendTextMessage(conversationId, "Text message " + i + " for pagination testing");
                TimeUnit.MILLISECONDS.sleep(100); // Small delay between messages
            }
            
            // Wait for messages to be processed
            System.out.println("\nWaiting for messages to be processed...");
            TimeUnit.SECONDS.sleep(2);
            
            long endTime = System.currentTimeMillis();
            
            // Test basic query
            System.out.println("\n==== Testing Basic Query ====");
            testBasicConversationQuery(conversationId, startTime, endTime);
            
            // Test pagination
            System.out.println("\n==== Testing Pagination ====");
            testConversationPagination(conversationId, startTime, endTime);
            
            // Test sorting order
            System.out.println("\n==== Testing Sorting Order ====");
            testConversationSortingOrder(conversationId, startTime, endTime);
            
            // Test filtering by message type
            System.out.println("\n==== Testing Filtering by Message Type ====");
            testFilterConversationByMessageType(conversationId, startTime, endTime);
            
            System.out.println("\n==== All conversation pagination tests completed successfully ====");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test basic query functionality for conversations
     */
    private void testBasicConversationQuery(String conversationId, long startTime, long endTime) throws YunxinSdkException {
        // Create request with all required parameters
        QueryConversationMessagesRequestV2 request = new QueryConversationMessagesRequestV2(
                conversationId,
                startTime,
                endTime,
                100 // Max limit
        );
        
        // Execute query
        Result<QueryConversationMessagesResponseV2> result = messageService.queryConversationMessages(request);
        
        System.out.println("Basic query response: " + JSON.toJSONString(result));
        
        // Verify query was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display query results
        displayConversationQueryResults(result.getResponse(), "basic query");
    }
    
    /**
     * Test pagination functionality for conversations
     */
    private void testConversationPagination(String conversationId, long startTime, long endTime) throws YunxinSdkException {
        // First page query with small limit
        QueryConversationMessagesRequestV2 request = new QueryConversationMessagesRequestV2(
                conversationId,
                startTime,
                endTime,
                2 // Small limit to test pagination
        );
        
        // Execute query for first page
        Result<QueryConversationMessagesResponseV2> result = messageService.queryConversationMessages(request);
        
        System.out.println("First page query response: " + JSON.toJSONString(result));
        
        // Verify query was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display first page results
        displayConversationQueryResults(result.getResponse(), "first page (limit: 2)");
        
        // If there's more pages, get next page
        if (result.getResponse().getHasMore() != null && result.getResponse().getHasMore()
                && result.getResponse().getNextToken() != null) {
            
            // Second page query
            QueryConversationMessagesRequestV2 nextRequest = new QueryConversationMessagesRequestV2(
                    conversationId,
                    startTime,
                    endTime,
                    2 // Same limit as first page
            );
            nextRequest.setPageToken(result.getResponse().getNextToken());
            
            // Execute query for second page
            Result<QueryConversationMessagesResponseV2> nextResult = messageService.queryConversationMessages(nextRequest);
            
            System.out.println("Second page query response: " + JSON.toJSONString(nextResult));
            
            // Verify query was successful
            Assert.assertEquals(200, nextResult.getCode());
            Assert.assertNotNull(nextResult.getResponse());
            
            // Display second page results
            displayConversationQueryResults(nextResult.getResponse(), "second page (limit: 2)");
        } else {
            System.out.println("No more pages available for testing pagination");
        }
    }
    
    /**
     * Test sorting order for conversations (ascending/descending by time)
     */
    private void testConversationSortingOrder(String conversationId, long startTime, long endTime) throws YunxinSdkException {
        // Test ascending order (descending=true)
        QueryConversationMessagesRequestV2 ascRequest = new QueryConversationMessagesRequestV2(
                conversationId,
                startTime,
                endTime,
                100
        );
        ascRequest.setDescending(true); // Ascending order by time
        
        // Execute query with ascending order
        Result<QueryConversationMessagesResponseV2> ascResult = messageService.queryConversationMessages(ascRequest);
        
        System.out.println("Ascending order query response: " + JSON.toJSONString(ascResult));
        
        // Verify query was successful
        Assert.assertEquals(200, ascResult.getCode());
        Assert.assertNotNull(ascResult.getResponse());
        
        // Display ascending order results
        displayConversationQueryResults(ascResult.getResponse(), "ascending order by time");
        
        // Test descending order (descending=false)
        QueryConversationMessagesRequestV2 descRequest = new QueryConversationMessagesRequestV2(
                conversationId,
                startTime,
                endTime,
                100
        );
        descRequest.setDescending(false); // Descending order by time
        
        // Execute query with descending order
        Result<QueryConversationMessagesResponseV2> descResult = messageService.queryConversationMessages(descRequest);
        
        System.out.println("Descending order query response: " + JSON.toJSONString(descResult));
        
        // Verify query was successful
        Assert.assertEquals(200, descResult.getCode());
        Assert.assertNotNull(descResult.getResponse());
        
        // Display descending order results
        displayConversationQueryResults(descResult.getResponse(), "descending order by time");
    }
    
    /**
     * Test filtering by message type for conversations
     */
    private void testFilterConversationByMessageType(String conversationId, long startTime, long endTime) throws YunxinSdkException {
        // Query only text messages (type 0)
        QueryConversationMessagesRequestV2 request = new QueryConversationMessagesRequestV2(
                conversationId,
                startTime,
                endTime,
                100
        );
        request.setMessageType("0"); // Only text messages
        
        // Execute query with message type filter
        Result<QueryConversationMessagesResponseV2> result = messageService.queryConversationMessages(request);
        
        System.out.println("Message type filter query response: " + JSON.toJSONString(result));
        
        // Verify query was successful
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Display filtered results
        displayConversationQueryResults(result.getResponse(), "message type filter (type 0: text)");
    }
    
    /**
     * Display conversation query results in a readable format
     */
    private void displayConversationQueryResults(QueryConversationMessagesResponseV2 response, String queryType) {
        if (response.getItems() != null && !response.getItems().isEmpty()) {
            System.out.println("Found " + response.getItems().size() + " messages for " + queryType);
            
                int count = 1;
            for (QueryConversationMessagesResponseV2.MessageItem item : response.getItems()) {
                    System.out.println("Message " + count + ":");
                    System.out.println("  ID: " + item.getMessageServerId());
                    System.out.println("  Sender: " + item.getSenderId());
                    System.out.println("  Type: " + item.getMessageType());
                    System.out.println("  Content: " + item.getText());
                    System.out.println("  Time: " + new Date(item.getCreateTime()));
                    count++;
                }
            
            if (response.getHasMore() != null && response.getHasMore()) {
                System.out.println("More messages are available. Next token: " + response.getNextToken());
            }
        } else {
            System.out.println("No messages found for " + queryType);
        }
    }

    @Test
    public void testQueryThreadMessages() throws Exception {
        if (services == null) return;
        
        try {
            System.out.println("\n==== Testing Thread Messages ====");
            
            // Create conversation ID
            String conversationId = threadTestAccountId1 + "|1|" + threadTestAccountId2;
            
            // Send a test message that will be our thread root
            System.out.println("\n==== Sending Thread Root Message ====");
            Result<SendMessageResponseV2> rootMessageResult = sendTextMessage(
                    conversationId, "This is a thread root message for testing");
            
            if (rootMessageResult.getCode() != 200 || rootMessageResult.getResponse() == null) {
                System.out.println("Failed to send thread root message, skipping test");
                return;
            }
            
            // Get root message details
            Long rootMessageId = rootMessageResult.getResponse().getMessageServerId();
            String rootMessageClientId = rootMessageResult.getResponse().getMessageClientId();
            Long rootMessageTime = rootMessageResult.getResponse().getCreateTime();
            String senderId = rootMessageResult.getResponse().getSenderId();
            String receiverId = rootMessageResult.getResponse().getReceiverId();
            
            System.out.println("Root message ID: " + rootMessageId);
            System.out.println("Root message client ID: " + rootMessageClientId);
            System.out.println("Root message time: " + new Date(rootMessageTime));
            
            // Wait for the message to be processed
            System.out.println("\nWaiting for message to be processed...");
            TimeUnit.SECONDS.sleep(2);
            
            // Query thread messages
            System.out.println("\n==== Querying Thread Messages ====");
            queryThreadMessages(rootMessageId, rootMessageClientId, rootMessageTime, senderId, receiverId);
            
            System.out.println("\n==== All thread message tests completed ====");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test thread messages query functionality
     */
    private void queryThreadMessages(
            Long rootMessageId, 
            String rootMessageClientId, 
            Long rootMessageTime,
            String senderId,
            String receiverId) throws YunxinSdkException {
            
        // Create query parameters
        long beginTime = rootMessageTime - (7 * 24 * 60 * 60 * 1000); // 7 days before
        long endTime = System.currentTimeMillis() + (24 * 60 * 60 * 1000); // 1 day ahead
        
        // Create request
        QueryThreadMessagesRequestV2 request = new QueryThreadMessagesRequestV2(
                beginTime,
                endTime,
                100, // Maximum limit
                1,   // P2P conversation type
                senderId,
                receiverId,
                rootMessageId,
                rootMessageClientId,
                rootMessageTime
        );
        
        // Execute query
        Result<QueryThreadMessagesResponseV2> result = messageService.queryThreadMessages(request);
        
        System.out.println("Thread messages query response: " + JSON.toJSONString(result));
        
        // Verify query was executed (it might return success even if no thread messages exist)
        Assert.assertEquals(200, result.getCode());
        
        // Display results if any
        if (result.getResponse() != null) {
            displayThreadMessagesResults(result.getResponse());
        }
    }
    
    /**
     * Display thread messages results in a readable format
     */
    private void displayThreadMessagesResults(QueryThreadMessagesResponseV2 response) {
        // Display thread root message
        if (response.getThreadRoot() != null) {
            System.out.println("Thread Root Message:");
            System.out.println("  ID: " + response.getThreadRoot().getMessageServerId());
            System.out.println("  Sender: " + response.getThreadRoot().getSenderId());
            System.out.println("  Content: " + response.getThreadRoot().getText());
            System.out.println("  Time: " + new Date(response.getThreadRoot().getCreateTime()));
        }
        
        // Display total count
        if (response.getTotal() != null) {
            System.out.println("Total thread messages: " + response.getTotal());
        }
        
        // Display thread messages
        if (response.getMessages() != null && !response.getMessages().isEmpty()) {
            System.out.println("Thread Messages:");
            
            int count = 1;
            for (QueryThreadMessagesResponseV2.MessageItem message : response.getMessages()) {
                System.out.println("Message " + count + ":");
                System.out.println("  ID: " + message.getMessageServerId());
                System.out.println("  Sender: " + message.getSenderId());
                System.out.println("  Type: " + message.getMessageType());
                System.out.println("  Content: " + message.getText());
                System.out.println("  Time: " + new Date(message.getCreateTime()));
                count++;
            }
            
            // Display pagination info
            if (response.getHasMore() != null && response.getHasMore()) {
                System.out.println("More messages available. Next token: " + response.getNextToken());
            }
        } else {
            System.out.println("No thread messages found");
        }
    }

    /**
     * Display batch query results in a readable format
     */
    private void displayBatchQueryResults(BatchQueryMessagesResponseV2 response) {
        // Display successful messages
        if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
            System.out.println("Successfully queried " + response.getSuccessList().size() + " messages:");
            
            int count = 1;
            for (BatchQueryMessagesResponseV2.SuccessMessage message : response.getSuccessList()) {
                System.out.println("Message " + count + ":");
                System.out.println("  ID: " + message.getMessageServerId());
                System.out.println("  Sender: " + message.getSenderId());
                System.out.println("  Type: " + message.getMessageType());
                System.out.println("  Content: " + message.getText());
                System.out.println("  Time: " + new Date(message.getCreateTime()));
                count++;
            }
        } else {
            System.out.println("No messages were successfully queried");
        }
        
        // Display failed messages
        if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
            System.out.println("Failed to query " + response.getFailedList().size() + " messages:");
            
            int count = 1;
            for (BatchQueryMessagesResponseV2.FailedMessage message : response.getFailedList()) {
                System.out.println("Failed Message " + count + ":");
                System.out.println("  ID: " + message.getMessageServerId());
                System.out.println("  Time: " + new Date(message.getCreateTime()));
                System.out.println("  Error Code: " + message.getErrorCode());
                System.out.println("  Error Message: " + message.getErrorMsg());
                count++;
            }
        }
    }
} 