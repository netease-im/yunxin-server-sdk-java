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
import com.netease.nim.server.sdk.im.v2.conversation.IConversationV2Service;
import com.netease.nim.server.sdk.im.v2.conversation.request.BatchDeleteConversationsRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.request.BatchGetConversationsRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.request.CreateConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.request.DeleteConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.request.GetConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.request.ListConversationsRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.request.StickTopConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.request.UpdateConversationRequestV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.BatchDeleteConversationsResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.BatchGetConversationsResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.CreateConversationResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.DeleteConversationResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.GetConversationResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.ListConversationsResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.StickTopConversationResponseV2;
import com.netease.nim.server.sdk.im.v2.conversation.response.UpdateConversationResponseV2;
import com.netease.nim.server.sdk.im.v2.team.ITeamV2Service;
import com.netease.nim.server.sdk.im.v2.team.request.CreateTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.response.CreateTeamResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Test class for ConversationV2Service
 */
public class TestConversationV2 {

    private static YunxinV2ApiServices services = null;
    private static String accountId1;
    private static String accountId2;
    private static String accountId3;
    private static List<String> teamIds;
    
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
        
                // Create teams
        printSeparator("CREATING TEAMS");
                teamIds = new ArrayList<>();
        
        // Create first team
        String teamId1 = createAdvancedTeam("Test Team 1");
        if (teamId1 != null) {
            teamIds.add(teamId1);
        }
        
        // Create second team
        String teamId2 = createAdvancedTeam("Test Team 2");
        if (teamId2 != null) {
            teamIds.add(teamId2);
        }
        
