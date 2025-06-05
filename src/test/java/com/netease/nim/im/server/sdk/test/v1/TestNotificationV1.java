package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v1.YunxinV1ApiServices;
import com.netease.nim.server.sdk.im.v1.account.IAccountV1Service;
import com.netease.nim.server.sdk.im.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.server.sdk.im.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.server.sdk.im.v1.team.ITeamV1Service;
import com.netease.nim.server.sdk.im.v1.team.request.CreateTeamRequestV1;
import com.netease.nim.server.sdk.im.v1.team.request.DismissTeamRequestV1;
import com.netease.nim.server.sdk.im.v1.team.response.CreateTeamResponseV1;
import com.netease.nim.server.sdk.im.v1.team.response.DismissTeamResponseV1;
import com.netease.nim.server.sdk.im.v1.system_notification.ISystemNotificationV1Service;
import com.netease.nim.server.sdk.im.v1.system_notification.request.SendAttachMsgRequestV1;
import com.netease.nim.server.sdk.im.v1.system_notification.request.SendBatchAttachMsgRequestV1;
import com.netease.nim.server.sdk.im.v1.system_notification.response.SendAttachMsgResponseV1;
import com.netease.nim.server.sdk.im.v1.system_notification.response.SendBatchAttachMsgResponseV1;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 系统通知功能测试类
 */
public class TestNotificationV1 {

    private static YunxinV1ApiServices services = null;
    private static ITeamV1Service teamService = null;
    private static ISystemNotificationV1Service notificationService = null;
    private static IAccountV1Service accountService = null;
    
    // 测试账号，使用动态生成的UUID避免冲突
    private static final String accid1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid3 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid4 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid5 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    
    // 群组ID和拥有者
    private static Long tid = null;
    private static String owner = null;

    /**
     * 测试前准备工作，创建测试资源
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
        services = new YunxinV1ApiServices(client);
        teamService = services.getTeamService();
        notificationService = services.getSystemNotificationService();
        accountService = services.getAccountService();
        
        // 创建测试账号
        createAccount(accid1);
        createAccount(accid2);
        createAccount(accid3);
        createAccount(accid4);
        createAccount(accid5);
        owner = accid1;
        
        // 创建群组
        CreateTeamRequestV1 request = new CreateTeamRequestV1();
        request.setOwner(owner);
        request.setTname("TestTeam-" + System.currentTimeMillis());
        request.setJoinMode(0);
        request.setMagree(0);
        request.setMsg("欢迎加入群聊");
        request.setMembers(Arrays.asList(accid2, accid3));
        
        Result<CreateTeamResponseV1> result = teamService.createTeam(request);
        Assert.assertTrue("Failed to create team: " + JSON.toJSONString(result), result.isSuccess());
        tid = result.getResponse().getTid();
        System.out.println("Created team with id: " + tid);
    }

    /**
     * 测试发送自定义系统通知（点对点）
     */
    @Test
    public void testSendPointToPointMsg() {
        if (notificationService == null) return;
        
        try {
            // 点对点系统通知
            SendAttachMsgRequestV1 request = new SendAttachMsgRequestV1();
            request.setFrom(accid1);
            request.setMsgType(0); // 点对点通知
            request.setTo(accid2);
            
            // 构建自定义内容，使用JSON格式
            JSONObject attachContent = new JSONObject();
            attachContent.put("type", "custom_notification");
            attachContent.put("data", "This is a test notification");
            attachContent.put("timestamp", System.currentTimeMillis());
            
            request.setAttach(attachContent.toJSONString());
            request.setPushContent("您收到一条测试通知");
            
            // 设置推送参数
            JSONObject payload = new JSONObject();
            payload.put("key1", "value1");
            payload.put("key2", "value2");
            request.setPayload(payload.toJSONString());
            
            // 设置选项
            JSONObject option = new JSONObject();
            option.put("badge", true);
            option.put("needPushNick", true);
            option.put("route", true);
            request.setOption(option.toJSONString());
            
            // 设置存离线
            request.setSave(2); // 存离线
            
            Result<SendAttachMsgResponseV1> result = notificationService.sendAttachMsg(request);
            Assert.assertTrue("Failed to send point-to-point message: " + result.getMsg(), result.isSuccess());
            System.out.println("**SendPointToPointMsg**" + JSON.toJSONString(result));
            
            // 如果有未注册的账号，会在响应中返回
            SendAttachMsgResponseV1 response = result.getResponse();
            if (response != null && response.getUnregister() != null && !response.getUnregister().isEmpty()) {
                System.out.println("Unregistered accounts: " + response.getUnregister());
            }
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to send point-to-point message: " + e.getMessage());
        }
    }
    
