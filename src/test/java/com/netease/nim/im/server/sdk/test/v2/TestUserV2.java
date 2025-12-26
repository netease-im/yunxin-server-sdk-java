package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.users.IUserV2Service;
import com.netease.nim.server.sdk.im.v2.users.request.BatchGetUsersRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.GetUserOnlineStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.GetUserRequestV2;
import com.netease.nim.server.sdk.im.v2.users.request.UpdateUserRequestV2;
import com.netease.nim.server.sdk.im.v2.users.response.BatchGetUsersResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.GetUserOnlineStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.GetUserResponseV2;
import com.netease.nim.server.sdk.im.v2.users.response.UpdateUserResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Test class for UserV2Service
 */
public class TestUserV2 {

    private static YunxinV2ApiServices services = null;
    private static String accountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String accountId2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }

        services = new YunxinV2ApiServices(client);
        
        try {
            // Create test accounts
            String name = "testUser-" + UUID.randomUUID();
            createAccount(accountId, name);
            
            // Create a second test account
            String name2 = "testUser2-" + UUID.randomUUID();
            createAccount(accountId2, name2);
        } catch (YunxinSdkException e) {
            System.out.println("Failed to create test accounts: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateUser() throws YunxinSdkException {
        if (services == null) return;
        updateUser(accountId);
    }
    
    @Test
    public void testGetUser() throws YunxinSdkException {
        if (services == null) return;
        getUser(accountId);
    }
    
    @Test
    public void testBatchGetUsers() throws YunxinSdkException {
        if (services == null) return;
        batchGetUsers(accountId, accountId2);
    }
    
    @Test
    public void testGetUsersOnlineStatus() throws YunxinSdkException {
        if (services == null) return;
        getUsersOnlineStatus(accountId, accountId2);
    }
    
    @Test
    public void testUpdateUserWithEmailValidationMode() throws YunxinSdkException {
        if (services == null) return;
        updateUserWithEmailValidationMode(accountId);
    }
    
    /**
     * Helper method to create a test account
     * 
     * @param accountId the account ID to create
     * @param name the name for the account
     * @throws YunxinSdkException if an error occurs
     */
    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        
        // Set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);
        
        // Set configuration
        CreateAccountRequestV2.Configuration config = new CreateAccountRequestV2.Configuration();
        config.setEnabled(true);
        request.setConfiguration(config);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        System.out.println("createAccount(" + accountId + "):" + result.getMsg());
        Assert.assertEquals(200, result.getCode());
    }
    
    /**
     * Test updating user information
     * 
     * @param accountId the account ID to update
     * @throws YunxinSdkException if an error occurs
     */
    private static void updateUser(String accountId) throws YunxinSdkException {
        UpdateUserRequestV2 request = new UpdateUserRequestV2();
        request.setAccountId(accountId);
        
        // Set user profile information
        request.setName("Updated User Name");
        request.setAvatar("https://example.com/avatar.png");
        request.setSign("This is my signature");
        request.setEmail("user@example.com");
        request.setBirthday("1990-01-01");
        request.setMobile("+1-1234567890");
        request.setGender(UpdateUserRequestV2.GENDER_MALE);
        request.setExtension("{\"hobby\":\"reading\",\"location\":\"Beijing\"}");
        
        // Set antispam configuration
        UpdateUserRequestV2.AntispamConfigurationV2 antispamConfig = new UpdateUserRequestV2.AntispamConfigurationV2();
        antispamConfig.setEnabled(true);
        
        List<UpdateUserRequestV2.AntispamBusinessIdMapV2> businessIdMap = new ArrayList<>();
        
        // Add text detection
        UpdateUserRequestV2.AntispamBusinessIdMapV2 textDetection = new UpdateUserRequestV2.AntispamBusinessIdMapV2();
        textDetection.setType(UpdateUserRequestV2.AntispamBusinessIdMapV2.TYPE_TEXT);
        textDetection.setBusinessId("textscan123");
        businessIdMap.add(textDetection);
        
        // Add image detection
        UpdateUserRequestV2.AntispamBusinessIdMapV2 imageDetection = new UpdateUserRequestV2.AntispamBusinessIdMapV2();
        imageDetection.setType(UpdateUserRequestV2.AntispamBusinessIdMapV2.TYPE_IMAGE);
        imageDetection.setBusinessId("imagescan456");
        businessIdMap.add(imageDetection);
        
        antispamConfig.setBusinessIdMap(businessIdMap);
        request.setAntispamConfiguration(antispamConfig);
        
        IUserV2Service userService = services.getUserService();
        Result<UpdateUserResponseV2> result = userService.updateUser(request);
        
        System.out.println("updateUser:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        UpdateUserResponseV2 response = result.getResponse();
        Assert.assertEquals(accountId, response.getAccountId());
        Assert.assertEquals("Updated User Name", response.getName());
        Assert.assertEquals("https://example.com/avatar.png", response.getAvatar());
        Assert.assertEquals("This is my signature", response.getSign());
        Assert.assertEquals("user@example.com", response.getEmail());
        Assert.assertEquals("1990-01-01", response.getBirthday());
        Assert.assertEquals("+1-1234567890", response.getMobile());
        Assert.assertEquals(UpdateUserRequestV2.GENDER_MALE, response.getGender());
        
        // Print response details
        System.out.println("Updated user: " + response.getAccountId());
        System.out.println("Name: " + response.getName());
        System.out.println("Avatar: " + response.getAvatar());
        System.out.println("Sign: " + response.getSign());
        System.out.println("Email: " + response.getEmail());
        System.out.println("Birthday: " + response.getBirthday());
        System.out.println("Mobile: " + response.getMobile());
        System.out.println("Gender: " + response.getGender());
        if (response.getExtension() != null) {
            System.out.println("Extension: " + response.getExtension());
        }
    }
    
    /**
     * Test updating user with email validation mode
     * 
     * @param accountId the account ID to update
     * @throws YunxinSdkException if an error occurs
     */
    private static void updateUserWithEmailValidationMode(String accountId) throws YunxinSdkException {
        UpdateUserRequestV2 request = new UpdateUserRequestV2();
        request.setAccountId(accountId);
        
        // Set user profile information
        request.setName("User with Email Validation");
        request.setEmail("test.validation@example.com");
        
        // Set email validation mode
        // 0: Default validation mode
        // 1: Extended validation mode (includes special characters and Latin characters)
        // 2: No validation (not recommended, may cause unknown display issues)
        request.setEmailValidationMode(1); // Use extended validation mode
        
        IUserV2Service userService = services.getUserService();
        Result<UpdateUserResponseV2> result = userService.updateUser(request);
        
        System.out.println("updateUserWithEmailValidationMode:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        UpdateUserResponseV2 response = result.getResponse();
        Assert.assertEquals(accountId, response.getAccountId());
        Assert.assertEquals("User with Email Validation", response.getName());
        Assert.assertEquals("test.validation@example.com", response.getEmail());
        
        // Print response details
        System.out.println("Updated user with email validation mode:");
        System.out.println("Account ID: " + response.getAccountId());
        System.out.println("Name: " + response.getName());
        System.out.println("Email: " + response.getEmail());
    }
    
    /**
     * Test getting user information
     * 
     * @param accountId the account ID to get information for
     * @throws YunxinSdkException if an error occurs
     */
    private static void getUser(String accountId) throws YunxinSdkException {
        GetUserRequestV2 request = new GetUserRequestV2();
        request.setAccountId(accountId);
        
        IUserV2Service userService = services.getUserService();
        Result<GetUserResponseV2> result = userService.getUser(request);
        
        System.out.println("getUser:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        GetUserResponseV2 response = result.getResponse();
        Assert.assertEquals(accountId, response.getAccountId());
        Assert.assertEquals("Updated User Name", response.getName());
        Assert.assertEquals("https://example.com/avatar.png", response.getAvatar());
        Assert.assertEquals("This is my signature", response.getSign());
        Assert.assertEquals("user@example.com", response.getEmail());
        Assert.assertEquals("1990-01-01", response.getBirthday());
        Assert.assertEquals("+1-1234567890", response.getMobile());
        Assert.assertEquals((Integer)1, response.getGender());
        
        // Print response details
        System.out.println("Retrieved user: " + response.getAccountId());
        System.out.println("Name: " + response.getName());
        System.out.println("Avatar: " + response.getAvatar());
        System.out.println("Sign: " + response.getSign());
        System.out.println("Email: " + response.getEmail());
        System.out.println("Birthday: " + response.getBirthday());
        System.out.println("Mobile: " + response.getMobile());
        System.out.println("Gender: " + response.getGender());
        if (response.getExtension() != null) {
            System.out.println("Extension: " + response.getExtension());
        }
    }
    
    /**
     * Test batch getting users information
     * 
     * @param accountId1 the first account ID to get information for
     * @param accountId2 the second account ID to get information for
     * @throws YunxinSdkException if an error occurs
     */
    private static void batchGetUsers(String accountId1, String accountId2) throws YunxinSdkException {
        BatchGetUsersRequestV2 request = new BatchGetUsersRequestV2();
        List<String> accountIds = Arrays.asList(accountId1, accountId2);
        request.setAccountIds(accountIds);
        
        IUserV2Service userService = services.getUserService();
        Result<BatchGetUsersResponseV2> result = userService.batchGetUsers(request);
        
        System.out.println("batchGetUsers:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        BatchGetUsersResponseV2 response = result.getResponse();
        Assert.assertNotNull(response.getSuccessList());
        
        // Print success list details
        System.out.println("Number of successful retrievals: " + response.getSuccessList().size());
        for (BatchGetUsersResponseV2.UserInfo userInfo : response.getSuccessList()) {
            System.out.println("Retrieved user: " + userInfo.getAccountId());
            System.out.println("Name: " + userInfo.getName());
            
            // Check if the first account was successfully retrieved
            if (userInfo.getAccountId().equals(accountId1)) {
                Assert.assertEquals("Updated User Name", userInfo.getName());
                Assert.assertEquals("https://example.com/avatar.png", userInfo.getAvatar());
                Assert.assertEquals("This is my signature", userInfo.getSign());
                Assert.assertEquals("user@example.com", userInfo.getEmail());
                Assert.assertEquals("1990-01-01", userInfo.getBirthday());
                Assert.assertEquals("+1-1234567890", userInfo.getMobile());
                Assert.assertEquals((Integer)1, userInfo.getGender());
            }
        }
        
        // Print failed list details if any
        if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
            System.out.println("Number of failed retrievals: " + response.getFailedList().size());
            for (BatchGetUsersResponseV2.FailedInfo failedInfo : response.getFailedList()) {
                System.out.println("Failed account ID: " + failedInfo.getAccountId());
                System.out.println("Error code: " + failedInfo.getErrorCode());
                System.out.println("Error message: " + failedInfo.getErrorMsg());
            }
        }
    }
    
    /**
     * Test getting users' online status
     * 
     * @param accountId1 the first account ID to get online status for
     * @param accountId2 the second account ID to get online status for
     * @throws YunxinSdkException if an error occurs
     */
    private static void getUsersOnlineStatus(String accountId1, String accountId2) throws YunxinSdkException {
        GetUserOnlineStatusRequestV2 request = new GetUserOnlineStatusRequestV2();
        List<String> accountIds = Arrays.asList(accountId1, accountId2);
        request.setAccountIds(accountIds);
        
        IUserV2Service userService = services.getUserService();
        Result<GetUserOnlineStatusResponseV2> result = userService.getUsersOnlineStatus(request);
        
        System.out.println("getUsersOnlineStatus:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        GetUserOnlineStatusResponseV2 response = result.getResponse();
        
        // Print success list details
        if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
            System.out.println("Number of successful online status retrievals: " + response.getSuccessList().size());
            for (GetUserOnlineStatusResponseV2.UserOnlineStatus userStatus : response.getSuccessList()) {
                System.out.println("User account ID: " + userStatus.getAccountId());
                
                if (userStatus.getOnlineStatus() != null && !userStatus.getOnlineStatus().isEmpty()) {
                    System.out.println("Online status information:");
                    for (GetUserOnlineStatusResponseV2.ClientStatus clientStatus : userStatus.getOnlineStatus()) {
                        System.out.println("  Client type: " + getClientTypeDescription(clientStatus.getClientType()));
                        System.out.println("  Login time: " + clientStatus.getLoginTime());
                    }
                } else {
                    System.out.println("User is not online on any device.");
                }
            }
        } else {
            System.out.println("No online status information retrieved.");
        }
        
        // Print failed list details if any
        if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
            System.out.println("Number of failed online status retrievals: " + response.getFailedList().size());
            for (GetUserOnlineStatusResponseV2.FailedInfo failedInfo : response.getFailedList()) {
                System.out.println("Failed account ID: " + failedInfo.getAccountId());
                System.out.println("Error code: " + failedInfo.getErrorCode());
                System.out.println("Error message: " + failedInfo.getErrorMsg());
            }
        }
    }
    
    /**
     * Get the description of a client type
     * 
     * @param clientType the client type code
     * @return the description of the client type
     */
    private static String getClientTypeDescription(Integer clientType) {
        if (clientType == null) {
            return "Unknown";
        }
        
        switch (clientType) {
            case GetUserOnlineStatusResponseV2.ClientStatus.CLIENT_TYPE_ANDROID:
                return "Android";
            case GetUserOnlineStatusResponseV2.ClientStatus.CLIENT_TYPE_IOS:
                return "iOS";
            case GetUserOnlineStatusResponseV2.ClientStatus.CLIENT_TYPE_PC:
                return "PC";
            case GetUserOnlineStatusResponseV2.ClientStatus.CLIENT_TYPE_WEB:
                return "Web";
            case GetUserOnlineStatusResponseV2.ClientStatus.CLIENT_TYPE_MAC:
                return "Mac";
            case GetUserOnlineStatusResponseV2.ClientStatus.CLIENT_TYPE_HARMONY:
                return "Harmony";
            default:
                return "Unknown client type: " + clientType;
        }
    }
} 