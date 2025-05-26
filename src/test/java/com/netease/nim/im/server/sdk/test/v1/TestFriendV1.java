package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.im.server.sdk.v1.friend.IFriendV1Service;
import com.netease.nim.im.server.sdk.v1.friend.request.*;
import com.netease.nim.im.server.sdk.v1.friend.response.BaseFriendResponseV1;
import com.netease.nim.im.server.sdk.v1.friend.response.GetFriendListResponseV1;
import com.netease.nim.im.server.sdk.v1.friend.response.GetFriendRelationshipResponseV1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestFriendV1 {
    private static YunxinV1ApiServices services;
    private static IFriendV1Service friendV1Service;
    private static final long roomId = 2008;
    private static String accid1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String accid2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @BeforeClass
    public static void setup() {
        if (friendV1Service != null) {
            return;
        }

        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV1ApiServices(client);
        friendV1Service = services.getFriendV1Service();
        
        // 创建测试账号
        createAccount(accid1);
        createAccount(accid2);
    }

    private static void createAccount(String accid) {
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid(accid);
        request.setName("user-" + accid.substring(0, 6));
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        
        IAccountV1Service accountService = services.getAccountService();
        Result<CreateAccountResponseV1> result = accountService.createAccount(request);
        
        // 如果账号已存在，不视为错误
        if (result.getCode() == 414) {
            System.out.println("Account " + accid + " already exists");
        } else {
            Assert.assertEquals("Failed to create account: " + result.getMsg(), 200, result.getCode());
            Assert.assertEquals(request.getAccid(), result.getResponse().getAccid());
        }
    }

    @Test
    public void testAddFriend() throws YunxinSdkException {
        if (friendV1Service == null) return;
        add();
    }
    
    @Test
    public void testGetFriendByAccId() throws YunxinSdkException {
        if (friendV1Service == null) return;
        add(); // 确保好友关系存在
        getByAccId();
    }
    
    @Test
    public void testGetFriendList() throws YunxinSdkException {
        if (friendV1Service == null) return;
        add(); // 确保好友关系存在
        get();
    }
    
    @Test
    public void testUpdateFriend() throws YunxinSdkException {
        if (friendV1Service == null) return;
        add(); // 确保好友关系存在
        update();
        get(); // 验证更新
    }
    
    @Test
    public void testDeleteFriend() throws YunxinSdkException {
        if (friendV1Service == null) return;
        add(); // 确保好友关系存在
        delete();
        get(); // 验证删除
    }

    private static void add() {
        AddFriendRequestV1 request = new AddFriendRequestV1();
        request.setAccid(accid1);
        request.setFaccid(accid2);
        request.setMsg("xxxx");
        request.setServerex("xxxxxxxygytest");
        request.setType(1);

        Result<BaseFriendResponseV1> result = friendV1Service.add(request);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.out.println("**add**" + JSONObject.toJSONString(result.getResponse()));
    }

    private static void get() {
        GetFriendListRequestV1 request = new GetFriendListRequestV1();
        request.setAccid(accid1);
        request.setUpdatetime(System.currentTimeMillis() - 60*60*1000);

        Result<GetFriendListResponseV1> result = friendV1Service.get(request);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.out.println("**get**" + JSONObject.toJSONString(result.getResponse()));
    }

    private static void getByAccId() {
        GetFriendRelationshipRequestV1 request = new GetFriendRelationshipRequestV1();
        request.setAccid(accid1);
        request.setFaccid(accid2);

        Result<GetFriendRelationshipResponseV1> result = friendV1Service.getByAccId(request);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.out.println("**getByAccId**" + JSONObject.toJSONString(result.getResponse()));
    }

    private static void update() {
        UpdateFriendRequestV1 request = new UpdateFriendRequestV1();
        request.setAccid(accid1);
        request.setFaccid(accid2);
        request.setAlias("user1-user2");
        request.setServerex("xxxxxxxygytest");
        request.setEx("xxxxxx");

        Result<BaseFriendResponseV1> result = friendV1Service.update(request);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.out.println("**update**" + JSONObject.toJSONString(result.getResponse()));
    }

    private static void delete() {
        DeleteFriendRequestV1 request = new DeleteFriendRequestV1();
        request.setAccid(accid1);
        request.setFaccid(accid2);
        request.setDeleteAlias(true);

        Result<BaseFriendResponseV1> result = friendV1Service.delete(request);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.out.println("**delete**" + JSONObject.toJSONString(result.getResponse()));
    }
}