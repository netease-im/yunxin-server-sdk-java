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
import com.netease.nim.im.server.sdk.v1.special_relation.ISpecialRelationV1Service;
import com.netease.nim.im.server.sdk.v1.special_relation.request.ListSpecialRelationRequestV1;
import com.netease.nim.im.server.sdk.v1.special_relation.request.SetSpecialRelationRequestV1;
import com.netease.nim.im.server.sdk.v1.special_relation.response.ListSpecialRelationResponseV1;
import com.netease.nim.im.server.sdk.v1.special_relation.response.SetSpecialRelationResponseV1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

/**
 * 特殊关系功能测试类
 */
public class TestSpecialRelationV1 {
    private static YunxinV1ApiServices services = null;
    private static ISpecialRelationV1Service specialRelationV1Service = null;
    private static IAccountV1Service accountV1Service = null;
    
    // 使用随机账号ID避免冲突
    private static String accid1;
    private static String accid2;
    private static String accid3;

    @BeforeClass
    public static void setup() {
        if (services != null) {
            return;
        }
        
        // 使用随机账号ID避免冲突
        accid1 = "yx_" + UUID.randomUUID().toString().substring(0, 8);
        accid2 = "yx_" + UUID.randomUUID().toString().substring(0, 8);
        accid3 = "yx_" + UUID.randomUUID().toString().substring(0, 8);

        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV1ApiServices(client);
        specialRelationV1Service = services.getSpecialRelationV1Service();
        accountV1Service = services.getAccountService();
        
        // 创建测试账号
        try {
            createAccount(accid1, "User1");
            createAccount(accid2, "User2");
            createAccount(accid3, "User3");
        } catch (Exception e) {
            System.err.println("Error creating test accounts: " + e.getMessage());
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

    /**
     * 测试设置和查询特殊关系
     */
    @Test
    public void testSetAndGetSpecialRelation() {
        if (specialRelationV1Service == null) return;
        
        try {
            // 设置用户1和用户2的特殊关系（黑名单）
            setupSpecialRelation(accid1, accid2, 1, 1);
            
            // 设置用户1和用户3的特殊关系（静音）
            setupSpecialRelation(accid1, accid3, 2, 1);
            
            // 查询用户1的特殊关系列表
            querySpecialRelation(accid1);
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to test special relationship: " + e.getMessage());
        }
    }
    
    /**
     * 测试设置特殊关系（黑名单/静音）
     */
    @Test
    public void testSetSpecialRelation() {
        if (specialRelationV1Service == null) return;
        
        try {
            // 设置黑名单
            setupSpecialRelation(accid1, accid2, 1, 1);
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to set special relationship: " + e.getMessage());
        }
    }
    
    /**
     * 测试查询特殊关系列表
     */
    @Test
    public void testGetSpecialRelation() {
        if (specialRelationV1Service == null) return;
        
        try {
            // 先设置关系，再查询
            setupSpecialRelation(accid1, accid3, 2, 1);
            querySpecialRelation(accid1);
        } catch (YunxinSdkException e) {
            Assert.fail("Failed to query special relationship: " + e.getMessage());
        }
    }

    /**
     * 设置特殊关系
     * 
     * @param accid 用户ID
     * @param targetAcc 目标用户ID
     * @param relationType 关系类型：1-黑名单，2-静音
     * @param value 操作值：0-取消，1-设置
     */
    private static void setupSpecialRelation(String accid, String targetAcc, int relationType, int value) throws YunxinSdkException {
        SetSpecialRelationRequestV1 request = new SetSpecialRelationRequestV1();
        request.setAccid(accid);
        request.setTargetAcc(targetAcc);
        request.setRelationType(relationType);
        request.setValue(value);

        Result<SetSpecialRelationResponseV1> result = specialRelationV1Service.setSpecialRelation(request);
        Assert.assertTrue("Failed to set special relation: " + result.getMsg(), result.isSuccess());
        System.out.println("**set**" + JSONObject.toJSONString(result.getResponse()));
    }

    /**
     * 查询特殊关系列表
     * 
     * @param accid 用户ID
     */
    private static void querySpecialRelation(String accid) throws YunxinSdkException {
        ListSpecialRelationRequestV1 request = new ListSpecialRelationRequestV1();
        request.setAccid(accid);
        Result<ListSpecialRelationResponseV1> result = specialRelationV1Service.listBlackAndMuteList(request);
        Assert.assertTrue("Failed to query special relation: " + result.getMsg(), result.isSuccess());
        System.out.println("**get**" + JSONObject.toJSONString(result.getResponse()));
    }
}