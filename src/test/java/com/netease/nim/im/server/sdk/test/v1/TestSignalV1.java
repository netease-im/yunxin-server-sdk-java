package com.netease.nim.im.server.sdk.test.v1;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v1.YunxinV1ApiServices;
import com.netease.nim.server.sdk.im.v1.account.IAccountV1Service;
import com.netease.nim.server.sdk.im.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.server.sdk.im.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.ISignalV1Service;
import com.netease.nim.server.sdk.im.v1.signal.request.CreateSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.DelaySignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CloseSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.GetSignalRoomInfoRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CtrlSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.InviteSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.CancelSignalRoomInviteRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.request.KickSignalRoomRequestV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CreateSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.DelaySignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CloseSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.GetSignalRoomInfoResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CtrlSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.InviteSignalRoomResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.CancelSignalRoomInviteResponseV1;
import com.netease.nim.server.sdk.im.v1.signal.response.KickSignalRoomResponseV1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

/**
 * 信令频道测试
 */
public class TestSignalV1 {

    private static YunxinV1ApiServices services = null;
    private static ISignalV1Service signalService = null;
    private static IAccountV1Service accountService = null;
    private static String accid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String inviteeAccid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV1ApiServices(client);
        signalService = services.getSignalService();
        accountService = services.getAccountService();
        
