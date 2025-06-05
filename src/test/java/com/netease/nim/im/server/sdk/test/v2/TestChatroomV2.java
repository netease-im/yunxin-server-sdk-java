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
import com.netease.nim.server.sdk.im.v2.chatroom.IChatroomV2Service;
import com.netease.nim.server.sdk.im.v2.chatroom.request.CreateChatroomRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.GetChatroomAddressRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.GetChatroomInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ListFixedMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ListOnlineMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.QueryOpenChatroomsRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ToggleChatroomMuteRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.UpdateChatroomInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.UpdateChatroomStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.request.ToggleInOutNotificationRequestV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.CreateChatroomResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.GetChatroomAddressResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.GetChatroomInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ListFixedMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.QueryOpenChatroomsResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ToggleChatroomMuteResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ToggleInOutNotificationResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.ListOnlineMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.UpdateChatroomInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.chatroom.response.UpdateChatroomStatusResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for ChatroomV2Service
 */
public class TestChatroomV2 {

    private static YunxinV2ApiServices services;
    
    // Test account IDs
    private static final String accountId1 = "chatroom" + System.currentTimeMillis();
    private static Long basicRoomId;
    private static Long fullRoomId;
    
    /**
     * Initialize test environment once for all tests
     */
    @BeforeClass
    public static void setup() throws Exception {
        // Get appkey and appsecret from system properties or environment variables
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        
        services = new YunxinV2ApiServices(client);
        
        // Initialize test environment
        // Create a test account to be the creator
        System.out.println("\n==== Creating Test Account ====");
        createAccount(accountId1, "Chatroom Creator");
        
        // Create a chatroom with only required parameters
        basicRoomId = createBasicChatroom();
        
        // Create a chatroom with all parameters
        fullRoomId = createFullChatroom();
    }
    
    /**
     * Test creating a basic chatroom with only required parameters
     * 
     * @return The ID of the created chatroom
     */
    private static Long createBasicChatroom() throws YunxinSdkException {
        System.out.println("\n==== Testing Basic Chatroom Creation ====");
        
        // Create a chatroom with only required parameters
        String roomName = "Test Chatroom " + System.currentTimeMillis();
        CreateChatroomRequestV2 basicRequest = new CreateChatroomRequestV2(accountId1, roomName);
        
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<CreateChatroomResponseV2> basicResult = chatroomService.createChatroom(basicRequest);
        
        System.out.println("Basic Chatroom Creation: " + basicResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(basicResult));
        
        // Verify chatroom was created successfully
        Assert.assertEquals(200, basicResult.getCode());
        CreateChatroomResponseV2 basicResponse = basicResult.getResponse();
        Assert.assertNotNull(basicResponse);
        Assert.assertEquals(accountId1, basicResponse.getCreator());
        Assert.assertEquals(roomName, basicResponse.getRoomName());
        Assert.assertNotNull(basicResponse.getRoomId());
        
        Long roomId = basicResponse.getRoomId();
        System.out.println("Created basic chatroom:");
        System.out.println("  Room ID: " + roomId);
        System.out.println("  Creator: " + basicResponse.getCreator());
        System.out.println("  Room Name: " + basicResponse.getRoomName());
        
        return roomId;
    }
    
