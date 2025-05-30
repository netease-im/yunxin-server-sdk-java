package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.im.server.sdk.v1.chatroom.IChatRoomV1Service;
import com.netease.nim.im.server.sdk.v1.chatroom.response.CreateChatroomResponseV1;
import com.netease.nim.im.server.sdk.v1.chatroom.request.CreateChatroomRequestV1;
import com.netease.nim.im.server.sdk.v1.chatroom_message.IChatroomMessageV1Service;
import com.netease.nim.im.server.sdk.v1.chatroom_message.request.SendChatroomMsgRequestV1;
import com.netease.nim.im.server.sdk.v1.chatroom_message.response.SendChatroomMsgResponseV1;
import com.netease.nim.im.server.sdk.v1.history.IHistoryV1Service;
import com.netease.nim.im.server.sdk.v1.history.model.Message;
import com.netease.nim.im.server.sdk.v1.history.model.TextMessage;
import com.netease.nim.im.server.sdk.v1.history.model.ImageMessage;
import com.netease.nim.im.server.sdk.v1.history.model.FileMessage;
import com.netease.nim.im.server.sdk.v1.history.model.LocationMessage;
import com.netease.nim.im.server.sdk.v1.history.model.AudioMessage;
import com.netease.nim.im.server.sdk.v1.history.model.VideoMessage;
import com.netease.nim.im.server.sdk.v1.history.model.TipMessage;
import com.netease.nim.im.server.sdk.v1.history.request.*;
import com.netease.nim.im.server.sdk.v1.history.response.*;
import com.netease.nim.im.server.sdk.v1.message.IMessageV1Service;
import com.netease.nim.im.server.sdk.v1.message.request.BroadcastMessageRequestV1;
import com.netease.nim.im.server.sdk.v1.message.request.SendMessageRequestV1;
import com.netease.nim.im.server.sdk.v1.message.response.BroadcastMessageResponseV1;
import com.netease.nim.im.server.sdk.v1.message.response.SendMessageResponseV1;
import com.netease.nim.im.server.sdk.v1.team.ITeamV1Service;
import com.netease.nim.im.server.sdk.v1.team.request.CreateTeamRequestV1;
import com.netease.nim.im.server.sdk.v1.team.response.CreateTeamResponseV1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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

    @Test
    public void testSendAndQueryTeamMessages() {
        if (messageV1Service == null || historyV1Service == null) return;
        
        try {
            // 发送各种类型的消息
            sendTextTeamMessage(accid1, tid);
            sendImageTeamMessage(accid1, tid);
            sendAudioTeamMessage(accid1, tid);
            sendVideoTeamMessage(accid1, tid);
            sendLocationTeamMessage(accid1, tid);
            sendFileTeamMessage(accid1, tid);
            sendCustomTeamMessage(accid1, tid);
            sendTipTeamMessage(accid1, tid);
            // 等待消息处理
            Thread.sleep(5000L);
            
            // 查询消息并按类型输出
            queryTeamHistoryMessagesByType(tid, accid1);
        } catch (Exception e) {
            System.err.println("Error in testSendAndQueryTeamMessages: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void testNotificationMessages() {
        if (historyV1Service == null || messageV1Service == null) return;
        
        try {
            // 等待消息处理
            Thread.sleep(5000L);
            
            // 2. 查询团队消息并筛选出通知消息(type=5)
            queryTeamNotificationMessages(tid, accid1);
            
            // 3. 验证聊天室通知消息
            // 创建聊天室成员进入/退出等操作会产生通知消息
            testChatroomNotificationMessages(roomid, accid1);
        } catch (Exception e) {
            System.err.println("Error in testNotificationMessages: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed: " + e.getMessage());
        }
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
            
            // 输出消息详情，用于验证消息模型
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsgs() != null) {
                List<Message> messages = result.getResponse().getMsgs();
                System.out.println("Retrieved " + messages.size() + " session messages");
                for (Message message : messages) {
                    System.out.println("Session message type: " + message.getType() + ", from: " + message.getFrom());
                    System.out.println("Session message body: " + JSON.toJSONString(message.getBody()));
                }
            }
            
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
            
            // 输出消息详情，用于验证消息模型
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsgs() != null) {
                List<Message> messages = result.getResponse().getMsgs();
                System.out.println("Retrieved " + messages.size() + " messages");
                for (Message message : messages) {
                    System.out.println("Message type: " + message.getType() + ", from: " + message.getFrom());
                    System.out.println("Message body: " + JSON.toJSONString(message.getBody()));
                }
            }
            
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
            request.setType("5"); // 仅查询通知消息
            
            Result<QueryChatroomHistoryMessageResponseV1> result = historyV1Service.queryChatroomHistoryMessage(request);
            System.out.println("**queryChatroomHistoryMessage**" + JSON.toJSONString(result));
            
            // 输出消息详情，用于验证消息模型
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsgs() != null) {
                List<Message> messages = result.getResponse().getMsgs();
                System.out.println("Retrieved " + messages.size() + " chatroom messages");
                for (Message message : messages) {
                    System.out.println("Chatroom message type: " + message.getType() + ", from: " + message.getFrom());
                    System.out.println("Chatroom message body: " + JSON.toJSONString(message.getBody()));
                }
            }
            
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
            
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsg() != null) {
                QueryBroadcastHistoryMessageByIdResponseV1.BroadcastMessage msg = result.getResponse().getMsg();
                System.out.println("广播消息详情:");
                System.out.println("广播ID: " + msg.getBroadcastId());
                System.out.println("消息内容: " + msg.getBody());
                System.out.println("创建时间: " + msg.getCreateTime());
                System.out.println("过期时间: " + msg.getExpireTime());
                System.out.println("是否存离线: " + msg.getIsOffline());
                if (msg.getTargetOs() != null) {
                    System.out.println("目标平台: " + String.join(", ", msg.getTargetOs()));
                }
            }
            
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

            // 输出消息详情，用于验证消息模型
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsgs() != null) {
                List<QueryBroadcastHistoryMessageResponseV1.BroadcastMessage> messages = result.getResponse().getMsgs();
                System.out.println("Retrieved " + messages.size() + " broadcast messages");
                
                for (QueryBroadcastHistoryMessageResponseV1.BroadcastMessage message : messages) {
                    System.out.println("广播消息详情:");
                    System.out.println("广播ID: " + message.getBroadcastId());
                    System.out.println("消息内容: " + message.getBody());
                    System.out.println("创建时间: " + message.getCreateTime());
                    System.out.println("过期时间: " + message.getExpireTime());
                    System.out.println("是否存离线: " + message.getIsOffline());
                    if (message.getTargetOs() != null) {
                        System.out.println("目标平台: " + String.join(", ", message.getTargetOs()));
                    }
                    System.out.println("------------------------------");
                }
            }
            
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

    /**
     * 发送文本消息到群组
     */
    private static SendMessageResponseV1 sendTextTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(0); // 文本消息

        // 文本消息体
        JSONObject body = new JSONObject();
        body.put("msg", "这是一条测试文本消息");
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 文本消息");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendTextTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 发送图片消息到群组
     */
    private static SendMessageResponseV1 sendImageTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(1); // 图片消息

        // 图片消息体
        JSONObject body = new JSONObject();
        body.put("name", "测试图片.jpg");
        body.put("md5", "9894907e4ad9de4678091277509361f7");
        body.put("url", "http://example.com/image.jpg");
        body.put("ext", "jpg");
        body.put("w", 800);
        body.put("h", 600);
        body.put("size", 102400);
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 图片");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendImageTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 发送语音消息到群组
     */
    private static SendMessageResponseV1 sendAudioTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(2); // 语音消息

        // 语音消息体
        JSONObject body = new JSONObject();
        body.put("dur", 3000); // 时长3秒
        body.put("md5", "87b94a090dec5c58f242b7132a530a01");
        body.put("url", "http://example.com/audio.aac");
        body.put("ext", "aac");
        body.put("size", 16420);
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 语音");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendAudioTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 发送视频消息到群组
     */
    private static SendMessageResponseV1 sendVideoTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(3); // 视频消息

        // 视频消息体
        JSONObject body = new JSONObject();
        body.put("dur", 10000); // 时长10秒
        body.put("md5", "da2cef3e5663ee9c3547ef5d127f7e3e");
        body.put("url", "http://example.com/video.mp4");
        body.put("w", 1280);
        body.put("h", 720);
        body.put("ext", "mp4");
        body.put("size", 2048000);
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 视频");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendVideoTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 发送地理位置消息到群组
     */
    private static SendMessageResponseV1 sendLocationTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(4); // 地理位置消息

        // 地理位置消息体
        JSONObject body = new JSONObject();
        body.put("title", "杭州市网商路599号");
        body.put("lng", 120.1908686708565);
        body.put("lat", 30.18704515647036);
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 位置");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendLocationTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 发送文件消息到群组
     */
    private static SendMessageResponseV1 sendFileTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(6); // 文件消息

        // 文件消息体
        JSONObject body = new JSONObject();
        body.put("name", "测试文件.pdf");
        body.put("md5", "79d62a35fa3d34c367b20c66afc2a500");
        body.put("url", "http://example.com/file.pdf");
        body.put("ext", "pdf");
        body.put("size", 1024000);
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 文件");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendFileTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 发送自定义消息到群组
     */
    private static SendMessageResponseV1 sendCustomTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(100); // 自定义消息

        // 自定义消息体
        JSONObject body = new JSONObject();
        body.put("customType", "poll");
        body.put("title", "投票: 今天晚上吃什么?");
        body.put("options", Arrays.asList("火锅", "烧烤", "日料", "自助"));
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 投票");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendCustomTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 发送提示消息到群组
     */
    private static SendMessageResponseV1 sendTipTeamMessage(String fromAccid, Long tid) throws YunxinSdkException {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(1); // 1表示群消息
        request.setTo(String.valueOf(tid));
        request.setType(10); // 提示消息

        // 提示消息体
        JSONObject body = new JSONObject();
        body.put("msg", "这是一条提示消息，请注意查看");
        request.setBody(body.toJSONString());

        // 推送选项
        request.setPushcontent("新消息: 提示");
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendTipTeamMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    /**
     * 查询群聊历史消息并按类型输出
     */
    private static void queryTeamHistoryMessagesByType(Long tid, String accid) {
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
            System.out.println("**queryTeamHistoryMessagesByType**" + JSON.toJSONString(result));
            
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsgs() != null) {
                List<Message> messages = result.getResponse().getMsgs();
                System.out.println("\n========== 查询到 " + messages.size() + " 条群消息 ==========\n");
                
                for (Message message : messages) {
                    Integer type = message.getType();
                    System.out.println("消息ID: " + message.getMsgid() + ", 发送者: " + message.getFrom() + 
                                       ", 发送时间: " + message.getSendtime());
                    
                    switch (type) {
                        case 0: // 文本消息
                            try {
                                Object bodyObj = message.getBody();
                                if (bodyObj instanceof TextMessage.Body) {
                                    TextMessage.Body textBody = (TextMessage.Body) bodyObj;
                                    System.out.println("文本消息: " + textBody.getMsg());
                                } else {
                                    // Convert JSON to proper body object
                                    JSONObject jsonBody = bodyObj instanceof JSONObject ? 
                                        (JSONObject) bodyObj : 
                                        JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                    
                                    System.out.println("文本消息: " + jsonBody.getString("msg"));
                                }
                            } catch (Exception e) {
                                System.out.println("解析文本消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        case 1: // 图片消息
                            try {
                                Object bodyObj = message.getBody();
                                if (bodyObj instanceof ImageMessage.Body) {
                                    ImageMessage.Body imgBody = (ImageMessage.Body) bodyObj;
                                    System.out.println("图片消息: " + imgBody.getName() + 
                                                    ", 尺寸: " + imgBody.getW() + "x" + imgBody.getH() + 
                                                    ", URL: " + imgBody.getUrl());
                                } else {
                                    // Convert JSON to proper body object
                                    JSONObject jsonBody = bodyObj instanceof JSONObject ? 
                                        (JSONObject) bodyObj : 
                                        JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                    
                                    System.out.println("图片消息: " + jsonBody.getString("name") + 
                                                    ", 尺寸: " + jsonBody.getInteger("w") + "x" + jsonBody.getInteger("h") + 
                                                    ", URL: " + jsonBody.getString("url"));
                                }
                            } catch (Exception e) {
                                System.out.println("解析图片消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        case 2: // 语音消息
                            try {
                                Object bodyObj = message.getBody();
                                if (bodyObj instanceof AudioMessage.Body) {
                                    AudioMessage.Body audioBody = (AudioMessage.Body) bodyObj;
                                    System.out.println("语音消息: 时长 " + audioBody.getDur() + "ms" +
                                                    ", URL: " + audioBody.getUrl());
                                } else {
                                    // Convert JSON to proper body object
                                    JSONObject jsonBody = bodyObj instanceof JSONObject ? 
                                        (JSONObject) bodyObj : 
                                        JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                    
                                    System.out.println("语音消息: 时长 " + jsonBody.getLong("dur") + "ms" +
                                                    ", URL: " + jsonBody.getString("url"));
                                }
                            } catch (Exception e) {
                                System.out.println("解析语音消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        case 3: // 视频消息
                            try {
                                Object bodyObj = message.getBody();
                                if (bodyObj instanceof VideoMessage.Body) {
                                    VideoMessage.Body videoBody = (VideoMessage.Body) bodyObj;
                                    System.out.println("视频消息: 时长 " + videoBody.getDur() + "ms" +
                                                    ", 尺寸: " + videoBody.getW() + "x" + videoBody.getH() +
                                                    ", URL: " + videoBody.getUrl());
                                } else {
                                    // Convert JSON to proper body object
                                    JSONObject jsonBody = bodyObj instanceof JSONObject ? 
                                        (JSONObject) bodyObj : 
                                        JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                    
                                    System.out.println("视频消息: 时长 " + jsonBody.getLong("dur") + "ms" +
                                                    ", 尺寸: " + jsonBody.getInteger("w") + "x" + jsonBody.getInteger("h") +
                                                    ", URL: " + jsonBody.getString("url"));
                                }
                            } catch (Exception e) {
                                System.out.println("解析视频消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        case 4: // 地理位置消息
                            try {
                                Object bodyObj = message.getBody();
                                if (bodyObj instanceof LocationMessage.Body) {
                                    LocationMessage.Body locBody = (LocationMessage.Body) bodyObj;
                                    System.out.println("地理位置消息: " + locBody.getTitle() + 
                                                    ", 坐标: [" + locBody.getLng() + ", " + locBody.getLat() + "]");
                                } else {
                                    // Convert JSON to proper body object
                                    JSONObject jsonBody = bodyObj instanceof JSONObject ? 
                                        (JSONObject) bodyObj : 
                                        JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                    
                                    System.out.println("地理位置消息: " + jsonBody.getString("title") + 
                                                    ", 坐标: [" + jsonBody.getDouble("lng") + ", " + jsonBody.getDouble("lat") + "]");
                                }
                            } catch (Exception e) {
                                System.out.println("解析地理位置消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        case 5: // 通知消息
                            try {
                                Object bodyObj = message.getBody();
                                JSONObject bodyJson;
                                
                                if (bodyObj instanceof JSONObject) {
                                    bodyJson = (JSONObject) bodyObj;
                                } else {
                                    bodyJson = JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                }
                                
                                if (bodyJson.containsKey("tid")) {
                                    // 群通知消息
                                    Integer ope = bodyJson.getInteger("ope");
                                    String operationType;
                                    switch (ope != null ? ope : -1) {
                                        case 0: operationType = "群拉人"; break;
                                        case 1: operationType = "群踢人"; break;
                                        case 2: operationType = "退出群"; break;
                                        case 3: operationType = "群信息更新"; break;
                                        case 4: operationType = "群解散"; break;
                                        case 5: operationType = "申请加入群成功"; break;
                                        case 6: operationType = "退出并移交群主"; break;
                                        case 7: operationType = "增加管理员"; break;
                                        case 8: operationType = "删除管理员"; break;
                                        case 9: operationType = "接受邀请进群"; break;
                                        case 10: operationType = "禁言群成员"; break;
                                        default: operationType = "未知操作(" + ope + ")";
                                    }
                                    
                                    System.out.println("群通知消息: 操作类型=" + operationType + 
                                                     ", 群ID=" + bodyJson.getLong("tid") + 
                                                     ", 群名称=" + bodyJson.getString("tname"));
                                    
                                    if (bodyJson.containsKey("accids")) {
                                        List<String> accids = bodyJson.getList("accids", String.class);
                                        if (accids != null && !accids.isEmpty()) {
                                            System.out.println("被操作的成员: " + String.join(", ", accids));
                                        }
                                    }
                                    
                                    if (ope != null && ope == 3) { // 群信息更新
                                        if (bodyJson.containsKey("announcement")) {
                                            System.out.println("更新的公告: " + bodyJson.getString("announcement"));
                                        }
                                        if (bodyJson.containsKey("intro")) {
                                            System.out.println("更新的介绍: " + bodyJson.getString("intro"));
                                        }
                                    }
                                } else if (bodyJson.containsKey("id")) {
                                    // 聊天室通知消息
                                    Integer id = bodyJson.getInteger("id");
                                    String notificationType;
                                    switch (id != null ? id : -1) {
                                        case 301: notificationType = "成员进入聊天室"; break;
                                        case 302: notificationType = "成员离开聊天室"; break;
                                        case 303: notificationType = "成员被加黑"; break;
                                        case 304: notificationType = "成员被取消黑名单"; break;
                                        case 305: notificationType = "成员被设置禁言"; break;
                                        case 306: notificationType = "成员被取消禁言"; break;
                                        case 307: notificationType = "设置为管理员"; break;
                                        case 308: notificationType = "取消管理员"; break;
                                        case 309: notificationType = "成员设定为固定成员"; break;
                                        case 310: notificationType = "成员取消固定成员"; break;
                                        case 312: notificationType = "聊天室信息更新"; break;
                                        case 313: notificationType = "成员被踢"; break;
                                        case 314: notificationType = "新增临时禁言"; break;
                                        case 315: notificationType = "主动解除临时禁言"; break;
                                        case 316: notificationType = "成员更新聊天室内的角色信息"; break;
                                        case 317: notificationType = "麦序队列中有变更"; break;
                                        case 318: notificationType = "聊天室禁言"; break;
                                        case 319: notificationType = "聊天室解除禁言状态"; break;
                                        case 320: notificationType = "麦序队列中有批量变更"; break;
                                        default: notificationType = "未知通知类型(" + id + ")";
                                    }
                                    
                                    System.out.println("聊天室通知消息: 类型=" + notificationType);
                                    
                                    if (bodyJson.containsKey("data")) {
                                        JSONObject data = bodyJson.getJSONObject("data");
                                        if (data != null) {
                                            System.out.println("操作者: " + data.getString("operator") + 
                                                             " (" + data.getString("opeNick") + ")");
                                            
                                            if (data.containsKey("target")) {
                                                List<String> targets = data.getList("target", String.class);
                                                if (targets != null && !targets.isEmpty()) {
                                                    System.out.println("目标账号: " + String.join(", ", targets));
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("未知通知消息类型: " + JSON.toJSONString(bodyJson));
                                }
                            } catch (Exception e) {
                                System.out.println("解析通知消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        case 6: // 文件消息
                            try {
                                Object bodyObj = message.getBody();
                                if (bodyObj instanceof FileMessage.Body) {
                                    FileMessage.Body fileBody = (FileMessage.Body) bodyObj;
                                    System.out.println("文件消息: " + fileBody.getName() + 
                                                    ", 大小: " + fileBody.getSize() + "字节" +
                                                    ", URL: " + fileBody.getUrl());
                                } else {
                                    // Convert JSON to proper body object
                                    JSONObject jsonBody = bodyObj instanceof JSONObject ? 
                                        (JSONObject) bodyObj : 
                                        JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                    
                                    System.out.println("文件消息: " + jsonBody.getString("name") + 
                                                    ", 大小: " + jsonBody.getLong("size") + "字节" +
                                                    ", URL: " + jsonBody.getString("url"));
                                }
                            } catch (Exception e) {
                                System.out.println("解析文件消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        case 10: // 提示消息
                            try {
                                Object bodyObj = message.getBody();
                                if (bodyObj instanceof TipMessage.Body) {
                                    TipMessage.Body tipBody = (TipMessage.Body) bodyObj;
                                    System.out.println("提示消息: " + tipBody.getMsg());
                                } else {
                                    // Convert JSON to proper body object
                                    JSONObject jsonBody = bodyObj instanceof JSONObject ? 
                                        (JSONObject) bodyObj : 
                                        JSONObject.parseObject(JSON.toJSONString(bodyObj));
                                    
                                    System.out.println("提示消息: " + jsonBody.getString("msg"));
                                }
                            } catch (Exception e) {
                                System.out.println("解析提示消息出错: " + e.getMessage());
                                System.out.println("原始消息内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                            
                        default:
                            if (type >= 100) { // 自定义消息
                                try {
                                    System.out.println("自定义消息: " + JSON.toJSONString(message.getBody()));
                                } catch (Exception e) {
                                    System.out.println("解析自定义消息出错: " + e.getMessage());
                                }
                            } else {
                                System.out.println("未知消息类型: " + type + ", 内容: " + JSON.toJSONString(message.getBody()));
                            }
                            break;
                    }
                    
                    System.out.println("------------------------------");
                }
            } else {
                System.out.println("未查询到群消息或查询失败");
            }
            
            Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        } catch (Exception e) {
            System.err.println("Error querying team history by type: " + e.getMessage());
            Assert.fail("Query team history by type failed: " + e.getMessage());
        }
    }

    /**
     * 测试聊天室通知消息
     */
    private static void testChatroomNotificationMessages(Long roomid, String accid) {
        try {
            // 聊天室的进入/退出等操作会生成通知消息
            // 查询聊天室消息，筛选出通知消息(type=5)
            QueryChatroomHistoryMessageRequestV1 request = new QueryChatroomHistoryMessageRequestV1();
            request.setRoomid(roomid);
            request.setAccid(accid);
            request.setTimetag(0L);
            request.setLimit(100);
            request.setReverse(1);
            request.setType("5"); // 仅查询通知消息
            
            Result<QueryChatroomHistoryMessageResponseV1> result = historyV1Service.queryChatroomHistoryMessage(request);
            System.out.println("**queryChatroomNotificationMessages**" + JSON.toJSONString(result));
            
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsgs() != null) {
                List<Message> messages = result.getResponse().getMsgs();
                System.out.println("\n========== 查询到 " + messages.size() + " 条聊天室通知消息 ==========\n");
                
                for (Message message : messages) {
                    if (message.getType() == 5) { // 通知消息
                        // 使用fromJson方法获取具体的消息对象
                        JSONObject bodyJson = null;
                        Object bodyObj = message.getBody();
                        
                        if (bodyObj instanceof JSONObject) {
                            bodyJson = (JSONObject) bodyObj;
                        } else {
                            bodyJson = JSONObject.parseObject(JSON.toJSONString(bodyObj));
                        }
                        
                        // 从JSON中提取聊天室通知信息
                        if (bodyJson.containsKey("id")) {
                            Integer id = bodyJson.getInteger("id");
                            String notificationType = "未知类型";
                            
                            switch (id) {
                                case 301: notificationType = "成员进入聊天室"; break;
                                case 302: notificationType = "成员离开聊天室"; break;
                                case 303: notificationType = "成员被加黑"; break;
                                case 304: notificationType = "成员被取消黑名单"; break;
                                case 305: notificationType = "成员被设置禁言"; break;
                                case 306: notificationType = "成员被取消禁言"; break;
                                case 307: notificationType = "设置为管理员"; break;
                                case 308: notificationType = "取消管理员"; break;
                                case 309: notificationType = "成员设定为固定成员"; break;
                                case 310: notificationType = "成员取消固定成员"; break;
                                case 312: notificationType = "聊天室信息更新"; break;
                                case 313: notificationType = "成员被踢"; break;
                                case 314: notificationType = "新增临时禁言"; break;
                                case 315: notificationType = "主动解除临时禁言"; break;
                                case 316: notificationType = "成员更新聊天室内的角色信息"; break;
                                case 317: notificationType = "麦序队列中有变更"; break;
                                case 318: notificationType = "聊天室禁言"; break;
                                case 319: notificationType = "聊天室解除禁言状态"; break;
                                case 320: notificationType = "麦序队列中有批量变更"; break;
                            }
                            
                            System.out.println("聊天室通知: " + notificationType + ", msgid=" + message.getMsgid());
                            
                            JSONObject data = bodyJson.getJSONObject("data");
                            if (data != null) {
                                System.out.println("操作者: " + data.getString("operator") + 
                                                 " (" + data.getString("opeNick") + ")");
                                
                                List<String> targets = data.getList("target", String.class);
                                if (targets != null && !targets.isEmpty()) {
                                    System.out.println("目标账号: " + String.join(", ", targets));
                                }
                            }
                        } else {
                            System.out.println("未知聊天室通知消息类型: " + JSON.toJSONString(bodyJson));
                        }
                    }
                }
            } else {
                System.out.println("未查询到聊天室通知消息或查询失败");
            }
        } catch (Exception e) {
            System.err.println("Error testing chatroom notification messages: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 查询团队通知消息
     */
    private static void queryTeamNotificationMessages(Long tid, String accid) {
        try {
            QueryTeamHistoryMessageRequestV1 request = new QueryTeamHistoryMessageRequestV1();
            request.setTid(tid);
            request.setAccid(accid);
            request.setBegintime(0L);
            request.setEndtime(System.currentTimeMillis());
            request.setLimit(100);
            request.setReverse(1);
            request.setType("5"); // 仅查询通知消息
            
            Result<QueryTeamHistoryMessageResponseV1> result = historyV1Service.queryTeamHistoryMessage(request);
            System.out.println("**queryTeamNotificationMessages**" + JSON.toJSONString(result));
            
            if (result.isSuccess() && result.getResponse() != null && result.getResponse().getMsgs() != null) {
                List<Message> messages = result.getResponse().getMsgs();
                System.out.println("\n========== 查询到 " + messages.size() + " 条团队通知消息 ==========\n");
                
                for (Message message : messages) {
                    if (message.getType() == 5) { // 通知消息
                        // 使用fromJson方法获取具体的消息对象
                        JSONObject bodyJson = null;
                        Object bodyObj = message.getBody();
                        
                        if (bodyObj instanceof JSONObject) {
                            bodyJson = (JSONObject) bodyObj;
                        } else {
                            bodyJson = JSONObject.parseObject(JSON.toJSONString(bodyObj));
                        }
                        
                        // 从JSON中提取团队通知信息
                        if (bodyJson.containsKey("tid")) {
                            Integer ope = bodyJson.getInteger("ope");
                            String operationType = "未知操作";
                            
                            switch (ope) {
                                case 0: operationType = "群拉人"; break;
                                case 1: operationType = "群踢人"; break;
                                case 2: operationType = "退出群"; break;
                                case 3: operationType = "群信息更新"; break;
                                case 4: operationType = "群解散"; break;
                                case 5: operationType = "申请加入群成功"; break;
                                case 6: operationType = "退出并移交群主"; break;
                                case 7: operationType = "增加管理员"; break;
                                case 8: operationType = "删除管理员"; break;
                                case 9: operationType = "接受邀请进群"; break;
                                case 10: operationType = "禁言群成员"; break;
                            }
                            
                            System.out.println("团队通知: " + operationType + ", msgid=" + message.getMsgid());
                            System.out.println("群ID: " + bodyJson.getLong("tid") + ", 群名称: " + bodyJson.getString("tname"));
                            
                            List<String> accids = bodyJson.getList("accids", String.class);
                            if (accids != null && !accids.isEmpty()) {
                                System.out.println("被操作的成员: " + String.join(", ", accids));
                            }
                            
                            if (ope == 3) { // 群信息更新
                                if (bodyJson.containsKey("announcement")) {
                                    System.out.println("更新的公告: " + bodyJson.getString("announcement"));
                                }
                                if (bodyJson.containsKey("intro")) {
                                    System.out.println("更新的介绍: " + bodyJson.getString("intro"));
                                }
                            }
                        } else {
                            System.out.println("未知团队通知消息类型: " + JSON.toJSONString(bodyJson));
                        }
                    }
                }
            } else {
                System.out.println("未查询到团队通知消息或查询失败");
            }
        } catch (Exception e) {
            System.err.println("Error querying team notification messages: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
