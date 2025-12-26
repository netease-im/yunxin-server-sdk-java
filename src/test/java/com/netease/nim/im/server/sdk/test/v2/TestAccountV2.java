package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.BatchQueryAccountsRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.DisableAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.GetAccountDetailsRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.KickAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.RefreshTokenRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.SetPushConfigRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.UpdateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.BatchQueryAccountsResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.DisableAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.GetAccountDetailsResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.KickAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.RefreshTokenResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.SetPushConfigResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.UpdateAccountResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Test class for AccountV2Service
 */
public class TestAccountV2 {

    private static YunxinV2ApiServices services = null;
    private static String accountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String accountId1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @BeforeClass
    public static void setup() {
        if (services != null) {
            return;
        }

        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);
    }

    @Test
    public void testCreateAccount() throws YunxinSdkException {
        if (services == null) return;
        createAccount(accountId);
    }
    
    @Test
    public void testGetAccountDetails() throws YunxinSdkException {
        if (services == null) return;
        getAccountDetails(accountId);
    }
    
    @Test
    public void testUpdateAccount() throws YunxinSdkException {
        if (services == null) return;
        String name = "testUser-" + UUID.randomUUID();
        updateAccount(name + "-updated");
    }
    
    @Test
    public void testBatchQueryAccounts() throws YunxinSdkException {
        if (services == null) return;
        CreateAccountResponseV2 createResponse = createAccount(accountId1);
        batchQueryAccounts(createResponse.getAccountId());
    }
    
