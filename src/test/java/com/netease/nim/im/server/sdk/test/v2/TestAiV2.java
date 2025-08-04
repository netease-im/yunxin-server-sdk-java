package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.ai.request.ChatAssistRequestV2;
import com.netease.nim.server.sdk.im.v2.ai.response.ChatAssistResponseV2;

import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;

/**
 * V2 AI test
 */
public class TestAiV2 {

    private static YunxinV2ApiServices services;
    private static String senderId;
    private static String receiverId;

    @BeforeClass
    public static void setup(){
        if(services!=null){
            return;
        }
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);

        // Initialize and create test accounts
        senderId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        receiverId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        createAccount(senderId, "ai-sender");
        createAccount(receiverId, "ai-receiver");

    }

    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);
        services.getAccountService().createAccount(request);
    }

    @Test
    public void testChatAssist() throws YunxinSdkException {
        if (services == null) return;
        ChatAssistRequestV2 request = new ChatAssistRequestV2();
        request.setSenderId(senderId);
        request.setReceiverId(receiverId);
        request.setStyleList(Collections.singletonList("hot"));
        request.setReceiverLastMessage("我今天的衣服漂亮吗？");

        Result<ChatAssistResponseV2> result = services.getAiService().chatAssist(request);
        Assert.assertNotNull(result);
        System.out.println(result.getResponse().getItems().get(0).getAnswer());
        Assert.assertTrue(result.isSuccess());
    }
}
