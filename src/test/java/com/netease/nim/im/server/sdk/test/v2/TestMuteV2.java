package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.mute.IMuteV2Service;
import com.netease.nim.server.sdk.im.v2.mute.request.AddMuteContactRequestV2;
import com.netease.nim.server.sdk.im.v2.mute.request.ListMuteContactsRequestV2;
import com.netease.nim.server.sdk.im.v2.mute.request.RemoveMuteContactRequestV2;
import com.netease.nim.server.sdk.im.v2.mute.response.AddMuteContactResponseV2;
import com.netease.nim.server.sdk.im.v2.mute.response.ListMuteContactsResponseV2;
import com.netease.nim.server.sdk.im.v2.mute.response.RemoveMuteContactResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

/**
 * Test class for MuteV2Service
 */
public class TestMuteV2 {

    private static YunxinV2ApiServices services = null;
    private static String accountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    private static String contactAccountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);
        CreateAccounts();
    }

    public static void CreateAccounts() throws YunxinSdkException {
        if (services == null) return;
        
        String name1 = "testUser-" + UUID.randomUUID();
        String name2 = "testContact-" + UUID.randomUUID();
        
        createAccount(accountId, name1);
        createAccount(contactAccountId, name2);
    }
    
    @Test
    public void testAddMuteContact() throws YunxinSdkException {
        if (services == null) return;
        // Test adding mute contact
        addMuteContact(accountId, contactAccountId);
    }
    
    @Test
    public void testListMuteContacts() throws YunxinSdkException {
        if (services == null) return;
        // List mute contacts
        listMuteContacts(accountId);
    }
    
    @Test
    public void testRemoveMuteContact() throws YunxinSdkException {
        if (services == null) return;
        
        // Make sure we have muted contacts
        testAddMuteContact();
        
        // Test removing mute contact
        removeMuteContact(accountId, contactAccountId);
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
     * Test adding a mute contact
     * 
     * @param accountId the account ID that initiates the mute operation
     * @param contactAccountId the contact account ID to be muted
     * @throws YunxinSdkException if an error occurs
     */
    private static void addMuteContact(String accountId, String contactAccountId) throws YunxinSdkException {
        AddMuteContactRequestV2 request = new AddMuteContactRequestV2();
        request.setAccountId(accountId);
        request.setContactAccountId(contactAccountId);
        
        IMuteV2Service muteService = services.getMuteService();
        Result<AddMuteContactResponseV2> result = muteService.addMuteContact(request);
        
        System.out.println("addMuteContact: " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
    }
    
    /**
     * Test listing mute contacts
     * 
     * @param accountId the account ID to list mute contacts for
     * @throws YunxinSdkException if an error occurs
     */
    private static void listMuteContacts(String accountId) throws YunxinSdkException {
        ListMuteContactsRequestV2 request = new ListMuteContactsRequestV2();
        request.setAccountId(accountId);
        // Optionally set pagination parameters
        request.setLimit(10);
        
        IMuteV2Service muteService = services.getMuteService();
        Result<ListMuteContactsResponseV2> result = muteService.listMuteContacts(request);
        
        System.out.println("listMuteContacts: " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertNotNull(result.getResponse().getItems());
        
        // If we expect the contact to be in the list, verify it
        boolean found = false;
        for (String contactId : result.getResponse().getItems()) {
            if (contactAccountId.equals(contactId)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("Contact should be in the mute list", found);
    }
    
    /**
     * Test removing a mute contact
     * 
     * @param accountId the account ID that initiates the unmute operation
     * @param contactAccountId the contact account ID to be unmuted
     * @throws YunxinSdkException if an error occurs
     */
    private static void removeMuteContact(String accountId, String contactAccountId) throws YunxinSdkException {
        RemoveMuteContactRequestV2 request = new RemoveMuteContactRequestV2();
        request.setAccountId(accountId);
        request.setContactAccountId(contactAccountId);
        
        IMuteV2Service muteService = services.getMuteService();
        Result<RemoveMuteContactResponseV2> result = muteService.removeMuteContact(request);
        
        System.out.println("removeMuteContact: " + result.getMsg());
        
        // Assertions
        Assert.assertEquals(200, result.getCode());
    }
} 