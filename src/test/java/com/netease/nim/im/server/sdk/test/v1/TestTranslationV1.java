package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiServices;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.im.server.sdk.v1.translations.ITranslationV1Service;
import com.netease.nim.im.server.sdk.v1.translations.request.TextTranslationRequest;
import com.netease.nim.im.server.sdk.v1.translations.response.TextTranslationResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

public class TestTranslationV1 {
    private static YunxinV1ApiServices services = null;
    private static ITranslationV1Service translationV1Service = null;
    private static IAccountV1Service accountV1Service = null;
    private static String accid;

    @BeforeClass
    public static void setup() {
        if (services != null) {
            return;
        }
        
        // 使用随机账号ID避免冲突
        accid = "yx_" + UUID.randomUUID().toString().substring(0, 8);

        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV1ApiServices(client);
        translationV1Service = services.getTranslationV1Service();
        accountV1Service = services.getAccountService();
        
        // 创建测试账号
        try {
            createAccount(accid, "TransUser");
        } catch (Exception e) {
            System.err.println("Error creating test account: " + e.getMessage());
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
    public void testMessage() {
        if (translationV1Service == null) return;
        
        TextTranslationRequest request = new TextTranslationRequest();
        request.setAccid(accid);
        request.setText("你好中国");
        request.setTo("en");
        Result<TextTranslationResponse> result = translationV1Service.translatorText(request);
        Assert.assertTrue(result.getCode() + ":" + result.getMsg(), result.isSuccess());
        System.err.println(JSON.toJSONString(result));
    }
}
