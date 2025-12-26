package com.netease.nim.im.server.sdk.test.v2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.system_notification.ICustomNotificationV2Service;
import com.netease.nim.server.sdk.im.v2.system_notification.request.SendBatchCustomNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.system_notification.request.SendCustomNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.system_notification.response.SendBatchCustomNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.system_notification.response.SendCustomNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.team.ITeamV2Service;
import com.netease.nim.server.sdk.im.v2.team.request.CreateTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.response.CreateTeamResponseV2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for the CustomNotificationV2Service
 */
public class TestSystemNotificationV2 {

    private static YunxinV2ApiServices services;
    
    private static final String sender = "sender_" + System.currentTimeMillis();
    private static final String receiver = "receiver_" + System.currentTimeMillis();
    private static final String receiver2 = "receiver2_" + System.currentTimeMillis();
    private static final String receiver3 = "receiver3_" + System.currentTimeMillis();
    private static String teamId;
    
    @BeforeClass
    public static void setup() throws Exception {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }

        services = new YunxinV2ApiServices(client);
        
        System.out.println("\n==== Creating Test Accounts and Team ====");
        createAccount(sender, "Custom Notification Sender");
        createAccount(receiver, "Custom Notification Receiver");
        createAccount(receiver2, "Custom Notification Receiver 2");
        createAccount(receiver3, "Custom Notification Receiver 3");
        createTeam();
    }
    
    @Test
    public void testP2PCustomNotification() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        System.out.println("\n==== Testing P2P Custom Notification ====");
        
        JSONObject contentObj = new JSONObject();
        contentObj.put("type", "friend_request");
        contentObj.put("message", "Hi, I would like to add you as a friend.");
        contentObj.put("timestamp", System.currentTimeMillis());
        String content = contentObj.toJSONString();
        
        SendCustomNotificationRequestV2 request = new SendCustomNotificationRequestV2(
                sender,
                1,
                receiver,
                content
        );
        
        ICustomNotificationV2Service customNotificationService = services.getCustomNotificationService();
        Result<SendCustomNotificationResponseV2> result = customNotificationService.sendCustomNotification(request);
        
        System.out.println("P2P Custom Notification: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        System.out.println("P2P Custom Notification sent successfully from " + sender + " to " + receiver);
    }
    
    @Test
    public void testTeamCustomNotification() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        System.out.println("\n==== Testing Team Custom Notification ====");
        
        if (teamId == null) {
            System.out.println("Skipping team notification test as team creation failed");
            return;
        }
        
        JSONObject contentObj = new JSONObject();
        contentObj.put("type", "team_announcement");
        contentObj.put("title", "Team Meeting");
        contentObj.put("message", "Team meeting scheduled for tomorrow at 10:00 AM");
        contentObj.put("timestamp", System.currentTimeMillis());
        String content = contentObj.toJSONString();
        
        SendCustomNotificationRequestV2 request = new SendCustomNotificationRequestV2(
                sender,
                2,
                teamId,
                content
        );
        
        request.setSound("notification.mp3");
        
        ICustomNotificationV2Service customNotificationService = services.getCustomNotificationService();
        Result<SendCustomNotificationResponseV2> result = customNotificationService.sendCustomNotification(request);
        
        System.out.println("Team Custom Notification: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        System.out.println("Team Custom Notification sent successfully to team " + teamId);
    }
    
    @Test
    public void testFullFeaturedCustomNotification() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        System.out.println("\n==== Testing Full Featured Custom Notification ====");
        
        JSONObject contentObj = new JSONObject();
        contentObj.put("type", "custom_event");
        contentObj.put("title", "Important Notice");
        contentObj.put("message", "This is a full-featured custom notification");
        contentObj.put("data", Arrays.asList("item1", "item2", "item3"));
        contentObj.put("timestamp", System.currentTimeMillis());
        String content = contentObj.toJSONString();
        
        SendCustomNotificationRequestV2 request = new SendCustomNotificationRequestV2(
                sender,
                1,
                receiver,
                content
        );
        
        request.setSound("special_alert.mp3");
        
        SendCustomNotificationRequestV2.NotificationConfig notificationConfig = new SendCustomNotificationRequestV2.NotificationConfig();
        notificationConfig.setOfflineEnabled(true);
        notificationConfig.setUnreadEnabled(true);
        request.setNotificationConfig(notificationConfig);
        
        SendCustomNotificationRequestV2.PushConfig pushConfig = new SendCustomNotificationRequestV2.PushConfig();
        pushConfig.setPushEnabled(true);
        pushConfig.setPushNickEnabled(true);
        pushConfig.setPushContent("You have received an important notification");
        
        JSONObject pushPayload = new JSONObject();
        pushPayload.put("custom_key", "custom_value");
        pushPayload.put("notification_id", System.currentTimeMillis());
        pushConfig.setPushPayload(pushPayload.toJSONString());
        
        request.setPushConfig(pushConfig);
        
        SendCustomNotificationRequestV2.RouteConfig routeConfig = new SendCustomNotificationRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(true);
        routeConfig.setRouteEnvironment("production");
        request.setRouteConfig(routeConfig);
        
        ICustomNotificationV2Service customNotificationService = services.getCustomNotificationService();
        Result<SendCustomNotificationResponseV2> result = customNotificationService.sendCustomNotification(request);
        
        System.out.println("Full Featured Custom Notification: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        System.out.println("Full Featured Custom Notification sent successfully from " + sender + " to " + receiver);
    }
    
    @Test
    public void testBatchCustomNotification() throws YunxinSdkException {
        if (services == null) {
            return;
        }
        
        System.out.println("\n==== Testing Batch Custom Notification ====");
        
        JSONObject contentObj = new JSONObject();
        contentObj.put("type", "batch_message");
        contentObj.put("title", "Batch Notification");
        contentObj.put("message", "This is a batch notification to multiple users");
        contentObj.put("timestamp", System.currentTimeMillis());
        String content = contentObj.toJSONString();
        
        List<String> receiverIds = Arrays.asList(receiver, receiver2, receiver3);
        
        SendBatchCustomNotificationRequestV2 request = new SendBatchCustomNotificationRequestV2(
                sender,
                receiverIds,
                content
        );
        
        request.setSound("batch_notification.mp3");
        
        SendBatchCustomNotificationRequestV2.NotificationConfig notificationConfig = 
                new SendBatchCustomNotificationRequestV2.NotificationConfig();
        notificationConfig.setOfflineEnabled(true);
        notificationConfig.setUnreadEnabled(true);
        request.setNotificationConfig(notificationConfig);
        
        SendBatchCustomNotificationRequestV2.PushConfig pushConfig = 
                new SendBatchCustomNotificationRequestV2.PushConfig();
        pushConfig.setPushEnabled(true);
        pushConfig.setPushNickEnabled(true);
        pushConfig.setPushContent("You have received a batch notification");
        
        JSONObject pushPayload = new JSONObject();
        pushPayload.put("batch_id", System.currentTimeMillis());
        pushPayload.put("receivers_count", receiverIds.size());
        pushConfig.setPushPayload(pushPayload.toJSONString());
        
        request.setPushConfig(pushConfig);
        
        SendBatchCustomNotificationRequestV2.RouteConfig routeConfig = 
                new SendBatchCustomNotificationRequestV2.RouteConfig();
        routeConfig.setRouteEnabled(true);
        routeConfig.setRouteEnvironment("production");
        request.setRouteConfig(routeConfig);
        
        ICustomNotificationV2Service customNotificationService = services.getCustomNotificationService();
        Result<SendBatchCustomNotificationResponseV2> result = 
                customNotificationService.sendBatchCustomNotification(request);
        
        System.out.println("Batch Custom Notification: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        if (result.getResponse() != null) {
            if (result.getResponse().getSuccessList() != null && !result.getResponse().getSuccessList().isEmpty()) {
                System.out.println("Successfully sent to: " + result.getResponse().getSuccessList().size() + " receivers");
            }
            
            if (result.getResponse().getFailedList() != null && !result.getResponse().getFailedList().isEmpty()) {
                System.out.println("Failed to send to: " + result.getResponse().getFailedList().size() + " receivers");
                for (SendBatchCustomNotificationResponseV2.FailedNotification failed : result.getResponse().getFailedList()) {
                    System.out.println("  Failed for: " + failed.getAccountId() + 
                                       ", Error: " + failed.getErrorCode() + " - " + failed.getErrorMsg());
                }
            }
        }
        
        System.out.println("Batch Custom Notification sent successfully from " + sender + " to " + receiverIds.size() + " receivers");
    }
    
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
    
    private static void createTeam() throws YunxinSdkException {
        CreateTeamRequestV2 createTeamRequest = new CreateTeamRequestV2();
        createTeamRequest.setName("Custom Notification Test Team");
        createTeamRequest.setTeamType(1);
        createTeamRequest.setOwnerAccountId(sender);
        
        List<String> members = new ArrayList<>();
        members.add(receiver);
        createTeamRequest.setInviteAccountIds(members);
        
        ITeamV2Service teamService = services.getTeamService();
        Result<CreateTeamResponseV2> teamResult = teamService.createTeam(createTeamRequest);
        
        if (teamResult.getCode() == 200 && teamResult.getResponse() != null) {
            teamId = String.valueOf(teamResult.getResponse().getTeamInfo().getTeamId());
            System.out.println("Created team with ID: " + teamId);
        } else {
            System.out.println("Failed to create team: " + teamResult.getMsg());
        }
    }
}