        if (teamIds.isEmpty()) {
                    System.out.println("Failed to create any teams, some conversation tests may be skipped.");
                }
            } catch (Exception e) {
                System.out.println("Exception during setup: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Test creating and managing team conversations
     */
    @Test
    public void testTeamConversationOperations() throws YunxinSdkException {
        if (services == null || teamIds == null || teamIds.isEmpty()) return;
        
        printSeparator("CREATING CONVERSATIONS");
        List<String> conversationIds = new ArrayList<>();
        
        // Create conversations for each team
        for (String teamId : teamIds) {
            String conversationId = createAdvancedTeamConversation(teamId);
            if (conversationId != null) {
                conversationIds.add(conversationId);
            }
        }
        
        if (conversationIds.isEmpty()) {
            System.out.println("Failed to create any team conversations, skipping test.");
            return;
        }
        
        // Get conversation details individually
        printSeparator("GETTING CONVERSATION DETAILS INDIVIDUALLY");
        for (String conversationId : conversationIds) {
            getConversation(conversationId);
        }
        
        // Batch get conversation details
        printSeparator("BATCH GETTING CONVERSATION DETAILS");
        batchGetConversations(conversationIds);
        
        // Update conversations
        printSeparator("UPDATING CONVERSATIONS");
        for (String conversationId : conversationIds) {
            updateConversation(conversationId);
        }
        
        // Delete conversations one by one
        printSeparator("DELETING CONVERSATIONS INDIVIDUALLY");
        for (String conversationId : conversationIds) {
            deleteConversation(conversationId, true);
        }
    }
    
    /**
     * Test creating and managing P2P conversations
     */
    @Test
    public void testP2PConversationOperations() throws YunxinSdkException {
        if (services == null) return;
        
        printSeparator("CREATING P2P CONVERSATION");
        String p2pConversationId = createP2PConversation(accountId1, accountId2);
        if (p2pConversationId == null) {
            System.out.println("Failed to create P2P conversation, skipping test.");
            return;
        }
        
        // Get conversation details
        getConversation(p2pConversationId);
        
        // Update the conversation
        updateConversation(p2pConversationId);
        
        // Delete the conversation
        deleteConversation(p2pConversationId, true);
    }
    
    /**
     * Test listing all conversations for the test account
     */
    @Test
    public void testListConversations() throws YunxinSdkException {
        if (services == null) return;
        
        // Create a few conversations to ensure we have something to list
        List<String> tempConversationIds = new ArrayList<>();
        
        // Create P2P conversations
        String p2pConversation1 = createP2PConversation(accountId1, accountId2);
        if (p2pConversation1 != null) {
            tempConversationIds.add(p2pConversation1);
        }
        
        String p2pConversation2 = createP2PConversation(accountId1, accountId3);
        if (p2pConversation2 != null) {
            tempConversationIds.add(p2pConversation2);
        }
        
        // Create team conversations if teams exist
        if (teamIds != null && !teamIds.isEmpty()) {
            for (String teamId : teamIds) {
                String teamConversation = createAdvancedTeamConversation(teamId);
                if (teamConversation != null) {
                    tempConversationIds.add(teamConversation);
                }
            }
        }
        
        if (tempConversationIds.isEmpty()) {
            System.out.println("Failed to create any conversations for listing test, skipping.");
            return;
        }
        
        try {
        // List all conversations for the test account
        printSeparator("LISTING ALL CONVERSATIONS FOR ACCOUNT");
        listConversations(accountId1);
        } finally {
            // Clean up the temporary conversations
            for (String conversationId : tempConversationIds) {
                try {
                    deleteConversation(conversationId, true);
                } catch (Exception e) {
                    System.out.println("Failed to delete temporary conversation " + conversationId + ": " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Test sticking top (pinning) a conversation
     */
    @Test
    public void testStickTopConversation() throws YunxinSdkException {
        if (services == null) return;
        
        // Create a P2P conversation for testing
        String conversationId = createP2PConversation(accountId1, accountId2);
        if (conversationId == null) {
            System.out.println("Failed to create conversation, skipping test.");
            return;
        }
        
        try {
            IConversationV2Service conversationService = services.getConversationService();
            
            // First pin the conversation
            printSeparator("PINNING CONVERSATION");
            try {
                // Create a request to pin the conversation
                StickTopConversationRequestV2 pinRequest = StickTopConversationRequestV2.createPinRequest(conversationId);
                
                Result<StickTopConversationResponseV2> pinResult = conversationService.stickTopConversation(pinRequest);
                
                System.out.println("pinConversation: " + pinResult.getMsg());
                System.out.println("Response: " + JSON.toJSONString(pinResult));
                
                if (pinResult.getCode() == 200) {
                    System.out.println("Successfully pinned conversation: " + conversationId);
                    
                    // Verify the conversation is pinned
                    GetConversationRequestV2 getRequest = new GetConversationRequestV2();
                    getRequest.setConversationId(conversationId);
                    
                    Result<GetConversationResponseV2> getResult = conversationService.getConversation(getRequest);
                    
                    if (getResult.getCode() == 200 && getResult.getResponse() != null) {
                        GetConversationResponseV2 getResponse = getResult.getResponse();
                        System.out.println("Verified conversation stick top status: " + getResponse.getStickTop());
                        // StickTop should be true if pinning was successful
                        Assert.assertEquals(true, getResponse.getStickTop());
                    }
                } else {
                    System.out.println("Failed to pin conversation: " + pinResult.getMsg());
                }
                
                // Wait a moment before unpinning
                Thread.sleep(1000);
                
                // Then unpin the conversation
                printSeparator("UNPINNING CONVERSATION");
                
                // Create a request to unpin the conversation
                StickTopConversationRequestV2 unpinRequest = StickTopConversationRequestV2.createUnpinRequest(conversationId);
                
                Result<StickTopConversationResponseV2> unpinResult = conversationService.stickTopConversation(unpinRequest);
                
                System.out.println("unpinConversation: " + unpinResult.getMsg());
                System.out.println("Response: " + JSON.toJSONString(unpinResult));
                
                if (unpinResult.getCode() == 200) {
                    System.out.println("Successfully unpinned conversation: " + conversationId);
                    
                    // Verify the conversation is unpinned
                    GetConversationRequestV2 getRequest = new GetConversationRequestV2();
                    getRequest.setConversationId(conversationId);
                    
                    Result<GetConversationResponseV2> getResult = conversationService.getConversation(getRequest);
                    
                    if (getResult.getCode() == 200 && getResult.getResponse() != null) {
                        GetConversationResponseV2 getResponse = getResult.getResponse();
                        System.out.println("Verified conversation stick top status: " + getResponse.getStickTop());
                        // StickTop should be false if unpinning was successful
                        Assert.assertEquals(false, getResponse.getStickTop());
                    }
                } else {
                    System.out.println("Failed to unpin conversation: " + unpinResult.getMsg());
                }
            } catch (Exception e) {
                System.out.println("Exception during stick top test: " + e.getMessage());
                e.printStackTrace();
            }
        } finally {
            // Clean up - delete the conversation
            deleteConversation(conversationId, true);
        }
    }
    
    /**
     * Test batch deleting multiple conversations
     */
    @Test
    public void testBatchDeleteConversations() throws YunxinSdkException {
        if (services == null) return;
        
        // Create conversations for batch deletion
        printSeparator("CREATING CONVERSATIONS FOR BATCH DELETION");
        List<String> batchConversationIds = new ArrayList<>();
        
        // Create conversations for each team if available
        if (teamIds != null && !teamIds.isEmpty()) {
        for (String teamId : teamIds) {
            String conversationId = createAdvancedTeamConversation(teamId);
            if (conversationId != null) {
                batchConversationIds.add(conversationId);
                }
            }
        }
        
        // Create P2P conversations
        String p2pConversationId1 = createP2PConversation(accountId1, accountId2);
        if (p2pConversationId1 != null) {
            batchConversationIds.add(p2pConversationId1);
        }
        
        String p2pConversationId2 = createP2PConversation(accountId1, accountId3);
        if (p2pConversationId2 != null) {
            batchConversationIds.add(p2pConversationId2);
        }
        
        if (batchConversationIds.isEmpty()) {
            System.out.println("Failed to create any conversations for batch deletion, skipping test.");
            return;
        }
        
        // Batch get the conversations to verify they exist
        printSeparator("BATCH GETTING CONVERSATIONS");
        batchGetConversations(batchConversationIds);
        
        // Batch delete conversations
        printSeparator("BATCH DELETING CONVERSATIONS");
        batchDeleteConversations(batchConversationIds, true);
    }
    
    /**
     * Helper method to print a separator for better output readability
     */
    private static void printSeparator(String sectionName) {
        System.out.println("\n=============================================");
        System.out.println("==== " + sectionName + " ====");
        System.out.println("=============================================\n");
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
        
        // Verify account creation
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());
        
        System.out.println("Created account: " + accountId + ", name: " + name);
    }
    
    /**
     * Create an advanced team
     * 
     * @param teamName the name for the team
     * @return team ID if created successfully, null otherwise
     */
    private static String createAdvancedTeam(String teamName) throws YunxinSdkException {
        List<String> inviteAccountIds = Arrays.asList(accountId2, accountId3);
        String inviteMsg = "Join my test team";
        
        // Use helper method from CreateTeamRequestV2
        CreateTeamRequestV2 request = CreateTeamRequestV2.createAdvancedTeam(
            accountId1, teamName, inviteAccountIds, inviteMsg);
        
        ITeamV2Service teamService = services.getTeamService();
        Result<CreateTeamResponseV2> result = teamService.createTeam(request);
        
        System.out.println("createAdvancedTeam: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200 && result.getResponse() != null) {
            String teamId = String.valueOf(result.getResponse().getTeamInfo().getTeamId());
            System.out.println("Created team: " + teamId + ", name: " + teamName);
            return teamId;
        } else {
            System.out.println("Failed to create team: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Test creating an advanced team conversation
     * 
     * @param teamId the team ID to create conversation for
     * @return the conversation ID if creation was successful, null otherwise
     */
    private static String createAdvancedTeamConversation(String teamId) throws YunxinSdkException {
        if (teamId == null) return null;
        
        String conversationId = CreateConversationRequestV2.createAdvancedTeamConversationId(accountId1, teamId);
        
        CreateConversationRequestV2 request = new CreateConversationRequestV2();
        request.setConversationId(conversationId);
        
        IConversationV2Service conversationService = services.getConversationService();
        Result<CreateConversationResponseV2> result = conversationService.createConversation(request);
        
        System.out.println("createAdvancedTeamConversation: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            CreateConversationResponseV2 response = result.getResponse();
            Assert.assertEquals(conversationId, response.getConversationId());
            Assert.assertEquals(accountId1, response.getSenderId());
            Assert.assertEquals(teamId, response.getReceiverId());
            Assert.assertEquals(Integer.valueOf(2), response.getType());
            
            System.out.println("Created Advanced Team conversation: " + response.getConversationId());
            System.out.println("Sender: " + response.getSenderId());
            System.out.println("Team ID: " + response.getReceiverId());
            System.out.println("Type: " + response.getType());
            if (response.getCreateTime() != null) {
                System.out.println("Created at: " + response.getCreateTime());
            }
            
            return conversationId;
        } else {
            System.out.println("Could not create Advanced Team conversation: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Create a point-to-point conversation
     * 
     * @param senderId sender account ID
     * @param receiverId receiver account ID
     * @return the conversation ID if creation was successful, null otherwise
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
            if (response.getCreateTime() != null) {
                System.out.println("Created at: " + response.getCreateTime());
            }
            
            return conversationId;
        } else {
            System.out.println("Could not create P2P conversation: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Test retrieving conversation details
     * 
     * @param conversationId the conversation ID to retrieve
     */
    private static void getConversation(String conversationId) throws YunxinSdkException {
        // Create the get request
        GetConversationRequestV2 request = new GetConversationRequestV2();
        request.setConversationId(conversationId);
        
        IConversationV2Service conversationService = services.getConversationService();
        Result<GetConversationResponseV2> result = conversationService.getConversation(request);
        
        System.out.println("getConversation: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            GetConversationResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(conversationId, response.getConversationId());
            
            System.out.println("Got conversation: " + response.getConversationId());
            System.out.println("Sender: " + response.getSenderId());
            System.out.println("Receiver: " + response.getReceiverId());
            System.out.println("Type: " + response.getType());
            System.out.println("Unread count: " + response.getUnreadCount());
            System.out.println("Is stick top: " + response.getStickTop());
            
            if (response.getGroupIds() != null) {
                System.out.println("Group IDs: " + response.getGroupIds());
            }
            
            if (response.getServerExtension() != null) {
                System.out.println("Server extension: " + response.getServerExtension());
            }
            
            if (response.getCreateTime() != null) {
                System.out.println("Created at: " + response.getCreateTime());
            }
            
            if (response.getUpdateTime() != null) {
                System.out.println("Updated at: " + response.getUpdateTime());
            }
            
            if (response.getLastReadTime() != null) {
                System.out.println("Last read at: " + response.getLastReadTime());
            }
        } else {
            System.out.println("Failed to get conversation: " + result.getMsg());
        }
    }
    
    /**
     * Test batch retrieving multiple conversation details
     * 
     * @param conversationIds the list of conversation IDs to retrieve
     */
    private static void batchGetConversations(List<String> conversationIds) throws YunxinSdkException {
        if (conversationIds == null || conversationIds.isEmpty()) {
            System.out.println("No conversation IDs provided for batch retrieval");
            return;
        }
        
        // Print conversation IDs for debugging
        System.out.println("\n----- Batch Get Conversation IDs List -----");
        for (String id : conversationIds) {
            System.out.println("  " + id);
        }
        System.out.println("-------------------------------------------\n");
        
        // Create the batch get request
        BatchGetConversationsRequestV2 request = new BatchGetConversationsRequestV2();
        request.setConversationIds(conversationIds);
        
        IConversationV2Service conversationService = services.getConversationService();
        
        try {
            Result<BatchGetConversationsResponseV2> result = conversationService.batchGetConversations(request);
            
            System.out.println("batchGetConversations: " + result.getMsg());
            System.out.println("Response: " + JSON.toJSONString(result));
            
            if (result.getCode() == 200) {
                BatchGetConversationsResponseV2 response = result.getResponse();
                
                // Check successful retrievals
                if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
                    System.out.println("Successfully retrieved conversations: " + response.getSuccessList().size());
                    for (BatchGetConversationsResponseV2.ConversationInfo info : response.getSuccessList()) {
                        System.out.println("\n  Conversation: " + info.getConversationId());
                        System.out.println("  Sender: " + info.getSenderId());
                        System.out.println("  Receiver: " + info.getReceiverId());
                        System.out.println("  Type: " + info.getType());
                        System.out.println("  Unread count: " + info.getUnreadCount());
                        System.out.println("  Is stick top: " + info.getStickTop());
                        
                        if (info.getGroupIds() != null) {
                            System.out.println("  Group IDs: " + info.getGroupIds());
                        }
                        
                        if (info.getServerExtension() != null) {
                            System.out.println("  Server extension: " + info.getServerExtension());
                        }
                    }
                }
                
                // Check failed retrievals
                if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                    System.out.println("\nFailed to retrieve conversations: " + response.getFailedList().size());
                    for (BatchGetConversationsResponseV2.FailedItem failedItem : response.getFailedList()) {
                        System.out.println("  - " + failedItem.getConversationId() + 
                                          ", Error: " + failedItem.getErrorCode() + 
                                          " - " + failedItem.getErrorMsg());
                    }
                }
                
                System.out.println("\nBatch retrieved conversations: " + conversationIds.size());
            } else {
                System.out.println("Failed to batch retrieve conversations: " + result.getMsg());
                
                // Fall back to retrieving one by one
                System.out.println("\nFalling back to individual retrieval...");
                for (String conversationId : conversationIds) {
                    try {
                        getConversation(conversationId);
                    } catch (Exception ex) {
                        System.out.println("Failed to get conversation " + conversationId + ": " + ex.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception during batch retrieval: " + e.getMessage());
            e.printStackTrace();
            
            // Fall back to retrieving one by one
            System.out.println("\nFalling back to individual retrieval...");
            for (String conversationId : conversationIds) {
                try {
                    getConversation(conversationId);
                } catch (Exception ex) {
                    System.out.println("Failed to get conversation " + conversationId + ": " + ex.getMessage());
                }
            }
        }
    }
    
    /**
     * Test updating a conversation
     * 
     * @param conversationId the conversation ID to update
     */
    private static void updateConversation(String conversationId) throws YunxinSdkException {
        String serverExtension = "{\"customKey\":\"customValue-" + UUID.randomUUID() + "\"}";
        
        // Create the update request
        UpdateConversationRequestV2 request = new UpdateConversationRequestV2();
        request.setConversationId(conversationId);
        request.setServerExtension(serverExtension);
        
        IConversationV2Service conversationService = services.getConversationService();
        Result<UpdateConversationResponseV2> result = conversationService.updateConversation(request);
        
        System.out.println("updateConversation: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            UpdateConversationResponseV2 response = result.getResponse();
            Assert.assertNotNull(response);
            Assert.assertEquals(conversationId, response.getConversationId());
            Assert.assertEquals(serverExtension, response.getServerExtension());
            
            System.out.println("Updated conversation: " + response.getConversationId());
            System.out.println("Server extension: " + response.getServerExtension());
        } else {
            System.out.println("Failed to update conversation: " + result.getMsg());
        }
    }
    
    /**
     * Test deleting a conversation
     * 
     * @param conversationId the conversation ID to delete
     * @param clearMessage whether to delete conversation history messages
     */
    private static void deleteConversation(String conversationId, boolean clearMessage) throws YunxinSdkException {
        // Create the delete request
        DeleteConversationRequestV2 request = new DeleteConversationRequestV2();
        request.setConversationId(conversationId);
        request.setClearMessage(clearMessage);
        
        IConversationV2Service conversationService = services.getConversationService();
        Result<DeleteConversationResponseV2> result = conversationService.deleteConversation(request);
        
        System.out.println("deleteConversation: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            System.out.println("Deleted conversation: " + conversationId);
            System.out.println("Clear message history: " + clearMessage);
        } else {
            System.out.println("Failed to delete conversation: " + result.getMsg());
        }
    }
    
    /**
     * Test batch deleting multiple conversations
     * 
     * @param conversationIds list of conversation IDs to delete
     * @param clearMessage whether to delete conversation history messages
     */
    private static void batchDeleteConversations(List<String> conversationIds, boolean clearMessage) throws YunxinSdkException {
        // Print conversation IDs for debugging
        System.out.println("\n----- Batch Delete Conversation IDs List -----");
        for (String id : conversationIds) {
            System.out.println("  " + id);
        }
        System.out.println("-------------------------------------------\n");
        
        // Create the batch delete request
        BatchDeleteConversationsRequestV2 request = new BatchDeleteConversationsRequestV2();
        request.setConversationIds(conversationIds);
        request.setClearMessage(clearMessage);
        
        IConversationV2Service conversationService = services.getConversationService();
        
        try {
            Result<BatchDeleteConversationsResponseV2> result = conversationService.batchDeleteConversations(request);
            
            System.out.println("batchDeleteConversations: " + result.getMsg());
            System.out.println("Response: " + JSON.toJSONString(result));
            
            if (result.getCode() == 200) {
                BatchDeleteConversationsResponseV2 response = result.getResponse();
                
                // Check successful deletions
                if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
                    System.out.println("Successfully deleted conversations: " + response.getSuccessList().size());
                    for (String id : response.getSuccessList()) {
                        System.out.println("  - " + id);
                    }
                }
                
                // Check failed deletions
                if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                    System.out.println("Failed to delete conversations: " + response.getFailedList().size());
                    for (BatchDeleteConversationsResponseV2.FailedItem failedItem : response.getFailedList()) {
                        System.out.println("  - " + failedItem.getConversationId() + 
                                          ", Error: " + failedItem.getErrorCode() + 
                                          " - " + failedItem.getErrorMsg());
                    }
                }
                
                System.out.println("Batch deleted conversations: " + conversationIds.size());
                System.out.println("Clear message history: " + clearMessage);
            } else {
                System.out.println("Failed to batch delete conversations: " + result.getMsg());
            }
        } catch (Exception e) {
            System.out.println("Exception during batch deletion: " + e.getMessage());
            e.printStackTrace();
            
            // Fall back to deleting one by one
            System.out.println("\nFalling back to individual deletion...");
            for (String conversationId : conversationIds) {
                try {
                    deleteConversation(conversationId, clearMessage);
                } catch (Exception ex) {
                    System.out.println("Failed to delete conversation " + conversationId + ": " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Test listing conversations for an account with pagination
     *
     * @param accountId the account ID to list conversations for
     */
    private static void listConversations(String accountId) throws YunxinSdkException {
        // Create the list request with default limit (100)
        ListConversationsRequestV2 request = new ListConversationsRequestV2(accountId);
        
        IConversationV2Service conversationService = services.getConversationService();
        
        boolean hasMore = true;
        String nextToken = null;
        int page = 1;
        
        // Iterate through pages until there are no more results
        while (hasMore) {
            if (nextToken != null) {
                request.setPageToken(nextToken);
            }
            
            System.out.println("\n----- Fetching Conversations Page " + page + " -----");
            try {
                Result<ListConversationsResponseV2> result = conversationService.listConversations(request);
                
                System.out.println("listConversations (Page " + page + "): " + result.getMsg());
                System.out.println("Response: " + JSON.toJSONString(result));
                
                if (result.getCode() == 200) {
                    ListConversationsResponseV2 response = result.getResponse();
                    
                    // Check conversation items
                    if (response.getItems() != null && !response.getItems().isEmpty()) {
                        System.out.println("Found " + response.getItems().size() + " conversations:");
                        for (ListConversationsResponseV2.ConversationItem item : response.getItems()) {
                            System.out.println("  - " + item.getConversationId());
                            System.out.println("    Type: " + item.getType());
                            System.out.println("    Sender: " + item.getSenderId());
                            System.out.println("    Receiver: " + item.getReceiverId());
                            System.out.println("    Is stick top: " + item.getStickTop());
                            System.out.println("    Unread count: " + item.getUnreadCount());
                        }
                    } else {
                        System.out.println("No conversations found on this page");
                    }
                    
                    // Update pagination state for next iteration
                    hasMore = response.getHasMore() != null && response.getHasMore();
                    nextToken = response.getNextToken();
                    
                    if (hasMore) {
                        System.out.println("More conversations available, next token: " + nextToken);
                    } else {
                        System.out.println("No more conversations available");
                    }
                } else {
                    System.out.println("Failed to list conversations: " + result.getMsg());
                    hasMore = false;
                }
            } catch (Exception e) {
                System.out.println("Exception during listing conversations: " + e.getMessage());
                e.printStackTrace();
                hasMore = false;
            }
            
            page++;
        }
    }
} 