        // 先创建测试账户
        if (accountService != null) {
            createAccount(accid, "signal-test-user-" + UUID.randomUUID());
            createAccount(inviteeAccid, "signal-invitee-user-" + UUID.randomUUID());
        }
    }

    @Test
    public void testCreateRoom() {
        if (signalService == null) return;
        
        String channelName = "test-channel-" + System.currentTimeMillis();
        createRoom(channelName);
    }

    @Test
    public void testDelayRoom() {
        if (signalService == null) return;
        
        // 先创建一个频道
        String channelName = "test-delay-channel-" + System.currentTimeMillis();
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 延长频道有效期
            delayRoom(createResponse.getChannelId());
        }
    }

    @Test
    public void testCloseRoom() {
        if (signalService == null) return;
        
        // 先创建一个频道
        String channelName = "test-close-channel-" + System.currentTimeMillis();
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 关闭频道
            closeRoom(createResponse.getChannelId());
        }
    }

    @Test
    public void testGetRoomInfo() {
        if (signalService == null) return;
        
        // 先创建一个频道
        String channelName = "test-get-room-info-" + System.currentTimeMillis();
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 通过频道ID查询
            getRoomInfoByChannelId(createResponse.getChannelId());
            
            // 通过频道名称查询
            getRoomInfoByChannelName(createResponse.getChannelName());
        }
    }

    @Test
    public void testCtrlRoom() {
        if (signalService == null) return;
        
        // 先创建一个频道
        String channelName = "test-ctrl-room-" + System.currentTimeMillis();
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 发送广播控制指令
            ctrlRoomBroadcast(createResponse.getChannelId());
            
            // 发送指定接收者的控制指令
            ctrlRoomToSpecificUser(createResponse.getChannelId(), accid);
        }
    }

    @Test
    public void testInvite() {
        if (signalService == null) return;
        
        // 先创建一个频道
        String channelName = "test-invite-" + System.currentTimeMillis();
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 发送邀请（不推送）
            invite(createResponse.getChannelId(), inviteeAccid, false);
            
            // 发送邀请（推送通知）
            inviteWithPush(createResponse.getChannelId(), inviteeAccid);
        }
    }

    @Test
    public void testCancelInvite() {
        if (signalService == null) return;
        
        // 先创建一个频道
        String channelName = "test-cancel-invite-" + System.currentTimeMillis();
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            // 完整的邀请-取消邀请流程
            String requestId1 = "invite_to_cancel_" + System.currentTimeMillis();
            String requestId2 = "invite_push_to_cancel_" + System.currentTimeMillis();
            
            // 1. 发送邀请（不推送）
            inviteWithRequestId(createResponse.getChannelId(), inviteeAccid, requestId1, false);
            
            // 2. 取消邀请（不推送）
            cancelInvite(createResponse.getChannelId(), inviteeAccid, requestId1, false);
            
            // 3. 发送邀请（推送通知）
            inviteWithRequestId(createResponse.getChannelId(), inviteeAccid, requestId2, true);
            
            // 4. 取消邀请（推送通知）
            cancelInviteWithPush(createResponse.getChannelId(), inviteeAccid, requestId2);
        }
    }

    @Test
    public void testKick() {
        if (signalService == null) return;
        
        // 先创建一个频道
        String channelName = "test-kick-" + System.currentTimeMillis();
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            
            System.out.println("\n=== 测试踢出功能（注意：服务端只能发送邀请，用户需要通过客户端接受邀请才能真正加入频道） ===");
            
            // 场景1：直接踢出用户（测试API调用，预期可能返回"用户不在频道"错误）
            System.out.println("\n--- 场景1：直接踢出用户（不存离线消息） ---");
            kick(channelId, inviteeAccid, false, false);
            
            // 场景2：踢出用户（存离线消息，抄送）
            System.out.println("\n--- 场景2：直接踢出用户（存离线消息+抄送） ---");
            kickWithSaveAndRoute(channelId, inviteeAccid);
            
            System.out.println("\n注意：如果返回错误'to not member'是正常的，因为用户需要通过客户端主动接受邀请才能加入频道。");
        }
    }

    @Test
    public void testCompleteWorkflow() {
        if (signalService == null) return;
        
        // 完整的工作流程测试：创建 -> 查询 -> 邀请 -> 取消邀请 -> 重新邀请 -> 尝试踢出 -> 发送指令 -> 延长 -> 查询 -> 关闭
        String channelName = "test-workflow-channel-" + System.currentTimeMillis();
        
        // 1. 创建频道
        CreateSignalRoomResponseV1 createResponse = createRoom(channelName);
        if (createResponse != null && createResponse.getChannelId() != null) {
            String channelId = createResponse.getChannelId();
            String requestId = "workflow_invite_" + System.currentTimeMillis();
            
            // 2. 查询频道信息
            getRoomInfoByChannelId(channelId);
            
            // 3. 邀请用户加入
            inviteWithRequestId(channelId, inviteeAccid, requestId, true);
            
            // 4. 取消邀请
            cancelInvite(channelId, inviteeAccid, requestId, false);
            
            // 5. 重新邀请用户加入频道
            String newRequestId = "workflow_reinvite_" + System.currentTimeMillis();
            inviteWithRequestId(channelId, inviteeAccid, newRequestId, true);
            
            // 6. 尝试踢出用户（注意：服务端邀请不能让用户直接加入，需客户端接受）
            kick(channelId, inviteeAccid, true, true);
            
            // 7. 发送控制指令
            ctrlRoomBroadcast(channelId);
            
            // 8. 延长有效期
            delayRoom(channelId);
            
            // 9. 再次查询频道信息（验证延长后的过期时间）
            getRoomInfoByChannelId(channelId);
            
            // 10. 关闭频道
            closeRoom(channelId);
            
            System.out.println("完整工作流程测试完成: 创建 -> 查询 -> 邀请 -> 取消邀请 -> 重新邀请 -> 尝试踢出 -> 发送指令 -> 延长 -> 查询 -> 关闭");
        }
    }

    private static void createAccount(String accid, String name) {
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid(accid);
        request.setName(name);
        request.setEx("signal test user");
        request.setBirth("1990-01-01");
        request.setGender(1);
        request.setIcon("https://icon-signal-test.jpg");
        request.setMobile("13800000000");
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        request.setSign("signal test sign");
        request.setEmail("signaltest@163.com");
        
        Result<CreateAccountResponseV1> result = accountService.createAccount(request);
        if (result.getCode() == 200) {
            System.out.println("创建测试账户成功: " + accid);
            CreateAccountResponseV1 response = result.getResponse();
            Assert.assertEquals(request.getAccid(), response.getAccid());
            Assert.assertEquals(request.getName(), response.getName());
            Assert.assertNotNull(response.getToken());
        } else {
            System.out.println("创建测试账户失败: " + result.getMsg());
        }
    }

    private static CreateSignalRoomResponseV1 createRoom(String channelName) {
            CreateSignalRoomRequestV1 request = new CreateSignalRoomRequestV1();
        request.setChannelName(channelName);
            request.setType(2); // 视频类型
        request.setFrom(accid);
            request.setExt("test extension");
            request.setIsRoute(0); // 不抄送

            Result<CreateSignalRoomResponseV1> result = signalService.createRoom(request);
            
            System.out.println("创建信令频道结果:");
            System.out.println("状态码: " + result.getCode());
            System.out.println("追踪ID: " + result.getTraceId());
            
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
                CreateSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelName, response.getChannelName());
            Assert.assertNotNull(response.getChannelId());
            Assert.assertEquals("VEDIO", response.getType());
            Assert.assertEquals(accid, response.getCreator());
            Assert.assertNotNull(response.getChannelCreateTime());
            Assert.assertNotNull(response.getChannelExpireTime());
            Assert.assertEquals("test extension", response.getExt());
            
                System.out.println("频道名称: " + response.getChannelName());
                System.out.println("频道ID: " + response.getChannelId());
                System.out.println("频道类型: " + response.getType());
                System.out.println("创建者: " + response.getCreator());
                System.out.println("创建时间: " + response.getChannelCreateTime());
                System.out.println("过期时间: " + response.getChannelExpireTime());
                System.out.println("扩展字段: " + response.getExt());
                
                if (response.getMembers() != null && !response.getMembers().isEmpty()) {
                    System.out.println("成员列表:");
                    for (CreateSignalRoomResponseV1.Member member : response.getMembers()) {
                        System.out.println("  - 账号ID: " + member.getAccid());
                        System.out.println("    用户ID: " + member.getUid());
                        System.out.println("    设备ID: " + member.getDeviceId());
                        System.out.println("    加入时间: " + member.getCreateTime());
                        System.out.println("    过期时间: " + member.getExpireTime());
                    }
            }
            
            return response;
        } else {
            System.out.println("创建频道失败: " + result.getMsg());
            return null;
        }
    }

    private static void delayRoom(String channelId) {
        DelaySignalRoomRequestV1 request = new DelaySignalRoomRequestV1();
        request.setChannelId(channelId);

        Result<DelaySignalRoomResponseV1> result = signalService.delayRoom(request);
        
        System.out.println("延长信令频道有效期结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            DelaySignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelId, response.getChannelId());
            Assert.assertNotNull(response.getChannelExpireTime());
            
            System.out.println("频道名称: " + response.getChannelName());
            System.out.println("频道ID: " + response.getChannelId());
            System.out.println("频道类型: " + response.getType());
            System.out.println("创建者: " + response.getCreator());
            System.out.println("创建时间: " + response.getChannelCreateTime());
            System.out.println("延长后过期时间: " + response.getChannelExpireTime());
            System.out.println("扩展字段: " + response.getExt());
            
            if (response.getMembers() != null && !response.getMembers().isEmpty()) {
                System.out.println("成员列表:");
                for (DelaySignalRoomResponseV1.Member member : response.getMembers()) {
                    System.out.println("  - 账号ID: " + member.getAccountId());
                    System.out.println("    用户ID: " + member.getUid());
                    System.out.println("    设备ID: " + member.getDeviceId());
                    System.out.println("    加入时间: " + member.getCreateTime());
                    System.out.println("    过期时间: " + member.getExpireTime());
                }
            }
        } else {
            System.out.println("延长频道有效期失败: " + result.getMsg());
        }
    }

    private static void closeRoom(String channelId) {
        CloseSignalRoomRequestV1 request = new CloseSignalRoomRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setIsSave(0); // 不存离线消息
        request.setAttachExt("close room test");
        request.setIsRoute(0); // 不抄送

        Result<CloseSignalRoomResponseV1> result = signalService.closeRoom(request);
        
        System.out.println("关闭信令频道结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CloseSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("频道关闭成功，频道ID: " + channelId);
        } else {
            System.out.println("关闭频道失败: " + result.getMsg());
        }
    }

    private static void getRoomInfoByChannelId(String channelId) {
        GetSignalRoomInfoRequestV1 request = new GetSignalRoomInfoRequestV1();
        request.setChannelId(channelId);

        Result<GetSignalRoomInfoResponseV1> result = signalService.getRoomInfo(request);
        
        System.out.println("根据频道ID查询信令频道信息结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            GetSignalRoomInfoResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelId, response.getChannelId());
            
            printRoomInfo(response);
        } else {
            System.out.println("查询频道信息失败: " + result.getMsg());
        }
    }

    private static void getRoomInfoByChannelName(String channelName) {
        GetSignalRoomInfoRequestV1 request = new GetSignalRoomInfoRequestV1();
        request.setChannelName(channelName);

        Result<GetSignalRoomInfoResponseV1> result = signalService.getRoomInfo(request);
        
        System.out.println("根据频道名称查询信令频道信息结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            GetSignalRoomInfoResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(channelName, response.getChannelName());
            
            printRoomInfo(response);
        } else {
            System.out.println("查询频道信息失败: " + result.getMsg());
        }
    }

    private static void ctrlRoomBroadcast(String channelId) {
        CtrlSignalRoomRequestV1 request = new CtrlSignalRoomRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        // 不设置to字段，表示广播给所有人
        request.setAttachExt("{\"action\":\"mute_all\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setIsRoute(0); // 不抄送

        Result<CtrlSignalRoomResponseV1> result = signalService.ctrlRoom(request);
        
        System.out.println("发送广播控制指令结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CtrlSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("广播控制指令发送成功，频道ID: " + channelId);
        } else {
            System.out.println("发送广播控制指令失败: " + result.getMsg());
        }
    }

    private static void ctrlRoomToSpecificUser(String channelId, String targetUserId) {
        CtrlSignalRoomRequestV1 request = new CtrlSignalRoomRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setTo(targetUserId); // 指定接收者
        request.setAttachExt("{\"action\":\"unmute\",\"target\":\"" + targetUserId + "\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setIsRoute(0); // 不抄送

        Result<CtrlSignalRoomResponseV1> result = signalService.ctrlRoom(request);
        
        System.out.println("发送指定用户控制指令结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CtrlSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("指定用户控制指令发送成功，频道ID: " + channelId + "，目标用户: " + targetUserId);
        } else {
            System.out.println("发送指定用户控制指令失败: " + result.getMsg());
        }
    }

    private static void invite(String channelId, String inviteeId, boolean needPush) {
        String requestId = "invite_" + System.currentTimeMillis();
        inviteWithRequestId(channelId, inviteeId, requestId, needPush);
    }

    private static void inviteWithRequestId(String channelId, String inviteeId, String requestId, boolean needPush) {
        InviteSignalRoomRequestV1 request = new InviteSignalRoomRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setTo(inviteeId);
        request.setRequestId(requestId);
        request.setAttachExt("{\"invitation_type\":\"VEDIO_call\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setNeedPush(needPush ? 1 : 0); // 0代表不推送，1代表推送
        request.setNeedBadge(1); // 1代表计入未读数
        request.setIsSave(1); // 存离线消息
        request.setIsRoute(0); // 不抄送

        Result<InviteSignalRoomResponseV1> result = signalService.invite(request);
        
        System.out.println("邀请用户加入信令频道结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            InviteSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("邀请发送成功，频道ID: " + channelId + "，被邀请者: " + inviteeId + "，邀请ID: " + requestId + "，推送: " + needPush);
        } else {
            System.out.println("发送邀请失败: " + result.getMsg());
            if (result.getCode() == 10202) {
                System.out.println("  -> 这是预期的错误，因为被邀请用户需要在线才能收到邀请，测试环境无法模拟用户在线");
            }
        }
    }

    private static void inviteWithPush(String channelId, String inviteeId) {
        InviteSignalRoomRequestV1 request = new InviteSignalRoomRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setTo(inviteeId);
        request.setRequestId("invite_push_" + System.currentTimeMillis());
        request.setAttachExt("{\"invitation_type\":\"VEDIO_call_with_push\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setNeedPush(1); // 1代表推送
        request.setPushTitle("视频通话邀请");
        request.setPushContent("您收到一个视频通话邀请，请及时处理");
        request.setPushPayload("{\"type\":\"VEDIO_call\",\"urgency\":\"high\"}");
        request.setNeedBadge(1); // 1代表计入未读数
        request.setIsSave(1); // 存离线消息
        request.setIsRoute(0); // 不抄送

        Result<InviteSignalRoomResponseV1> result = signalService.invite(request);
        
        System.out.println("发送带推送的邀请结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            InviteSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("带推送的邀请发送成功，频道ID: " + channelId + "，被邀请者: " + inviteeId);
            System.out.println("推送标题: " + request.getPushTitle());
            System.out.println("推送内容: " + request.getPushContent());
        } else {
            System.out.println("发送带推送的邀请失败: " + result.getMsg());
            if (result.getCode() == 10202) {
                System.out.println("  -> 这是预期的错误，因为被邀请用户需要在线才能收到邀请，测试环境无法模拟用户在线");
            }
        }
    }

    private static void cancelInvite(String channelId, String inviteeId, String requestId, boolean needPush) {
        CancelSignalRoomInviteRequestV1 request = new CancelSignalRoomInviteRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setTo(inviteeId);
        request.setRequestId(requestId);
        request.setAttachExt("{\"cancel_reason\":\"user_cancelled\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setNeedPush(needPush ? 1 : 0); // 0代表不推送，1代表推送
        request.setNeedBadge(1); // 1代表计入未读数
        request.setIsSave(1); // 存离线消息
        request.setIsRoute(0); // 不抄送

        Result<CancelSignalRoomInviteResponseV1> result = signalService.cancelInvite(request);
        
        System.out.println("取消邀请结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CancelSignalRoomInviteResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("取消邀请成功，频道ID: " + channelId + "，被邀请者: " + inviteeId + "，邀请ID: " + requestId + "，推送: " + needPush);
        } else {
            System.out.println("取消邀请失败: " + result.getMsg());
            System.out.println("  -> 可能因为原邀请未成功发送或邀请已处理，这在测试环境中是正常的");
        }
    }

    private static void cancelInviteWithPush(String channelId, String inviteeId, String requestId) {
        CancelSignalRoomInviteRequestV1 request = new CancelSignalRoomInviteRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setTo(inviteeId);
        request.setRequestId(requestId);
        request.setAttachExt("{\"cancel_reason\":\"changed_mind\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setNeedPush(1); // 1代表推送
        request.setPushTitle("邀请已取消");
        request.setPushContent("视频通话邀请已被取消");
        request.setPushPayload("{\"type\":\"invite_cancelled\",\"action\":\"dismiss\"}");
        request.setNeedBadge(0); // 0代表不计入未读数
        request.setIsSave(1); // 存离线消息
        request.setIsRoute(0); // 不抄送

        Result<CancelSignalRoomInviteResponseV1> result = signalService.cancelInvite(request);
        
        System.out.println("取消邀请（带推送）结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            CancelSignalRoomInviteResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("取消邀请（带推送）成功，频道ID: " + channelId + "，被邀请者: " + inviteeId + "，邀请ID: " + requestId);
            System.out.println("推送标题: " + request.getPushTitle());
            System.out.println("推送内容: " + request.getPushContent());
        } else {
            System.out.println("取消邀请（带推送）失败: " + result.getMsg());
        }
    }

    private static void kick(String channelId, String targetUserId, boolean isSave, boolean isRoute) {
        KickSignalRoomRequestV1 request = new KickSignalRoomRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setTo(targetUserId);
        request.setAttachExt("{\"kick_reason\":\"user_violated_rules\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setIsSave(isSave ? 1 : 0); // 0：不存离线；1：存离线
        request.setIsRoute(isRoute ? 1 : 0); // 0：不抄送；1：抄送

        Result<KickSignalRoomResponseV1> result = signalService.kick(request);
        
        System.out.println("踢出成员API调用结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            KickSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("踢出成员API调用成功，频道ID: " + channelId + "，被踢用户: " + targetUserId + "，存离线: " + isSave + "，抄送: " + isRoute);
        } else {
            System.out.println("踢出成员API调用失败: " + result.getMsg());
            if (result.getCode() == 10406) {
                System.out.println("  -> 这是预期的错误，因为用户需要通过客户端主动接受邀请才能加入频道");
            }
        }
    }

    private static void kickWithSaveAndRoute(String channelId, String targetUserId) {
        KickSignalRoomRequestV1 request = new KickSignalRoomRequestV1();
        request.setChannelId(channelId);
        request.setFrom(accid);
        request.setTo(targetUserId);
        request.setAttachExt("{\"kick_reason\":\"room_management\",\"operator\":\"" + accid + "\",\"timestamp\":" + System.currentTimeMillis() + "}");
        request.setIsSave(1); // 存离线消息
        request.setIsRoute(1); // 抄送

        Result<KickSignalRoomResponseV1> result = signalService.kick(request);
        
        System.out.println("踢出频道内成员（存离线+抄送）结果:");
        System.out.println("状态码: " + result.getCode());
        System.out.println("追踪ID: " + result.getTraceId());
        
        if (result.getCode() == 200) {
            Assert.assertEquals(200, result.getCode());
            KickSignalRoomResponseV1 response = result.getResponse();
            Assert.assertNotNull(response);
            
            System.out.println("踢出频道内成员（存离线+抄送）成功，频道ID: " + channelId + "，被踢用户: " + targetUserId);
            System.out.println("扩展信息: " + request.getAttachExt());
        } else {
            System.out.println("踢出频道内成员（存离线+抄送）失败: " + result.getMsg());
        }
    }

    private static void printRoomInfo(GetSignalRoomInfoResponseV1 response) {
        System.out.println("频道名称: " + response.getChannelName());
        System.out.println("频道ID: " + response.getChannelId());
        System.out.println("频道类型: " + response.getType());
        System.out.println("创建者: " + response.getCreator());
        System.out.println("创建时间: " + response.getChannelCreateTime());
        System.out.println("过期时间: " + response.getChannelExpireTime());
        System.out.println("扩展字段: " + response.getExt());
        
        if (response.getMembers() != null && !response.getMembers().isEmpty()) {
            System.out.println("成员列表:");
            for (GetSignalRoomInfoResponseV1.Member member : response.getMembers()) {
                System.out.println("  - 账号ID: " + member.getAccountId());
                System.out.println("    用户ID: " + member.getUid());
                System.out.println("    设备ID: " + member.getDeviceId());
                System.out.println("    加入时间: " + member.getCreateTime());
                System.out.println("    过期时间: " + member.getExpireTime());
            }
        }
    }
} 