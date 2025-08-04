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
import com.netease.nim.server.sdk.im.v2.message.IMessageV2Service;
import com.netease.nim.server.sdk.im.v2.message.request.AddQuickCommentRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.BatchQueryQuickCommentsRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.DeleteQuickCommentRequestV2;
import com.netease.nim.server.sdk.im.v2.message.request.SendMessageRequestV2;
import com.netease.nim.server.sdk.im.v2.message.response.AddQuickCommentResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.BatchQueryQuickCommentsResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.DeleteQuickCommentResponseV2;
import com.netease.nim.server.sdk.im.v2.message.response.SendMessageResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for the quick comment functionality
 */
public class TestQuickCommentV2 {

    private static YunxinV2ApiServices services;
    private static String senderId;
    private static String receiverId;
    private static String conversationId;
    private static Long messageServerId;
    private static String messageClientId;
    private static Long createTime;
    private static String anotherUserId;

    @BeforeClass
    public static void setup() throws Exception {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
                
        services = new YunxinV2ApiServices(client);

        // Create test accounts
        senderId = createAccount("sender" + System.currentTimeMillis());
        receiverId = createAccount("receiver" + System.currentTimeMillis());
        anotherUserId = createAccount("another" + System.currentTimeMillis());
        
        // Create conversation ID for P2P chat
        conversationId = formatConversationId(senderId, 1, receiverId);
        
        // Send a test message to add comments to
        System.out.println("Sending a test message to add quick comments to...");
        SendMessageRequestV2 sendRequest = SendMessageRequestV2.createTextMessage(
                conversationId, 
                "This message will have quick comments added to it - " + System.currentTimeMillis()
        );
        
        IMessageV2Service messageService = services.getMessageService();
        Result<SendMessageResponseV2> sendResult = messageService.sendMessage(sendRequest);
        
        Assert.assertTrue("Failed to send test message: " + sendResult.getMsg(), sendResult.isSuccess());
        Assert.assertNotNull(sendResult.getResponse());
        
        // 保存从消息响应中获取的服务器ID和创建时间，后面使用
        messageServerId = sendResult.getResponse().getMessageServerId();
        messageClientId = sendResult.getResponse().getMessageClientId();
        createTime = sendResult.getResponse().getCreateTime();
        
        System.out.println("Test message sent successfully:");
        System.out.println("  Message Server ID: " + messageServerId);
        System.out.println("  Message Client ID: " + messageClientId);
        System.out.println("  Create Time: " + createTime);
    }
    
    /**
     * Creates a test account with the given ID
     */
    private static String createAccount(String accountId) throws YunxinSdkException {
        if (services == null) {
            return null;
        }
        
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        
        // Create and set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName("Test User " + accountId);
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        Assert.assertTrue("Failed to create account: " + result.getMsg(), result.isSuccess());
        
        return accountId;
    }
    
    /**
     * Format conversation ID based on conversation type and participants
     */
    private static String formatConversationId(String accountId1, int type, String accountId2) {
        return accountId1 + "|" + type + "|" + accountId2;
    }
    
    @Test
    public void testBasicQuickComment() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        IMessageV2Service messageService = services.getMessageService();
        
        System.out.println("\n===== 测试1：基本快捷评论功能 - 添加评论 =====");
        
        // 创建消息对象 - 使用消息响应中返回的服务器ID和客户端ID
        AddQuickCommentRequestV2.Message message = new AddQuickCommentRequestV2.Message(
                1,  // 会话类型：单聊
                senderId,  
                receiverId, 
                messageServerId, 
                messageClientId, 
                createTime
        );
        
        // 创建请求
        AddQuickCommentRequestV2 request = new AddQuickCommentRequestV2(
                senderId, // 操作者ID (此处与发送者相同)
                1L, // 评论类型索引 (例如: 1表示点赞)
                message
        );
        
        // 可选: 添加扩展信息，注意长度必须在1-8之间
        request.setExtension("like");
        