    /**
     * Test creating a chatroom with all parameters
     * 
     * @return The ID of the created chatroom
     */
    private static Long createFullChatroom() throws YunxinSdkException {
        System.out.println("\n==== Testing Full Chatroom Creation ====");
        
        // Create a chatroom with all parameters
        String fullRoomName = "Full Test Chatroom " + System.currentTimeMillis();
        String announcement = "Welcome to the test chatroom!";
        String liveUrl = "https://example.com/live/test";
        String extension = "{\"custom_key\":\"custom_value\"}";
        
        CreateChatroomRequestV2 fullRequest = new CreateChatroomRequestV2(accountId1, fullRoomName);
        fullRequest.setAnnouncement(announcement);
        fullRequest.setLiveUrl(liveUrl);
        fullRequest.setExtension(extension);
        fullRequest.setQueueLevel(1);
        fullRequest.setDelayClosePolicy(1);
        fullRequest.setDelaySeconds(3600L); // 1 hour
        fullRequest.setInOutNotification(true);
        
        // Set up antispam configuration if needed
        CreateChatroomRequestV2.AntispamConfiguration antispamConfig = new CreateChatroomRequestV2.AntispamConfiguration();
        antispamConfig.setEnabled(true);
        
        List<CreateChatroomRequestV2.BusinessIdMap> businessIdMaps = new ArrayList<>();
        
        // Text antispam
        CreateChatroomRequestV2.BusinessIdMap textMap = new CreateChatroomRequestV2.BusinessIdMap();
        textMap.setType(1); // Text type
        textMap.setBusinessId("test_text_business_id");
        businessIdMaps.add(textMap);
        
        // Image antispam
        CreateChatroomRequestV2.BusinessIdMap imageMap = new CreateChatroomRequestV2.BusinessIdMap();
        imageMap.setType(2); // Image type
        imageMap.setBusinessId("test_image_business_id");
        businessIdMaps.add(imageMap);
        
        antispamConfig.setBusinessIdMap(businessIdMaps);
        fullRequest.setAntispamConfiguration(antispamConfig);
        
        // Create the chatroom
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<CreateChatroomResponseV2> fullResult = chatroomService.createChatroom(fullRequest);
        
        System.out.println("Full Chatroom Creation: " + fullResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(fullResult));
        
        // Verify chatroom was created successfully
        Assert.assertEquals(200, fullResult.getCode());
        CreateChatroomResponseV2 fullResponse = fullResult.getResponse();
        Assert.assertNotNull(fullResponse);
        Assert.assertEquals(accountId1, fullResponse.getCreator());
        Assert.assertEquals(fullRoomName, fullResponse.getRoomName());
        Assert.assertEquals(announcement, fullResponse.getAnnouncement());
        Assert.assertEquals(liveUrl, fullResponse.getLiveUrl());
        Assert.assertEquals(extension, fullResponse.getExtension());
        Assert.assertEquals(Integer.valueOf(1), fullResponse.getQueueLevel());
        Assert.assertNotNull(fullResponse.getRoomId());
        
        Long roomId = fullResponse.getRoomId();
        
        System.out.println("Created full chatroom:");
        System.out.println("  Room ID: " + roomId);
        System.out.println("  Creator: " + fullResponse.getCreator());
        System.out.println("  Room Name: " + fullResponse.getRoomName());
        System.out.println("  Announcement: " + fullResponse.getAnnouncement());
        System.out.println("  Live URL: " + fullResponse.getLiveUrl());
        System.out.println("  Extension: " + fullResponse.getExtension());
        System.out.println("  Queue Level: " + fullResponse.getQueueLevel());
        
        return roomId;
    }
    
    /**
     * Test getting chatroom info with basic request
     */
    @Test
    public void testGetChatroomInfoBasic() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request with only required parameters
        GetChatroomInfoRequestV2 infoBasicRequest = new GetChatroomInfoRequestV2(fullRoomId);
        
        // Get chatroom info with basic request
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<GetChatroomInfoResponseV2> infoBasicResult = chatroomService.getChatroomInfo(infoBasicRequest);
        
        System.out.println("Get Chatroom Info (Basic): " + infoBasicResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(infoBasicResult));
        
        // Verify the basic result
        Assert.assertEquals(200, infoBasicResult.getCode());
        GetChatroomInfoResponseV2 infoBasicResponse = infoBasicResult.getResponse();
        Assert.assertNotNull(infoBasicResponse);
        Assert.assertNotNull(infoBasicResponse.getRoomId());
        Assert.assertEquals(fullRoomId, infoBasicResponse.getRoomId());
        Assert.assertEquals(accountId1, infoBasicResponse.getCreator());
        
