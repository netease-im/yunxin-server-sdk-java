package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.im.server.sdk.v1.chatroom.IChatRoomV1Service;
import com.netease.nim.im.server.sdk.v1.chatroom.reponse.CreateChatroomResponseV1;
import com.netease.nim.im.server.sdk.v1.chatroom.request.CreateChatroomRequestV1;
import com.netease.nim.im.server.sdk.v1.chatroom_message.IChatroomMessageV1Service;
import com.netease.nim.im.server.sdk.v1.chatroom_message.request.SendChatroomMsgRequestV1;
import com.netease.nim.im.server.sdk.v1.chatroom_message.response.SendChatroomMsgResponseV1;
import com.netease.nim.im.server.sdk.v1.history.IHistoryV1Service;
import com.netease.nim.im.server.sdk.v1.history.request.*;
import com.netease.nim.im.server.sdk.v1.history.response.*;
import com.netease.nim.im.server.sdk.v1.message.IMessageV1Service;
import com.netease.nim.im.server.sdk.v1.message.request.BroadcastMessageRequestV1;
import com.netease.nim.im.server.sdk.v1.message.response.BroadcastMessageResponseV1;
import com.netease.nim.im.server.sdk.v1.team.ITeamV1Service;
import com.netease.nim.im.server.sdk.v1.team.request.CreateTeamRequestV1;
import com.netease.nim.im.server.sdk.v1.team.response.CreateTeamResponseV1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TestHistoryV1 {

    private static YunxinV1ApiServices services = null;
    private static IHistoryV1Service historyV1Service = null;
    private static IMessageV1Service messageV1Service = null;
    private static IChatroomMessageV1Service chatroomMessageV1Service = null;

    private static final String accid1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static Long tid;
    private static Long roomid;

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
        historyV1Service = services.getHistoryV1Service();
        messageV1Service = services.getMessageV1Service();
        chatroomMessageV1Service = services.getChatroomMessageV1Service();
        
        // 创建测试资源
        try {
            createAccount(accid1);
            createAccount(accid2);
            tid = createTeam(Arrays.asList(accid1,accid2)).getTid();
            roomid = createChatroom(accid1).getRoomId();
            System.out.println("Test accounts and resources created:");
            System.out.println("accid1 = " + accid1);
            System.out.println("accid2 = " + accid2);
            System.out.println("tid = " + tid);
            System.out.println("roomid = " + roomid);
        } catch (Exception e) {
            System.err.println("Failed to initialize test resources: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testQuerySessionHistoryMessage() {
        if (historyV1Service == null) return;
        querySessionHistoryMessage(accid1, accid2);
    }

    @Test
    public void testQueryTeamHistoryMessage() {
        if (historyV1Service == null) return;
        queryTeamHistoryMessage(tid, accid1);
    }

    @Test
    public void testQueryChatroomHistoryMessage() {
        if (historyV1Service == null) return;
        queryChatroomHistoryMessage(roomid, accid1);
    }

    @Test
    public void testDeleteChatroomHistoryMessage() throws InterruptedException {
        if (historyV1Service == null || chatroomMessageV1Service == null) return;
        
        // 发送消息然后删除它
        SendChatroomMsgResponseV1 response = sendChatroomMsg(roomid, accid1);
        Thread.sleep(5000L); // 等待消息处理
        deleteChatroomHistoryMessage(roomid, accid1, response.getTime());
    }

    @Test
    public void testQuerySessionList() {
        if (historyV1Service == null) return;
        querySessionList(accid1);
    }

    @Test
    public void testQueryBroadcastHistoryMessageById() {
        if (historyV1Service == null || messageV1Service == null) return;
        
        // 先广播消息，然后查询它
        BroadcastMessageResponseV1 response = broadcastMessage(accid1);
        queryBroadcastHistoryMessageById(response.getBroadcastId());
    }

    @Test
    public void testQueryBroadcastHistoryMessage() {
        if (historyV1Service == null || messageV1Service == null) return;
        
        // 先广播消息，然后查询它
        BroadcastMessageResponseV1 response = broadcastMessage(accid1);
        queryBroadcastHistoryMessage(response.getBroadcastId());
    }

    @Test
    public void testQueryUserEvents() {
        if (historyV1Service == null) return;
        queryUserEvents(accid1);
    }

    /**
     * 查询单聊历史消息
     */
    private static void querySessionHistoryMessage(String fromAccid, String toAccid) {
        try {
            QuerySessionHistoryMessageRequestV1 request = new QuerySessionHistoryMessageRequestV1();
            request.setFrom(fromAccid);
            request.setTo(toAccid);
            request.setBegintime(0L);
            request.setEndtime(System.currentTimeMillis());
            request.setLimit(100);
            request.setReverse(1);
            request.setType(null);
            request.setIncludeNoSenseMsg(null);
            request.setExcludeMsgid(null);
            
            Result<QuerySessionHistoryMessageResponseV1> result = historyV1Service.querySessionHistoryMessage(request);
            System.out.println("**querySessionHistoryMessage**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error querying session history: " + e.getMessage());
            Assert.fail("Query session history failed: " + e.getMessage());
        }
    }

    /**
     * 查询群聊历史消息
     */
    private static void queryTeamHistoryMessage(Long tid, String accid) {
        try {
            QueryTeamHistoryMessageRequestV1 request = new QueryTeamHistoryMessageRequestV1();
            request.setTid(tid);
            request.setAccid(accid);
            request.setBegintime(0L);
            request.setEndtime(System.currentTimeMillis());
            request.setLimit(100);
            request.setReverse(1);
            request.setType(null);
            request.setCheckTeamValid(true);
            request.setIncludeNoSenseMsg(null);
            request.setExcludeMsgid(null);
            
            Result<QueryTeamHistoryMessageResponseV1> result = historyV1Service.queryTeamHistoryMessage(request);
            System.out.println("**queryTeamHistoryMessage**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error querying team history: " + e.getMessage());
            Assert.fail("Query team history failed: " + e.getMessage());
        }
    }

    /**
     * 查询聊天室历史消息
     */
    private static QueryChatroomHistoryMessageResponseV1 queryChatroomHistoryMessage(Long roomid, String accid) {
        try {
            QueryChatroomHistoryMessageRequestV1 request = new QueryChatroomHistoryMessageRequestV1();
            request.setRoomid(roomid);
            request.setAccid(accid);
            request.setTimetag(0L);
            request.setLimit(100);
            request.setReverse(1);
            request.setType(null);
            
            Result<QueryChatroomHistoryMessageResponseV1> result = historyV1Service.queryChatroomHistoryMessage(request);
            System.out.println("**queryChatroomHistoryMessage**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
            return result.getResponse();
        } catch (Exception e) {
            System.err.println("Error querying chatroom history: " + e.getMessage());
            Assert.fail("Query chatroom history failed: " + e.getMessage());
            return null;
        }
    }

    /**
     * 删除聊天室历史消息
     */
    private static void deleteChatroomHistoryMessage(Long roomid, String accid, Long msgTimetag) {
        try {
            DeleteChatroomHistoryMessageRequestV1 request = new DeleteChatroomHistoryMessageRequestV1();
            request.setRoomid(roomid);
            request.setFromAcc(accid);
            request.setMsgTimetag(msgTimetag);
            
            Result<DeleteChatroomHistoryMessageResponseV1> result = historyV1Service.deleteChatroomHistoryMessage(request);
            System.out.println("**deleteChatroomHistoryMessage**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error deleting chatroom history: " + e.getMessage());
            Assert.fail("Delete chatroom history failed: " + e.getMessage());
        }
    }

    /**
     * 查询会话列表
     */
    private static void querySessionList(String accid) {
        try {
            QuerySessionListRequestV1 request = new QuerySessionListRequestV1();
            request.setAccid(accid);
            request.setMinTimestamp(0L);
            request.setMaxTimestamp(System.currentTimeMillis());
            request.setLimit(100);
            request.setNeedLastMsg(0);
            
            Result<QuerySessionListResponseV1> result = historyV1Service.querySessionList(request);
            System.out.println("**querySessionList**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error querying session list: " + e.getMessage());
            Assert.fail("Query session list failed: " + e.getMessage());
        }
    }

    /**
     * 根据ID查询广播消息历史
     */
    private static void queryBroadcastHistoryMessageById(Long broadcastId) {
        try {
            QueryBroadcastHistoryMessageByIdRequestV1 request = new QueryBroadcastHistoryMessageByIdRequestV1();
            request.setBroadcastId(broadcastId);
            
            Result<QueryBroadcastHistoryMessageByIdResponseV1> result = historyV1Service.queryBroadcastHistoryMessageById(request);
            System.out.println("**queryBroadcastHistoryMessageById**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error querying broadcast history by ID: " + e.getMessage());
            Assert.fail("Query broadcast history by ID failed: " + e.getMessage());
        }
    }

    /**
     * 查询广播消息历史
     */
    private static void queryBroadcastHistoryMessage(Long broadcastId) {
        try {
            QueryBroadcastHistoryMessageRequestV1 request = new QueryBroadcastHistoryMessageRequestV1();
            request.setBroadcastId(broadcastId);
            request.setLimit(100);
            request.setType(1L);
            
            Result<QueryBroadcastHistoryMessageResponseV1> result = historyV1Service.queryBroadcastHistoryMessage(request);
            System.out.println("**queryBroadcastHistoryMessage**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error querying broadcast history: " + e.getMessage());
            Assert.fail("Query broadcast history failed: " + e.getMessage());
        }
    }

    /**
     * 查询用户事件
     */
    private static void queryUserEvents(String accid) {
        try {
            QueryUserEventsRequestV1 request = new QueryUserEventsRequestV1();
            request.setAccid(accid);
            request.setBegintime(0L);
            request.setEndtime(System.currentTimeMillis());
            request.setLimit(100);
            request.setReverse(1);
            
            Result<QueryUserEventsResponseV1> result = historyV1Service.queryUserEvents(request);
            System.out.println("**queryUserEvents**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error querying user events: " + e.getMessage());
            Assert.fail("Query user events failed: " + e.getMessage());
        }
    }

    /**
     * 发送广播消息
     */
    private static BroadcastMessageResponseV1 broadcastMessage(String fromAccid) {
        try {
            BroadcastMessageRequestV1 request = new BroadcastMessageRequestV1();
            request.setBody("{\"msg\":\"哈哈哈\"}");
            request.setFrom(fromAccid);
            request.setOffline(true);
            request.setTargetOs(null);
            
            Result<BroadcastMessageResponseV1> result = messageV1Service.broadcastMessage(request);
            System.out.println("**broadcastMessage**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
            return result.getResponse();
        } catch (Exception e) {
            System.err.println("Error broadcasting message: " + e.getMessage());
            Assert.fail("Broadcast message failed: " + e.getMessage());
            return null;
        }
    }

    /**
     * 发送聊天室消息
     */
    private static SendChatroomMsgResponseV1 sendChatroomMsg(Long roomid, String fromAccid) throws YunxinSdkException {
        try {
            SendChatroomMsgRequestV1 request = new SendChatroomMsgRequestV1();
            request.setRoomId(roomid);
            request.setMsgId(UUID.randomUUID().toString());
            request.setAttach("This is the message content."); // Message content
            request.setFromAccid(fromAccid);
            request.setMsgType(0);
            request.setResendFlag(0);
            
            Result<SendChatroomMsgResponseV1> result = chatroomMessageV1Service.sendMsg(request);
            System.out.println("**sendChatroomMsg**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
            return result.getResponse();
        } catch (Exception e) {
            System.err.println("Error sending chatroom message: " + e.getMessage());
            Assert.fail("Send chatroom message failed: " + e.getMessage());
            return null;
        }
    }

    /**
     * 创建测试账号
     */
    private static void createAccount(String accid) {
        try {
            CreateAccountRequestV1 request = new CreateAccountRequestV1();
            request.setAccid(accid);
            request.setName("test-" + accid.substring(0, 6));
            request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            
            IAccountV1Service accountService = services.getAccountService();
            Result<CreateAccountResponseV1> result = accountService.createAccount(request);
            
            // 如果账号已存在，不视为错误
            if (result.getCode() == 414) {
                System.out.println("Account " + accid + " already exists");
            } else {
                Assert.assertEquals(200, result.getCode());
                Assert.assertEquals(request.getAccid(), result.getResponse().getAccid());
                System.out.println("Created account: " + accid);
            }
        } catch (Exception e) {
            System.err.println("Error creating account " + accid + ": " + e.getMessage());
            Assert.fail("Create account failed: " + e.getMessage());
        }
    }

    /**
     * 创建测试群组
     */
    private static CreateTeamResponseV1 createTeam(List<String> members) {
        try {
            CreateTeamRequestV1 request = new CreateTeamRequestV1();
            request.setTname("TestTeam-" + System.currentTimeMillis());
            request.setOwner(members.get(0));
            request.setMembers(members);
            request.setMsg("Welcome to the team");
            request.setMagree(0);
            request.setJoinMode(0);
            
            ITeamV1Service teamService = services.getTeamService();
            Result<CreateTeamResponseV1> result = teamService.createTeam(request);
            System.out.println("**createTeam**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
            return result.getResponse();
        } catch (Exception e) {
            System.err.println("Error creating team: " + e.getMessage());
            Assert.fail("Create team failed: " + e.getMessage());
            return null;
        }
    }

    /**
     * 创建测试聊天室
     */
    private static CreateChatroomResponseV1 createChatroom(String creator) {
        try {
            CreateChatroomRequestV1 request = new CreateChatroomRequestV1();
            request.setCreator(creator);
            request.setRoomName("TestChatRoom-" + System.currentTimeMillis());
            request.setDelayClosePolicy(1);
            
            IChatRoomV1Service chatRoomService = services.getChatRoomService();
            Result<CreateChatroomResponseV1> result = chatRoomService.createChatroom(request);
            System.out.println("**createChatroom**" + JSON.toJSONString(result));
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
            return result.getResponse();
        } catch (Exception e) {
            System.err.println("Error creating chatroom: " + e.getMessage());
            Assert.fail("Create chatroom failed: " + e.getMessage());
            return null;
        }
    }
}