        // 可选: 配置推送通知
        AddQuickCommentRequestV2.PushConfig pushConfig = new AddQuickCommentRequestV2.PushConfig(
                true, 
                senderId + " 对你的消息做出了回应", 
                "{\"type\":\"quick_comment\",\"index\":1}"
        );
        request.setPushConfig(pushConfig);
        
        // 调用添加快捷评论方法
        Result<AddQuickCommentResponseV2> result = messageService.addQuickComment(request);
        
        System.out.println("添加快捷评论响应: " + JSON.toJSONString(result));
        
        // 验证响应
        Assert.assertTrue("添加快捷评论失败: " + result.getMsg(), result.isSuccess());
        Assert.assertNotNull(result.getResponse());
        Assert.assertNotNull(result.getResponse().getTime());
        
        System.out.println("快捷评论添加成功:");
        System.out.println("  时间戳: " + result.getResponse().getTime());
        
        // 添加另一个不同类型的评论以便稍后进行批量查询
        AddQuickCommentRequestV2 request1b = new AddQuickCommentRequestV2(
                senderId,
                2L,  // 不同的评论类型
                new AddQuickCommentRequestV2.Message(
                        1, senderId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        request1b.setExtension("love");
        
        Result<AddQuickCommentResponseV2> result1b = messageService.addQuickComment(request1b);
        Assert.assertTrue("添加第二个快捷评论失败: " + result1b.getMsg(), result1b.isSuccess());
        System.out.println("第二个快捷评论添加成功，时间戳: " + result1b.getResponse().getTime());
        
        System.out.println("\n===== 测试2：基本快捷评论功能 - 删除评论 =====");
        
        // 创建删除评论请求
        DeleteQuickCommentRequestV2.Message deleteMessage = new DeleteQuickCommentRequestV2.Message(
                1,  // 会话类型：单聊
                senderId,  
                receiverId, 
                messageServerId, 
                messageClientId, 
                createTime
        );
        
        DeleteQuickCommentRequestV2 deleteRequest = new DeleteQuickCommentRequestV2(
                senderId,
                1L,  // 与添加时相同的评论索引
                deleteMessage
        );
        
        // 删除评论
        Result<DeleteQuickCommentResponseV2> deleteResult = messageService.deleteQuickComment(deleteRequest);
        
        System.out.println("删除快捷评论响应: " + JSON.toJSONString(deleteResult));
        
        // 验证响应
        Assert.assertTrue("删除快捷评论失败: " + deleteResult.getMsg(), deleteResult.isSuccess());
        Assert.assertNotNull(deleteResult.getResponse());
        Assert.assertNotNull(deleteResult.getResponse().getTime());
        
        System.out.println("快捷评论删除成功:");
        System.out.println("  时间戳: " + deleteResult.getResponse().getTime());
    }
    
    @Test
    public void testDifferentCommentTypes() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        IMessageV2Service messageService = services.getMessageService();
        
        System.out.println("\n===== 测试3：使用不同评论类型 =====");
        
        // 添加不同类型的评论
        Long commentIndex2 = 2L;
        
        AddQuickCommentRequestV2 request2 = new AddQuickCommentRequestV2(
                senderId, 
                commentIndex2, // 不同的评论类型索引 (例如: 2表示爱心)
                new AddQuickCommentRequestV2.Message(
                        1, senderId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        
        // 使用短扩展字符串（1-8个字符）
        request2.setExtension("heart");
        
        // 添加评论
        Result<AddQuickCommentResponseV2> result2 = messageService.addQuickComment(request2);
        
        System.out.println("添加不同类型快捷评论响应: " + JSON.toJSONString(result2));
        
        // 验证响应
        Assert.assertTrue("添加不同类型快捷评论失败: " + result2.getMsg(), result2.isSuccess());
        Assert.assertNotNull(result2.getResponse());
        Assert.assertNotNull(result2.getResponse().getTime());
        
        System.out.println("不同类型快捷评论添加成功:");
        System.out.println("  时间戳: " + result2.getResponse().getTime());
        
        // 删除不同类型的评论
        DeleteQuickCommentRequestV2 deleteRequest2 = new DeleteQuickCommentRequestV2(
                senderId,
                commentIndex2,
                new DeleteQuickCommentRequestV2.Message(
                        1, senderId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        
        deleteRequest2.setExtension("heart");
        
        // 删除评论
        Result<DeleteQuickCommentResponseV2> deleteResult2 = messageService.deleteQuickComment(deleteRequest2);
        
        System.out.println("删除不同类型快捷评论响应: " + JSON.toJSONString(deleteResult2));
        
        // 验证响应
        Assert.assertTrue("删除不同类型快捷评论失败: " + deleteResult2.getMsg(), deleteResult2.isSuccess());
        System.out.println("不同类型快捷评论删除成功:");
        System.out.println("  时间戳: " + deleteResult2.getResponse().getTime());
    }
    
    @Test
    public void testOtherUserComments() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        IMessageV2Service messageService = services.getMessageService();
        
        System.out.println("\n===== 测试4：其他用户添加和删除评论 =====");
        
        // 由另一个用户添加评论
        AddQuickCommentRequestV2 request3 = new AddQuickCommentRequestV2(
                anotherUserId, // 不同的操作者ID
                3L, // 评论类型索引
                new AddQuickCommentRequestV2.Message(
                        1, anotherUserId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        
        request3.setExtension("wow");
        
        // 添加评论
        Result<AddQuickCommentResponseV2> result3 = messageService.addQuickComment(request3);
        
        System.out.println("不同用户添加快捷评论响应: " + JSON.toJSONString(result3));
        Assert.assertTrue("不同用户添加快捷评论失败: " + result3.getMsg(), result3.isSuccess());
        Assert.assertNotNull(result3.getResponse());
        
        System.out.println("不同用户添加快捷评论成功:");
        System.out.println("  时间戳: " + result3.getResponse().getTime());
        
        // 由同一个用户删除评论
        DeleteQuickCommentRequestV2 deleteRequest3 = new DeleteQuickCommentRequestV2(
                anotherUserId,
                3L,
                new DeleteQuickCommentRequestV2.Message(
                        1, anotherUserId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        
        deleteRequest3.setExtension("wow");
        
        // 删除评论
        Result<DeleteQuickCommentResponseV2> deleteResult3 = messageService.deleteQuickComment(deleteRequest3);
        
        System.out.println("不同用户删除快捷评论响应: " + JSON.toJSONString(deleteResult3));
        
        // 验证响应
        Assert.assertTrue("不同用户删除快捷评论失败: " + deleteResult3.getMsg(), deleteResult3.isSuccess());
        System.out.println("不同用户快捷评论删除成功:");
        System.out.println("  时间戳: " + deleteResult3.getResponse().getTime());
    }
    
    @Test
    public void testCommentWithPushConfig() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        IMessageV2Service messageService = services.getMessageService();
        
        System.out.println("\n===== 测试5：带有推送配置的评论 =====");
        
        // 添加带有推送配置的评论
        AddQuickCommentRequestV2 request4 = new AddQuickCommentRequestV2(
                senderId,
                4L,
                new AddQuickCommentRequestV2.Message(
                        1, senderId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        
        // 短扩展字符串
        request4.setExtension("haha");
        
        // 设置推送配置
        AddQuickCommentRequestV2.PushConfig pushConfig4 = new AddQuickCommentRequestV2.PushConfig(
                true,
                senderId + " 添加了表情",
                "{\"type\":\"add\",\"index\":4}"
        );
        request4.setPushConfig(pushConfig4);
        
        // 添加评论
        Result<AddQuickCommentResponseV2> result4 = messageService.addQuickComment(request4);
        
        System.out.println("带推送配置的快捷评论响应: " + JSON.toJSONString(result4));
        Assert.assertTrue("带推送配置的快捷评论添加失败: " + result4.getMsg(), result4.isSuccess());
        Assert.assertNotNull(result4.getResponse());
        
        System.out.println("带推送配置的快捷评论添加成功:");
        System.out.println("  时间戳: " + result4.getResponse().getTime());
        
        // 删除带推送配置的评论
        DeleteQuickCommentRequestV2 deleteRequest4 = new DeleteQuickCommentRequestV2(
                senderId,
                4L,
                new DeleteQuickCommentRequestV2.Message(
                        1, senderId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        
        // 短扩展字符串
        deleteRequest4.setExtension("haha");
        
        // 设置推送配置
        DeleteQuickCommentRequestV2.PushConfig pushConfig4Delete = new DeleteQuickCommentRequestV2.PushConfig(
                true,
                senderId + " 删除了表情",
                "{\"type\":\"del\",\"index\":4}"
        );
        deleteRequest4.setPushConfig(pushConfig4Delete);
        
        // 删除评论
        Result<DeleteQuickCommentResponseV2> deleteResult4 = messageService.deleteQuickComment(deleteRequest4);
        
        System.out.println("删除带推送配置的快捷评论响应: " + JSON.toJSONString(deleteResult4));
        
        // 验证响应
        Assert.assertTrue("删除带推送配置的快捷评论失败: " + deleteResult4.getMsg(), deleteResult4.isSuccess());
        System.out.println("带推送配置的快捷评论删除成功:");
        System.out.println("  时间戳: " + deleteResult4.getResponse().getTime());
    }
    
    @Test
    public void testBatchQueryQuickComments() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        IMessageV2Service messageService = services.getMessageService();
        
        System.out.println("\n===== 测试6：批量查询快捷评论 =====");
        
        // 首先添加一些评论，以便后续批量查询
        // 添加第一个评论
        AddQuickCommentRequestV2 addRequest6a = new AddQuickCommentRequestV2(
                senderId,
                5L,
                new AddQuickCommentRequestV2.Message(
                        1, senderId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        addRequest6a.setExtension("emoji1");
        
        Result<AddQuickCommentResponseV2> addResult6a = messageService.addQuickComment(addRequest6a);
        Assert.assertTrue("添加第一个查询测试评论失败: " + addResult6a.getMsg(), addResult6a.isSuccess());
        
        // 添加第二个评论 - 使用不同用户
        AddQuickCommentRequestV2 addRequest6b = new AddQuickCommentRequestV2(
                anotherUserId,
                6L,
                new AddQuickCommentRequestV2.Message(
                        1, anotherUserId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        addRequest6b.setExtension("emoji2");
        
        Result<AddQuickCommentResponseV2> addResult6b = messageService.addQuickComment(addRequest6b);
        Assert.assertTrue("添加第二个查询测试评论失败: " + addResult6b.getMsg(), addResult6b.isSuccess());
        
        // 准备批量查询请求
        BatchQueryQuickCommentsRequestV2 batchQueryRequest = new BatchQueryQuickCommentsRequestV2();
        
        // 添加要查询的消息
        BatchQueryQuickCommentsRequestV2.Message queryMessage = new BatchQueryQuickCommentsRequestV2.Message(
                1, // 会话类型：单聊
                senderId,
                receiverId,
                messageServerId,
                messageClientId,
                createTime
        );
        batchQueryRequest.addMessage(queryMessage);
        
        // 可以添加多条消息进行批量查询（这里只是示例，实际查询的是同一条消息）
        // 在真实场景中，通常会查询不同的消息
        if (false) { // 将此条件改为 true 以测试查询多条消息
            // 发送第二条测试消息
            SendMessageRequestV2 sendRequest2 = SendMessageRequestV2.createTextMessage(
                    conversationId, 
                    "Second test message - " + System.currentTimeMillis()
            );
            
            Result<SendMessageResponseV2> sendResult2 = messageService.sendMessage(sendRequest2);
            Assert.assertTrue("发送第二条测试消息失败: " + sendResult2.getMsg(), sendResult2.isSuccess());
            
            // 为第二条消息添加评论
            AddQuickCommentRequestV2 addRequest6c = new AddQuickCommentRequestV2(
                    senderId,
                    7L,
                    new AddQuickCommentRequestV2.Message(
                            1, 
                            senderId, 
                            receiverId, 
                            sendResult2.getResponse().getMessageServerId(), 
                            sendResult2.getResponse().getMessageClientId(),
                            sendResult2.getResponse().getCreateTime()
                    )
            );
            addRequest6c.setExtension("emoji3");
            
            Result<AddQuickCommentResponseV2> addResult6c = messageService.addQuickComment(addRequest6c);
            Assert.assertTrue("添加第三个查询测试评论失败: " + addResult6c.getMsg(), addResult6c.isSuccess());
            
            // 添加第二条消息到批量查询请求
            BatchQueryQuickCommentsRequestV2.Message queryMessage2 = new BatchQueryQuickCommentsRequestV2.Message(
                    1,
                    senderId,
                    receiverId,
                    sendResult2.getResponse().getMessageServerId(),
                    sendResult2.getResponse().getMessageClientId(),
                    sendResult2.getResponse().getCreateTime()
            );
            batchQueryRequest.addMessage(queryMessage2);
        }
        
        // 执行批量查询请求
        Result<BatchQueryQuickCommentsResponseV2> batchQueryResult = messageService.batchQueryQuickComments(batchQueryRequest);
        
        System.out.println("批量查询快捷评论响应: " + JSON.toJSONString(batchQueryResult));
        
        // 验证响应
        Assert.assertTrue("批量查询快捷评论失败: " + batchQueryResult.getMsg(), batchQueryResult.isSuccess());
        Assert.assertNotNull(batchQueryResult.getResponse());
        
        // 验证成功查询列表
        Assert.assertNotNull(batchQueryResult.getResponse().getSuccessList());
        if (!batchQueryResult.getResponse().getSuccessList().isEmpty()) {
            BatchQueryQuickCommentsResponseV2.SuccessResult successResult = batchQueryResult.getResponse().getSuccessList().get(0);
            Assert.assertNotNull(successResult.getComments());
            System.out.println("成功查询到 " + successResult.getComments().size() + " 条评论");
            
            // 打印每条评论的详细信息
            for (BatchQueryQuickCommentsResponseV2.SuccessResult.Comment comment : successResult.getComments()) {
                System.out.println("  评论者: " + comment.getOperatorId());
                System.out.println("  评论类型: " + comment.getIndex());
                System.out.println("  扩展信息: " + comment.getExtension());
                System.out.println("  评论时间: " + comment.getTime());
                System.out.println("  ------");
            }
        }
        
        // 验证失败查询列表（如果有）
        if (batchQueryResult.getResponse().getFailedList() != null && !batchQueryResult.getResponse().getFailedList().isEmpty()) {
            System.out.println("查询失败的消息数: " + batchQueryResult.getResponse().getFailedList().size());
            for (BatchQueryQuickCommentsResponseV2.FailedResult failedResult : batchQueryResult.getResponse().getFailedList()) {
                System.out.println("  错误码: " + failedResult.getErrorCode());
                System.out.println("  错误信息: " + failedResult.getErrorMsg());
            }
        }
        
        // 清理测试数据 - 删除之前添加的评论
        DeleteQuickCommentRequestV2 deleteRequest6a = new DeleteQuickCommentRequestV2(
                senderId,
                5L,
                new DeleteQuickCommentRequestV2.Message(
                        1, senderId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        deleteRequest6a.setExtension("emoji1");
        messageService.deleteQuickComment(deleteRequest6a);
        
        DeleteQuickCommentRequestV2 deleteRequest6b = new DeleteQuickCommentRequestV2(
                anotherUserId,
                6L,
                new DeleteQuickCommentRequestV2.Message(
                        1, anotherUserId, receiverId, messageServerId, messageClientId, createTime
                )
        );
        deleteRequest6b.setExtension("emoji2");
        messageService.deleteQuickComment(deleteRequest6b);
    }
} 