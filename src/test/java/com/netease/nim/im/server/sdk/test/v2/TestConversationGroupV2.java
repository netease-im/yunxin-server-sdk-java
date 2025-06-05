package com.netease.nim.im.server.sdk.test.v2;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v2.YunxinV2ApiServices;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.IConversationV2Service;
import com.netease.nim.server.sdk.im.v2.conversation.request.CreateConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.CreateConversationResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.IConversationGroupV2Service;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.BatchGetConversationGroupsRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.CreateConversationGroupRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.DeleteConversationGroupRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.GetConversationGroupRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.ListAllConversationGroupsRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.UpdateConversationGroupRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.BatchGetConversationGroupsResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.CreateConversationGroupResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.DeleteConversationGroupResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.GetConversationGroupResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.ListAllConversationGroupsResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.UpdateConversationGroupResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Test class for ConversationGroupV2Service
 * Each API operation has its own @Test method for better test isolation and readability
 */
public class TestConversationGroupV2 {

    private static YunxinV2ApiServices services = null;
    private static String accountId1;
    private static String accountId2;
    private static String accountId3;
    private static String accountId4;
    private static List<String> conversationIds;

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
        accountId3 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        accountId4 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        conversationIds = new ArrayList<>();
        
        if (services != null) {
            try {
                // Create test accounts
                printSeparator("CREATING TEST ACCOUNTS");
                
                String name1 = "testUser1-" + UUID.randomUUID();
                createAccount(accountId1, name1);
                
                String name2 = "testUser2-" + UUID.randomUUID();
                createAccount(accountId2, name2);

                String name3 = "testUser3-" + UUID.randomUUID();
                createAccount(accountId3, name3);

               String name4 = "testUser4-" + UUID.randomUUID();
               createAccount(accountId4, name4);

                // Create some conversations for testing
                printSeparator("CREATING TEST CONVERSATIONS");
                
                String p2pConversationId1 = createP2PConversation(accountId1, accountId2);
                if (p2pConversationId1 != null) {
                    conversationIds.add(p2pConversationId1);
                }

                String p2pConversationId2 = createP2PConversation(accountId1, accountId3);
                if (p2pConversationId2 != null) {
                    conversationIds.add(p2pConversationId2);
                }
            } catch (Exception e) {
                System.out.println("Exception during setup: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Test creating a conversation group
     */
    @Test
    public void testCreateConversationGroup() throws YunxinSdkException {
        if (services == null || conversationIds.isEmpty()) {
            System.out.println("Setup failed or no conversations available, skipping test.");
            return;
        }

        printSeparator("CREATING CONVERSATION GROUP");

        // Create a conversation group
        CreateConversationGroupRequestV2 request = new CreateConversationGroupRequestV2();
        request.setAccountId(accountId1);
        request.setName("Test Group"+ UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32));
        request.setConversationIds(conversationIds);

        IConversationGroupV2Service groupService = services.getConversationGroupService();
        Result<CreateConversationGroupResponseV2> result = groupService.createConversationGroup(request);
        System.out.println(result.getMsg());
        Assert.assertEquals(200, result.getCode());
        CreateConversationGroupResponseV2 response = result.getResponse();
        Long groupId = response.getConversationGroup().getGroupId();
        System.out.println("Created conversation group with ID: " + groupId);

        // Clean up - delete the created group
        deleteConversationGroup(groupId, accountId1);
    }

    /**
     * Test getting conversation group details
     */
    @Test
    public void testGetConversationGroup() throws YunxinSdkException {
        if (services == null || conversationIds.isEmpty()) {
            System.out.println("Setup failed or no conversations available, skipping test.");
            return;
        }
        
        // First create a group to get
        Long groupId = createTestConversationGroup(accountId1, "Group for Get Test", conversationIds);
        if (groupId == null) {
            System.out.println("Failed to create test conversation group, skipping test.");
            return;
        }
        
        try {
            printSeparator("GETTING CONVERSATION GROUP DETAILS");
            
            GetConversationGroupRequestV2 request = new GetConversationGroupRequestV2();
            request.setGroupId(groupId);
            request.setAccountId(accountId1);
            
            IConversationGroupV2Service groupService = services.getConversationGroupService();
            Result<GetConversationGroupResponseV2> result = groupService.getConversationGroup(request);
            
            Assert.assertEquals(200, result.getCode());
            GetConversationGroupResponseV2 response = result.getResponse();
            System.out.println("Retrieved group: " + response.getName() + " (ID: " + response.getGroupId() + ")");
            
            // Add null check before accessing size to prevent NullPointerException
            List<String> groupConversationIds = response.getConversationIds();
            int conversationCount = (groupConversationIds != null) ? groupConversationIds.size() : 0;
            System.out.println("Group contains " + conversationCount + " conversations");
            
            // Verify correct group was retrieved
            Assert.assertEquals(groupId, response.getGroupId());
            Assert.assertEquals("Group for Get Test", response.getName());
        } finally {
            // Clean up
            deleteConversationGroup(groupId, accountId1);
        }
    }
    
    /**
     * Test updating a conversation group
     */
    @Test
    public void testUpdateConversationGroup() throws YunxinSdkException {
        if (services == null || conversationIds.isEmpty()) {
            System.out.println("Setup failed or no conversations available, skipping test.");
            return;
        }
        
        // First create a group to update
        Long groupId = createTestConversationGroup(accountId1, "Group for Update Test", conversationIds);
        if (groupId == null) {
            System.out.println("Failed to create test conversation group, skipping test.");
            return;
        }
        
        try {
            printSeparator("UPDATING CONVERSATION GROUP");
            
            String newName = "Updated Group Name " + UUID.randomUUID().toString().substring(0, 8);
            UpdateConversationGroupRequestV2 request = new UpdateConversationGroupRequestV2();
            request.setGroupId(groupId);
            request.setAccountId(accountId1);
            request.setName(newName);
            
            IConversationGroupV2Service groupService = services.getConversationGroupService();
            Result<UpdateConversationGroupResponseV2> result = groupService.updateConversationGroup(request);
            
            Assert.assertEquals(200, result.getCode());
            System.out.println("Updated group name to: " + newName);
            
            // Verify the update by getting the group again
            GetConversationGroupRequestV2 getRequest = new GetConversationGroupRequestV2();
            getRequest.setGroupId(groupId);
            getRequest.setAccountId(accountId1);
            
            Result<GetConversationGroupResponseV2> getResult = groupService.getConversationGroup(getRequest);
            Assert.assertEquals(200, getResult.getCode());
            Assert.assertEquals(newName, getResult.getResponse().getName());
        } finally {
            // Clean up
            deleteConversationGroup(groupId, accountId1);
        }
    }
    
    /**
     * Test listing all conversation groups for an account
     */
    @Test
    public void testListAllConversationGroups() throws YunxinSdkException {
        if (services == null) {
            System.out.println("Setup failed, skipping test.");
            return;
        }
        
        printSeparator("LISTING ALL CONVERSATION GROUPS");
        
        // Create a test group to ensure we have at least one to list
        Long groupId = createTestConversationGroup(accountId1, "Group for List Test", conversationIds);
        
        try {
            ListAllConversationGroupsRequestV2 request = new ListAllConversationGroupsRequestV2();
            request.setAccountId(accountId1);
            
            IConversationGroupV2Service groupService = services.getConversationGroupService();
            Result<ListAllConversationGroupsResponseV2> result = groupService.listAllConversationGroups(request);
            
            Assert.assertEquals(200, result.getCode());
            ListAllConversationGroupsResponseV2 response = result.getResponse();
            System.out.println("Account has " + response.getConversationGroups().size() + " conversation groups");
            
            // There should be at least one group
            Assert.assertTrue("No conversation groups found", response.getConversationGroups().size() > 0);
            
            for (ListAllConversationGroupsResponseV2.ConversationGroup group : response.getConversationGroups()) {
                System.out.println("Group: " + group.getName() + " (ID: " + group.getGroupId() + ")");
            }
        } finally {
            // Clean up if we created a group
            if (groupId != null) {
                deleteConversationGroup(groupId, accountId1);
            }
        }
    }

    
    /**
     * Test batch getting conversation groups
     */
    @Test
    public void testBatchGetConversationGroups() throws YunxinSdkException {
        if (services == null) {
            System.out.println("Setup failed, skipping test.");
            return;
        }
        
        printSeparator("CREATING MULTIPLE CONVERSATION GROUPS FOR BATCH GET TEST");
        
        // Create multiple conversation groups with unique conversations
        List<Long> groupIds = new ArrayList<>();
        
        // Create new unique conversations for the first group
        String uniqueConversation1 = createP2PConversation(accountId1, accountId2 + "_group1");
        List<String> firstGroupConversations = new ArrayList<>();
        if (uniqueConversation1 != null) {
            firstGroupConversations.add(uniqueConversation1);
        }
        
        // Create the first group with its unique conversation
        Long groupId1 = createTestConversationGroup(accountId1, "Test Group 1", firstGroupConversations);
        if (groupId1 != null) {
            groupIds.add(groupId1);
            System.out.println("Successfully created first group with ID: " + groupId1);
        }
        
        // Create new unique conversation for the second group
        String uniqueConversation2 = createP2PConversation(accountId1, accountId2 + "_group2");
        List<String> secondGroupConversations = new ArrayList<>();
        if (uniqueConversation2 != null) {
            secondGroupConversations.add(uniqueConversation2);
        }
        
        // Create the second group with its unique conversation
        Long groupId2 = createTestConversationGroup(accountId1, "Test Group 2", secondGroupConversations);
        if (groupId2 != null) {
            groupIds.add(groupId2);
            System.out.println("Successfully created second group with ID: " + groupId2);
        }
        
        if (groupIds.isEmpty()) {
            System.out.println("Failed to create any conversation groups, skipping test.");
            return;
        }
        
        try {
            // Batch get conversation groups
            printSeparator("BATCH GETTING CONVERSATION GROUPS");
            
            BatchGetConversationGroupsRequestV2 request = new BatchGetConversationGroupsRequestV2();
            request.setAccountId(accountId1);
            request.setGroupIds(groupIds);
            
            IConversationGroupV2Service groupService = services.getConversationGroupService();
            Result<BatchGetConversationGroupsResponseV2> result = groupService.batchGetConversationGroups(request);
            System.out.println(result.getMsg());
            Assert.assertEquals(200, result.getCode());
            BatchGetConversationGroupsResponseV2 response = result.getResponse();
            System.out.println("Successfully retrieved " + response.getSuccessList().size() + " groups");
            
            // Should match the number of groups we created
            Assert.assertEquals(groupIds.size(), response.getSuccessList().size());
            
            for (BatchGetConversationGroupsResponseV2.ConversationGroup group : response.getSuccessList()) {
                System.out.println("Group: " + group.getName() + " (ID: " + group.getGroupId() + ")");
                
                // Add null check for conversation IDs
                List<String> groupConversationIds = group.getConversationIds();
                int conversationCount = (groupConversationIds != null) ? groupConversationIds.size() : 0;
                System.out.println("  - Contains " + conversationCount + " conversations");
            }
        } finally {
            // Clean up
            for (Long groupId : groupIds) {
                deleteConversationGroup(groupId, accountId1);
            }
        }
    }
    
    /**
     * Helper method to create a test conversation group for use in tests
     */
    private Long createTestConversationGroup(String accountId, String groupName, List<String> conversationIds) throws YunxinSdkException {
        CreateConversationGroupRequestV2 request = new CreateConversationGroupRequestV2();
        request.setAccountId(accountId);
        request.setName(groupName);
        request.setConversationIds(conversationIds);
        
        IConversationGroupV2Service groupService = services.getConversationGroupService();
        Result<CreateConversationGroupResponseV2> result = groupService.createConversationGroup(request);
        
        if (result.getCode() == 200) {
            CreateConversationGroupResponseV2 response = result.getResponse();
            Long groupId = response.getConversationGroup().getGroupId();
            System.out.println("Created test conversation group with ID: " + groupId);
            return groupId;
        } else {
            System.out.println("Failed to create test conversation group: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Helper method to delete a conversation group
     */
    private void deleteConversationGroup(Long groupId, String accountId) throws YunxinSdkException {
        if (groupId == null) {
            return;
        }
        
        DeleteConversationGroupRequestV2 request = new DeleteConversationGroupRequestV2();
        request.setGroupId(groupId);
        request.setAccountId(accountId);
        
        IConversationGroupV2Service groupService = services.getConversationGroupService();
        Result<DeleteConversationGroupResponseV2> result = groupService.deleteConversationGroup(request);
        
        if (result.getCode() == 200) {
            System.out.println("Deleted conversation group with ID: " + groupId);
        } else {
            System.out.println("Failed to delete conversation group: " + result.getMsg());
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
     * Test deleting a conversation group
     */
    @Test
    public void testDeleteConversationGroup() throws YunxinSdkException {
        if (services == null || conversationIds.isEmpty()) {
            System.out.println("Setup failed or no conversations available, skipping test.");
            return;
        }

        // First create a group to delete
        Long groupId = createTestConversationGroup(accountId1, "Group for Delete Test", conversationIds);
        if (groupId == null) {
            System.out.println("Failed to create test conversation group, skipping test.");
            return;
        }

        printSeparator("DELETING CONVERSATION GROUP");

        DeleteConversationGroupRequestV2 request = new DeleteConversationGroupRequestV2();
        request.setGroupId(groupId);
        request.setAccountId(accountId1);

        IConversationGroupV2Service groupService = services.getConversationGroupService();
        Result<DeleteConversationGroupResponseV2> result = groupService.deleteConversationGroup(request);

        Assert.assertEquals(200, result.getCode());
        System.out.println("Deleted conversation group with ID: " + groupId);

        // Verify deletion by trying to get the group (should fail)
        GetConversationGroupRequestV2 getRequest = new GetConversationGroupRequestV2();
        getRequest.setGroupId(groupId);
        getRequest.setAccountId(accountId1);

        Result<GetConversationGroupResponseV2> getResult = groupService.getConversationGroup(getRequest);
        Assert.assertNotEquals("Group should be deleted", 200, getResult.getCode());
    }
} 