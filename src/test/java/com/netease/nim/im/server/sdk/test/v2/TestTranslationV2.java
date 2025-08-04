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
import com.netease.nim.server.sdk.im.v2.tool.IToolV2Service;
import com.netease.nim.server.sdk.im.v2.translation.request.TranslateTextRequestV2;
import com.netease.nim.server.sdk.im.v2.translation.response.TranslateTextResponseV2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for the Translation V2 functionality
 */
public class TestTranslationV2 {

    private static YunxinV2ApiServices services;
    
    // Test account ID
    private static final String accountId = "translator_" + System.currentTimeMillis();
    
    /**
     * Initialize test environment
     */
    @BeforeClass
    public static void setup() throws Exception {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        
        services = new YunxinV2ApiServices(client);
        
        // Create test account
        System.out.println("\n==== Creating Test Account ====");
        createAccount(accountId, "Translator User");
    }
    
    /**
     * Test Chinese to English translation
     */
    @Test
    public void testChineseToEnglishTranslation() throws Exception {
        if (services == null) {
            return;
        }
        
        try {
            // Get translation service
            IToolV2Service toolV2Service= services.getToolService();
            
            System.out.println("\n==== Testing Chinese to English Translation ====");
            
            // Create translate request for Chinese to English
            TranslateTextRequestV2 zhToEnRequest = new TranslateTextRequestV2();
            zhToEnRequest.setOperatorAccountId(accountId);
            zhToEnRequest.setSourceText("你好，世界！这是一个翻译测试。");
            zhToEnRequest.setSourceLanguage("zh-CHS");
            zhToEnRequest.setTargetLanguage("en");

            // Create translator config with strict mode
            TranslateTextRequestV2.TranslatorConfig zhToEnConfig = new TranslateTextRequestV2.TranslatorConfig();
            zhToEnConfig.setStrict(true);
            zhToEnRequest.setTranslatorConfig(zhToEnConfig);

            // Perform translation
            Result<TranslateTextResponseV2> zhToEnResult = toolV2Service.translateText(zhToEnRequest);

            // Verify the operation was successful
            System.out.println("Chinese to English Translation Result: " + zhToEnResult.getMsg());
            System.out.println("Response: " + JSON.toJSONString(zhToEnResult));
            Assert.assertEquals(200, zhToEnResult.getCode());

            // Check translation results
            TranslateTextResponseV2 zhToEnResponse = zhToEnResult.getResponse();
            if (zhToEnResponse != null) {
                System.out.println("Source Language: " + zhToEnResponse.getSourceLanguage());
                System.out.println("Target Language: " + zhToEnResponse.getTargetLanguage());
                System.out.println("Original Text: 你好，世界！这是一个翻译测试。");
                System.out.println("Translated Text: " + zhToEnResponse.getTranslatedText());

                Assert.assertNotNull("Translated text should not be null", zhToEnResponse.getTranslatedText());
                Assert.assertFalse("Translated text should not be empty", zhToEnResponse.getTranslatedText().isEmpty());
                Assert.assertEquals("Source language should be zh", "zh-CHS", zhToEnResponse.getSourceLanguage());
                Assert.assertEquals("Target language should be en", "en", zhToEnResponse.getTargetLanguage());
            } else {
                Assert.fail("Response object is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test English to Chinese translation
     */
    @Test
    public void testEnglishToChineseTranslation() throws Exception {
        if (services == null) {
            return;
        }
        
        try {
            // Get translation service
            IToolV2Service translationService = services.getToolService();
            
            System.out.println("\n==== Testing English to Chinese Translation ====");

            // Create translate request for English to Chinese
            TranslateTextRequestV2 enToZhRequest = new TranslateTextRequestV2();
            enToZhRequest.setOperatorAccountId(accountId);
            enToZhRequest.setSourceText("Hello, world! This is a translation test.");
            enToZhRequest.setSourceLanguage("en");
            enToZhRequest.setTargetLanguage("zh-CHS");

            // Create translator config with strict mode
            TranslateTextRequestV2.TranslatorConfig enToZhConfig = new TranslateTextRequestV2.TranslatorConfig();
            enToZhConfig.setStrict(true);
            enToZhRequest.setTranslatorConfig(enToZhConfig);

            // Perform translation
            Result<TranslateTextResponseV2> enToZhResult = translationService.translateText(enToZhRequest);

            // Verify the operation was successful
            System.out.println("English to Chinese Translation Result: " + enToZhResult.getMsg());
            System.out.println("Response: " + JSON.toJSONString(enToZhResult));
            Assert.assertEquals(200, enToZhResult.getCode());

            // Check translation results
            TranslateTextResponseV2 enToZhResponse = enToZhResult.getResponse();
            if (enToZhResponse != null) {
                System.out.println("Source Language: " + enToZhResponse.getSourceLanguage());
                System.out.println("Target Language: " + enToZhResponse.getTargetLanguage());
                System.out.println("Original Text: Hello, world! This is a translation test.");
                System.out.println("Translated Text: " + enToZhResponse.getTranslatedText());

                Assert.assertNotNull("Translated text should not be null", enToZhResponse.getTranslatedText());
                Assert.assertFalse("Translated text should not be empty", enToZhResponse.getTranslatedText().isEmpty());
                Assert.assertEquals("Source language should be en", "en", enToZhResponse.getSourceLanguage());
                Assert.assertEquals("Target language should be zh", "zh-CHS", enToZhResponse.getTargetLanguage());
            } else {
                Assert.fail("Response object is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test auto-detect language translation
     */
    @Test
    public void testAutoDetectLanguageTranslation() throws Exception {
        if (services == null) {
            return;
        }
        
        try {
            // Get translation service
            IToolV2Service translationService = services.getToolService();
            
            System.out.println("\n==== Testing Auto-detect Language Translation ====");
            
            // Create translate request with auto-detect language
            TranslateTextRequestV2 autoDetectRequest = new TranslateTextRequestV2();
            autoDetectRequest.setOperatorAccountId(accountId);
            autoDetectRequest.setSourceText("こんにちは、世界！これは翻訳テストです。");
            // No source language specified, will auto-detect
            autoDetectRequest.setTargetLanguage("en");
            
            // Perform translation
            Result<TranslateTextResponseV2> autoDetectResult = translationService.translateText(autoDetectRequest);
            
            // Verify the operation was successful
            System.out.println("Auto-detect Language Translation Result: " + autoDetectResult.getMsg());
            System.out.println("Response: " + JSON.toJSONString(autoDetectResult));
            Assert.assertEquals(200, autoDetectResult.getCode());
            
            // Check translation results
            TranslateTextResponseV2 autoDetectResponse = autoDetectResult.getResponse();
            if (autoDetectResponse != null) {
                System.out.println("Detected Source Language: " + autoDetectResponse.getSourceLanguage());
                System.out.println("Target Language: " + autoDetectResponse.getTargetLanguage());
                System.out.println("Original Text: こんにちは、世界！これは翻訳テストです。");
                System.out.println("Translated Text: " + autoDetectResponse.getTranslatedText());
                
                Assert.assertNotNull("Translated text should not be null", autoDetectResponse.getTranslatedText());
                Assert.assertFalse("Translated text should not be empty", autoDetectResponse.getTranslatedText().isEmpty());
                Assert.assertNotNull("Detected source language should not be null", autoDetectResponse.getSourceLanguage());
                Assert.assertEquals("Target language should be en", "en", autoDetectResponse.getTargetLanguage());
            } else {
                Assert.fail("Response object is null");
            }
            
            System.out.println("\n==== Translation Tests Completed Successfully ====");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
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