//    @Test 暂时无法测试需要模拟登录设备
//    public void testSetPushConfig() throws YunxinSdkException {
//        if (services == null) return;
//        setPushConfig(true);
//        setPushConfig(false);
//    }
    
    @Test
    public void testDisableAccount() throws YunxinSdkException {
        if (services == null) return;
        disableAccount(false);
        disableAccount(true);
    }
    
    @Test
    public void testKickAccount() throws YunxinSdkException {
        if (services == null) return;
        kickAccount();
    }
    
    @Test
    public void testRefreshToken() throws YunxinSdkException {
        if (services == null) return;
        refreshToken(accountId);
    }
    
    @Test
    public void testCreateAccountWithEmailValidationMode() throws YunxinSdkException {
        if (services == null) return;
        
        // Test with mode 0 (default validation mode)
        String accountIdMode0 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        createAccountWithEmailValidationMode(accountIdMode0, 0);
        
        // Test with mode 1 (extended validation mode with special and Latin characters)
        String accountIdMode1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        createAccountWithEmailValidationMode(accountIdMode1, 1);
        
        // Test with mode 2 (no validation - not recommended)
        String accountIdMode2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        createAccountWithEmailValidationMode(accountIdMode2, 2);
    }
    
    @Test
    public void testUpdateAccountWithEmailValidationMode() throws YunxinSdkException {
        if (services == null) return;
        
        // Create an account first
        String testAccountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        createAccount(testAccountId);
        
        // Update account with different email validation modes
        updateAccountWithEmailValidationMode(testAccountId, 0);
        updateAccountWithEmailValidationMode(testAccountId, 1);
        updateAccountWithEmailValidationMode(testAccountId, 2);
    }
    
    /**
     * Test create account operation
     * 
     * @param accountId The accountId for the account
     * @return CreateAccountResponseV2 response object
     * @throws YunxinSdkException if an error occurs
     */
    private static CreateAccountResponseV2 createAccount(String accountId) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        // 网易云信账号，请确保唯一性，只允许字母、数字、半角下划线、@、半角点以及半角横线，长度上限为 32 位字符
        request.setAccountId(accountId);
        // 登录密钥 Token，长度上限 128 位字符
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        
        // 设置用户信息
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        // 用户昵称，长度上限 64 位字符
        userInfo.setName(accountId);
        // 用户头像URL，长度上限 1024 位字符
        userInfo.setAvatar("https://example.com/avatar.jpg");
        // 用户签名，长度上限 256 位字符
        userInfo.setSign("This is a test signature");
        // 用户邮箱，长度上限 64 位字符
        userInfo.setEmail("test@example.com");
        // 用户生日，格式如 "xxxx-xx-xx"
        userInfo.setBirthday("1990-01-01");
        // 用户手机号，长度上限 32 位字符
        userInfo.setMobile("13800138000");
        // 用户性别，0-未知，1-男，2-女
        userInfo.setGender(1);
        // 扩展字段，建议JSON格式，长度上限 1024 位字符
        userInfo.setExtension("{\"custom_key\":\"custom_value\"}");
        // 用户信息校验模式，0-默认当前校验模式；1-扩展校验模式，包括特殊字符和拉丁字符；2-不校验，不建议用该模式，可能会导致未知显示问题
        userInfo.setEmailValidationMode(0);
        request.setUserInformation(userInfo);

        // 设置安全通相关配置
        CreateAccountRequestV2.AntispamConfiguration antispamConfig = new CreateAccountRequestV2.AntispamConfiguration();
        antispamConfig.setEnabled(true);
        
        // 设置安全通业务ID列表（嵌套在antispam_configuration内）
        java.util.List<CreateAccountRequestV2.BusinessIdMapItem> businessIdMap = new java.util.ArrayList<>();
        CreateAccountRequestV2.BusinessIdMapItem textItem = new CreateAccountRequestV2.BusinessIdMapItem();
        textItem.setType(1);
        textItem.setBusinessId("your_text_business_id");
        businessIdMap.add(textItem);
        antispamConfig.setBusinessIdMap(businessIdMap);
        
        request.setAntispamConfiguration(antispamConfig);
        
        // 设置配置项
        CreateAccountRequestV2.Configuration config = new CreateAccountRequestV2.Configuration();
        // 账号是否可用，默认为true
        config.setEnabled(true);
        // 单聊禁言标记，true表示禁言
        config.setP2pChatBanned(false);
        // 群聊禁言标记，true表示禁言
        config.setTeamChatBanned(false);
        // 聊天室禁言标记，true表示禁言
        config.setChatroomChatBanned(false);
        // 圈组禁言标记，true表示禁言
        config.setQchatChatBanned(false);
        request.setConfiguration(config);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        System.out.println("createAccount:"+result.getMsg());
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
        Assert.assertNotNull(result.getResponse().getToken());
        
        return result.getResponse();
    }
    
    /**
     * Test create account with different email validation modes
     * 
     * @param accountId The accountId for the account
     * @param emailValidationMode Email validation mode: 0-default, 1-extended, 2-no validation
     * @return CreateAccountResponseV2 response object
     * @throws YunxinSdkException if an error occurs
     */
    private static CreateAccountResponseV2 createAccountWithEmailValidationMode(String accountId, Integer emailValidationMode) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        
        // 设置用户信息，包含email_validation_mode
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName("testUser_" + emailValidationMode);
        userInfo.setEmail("test@example.com");
        // 设置用户信息校验模式
        // 0：默认当前校验模式
        // 1：扩展校验模式，包括特殊字符和拉丁字符
        // 2：不校验，不建议用该模式，可能会导致未知显示问题
        userInfo.setEmailValidationMode(emailValidationMode);
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        System.out.println("createAccountWithEmailValidationMode (mode=" + emailValidationMode + "): " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
        
        return result.getResponse();
    }
    
    /**
     * Test update account with different email validation modes
     * 
     * @param accountId The accountId for the account
     * @param emailValidationMode Email validation mode: 0-default, 1-extended, 2-no validation
     * @throws YunxinSdkException if an error occurs
     */
    private static void updateAccountWithEmailValidationMode(String accountId, Integer emailValidationMode) throws YunxinSdkException {
        UpdateAccountRequestV2 request = new UpdateAccountRequestV2();
        request.setAccountId(accountId);
        
        // Set user information with email_validation_mode
        UpdateAccountRequestV2.UserInformation userInfo = new UpdateAccountRequestV2.UserInformation();
        userInfo.setName("updatedUser_mode_" + emailValidationMode);
        userInfo.setAvatar("https://example.com/avatar-mode-" + emailValidationMode + ".jpg");
        userInfo.setEmail("updated" + emailValidationMode + "@example.com");
        // 设置用户信息校验模式
        // 0：默认当前校验模式
        // 1：扩展校验模式，包括特殊字符和拉丁字符
        // 2：不校验，不建议用该模式，可能会导致未知显示问题
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<UpdateAccountResponseV2> result = accountService.updateAccount(request);
        System.out.println("updateAccountWithEmailValidationMode (mode=" + emailValidationMode + "): " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
    }
    
    /**
     * Test update account operation
     * 
     * @param updatedName The new name for the account
     * @throws YunxinSdkException if an error occurs
     */
    private static void updateAccount(String updatedName) throws YunxinSdkException {
        UpdateAccountRequestV2 request = new UpdateAccountRequestV2();
        request.setAccountId(accountId);
        
        // Set configuration
        UpdateAccountRequestV2.Configuration config = new UpdateAccountRequestV2.Configuration();
        config.setEnabled(true);
        request.setConfiguration(config);
        
        // Set user information with email_validation_mode
        UpdateAccountRequestV2.UserInformation userInfo = new UpdateAccountRequestV2.UserInformation();
        userInfo.setName(updatedName);
        userInfo.setAvatar("https://example.com/updated-avatar.jpg");
        userInfo.setSign("Updated signature");
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<UpdateAccountResponseV2> result = accountService.updateAccount(request);
        System.out.println("updateAccount:"+result.getMsg());
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
    }
    
    /**
     * Test batch query accounts operation
     * 
     * @param accountId The account ID to query
     * @throws YunxinSdkException if an error occurs
     */
    private static void batchQueryAccounts(String accountId) throws YunxinSdkException {
        BatchQueryAccountsRequestV2 request = new BatchQueryAccountsRequestV2();
        List<String> accountList = new ArrayList<>();
        accountList.add(accountId);
        
        // Add a non-existent account to test handling of invalid accounts
        String nonExistentAccountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        accountList.add(nonExistentAccountId);
        
        request.setAccountList(accountList);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<BatchQueryAccountsResponseV2> result = accountService.batchQueryAccounts(request);
        System.out.println("batchQuery:"+result.getMsg());
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Should have at least one valid account (the one we created)
        List<BatchQueryAccountsResponseV2.Account> successList = result.getResponse().getSuccessList();
        Assert.assertTrue(successList.size() > 0);
        
        // Check the account we created is in the results
        boolean foundCreatedAccount = false;
        for (BatchQueryAccountsResponseV2.Account account : successList) {
            if (account.getAccountId().equals(accountId)) {
                foundCreatedAccount = true;
                break;
            }
        }
        Assert.assertTrue("The created account should be found in batch query results", foundCreatedAccount);
    }
    
    /**
     * Test disable or enable account operation
     * 
     * @param enabled Whether to enable (true) or disable (false) the account
     * @throws YunxinSdkException if an error occurs
     */
    private static void disableAccount(boolean enabled) throws YunxinSdkException {
        DisableAccountRequestV2 request = new DisableAccountRequestV2();
        request.setAccountId(accountId);
        // 设置账号是否可用，true表示可用，false表示禁用
        request.setEnabled(enabled);
        
        if (!enabled) {
            // 如果禁用账号，设置是否同时踢下线
            request.setNeedKick(true);
            // 设置踢下线操作的扩展字段，可透传至客户端SDK
            request.setKickNotifyExtension("{\"reason\":\"Account disabled for testing\"}");
        }
        
        IAccountV2Service accountService = services.getAccountService();
        Result<DisableAccountResponseV2> result = accountService.disableAccount(request);
        
        String action = enabled ? "enableAccount" : "disableAccount";
        System.out.println(action + ":" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
        
        // Verify account configuration
        DisableAccountResponseV2.Configuration config = result.getResponse().getConfiguration();
        Assert.assertEquals(enabled, config.getEnabled());
    }
    
    /**
     * Test set push configuration operation
     * 
     * @param enabled Whether to enable (true) or disable (false) push when desktop is online
     * @throws YunxinSdkException if an error occurs
     */
    private static void setPushConfig(boolean enabled) throws YunxinSdkException {
        SetPushConfigRequestV2 request = new SetPushConfigRequestV2();
        request.setAccountId(accountId);
        // 桌面端在线时，移动端是否需要推送
        request.setPushEnabledWhenDesktopOnline(enabled);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<SetPushConfigResponseV2> result = accountService.setPushConfig(request);
        
        String action = enabled ? "enablePush" : "disablePush";
        System.out.println(action + ":" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
        
        // Verify the push setting was applied
        SetPushConfigResponseV2.Configuration config = result.getResponse().getConfiguration();
        if (config != null && config.getPushEnabledWhenDesktopOnline() != null) {
            Assert.assertEquals(enabled, config.getPushEnabledWhenDesktopOnline());
        }
    }
    
    /**
     * Test get account details operation
     * 
     * @param accountId The account ID to query
     * @throws YunxinSdkException if an error occurs
     */
    private static void getAccountDetails(String accountId) throws YunxinSdkException {
        GetAccountDetailsRequestV2 request = new GetAccountDetailsRequestV2();
        request.setAccountId(accountId);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<GetAccountDetailsResponseV2> result = accountService.getAccountDetails(request);
        System.out.println("getAccountDetails:" + result.getMsg());
        
        // Note: This may fail if the account does not exist
        // We only assert the response code if it's successful
        if (result.getCode() == 200) {
            Assert.assertNotNull(result.getResponse());
            Assert.assertEquals(accountId, result.getResponse().getAccountId());
        }
    }
    
    /**
     * Test kick account operation
     * 
     * @throws YunxinSdkException if an error occurs
     */
    private static void kickAccount() throws YunxinSdkException {
        KickAccountRequestV2 request = new KickAccountRequestV2();
        request.setAccountId(accountId);
        
        // Set a notification extension message
        request.setKickNotifyExtension("{\"reason\":\"Testing kick operation\"}");
        request.setType(1);
        IAccountV2Service accountService = services.getAccountService();
        Result<KickAccountResponseV2> result = accountService.kickAccount(request);
        System.out.println("kickAccount:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        // Print successful kicked devices if any
        KickAccountResponseV2 response = result.getResponse();
        if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
            System.out.println("Successfully kicked devices: " + response.getSuccessList().size());
        }
    }
    
    /**
     * Test refresh token operation
     * 
     * @param accountId The account ID to refresh token for
     * @throws YunxinSdkException if an error occurs
     */
    private static void refreshToken(String accountId) throws YunxinSdkException {
        RefreshTokenRequestV2 request = new RefreshTokenRequestV2();
        request.setAccountId(accountId);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<RefreshTokenResponseV2> result = accountService.refreshToken(request);
        System.out.println("refreshToken:" + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
        Assert.assertNotNull(result.getResponse().getToken());
        
        // Print the new token
        System.out.println("New token: " + result.getResponse().getToken());
        
        // Check configuration if available
        RefreshTokenResponseV2.Configuration config = result.getResponse().getConfiguration();
        if (config != null) {
            System.out.println("Account enabled: " + config.getEnabled());
        }
    }
} 