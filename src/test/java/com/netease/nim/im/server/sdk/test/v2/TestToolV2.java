package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.tool.IToolV2Service;
import com.netease.nim.server.sdk.im.v2.tool.request.AsrRequestV2;
import com.netease.nim.server.sdk.im.v2.tool.response.AsrResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

/**
 * V2 tool test
 */
public class TestToolV2 {

    private static YunxinV2ApiServices services;
    private static String operatorAccountId;

    @BeforeClass
    public static void setup() throws YunxinSdkException {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);

        // Initialize and create a test account
        operatorAccountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        if (services != null) {
            String name = "asr-user-" + UUID.randomUUID();
            createAccount(operatorAccountId, name);
        }
    }

    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);

        // Create and set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);

        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);

        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
        System.out.println("Created account: " + accountId + ", name: " + name);
    }

//    @Test
//    public void testAsr() throws YunxinSdkException {
//        if (services == null) {
//            System.out.println("SDK services not initialized, skipping test.");
//            return;
//        }
//        IToolV2Service toolV2Service = services.getToolV2Service();
//        AsrRequestV2 request = new AsrRequestV2();
//        request.setFormat("aac");
//        // Please replace with a valid and accessible audio URL for testing
//        request.setUrl("http://nim.nos.netease.com/351733a7-342c-4a30-9293-d7889d2516d7");
//        request.setOperatorAccountId(operatorAccountId);
//
//        Result<AsrResponseV2> result = toolV2Service.asr(request);
//
//        System.out.println("ASR API call result: " + result);
//        Assert.assertNotNull(result);
//
//        if (result.isSuccess()) {
//            Assert.assertNotNull(result.getResponse());
//            System.out.println("ASR recognized text: " + result.getResponse().getText());
//        } else {
//            System.out.println("ASR API call failed with code: " + result.getCode() + ", message: " + result.getMsg());
//        }
//    }
}
