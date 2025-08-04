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
import com.netease.nim.server.sdk.im.v1.team.ITeamV1Service;
import com.netease.nim.server.sdk.im.v1.team.request.*;
import com.netease.nim.server.sdk.im.v1.team.response.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 群组API功能测试类
 */
public class TestTeamV1 {

    private static YunxinV1ApiServices services = null;
    private static ITeamV1Service teamV1Service = null;
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
        teamV1Service = services.getTeamService();
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

        // 创建一个测试群组
        try {
            CreateTeamRequestV1 request = new CreateTeamRequestV1();
            request.setOwner(owner);
            request.setTname("teamTest" + System.currentTimeMillis());
            request.setJoinmode(0);
            request.setMagree(0);
            request.setMsg("欢迎加入群聊");
            
            // 添加测试成员
            List<String> members = new ArrayList<>();
            members.add(member1);
            members.add(member2);
            members.add(member3);
            members.add(member4);
            request.setMembers(members);
            
            Result<CreateTeamResponseV1> result = teamV1Service.createTeam(request);
            Assert.assertTrue("Failed to create team: " + result.getMsg(), result.isSuccess());
            tid = result.getResponse().getTid();
            System.out.println("Created team with id: " + tid);
        } catch (Exception e) {
            System.err.println("Error creating test team: " + e.getMessage());
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
    public void testUpdateTeam() {
        if (teamV1Service == null) return;
        
        try {
            UpdateTeamRequestV1 request = new UpdateTeamRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setTname("更新的群名称");
            request.setAnnouncement("这是群公告");
            request.setIntro("这是群介绍");
            request.setJoinmode(0);
            Result<UpdateTeamResponseV1> result = teamV1Service.updateTeam(request);
            Assert.assertTrue("Failed to update team: " + result.getMsg(), result.isSuccess());
            System.out.println("**UpdateTeam**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to update team: " + e.getMessage());
        }
    }
    
    @Test
    public void testQueryTeam() {
        if (teamV1Service == null) return;
        
        try {
            QueryTeamRequestV1 request = new QueryTeamRequestV1();
            request.setTids(Arrays.asList(tid));
            request.setOpe(1);
            Result<QueryTeamResponseV1> result = teamV1Service.queryTeam(request);
            Assert.assertTrue("Failed to query team: " + result.getMsg(), result.isSuccess());
            System.out.println("**QueryTeam**" + JSON.toJSONString(result.getResponse()));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to query team: " + e.getMessage());
        }
    }
    
    @Test
    public void testAddTeamMember() {
        if (teamV1Service == null) return;
        
        try {
            AddTeamRequestV1 request = new AddTeamRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setMsg("邀请加入群聊");
            request.setMembers(Arrays.asList(member));
            Result<AddTeamResponseV1> result = teamV1Service.addTeam(request);
            Assert.assertTrue("Failed to add team member: " + result.getMsg(), result.isSuccess());
            System.out.println("**AddTeam**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to add team member: " + e.getMessage());
        }
    }
    
    @Test
    public void testUpdateTeamMemberNick() {
        if (teamV1Service == null) return;
        
        try {
            // 先添加成员
            testAddTeamMember();
            
            UpdateTeamNickRequestV1 request = new UpdateTeamNickRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setAccid(member);
            request.setNick("测试昵称");
            Result<UpdateTeamNickResponseV1> result = teamV1Service.updateTeamMemberNick(request);
            Assert.assertTrue("Failed to update team member nick: " + result.getMsg(), result.isSuccess());
            System.out.println("**UpdateTeamMemberNick**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to update team member nick: " + e.getMessage());
        }
    }
    
    @Test
    public void testQueryJoinedTeamList() {
        if (teamV1Service == null) return;
        
        try {
            // 确保成员已添加到群组
            testAddTeamMember();
            
            JoinsTeamRequestV1 request = new JoinsTeamRequestV1();
            request.setAccid(member);
            Result<JoinsTeamResponseV1> result = teamV1Service.queryJoinedTeamListByAccId(request);
            Assert.assertTrue("Failed to query joined team list: " + result.getMsg(), result.isSuccess());
            System.out.println("**QueryJoinedTeamList**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to query joined team list: " + e.getMessage());
        }
    }
    
    @Test
    public void testMuteTeam() {
        if (teamV1Service == null) return;
        
        try {
            MuteTeamRequestV1 request = new MuteTeamRequestV1();
            request.setTid(tid);
            request.setAccid(owner);
            request.setOpe(1);
            Result<MuteTeamResponseV1> result = teamV1Service.muteTeam(request);
            Assert.assertTrue("Failed to mute team: " + result.getMsg(), result.isSuccess());
            System.out.println("**MuteTeam**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to mute team: " + e.getMessage());
        }
    }
    
    @Test
    public void testMuteTeamMember() {
        if (teamV1Service == null) return;
        
        try {
            // 确保成员已添加到群组
            testAddTeamMember();
            
            MuteTeamTargetMemberRequestV1 request = new MuteTeamTargetMemberRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setMute(1);
            request.setAccid(member);
            Result<MuteTeamTargetMemberResponseV1> result = teamV1Service.muteTeamTargetMember(request);
            Assert.assertTrue("Failed to mute team member: " + result.getMsg(), result.isSuccess());
            System.out.println("**MuteTeamMember**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to mute team member: " + e.getMessage());
        }
    }
    
    @Test
    public void testQueryMuteTeamMembers() {
        if (teamV1Service == null) return;
        
        try {
            // 确保成员已被禁言
            testMuteTeamMember();
            
            QueryMuteTeamMembersRequestV1 request = new QueryMuteTeamMembersRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            Result<QueryMuteTeamMembersResponseV1> result = teamV1Service.queryMuteTeamMembers(request);
            Assert.assertTrue("Failed to query mute team members: " + result.getMsg(), result.isSuccess());
            System.out.println("**QueryMuteTeamMembers**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to query mute team members: " + e.getMessage());
        }
    }
    
    @Test
    public void testLeaveTeam() {
        if (teamV1Service == null) return;
        
        try {
            LeaveTeamRequestV1 request = new LeaveTeamRequestV1();
            request.setTid(tid);
            request.setAccid(member2);
            Result<LeaveTeamResponseV1> result = teamV1Service.leaveTeam(request);
            Assert.assertTrue("Failed to leave team: " + result.getMsg(), result.isSuccess());
            System.out.println("**LeaveTeam**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to leave team: " + e.getMessage());
        }
    }
    
    @Test
    public void testKickTeam() {
        if (teamV1Service == null) return;
        
        try {
            List<String> members = new ArrayList<>();
            members.add(member3);
            
            KickTeamRequestV1 request = new KickTeamRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setMembers(members);
            Result<KickTeamResponseV1> result = teamV1Service.kickTeam(request);
            Assert.assertTrue("Failed to kick team: " + result.getMsg(), result.isSuccess());
            System.out.println("**KickTeam**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to kick team: " + e.getMessage());
        }
    }
    
    @Test
    public void testAddAndRemoveManagerTeam() {
        if (teamV1Service == null) return;
        
        try {
            // 添加管理员
            List<String> members = new ArrayList<>();
            members.add(member4);
            
            AddManagerTeamRequestV1 request = new AddManagerTeamRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setMembers(members);
            Result<AddManagerTeamResponseV1> result = teamV1Service.addManagerTeam(request);
            System.out.println(result.getMsg());
            System.out.println(result.getCode());
            Assert.assertTrue("Failed to add manager team: " + result.getMsg(), result.isSuccess());
            System.out.println("**AddManagerTeam**" + JSON.toJSONString(result));
            
            // 移除管理员
            RemoveManagerTeamRequestV1 removeRequest = new RemoveManagerTeamRequestV1();
            removeRequest.setTid(tid);
            removeRequest.setOwner(owner);
            removeRequest.setMembers(members);
            Result<RemoveManagerTeamResponseV1> removeResult = teamV1Service.removeManagerTeam(removeRequest);
            Assert.assertTrue("Failed to remove manager team: " + removeResult.getMsg(), removeResult.isSuccess());
            System.out.println("**RemoveManagerTeam**" + JSON.toJSONString(removeResult));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to manage team roles: " + e.getMessage());
        }
    }
    
    @Test
    public void testChangeOwnerTeam() {
        if (teamV1Service == null) return;
        
        try {
            ChangeOwnerTeamRequestV1 request = new ChangeOwnerTeamRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            request.setNewOwner(member1);
            request.setLeave(2);
            Result<ChangeOwnerTeamResponseV1> result = teamV1Service.changeOwnerTeam(request);
            Assert.assertTrue("Failed to change owner team: " + result.getMsg(), result.isSuccess());
            System.out.println("**ChangeOwnerTeam**" + JSON.toJSONString(result));
            
            // 更新当前的owner变量，以便后续测试和清理使用正确的群主
            owner = member1;
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to change owner team: " + e.getMessage());
        }
    }
    
    @Test
    public void testQueryOnlineTeamMember() {
        if (teamV1Service == null) return;
        
        try {
            QueryOnlineTeamMemberRequestV1 request = new QueryOnlineTeamMemberRequestV1();
            request.setTid(tid);
            Result<QueryOnlineTeamMemberResponseV1> result = teamV1Service.queryOnlineTeamMember(request);
            Assert.assertTrue("Failed to query online team member: " + result.getMsg(), result.isSuccess());
            System.out.println("**QueryOnlineTeamMember**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to query online team member: " + e.getMessage());
        }
    }
    
    @Test
    public void testBatchQueryOnlineTeamMemberCount() {
        if (teamV1Service == null) return;
        
        try {
            BatchQueryOnlineTeamMemberCountRequestV1 request = new BatchQueryOnlineTeamMemberCountRequestV1();
            request.setTids(Arrays.asList(tid));
            Result<BatchQueryOnlineTeamMemberCountResponseV1> result = teamV1Service.batchQueryOnlineTeamMemberCount(request);
            Assert.assertTrue("Failed to batch query online team member count: " + result.getMsg(), result.isSuccess());
            System.out.println("**BatchQueryOnlineTeamMemberCount**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to batch query online team member count: " + e.getMessage());
        }
    }
    
    @Test
    public void testQueryTeamInfoDetails() {
        if (teamV1Service == null) return;
        
        try {
            QueryTeamInfoDetailsRequestV1 request = new QueryTeamInfoDetailsRequestV1();
            request.setTid(tid);
            Result<QueryTeamInfoDetailsResponseV1> result = teamV1Service.queryTeamInfoDetails(request);
            Assert.assertTrue("Failed to query team info details: " + result.getMsg(), result.isSuccess());
            System.out.println("**QueryTeamInfoDetails**" + JSON.toJSONString(result));
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to query team info details: " + e.getMessage());
        }
    }
    
    @AfterClass
    public static void tearDown() {
        if (teamV1Service == null) return;
        
        try {
            DismissTeamRequestV1 request = new DismissTeamRequestV1();
            request.setTid(tid);
            request.setOwner(owner);
            Result<DismissTeamResponseV1> result = teamV1Service.dismissTeam(request);
            System.out.println("Dismissed team: " + JSON.toJSONString(result));
        } catch (Exception e) {
            System.err.println("Error dismissing team: " + e.getMessage());
        }
    }
} 