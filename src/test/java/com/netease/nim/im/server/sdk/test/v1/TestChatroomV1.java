package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.im.server.sdk.v1.chatroom.IChatRoomV1Service;
import com.netease.nim.im.server.sdk.v1.chatroom.response.*;
import com.netease.nim.im.server.sdk.v1.chatroom.request.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by caojiajun on 2025/2/10
 */
public class TestChatroomV1 {

    private static YunxinV1ApiServices services = null;
    private static IChatRoomV1Service chatRoomService = null;

    private static final String accid1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static final String accid3 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    private static Long roomid1 = 0L;
    private static Long roomid2 = 0L;

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
        chatRoomService = services.getChatRoomService();
        
        // Create test accounts
        createAccount(accid1);
        createAccount(accid2);
        createAccount(accid3);
        
        // Create test chatrooms
        createChatroom();
    }
    
    private static void createChatroom() {
        CreateChatroomRequestV1 request = new CreateChatroomRequestV1();
        request.setCreator(accid1);
        request.setRoomName(accid1 + "room");
        request.setDelayClosePolicy(1);
        Result<CreateChatroomResponseV1> result = chatRoomService.createChatroom(request);
        Assert.assertEquals(result.getCode(), 200);
        CreateChatroomResponseV1 response = result.getResponse();
        Assert.assertEquals(request.getCreator(), response.getCreator());
        Assert.assertEquals(request.getRoomName(), response.getRoomName());
        Assert.assertNotEquals(result.getResponse().getRoomId(), 0);
        roomid1 = result.getResponse().getRoomId();
        System.out.println("Created chatroom with ID: " + roomid1);
    }

    @Test
    public void testUpdateChatroom() {
        if (chatRoomService == null) return;
        update(chatRoomService);
    }
    
    @Test
    public void testQueryChatroomAddress() {
        if (chatRoomService == null) return;
        queryChatroomAddress(chatRoomService);
    }
    
    @Test
    public void testQueryChatroomInfo() {
        if (chatRoomService == null) return;
        queryChatroomInfo(chatRoomService);
    }
    
    @Test
    public void testQueryChatroomInfos() {
        if (chatRoomService == null) return;
        queryChatroomInfos(chatRoomService);
    }
    
    @Test
    public void testToggleCloseChatroomStat() {
        if (chatRoomService == null) return;
        toggleCloseChatroomStat(chatRoomService);
    }
    
    @Test
    public void testUpdateDelayClosePolicy() {
        if (chatRoomService == null) return;
        updateDelayClosePolicy(chatRoomService);
    }
    
    @Test
    public void testUpdateChatroomInOutNotification() {
        if (chatRoomService == null) return;
        updateChatroomInOutNotification(chatRoomService);
    }
    
    @Test
    public void testKickMember() {
        if (chatRoomService == null) return;
        kickMember(chatRoomService);
    }
    
    @Test
    public void testSetMemberRole() {
        if (chatRoomService == null) return;
        setMemberRole(chatRoomService);
    }
    
    @Test
    public void testUpdateMyRoomRole() {
        if (chatRoomService == null) return;
        updateMyRoomRole(chatRoomService);
    }
    
    @Test
    public void testMembersByPage() {
        if (chatRoomService == null) return;
        membersByPage(chatRoomService);
    }
    
    @Test
    public void testMembersByRoles() {
        if (chatRoomService == null) return;
        membersByRoles(chatRoomService);
    }
    
    @Test
    public void testQueryMembers() {
        if (chatRoomService == null) return;
        queryMembers(chatRoomService);
    }
    
    @Test
    public void testAddRobot() {
        if (chatRoomService == null) return;
        addRobot(chatRoomService);
    }
    
    @Test
    public void testRemoveRobot() {
        if (chatRoomService == null) return;
        removeRobot(chatRoomService);
    }
    
    @Test
    public void testTagTemporaryMute() {
        if (chatRoomService == null) return;
        tagTemporaryMute(chatRoomService);
    }
    
    @Test
    public void testTagMembersCount() {
        if (chatRoomService == null) return;
        tagMembersCount(chatRoomService);
    }
    
    @Test
    public void testTagMembersQuery() {
        if (chatRoomService == null) return;
        tagMembersQuery(chatRoomService);
    }
    
    @Test
    public void testQueryTagHistoryMsg() {
        if (chatRoomService == null) return;
        queryTagHistoryMsg(chatRoomService);
    }
    
    @Test
    public void testUpdateChatRoomRoleTag() {
        if (chatRoomService == null) return;
        updateChatRoomRoleTag(chatRoomService);
    }
    
    @Test
    public void testClearRobot() {
        if (chatRoomService == null) return;
        clearRobot(chatRoomService);
    }
    
    @Test
    public void testTemporaryMute() {
        if (chatRoomService == null) return;
        temporaryMute(chatRoomService);
    }
    
    @Test
    public void testMuteRoom() {
        if (chatRoomService == null) return;
        muteRoom(chatRoomService);
    }
    
    @Test
    public void testQueryUserRoomIds() {
        if (chatRoomService == null) return;
        queryUserRoomIds(chatRoomService);
    }
    
    @Test
    public void testQueueOperations() {
        if (chatRoomService == null) return;
        
        // Execute queue operations in sequence
        queueInit(chatRoomService);
        queueOffer(chatRoomService);
        queueBatchOffer(chatRoomService);
        queueBatchUpdate(chatRoomService);
        queueList(chatRoomService);
        queueGet(chatRoomService);
        queuePoll(chatRoomService);
        queueDrop(chatRoomService);
    }

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
            
            IAccountV1Service accountService = services.getAccountService();
            Result<CreateAccountResponseV1> result = accountService.createAccount(request);
            
            // If account already exists, don't treat it as an error
            if (result.getCode() == 414) {
                System.out.println("Account " + accid + " already exists");
            } else {
                Assert.assertEquals(200, result.getCode());
                CreateAccountResponseV1 response = result.getResponse();
                Assert.assertEquals(request.getAccid(), response.getAccid());
                Assert.assertEquals(request.getName(), response.getName());
                Assert.assertNotNull(response.getToken());
                System.out.println("Created account: " + accid);
            }
        } catch (Exception e) {
            System.err.println("Error creating account " + accid + ": " + e.getMessage());
        }
    }

    private static void update(IChatRoomV1Service chatRoomService) {
        UpdateChatroomRequestV1 request = new UpdateChatroomRequestV1();
        request.setRoomId(roomid1);
        request.setAnnouncement("test-" + System.currentTimeMillis());
        Result<UpdateChatroomResponseV1> result = chatRoomService.updateChatroom(request);
        Assert.assertEquals(result.getCode(), 200);
        UpdateChatroomResponseV1 response = result.getResponse();
        Assert.assertEquals(request.getRoomId(), response.getRoomId());
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queryChatroomAddress(IChatRoomV1Service chatRoomService) {
        QueryChatroomAddressRequestV1 request = new QueryChatroomAddressRequestV1();
        request.setRoomId(roomid1);
        request.setAccid(accid1);
        Result<QueryChatroomAddressResponseV1> result = chatRoomService.queryChatroomAddress(request);
        Assert.assertEquals(result.getCode(), 200);
        QueryChatroomAddressResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queryChatroomInfo(IChatRoomV1Service chatRoomService) {
        QueryChatroomInfoRequestV1 request = new QueryChatroomInfoRequestV1();
        request.setRoomId(roomid1);

        Result<QueryChatroomInfoResponseV1> result = chatRoomService.queryChatroomInfo(request);
        Assert.assertEquals(result.getCode(), 200);
        QueryChatroomInfoResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queryChatroomInfos(IChatRoomV1Service chatRoomService) {
        QueryChatroomInfosRequestV1 request = new QueryChatroomInfosRequestV1();
        List<Long> list = new ArrayList<>();
        list.add(roomid1);
        list.add(roomid2);
        request.setRoomIds(list);

        Result<QueryChatroomInfosResponseV1> result = chatRoomService.queryChatroomInfos(request);
        Assert.assertEquals(result.getCode(), 200);
        QueryChatroomInfosResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void toggleCloseChatroomStat(IChatRoomV1Service chatRoomService) {
        ToggleCloseChatroomStatRequestV1 request = new ToggleCloseChatroomStatRequestV1();
        request.setRoomId(roomid1);
        request.setOperator(accid1);
        request.setValid(true);

        Result<ToggleCloseChatroomStatResponseV1> result = chatRoomService.toggleCloseChatroomStat(request);
        Assert.assertEquals(result.getCode(), 417);
        ToggleCloseChatroomStatResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void updateDelayClosePolicy(IChatRoomV1Service chatRoomService) {
        UpdateChatroomDelayClosePolicyRequestV1 request = new UpdateChatroomDelayClosePolicyRequestV1();
        request.setRoomId(roomid1);
        request.setDelayClosePolicy(0);

        Result<UpdateChatroomDelayClosePolicyResponseV1> result = chatRoomService.updateDelayClosePolicy(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        UpdateChatroomDelayClosePolicyResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }


    private static void updateChatroomInOutNotification(IChatRoomV1Service chatRoomService) {
        UpdateChatroomInOutNotificationRequestV1 request = new UpdateChatroomInOutNotificationRequestV1();
        request.setRoomId(roomid1);
        request.setClose(false);

        Result<UpdateChatroomInOutNotificationResponseV1> result = chatRoomService.updateChatroomInOutNotification(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        UpdateChatroomInOutNotificationResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void kickMember(IChatRoomV1Service chatRoomService) {
        KickMemberRequestV1 request = new KickMemberRequestV1();
        request.setRoomId(roomid1);
        request.setAccid(accid1);
        request.setTargetAccid(accid2);

        Result<KickMemberResponseV1> result = chatRoomService.kickMember(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 404);
        KickMemberResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void setMemberRole(IChatRoomV1Service chatRoomService) {
        SetMemberRoleRequestV1 request = new SetMemberRoleRequestV1();
        request.setRoomId(roomid1);
        request.setTarget(accid3);
        request.setOperator(accid1);
        request.setOpt(1);
        request.setOptValue(true);

        Result<SetMemberRoleResponseV1> result = chatRoomService.setMemberRole(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        SetMemberRoleResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void updateMyRoomRole(IChatRoomV1Service chatRoomService) {
        UpdateMyRoomRoleRequestV1 request = new UpdateMyRoomRoleRequestV1();
        request.setRoomId(roomid1);
        request.setAccid(accid1);

        Result<UpdateMyRoomRoleResponseV1> result = chatRoomService.updateMyRoomRole(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        UpdateMyRoomRoleResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void membersByPage(IChatRoomV1Service chatRoomService) {
        QueryMembersByPageRequestV1 request = new QueryMembersByPageRequestV1();
        request.setRoomId(roomid1);
        request.setType(0);
        request.setEndTime(System.currentTimeMillis());
        request.setLimit(10L);

        Result<QueryMembersByPageResponseV1> result = chatRoomService.membersByPage(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueryMembersByPageResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void membersByRoles(IChatRoomV1Service chatRoomService) {
        QueryMembersByRolesRequestV1 request = new QueryMembersByRolesRequestV1();
        request.setRoomId(roomid1);
        JSONObject json = new JSONObject();
        json.put("creator", true);
        request.setRoles(json.toJSONString());

        Result<QueryMembersByRolesResponseV1> result = chatRoomService.membersByRoles(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueryMembersByRolesResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queryMembers(IChatRoomV1Service chatRoomService) {
        QueryMembersRequestV1 request = new QueryMembersRequestV1();
        request.setRoomId(roomid1);
        request.setAccids(Arrays.asList(accid1, accid2, accid3));

        Result<QueryMembersResponseV1> result = chatRoomService.queryMembers(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueryMembersResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void addRobot(IChatRoomV1Service chatRoomService) {
        AddRobotRequestV1 request = new AddRobotRequestV1();
        request.setRoomId(roomid1);
        request.setAccids(Arrays.asList(accid3));

        Result<AddRobotResponseV1> result = chatRoomService.addRobot(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        AddRobotResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void removeRobot(IChatRoomV1Service chatRoomService) {
        RemoveRobotRequestV1 request = new RemoveRobotRequestV1();
        request.setRoomId(roomid1);
        request.setAccids(Arrays.asList(accid3));

        Result<RemoveRobotResponseV1> result = chatRoomService.removeRobot(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        RemoveRobotResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void tagTemporaryMute(IChatRoomV1Service chatRoomService) {
        TagTemporaryMuteRequestV1 request = new TagTemporaryMuteRequestV1();
        request.setRoomId(roomid1);
        request.setOperator(accid1);
        request.setTargetTag("user-tag");
        request.setMuteDuration(30);

        Result<TagTemporaryMuteResponseV1> result = chatRoomService.tagTemporaryMute(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        TagTemporaryMuteResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void tagMembersCount(IChatRoomV1Service chatRoomService) {
        TagMembersCountRequestV1 request = new TagMembersCountRequestV1();
        request.setRoomId(roomid1);
        request.setTag("sex");

        Result<TagMembersCountResponseV1> result = chatRoomService.tagMembersCount(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        TagMembersCountResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void tagMembersQuery(IChatRoomV1Service chatRoomService) {
        TagMembersQueryRequestV1 request = new TagMembersQueryRequestV1();
        request.setRoomId(roomid1);
        request.setTag("sex");
        request.setLimit(100);
        request.setEndTime(System.currentTimeMillis());
        Result<TagMembersQueryResponseV1> result = chatRoomService.tagMembersQuery(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        TagMembersQueryResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queryTagHistoryMsg(IChatRoomV1Service chatRoomService) {
        QueryTagHistoryMsgRequestV1 request = new QueryTagHistoryMsgRequestV1();
        request.setRoomId(roomid1);
        request.setTags(Arrays.asList("chatroom"));
        request.setLimit(20);
        request.setReverse(1);

        Result<QueryTagHistoryMsgResponseV1> result = chatRoomService.queryTagHistoryMsg(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueryTagHistoryMsgResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void updateChatRoomRoleTag(IChatRoomV1Service chatRoomService) {
        UpdateChatRoomRoleTagRequestV1 request = new UpdateChatRoomRoleTagRequestV1();
        request.setRoomId(roomid1);
        request.setTags(Arrays.asList("tag-" + System.currentTimeMillis()));
        request.setAccid(accid3);

        Result<UpdateChatRoomRoleTagResponseV1> result = chatRoomService.updateChatRoomRoleTag(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        UpdateChatRoomRoleTagResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void clearRobot(IChatRoomV1Service chatRoomService) {
        CleanRobotRequestV1 request = new CleanRobotRequestV1();
        request.setRoomId(roomid1);
        request.setNotify(true);

        Result<CleanRobotResponseV1> result = chatRoomService.cleanRobot(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        CleanRobotResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void temporaryMute(IChatRoomV1Service chatRoomService) {
        TemporaryMuteRequestV1 request = new TemporaryMuteRequestV1();
        request.setRoomId(roomid1);
        request.setOperator(accid1);
        request.setTarget(accid2);
        request.setMuteDuration(300);
        request.setNeedNotify(true);

        Result<TemporaryMuteResponseV1> result = chatRoomService.temporaryMute(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        TemporaryMuteResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void muteRoom(IChatRoomV1Service chatRoomService) {
        MuteRoomRequestV1 request = new MuteRoomRequestV1();
        request.setRoomId(roomid1);
        request.setOperator(accid1);
        request.setMute(true);
        request.setNeedNotify(true);
        request.setNotifyExt("test");

        Result<MuteRoomResponseV1> result = chatRoomService.muteRoom(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        MuteRoomResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queryUserRoomIds(IChatRoomV1Service chatRoomService) {
        QueryUserRoomIdsRequestV1 request = new QueryUserRoomIdsRequestV1();
        request.setCreator(accid1);

        Result<QueryUserRoomIdsResponseV1> result = chatRoomService.queryUserRoomIds(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueryUserRoomIdsResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queueInit(IChatRoomV1Service chatRoomService) {
        QueueInitRequestV1 request = new QueueInitRequestV1();
        request.setRoomId(roomid1);
        request.setSizeLimit(100);

        Result<QueueInitResponseV1> result = chatRoomService.queueInit(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueueInitResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queueOffer(IChatRoomV1Service chatRoomService) {
        QueueOfferRequestV1 request = new QueueOfferRequestV1();
        request.setRoomId(roomid1);
        request.setKey(System.currentTimeMillis() + "");
        request.setValue(System.currentTimeMillis() + "Value");
        request.setTransient_(false);

        QueueOfferRequestV1 request2 = new QueueOfferRequestV1();
        request2.setRoomId(roomid1);
        request2.setKey(System.currentTimeMillis() + "-2");
        request2.setValue(System.currentTimeMillis() + "Value-2");
        request2.setTransient_(false);
        Result<QueueOfferResponseV1> result = chatRoomService.queueOffer(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueueOfferResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));

        result = chatRoomService.queueOffer(request2);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queueBatchOffer(IChatRoomV1Service chatRoomService) {
        QueueBatchOfferRequestV1 request = new QueueBatchOfferRequestV1();
        request.setRoomId(roomid1);
        request.setTransient_(false);
        
        // Create element list
        List<QueueBatchOfferRequestV1.QueueElement> elements = new ArrayList<>();
        
        // Add elements
        QueueBatchOfferRequestV1.QueueElement element1 = new QueueBatchOfferRequestV1.QueueElement();
        element1.setKey(System.currentTimeMillis() + "batch");
        element1.setValue(System.currentTimeMillis() + "-batch-value");
        elements.add(element1);
        
        QueueBatchOfferRequestV1.QueueElement element2 = new QueueBatchOfferRequestV1.QueueElement();
        element2.setKey(System.currentTimeMillis() + "batch2");
        element2.setValue(System.currentTimeMillis() + "-batch-value2");
        elements.add(element2);
        
        request.setElements(elements);

        QueueBatchOfferRequestV1 request2 = new QueueBatchOfferRequestV1();
        request2.setRoomId(roomid1);
        request2.setTransient_(false);
        
        List<QueueBatchOfferRequestV1.QueueElement> elements2 = new ArrayList<>();
        
        QueueBatchOfferRequestV1.QueueElement element3 = new QueueBatchOfferRequestV1.QueueElement();
        element3.setKey(System.currentTimeMillis() + "batch3");
        element3.setValue(System.currentTimeMillis() + "-batch-value3");
        elements2.add(element3);
        
        QueueBatchOfferRequestV1.QueueElement element4 = new QueueBatchOfferRequestV1.QueueElement();
        element4.setKey(System.currentTimeMillis() + "batch4");
        element4.setValue(System.currentTimeMillis() + "-batch-value4");
        elements2.add(element4);
        
        request2.setElements(elements2);

        Result<QueueBatchOfferResponseV1> result = chatRoomService.queueBatchOffer(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueueBatchOfferResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));

        result = chatRoomService.queueBatchOffer(request2);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queueBatchUpdate(IChatRoomV1Service chatRoomService) {
        QueueBatchUpdateRequestV1 request = new QueueBatchUpdateRequestV1();
        request.setRoomId(roomid1);
        Map<String, String> elements = new HashMap<>();
        elements.put("aaa", "valu33e");
        elements.put("bbb", "value332");
        request.setElements(elements);
        request.setOperator(accid1);
        QueueBatchUpdateRequestV1 request2 = new QueueBatchUpdateRequestV1();
        request2.setRoomId(roomid1);
        Map<String, String> elements2 = new HashMap<>();
        elements2.put("aaa", "valu33e22");
        elements2.put("bbb", "value33222");
        request2.setElements(elements2);
        request2.setOperator(accid1);
        Result<QueueBatchUpdateResponseV1> result = chatRoomService.queueBatchUpdate(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueueBatchUpdateResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));

        result = chatRoomService.queueBatchUpdate(request2);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queueList(IChatRoomV1Service chatRoomService) {
        QueueListRequestV1 request = new QueueListRequestV1();
        request.setRoomId(roomid1);
        Result<QueueListResponseV1> result = chatRoomService.queueList(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueueListResponseV1 response = result.getResponse();
        System.out.println(response.getList().size());

        // Update the list with results for test
        for (Map<String, Object> element : response.getList()) {
            System.out.println(element.get("key") + "---" + element.get("value"));
        }
    }

    private static void queueGet(IChatRoomV1Service chatRoomService) {
        // First list the queues to get the keys
        QueueListRequestV1 listRequest = new QueueListRequestV1();
        listRequest.setRoomId(roomid1);
        Result<QueueListResponseV1> listResult = chatRoomService.queueList(listRequest);
        
        if (listResult.isSuccess() && listResult.getResponse() != null && 
            listResult.getResponse().getList() != null && 
            !listResult.getResponse().getList().isEmpty()) {
            
            // Get the first key from the list
            String key = (String) listResult.getResponse().getList().get(0).get("key");
            
            // Now perform the get operation using this key
            QueueGetRequestV1 request = new QueueGetRequestV1();
            request.setRoomId(roomid1);
            List<String> keys = new ArrayList<>();
            keys.add(key);
            request.setKeys(keys);
            
            Result<QueueGetResponseV1> result = chatRoomService.queueGet(request);
            System.out.println(result.getMsg());
            Assert.assertEquals(result.getCode(), 200);
            QueueGetResponseV1 response = result.getResponse();
            System.out.println(JSONObject.toJSONString(response));
        } else {
            System.out.println("No queue elements to get");
        }
    }

    private static void queuePoll(IChatRoomV1Service chatRoomService) {
        QueuePollRequestV1 request = new QueuePollRequestV1();
        request.setRoomId(roomid1);
        Result<QueuePollResponseV1> result = chatRoomService.queuePoll(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueuePollResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }

    private static void queueDrop(IChatRoomV1Service chatRoomService) {
        QueueDropRequestV1 request = new QueueDropRequestV1();
        request.setRoomId(roomid1);
        Result<QueueDropResponseV1> result = chatRoomService.queueDrop(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(result.getCode(), 200);
        QueueDropResponseV1 response = result.getResponse();
        System.out.println(JSONObject.toJSONString(response));
    }
}


