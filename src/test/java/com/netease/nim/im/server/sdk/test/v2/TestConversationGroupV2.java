package com.netease.nim.im.server.sdk.test.v2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.im.server.sdk.v2.YunxinV2ApiServices;
import com.netease.nim.im.server.sdk.v2.account.IAccountV2Service;
import com.netease.nim.im.server.sdk.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.IConversationV2Service;
import com.netease.nim.im.server.sdk.v2.conversation.request.BatchGetConversationGroupsRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.request.CreateConversationGroupRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.request.CreateConversationRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.request.DeleteConversationGroupRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.request.GetConversationGroupRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.request.UpdateConversationGroupRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.request.ListAllConversationGroupsRequestV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.BatchGetConversationGroupsResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.CreateConversationGroupResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.CreateConversationResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.DeleteConversationGroupResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.GetConversationGroupResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.UpdateConversationGroupResponseV2;
import com.netease.nim.im.server.sdk.v2.conversation.response.ListAllConversationGroupsResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Test class for Conversation Group V2 operations
 */
public class TestConversationGroupV2 {

    private static YunxinV2ApiServices services = null;
    // Test data used across multiple tests
    private static String accountId1;
    private static String accountId2;
    private static String accountId3;
    private static Long groupId1;
    private static Long groupId2;
    private static List<String> initialConversations = new ArrayList<>();
    private static List<String> additionalConversations = new ArrayList<>();

    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }

        services = new YunxinV2ApiServices(client);
        
        // Initialize test data
        accountId1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        accountId2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        accountId3 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        createAccount(accountId1);
        createAccount(accountId2);
        createAccount(accountId3);
    }

    
    /**
     * Test creating conversations between accounts
     */
    @Test
    public void testCreateConversations() throws YunxinSdkException {
        if (services == null) return;
        
        // Create P2P conversations
        String p2pConversationId1 = createP2PConversation(accountId1, accountId2);
        if (p2pConversationId1 != null) {
            initialConversations.add(p2pConversationId1);
        }
        
        // Create a second P2P conversation to add to the group later
        String p2pConversationId2 = createP2PConversation(accountId1, accountId3);
        if (p2pConversationId2 != null) {
            additionalConversations.add(p2pConversationId2);
        }
    }
    
    /**
     * Test creating conversation groups
     */
    @Test
    public void testCreateConversationGroups() throws YunxinSdkException {
        if (services == null) return;

        
        // Create conversation group
        groupId1 = createConversationGroup(accountId1, "Test Group 1", initialConversations);
        
        // Create a second conversation group
        groupId2 = createConversationGroup(accountId1, "Test Group 2", additionalConversations);
    }
    
    /**
     * Test batch getting conversation groups
     */
    @Test
    public void testBatchGetConversationGroups() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure we have conversation groups
        if (groupId1 == null || groupId2 == null) {
            testCreateConversationGroups();
        }
        
        // Get conversation groups in a batch
        batchGetConversationGroups(accountId1, Arrays.asList(groupId1, groupId2));
    }
    
    /**
     * Test getting a single conversation group
     */
    @Test
    public void testGetConversationGroup() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure we have conversation groups
        if (groupId1 == null) {
            testCreateConversationGroups();
        }
        
        // Get the conversation group information
        getConversationGroup(groupId1, accountId1);
    }
    
    /**
     * Test updating conversation group information
     */
    @Test
    public void testUpdateConversationGroup() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure we have conversation groups
        if (groupId1 == null) {
            testCreateConversationGroups();
        }
        
        // Update the conversation group
        updateConversationGroupInfo(
            groupId1, 
            accountId1, 
            "Updated Group Name", 
            "{\"updatedAt\":" + System.currentTimeMillis() + "}"
        );
        
        // Verify the updates
        getConversationGroup(groupId1, accountId1);
    }
    
    /**
     * Test adding conversations to a group
     */
    @Test
    public void testAddConversationsToGroup() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure we have conversation groups and additional conversations
        if (groupId1 == null || additionalConversations.isEmpty()) {
            testCreateConversationGroups();
        }
        
        // Add the conversations to the group
        if (!additionalConversations.isEmpty()) {
            addConversationsToGroup(groupId1, accountId1, additionalConversations);
        }
    }
    
    /**
     * Test removing conversations from a group
     */
    @Test
    public void testRemoveConversationsFromGroup() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure we have conversation groups and initial conversations
        if (groupId1 == null || initialConversations.isEmpty()) {
            testCreateConversationGroups();
        }
        
        // Remove the conversations from the group
        if (!initialConversations.isEmpty()) {
            removeConversationsFromGroup(groupId1, accountId1, initialConversations);
        }
    }
    
    /**
     * Test deleting conversation groups
     */
    @Test
    public void testDeleteConversationGroups() throws YunxinSdkException {
        if (services == null) return;
        
        // Ensure we have conversation groups
        if (groupId1 == null || groupId2 == null) {
            testCreateConversationGroups();
        }
        
        // Delete the conversation groups
        deleteConversationGroup(groupId1, accountId1);
        deleteConversationGroup(groupId2, accountId1);
        
        // Reset the group IDs after deletion
        groupId1 = null;
        groupId2 = null;
    }
    
    /**
     * Test creating and deleting a standalone conversation group
     */
    @Test
    public void testStandaloneConversationGroup() throws YunxinSdkException {
        if (services == null) return;
        
        // Generate a standalone account ID
        String standaloneAccountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

        createAccount(standaloneAccountId);
        
        // Create empty conversation group
        Long standaloneGroupId = createConversationGroup(standaloneAccountId, "Standalone Group", null);
        
        if (standaloneGroupId != null) {
            // Get the standalone conversation group information
            getConversationGroup(standaloneGroupId, standaloneAccountId);
            
            // Delete the standalone conversation group
            deleteConversationGroup(standaloneGroupId, standaloneAccountId);
        }
    }
    
    /**
     * Test listing all conversation groups for an account
     */
    @Test
    public void testListAllConversationGroups() throws YunxinSdkException {
        if (services == null) return;
        
        // Generate unique account ID for this test
        String accountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        String name = "testUser-" + UUID.randomUUID();
        
        // Create test account
        createAccount(accountId);
        
        // Create multiple conversation groups
        Long groupId1 = createConversationGroup(accountId, "Test Group 1", null);
        Long groupId2 = createConversationGroup(accountId, "Test Group 2", null);
        Long groupId3 = createConversationGroup(accountId, "Test Group 3", null);
        
        // List all conversation groups
        listAllConversationGroups(accountId);
        
        // Clean up
        if (groupId1 != null) {
            deleteConversationGroup(groupId1, accountId);
        }
        if (groupId2 != null) {
            deleteConversationGroup(groupId2, accountId);
        }
        if (groupId3 != null) {
            deleteConversationGroup(groupId3, accountId);
        }
    }
    
    /**
     * Helper method to create an account
     */
    private static void createAccount(String accountId) throws YunxinSdkException {
        CreateAccountRequestV2 request = new CreateAccountRequestV2();
        request.setAccountId(accountId);
        
        // Create and set user information
        CreateAccountRequestV2.UserInformation userInfo = new CreateAccountRequestV2.UserInformation();
        userInfo.setName(accountId);
        request.setUserInformation(userInfo);
        
        IAccountV2Service accountService = services.getAccountService();
        Result<CreateAccountResponseV2> result = accountService.createAccount(request);
        
        // Verify account creation
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());

    }
    
    /**
     * Create a point-to-point conversation
     */
    private static String createP2PConversation(String senderId, String receiverId) throws YunxinSdkException {
        String conversationId = CreateConversationRequestV2.createP2PConversationId(senderId, receiverId);
        
        CreateConversationRequestV2 request = new CreateConversationRequestV2();
        request.setConversationId(conversationId);
        
        IConversationV2Service conversationService = services.getConversationService();
        Result<CreateConversationResponseV2> result = conversationService.createConversation(request);
        
        System.out.println("createP2PConversation: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            CreateConversationResponseV2 response = result.getResponse();
            Assert.assertEquals(conversationId, response.getConversationId());
            Assert.assertEquals(senderId, response.getSenderId());
            Assert.assertEquals(receiverId, response.getReceiverId());
            Assert.assertEquals(Integer.valueOf(1), response.getType());
            
            System.out.println("Created P2P conversation: " + response.getConversationId());
            System.out.println("Sender: " + response.getSenderId());
            System.out.println("Receiver: " + response.getReceiverId());
            System.out.println("Type: " + response.getType());
            
            return conversationId;
        } else {
            System.out.println("Could not create P2P conversation: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Create a conversation group
     * 
     * @return groupId of the created group, or null if creation failed
     */
    private static Long createConversationGroup(String accountId, String groupName, List<String> conversationIds) throws YunxinSdkException {
        // Create the request
        CreateConversationGroupRequestV2 request = new CreateConversationGroupRequestV2();
        request.setAccountId(accountId);
        request.setName(groupName);
        
        // Set server extension (optional)
        String serverExtension = "{\"createdAt\":" + System.currentTimeMillis() + "}";
        request.setServerExtension(serverExtension);
        
        // Set conversation IDs (optional)
        if (conversationIds != null && !conversationIds.isEmpty()) {
            request.setConversationIds(conversationIds);
        }
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<CreateConversationGroupResponseV2> result = conversationService.createConversationGroup(request);
        
        System.out.println("createConversationGroup: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            CreateConversationGroupResponseV2 response = result.getResponse();
            
            // Verify the conversation group details
            CreateConversationGroupResponseV2.ConversationGroup group = response.getConversationGroup();
            Assert.assertNotNull(group);
            Assert.assertEquals(groupName, group.getName());
            Assert.assertEquals(serverExtension, group.getServerExtension());
            Assert.assertNotNull(group.getGroupId());
            Assert.assertNotNull(group.getCreateTime());
            Assert.assertNotNull(group.getUpdateTime());
            
            System.out.println("Created conversation group:");
            System.out.println("  Group ID: " + group.getGroupId());
            System.out.println("  Name: " + group.getName());
            System.out.println("  Server extension: " + group.getServerExtension());
            System.out.println("  Created at: " + group.getCreateTime());
            
            // Check successfully added conversations
            if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
                System.out.println("Successfully added conversations:");
                for (String id : response.getSuccessList()) {
                    System.out.println("  - " + id);
                }
            }
            
            // Check failed conversations
            if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                System.out.println("Failed to add conversations:");
                for (CreateConversationGroupResponseV2.FailedItem failedItem : response.getFailedList()) {
                    System.out.println("  - " + failedItem.getConversationId() + 
                                      ", Error: " + failedItem.getErrorCode() + 
                                      " - " + failedItem.getErrorMsg());
                }
            }
            
            return group.getGroupId();
        } else {
            System.out.println("Failed to create conversation group: " + result.getMsg());
            Assert.fail("Failed to create conversation group: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Get conversation group information
     */
    private static void getConversationGroup(Long groupId, String accountId) throws YunxinSdkException {
        // Create the request
        GetConversationGroupRequestV2 request = new GetConversationGroupRequestV2(groupId, accountId);
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<GetConversationGroupResponseV2> result = conversationService.getConversationGroup(request);
        
        System.out.println("getConversationGroup: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            GetConversationGroupResponseV2 response = result.getResponse();
            
            // Verify the conversation group details
            Assert.assertNotNull(response);
            Assert.assertEquals(groupId, response.getGroupId());
            Assert.assertNotNull(response.getName());
            Assert.assertNotNull(response.getServerExtension());
            Assert.assertNotNull(response.getCreateTime());
            Assert.assertNotNull(response.getUpdateTime());
            
            System.out.println("Conversation group details:");
            System.out.println("  Group ID: " + response.getGroupId());
            System.out.println("  Name: " + response.getName());
            System.out.println("  Server extension: " + response.getServerExtension());
            System.out.println("  Created at: " + response.getCreateTime());
            System.out.println("  Updated at: " + response.getUpdateTime());
        } else {
            System.out.println("Failed to get conversation group information: " + result.getMsg());
            Assert.fail("Failed to get conversation group information: " + result.getMsg());
        }
    }
    
    /**
     * Batch get conversation groups information
     */
    private static void batchGetConversationGroups(String accountId, List<Long> groupIds) throws YunxinSdkException {
        // Create the request
        BatchGetConversationGroupsRequestV2 request = new BatchGetConversationGroupsRequestV2(accountId, groupIds);
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<BatchGetConversationGroupsResponseV2> result = conversationService.batchGetConversationGroups(request);
        
        System.out.println("batchGetConversationGroups: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            BatchGetConversationGroupsResponseV2 response = result.getResponse();
            
            // Check successfully retrieved conversation groups
            if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
                System.out.println("Successfully retrieved conversation groups:");
                for (BatchGetConversationGroupsResponseV2.ConversationGroup group : response.getSuccessList()) {
                    System.out.println("  Group ID: " + group.getGroupId());
                    System.out.println("  Name: " + group.getName());
                    System.out.println("  Server extension: " + group.getServerExtension());
                    System.out.println("  Created at: " + group.getCreateTime());
                    System.out.println("  Updated at: " + group.getUpdateTime());
                    System.out.println();
                }
                Assert.assertTrue("Success list should include at least one group", 
                                 response.getSuccessList().size() > 0);
                Assert.assertEquals("All requested groups should be successfully retrieved", 
                                   groupIds.size(), response.getSuccessList().size());
            }
            
            // Check failed group retrievals
            if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                System.out.println("Failed to retrieve conversation groups:");
                for (BatchGetConversationGroupsResponseV2.FailedItem failedItem : response.getFailedList()) {
                    System.out.println("  - Group ID: " + failedItem.getGroupId() + 
                                      ", Error: " + failedItem.getErrorCode() + 
                                      " - " + failedItem.getErrorMsg());
                }
            }
        } else {
            System.out.println("Failed to batch get conversation groups: " + result.getMsg());
            Assert.fail("Failed to batch get conversation groups: " + result.getMsg());
        }
    }
    
    /**
     * Update a conversation group's name and server extension
     */
    private static void updateConversationGroupInfo(Long groupId, String accountId, String newName, String newServerExtension) throws YunxinSdkException {
        // Create the request
        UpdateConversationGroupRequestV2 request = new UpdateConversationGroupRequestV2(groupId, accountId);
        request.setName(newName);
        request.setServerExtension(newServerExtension);
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<UpdateConversationGroupResponseV2> result = conversationService.updateConversationGroup(request);
        
        System.out.println("updateConversationGroupInfo: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            UpdateConversationGroupResponseV2 response = result.getResponse();
            
            // Verify the updated conversation group details
            UpdateConversationGroupResponseV2.ConversationGroup group = response.getConversationGroup();
            Assert.assertNotNull(group);
            Assert.assertEquals(newName, group.getName());
            Assert.assertEquals(newServerExtension, group.getServerExtension());
            Assert.assertEquals(groupId, group.getGroupId());
            Assert.assertNotNull(group.getCreateTime());
            Assert.assertNotNull(group.getUpdateTime());
            
            System.out.println("Updated conversation group info:");
            System.out.println("  Group ID: " + group.getGroupId());
            System.out.println("  New name: " + group.getName());
            System.out.println("  New server extension: " + group.getServerExtension());
            System.out.println("  Updated at: " + group.getUpdateTime());
        } else {
            System.out.println("Failed to update conversation group info: " + result.getMsg());
            Assert.fail("Failed to update conversation group info: " + result.getMsg());
        }
    }
    
    /**
     * Add conversations to a conversation group
     */
    private static void addConversationsToGroup(Long groupId, String accountId, List<String> conversationIds) throws YunxinSdkException {
        // Create the request
        UpdateConversationGroupRequestV2 request = UpdateConversationGroupRequestV2.createAddConversationsRequest(
                groupId, accountId, conversationIds);
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<UpdateConversationGroupResponseV2> result = conversationService.updateConversationGroup(request);
        
        System.out.println("addConversationsToGroup: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            UpdateConversationGroupResponseV2 response = result.getResponse();
            
            // Check successfully added conversations
            if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
                System.out.println("Successfully added conversations:");
                for (String id : response.getSuccessList()) {
                    System.out.println("  - " + id);
                }
                Assert.assertTrue("Success list should include at least one conversation", 
                                 response.getSuccessList().size() > 0);
            }
            
            // Check failed conversations
            if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                System.out.println("Failed to add conversations:");
                for (UpdateConversationGroupResponseV2.FailedItem failedItem : response.getFailedList()) {
                    System.out.println("  - " + failedItem.getConversationId() + 
                                      ", Error: " + failedItem.getErrorCode() + 
                                      " - " + failedItem.getErrorMsg());
                }
            }
        } else {
            System.out.println("Failed to add conversations to group: " + result.getMsg());
            Assert.fail("Failed to add conversations to group: " + result.getMsg());
        }
    }
    
    /**
     * Remove conversations from a conversation group
     */
    private static void removeConversationsFromGroup(Long groupId, String accountId, List<String> conversationIds) throws YunxinSdkException {
        // Create the request
        UpdateConversationGroupRequestV2 request = UpdateConversationGroupRequestV2.createRemoveConversationsRequest(
                groupId, accountId, conversationIds);
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<UpdateConversationGroupResponseV2> result = conversationService.updateConversationGroup(request);
        
        System.out.println("removeConversationsFromGroup: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            UpdateConversationGroupResponseV2 response = result.getResponse();
            
            // Check successfully removed conversations
            if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
                System.out.println("Successfully removed conversations:");
                for (String id : response.getSuccessList()) {
                    System.out.println("  - " + id);
                }
                Assert.assertTrue("Success list should include at least one conversation", 
                                 response.getSuccessList().size() > 0);
            }
            
            // Check failed conversations
            if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                System.out.println("Failed to remove conversations:");
                for (UpdateConversationGroupResponseV2.FailedItem failedItem : response.getFailedList()) {
                    System.out.println("  - " + failedItem.getConversationId() + 
                                      ", Error: " + failedItem.getErrorCode() + 
                                      " - " + failedItem.getErrorMsg());
                }
            }
        } else {
            System.out.println("Failed to remove conversations from group: " + result.getMsg());
            Assert.fail("Failed to remove conversations from group: " + result.getMsg());
        }
    }
    
    /**
     * Delete a conversation group
     */
    private static void deleteConversationGroup(Long groupId, String accountId) throws YunxinSdkException {
        // Create the request
        DeleteConversationGroupRequestV2 request = new DeleteConversationGroupRequestV2(groupId, accountId);
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<DeleteConversationGroupResponseV2> result = conversationService.deleteConversationGroup(request);
        
        System.out.println("deleteConversationGroup: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify successful deletion
        Assert.assertEquals("Deletion should return success code 200", 200, result.getCode());
        Assert.assertEquals("Deletion should return 'success' message", "success", result.getMsg());
        
        System.out.println("Successfully deleted conversation group with ID: " + groupId);
    }

    /**
     * List all conversation groups for an account
     */
    private static void listAllConversationGroups(String accountId) throws YunxinSdkException {
        // Create the request
        ListAllConversationGroupsRequestV2 request = new ListAllConversationGroupsRequestV2(accountId);
        
        // Call the API
        IConversationV2Service conversationService = services.getConversationService();
        Result<ListAllConversationGroupsResponseV2> result = conversationService.listAllConversationGroups(request);
        
        System.out.println("listAllConversationGroups: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            ListAllConversationGroupsResponseV2 response = result.getResponse();
            
            // Check conversation groups
            if (response.getConversationGroups() != null && !response.getConversationGroups().isEmpty()) {
                System.out.println("Found conversation groups: " + response.getConversationGroups().size());
                System.out.println("Conversation groups:");
                for (ListAllConversationGroupsResponseV2.ConversationGroup group : response.getConversationGroups()) {
                    System.out.println("  Group ID: " + group.getGroupId());
                    System.out.println("  Name: " + group.getName());
                    System.out.println("  Server extension: " + group.getServerExtension());
                    System.out.println("  Created at: " + group.getCreateTime());
                    System.out.println("  Updated at: " + group.getUpdateTime());
                    System.out.println();
                }
                Assert.assertTrue("Account should have conversation groups", 
                                 response.getConversationGroups().size() > 0);
            } else {
                System.out.println("No conversation groups found for account: " + accountId);
            }
        } else {
            System.out.println("Failed to list conversation groups: " + result.getMsg());
            Assert.fail("Failed to list conversation groups: " + result.getMsg());
        }
    }
} 