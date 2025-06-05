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
import com.netease.nim.server.sdk.im.v1.super_team.ISuperTeamV1Service;
import com.netease.nim.server.sdk.im.v1.super_team.request.*;
import com.netease.nim.server.sdk.im.v1.super_team.response.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 超级群组功能测试类
 */
public class TestSuperTeamV1 {

    private static YunxinV1ApiServices services = null;
    private static ISuperTeamV1Service superTeamV1Service = null;
    private static IAccountV1Service accountV1Service = null;
    private static long tid;
    private static String owner;
    private static String member;
    private static String member1;
    private static String member2;
    private static String member3;
    private static String member4;

    @BeforeClass
    public static void setup() {
        if (services != null) {
            return;
        }
        
        // 使用随机账号ID避免冲突
        owner = "yx_" + UUID.randomUUID().toString().substring(0, 8);
        member = "yx_" + UUID.randomUUID().toString().substring(0, 8);
        member1 = "yx_" + UUID.randomUUID().toString().substring(0, 8);
        member2 = "yx_" + UUID.randomUUID().toString().substring(0, 8);
        member3 = "yx_" + UUID.randomUUID().toString().substring(0, 8);
        member4 = "yx_" + UUID.randomUUID().toString().substring(0, 8);

        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV1ApiServices(client);
        superTeamV1Service = services.getSuperTeamV1Service();
        accountV1Service = services.getAccountService();
        
        // 创建测试账号
        try {
            createAccount(owner, "Owner");
            createAccount(member, "Member");
            createAccount(member1, "Member1");
            createAccount(member2, "Member2");
            createAccount(member3, "Member3");
            createAccount(member4, "Member4");
        } catch (Exception e) {
            System.err.println("Error creating test accounts: " + e.getMessage());
        }

        try {
            // 创建测试群组
            List<String> inviteAccids = Arrays.asList(member1, member2, member3, member4);
            SuperTeamCreateRequestV1 request = new SuperTeamCreateRequestV1();
            request.setOwner(owner);
            request.setInviteAccids(inviteAccids);
            request.setTname("ygytest" + System.currentTimeMillis());
            request.setJoinmode(0);
            request.setBeinvitemode(1);
            request.setMsg("加入群聊");
            Result<CreateSuperTeamResponseV1> result = superTeamV1Service.createTeam(request);
            
            Assert.assertTrue("Failed to create super team: " + result.getMsg(), result.isSuccess());
            tid = result.getResponse().getTid();
            System.out.println("Created super team with ID: " + tid);
        } catch (Exception e) {
            System.err.println("Error creating test super team: " + e.getMessage());
        }
    }
    
    /**
     * 创建账号
     * 
     * @param accid 账号ID
     * @param name 名称
     */
    private static void createAccount(String accid, String name) {
        try {
            CreateAccountRequestV1 request = new CreateAccountRequestV1();
            request.setAccid(accid);
            request.setName(name);
            request.setEx("ex");
            request.setBirth("1970-01-01");
            request.setGender(1);
            request.setIcon("https://icon-xxx.jpg");
            request.setMobile("13811110000");
            request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            request.setSign("sign");
            request.setEmail(name.toLowerCase() + "@example.com");
            
            Result<CreateAccountResponseV1> result = accountV1Service.createAccount(request);
            if (result.isSuccess()) {
                System.out.println("Created account: " + accid);
            } else {
                System.err.println("Failed to create account " + accid + ": " + result.getMsg());
            }
        } catch (Exception e) {
            System.err.println("Error creating account " + accid + ": " + e.getMessage());
        }
    }