    /**
     * 测试发送群系统通知
     */
    @Test
    public void testSendTeamMsg() {
        if (notificationService == null) return;
        
        try {
            SendAttachMsgRequestV1 request = new SendAttachMsgRequestV1();
            request.setFrom(accid1);
            request.setMsgType(1); // 群通知
            request.setTo(tid.toString()); // 使用静态群组ID
            
            // 构建自定义内容
            JSONObject attachContent = new JSONObject();
            attachContent.put("type", "team_notification");
            attachContent.put("action", "team_update");
            attachContent.put("data", "Team information updated");
            attachContent.put("teamId", tid);
            
            request.setAttach(attachContent.toJSONString());
            request.setPushContent("群信息已更新");
            
            // 强制推送相关设置
            request.setIsForcePush(true);
            request.setForcePushContent("重要通知：群信息已更新");
            
            // 强制推送给指定用户
            request.setForcePushAll(false);
            request.setForcePushList(Arrays.asList(accid2, accid3));
            
            Result<SendAttachMsgResponseV1> result = notificationService.sendAttachMsg(request);
            Assert.assertTrue("Failed to send team message: " + result.getMsg(), result.isSuccess());
            System.out.println("**SendTeamMsg**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to send team message: " + e.getMessage());
        }
    }
    
    /**
     * 测试批量发送自定义系统通知
     */
    @Test
    public void testSendBatchMsg() {
        if (notificationService == null) return;
        
        try {
            SendBatchAttachMsgRequestV1 request = new SendBatchAttachMsgRequestV1();
            request.setFromAccid(accid1);
            
            // 设置接收者列表（最多5000人）
            List<String> toAccids = new ArrayList<>();
            toAccids.add(accid2);
            toAccids.add(accid3);
            toAccids.add(accid4);
            toAccids.add(accid5);
            request.setToAccids(toAccids);
            
            // 构建自定义内容，使用JSON格式
            JSONObject attachContent = new JSONObject();
            attachContent.put("type", "batch_notification");
            attachContent.put("data", "This is a batch notification");
            attachContent.put("timestamp", System.currentTimeMillis());
            
            request.setAttach(attachContent.toJSONString());
            request.setPushContent("您收到一条批量通知");
            
            // 设置推送参数
            JSONObject payload = new JSONObject();
            payload.put("key1", "value1");
            payload.put("key2", "value2");
            request.setPayload(payload.toJSONString());
            
            // 设置选项
            JSONObject option = new JSONObject();
            option.put("badge", true);
            option.put("needPushNick", true);
            option.put("route", true);
            request.setOption(option.toJSONString());
            
            // 设置存离线
            request.setSave(2); // 存离线
            
            // 设置强制推送
            request.setIsForcePush(true);
            request.setForcePushContent("重要通知：批量系统消息");
            
            Result<SendBatchAttachMsgResponseV1> result = notificationService.sendBatchAttachMsg(request);
            Assert.assertTrue("Failed to send batch message: " + result.getMsg(), result.isSuccess());
            System.out.println("**SendBatchMsg**" + JSON.toJSONString(result));
            
            // 如果有未注册的账号，会在响应中返回
            SendBatchAttachMsgResponseV1 response = result.getResponse();
            if (response != null && response.getUnregister() != null && !response.getUnregister().isEmpty()) {
                System.out.println("Unregistered accounts in batch send: " + response.getUnregister());
            }
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to send batch message: " + e.getMessage());
        }
    }
    
    /**
     * 测试结束后清理资源
     */
    @AfterClass
    public static void tearDown() {
        if (services == null) return;
        
        try {
            // 解散测试群组
            DismissTeamRequestV1 request = new DismissTeamRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            Result<DismissTeamResponseV1> result = teamService.dismissTeam(request);
            System.out.println("Dismissed team: " + JSON.toJSONString(result));
        } catch (Exception e) {
            System.err.println("Error dismissing team: " + e.getMessage());
        }
    }
    
    /**
     * 创建单个账号
     * 
     * @param accid 账号ID
     */
    private static void createAccount(String accid) {
        try {
            CreateAccountRequestV1 request = new CreateAccountRequestV1();
            request.setAccid(accid);
            request.setName("zhangsan-" + UUID.randomUUID());
            request.setEx("ex");
            request.setBirth("1970-01-01");
            request.setGender(1);
            request.setIcon("https://icon-xxx.jpg");
            request.setMobile("13811110000");
            request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            request.setSign("sign");
            request.setEmail("zhangsan@163.com");
            
            Result<CreateAccountResponseV1> result = accountService.createAccount(request);
            
            // 如果账号已存在，不视为错误
            if (result.getCode() == 414) {
                System.out.println("Account " + accid + " already exists");
            } else {
                Assert.assertEquals("Failed to create account: " + result.getMsg(), 200, result.getCode());
                CreateAccountResponseV1 response = result.getResponse();
                Assert.assertEquals(request.getAccid(), response.getAccid());
                Assert.assertEquals(request.getName(), response.getName());
                Assert.assertNotNull(response.getToken());
            }
        } catch (Exception e) {
            System.err.println("Error creating account " + accid + ": " + e.getMessage());
        }
    }
} 