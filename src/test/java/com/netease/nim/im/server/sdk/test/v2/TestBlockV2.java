package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.block.IBlockV2Service;
import com.netease.nim.server.sdk.im.v2.block.request.AddBlockContactRequestV2;
import com.netease.nim.server.sdk.im.v2.block.request.ListBlockContactsRequestV2;
import com.netease.nim.server.sdk.im.v2.block.request.RemoveBlockContactRequestV2;
import com.netease.nim.server.sdk.im.v2.block.response.AddBlockContactResponseV2;
import com.netease.nim.server.sdk.im.v2.block.response.ListBlockContactsResponseV2;
import com.netease.nim.server.sdk.im.v2.block.response.RemoveBlockContactResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

/**
 * Test class for BlockV2Service
 */
public class TestBlockV2 {

    private static YunxinV2ApiServices services = null;
    private static IBlockV2Service blockService = null;
    private static IAccountV2Service accountService = null;
    private static String accountId = "block_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
    private static String contactAccountId = "contact_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);

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
        blockService = services.getBlockService();
        accountService = services.getAccountService();
        
        // Create test accounts
        try {
            String name1 = "testUser-" + UUID.randomUUID();
            createAccount(accountId, name1);
            
            String name2 = "testContact-" + UUID.randomUUID();
            createAccount(contactAccountId, name2);
        } catch (Exception e) {
            System.err.println("Error creating test accounts: " + e.getMessage());
        }
    }

    @Test
    public void testAddBlockContact() throws YunxinSdkException {
        if (services == null) return;
        
        AddBlockContactRequestV2 request = new AddBlockContactRequestV2();
        request.setAccountId(accountId);
        request.setContactAccountId(contactAccountId);

        
        Result<AddBlockContactResponseV2> result = blockService.addBlockContact(request);
        
        System.out.println("addBlockContact: " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
    }
    
    @Test
    public void testListBlockContacts() throws YunxinSdkException {
        if (services == null) return;
        
        // First ensure there's a blocked contact by adding one
        testAddBlockContact();

        ListBlockContactsRequestV2 request = new ListBlockContactsRequestV2();
        request.setAccountId(accountId);
        request.setLimit(10);

        Result<ListBlockContactsResponseV2> result = blockService.listBlockContacts(request);
        
        System.out.println("listBlockContacts: " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertNotNull(result.getResponse().getItems());
        
        // If we expect the contact to be in the list, verify it
        boolean found = false;
        for (String item : result.getResponse().getItems()) {
            if (contactAccountId.equals(item)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("Contact should be in the block list", found);
        
        // If hasMore is true, we should have a valid nextToken
        if (Boolean.TRUE.equals(result.getResponse().getHasMore())) {
            Assert.assertNotNull("Next token should be present when hasMore is true", 
                result.getResponse().getNextToken());
        }
    }
    
    @Test
    public void testRemoveBlockContact() throws YunxinSdkException {
        if (services == null) return;
        
        // First ensure there's a blocked contact by adding one
        testAddBlockContact();
        
        RemoveBlockContactRequestV2 request = new RemoveBlockContactRequestV2();
        request.setAccountId(accountId);
        request.setContactAccountId(contactAccountId);
        
        Result<RemoveBlockContactResponseV2> result = blockService.removeBlockContact(request);
        
        System.out.println("removeBlockContact: " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
    }
    
    @Test
    public void testContactRemovalVerification() throws YunxinSdkException {
        if (services == null) return;
        
        // First add a contact to the block list
        testAddBlockContact();
        
        // Then remove it
        testRemoveBlockContact();
        
        // Now verify it's not in the list anymore
        ListBlockContactsRequestV2 request = new ListBlockContactsRequestV2();
        request.setAccountId(accountId);
        request.setLimit(100);
        
        Result<ListBlockContactsResponseV2> result = blockService.listBlockContacts(request);
        
        System.out.println("verifyContactNotInBlockList: " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        
        // Verify the contact is not in the list
        boolean found = false;
        if (result.getResponse() != null && result.getResponse().getItems() != null) {
            for (String item : result.getResponse().getItems()) {
                if (contactAccountId.equals(item)) {
                    found = true;
                    break;
                }
            }
        }
        Assert.assertFalse("Contact should not be in the block list", found);
    }
    
    @Test
    public void testFullBlockCycle() throws YunxinSdkException {
        if (services == null) return;
        
        // Test the full block cycle: add, list, remove, verify
        testAddBlockContact();
        testListBlockContacts();
        testRemoveBlockContact();
        testContactRemovalVerification();
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
        
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        System.out.println("createAccount(" + accountId + "):" + result.getMsg());
        if (result.getCode() == 200) {
            System.out.println("Created account: " + accountId);
        } else if (result.getCode() == 414) {
            // Account already exists
            System.out.println("Account already exists: " + accountId);
        } else {
            System.err.println("Failed to create account " + accountId + ": " + result.getMsg());
        }
    }
} 