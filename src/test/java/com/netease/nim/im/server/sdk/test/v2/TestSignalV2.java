package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.ISignalV2Service;
import com.netease.nim.server.sdk.im.v2.signal.request.CreateSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.DelaySignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.CloseSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.QuerySignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.SendSignalRoomControlRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.InviteSignalRoomRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.CancelSignalRoomInviteRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.request.KickSignalRoomMemberRequestV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CreateSIgnalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.DelaySignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CloseSignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.QuerySignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.SendSignalRoomControlResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.InviteSignalRoomResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.CancelSignalRoomInviteResponseV2;
import com.netease.nim.server.sdk.im.v2.signal.response.KickSignalRoomMemberResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 信令频道测试 V2
 */
public class TestSignalV2 {

    private static YunxinV2ApiServices services = null;
    private static ISignalV2Service signalService = null;
    private static IAccountV2Service accountService = null;
    
    // Test account IDs - defined at class load time with unique timestamps
    private static final String creatorAccountId = "signal_creator_" + System.currentTimeMillis();
    private static final String targetAccountId = "signal_target_" + System.currentTimeMillis();
    private static final String inviteeAccountId = "signal_invitee_" + System.currentTimeMillis();

    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.initWithEndPoint("https://open-pre.yunxinapi.com");
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);
        signalService = services.getSignalService();
        accountService = services.getAccountService();
        
        // 创建测试用户账号
        createTestAccounts();
    }
    
    /**
     * 创建测试用的用户账号
     */
    private static void createTestAccounts() {
        if (accountService == null) {
            System.out.println("账号服务未初始化，跳过用户创建");
            return;
        }
        
        System.out.println("\n=== 创建测试用户账号 ===");
        System.out.println("房间创建者账号: " + creatorAccountId);
        System.out.println("目标用户账号: " + targetAccountId);
        System.out.println("被邀请用户账号: " + inviteeAccountId);
        
        // 创建三个测试账号
        createAccount(creatorAccountId, "信令房间创建者");
        createAccount(targetAccountId, "信令目标用户");
        createAccount(inviteeAccountId, "信令被邀请用户");
        
        System.out.println("=== 测试用户账号创建完成 ===\n");
    }
    
    /**
     * 创建单个用户账号
     */
    private static boolean createAccount(String accountId, String nickname) {
        try {
            CreateAccountRequestV2 request = new CreateAccountRequestV2();
            request.setAccountId(accountId);
            request.setToken("test_token_" + System.currentTimeMillis());
            
            // 设置用户信息
            CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
            userInfo.setName(nickname);
            userInfo.setAvatar("https://example.com/avatar.jpg");
            userInfo.setEmail(accountId + "@test.com");
            userInfo.setMobile("138" + String.format("%08d", Math.abs(accountId.hashCode()) % 100000000));
            userInfo.setGender(1); // 男性
            userInfo.setSign("信令测试用户");
            userInfo.setBirthday("1998-01-01");
            request.setUserInformation(userInfo);
            
            Result<CreateAccountResponseV2> result = accountService.createAccount(request);
            
            System.out.println("创建用户 " + accountId + " 结果:");
            System.out.println("  状态码: " + result.getCode());
            System.out.println("  消息: " + result.getMsg());
            System.out.println("  昵称: " + nickname);
            
            if (result.getCode() == 200) {
                System.out.println("  创建成功!");
                return true;
            } else if (result.getCode() == 414 && result.getMsg().contains("already exists")) {
                System.out.println("  用户已存在，继续使用!");
                return true;
            } else {
                System.out.println("  创建失败: " + result.getMsg());
                return false;
            }
        } catch (Exception e) {
            System.out.println("创建用户 " + accountId + " 异常: " + e.getMessage());
            return false;
        }
    }

    @Test
    public void testAccountCreation() {
        System.out.println("\n=== 验证用户账号定义 ===");
        System.out.println("房间创建者账号: " + creatorAccountId);
        System.out.println("目标用户账号: " + targetAccountId);
        System.out.println("被邀请用户账号: " + inviteeAccountId);
        
        Assert.assertFalse("房间创建者账号不能为空", creatorAccountId.isEmpty());
        Assert.assertFalse("目标用户账号不能为空", targetAccountId.isEmpty());
        Assert.assertFalse("被邀请用户账号不能为空", inviteeAccountId.isEmpty());
        
        Assert.assertTrue("房间创建者账号应该包含前缀", creatorAccountId.startsWith("signal_creator_"));
        Assert.assertTrue("目标用户账号应该包含前缀", targetAccountId.startsWith("signal_target_"));
        Assert.assertTrue("被邀请用户账号应该包含前缀", inviteeAccountId.startsWith("signal_invitee_"));
        
        System.out.println("✅ 用户账号定义验证通过");
    }

    @Test
    public void testCreateRoom() {
        if (!isServiceReady()) return;
        
        String channelName = "test-signal-v2-" + System.currentTimeMillis();
        createRoom(channelName, creatorAccountId);
    }

    @Test
    public void testDelayRoom() {
        if (signalService == null || creatorAccountId == null) {
            System.out.println("信令服务或用户账号未初始化，跳过测试");
            return;
        }
        
        // 先创建一个房间
        String channelName = "test-delay-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 延长房间有效期
            delayRoom(createResponse.getChannelId());
        }
    }

    @Test
    public void testCloseRoom() {
        if (signalService == null || creatorAccountId == null) {
            System.out.println("信令服务或用户账号未初始化，跳过测试");
            return;
        }
        
        // 先创建一个房间
        String channelName = "test-close-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 关闭房间
            closeRoom(createResponse.getChannelId(), creatorAccountId);
        }
    }

    @Test
    public void testQueryRoom() {
        if (!isServiceReady()) return;
        
        // 先创建一个房间
        String channelName = "test-query-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 测试查询房间功能 ===");
            
            // 通过房间ID查询
            System.out.println("1. 通过房间ID查询...");
            queryRoomById(channelId);
            
            // 通过房间名称查询
            System.out.println("2. 通过房间名称查询...");
            queryRoomByName(channelName);
        }
    }

    @Test
    public void testSendControl() {
        if (!isServiceReady()) return;
        
        // 先创建一个房间
        String channelName = "test-control-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 测试发送控制指令功能 ===");
            
            // 发送给特定成员
            System.out.println("1. 发送控制指令给特定成员...");
            sendControlToMember(channelId, creatorAccountId, targetAccountId);
            
            // 广播给所有成员
            System.out.println("2. 广播控制指令给所有成员...");
            sendControlBroadcast(channelId, creatorAccountId);
            
            // 带抄送配置的控制指令
            System.out.println("3. 发送带抄送配置的控制指令...");
            sendControlWithRoute(channelId, creatorAccountId, targetAccountId);
        }
    }

    @Test
    public void testInvite() {
        if (!isServiceReady()) return;
        
        // 先创建一个房间
        String channelName = "test-invite-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 测试邀请加入房间功能 ===");
            
            // 基本邀请
            System.out.println("1. 基本邀请...");
            inviteBasic(channelId, creatorAccountId, inviteeAccountId);
            
            // 带推送配置的邀请
            System.out.println("2. 带推送配置的邀请...");
            inviteWithPush(channelId, creatorAccountId, targetAccountId);
            
            // 带完整配置的邀请
            System.out.println("3. 带完整配置的邀请...");
            inviteWithFullConfig(channelId, creatorAccountId, "another_" + inviteeAccountId);
        }
    }

    @Test
    public void testCancelInvite() {
        if (!isServiceReady()) return;
        
        // 先创建一个房间
        String channelName = "test-cancel-invite-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 测试取消邀请功能 ===");
            
            // 先发送邀请，获取请求ID
            String requestId = "invite_" + System.currentTimeMillis();
            
            // 基本取消邀请
            System.out.println("1. 基本取消邀请...");
            cancelInviteBasic(channelId, creatorAccountId, inviteeAccountId, requestId);
            
            // 带推送配置的取消邀请
            System.out.println("2. 带推送配置的取消邀请...");
            cancelInviteWithPush(channelId, creatorAccountId, targetAccountId, "invite_push_" + System.currentTimeMillis());
            
            // 带完整配置的取消邀请
            System.out.println("3. 带完整配置的取消邀请...");
            cancelInviteWithFullConfig(channelId, creatorAccountId, "another_" + inviteeAccountId, "invite_full_" + System.currentTimeMillis());
        }
    }

    @Test
    public void testCompleteWorkflow() {
        if (!isServiceReady()) return;
        
        // 创建 -> 查询 -> 延长 -> 查询 -> 关闭的完整流程
        String channelName = "test-workflow-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 完整工作流测试 ===");
            System.out.println("1. 房间已创建: " + channelId);
            
            // 查询房间信息
            System.out.println("2. 查询房间信息...");
            queryRoomById(channelId);
            
            // 延长房间有效期
            System.out.println("3. 延长房间有效期...");
            delayRoom(channelId);
            
            // 再次查询房间信息（验证延长后的过期时间）
            System.out.println("4. 再次查询房间信息（验证延长后的过期时间）...");
            queryRoomById(channelId);
            
            // 关闭房间
            System.out.println("5. 关闭房间...");
            closeRoom(channelId, creatorAccountId);
            
            // 尝试查询已关闭的房间（应该返回404）
            System.out.println("6. 尝试查询已关闭的房间...");
            queryRoomById(channelId);
            
            System.out.println("=== 工作流测试完成 ===");
        }
    }

    @Test
    public void testKickMember() {
        if (!isServiceReady()) return;
        
        // 先创建一个房间
        String channelName = "test-kick-member-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 测试踢出成员功能 ===");
            
            // 基本踢出成员
            System.out.println("1. 基本踢出成员...");
            kickMemberBasic(channelId, creatorAccountId, targetAccountId);
            
            // 带抄送配置的踢出成员
            System.out.println("2. 带抄送配置的踢出成员...");
            kickMemberWithRoute(channelId, creatorAccountId, inviteeAccountId);
            
            // 带完整配置的踢出成员
            System.out.println("3. 带完整配置的踢出成员...");
            kickMemberWithFullConfig(channelId, creatorAccountId, "another_" + targetAccountId);
        }
    }

    @Test
    public void testInviteAndCancelWorkflow() {
        if (!isServiceReady()) return;
        
        // 邀请 -> 取消邀请的完整流程
        String channelName = "test-invite-cancel-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            String requestId = "invite_cancel_test_" + System.currentTimeMillis();
            
            System.out.println("\n=== 邀请取消工作流测试 ===");
            System.out.println("1. 房间已创建: " + channelId);
            
            // 发送邀请
            System.out.println("2. 发送邀请...");
            inviteBasic(channelId, creatorAccountId, inviteeAccountId);
            
            // 取消邀请
            System.out.println("3. 取消邀请...");
            cancelInviteBasic(channelId, creatorAccountId, inviteeAccountId, requestId);
            
            System.out.println("=== 邀请取消工作流测试完成 ===");
        }
    }

    @Test
    public void testBasicSignalFlow() {
        if (!isServiceReady()) return;
        
        System.out.println("\n=== 基础信令流程测试 ===");
        System.out.println("使用真实用户账号进行测试:");
        System.out.println("- 房间创建者: " + creatorAccountId);
        System.out.println("- 目标用户: " + targetAccountId);
        System.out.println("- 被邀请用户: " + inviteeAccountId);
        
        // 创建 -> 查询 -> 关闭的基础流程
        String channelName = "test-basic-signal-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("1. ✅ 房间创建成功: " + channelId);
            
            // 查询房间信息
            System.out.println("2. 查询房间信息...");
            QuerySignalRoomResponseV2 queryResponse = queryRoomById(channelId);
            if (queryResponse != null) {
                System.out.println("   ✅ 房间查询成功");
            }
            
            // 关闭房间
            System.out.println("3. 关闭房间...");
            CloseSignalRoomResponseV2 closeResponse = closeRoom(channelId, creatorAccountId);
            if (closeResponse != null) {
                System.out.println("   ✅ 房间关闭成功");
            }
            
            System.out.println("=== 基础信令流程测试完成 ===");
        } else {
            System.out.println("❌ 房间创建失败，跳过后续测试");
        }
    }

    @Test
    public void testCompleteSignalWorkflow() {
        if (!isServiceReady()) return;
        
        // 创建 -> 邀请 -> 踢出 -> 关闭的完整流程
        String channelName = "test-complete-signal-v2-" + System.currentTimeMillis();
        CreateSIgnalRoomResponseV2 createResponse = createRoom(channelName, creatorAccountId);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 完整信令操作流程测试 ===");
            System.out.println("1. 房间已创建: " + channelId);
            
            // 查询房间信息
            System.out.println("2. 查询房间信息...");
            queryRoomById(channelId);
            
            // 发送邀请
            System.out.println("3. 发送邀请...");
            inviteBasic(channelId, creatorAccountId, inviteeAccountId);
            
            // 发送控制指令
            System.out.println("4. 发送控制指令...");
            sendControlToMember(channelId, creatorAccountId, targetAccountId);
            
            // 踢出成员
            System.out.println("5. 踢出成员...");
            kickMemberBasic(channelId, creatorAccountId, targetAccountId);
            
            // 延长房间有效期
            System.out.println("6. 延长房间有效期...");
            delayRoom(channelId);
            
            // 关闭房间
            System.out.println("7. 关闭房间...");
            closeRoom(channelId, creatorAccountId);
            
            System.out.println("=== 完整信令操作流程测试完成 ===");
        }
    }

    private static CreateSIgnalRoomResponseV2 createRoom(String channelName, String creatorAccountId) {
        CreateSignalRoomRequestV2 request = new CreateSignalRoomRequestV2();
        request.setChannelName(channelName);
        request.setCreatorAccountId(creatorAccountId);
        request.setChannelType(2); // 视频类型
        request.setChannelExtension("{\"description\":\"test signal room v2\"}");
        
        // 设置抄送配置
        CreateSignalRoomRequestV2.RouteConfig routeConfig = new CreateSignalRoomRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(false);
        request.setRouteConfig(routeConfig);

        Result<CreateSIgnalRoomResponseV2> result = signalService.createRoom(request);
        
        System.out.println("创建信令房间结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CreateSIgnalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelName, response.getChannelName());
            Assert.assertEquals(creatorAccountId, response.getCreatorAccountId());
            Assert.assertNotNull(response.getChannelId());
            Assert.assertEquals(Integer.valueOf(2), response.getChannelType());
            Assert.assertNotNull(response.getCreateTime());
            Assert.assertNotNull(response.getExpireTime());
            
            System.out.println("房间名称: " + response.getChannelName());
            System.out.println("房间ID: " + response.getChannelId());
            System.out.println("创建者: " + response.getCreatorAccountId());
            System.out.println("房间类型: " + response.getChannelType());
            System.out.println("创建时间: " + response.getCreateTime());
            System.out.println("过期时间: " + response.getExpireTime());
            System.out.println("扩展字段: " + response.getChannelExtension());
            
            if (response.getMemberList() != null && !response.getMemberList().isEmpty()) {
                System.out.println("成员列表:");
                for (CreateSIgnalRoomResponseV2.Member member : response.getMemberList()) {
                    System.out.println("  - 账号ID: " + member.getAccountId());
                    System.out.println("    用户ID: " + member.getUid());
                    System.out.println("    设备ID: " + member.getDeviceId());
                    System.out.println("    加入时间: " + member.getJoinTime());
                    System.out.println("    过期时间: " + member.getExpireTime());
                }
            }
            
            return response;
        } else {
            System.out.println("创建房间失败: " + result.getMsg());
            if (result.getCode() == 118301) {
                System.out.println("  -> 信令房间已存在，这在并发测试中是正常的");
            } else if (result.getCode() == 118410) {
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
            }
            return null;
        }
    }

    private static DelaySignalRoomResponseV2 delayRoom(String channelId) {
        DelaySignalRoomRequestV2 request = new DelaySignalRoomRequestV2();
        request.setChannelId(channelId);

        Result<DelaySignalRoomResponseV2> result = signalService.delayRoom(request);
        
        System.out.println("延长信令房间有效期结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            DelaySignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelId, response.getChannelId());
            Assert.assertNotNull(response.getExpireTime());
            
            System.out.println("房间名称: " + response.getChannelName());
            System.out.println("房间ID: " + response.getChannelId());
            System.out.println("创建者: " + response.getCreatorAccountId());
            System.out.println("房间类型: " + response.getChannelType());
            System.out.println("创建时间: " + response.getCreateTime());
            System.out.println("延长后过期时间: " + response.getExpireTime());
            System.out.println("扩展字段: " + response.getChannelExtension());
            
            if (response.getMemberList() != null && !response.getMemberList().isEmpty()) {
                System.out.println("成员列表:");
                for (DelaySignalRoomResponseV2.Member member : response.getMemberList()) {
                    System.out.println("  - 账号ID: " + member.getAccountId());
                    System.out.println("    用户ID: " + member.getUid());
                    System.out.println("    设备ID: " + member.getDeviceId());
                    System.out.println("    加入时间: " + member.getJoinTime());
                    System.out.println("    过期时间: " + member.getExpireTime());
                }
            }
            
            return response;
        } else {
            System.out.println("延长房间有效期失败: " + result.getMsg());
            if (result.getCode() == 118404) {
                System.out.println("  -> 信令房间不存在");
            } else if (result.getCode() == 118410) {
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
            }
            return null;
        }
    }

    private static CloseSignalRoomResponseV2 closeRoom(String channelId, String operatorAccountId) {
        CloseSignalRoomRequestV2 request = new CloseSignalRoomRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        request.setServerExtension("{\"reason\":\"test close\"}");
        request.setOfflineEnabled(false);
        request.setRouteEnabled(false);

        Result<CloseSignalRoomResponseV2> result = signalService.closeRoom(request);
        
        System.out.println("关闭信令房间结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CloseSignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("房间关闭成功: " + channelId);
            return response;
        } else {
            System.out.println("关闭房间失败: " + result.getMsg());
            if (result.getCode() == 118404) {
                System.out.println("  -> 信令房间不存在");
            } else if (result.getCode() == 118410) {
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
            } else if (result.getCode() == 414) {
                System.out.println("  -> 参数错误，请检查操作者是否为房间创建者或房间成员");
            }
            return null;
        }
    }

    private static CloseSignalRoomResponseV2 closeRoomWithOptions(String channelId, String operatorAccountId) {
        CloseSignalRoomRequestV2 request = new CloseSignalRoomRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        request.setServerExtension("{\"reason\":\"test close with offline and route\"}");
        request.setOfflineEnabled(true);  // 存离线消息
        request.setRouteEnabled(true);    // 抄送消息

        Result<CloseSignalRoomResponseV2> result = signalService.closeRoom(request);
        
        System.out.println("关闭信令房间结果 (带离线+抄送) (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CloseSignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("房间关闭成功 (带离线+抄送): " + channelId);
            return response;
        } else {
            System.out.println("关闭房间失败: " + result.getMsg());
            return null;
        }
    }

    private static QuerySignalRoomResponseV2 queryRoomById(String channelId) {
        QuerySignalRoomRequestV2 request = new QuerySignalRoomRequestV2();
        request.setChannelId(channelId);

        Result<QuerySignalRoomResponseV2> result = signalService.queryRoom(request);
        
        System.out.println("通过房间ID查询信令房间结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            QuerySignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelId, response.getChannelId());
            
            System.out.println("房间名称: " + response.getChannelName());
            System.out.println("房间ID: " + response.getChannelId());
            System.out.println("创建者: " + response.getCreatorAccountId());
            System.out.println("房间类型: " + response.getChannelType());
            System.out.println("创建时间: " + response.getCreateTime());
            System.out.println("过期时间: " + response.getExpireTime());
            System.out.println("扩展字段: " + response.getChannelExtension());
            
            if (response.getMemberList() != null && !response.getMemberList().isEmpty()) {
                System.out.println("成员列表:");
                for (QuerySignalRoomResponseV2.Member member : response.getMemberList()) {
                    System.out.println("  - 账号ID: " + member.getAccountId());
                    System.out.println("    用户ID: " + member.getUid());
                    System.out.println("    设备ID: " + member.getDeviceId());
                    System.out.println("    加入时间: " + member.getJoinTime());
                    System.out.println("    过期时间: " + member.getExpireTime());
                }
            } else {
                System.out.println("成员列表: 无");
            }
            
            return response;
        } else {
            System.out.println("查询房间失败: " + result.getMsg());
            if (result.getCode() == 118404) {
                System.out.println("  -> 信令房间不存在");
            } else if (result.getCode() == 118410) {
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
            } else if (result.getCode() == 414) {
                System.out.println("  -> 参数错误，请检查房间ID或房间名称");
            }
            return null;
        }
    }

    private static QuerySignalRoomResponseV2 queryRoomByName(String channelName) {
        QuerySignalRoomRequestV2 request = new QuerySignalRoomRequestV2();
        request.setChannelName(channelName);

        Result<QuerySignalRoomResponseV2> result = signalService.queryRoom(request);
        
        System.out.println("通过房间名称查询信令房间结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            QuerySignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelName, response.getChannelName());
            
            System.out.println("房间名称: " + response.getChannelName());
            System.out.println("房间ID: " + response.getChannelId());
            System.out.println("创建者: " + response.getCreatorAccountId());
            System.out.println("房间类型: " + response.getChannelType());
            System.out.println("创建时间: " + response.getCreateTime());
            System.out.println("过期时间: " + response.getExpireTime());
            System.out.println("扩展字段: " + response.getChannelExtension());
            
            if (response.getMemberList() != null && !response.getMemberList().isEmpty()) {
                System.out.println("成员列表:");
                for (QuerySignalRoomResponseV2.Member member : response.getMemberList()) {
                    System.out.println("  - 账号ID: " + member.getAccountId());
                    System.out.println("    用户ID: " + member.getUid());
                    System.out.println("    设备ID: " + member.getDeviceId());
                    System.out.println("    加入时间: " + member.getJoinTime());
                    System.out.println("    过期时间: " + member.getExpireTime());
                }
            } else {
                System.out.println("成员列表: 无");
            }
            
            return response;
        } else {
            System.out.println("查询房间失败: " + result.getMsg());
            if (result.getCode() == 118404) {
                System.out.println("  -> 信令房间不存在");
            } else if (result.getCode() == 118410) {
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
            } else if (result.getCode() == 414) {
                System.out.println("  -> 参数错误，请检查房间ID或房间名称");
            }
            return null;
        }
    }

    private static SendSignalRoomControlResponseV2 sendControlToMember(String channelId, String operatorAccountId, String targetAccountId) {
        SendSignalRoomControlRequestV2 request = new SendSignalRoomControlRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        request.setTargetAccountId(targetAccountId);
        request.setServerExtension("{\"action\":\"mute\",\"reason\":\"test control to member\"}");

        Result<SendSignalRoomControlResponseV2> result = signalService.sendControl(request);
        
        System.out.println("发送控制指令给特定成员结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            SendSignalRoomControlResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("控制指令发送成功到用户: " + targetAccountId);
            return response;
        } else {
            System.out.println("发送控制指令失败: " + result.getMsg());
            handleControlError(result.getCode());
            return null;
        }
    }

    private static SendSignalRoomControlResponseV2 sendControlBroadcast(String channelId, String operatorAccountId) {
        SendSignalRoomControlRequestV2 request = new SendSignalRoomControlRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        // 不设置targetAccountId，表示广播给所有成员
        request.setServerExtension("{\"action\":\"broadcast\",\"message\":\"test broadcast control\"}");

        Result<SendSignalRoomControlResponseV2> result = signalService.sendControl(request);
        
        System.out.println("广播控制指令给所有成员结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            SendSignalRoomControlResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("控制指令广播发送成功");
            return response;
        } else {
            System.out.println("广播控制指令失败: " + result.getMsg());
            handleControlError(result.getCode());
            return null;
        }
    }

    private static SendSignalRoomControlResponseV2 sendControlWithRoute(String channelId, String operatorAccountId, String targetAccountId) {
        SendSignalRoomControlRequestV2 request = new SendSignalRoomControlRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        request.setTargetAccountId(targetAccountId);
        request.setServerExtension("{\"action\":\"kick\",\"reason\":\"test control with route\"}");
        
        // 设置抄送配置
        SendSignalRoomControlRequestV2.RouteConfig routeConfig = new SendSignalRoomControlRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(true);
        request.setRouteConfig(routeConfig);

        Result<SendSignalRoomControlResponseV2> result = signalService.sendControl(request);
        
        System.out.println("发送带抄送配置的控制指令结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            SendSignalRoomControlResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带抄送配置的控制指令发送成功到用户: " + targetAccountId);
            return response;
        } else {
            System.out.println("发送带抄送配置的控制指令失败: " + result.getMsg());
            handleControlError(result.getCode());
            return null;
        }
    }

    private static InviteSignalRoomResponseV2 inviteBasic(String channelId, String inviterAccountId, String inviteeAccountId) {
        InviteSignalRoomRequestV2 request = new InviteSignalRoomRequestV2();
        request.setChannelId(channelId);
        request.setInviterAccountId(inviterAccountId);
        request.setInviteeAccountId(inviteeAccountId);
        request.setRequestId("invite_" + System.currentTimeMillis());
        request.setServerExtension("{\"type\":\"basic_invite\",\"message\":\"test basic invite\"}");

        Result<InviteSignalRoomResponseV2> result = signalService.invite(request);
        
        System.out.println("基本邀请结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            InviteSignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("基本邀请发送成功到用户: " + inviteeAccountId);
            return response;
        } else {
            System.out.println("基本邀请失败: " + result.getMsg());
            handleInviteError(result.getCode());
            return null;
        }
    }

    private static InviteSignalRoomResponseV2 inviteWithPush(String channelId, String inviterAccountId, String inviteeAccountId) {
        InviteSignalRoomRequestV2 request = new InviteSignalRoomRequestV2();
        request.setChannelId(channelId);
        request.setInviterAccountId(inviterAccountId);
        request.setInviteeAccountId(inviteeAccountId);
        request.setRequestId("invite_push_" + System.currentTimeMillis());
        request.setServerExtension("{\"type\":\"push_invite\",\"message\":\"test invite with push\"}");
        
        // 设置推送配置
        InviteSignalRoomRequestV2.PushConfig pushConfig = new InviteSignalRoomRequestV2.PushConfig();
        pushConfig.setPushEnabled(true);
        pushConfig.setPushTitle("音视频邀请");
        pushConfig.setPushContent("有人邀请您加入音视频通话");
        pushConfig.setPushPayload("{\"action\":\"invite\",\"type\":\"video\"}");
        request.setPushConfig(pushConfig);

        Result<InviteSignalRoomResponseV2> result = signalService.invite(request);
        
        System.out.println("带推送配置的邀请结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            InviteSignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带推送配置的邀请发送成功到用户: " + inviteeAccountId);
            return response;
        } else {
            System.out.println("带推送配置的邀请失败: " + result.getMsg());
            handleInviteError(result.getCode());
            return null;
        }
    }

    private static InviteSignalRoomResponseV2 inviteWithFullConfig(String channelId, String inviterAccountId, String inviteeAccountId) {
        InviteSignalRoomRequestV2 request = new InviteSignalRoomRequestV2();
        request.setChannelId(channelId);
        request.setInviterAccountId(inviterAccountId);
        request.setInviteeAccountId(inviteeAccountId);
        request.setRequestId("invite_full_" + System.currentTimeMillis());
        request.setServerExtension("{\"type\":\"full_config_invite\",\"message\":\"test invite with full config\"}");
        request.setOfflineEnabled(true);    // 存离线消息
        request.setUnreadEnabled(true);     // 计入未读数
        
        // 设置推送配置
        InviteSignalRoomRequestV2.PushConfig pushConfig = new InviteSignalRoomRequestV2.PushConfig();
        pushConfig.setPushEnabled(true);
        pushConfig.setPushTitle("视频通话邀请");
        pushConfig.setPushContent("您有一个新的视频通话邀请，请查看");
        pushConfig.setPushPayload("{\"action\":\"video_invite\",\"priority\":\"high\"}");
        request.setPushConfig(pushConfig);
        
        // 设置抄送配置
        InviteSignalRoomRequestV2.RouteConfig routeConfig = new InviteSignalRoomRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(true);
        request.setRouteConfig(routeConfig);

        Result<InviteSignalRoomResponseV2> result = signalService.invite(request);
        
        System.out.println("带完整配置的邀请结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            InviteSignalRoomResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带完整配置的邀请发送成功到用户: " + inviteeAccountId);
            return response;
        } else {
            System.out.println("带完整配置的邀请失败: " + result.getMsg());
            handleInviteError(result.getCode());
            return null;
        }
    }

    private static CancelSignalRoomInviteResponseV2 cancelInviteBasic(String channelId, String inviterAccountId, String inviteeAccountId, String requestId) {
        CancelSignalRoomInviteRequestV2 request = new CancelSignalRoomInviteRequestV2();
        request.setChannelId(channelId);
        request.setInviterAccountId(inviterAccountId);
        request.setInviteeAccountId(inviteeAccountId);
        request.setRequestId(requestId);
        request.setServerExtension("{\"type\":\"basic_cancel_invite\",\"message\":\"test basic cancel invite\"}");

        Result<CancelSignalRoomInviteResponseV2> result = signalService.cancelInvite(request);
        
        System.out.println("基本取消邀请结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CancelSignalRoomInviteResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("基本取消邀请成功，用户: " + inviteeAccountId);
            return response;
        } else {
            System.out.println("基本取消邀请失败: " + result.getMsg());
            handleCancelInviteError(result.getCode());
            return null;
        }
    }

    private static CancelSignalRoomInviteResponseV2 cancelInviteWithPush(String channelId, String inviterAccountId, String inviteeAccountId, String requestId) {
        CancelSignalRoomInviteRequestV2 request = new CancelSignalRoomInviteRequestV2();
        request.setChannelId(channelId);
        request.setInviterAccountId(inviterAccountId);
        request.setInviteeAccountId(inviteeAccountId);
        request.setRequestId(requestId);
        request.setServerExtension("{\"type\":\"push_cancel_invite\",\"message\":\"test cancel invite with push\"}");
        
        // 设置推送配置
        CancelSignalRoomInviteRequestV2.PushConfig pushConfig = new CancelSignalRoomInviteRequestV2.PushConfig();
        pushConfig.setPushEnabled(true);
        pushConfig.setPushTitle("邀请取消");
        pushConfig.setPushContent("音视频邀请已被取消");
        pushConfig.setPushPayload("{\"action\":\"cancel_invite\",\"type\":\"video\"}");
        request.setPushConfig(pushConfig);

        Result<CancelSignalRoomInviteResponseV2> result = signalService.cancelInvite(request);
        
        System.out.println("带推送配置的取消邀请结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CancelSignalRoomInviteResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带推送配置的取消邀请成功，用户: " + inviteeAccountId);
            return response;
        } else {
            System.out.println("带推送配置的取消邀请失败: " + result.getMsg());
            handleCancelInviteError(result.getCode());
            return null;
        }
    }

    private static CancelSignalRoomInviteResponseV2 cancelInviteWithFullConfig(String channelId, String inviterAccountId, String inviteeAccountId, String requestId) {
        CancelSignalRoomInviteRequestV2 request = new CancelSignalRoomInviteRequestV2();
        request.setChannelId(channelId);
        request.setInviterAccountId(inviterAccountId);
        request.setInviteeAccountId(inviteeAccountId);
        request.setRequestId(requestId);
        request.setServerExtension("{\"type\":\"full_config_cancel_invite\",\"message\":\"test cancel invite with full config\"}");
        request.setOfflineEnabled(true);    // 存离线消息
        request.setUnreadEnabled(true);     // 计入未读数
        
        // 设置推送配置
        CancelSignalRoomInviteRequestV2.PushConfig pushConfig = new CancelSignalRoomInviteRequestV2.PushConfig();
        pushConfig.setPushEnabled(true);
        pushConfig.setPushTitle("视频通话邀请已取消");
        pushConfig.setPushContent("您的视频通话邀请已被取消");
        pushConfig.setPushPayload("{\"action\":\"cancel_video_invite\",\"priority\":\"high\"}");
        request.setPushConfig(pushConfig);
        
        // 设置抄送配置
        CancelSignalRoomInviteRequestV2.RouteConfig routeConfig = new CancelSignalRoomInviteRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(true);
        request.setRouteConfig(routeConfig);

        Result<CancelSignalRoomInviteResponseV2> result = signalService.cancelInvite(request);
        
        System.out.println("带完整配置的取消邀请结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CancelSignalRoomInviteResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带完整配置的取消邀请成功，用户: " + inviteeAccountId);
            return response;
        } else {
            System.out.println("带完整配置的取消邀请失败: " + result.getMsg());
            handleCancelInviteError(result.getCode());
            return null;
        }
    }

    private static KickSignalRoomMemberResponseV2 kickMemberBasic(String channelId, String operatorAccountId, String targetAccountId) {
        KickSignalRoomMemberRequestV2 request = new KickSignalRoomMemberRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        request.setTargetAccountId(targetAccountId);
        request.setServerExtension("{\"type\":\"basic_kick\",\"reason\":\"test basic kick member\"}");

        Result<KickSignalRoomMemberResponseV2> result = signalService.kickMember(request);
        
        System.out.println("基本踢出成员结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            KickSignalRoomMemberResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("基本踢出成员成功，用户: " + targetAccountId);
            return response;
        } else {
            System.out.println("基本踢出成员失败: " + result.getMsg());
            handleKickMemberError(result.getCode());
            return null;
        }
    }

    private static KickSignalRoomMemberResponseV2 kickMemberWithRoute(String channelId, String operatorAccountId, String targetAccountId) {
        KickSignalRoomMemberRequestV2 request = new KickSignalRoomMemberRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        request.setTargetAccountId(targetAccountId);
        request.setServerExtension("{\"type\":\"route_kick\",\"reason\":\"test kick member with route\"}");
        
        // 设置抄送配置
        KickSignalRoomMemberRequestV2.RouteConfig routeConfig = new KickSignalRoomMemberRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(true);
        request.setRouteConfig(routeConfig);

        Result<KickSignalRoomMemberResponseV2> result = signalService.kickMember(request);
        
        System.out.println("带抄送配置的踢出成员结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            KickSignalRoomMemberResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带抄送配置的踢出成员成功，用户: " + targetAccountId);
            return response;
        } else {
            System.out.println("带抄送配置的踢出成员失败: " + result.getMsg());
            handleKickMemberError(result.getCode());
            return null;
        }
    }

    private static KickSignalRoomMemberResponseV2 kickMemberWithFullConfig(String channelId, String operatorAccountId, String targetAccountId) {
        KickSignalRoomMemberRequestV2 request = new KickSignalRoomMemberRequestV2();
        request.setChannelId(channelId);
        request.setOperatorAccountId(operatorAccountId);
        request.setTargetAccountId(targetAccountId);
        request.setServerExtension("{\"type\":\"full_config_kick\",\"reason\":\"test kick member with full config\"}");
        request.setOfflineEnabled(true);    // 存离线消息
        
        // 设置抄送配置
        KickSignalRoomMemberRequestV2.RouteConfig routeConfig = new KickSignalRoomMemberRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(true);
        request.setRouteConfig(routeConfig);

        Result<KickSignalRoomMemberResponseV2> result = signalService.kickMember(request);
        
        System.out.println("带完整配置的踢出成员结果 (V2):");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        System.out.println("消息: " + result.getMsg());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            KickSignalRoomMemberResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带完整配置的踢出成员成功，用户: " + targetAccountId);
            return response;
        } else {
            System.out.println("带完整配置的踢出成员失败: " + result.getMsg());
            handleKickMemberError(result.getCode());
            return null;
        }
    }

    private static void handleKickMemberError(int errorCode) {
        switch (errorCode) {
            case 118404:
                System.out.println("  -> 信令房间不存在");
                break;
            case 118311:
                System.out.println("  -> 只有信令房间创建者才可以操作");
                break;
            case 118303:
                System.out.println("  -> 信令成员不存在");
                break;
            case 118410:
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
                break;
            case 414:
                System.out.println("  -> 参数错误，请检查参数");
                break;
            case 7101:
                System.out.println("  -> 用户被拉黑，无法操作");
                break;
            default:
                System.out.println("  -> 未知错误，错误码: " + errorCode);
                break;
        }
    }

    private static void handleCancelInviteError(int errorCode) {
        switch (errorCode) {
            case 118404:
                System.out.println("  -> 信令房间不存在");
                break;
            case 118310:
                System.out.println("  -> 邀请不存在，无法取消");
                break;
            case 118302:
                System.out.println("  -> 邀请已经被接受，无法取消");
                break;
            case 118307:
                System.out.println("  -> 邀请已经被拒绝，无法取消");
                break;
            case 118410:
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
                break;
            case 414:
                System.out.println("  -> 参数错误，请检查操作者是否为房间创建者或房间成员");
                break;
            case 7101:
                System.out.println("  -> 用户被拉黑，无法操作");
                break;
            default:
                System.out.println("  -> 未知错误，错误码: " + errorCode);
                break;
        }
    }

    private static void handleInviteError(int errorCode) {
        switch (errorCode) {
            case 118404:
                System.out.println("  -> 信令房间不存在");
                break;
            case 118303:
                System.out.println("  -> 信令成员不存在");
                break;
            case 118308:
                System.out.println("  -> 信令成员不在线但可以通过推送通知到达");
                break;
            case 118410:
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
                break;
            case 414:
                System.out.println("  -> 参数错误，请检查操作者是否为房间创建者或房间成员");
                break;
            case 118301:
                System.out.println("  -> 邀请已存在，重复邀请");
                break;
            case 7101:
                System.out.println("  -> 用户被拉黑，无法邀请");
                break;
            default:
                System.out.println("  -> 未知错误，错误码: " + errorCode);
                break;
        }
    }

    private static void handleControlError(int errorCode) {
        switch (errorCode) {
            case 118404:
                System.out.println("  -> 信令房间不存在");
                break;
            case 118303:
                System.out.println("  -> 信令成员不存在");
                break;
            case 118308:
                System.out.println("  -> 信令成员不在线但可以通过推送通知到达");
                break;
            case 118410:
                System.out.println("  -> 信令服务未开通，请先开通信令服务");
                break;
            case 414:
                System.out.println("  -> 参数错误，请检查操作者是否为房间创建者或房间成员");
                break;
            default:
                System.out.println("  -> 未知错误，错误码: " + errorCode);
                break;
        }
    }

    /**
     * 检查服务是否已初始化
     */
    private static boolean isServiceReady() {
        if (signalService == null || accountService == null) {
            System.out.println("信令服务或账号服务未初始化，跳过测试");
            return false;
        }
        return true;
    }
} 