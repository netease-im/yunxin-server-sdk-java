package com.netease.nim.im.server.sdk.test.v1;


import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v1.YunxinV1ApiServices;
import com.netease.nim.server.sdk.im.v1.account.IAccountV1Service;
import com.netease.nim.server.sdk.im.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.server.sdk.im.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.server.sdk.im.v1.chatroom_message.IChatroomMessageV1Service;
import com.netease.nim.server.sdk.im.v1.chatroom_message.request.*;
import com.netease.nim.server.sdk.im.v1.chatroom_message.response.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TestChatroomMessageV1 {
    private static YunxinV1ApiServices services;
    private static IChatroomMessageV1Service chatroomMessageService;
    private static final long roomId = 10908439525L;
    
    // Dynamic account IDs for testing
    private static final String fromAccid = "yx_test_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    private static final String toAccid1 = "yx_test_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    private static final String toAccid2 = "yx_test_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);

    @BeforeClass
    public static void setup() {
        if (chatroomMessageService != null) {
            return;
        }

        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }

        services = new YunxinV1ApiServices(client);
        chatroomMessageService = services.getChatroomMessageV1Service();
        
        // Create test accounts
        createAccount(fromAccid);
        createAccount(toAccid1);
        createAccount(toAccid2);
    }
    
    /**
     * Helper method to create a test account
     * 
     * @param accid the account ID to create
     */
    private static void createAccount(String accid) {
        try {
            CreateAccountRequestV1 request = new CreateAccountRequestV1();
            request.setAccid(accid);
            request.setName("user-" + accid.substring(0, 6));
            request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            
            IAccountV1Service accountService = services.getAccountService();
            Result<CreateAccountResponseV1> result = accountService.createAccount(request);
            
            // 如果账号已存在，不视为错误
            if (result.getCode() == 414) {
                System.out.println("Account " + accid + " already exists");
            } else {
                Assert.assertEquals("Failed to create account: " + result.getMsg(), 200, result.getCode());
                Assert.assertEquals(request.getAccid(), result.getResponse().getAccid());
                System.out.println("Created account: " + accid);
            }
        } catch (Exception e) {
            System.err.println("Error creating account " + accid + ": " + e.getMessage());
        }
    }

    @Test
    public void testSendMsg() throws YunxinSdkException {
        if (chatroomMessageService == null) return;
        SendChatroomMsgResponseV1 response = sendMsg();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getMsgid_client());
    }
    
    @Test
    public void testRecall() throws YunxinSdkException {
        if (chatroomMessageService == null) return;
        SendChatroomMsgResponseV1 msg = sendMsg();
        recall(msg.getMsgid_client(), msg.getTime());
    }
    
    @Test
    public void testBatchSendMsg() throws YunxinSdkException {
        if (chatroomMessageService == null) return;
        batchSendMsg();
    }
    
    @Test
    public void testSendMsgToSomeone() throws YunxinSdkException {
        if (chatroomMessageService == null) return;
        sendMsgToSomeone();
    }
    
    @Test
    public void testBatchSendMsgToSomeone() throws YunxinSdkException {
        if (chatroomMessageService == null) return;
        batchSendMsgToSomeone();
    }
    
    @Test
    public void testBroadcast() throws YunxinSdkException {
        if (chatroomMessageService == null) return;
        broadcast();
    }

    private static SendChatroomMsgResponseV1 sendMsg() throws YunxinSdkException {
        SendChatroomMsgRequestV1 request = new SendChatroomMsgRequestV1();
        request.setRoomId(roomId);
        request.setMsgId(UUID.randomUUID().toString());
        request.setAttach("This is the message content."); // Message content
        request.setFromAccid(fromAccid);
        request.setIgnoreMute(false);
        request.setMsgType(0);
        request.setSubType(1);
        request.setResendFlag(0);
        request.setExt("{\"key\":\"value\"}");
        request.setRoute(1);
        request.setSkipHistory(0);
        request.setAbandonRatio(0);
        request.setHighPriority(true);
        request.setNeedHighPriorityMsgResend(false);
        request.setUseYidun(1);
        request.setYidunAntiCheating("{\"antiCheating\":\"data\"}");
        request.setYidunAntiSpamExt("{\"antiSpam\":\"data\"}");
        request.setBid("business-id-123");
        request.setAntispam(true);
        request.setNotifyTargetTags("{\"tag\": \"abc\"} or {\"tag\": \"def\"}");
        request.setAntispamCustom("{\"customSpam\":\"data\"}");
        request.setEnv("production");
        request.setChatMsgPriority(1);
        request.setForbiddenIfHighPriorityMsgFreq(0);
        request.setLocX(12.34);
        request.setLocY(56.78);
        request.setLocZ(90.12);

        Result<SendChatroomMsgResponseV1> result = chatroomMessageService.sendMsg(request);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.err.println("**SendMsg**" + JSON.toJSONString(result.getResponse()));
        return result.getResponse();
    }

    private static void batchSendMsg() throws YunxinSdkException {
        BatchSendChatroomMsgRequestV1 batchSendRequest = new BatchSendChatroomMsgRequestV1();

        batchSendRequest.setRoomId(roomId);
        batchSendRequest.setFromAccid(fromAccid); // Sender's account ID
        batchSendRequest.setIgnoreMute(false); // Do not ignore mute
        batchSendRequest.setSkipHistory(0); // Do not skip history
        batchSendRequest.setRoute(1); // Message routing
        batchSendRequest.setAbandonRatio(0); // No message discard
        batchSendRequest.setHighPriority(true); // High priority message
        batchSendRequest.setNeedHighPriorityMsgResend(false); // No need for high priority resend
        batchSendRequest.setUseYidun(1); // Use Yidun for security
        batchSendRequest.setYidunAntiCheating("{\"antiCheating\":\"data\"}"); // Anti-cheating parameters
        batchSendRequest.setYidunAntiSpamExt("{\"antiSpam\":\"data\"}"); // Anti-spam parameters
        batchSendRequest.setBid("business-id-123"); // Custom anti-spam business ID
        batchSendRequest.setAntispam(true); // Enable anti-spam
        batchSendRequest.setNotifyTargetTags("{\"tag\": \"abc\"} or {\"tag\": \"def\"}"); // Target tags for notification
        batchSendRequest.setAntispamCustom("{\"customSpam\":\"data\"}"); // Custom anti-spam content
        batchSendRequest.setEnv("production"); // Environment name
        batchSendRequest.setChatMsgPriority(1); // Chat message priority
        batchSendRequest.setForbiddenIfHighPriorityMsgFreq(0); // No frequency control for high priority

        // Create a list of messages
        List<BatchSendChatroomMsgRequestV1.Message> messages = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BatchSendChatroomMsgRequestV1.Message message = new BatchSendChatroomMsgRequestV1.Message();
            message.setMsgId(("msg-uuid-" + i + UUID.randomUUID().toString()).replaceAll("-", ""));
            message.setMsgType(0);
            message.setAttach("This is message content " + i);
            message.setExt("{\"key\":\"value\"}");
            message.setSubType(1);
            message.setResendFlag(0);
            message.setLocX(12.34 + i);
            message.setLocY(56.78 + i);
            message.setLocZ(90.12 + i);
            messages.add(message);
        }
        batchSendRequest.setMsgList(messages);
        Result<BatchSendChatroomMsgResponseV1> result = chatroomMessageService.batchSendMsg(batchSendRequest);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.err.println("**BatchSendMsg**" + JSON.toJSONString(result.getResponse()));
    }

    private static void recall(String msgId, long time) throws YunxinSdkException {
        RecallChatroomMsgRequestV1 recallRequest = new RecallChatroomMsgRequestV1();
        recallRequest.setFromAcc(fromAccid);
        recallRequest.setMsgId(msgId);
        recallRequest.setMsgTimetag(time);
        recallRequest.setNotifyExt("xxxxx");
        recallRequest.setOperatorAcc(fromAccid);
        recallRequest.setRoomId(roomId);
        Result<RecallChatroomMsgResponseV1> result = chatroomMessageService.recall(recallRequest);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.err.println("**testRecall**" + JSON.toJSONString(result.getResponse()));
    }

    private static void sendMsgToSomeone() throws YunxinSdkException {
        ChatroomTargetMsgRequestV1 targetMsgRequest = new ChatroomTargetMsgRequestV1();
        targetMsgRequest.setRoomId(roomId); // Chatroom ID
        targetMsgRequest.setMsgId("msg-uuid-" + UUID.randomUUID().toString().replaceAll("-", "")); // Message ID (UUID)
        targetMsgRequest.setAttach("This is the message content."); // Message content
        targetMsgRequest.setFromAccid(fromAccid); // Sender's account ID
        targetMsgRequest.setToAccids(Arrays.asList(toAccid1, toAccid2));
        targetMsgRequest.setMsgType(0);
        targetMsgRequest.setSubType(1);
        targetMsgRequest.setResendFlag(0);
        targetMsgRequest.setRoute(1);
        targetMsgRequest.setExt("{\"key\":\"value\"}");
        targetMsgRequest.setUseYidun(1); // Use Yidun for security
        targetMsgRequest.setYidunAntiCheating("{\"antiCheating\":\"data\"}"); // Anti-cheating parameters
        targetMsgRequest.setYidunAntiSpamExt("{\"antiSpam\":\"data\"}"); // Anti-spam parameters
        targetMsgRequest.setBid("business-id-123"); // Custom anti-spam business ID
        targetMsgRequest.setAntispam(true); // Enable anti-spam
        targetMsgRequest.setAntispamCustom("{\"customSpam\":\"data\"}"); // Custom anti-spam content
        targetMsgRequest.setEnv("production"); // Environment name
        Result<ChatroomTargetMsgResponseV1> result = chatroomMessageService.sendMsgToSomeone(targetMsgRequest);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.err.println("**SendMsgToSomeone**" + JSON.toJSONString(result.getResponse()));
    }

    /**
     * Helper method for batch sending of targeted chatroom messages
     */
    private static void batchSendMsgToSomeone() throws YunxinSdkException {
        System.out.println("\n==== Testing Batch Send Chatroom Target Messages ====");
        
        BatchChatroomTargetMsgRequestV1 batchChatroomRequest = new BatchChatroomTargetMsgRequestV1();
        batchChatroomRequest.setRoomId(roomId); // Chatroom ID
        batchChatroomRequest.setFromAccid(fromAccid); // Sender's account ID
        batchChatroomRequest.setToAccids(Arrays.asList(toAccid1, toAccid2)); // Recipients' account IDs
        batchChatroomRequest.setRoute(1); // Message routing: 1 = need to copy
        batchChatroomRequest.setUseYidun(0); // Don't use Yidun security
        batchChatroomRequest.setYidunAntiCheating("{\"antiCheating\":\"data\"}"); // Anti-cheating parameters
        batchChatroomRequest.setYidunAntiSpamExt("{\"antiSpam\":\"data\"}"); // Anti-spam parameters
        batchChatroomRequest.setBid("business-id-123"); // Custom anti-spam business ID
        batchChatroomRequest.setAntispam(true); // Enable anti-spam
        batchChatroomRequest.setAntispamCustom("{\"type\":1,\"data\":\"custom content\"}"); // Custom anti-spam content
        batchChatroomRequest.setEnv("production"); // Environment name

        // Create a list of messages
        List<BatchChatroomTargetMsgRequestV1.Message> messages = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BatchChatroomTargetMsgRequestV1.Message message = new BatchChatroomTargetMsgRequestV1.Message();
            message.setMsgId(UUID.randomUUID().toString().replaceAll("-", ""));
            message.setMsgType(i % 2 == 0 ? 0 : 100); // Alternate between text and custom messages
            message.setAttach(i % 2 == 0 ? "This is text message " + i : "{\"msg\":\"This is custom message " + i + "\"}");
            message.setExt("{\"key" + i + "\":\"value" + i + "\"}");
            message.setSubType(i + 1);
            message.setResendFlag(i == 1 ? 1 : 0); // Set one message as a resend message
            messages.add(message);
        }
        batchChatroomRequest.setMsgList(messages);
        
        System.out.println("Request details:");
        System.out.println("  Room ID: " + batchChatroomRequest.getRoomId());
        System.out.println("  From: " + batchChatroomRequest.getFromAccid());
        System.out.println("  To: " + batchChatroomRequest.getToAccids());
        System.out.println("  Messages: " + messages.size());
        
        Result<BatchChatroomTargetMsgResponseV1> result = chatroomMessageService.batchSendMsgToSomeone(batchChatroomRequest);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        
        System.out.println("Response details:");
        System.out.println("  Code: " + result.getCode());
        
        if (result.getResponse().getFailList() != null && !result.getResponse().getFailList().isEmpty()) {
            System.out.println("  Failed messages: " + result.getResponse().getFailList().size());
            for (BatchChatroomTargetMsgResponseV1.FailedMessage failed : result.getResponse().getFailList()) {
                System.out.println("    Message ID: " + failed.getClientMsgId() + ", Reason: " + failed.getReason());
            }
        } else {
            System.out.println("  No failed messages");
        }
        
        if (result.getResponse().getSuccessList() != null && !result.getResponse().getSuccessList().isEmpty()) {
            System.out.println("  Successful messages: " + result.getResponse().getSuccessList().size());
            for (ChatroomTargetMsgResponseV1 success : result.getResponse().getSuccessList()) {
                System.out.println("    Message ID: " + success.getMsgidClient() + ", Time: " + success.getTime());
            }
        } else {
            System.out.println("  No successful messages");
        }
        
        System.out.println("==== Batch Send Chatroom Target Messages Test Completed ====\n");
    }

    private static void broadcast() throws YunxinSdkException {
        ChatroomBroadcastRequestV1 broadcastRequest = new ChatroomBroadcastRequestV1();
        broadcastRequest.setMsgId(UUID.randomUUID().toString());
        broadcastRequest.setFromAccid(fromAccid);
        broadcastRequest.setMsgType(0);
        broadcastRequest.setAttach("This is the broadcast message content.");
        broadcastRequest.setSubType(1);
        broadcastRequest.setResendFlag(0);
        broadcastRequest.setRoute(1);
        broadcastRequest.setExt("{\"key\":\"value\"}");
        broadcastRequest.setUseYidun(1);
        broadcastRequest.setYidunAntiCheating("{\"antiCheating\":\"data\"}");
        broadcastRequest.setBid("business-id-123");
        broadcastRequest.setAntispam(true);
        broadcastRequest.setAntispamCustom("{\"customSpam\":\"data\"}");
        broadcastRequest.setNotifyTargetTags("{\"tag\": \"abc\"} or {\"tag\": \"def\"}");
        broadcastRequest.setEnv("production");
        Result<SendChatroomMsgResponseV1> result = chatroomMessageService.broadcast(broadcastRequest);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.err.println("**Broadcast**" + JSON.toJSONString(result.getResponse()));
    }
}