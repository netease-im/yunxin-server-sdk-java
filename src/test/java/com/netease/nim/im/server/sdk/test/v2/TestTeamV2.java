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
import com.netease.nim.server.sdk.im.v2.team.ITeamV2Service;
import com.netease.nim.server.sdk.im.v2.team.request.AddTeamManagersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.BatchQueryTeamInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.BatchQueryTeamOnlineMembersCountRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.CreateTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.DisbandTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.GetTeamInfoRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.ListOnlineTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.ListTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.RemoveTeamManagersRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.TransferTeamOwnerRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.UpdateTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.response.AddTeamManagersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.BatchQueryTeamInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.BatchQueryTeamOnlineMembersCountResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.CreateTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.DisbandTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.GetTeamInfoResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.ListOnlineTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.ListTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.RemoveTeamManagersResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.TransferTeamOwnerResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.UpdateTeamResponseV2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Test class for TeamV2Service
 */
public class TestTeamV2 {

    private static YunxinV2ApiServices services = null;
    private static Long advancedTeamId;
    private static String ownerAccountId;
    private static String memberAccountId1;
    private static String memberAccountId2;
    private static String memberAccountId3;

    @BeforeClass
    public static void setup() throws YunxinSdkException {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
        services = new YunxinV2ApiServices(client);
        
        // Initialize account IDs
        ownerAccountId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        memberAccountId1 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        memberAccountId2 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        memberAccountId3 = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
        
        // Create test accounts
        if (services != null) {
            // Create owner account
            String ownerName = "teamOwner-" + UUID.randomUUID();
            createAccount(ownerAccountId, ownerName);
            
            // Create member accounts
            String memberName1 = "teamMember1-" + UUID.randomUUID();
            createAccount(memberAccountId1, memberName1);
            
            String memberName2 = "teamMember2-" + UUID.randomUUID();
            createAccount(memberAccountId2, memberName2);
            
            // Create a third member account for manager
            String memberName3 = "teamMember3-" + UUID.randomUUID();
            createAccount(memberAccountId3, memberName3);
            
            // Create an advanced team for testing
            advancedTeamId = createAdvancedTeam();
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

        // Verify account creation
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        Assert.assertEquals(accountId, result.getResponse().getAccountId());

        System.out.println("Created account: " + accountId + ", name: " + name);
    }

    /**
     * Helper method to create an advanced team
     */
    private static Long createAdvancedTeam() throws YunxinSdkException {
        String teamName = "AdvancedTeam-" + UUID.randomUUID();
        List<String> members = Arrays.asList(memberAccountId1, memberAccountId2, memberAccountId3);
        String inviteMsg = "Please join my advanced team!";

        // Create the request using the helper method
        CreateTeamRequestV2 request = CreateTeamRequestV2.createAdvancedTeam(
            ownerAccountId, teamName, members, inviteMsg);

        // Add some more advanced settings
        request.setIcon("https://example.com/team-icon.png");
        request.setAnnouncement("Welcome to our advanced team!");
        request.setIntro("This is a test advanced team created via the SDK");

        // Set up more configuration
        CreateTeamRequestV2.Configuration config = request.getConfiguration();
        if (config == null) {
            config = new CreateTeamRequestV2.Configuration();
            request.setConfiguration(config);
        }

        config.setJoinMode(0); // Need owner/admin approval
        config.setInviteMode(0); // Only owner/admin can invite
        config.setAgreeMode(1); // Only owner/admin can invite

        ITeamV2Service teamService = services.getTeamService();
        Result<CreateTeamResponseV2> result = teamService.createTeam(request);

        System.out.println("createAdvancedTeam:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));

        if (result.getCode() == 200) {
            CreateTeamResponseV2 response = result.getResponse();
            Assert.assertNotNull(response.getTeamInfo());

            CreateTeamResponseV2.TeamInfo teamInfo = response.getTeamInfo();
            Assert.assertEquals(ownerAccountId, teamInfo.getOwnerAccountId());
            Assert.assertEquals(teamName, teamInfo.getName());

            System.out.println("Created advanced team: " + teamInfo.getTeamId());
            System.out.println("Team name: " + teamInfo.getName());
            System.out.println("Team owner: " + teamInfo.getOwnerAccountId());

            // Check if there were any failed invitations
            if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                System.out.println("Failed to invite accounts: ");
                for (CreateTeamResponseV2.FailedAccount failedAccount : response.getFailedList()) {
                    System.out.println("  Account: " + failedAccount.getAccountId() +
                                      ", Error: " + failedAccount.getErrorCode() +
                                      " - " + failedAccount.getErrorMsg());
                }
            }

            return teamInfo.getTeamId();
        } else {
            System.out.println("Failed to create advanced team: " + result.getMsg());
            return null;
        }
    }

    /**
     * Create a team specifically for the disband test
     */
    private Long createTeamForDisband() throws YunxinSdkException {
        String teamName = "TeamToDisband-" + UUID.randomUUID();
        List<String> members = Arrays.asList(memberAccountId1, memberAccountId2);
        String inviteMsg = "This team will be disbanded in the test!";

        // Create the request using the helper method
        CreateTeamRequestV2 request = CreateTeamRequestV2.createAdvancedTeam(
            ownerAccountId, teamName, members, inviteMsg);

        // Add some settings
        request.setIcon("https://example.com/team-icon.png");
        request.setAnnouncement("This team will be disbanded soon!");
        request.setIntro("This is a test team created to test the disband feature");

        // Set up configuration
        CreateTeamRequestV2.Configuration config = request.getConfiguration();
        if (config == null) {
            config = new CreateTeamRequestV2.Configuration();
            request.setConfiguration(config);
        }

        config.setJoinMode(0); // Need owner/admin approval
        config.setInviteMode(0); // Only owner/admin can invite

        ITeamV2Service teamService = services.getTeamService();
        Result<CreateTeamResponseV2> result = teamService.createTeam(request);

        System.out.println("createTeamForDisband:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));

        if (result.getCode() == 200) {
            CreateTeamResponseV2 response = result.getResponse();
            Assert.assertNotNull(response.getTeamInfo());

            CreateTeamResponseV2.TeamInfo teamInfo = response.getTeamInfo();
            Assert.assertEquals(ownerAccountId, teamInfo.getOwnerAccountId());
            Assert.assertEquals(teamName, teamInfo.getName());

            System.out.println("Created team for disband test: " + teamInfo.getTeamId());
            System.out.println("Team name: " + teamInfo.getName());

            return teamInfo.getTeamId();
        } else {
            System.out.println("Failed to create team for disband test: " + result.getMsg());
            return null;
        }
    }

    /**
     * Test updating a team
     *
     * @param teamId the team ID to update
     * @param teamType the team type (1 for advanced team, 2 for super team)
     */
    private void testUpdateTeam(Long teamId, int teamType) throws YunxinSdkException {
        String updatedName = "Updated Team " + UUID.randomUUID();
        String updatedAnnouncement = "Updated announcement for team " + teamId;

        // Create the update request
        UpdateTeamRequestV2 request = new UpdateTeamRequestV2();
        request.setOperatorId(ownerAccountId); // Use owner as the operator
        request.setTeamType(teamType); // Required field
        request.setName(updatedName);
        request.setAnnouncement(updatedAnnouncement);

        // Update the team configuration
        UpdateTeamRequestV2.Configuration config = new UpdateTeamRequestV2.Configuration();
        config.setJoinMode(2); // No one can apply to join
        config.setInviteMode(1); // Everyone can invite
        request.setConfiguration(config);

        ITeamV2Service teamService = services.getTeamService();
        request.setTeamId(teamId);
        Result<UpdateTeamResponseV2> result = teamService.updateTeam(request);

        System.out.println("updateTeam:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));

        if (result.getCode() == 200) {
            UpdateTeamResponseV2 response = result.getResponse();
            Assert.assertNotNull(response.getTeamInfo());

            UpdateTeamResponseV2.TeamInfo teamInfo = response.getTeamInfo();
            Assert.assertEquals(teamId, teamInfo.getTeamId());
            Assert.assertEquals(updatedName, teamInfo.getName());
            Assert.assertEquals(updatedAnnouncement, teamInfo.getAnnouncement());

            // Verify configuration update
            Assert.assertNotNull(teamInfo.getConfiguration());
            Assert.assertEquals(Integer.valueOf(2), teamInfo.getConfiguration().getJoinMode());
            Assert.assertEquals(Integer.valueOf(1), teamInfo.getConfiguration().getInviteMode());

            System.out.println("Updated team: " + teamInfo.getTeamId());
            System.out.println("Updated name: " + teamInfo.getName());
            System.out.println("Updated announcement: " + teamInfo.getAnnouncement());
        } else {
            System.out.println("Failed to update team: " + result.getMsg());
        }
    }

    /**
     * Test adding team managers
     *
     * This method adds one or more team members as managers to the team.
     * Only the team owner can add team managers.
     *
     */
    @Test
    public void testAddTeamManagers() throws YunxinSdkException {
        if (services == null) return;
        
        Long teamId = advancedTeamId;
        int teamType = 1;
        
        // Create the request to add team managers
        AddTeamManagersRequestV2 request = new AddTeamManagersRequestV2();
        request.setTeamId(teamId);
        request.setTeamType(teamType);
        request.setOperatorId(ownerAccountId); // Team owner is performing the operation

        // Add members as managers
        List<String> managers = Arrays.asList(memberAccountId1, memberAccountId2);
        request.setManagers(managers);

        // Add an extension field for advanced teams
        if (teamType == 1) {
            request.setExtension("{\"reason\":\"These members are active and trustworthy\"}");
        }

        ITeamV2Service teamService = services.getTeamService();
        Result<AddTeamManagersResponseV2> result = teamService.addManagers(request);

        System.out.println("addTeamManagers:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the response
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("Added team managers to team " + teamId + ":");
        for (String manager : managers) {
            System.out.println("  Manager: " + manager);
        }
    }
    
    /**
     * Test removing team managers
     * 
     * This method removes one or more team managers, reverting them to regular members.
     * Only the team owner can remove team managers.
     *
     */
    @Test
    public void testRemoveTeamManagers() throws YunxinSdkException {
        if (services == null) return;
        
        Long teamId = advancedTeamId;
        int teamType = 1;
        System.out.println("\n============= TESTING REMOVE TEAM MANAGERS =============");
        
        // Create the request to remove team managers
        RemoveTeamManagersRequestV2 request = new RemoveTeamManagersRequestV2();
        request.setTeamId(teamId);
        request.setTeamType(teamType);
        request.setOperatorId(ownerAccountId); // Team owner is performing the operation
        
        // Remove members from manager role
        List<String> managers = Arrays.asList(memberAccountId1);
        request.setManagers(managers);
        
        // Add an extension field for advanced teams
        if (teamType == 1) {
            request.setExtension("{\"reason\":\"Manager role rotation for team development\"}");
        }
        
        ITeamV2Service teamService = services.getTeamService();
        Result<RemoveTeamManagersResponseV2> result = teamService.removeManagers(request);
        
        System.out.println("removeTeamManagers:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the response
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("Removed team managers from team " + teamId + ":");
        for (String manager : managers) {
            System.out.println("  Removed manager: " + manager);
        }

        System.out.println("============= END TESTING REMOVE TEAM MANAGERS =============\n");
    }
    
    /**
     * Test disbanding a team
     * 
     * This method disbands a team completely, removing it from the system.
     * Only the team owner can disband a team.
     *
     */
    @Test
    public void testDisbandTeam() throws YunxinSdkException {
        if (services == null) return;
        
        Long teamIdObj = createTeamForDisband();
        if (teamIdObj == null) return;
        
        Long teamId = teamIdObj;
        Integer teamType = 1;
        
        System.out.println("\n============= TESTING DISBAND TEAM =============");
        
        // Create the request to disband the team
        DisbandTeamRequestV2 request = new DisbandTeamRequestV2(teamId, teamType);
        request.setOperatorId(ownerAccountId); // Team owner is performing the operation
        
        // Add an extension field for advanced teams
        if (teamType == 1) {
            request.setExtension("{\"reason\":\"Team disbanded for testing purposes\"}");
        }
        
        ITeamV2Service teamService = services.getTeamService();
        Result<DisbandTeamResponseV2> result = teamService.disbandTeam(request);
        
        System.out.println("disbandTeam:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the response
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("Successfully disbanded team " + teamId);
        
        System.out.println("============= END TESTING DISBAND TEAM =============\n");
    }
    
    /**
     * Test getting team information
     * 
     * This method retrieves detailed information about a team, including its
     * properties and configuration.
     *
     */
    @Test
    public void testGetTeamInfo() throws YunxinSdkException {
        if (services == null) return;
        
        Long teamId = advancedTeamId;
        Integer teamType = 1;
        
        // Create the request to get team information
        GetTeamInfoRequestV2 request = new GetTeamInfoRequestV2(teamId, teamType);
        
        ITeamV2Service teamService = services.getTeamService();
        Result<GetTeamInfoResponseV2> result = teamService.getTeamInfo(request);
        
        System.out.println("getTeamInfo:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            GetTeamInfoResponseV2 response = result.getResponse();
            Assert.assertNotNull(response.getTeamInfo());
            
            GetTeamInfoResponseV2.TeamInfo teamInfo = response.getTeamInfo();
            Assert.assertEquals(teamId, teamInfo.getTeamId());
            Assert.assertNotNull(teamInfo.getMemberCount());
            Assert.assertNotNull(teamInfo.getName());
            Assert.assertNotNull(teamInfo.getCreateTime());
            Assert.assertNotNull(teamInfo.getUpdateTime());
            
            // Verify configuration
            Assert.assertNotNull(teamInfo.getConfiguration());
            Assert.assertNotNull(teamInfo.getConfiguration().getJoinMode());
            
            System.out.println("Team info for team " + teamId + ":");
            System.out.println("  Name: " + teamInfo.getName());
            System.out.println("  Type: " + teamInfo.getTeamType());
            System.out.println("  Member count: " + teamInfo.getMemberCount());
            System.out.println("  Created: " + teamInfo.getCreateTime());
            System.out.println("  Updated: " + teamInfo.getUpdateTime());
            
            // Display configuration details
            GetTeamInfoResponseV2.Configuration config = teamInfo.getConfiguration();
            if (config != null) {
                System.out.println("  Join mode: " + config.getJoinMode());
                System.out.println("  Invite mode: " + config.getInviteMode());
                System.out.println("  Agree mode: " + config.getAgreeMode());
                System.out.println("  Chat banned mode: " + config.getChatBannedMode());
            }
        } else {
            System.out.println("Failed to get team info: " + result.getMsg());
        }
    }
    
    /**
     * Test listing team members
     * 
     * This method queries team members with optional pagination and filtering.
     *
     */
    @Test
    public void testListTeamMembers() throws YunxinSdkException {
        if (services == null) return;
        
        // List all members
        ListTeamMembersRequestV2 request = new ListTeamMembersRequestV2(advancedTeamId, 1);
        ITeamV2Service teamService = services.getTeamService();
        Result<ListTeamMembersResponseV2> result = teamService.listTeamMembers(request);
        
        System.out.println("listTeamMembers:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            ListTeamMembersResponseV2 response = result.getResponse();
            Assert.assertNotNull(response.getItems());
            
            List<ListTeamMembersResponseV2.TeamMember> members = response.getItems();
            System.out.println("Team members for team " + request.getTeamId() + ":");
            System.out.println("  Found " + members.size() + " members");
            System.out.println("  Has more: " + response.getHasMore());
            if (response.getHasMore()) {
                System.out.println("  Next page token: " + response.getNextToken());
            }
            
            // Print members details
            for (ListTeamMembersResponseV2.TeamMember member : members) {
                System.out.println("  Member: " + member.getAccountId());
                System.out.println("    Role: " + getRoleName(member.getMemberRole()));
                System.out.println("    Join time: " + member.getJoinTime());
                System.out.println("    Chat banned: " + (member.getChatBanned() != null && member.getChatBanned() ? "Yes" : "No"));
                if (member.getTeamNick() != null && !member.getTeamNick().isEmpty()) {
                    System.out.println("    Team nickname: " + member.getTeamNick());
                }
            }
        } else {
            System.out.println("Failed to list team members: " + result.getMsg());
        }
    }
    
    /**
     * Helper method to get role name from role ID
     */
    private String getRoleName(Integer roleId) {
        if (roleId == null) {
            return "Unknown";
        }
        
        switch (roleId) {
            case 0:
                return "Regular member";
            case 1:
                return "Owner";
            case 2:
                return "Manager";
            default:
                return "Unknown role (" + roleId + ")";
        }
    }
    
    /**
     * Test transferring team ownership
     * 
     * This method transfers ownership of a team to a new owner.
     * Only the team owner can transfer ownership.
     *
     */
    @Test
    public void testTransferTeamOwner() throws YunxinSdkException {
        if (services == null) return;
        
        Long teamId = advancedTeamId;
        int teamType = 1;
        
        // Create the request to transfer team ownership
        TransferTeamOwnerRequestV2 request = new TransferTeamOwnerRequestV2();
        request.setTeamId(teamId);
        request.setTeamType(teamType);
        request.setNewOwnerAccountId(memberAccountId3); // Transfer to member3
        request.setLeave(2); // Original owner stays as a regular member (1: Leave, 2: Stay)
        
        // Add an extension field for advanced teams
        if (teamType == 1) {
            request.setExtension("{\"reason\":\"Transferring ownership due to organizational changes\"}");
        }
        
        ITeamV2Service teamService = services.getTeamService();
        Result<TransferTeamOwnerResponseV2> result = teamService.transferOwner(request);
        
        System.out.println("transferTeamOwner:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the response
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("Transferred team " + teamId + " ownership:");
        System.out.println("  From: " + ownerAccountId);
        System.out.println("  To: " + memberAccountId3);
        ownerAccountId=memberAccountId3;
        System.out.println("  Original owner stayed as member: " + (request.getLeave() == 2 ? "Yes" : "No"));
    }

    /**
     * Test batch query team information
     */
    @Test
    public void testBatchQueryTeamInfo() throws YunxinSdkException {
        if (services == null) return;
        
        // Create the request
        BatchQueryTeamInfoRequestV2 request = new BatchQueryTeamInfoRequestV2();
        request.setTeamType(1); // 1 for advanced team
        List<Long> teamIds = new ArrayList<>();
        teamIds.add(advancedTeamId);
        
        // Create a second team if needed
        try {
            Long team2Id = createAdvancedTeam();
            if (team2Id != null) {
                teamIds.add(team2Id);
            }
        } catch (Exception e) {
            System.out.println("Failed to create second team for batch query: " + e.getMessage());
        }
        
        request.setTeamIds(teamIds);
        
        ITeamV2Service teamService = services.getTeamService();
        Result<BatchQueryTeamInfoResponseV2> result = teamService.batchQueryTeamInfo(request);
        
        System.out.println("batchQueryTeamInfo: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        Assert.assertEquals(200, result.getCode());
        Assert.assertNotNull(result.getResponse());
        
        BatchQueryTeamInfoResponseV2 response = result.getResponse();
        Assert.assertNotNull(response.getTeamInfoList());
        Assert.assertTrue(response.getTeamInfoList().size() > 0);
        
        System.out.println("Batch queried " + response.getTeamInfoList().size() + " teams");
        for (BatchQueryTeamInfoResponseV2.TeamInfo teamInfo : response.getTeamInfoList()) {
            System.out.println("Team ID: " + teamInfo.getTeamId());
            System.out.println("Team Name: " + teamInfo.getName());
            System.out.println("----------------------------------------");
        }
    }

    /**
     * Test listing online team members
     * Note: This API is only available for IM Flagship Edition or above
     */
    @Test
    public void testListOnlineTeamMembers() throws YunxinSdkException {
        if (services == null) return;
        
        Long teamId = advancedTeamId;
        Integer teamType = 1;
        
        // Create the request
        ListOnlineTeamMembersRequestV2 request = new ListOnlineTeamMembersRequestV2(teamId, teamType);
        
        ITeamV2Service teamService = services.getTeamService();
        Result<ListOnlineTeamMembersResponseV2> result = teamService.listOnlineTeamMembers(request);
        
        System.out.println("listOnlineTeamMembers: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Note: We check the result code but don't assert it should be 200, as this API
        // might not be available in test environments (requires IM Flagship Edition)
        if (result.getCode() == 200) {
            ListOnlineTeamMembersResponseV2 response = result.getResponse();
            if (response != null && response.getItems() != null) {
                System.out.println("Found " + response.getItems().size() + " online team members");
                
                // Display online members and their device information
                for (ListOnlineTeamMembersResponseV2.OnlineTeamMember member : response.getItems()) {
                    System.out.println("Account ID: " + member.getAccountId());
                    
                    // Display login information for each device
                    if (member.getOnlineStatus() != null) {
                        System.out.println("  Logged in on " + member.getOnlineStatus().size() + " devices:");
                        for (ListOnlineTeamMembersResponseV2.OnlineTeamMember.LoginInfo loginInfo : member.getOnlineStatus()) {
                            System.out.println("    Login Time: " + loginInfo.getLoginTime());
                            System.out.println("    Client Type: " + getClientTypeName(loginInfo.getClientType()));
                        }
                    }
                    System.out.println("----------------------------------------");
                }
            } else {
                System.out.println("No online team members found");
            }
        } else {
            System.out.println("Failed to list online team members. " +
                    "This API requires IM Flagship Edition or above.");
        }
    }
    
    /**
     * Helper method to get client type name from client type ID
     */
    private String getClientTypeName(Integer clientType) {
        if (clientType == null) return "Unknown";
        
        switch (clientType) {
            case 0: return "UNSET";
            case 1: return "Android";
            case 2: return "iOS";
            case 4: return "PC";
            case 8: return "Windows Phone";
            case 16: return "Web";
            case 32: return "REST";
            case 64: return "Mac";
            default: return "Unknown (" + clientType + ")";
        }
    }

    /**
     * Test batch query team online members count
     * Note: This API is only available for IM Flagship Edition or above
     */
    @Test
    public void testBatchQueryTeamOnlineMembersCount() throws YunxinSdkException {
        if (services == null) return;
        
        // Create the request
        BatchQueryTeamOnlineMembersCountRequestV2 request = new BatchQueryTeamOnlineMembersCountRequestV2();
        request.setTeamType(1); // 1 for advanced team
        List<Long> teamIds = new ArrayList<>();
        teamIds.add(advancedTeamId);
        
        // Create a second team if needed
        try {
            Long team2Id = createAdvancedTeam();
            if (team2Id != null) {
                teamIds.add(team2Id);
            }
        } catch (Exception e) {
            System.out.println("Failed to create second team for batch query: " + e.getMessage());
        }
        
        request.setTeamIds(teamIds);
        
        ITeamV2Service teamService = services.getTeamService();
        Result<BatchQueryTeamOnlineMembersCountResponseV2> result = teamService.batchQueryTeamOnlineMembersCount(request);
        
        System.out.println("batchQueryTeamOnlineMembersCount: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Note: We check the result code but don't assert it should be 200, as this API
        // might not be available in test environments (requires IM Flagship Edition)
        if (result.getCode() == 200) {
            BatchQueryTeamOnlineMembersCountResponseV2 response = result.getResponse();
            
            // Display successful teams
            if (response.getSuccessList() != null && !response.getSuccessList().isEmpty()) {
                System.out.println("Successfully queried " + response.getSuccessList().size() + " teams:");
                for (BatchQueryTeamOnlineMembersCountResponseV2.SuccessTeam team : response.getSuccessList()) {
                    System.out.println("Team ID: " + team.getTeamId());
                    System.out.println("  Online members: " + team.getOnlineCount());
                    System.out.println("  Offline members: " + team.getOfflineCount());
                    System.out.println("  Total members: " + (team.getOnlineCount() + team.getOfflineCount()));
                    System.out.println("----------------------------------------");
                }
            } else {
                System.out.println("No teams were successfully queried");
            }
            
            // Display failed teams
            if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
                System.out.println("Failed to query " + response.getFailedList().size() + " teams:");
                for (BatchQueryTeamOnlineMembersCountResponseV2.FailedTeam team : response.getFailedList()) {
                    System.out.println("Team ID: " + team.getTeamId());
                    System.out.println("  Error code: " + team.getErrorCode());
                    System.out.println("  Error message: " + team.getErrorMsg());
                    System.out.println("----------------------------------------");
                }
            }
        } else {
            System.out.println("Failed to batch query team online members count. " +
                    "This API requires IM Flagship Edition or above.");
        }
    }
    
    /**
     * Test updating a team
     * This method tests updating an existing team
     */
    @Test
    public void testUpdateTeam() throws YunxinSdkException {
        if (services == null) return;
        
        // Test with the advanced team
        testUpdateTeam(advancedTeamId, 1);
    }
}