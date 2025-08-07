package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v1.YunxinV1ApiServices;
import com.netease.nim.server.sdk.im.v1.account.IAccountV1Service;
import com.netease.nim.server.sdk.im.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.server.sdk.im.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.server.sdk.im.v1.message.IMessageV1Service;
import com.netease.nim.server.sdk.im.v1.message.request.*;
import com.netease.nim.server.sdk.im.v1.message.response.*;
import com.netease.nim.server.sdk.im.v1.team.ITeamV1Service;
import com.netease.nim.server.sdk.im.v1.team.request.CreateTeamRequestV1;
import com.netease.nim.server.sdk.im.v1.team.response.CreateTeamResponseV1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TestMessageV1 {

    private static YunxinV1ApiServices services = null;
    private static IMessageV1Service messageV1Service = null;
    private static IAccountV1Service accountV1Service = null;
    private static ITeamV1Service teamV1Service = null;

    private static final String accid1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static Long tid;

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
        messageV1Service = services.getMessageService();
        accountV1Service = services.getAccountService();
        teamV1Service = services.getTeamService();
        
        createAccount(accid1);
        createAccount(accid2);
        tid = createTeam(accid1, accid2).getTid();
        System.out.println("accid1 = " + accid1);
        System.out.println("accid2 = " + accid2);
        System.out.println("tid = " + tid);
    }

    @Test
    public void testSendMessage() {
        if (messageV1Service == null) return;
        sendMessage(accid1, accid2);
    }

    @Test
    public void testSendBatchMessage() {
        if (messageV1Service == null) return;
        sendBatchMessage(accid1, accid2);
    }

    @Test
    public void testMarkReadMessage() {
        if (messageV1Service == null) return;
        markReadMessage(accid1, accid2, "1234567890");
    }

    @Test
    public void testMarkReadTeamMessage() {
        if (messageV1Service == null) return;
        markReadTeamMessage(accid1, tid, 1234567890L);
    }

    @Test
    public void testRecallMessage() {
        if (messageV1Service == null) return;
        SendMessageResponseV1 response = sendMessage(accid1, accid2);
        recallMessage(response.getMsgid(), response.getTimetag(), accid1, accid2);
    }

    @Test
    public void testDeleteMessageOneWay() {
        if (messageV1Service == null) return;
        SendMessageResponseV1 response = sendMessage(accid1, accid2);
        deleteMessageOneWay(response.getMsgid(), response.getTimetag(), accid1, accid2);
    }

    @Test
    public void testBroadcastMessage() {
        if (messageV1Service == null) return;
        broadcastMessage(accid1);
    }

    @Test
    public void testDeleteBroadcastMessageById() {
        if (messageV1Service == null) return;
        BroadcastMessageResponseV1 response = broadcastMessage(accid1);
        deleteBroadcastMessageById(response.getBroadcastId());
    }

    @Test
    public void testBroadcastMessageWithTtl() {
        if (messageV1Service == null) return;
        broadcastMessageWithTtl(accid1);
    }

    @Test
    public void testUploadFile() {
        if (messageV1Service == null) return;
        uploadFile();
    }

    @Test
    public void testDeleteFile() {
        if (messageV1Service == null) return;
        deleteFile();
    }

    @Test
    public void testDeleteMessage() {
        if (messageV1Service == null) return;
        SendMessageResponseV1 response = sendMessage(accid1, accid2);
        deleteMessage(response.getMsgid(), response.getTimetag(), accid1, accid2);
    }

    @Test
    public void testDeleteRoamSession() {
        if (messageV1Service == null) return;
        deleteRoamSession(accid1, accid2);
    }

    private static SendMessageResponseV1 sendMessage(String fromAccid, String toAccid) {
        SendMessageRequestV1 request = new SendMessageRequestV1();
        request.setFrom(fromAccid);
        request.setOpe(0);
        request.setTo(toAccid);
        request.setType(0);
        request.setBody("{\"msg\":\"哈哈哈\"}");
        request.setMsgDesc("This is a description for the message.");
        request.setAntispam(true);
        request.setAntispamCustom("{\"key\":\"value\"}");
        request.setOption("{\"optionKey\":\"optionValue\"}");
        request.setPushContent("This is a push notification.");
        request.setPayload("{\"payloadKey\":\"payloadValue\"}");
        request.setExt("Additional developer info");
        request.setForcePushAll(false);
        request.setForcePushList(Arrays.asList("user456", "user789"));
        request.setForcePushContent("Force push message content.");
        request.setUseYidun(1);
        request.setBid("businessId123");
        request.setYidunAntiCheating("{\"cheating\":\"data\"}");
        request.setYidunAntiSpamExt("{\"ext\":\"data\"}");
        request.setMarkRead(0);
        request.setAsync(false);
        request.setCheckFriend(false);
        request.setSubType(100);
        request.setMsgSenderNoSense(0);
        request.setMsgReceiverNoSense(0);
        request.setEnv("production");
        request.setRobotAccount(null);
        request.setRobotTopic(null);
        request.setRobotFunction(null);
        request.setRobotCustomContent(null);
        
        Result<SendMessageResponseV1> result = messageV1Service.sendMessage(request);
        System.out.println("**sendMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    private static void sendBatchMessage(String fromAccid, String toAccid) {
        SendBatchMessageRequestV1 request = new SendBatchMessageRequestV1();
        request.setFromAccid(fromAccid);
        List<String> toAccidsList = new ArrayList<>();
        toAccidsList.add(toAccid);
        request.setToAccids(toAccidsList);
        request.setType(0);
        request.setBody("{\"msg\":\"哈哈哈\"}");
        request.setMsgDesc("This is a description for the message.");
        request.setOption("{\"optionKey\":\"optionValue\"}");
        request.setPushContent("This is a push notification.");
        request.setPayload("{\"payloadKey\":\"payloadValue\"}");
        request.setExt("Additional developer info");
        request.setUseYidun(1);
        request.setBid("businessId123");
        request.setYidunAntiCheating("{\"cheating\":\"data\"}");
        request.setYidunAntiSpamExt("{\"ext\":\"data\"}");
        request.setReturnMsgid(true);
        request.setEnv("production");
        request.setMsgSenderNoSense(0);
        
        Result<SendBatchMessageResponseV1> result = messageV1Service.sendBatchMessage(request);
        System.out.println("**sendBatchMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void markReadMessage(String fromAccid, String toAccid, String msgidClient) {
        MarkReadMessageRequestV1 request = new MarkReadMessageRequestV1();
        request.setFrom(fromAccid);
        request.setTo(toAccid);
        request.setMsgidClient(msgidClient);
        
        Result<MarkReadMessageResponseV1> result = messageV1Service.markReadMessage(request);
        System.out.println("**markReadMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void markReadTeamMessage(String accid, Long tid, Long msgid) {
        MarkReadTeamMessageRequestV1 request = new MarkReadTeamMessageRequestV1();
        request.setAccid(accid);
        request.setTid(tid);
        
        // Create list of message IDs
        List<Long> msgidsArray = new ArrayList<>();
        msgidsArray.add(msgid);
        request.setMsgids(msgidsArray);
        
        Result<MarkReadTeamMessageResponseV1> result = messageV1Service.markReadTeamMessage(request);
        System.out.println("**d**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void recallMessage(Long deleteMsgid, Long timetag, String fromAccid, String toAccid) {
        RecallMessageRequestV1 request = new RecallMessageRequestV1();
        request.setDeleteMsgid(deleteMsgid);
        request.setTimetag(timetag);
        request.setType(7);
        request.setFrom(fromAccid);
        request.setTo(toAccid);
        request.setMsg("撤回了一条信息");
        request.setIgnoreTime("1");
        request.setPushcontent("This is a push notification.");
        request.setPayload("{\"payloadKey\":\"payloadValue\"}");
        request.setEnv("production");
        request.setAttach("This is a attach.");
        
        Result<RecallMessageResponseV1> result = messageV1Service.recallMessage(request);
        System.out.println("**recallMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void deleteMessageOneWay(Long deleteMsgid, Long timetag, String fromAccid, String toAccid) {
        DeleteMessageOneWayRequestV1 request = new DeleteMessageOneWayRequestV1();
        request.setDeleteMsgid(deleteMsgid);
        request.setTimetag(timetag);
        request.setType(13);
        request.setFrom(fromAccid);
        request.setTo(toAccid);
        request.setMsg("撤回了一条信息");
        
        Result<DeleteMessageOneWayResponseV1> result = messageV1Service.deleteMessageOneWay(request);
        System.out.println("**deleteMessageOneWay**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static BroadcastMessageResponseV1 broadcastMessage(String fromAccid) {
        BroadcastMessageRequestV1 request = new BroadcastMessageRequestV1();
        request.setBody("{\"msg\":\"哈哈哈\"}");
        request.setFrom(fromAccid);
        request.setOffline(true);
        request.setTtl(24); // 设置24小时有效期
        request.setTargetOs(null);
        
        Result<BroadcastMessageResponseV1> result = messageV1Service.broadcastMessage(request);
        System.out.println("**broadcastMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }

    private static void deleteBroadcastMessageById(Long broadcastId) {
        DeleteBroadcastMessageByIdRequestV1 request = new DeleteBroadcastMessageByIdRequestV1();
        request.setBroadcastId(broadcastId);
        
        Result<DeleteBroadcastMessageByIdResponseV1> result = messageV1Service.deleteBroadcastMessageById(request);
        System.out.println("**deleteBroadcastMessageById**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void broadcastMessageWithTtl(String fromAccid) {
        System.out.println("==== Testing Broadcast Message with TTL ====");
        
        // Test with different TTL values
        int[] ttlValues = {1, 24, 72, 168}; // 1 hour, 1 day, 3 days, 1 week
        
        for (int ttl : ttlValues) {
            System.out.println("Testing TTL: " + ttl + " hours");
            
            BroadcastMessageRequestV1 request = new BroadcastMessageRequestV1();
            request.setBody("{\"msg\":\"Testing TTL " + ttl + " hours\", \"timestamp\":" + System.currentTimeMillis() + "}");
            request.setFrom(fromAccid);
            request.setOffline(true);
            request.setTtl(ttl);
            request.setTargetOs(null);
            
            Result<BroadcastMessageResponseV1> result = messageV1Service.broadcastMessage(request);
            System.out.println("**broadcastMessageWithTtl (TTL=" + ttl + "h)**" + JSON.toJSONString(result));
            
            Assert.assertTrue("TTL test failed for " + ttl + " hours: " + result.getMsg(), result.isSuccess());
            
            if (result.getResponse() != null) {
                BroadcastMessageResponseV1 response = result.getResponse();
                System.out.println("  Broadcast ID: " + response.getBroadcastId());
                System.out.println("  Create Time: " + response.getCreateTime());
                System.out.println("  Expire Time: " + response.getExpireTime());
                
                // Verify that expireTime is set correctly based on TTL
                if (response.getCreateTime() != null && response.getExpireTime() != null) {
                    long expectedExpireDuration = ttl * 60 * 60 * 1000L; // TTL in milliseconds
                    long actualExpireDuration = response.getExpireTime() - response.getCreateTime();
                    System.out.println("  Expected TTL duration: " + expectedExpireDuration + "ms");
                    System.out.println("  Actual TTL duration: " + actualExpireDuration + "ms");
                    
                    // Allow some tolerance for processing time (within 1 minute)
                    long tolerance = 60 * 1000L;
                    Assert.assertTrue("TTL duration mismatch for " + ttl + " hours. Expected: " + expectedExpireDuration + 
                                    ", Actual: " + actualExpireDuration, 
                                    Math.abs(actualExpireDuration - expectedExpireDuration) <= tolerance);
                }
            }
            
            System.out.println("TTL test passed for " + ttl + " hours");
            System.out.println("------------------------------");
        }
        
        System.out.println("==== TTL Testing Completed ====");
    }

    private static void uploadFile() {
        UploadFileRequestV1 request = new UploadFileRequestV1();
        request.setContent("abcdef");
        request.setType(null);
        request.setIshttps(false);
        request.setExpireSec(86400);
        request.setTag(null);
        
        Result<UploadFileResponseV1> result = messageV1Service.uploadFile(request);
        System.out.println("**uploadFile**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void deleteFile() {
//        DeleteFileRequestV1 request = new DeleteFileRequestV1();
//        request.setStartTime(0L);
//        request.setEndTime(24 * 3600 * 1000L);
//        request.setContentType(null);
//        request.setTag(null);
//
//        Result<DeleteFileResponseV1> result = messageV1Service.deleteFile(request);
//        System.out.println("**deleteFile**" + JSON.toJSONString(result));
//        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void deleteMessage(Long deleteMsgid, Long timetag, String fromAccid, String toAccid) {
        DeleteMessageRequestV1 request = new DeleteMessageRequestV1();
        request.setDeleteMsgid(deleteMsgid);
        request.setTimetag(timetag);
        request.setType(7);
        request.setFrom(fromAccid);
        request.setTo(toAccid);
        
        Result<DeleteMessageResponseV1> result = messageV1Service.deleteMessage(request);
        System.out.println("**deleteMessage**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void deleteRoamSession(String fromAccid, String toAccid) {
        DeleteRoamSessionRequestV1 request = new DeleteRoamSessionRequestV1();
        request.setType(1);
        request.setFrom(fromAccid);
        request.setTo(toAccid);
        
        Result<DeleteRoamSessionResponseV1> result = messageV1Service.deleteRoamSession(request);
        System.out.println("**deleteRoamSession**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static void createAccount(String accid) {
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid(accid);
        request.setName("name");
        request.setEx("ex");
        request.setBirth("1970-01-01");
        request.setGender(1);
        request.setIcon("https://icon-xxx.jpg");
        request.setMobile("13811110000");
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        request.setSign("sign");
        request.setEmail("zhangsan@163.com");
        
        Result<CreateAccountResponseV1> result = accountV1Service.createAccount(request);
        System.out.println("**createAccount**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
    }

    private static CreateTeamResponseV1 createTeam(String owner, String member) {
        CreateTeamRequestV1 request = new CreateTeamRequestV1();
        request.setOwner(owner);
        request.setTname("tname");
        List<String> list = new ArrayList<>();
        list.add(member);
        request.setMembers(list);
        request.setMsg("msg");
        request.setJoinmode(0);
        
        Result<CreateTeamResponseV1> result = teamV1Service.createTeam(request);
        System.out.println("**createTeam**" + JSON.toJSONString(result));
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        return result.getResponse();
    }
}