        // Print basic chatroom info
        System.out.println("Basic chatroom info:");
        System.out.println("  Room ID: " + infoBasicResponse.getRoomId());
        System.out.println("  Creator: " + infoBasicResponse.getCreator());
        System.out.println("  Room Name: " + infoBasicResponse.getRoomName());
        System.out.println("  Status: " + (infoBasicResponse.getValid() ? "Open" : "Closed"));
    }
    
    /**
     * Test getting chatroom info with online user count
     */
    @Test
    public void testGetChatroomInfoWithOnlineCount() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request with all parameters
        GetChatroomInfoRequestV2 infoFullRequest = new GetChatroomInfoRequestV2(
            fullRoomId,
            true,   // Get online user count
            true    // Get online user count by type
        );
        
        // Get chatroom info with full request
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<GetChatroomInfoResponseV2> infoFullResult = chatroomService.getChatroomInfo(infoFullRequest);
        
        System.out.println("Get Chatroom Info (Full): " + infoFullResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(infoFullResult));
        
        // Verify the full result
        Assert.assertEquals(200, infoFullResult.getCode());
        GetChatroomInfoResponseV2 infoFullResponse = infoFullResult.getResponse();
        Assert.assertNotNull(infoFullResponse);
        
        // Print full chatroom info
        System.out.println("Full chatroom info:");
        System.out.println("  Room ID: " + infoFullResponse.getRoomId());
        System.out.println("  Creator: " + infoFullResponse.getCreator());
        System.out.println("  Room Name: " + infoFullResponse.getRoomName());
        System.out.println("  Status: " + (infoFullResponse.getValid() ? "Open" : "Closed"));
        
        // Print online user counts if available
        System.out.println("  Online User Count: " + infoFullResponse.getOnlineUserCount());
        
        if (infoFullResponse.getIosOnlineUserCount() != null) {
            System.out.println("  iOS Online Users: " + infoFullResponse.getIosOnlineUserCount());
        }
        
        if (infoFullResponse.getAndroidOnlineUserCount() != null) {
            System.out.println("  Android Online Users: " + infoFullResponse.getAndroidOnlineUserCount());
        }
        
        if (infoFullResponse.getPcOnlineUserCount() != null) {
            System.out.println("  PC Online Users: " + infoFullResponse.getPcOnlineUserCount());
        }
        
        if (infoFullResponse.getWebOnlineUserCount() != null) {
            System.out.println("  Web Online Users: " + infoFullResponse.getWebOnlineUserCount());
        }
        
        if (infoFullResponse.getMacOnlineUserCount() != null) {
            System.out.println("  Mac Online Users: " + infoFullResponse.getMacOnlineUserCount());
        }
    }
    
    /**
     * Test getting chatroom address
     */
    @Test
    public void testGetChatroomAddress() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request for getting chatroom address
        GetChatroomAddressRequestV2 addressRequest = new GetChatroomAddressRequestV2(
            fullRoomId,
            accountId1,
            "59.1.1.1"  // Client IP (using localhost for testing)
        );
        
        // Optionally set client type and IP type
        addressRequest.setClientType(2);  // commonlink (for non-Web/HarmonyOS clients)
        addressRequest.setIpType(0);      // IPv4
        
        // Get chatroom address
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<GetChatroomAddressResponseV2> addressResult = chatroomService.getChatroomAddress(addressRequest);
        
        System.out.println("Get Chatroom Address: " + addressResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(addressResult));
        
        // Verify the result
        Assert.assertEquals(200, addressResult.getCode());
        GetChatroomAddressResponseV2 addressResponse = addressResult.getResponse();
        Assert.assertNotNull(addressResponse);
        Assert.assertNotNull(addressResponse.getItems());
        
        // Print addresses
        System.out.println("Chatroom addresses:");
        for (String address : addressResponse.getItems()) {
            System.out.println("  " + address);
        }
    }
    
    /**
     * Test updating chatroom information with minimal fields
     */
    @Test
    public void testUpdateChatroomInfoSimple() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request to update chatroom info with minimal fields
        UpdateChatroomInfoRequestV2 updateRequest = new UpdateChatroomInfoRequestV2();
        
        // Set fields to update
        String updatedRoomName = "Simple Update " + System.currentTimeMillis();
        
        updateRequest.setRoomId(fullRoomId);
        updateRequest.setRoomName(updatedRoomName);
        updateRequest.setNotificationEnabled(true);  // Send notification about the update
        
        // Update the chatroom
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<UpdateChatroomInfoResponseV2> updateResult = chatroomService.updateChatroomInfo(updateRequest);
        
        System.out.println("Simple Update Chatroom Info: " + updateResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(updateResult));
        
        // Verify the update result
        Assert.assertEquals(200, updateResult.getCode());
        UpdateChatroomInfoResponseV2 updateResponse = updateResult.getResponse();
        Assert.assertNotNull(updateResponse);
        Assert.assertEquals(fullRoomId, updateResponse.getRoomId());
        
        // Verify the updated fields
        Assert.assertEquals(updatedRoomName, updateResponse.getRoomName());
        
        System.out.println("Updated chatroom info:");
        System.out.println("  Room ID: " + updateResponse.getRoomId());
        System.out.println("  Room Name: " + updateResponse.getRoomName());
    }
    
    /**
     * Test updating chatroom status (open/close)
     */
    @Test
    public void testUpdateChatroomStatus() throws YunxinSdkException {
        if (services == null) return;
        
        // First close the chatroom
        UpdateChatroomStatusRequestV2 closeRequest = new UpdateChatroomStatusRequestV2(
            accountId1,  // Operator (creator)
            false     // Close the chatroom
        );
        
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<UpdateChatroomStatusResponseV2> closeResult = chatroomService.updateChatroomStatus(fullRoomId, closeRequest);
        
        System.out.println("Close Chatroom: " + closeResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(closeResult));
        
        // Verify the result
        Assert.assertEquals(200, closeResult.getCode());
        UpdateChatroomStatusResponseV2 closeResponse = closeResult.getResponse();
        Assert.assertNotNull(closeResponse);
        Assert.assertEquals(fullRoomId, closeResponse.getRoomId());
        Assert.assertEquals(Boolean.FALSE, closeResponse.getValid());  // Chatroom should be closed
        
        System.out.println("Chatroom status after closing:");
        System.out.println("  Room ID: " + closeResponse.getRoomId());
        System.out.println("  Status: " + (closeResponse.getValid() ? "Open" : "Closed"));
        
        // Now reopen the chatroom with auto-close policy
        UpdateChatroomStatusRequestV2 openRequest = new UpdateChatroomStatusRequestV2(
            accountId1,  // Operator (creator)
            true,     // Open the chatroom
            2,        // Auto-close policy: Close after being idle
            3600L     // Auto-close after 1 hour of being idle
        );
        
        Result<UpdateChatroomStatusResponseV2> openResult = chatroomService.updateChatroomStatus(fullRoomId, openRequest);
        
        System.out.println("Reopen Chatroom: " + openResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(openResult));
        
        // Verify the result
        Assert.assertEquals(200, openResult.getCode());
        UpdateChatroomStatusResponseV2 openResponse = openResult.getResponse();
        Assert.assertNotNull(openResponse);
        Assert.assertEquals(fullRoomId, openResponse.getRoomId());
        Assert.assertEquals(Boolean.TRUE, openResponse.getValid());  // Chatroom should be open
        
        System.out.println("Chatroom status after reopening:");
        System.out.println("  Room ID: " + openResponse.getRoomId());
        System.out.println("  Status: " + (openResponse.getValid() ? "Open" : "Closed"));
    }
    
    /**
     * Test toggling chatroom mute status
     */
    @Test
    public void testToggleChatroomMute() throws YunxinSdkException {
        if (services == null) return;
        
        // First enable mute (only admins and creator can send messages)
        ToggleChatroomMuteRequestV2 muteRequest = new ToggleChatroomMuteRequestV2(
            accountId1,  // Operator (creator)
            true      // Enable mute
        );
        
        // Optionally send notification about the change
        muteRequest.setNotificationEnabled(true);
        muteRequest.setNotificationExtension("{\"mute_reason\":\"Test muting\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}");
        
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<ToggleChatroomMuteResponseV2> muteResult = chatroomService.toggleChatroomMute(fullRoomId, muteRequest);
        
        System.out.println("Enable Chatroom Mute: " + muteResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(muteResult));
        
        // Verify the result
        Assert.assertEquals(200, muteResult.getCode());
        
        // Get chatroom info to verify mute status
        GetChatroomInfoRequestV2 infoRequest = new GetChatroomInfoRequestV2(fullRoomId);
        Result<GetChatroomInfoResponseV2> infoResult = chatroomService.getChatroomInfo(infoRequest);
        
        Assert.assertEquals(200, infoResult.getCode());
        GetChatroomInfoResponseV2 infoResponse = infoResult.getResponse();
        Assert.assertNotNull(infoResponse);
        Assert.assertEquals(Boolean.TRUE, infoResponse.getChatBanned());  // Should be muted
        
        System.out.println("Chatroom mute status after enabling mute: " + (infoResponse.getChatBanned() ? "Muted" : "Not muted"));
        
        // Now disable mute
        ToggleChatroomMuteRequestV2 unmuteRequest = new ToggleChatroomMuteRequestV2(
            accountId1,  // Operator (creator)
            false     // Disable mute
        );
        
        // Optionally send notification about the change
        unmuteRequest.setNotificationEnabled(true);
        unmuteRequest.setNotificationExtension("{\"unmute_reason\":\"Test unmuting\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}");
        
        Result<ToggleChatroomMuteResponseV2> unmuteResult = chatroomService.toggleChatroomMute(fullRoomId, unmuteRequest);
        
        System.out.println("Disable Chatroom Mute: " + unmuteResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(unmuteResult));
        
        // Verify the result
        Assert.assertEquals(200, unmuteResult.getCode());
        
        // Get chatroom info to verify mute status
        Result<GetChatroomInfoResponseV2> infoResult2 = chatroomService.getChatroomInfo(infoRequest);
        
        Assert.assertEquals(200, infoResult2.getCode());
        GetChatroomInfoResponseV2 infoResponse2 = infoResult2.getResponse();
        Assert.assertNotNull(infoResponse2);
        Assert.assertEquals(Boolean.FALSE, infoResponse2.getChatBanned());  // Should not be muted
        
        System.out.println("Chatroom mute status after disabling mute: " + (infoResponse2.getChatBanned() ? "Muted" : "Not muted"));
    }
    
    /**
     * Test toggling in/out notification for a chatroom
     */
    @Test
    public void testToggleInOutNotification() throws YunxinSdkException {
        if (services == null) return;
        
        // First disable in/out notification
        IChatroomV2Service chatroomService = services.getChatroomService();
        
        ToggleInOutNotificationRequestV2 disableRequest = new ToggleInOutNotificationRequestV2(fullRoomId, false);
        Result<ToggleInOutNotificationResponseV2> disableResult = chatroomService.toggleInOutNotification(disableRequest);
        
        System.out.println("Disable In/Out Notification: " + disableResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(disableResult));
        
        // Verify the result
        Assert.assertEquals(200, disableResult.getCode());
        
        // Now enable in/out notification
        ToggleInOutNotificationRequestV2 enableRequest = new ToggleInOutNotificationRequestV2(fullRoomId, true);
        Result<ToggleInOutNotificationResponseV2> enableResult = chatroomService.toggleInOutNotification(enableRequest);
        
        System.out.println("Enable In/Out Notification: " + enableResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(enableResult));
        
        // Verify the result
        Assert.assertEquals(200, enableResult.getCode());
        
        System.out.println("In/Out notification toggled successfully");
    }
    
    /**
     * Test querying open chatrooms
     */
    @Test
    public void testQueryOpenChatrooms() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request
        QueryOpenChatroomsRequestV2 request = new QueryOpenChatroomsRequestV2(accountId1);
        
        // Query open chatrooms for the test account
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<QueryOpenChatroomsResponseV2> result = chatroomService.queryOpenChatrooms(request);
        
        System.out.println("Query Open Chatrooms: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        QueryOpenChatroomsResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        
        // The response should contain open chatrooms (may be empty if no chatrooms are open)
        if (response.getItems() != null && !response.getItems().isEmpty()) {
            System.out.println("Open chatrooms for creator " + accountId1 + ":");
            for (String roomId : response.getItems()) {
                System.out.println("  Room ID: " + roomId);
            }
        } else {
            System.out.println("No open chatrooms found for creator " + accountId1);
        }
    }
    
    /**
     * Test listing online chatroom members
     */
    @Test
    public void testListOnlineMembers() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request for listing online members
        ListOnlineMembersRequestV2 request = new ListOnlineMembersRequestV2(
            fullRoomId,    // Chatroom ID
            0L,        // Start from the beginning (offset 0)
            20         // Get up to 20 members per page
        );
        
        // Optionally filter by member role (in this case, list all roles)
        request.setMemberRoles("0,1,2,3,4");
        
        // List online members of the chatroom
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<ListOnlineMembersResponseV2> result = chatroomService.listOnlineMembers(request);
        
        System.out.println("List Online Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        ListOnlineMembersResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        
        // Print pagination info
        System.out.println("Has more members: " + response.getHasMore());
        if (response.getHasMore() != null && response.getHasMore()) {
            System.out.println("Next page offset: " + response.getOffset());
        }
        
        System.out.println("Total online members: " + response.getOnlineCount());
        
        // Print online members
        if (response.getItems() != null && !response.getItems().isEmpty()) {
            System.out.println("Online members of chatroom " + fullRoomId + ":");
            for (ListOnlineMembersResponseV2.ChatroomMemberInfo member : response.getItems()) {
                System.out.println("  Account ID: " + member.getAccountId());
                System.out.println("  Nickname: " + member.getRoomNick());
                System.out.println("  Role: " + member.getMemberRole());
                System.out.println("  Is Online: " + member.getIsOnline());
                System.out.println("  ----------------");
            }
        } else {
            System.out.println("No online members found in chatroom " + fullRoomId);
        }
    }
    
    /**
     * Test listing fixed chatroom members
     */
    @Test
    public void testListFixedMembers() throws YunxinSdkException {
        if (services == null) return;
        
        // Create request for listing fixed members
        ListFixedMembersRequestV2 request = new ListFixedMembersRequestV2(fullRoomId);
        
        // Optionally filter by member role (in this case, list creators and admins)
        request.setMemberRoles("1,2");
        
        // List fixed members of the chatroom
        IChatroomV2Service chatroomService = services.getChatroomService();
        Result<ListFixedMembersResponseV2> result = chatroomService.listFixedMembers(request);
        
        System.out.println("List Fixed Members: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the result
        Assert.assertEquals(200, result.getCode());
        ListFixedMembersResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        
        // Check if we have items (should have at least the creator)
        if (response.getItems() != null && !response.getItems().isEmpty()) {
            System.out.println("Fixed members of chatroom " + fullRoomId + ":");
            for (ListFixedMembersResponseV2.ChatroomMemberInfo member : response.getItems()) {
                System.out.println("  Account ID: " + member.getAccountId());
                System.out.println("  Nickname: " + member.getRoomNick());
                System.out.println("  Role: " + member.getMemberRole());
                System.out.println("  Is Online: " + member.getIsOnline());
                System.out.println("  ----------------");
            }
            
            // Verify that our creator is included in the fixed members
            boolean creatorFound = false;
            for (ListFixedMembersResponseV2.ChatroomMemberInfo member : response.getItems()) {
                if (member.getAccountId().equals(accountId1) && member.getMemberRole().equals("1")) {
                    creatorFound = true;
                    break;
                }
            }
            
            Assert.assertTrue("Creator should be in the fixed members list", creatorFound);
        } else {
            // This is unexpected - we should at least have the creator in the fixed members
            Assert.fail("No fixed members found in chatroom " + fullRoomId);
        }
    }
    
    /**
     * Helper method to create an account
     */
    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        
        // Create and set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        // If account already exists, it's not an error for our test
        if (result.getCode() == 200) {
            System.out.println("Created account: " + accountId + ", name: " + name);
            Assert.assertNotNull(result.getResponse());
            Assert.assertEquals(accountId, result.getResponse().getAccountId());
        } else if (result.getCode() == 414) {
            // 414 usually means account already exists
            System.out.println("Account already exists: " + accountId);
        } else {
            // Fail the test for other unexpected errors
            Assert.fail("Failed to create account: " + result.getMsg());
        }
    }
} 