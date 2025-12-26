package com.netease.nim.im.server.sdk.test.v2;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.system_push.ISystemPushV2Service;
import com.netease.nim.server.sdk.im.v2.system_push.request.*;
import com.netease.nim.server.sdk.im.v2.system_push.response.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test class for the SystemPushV2Service
 */
public class TestSystemPushV2 {

    private static YunxinV2ApiServices services;
    
    private static final String sender = "sender_" + System.currentTimeMillis();
    
    @BeforeClass
    public static void setup() throws Exception {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }

        services = new YunxinV2ApiServices(client);
        
        System.out.println("\n==== Creating Test Account ====");
        createAccount(sender, "System Push Sender");
    }
    
    /**
     * Test sending push notification to all users
     */
    @Test
    public void testPushNotification() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        System.out.println("\n==== Testing Push Notification to All Users ====");
        
        SendPushNotificationRequestV2 request = new SendPushNotificationRequestV2();
        request.setContent("System push notification content");
        request.setSenderAccountId(sender);
        request.setTargetType(1);
        request.setTargetOs(Arrays.asList("ios", "aos", "pc", "web", "mac"));
        request.setRoamEnabled(true);
        request.setRoamExpireAfter(604800L);
        
        SendPushNotificationRequestV2.PushConfig pushConfig = new SendPushNotificationRequestV2.PushConfig();
        pushConfig.setPushNickEnabled(true);
        pushConfig.setPushBadgeEnabled(true);
        pushConfig.setPushContent("Push notification content");
        pushConfig.setPushPayload(null);
        request.setPushConfig(pushConfig);
        
        ISystemPushV2Service systemPushService = services.getSystemPushService();
        Result<SendPushNotificationResponseV2> result = systemPushService.sendPushNotification(request);
        
        System.out.println("Push Notification: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        if (result.getResponse() != null) {
            SendPushNotificationResponseV2 response = result.getResponse();
            System.out.println("Push ID: " + response.getPushId());
            System.out.println("Sender Account ID: " + response.getSenderAccountId());
            System.out.println("Content: " + response.getContent());
            System.out.println("Target Type: " + response.getTargetType());
            System.out.println("Target OS: " + response.getTargetOs());
            System.out.println("Roam Enabled: " + response.getRoamEnabled());
            System.out.println("Roam Expire Time: " + response.getRoamExpireTime());
            System.out.println("Create Time: " + response.getCreateTime());
            
            if (response.getPushConfig() != null) {
                System.out.println("Push Config:");
                System.out.println("  - Push Nick Enabled: " + response.getPushConfig().getPushNickEnabled());
                System.out.println("  - Push Badge Enabled: " + response.getPushConfig().getPushBadgeEnabled());
                System.out.println("  - Push Content: " + response.getPushConfig().getPushContent());
                System.out.println("  - Push Payload: " + response.getPushConfig().getPushPayload());
            }
        }
        
        System.out.println("Push Notification sent successfully to all users");
    }
    
    /**
     * Test getting a push notification by ID
     */
    @Test
    public void testGetPushNotification() throws YunxinSdkException {
        if (services == null) {
            return;
        }

        System.out.println("\n==== Testing Get Push Notification ====");

        SendPushNotificationRequestV2 sendRequest = new SendPushNotificationRequestV2();
        sendRequest.setContent("Test push notification for query");
        sendRequest.setSenderAccountId(sender);
        sendRequest.setTargetType(1);
        sendRequest.setTargetOs(Arrays.asList("ios", "aos"));
        sendRequest.setRoamEnabled(true);
        sendRequest.setRoamExpireAfter(604800L);

        SendPushNotificationRequestV2.PushConfig pushConfig = new SendPushNotificationRequestV2.PushConfig();
        pushConfig.setPushNickEnabled(true);
        pushConfig.setPushBadgeEnabled(true);
        pushConfig.setPushContent("Test push content");
        sendRequest.setPushConfig(pushConfig);

        ISystemPushV2Service systemPushService = services.getSystemPushService();
        Result<SendPushNotificationResponseV2> sendResult = systemPushService.sendPushNotification(sendRequest);

        if (sendResult.getCode() != 200 || sendResult.getResponse() == null) {
            System.out.println("Failed to send push notification, skipping get test");
            return;
        }

        Long pushId = sendResult.getResponse().getPushId();
        System.out.println("Created push notification with ID: " + pushId);

        GetPushNotificationRequestV2 getRequest = new GetPushNotificationRequestV2(pushId);
        Result<GetPushNotificationResponseV2> getResult = systemPushService.getPushNotification(getRequest);

        System.out.println("Get Push Notification: " + getResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(getResult));
        Assert.assertEquals(200, getResult.getCode());

        if (getResult.getResponse() != null) {
            GetPushNotificationResponseV2 response = getResult.getResponse();
            Assert.assertEquals(pushId, response.getPushId());
            System.out.println("Push ID: " + response.getPushId());
            System.out.println("Sender Account ID: " + response.getSenderAccountId());
            System.out.println("Content: " + response.getContent());
            System.out.println("Target Type: " + response.getTargetType());
            System.out.println("Target OS: " + response.getTargetOs());
            System.out.println("Roam Enabled: " + response.getRoamEnabled());
            System.out.println("Roam Expire Time: " + response.getRoamExpireTime());
            System.out.println("Create Time: " + response.getCreateTime());

            if (response.getPushConfig() != null) {
                System.out.println("Push Config:");
                System.out.println("  - Push Nick Enabled: " + response.getPushConfig().getPushNickEnabled());
                System.out.println("  - Push Badge Enabled: " + response.getPushConfig().getPushBadgeEnabled());
                System.out.println("  - Push Content: " + response.getPushConfig().getPushContent());
            }
        }

        System.out.println("Successfully queried push notification with ID: " + pushId);
    }

    /**
     * Test listing push notifications with pagination
     */
    @Test
    public void testListPushNotifications() throws YunxinSdkException {
        if (services == null) {
            return;
        }

        System.out.println("\n==== Testing List Push Notifications ====");

        ListPushNotificationsRequestV2 request = new ListPushNotificationsRequestV2();
        request.setLimit(10);
        request.setType(1);

        ISystemPushV2Service systemPushService = services.getSystemPushService();
        Result<ListPushNotificationsResponseV2> result = systemPushService.listPushNotifications(request);

        System.out.println("List Push Notifications: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());

        if (result.getResponse() != null) {
            ListPushNotificationsResponseV2 response = result.getResponse();
            System.out.println("Has More: " + response.getHasMore());
            System.out.println("Next Token: " + response.getNextToken());

            if (response.getItems() != null && !response.getItems().isEmpty()) {
                System.out.println("Total Items: " + response.getItems().size());

                ListPushNotificationsResponseV2.PushNotificationItem firstItem = response.getItems().get(0);
                System.out.println("\nFirst Item:");
                System.out.println("  Push ID: " + firstItem.getPushId());
                System.out.println("  Sender Account ID: " + firstItem.getSenderAccountId());
                System.out.println("  Content: " + firstItem.getContent());
                System.out.println("  Target Type: " + firstItem.getTargetType());
                System.out.println("  Target OS: " + firstItem.getTargetOs());
                System.out.println("  Roam Enabled: " + firstItem.getRoamEnabled());
                System.out.println("  Create Time: " + firstItem.getCreateTime());

                if (firstItem.getPushConfig() != null) {
                    System.out.println("  Push Config:");
                    System.out.println("    - Push Nick Enabled: " + firstItem.getPushConfig().getPushNickEnabled());
                    System.out.println("    - Push Badge Enabled: " + firstItem.getPushConfig().getPushBadgeEnabled());
                    System.out.println("    - Push Content: " + firstItem.getPushConfig().getPushContent());
                }

                if (response.getHasMore() != null && response.getHasMore() && response.getNextToken() != null) {
                    System.out.println("\n==== Testing Pagination with Next Token ====");
                    ListPushNotificationsRequestV2 nextRequest = new ListPushNotificationsRequestV2();
                    nextRequest.setPageToken(response.getNextToken());
                    nextRequest.setLimit(10);
                    nextRequest.setType(1);

                    Result<ListPushNotificationsResponseV2> nextResult = systemPushService.listPushNotifications(nextRequest);
                    System.out.println("Next Page Result: " + nextResult.getMsg());
                    if (nextResult.getResponse() != null && nextResult.getResponse().getItems() != null) {
                        System.out.println("Next Page Items Count: " + nextResult.getResponse().getItems().size());
                    }
                }
            } else {
                System.out.println("No push notifications found");
            }
        }

        System.out.println("Successfully listed push notifications");
    }
    
    /**
     * Helper method to create an account
     */
    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        if (result.getCode() == 200) {
            System.out.println("Created account: " + accountId + ", name: " + name);
            Assert.assertNotNull(result.getResponse());
            Assert.assertEquals(accountId, result.getResponse().getAccountId());
        } else if (result.getCode() == 414) {
            System.out.println("Account already exists: " + accountId);
        } else {
            Assert.fail("Failed to create account: " + result.getMsg());
        }
    }
}