    @Test
    public void testChangeLevel() {
        if (superTeamV1Service == null) return;
        
        try {
            SuperTeamChangeLevelRequestV1 request = new SuperTeamChangeLevelRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setTlevel(100);
            Result<BaseSuperTeamResponseV1> result = superTeamV1Service.changeLevel(request);
            Assert.assertTrue("Failed to change super team level: " + result.getMsg(), result.isSuccess());
            System.out.println("**ChangeLevel**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to change super team level: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateTinfo() {
        if (superTeamV1Service == null) return;
        
        try {
            SuperTeamUpdateRequestV1 request = new SuperTeamUpdateRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setTname("更新后的超级群名称");
            Result<BaseSuperTeamResponseV1> result = superTeamV1Service.updateTinfo(request);
            Assert.assertTrue("Failed to update super team info: " + result.getMsg(), result.isSuccess());
            System.out.println("**UpdateTinfo**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to update super team info: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetTinfos() {
        if (superTeamV1Service == null) return;
        
        try {
            GetSuperTeamRequestV1 request = new GetSuperTeamRequestV1();
            request.setTids(JSON.toJSONString(Arrays.asList(tid)));
            Result<GetSuperTeamResponseV1> result = superTeamV1Service.getTinfos(request);
            Assert.assertTrue("Failed to get super team info: " + result.getMsg(), result.isSuccess());
            System.out.println("**getTinfo**" + JSON.toJSONString(result.getResponse()));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to get super team info: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetTlists() {
        if (superTeamV1Service == null) return;
        
        try {
            GetSuperTeamMemberRequestV1 request = new GetSuperTeamMemberRequestV1();
            request.setTid(tid);
            request.setTimetag(System.currentTimeMillis());
            request.setLimit(100);
            request.setReverse(2);
            Result<GetSuperTeamMemberResponseV1> result = superTeamV1Service.getTlists(request);
            Assert.assertTrue("Failed to get super team members: " + result.getMsg(), result.isSuccess());
            System.out.println("**GetTlists**" + JSON.toJSONString(result.getResponse()));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to get super team members: " + e.getMessage());
        }
    }
    
    @Test
    public void testInviteAndUpdateNick() {
        if (superTeamV1Service == null) return;
        
        try {
            // 邀请成员
            SuperTeamInviteRequestV1 request = new SuperTeamInviteRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setMsg("邀请加入超级群");
            request.setInviteAccids(JSON.toJSONString(Arrays.asList(member)));
            Result<SuperTeamInviteResponseV1> result = superTeamV1Service.invite(request);
            Assert.assertTrue("Failed to invite member to super team: " + result.getMsg(), result.isSuccess());
            System.out.println("**Invite**" + JSON.toJSONString(result));
            
            // 更新群昵称
            SuperTeamUpdateNickRequestV1 nickRequest = new SuperTeamUpdateNickRequestV1();
            nickRequest.setAccid(member);
            nickRequest.setNick("测试昵称");
            nickRequest.setOwner(owner);
            nickRequest.setTid(tid);
            Result<BaseSuperTeamResponseV1> nickResult = superTeamV1Service.updateTeamNick(nickRequest);
            Assert.assertTrue("Failed to update member nick in super team: " + nickResult.getMsg(), nickResult.isSuccess());
            System.out.println("**UpdateTeamNick**" + JSON.toJSONString(nickResult));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to invite and update nick: " + e.getMessage());
        }
    }
    
    @Test
    public void testJoinTeams() {
        if (superTeamV1Service == null) return;
        
        try {
            // 确保成员已被邀请
            testInviteAndUpdateNick();
            
            GetJoinSuperTeamRequestV1 request = new GetJoinSuperTeamRequestV1();
            request.setAccid(member);
            Result<GetJoinSuperTeamResponseV1> result = superTeamV1Service.joinTeams(request);
            Assert.assertTrue("Failed to get joined super teams: " + result.getMsg(), result.isSuccess());
            System.out.println("**getJoinTeam**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to get joined super teams: " + e.getMessage());
        }
    }
    
    @Test
    public void testMuteAndMuteTlist() {
        if (superTeamV1Service == null) return;
        
        try {
            // 禁言群
            SuperTeamMuteRequestV1 request = new SuperTeamMuteRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setMuteType(1);
            Result<SuperTeamMuteResponseV1> result = superTeamV1Service.mute(request);
            Assert.assertTrue("Failed to mute super team: " + result.getMsg(), result.isSuccess());
            System.out.println("**mute**" + JSON.toJSONString(result));
            
            // 确保成员已被邀请
            testInviteAndUpdateNick();
            
            // 禁言成员
            SuperTeamMuteTlistRequestV1 muteMemberRequest = new SuperTeamMuteTlistRequestV1();
            muteMemberRequest.setTid(tid);
            muteMemberRequest.setOwner(owner);
            muteMemberRequest.setMute(1);
            muteMemberRequest.setMuteAccids(Arrays.asList(member));
            Result<SuperTeamMuteTlistResponseV1> muteMemberResult = superTeamV1Service.muteTlist(muteMemberRequest);
            Assert.assertTrue("Failed to mute member in super team: " + muteMemberResult.getMsg(), muteMemberResult.isSuccess());
            System.out.println("**MuteTlist**" + JSON.toJSONString(muteMemberResult));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to mute super team and member: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetMuteTlists() {
        if (superTeamV1Service == null) return;
        
        try {
            // 确保有成员被禁言
            testMuteAndMuteTlist();
            
            GetSuperTeamMuteMemberRequestV1 request = new GetSuperTeamMuteMemberRequestV1();
            request.setTid(tid);
            request.setLimit(100);
            request.setReverse(2);
            request.setTimetag(System.currentTimeMillis());
            Result<GetSuperTeamMuteMemberResponseV1> result = superTeamV1Service.getMuteTlists(request);
            Assert.assertTrue("Failed to get muted members: " + result.getMsg(), result.isSuccess());
            System.out.println("**GetMuteList**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to get muted members: " + e.getMessage());
        }
    }
    
    @Test
    public void testLeaveAndKick() {
        if (superTeamV1Service == null) return;
        
        try {
            // 用户离开群
            SuperTeamMemberLeaveRequestV1 request = new SuperTeamMemberLeaveRequestV1();
            request.setAccid(member2);
            request.setTid(tid);
            Result<BaseSuperTeamResponseV1> result = superTeamV1Service.leave(request);
            Assert.assertTrue("Failed to leave super team: " + result.getMsg(), result.isSuccess());
            System.out.println("**leave team**" + JSON.toJSONString(result));
            
            // 踢出用户
            SuperTeamKickMemberRequestV1 kickRequest = new SuperTeamKickMemberRequestV1();
            kickRequest.setOwner(owner);
            kickRequest.setTid(tid);
            kickRequest.setKickAccids(Arrays.asList(member3));
            Result<BaseSuperTeamResponseV1> kickResult = superTeamV1Service.kick(kickRequest);
            Assert.assertTrue("Failed to kick member from super team: " + kickResult.getMsg(), kickResult.isSuccess());
            System.out.println("**kick**" + JSON.toJSONString(kickResult));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to leave and kick from super team: " + e.getMessage());
        }
    }
    
    @Test
    public void testAddAndRemoveManager() {
        if (superTeamV1Service == null) return;
        
        try {
            // 添加管理员
            SuperTeamAddManagerRequestV1 request = new SuperTeamAddManagerRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setManagerAccids(Arrays.asList(member1));
            Result<SuperTeamAddManagerResponseV1> result = superTeamV1Service.addManager(request);
            Assert.assertTrue("Failed to add manager to super team: " + result.getMsg(), result.isSuccess());
            System.out.println("**AddManager**" + JSON.toJSONString(result));
            
            // 移除管理员
            SuperTeamRemoveManagerRequestV1 removeRequest = new SuperTeamRemoveManagerRequestV1();
            removeRequest.setTid(tid);
            removeRequest.setOwner(owner);
            removeRequest.setManagerAccids(Arrays.asList(member1));
            Result<SuperTeamRemoveManagerResponseV1> removeResult = superTeamV1Service.removeManager(removeRequest);
            Assert.assertTrue("Failed to remove manager from super team: " + removeResult.getMsg(), removeResult.isSuccess());
            System.out.println("**remove manager**" + JSON.toJSONString(removeResult));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to add and remove manager: " + e.getMessage());
        }
    }
    
    @Test
    public void testChangeOwner() {
        if (superTeamV1Service == null) return;
        
        try {
            SuperTeamChangeOwnerRequestV1 request = new SuperTeamChangeOwnerRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setAccid(member1);
            request.setLeave(2);
            Result<SuperTeamChangeOwnerResponseV1> result = superTeamV1Service.changeOwner(request);
            Assert.assertTrue("Failed to change super team owner: " + result.getMsg(), result.isSuccess());
            System.out.println("**ChangeOwner**" + JSON.toJSONString(result));
            
            // 更新owner变量供后续测试和清理使用
            owner = member1;
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to change super team owner: " + e.getMessage());
        }
    }
    
    @Test
    public void testUpdateTlist() {
        if (superTeamV1Service == null) return;
        
        try {
            SuperTeamUpdateMemberInfoRequestV1 request = new SuperTeamUpdateMemberInfoRequestV1();
            request.setAccid(member4);
            request.setCustom("custom-member4");
            request.setNick("update-member4");
            request.setSilentType(1);
            request.setTid(tid);
            Result<BaseSuperTeamResponseV1> result = superTeamV1Service.updateTlist(request);
            Assert.assertTrue("Failed to update super team member: " + result.getMsg(), result.isSuccess());
            System.out.println("**UpdateTlist**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to update super team member: " + e.getMessage());
        }
    }
    
    @Test
    public void testSendAndQueryMessage() {
        if (superTeamV1Service == null) return;
        
        try {
            // 发送消息
            SendSuperTeamMessageRequestV1 request = new SendSuperTeamMessageRequestV1();
            request.setTid(tid);
            request.setFromAccid(owner);
            request.setType(0);
            request.setBody("{\"msg\":\"这是一条测试消息\"}");
            request.setMsgDesc("测试消息描述");
            request.setAntispam(true);
            request.setAntispamCustom("{\"key\":\"value\"}");
            request.setUseYidun(1);
            request.setEnv("production");
            
            Result<SendSuperTeamMessageResponseV1> result = superTeamV1Service.sendMsg(request);
            Assert.assertTrue("Failed to send super team message: " + result.getMsg(), result.isSuccess());
            System.out.println("**sendMessage**" + JSON.toJSONString(result.getResponse()));
            
            // 查询消息历史
            GetSuperTeamMessageRequestV1 queryRequest = new GetSuperTeamMessageRequestV1();
            queryRequest.setAccid(owner);
            queryRequest.setBegintime(0L);
            queryRequest.setEndtime(System.currentTimeMillis());
            queryRequest.setLimit(100);
            queryRequest.setTid(tid);
            Result<GetSuperTeamMessageResponseV1> queryResult = superTeamV1Service.queryHistoryMsg(queryRequest);
            Assert.assertTrue("Failed to query super team message: " + queryResult.getMsg(), queryResult.isSuccess());
            System.out.println("**QueryHistory**" + JSON.toJSONString(queryResult.getResponse()));
            
            // 使用msgid查询特定消息
            long msgId = result.getResponse().getMsgid();
            long time = result.getResponse().getTimetag();
            
            GetSuperTeamMessageByIdsRequestV1 byIdsRequest = new GetSuperTeamMessageByIdsRequestV1();
            GetSuperTeamMessageByIdsRequestV1.Msg msg = new GetSuperTeamMessageByIdsRequestV1.Msg();
            msg.setTo(tid);
            msg.setTime(time);
            msg.setFrom(owner);
            msg.setMsgid(msgId);
            byIdsRequest.setMsgs(Arrays.asList(msg));
            
            Result<GetSuperTeamMessageByIdsResponseV1> byIdsResult = superTeamV1Service.queryHistoryMsgByIds(byIdsRequest);
            Assert.assertTrue("Failed to query super team message by IDs: " + byIdsResult.getMsg(), byIdsResult.isSuccess());
            System.out.println("**QueryHistoryByIds**" + JSON.toJSONString(byIdsResult.getResponse()));
            
            // 撤回消息
            RecallAttachSuperMessageRequestV1 recallRequest = new RecallAttachSuperMessageRequestV1();
            recallRequest.setDeleteMsgid(msgId);
            recallRequest.setFrom(owner);
            recallRequest.setIgnoreTime(1);
            recallRequest.setPushContent("消息已撤回");
            recallRequest.setTimetag(time);
            recallRequest.setTo(tid);
            Result<BaseSuperTeamResponseV1> recallResult = superTeamV1Service.recallMsg(recallRequest);
            Assert.assertTrue("Failed to recall super team message: " + recallResult.getMsg(), recallResult.isSuccess());
            System.out.println("**RecallMsg**" + JSON.toJSONString(recallResult));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to send and query message: " + e.getMessage());
        }
    }
    
    @Test
    public void testSendAttachMsg() {
        if (superTeamV1Service == null) return;
        
        try {
            SendAttachSuperTeamMessageRequestV1 request = new SendAttachSuperTeamMessageRequestV1();
            request.setFrom(owner);
            request.setTo(tid);
            request.setAttach("{\"msg\":\"这是一条附件消息\"}");
            request.setPushContent("您收到一条新消息");
            request.setPushPayload("{\"payloadKey\":\"payloadValue\"}");
            request.setSound("notification_sound.mp3");
            request.setSave(2);
            request.setOption("{\"badge\":false,\"needPushNick\":false,\"route\":false}");
            request.setIsForcePush("false");
            
            Result<BaseSuperTeamResponseV1> result = superTeamV1Service.sendAttachMsg(request);
            Assert.assertTrue("Failed to send attach message to super team: " + result.getMsg(), result.isSuccess());
            System.out.println("**SendAttachMsg**"+JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to send attach message: " + e.getMessage());
        }
    }

    @AfterClass
    public static void tearDown() {
        if (superTeamV1Service == null) return;
        
        try {
            SuperTeamDismissRequestV1 request = new SuperTeamDismissRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            Result<SuperTeamDismissResponseV1> result = superTeamV1Service.dismiss(request);
            System.out.println("Dismissed super team: " + JSON.toJSONString(result));
        } catch (Exception e) {
            System.err.println("Error dismissing super team: " + e.getMessage());
        }
    }
}

