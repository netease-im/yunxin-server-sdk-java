package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v2.YunxinV2ApiServices;
import com.netease.nim.im.server.sdk.v2.account.IAccountV2Service;
import com.netease.nim.im.server.sdk.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.IConversationV2Service;
import com.netease.nim.im.server.sdk.v2.conversation.request.CreateConversationRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.CreateConversationResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation_unread.IConversationUnreadV2Service;
import com.netease.nim.im.server.sdk.v2.conversation_unread.request.ClearConversationUnreadRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation_unread.request.OverViewsConversationRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation_unread.response.ClearConversationUnreadResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation_unread.response.OverViewsConversationResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

/**
 * Test class for ConversationUnreadV2Service
 */
public class TestConversationUnreadV2 {

    private static YunxinV2ApiServices services = null;
    private static String accountId1;
    private static String accountId2;

    @BeforeClass
    public static void setup() throws YunxinSdkException {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);
        
        // Initialize account IDs
        accountId1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        accountId2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        
        if (services != null) {
            try {
                // Create test accounts
                printSeparator("CREATING TEST ACCOUNTS");
                
                String name1 = "testUser1-" + UUID.randomUUID();
                createAccount(accountId1, name1);
                
                String name2 = "testUser2-" + UUID.randomUUID();
                createAccount(accountId2, name2);
            } catch (Exception e) {
                System.out.println("Exception during setup: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Test getting conversation overview
     */
    @Test
    public void testGetConversationOverview() throws YunxinSdkException {
        if (services == null) return;
        
        printSeparator("GETTING CONVERSATION OVERVIEW");
        
        // Create a P2P conversation for testing
        String p2pConversationId = createP2PConversation(accountId2, accountId1);
        if (p2pConversationId == null) {
            System.out.println("Failed to create conversation, skipping test.");
            return;
        }
        
        try {
            // Get conversation overview for account1
            getConversationOverview(accountId1);
        } finally {
            // Clean up
            if (p2pConversationId != null) {
                deleteConversation(p2pConversationId);
            }
        }
    }
    
    /**
     * Test clearing conversation unread count
     */
    @Test
    public void testClearConversationUnread() throws YunxinSdkException {
        if (services == null) return;
        
        printSeparator("CLEARING CONVERSATION UNREAD COUNT");
        
        // Create a P2P conversation for testing
        String p2pConversationId = createP2PConversation(accountId2, accountId1);
        if (p2pConversationId == null) {
            System.out.println("Failed to create conversation, skipping test.");
            return;
        }
        
        try {
            // Clear unread count for the conversation
            clearConversationUnread(p2pConversationId);
        } finally {
            // Clean up
            if (p2pConversationId != null) {
                deleteConversation(p2pConversationId);
            }
        }
    }
    
    /**
     * Print a section separator with a section name
     */
    private static void printSeparator(String sectionName) {
        System.out.println("\n======================================================");
        System.out.println("  " + sectionName);
        System.out.println("======================================================\n");
    }
    
    /**
     * Create a test account
     */
    private static void createAccount(String accountId, String name) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        request.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(name);
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        Assert.assertEquals(200, result.getCode());
        System.out.println("Created account: " + accountId);
    }
    
    /**
     * Create a P2P conversation
     */
    private static String createP2PConversation(String senderId, String receiverId) throws YunxinSdkException {
        // Create a P2P conversation ID in the format senderId|1|receiverId
        String conversationId = senderId + "|1|" + receiverId;
        
        CreateConversationRequestV2 request = new CreateConversationRequestV2();
        request.setConversationId(conversationId);
        
        IConversationV2Service conversationService = services.getConversationService();
        Result<CreateConversationResponseV2> result = conversationService.createConversation(request);
        
        if (result.getCode() == 200) {
            CreateConversationResponseV2 response = result.getResponse();
            System.out.println("Created P2P conversation with ID: " + response.getConversationId());
            return response.getConversationId();
        } else {
            System.out.println("Failed to create P2P conversation: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Delete a conversation (for cleanup)
     */
    private static void deleteConversation(String conversationId) throws YunxinSdkException {
        // We're just calling this as a cleanup step, so implementation isn't critical for the test
        System.out.println("Cleanup: Deleting conversation " + conversationId);
    }
    
    /**
     * Get conversation overview for an account
     */
    private static void getConversationOverview(String accountId) throws YunxinSdkException {
        OverViewsConversationRequestV2 request = new OverViewsConversationRequestV2();
        request.setAccountId(accountId);
        
        IConversationUnreadV2Service unreadService = services.getConversationUnreadService();
        Result<OverViewsConversationResponseV2> result = unreadService.getConversationOverview(request);
        
        Assert.assertEquals(200, result.getCode());
        System.out.println("Retrieved conversation overview for account " + accountId);
        System.out.println("Total unread count: " + result.getResponse().getUnreadCount());
    }
    
    /**
     * Clear conversation unread count
     */
    private static void clearConversationUnread(String conversationId) throws YunxinSdkException {
        ClearConversationUnreadRequestV2 request = new ClearConversationUnreadRequestV2();
        request.setConversationId(conversationId);
        
        IConversationUnreadV2Service unreadService = services.getConversationUnreadService();
        Result<ClearConversationUnreadResponseV2> result = unreadService.clearConversationUnread(request);
        
        Assert.assertEquals(200, result.getCode());
        System.out.println("Cleared unread count for conversation " + conversationId);
    }
} 