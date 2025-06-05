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
import com.netease.nim.server.sdk.im.v2.team.request.CreateTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.request.DisbandTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team.response.CreateTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team.response.DisbandTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.ITeamMemberV2Service;
import com.netease.nim.server.sdk.im.v2.team_member.request.BatchMuteTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.InviteTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.KickTeamMembersRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.LeaveTeamRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.QueryJoinedTeamsRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.request.UpdateTeamMemberRequestV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.BatchMuteTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.InviteTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.KickTeamMembersResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.LeaveTeamResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.QueryJoinedTeamsResponseV2;
import com.netease.nim.server.sdk.im.v2.team_member.response.UpdateTeamMemberResponseV2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

/**
 * Test class for TeamMemberV2Service
 */
public class TestTeamMemberV2 {

    private static YunxinV2ApiServices services = null;
    private static String ownerAccountId;
    private static String memberAccountId1;
    private static String memberAccountId2;
    private static String memberAccountId3;
    private static Long teamId = null;

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
        
        if (services != null) {
            // Create test accounts
            createTestAccounts();
            
            // Create a team for testing
            teamId = createTestTeam();
            if (teamId == null) {
                System.out.println("Failed to create test team. Tests will be skipped.");
            }
        }
    }

    /**
     * Create test user accounts
     */
    private static void createTestAccounts() throws YunxinSdkException {
        // Create owner account
        String ownerName = "teamOwner-" + UUID.randomUUID();
        createAccount(ownerAccountId, ownerName);
        
        // Create member accounts
        String memberName1 = "teamMember1-" + UUID.randomUUID();
        createAccount(memberAccountId1, memberName1);
        
        String memberName2 = "teamMember2-" + UUID.randomUUID();
        createAccount(memberAccountId2, memberName2);
        
        String memberName3 = "teamMember3-" + UUID.randomUUID();
        createAccount(memberAccountId3, memberName3);
        
        System.out.println("Created test accounts: owner=" + ownerAccountId + 
                           ", members=[" + memberAccountId1 + ", " + memberAccountId2 + ", " + memberAccountId3 + "]");
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
    }
    
    /**
     * Create a team for testing team member operations
     */
    private static Long createTestTeam() throws YunxinSdkException {
        String teamName = "TestTeam-" + UUID.randomUUID();
        
        // Create the request using the helper method
        CreateTeamRequestV2 request = CreateTeamRequestV2.createAdvancedTeam(
            ownerAccountId, teamName, Arrays.asList(memberAccountId1,memberAccountId2), "Please join my test team!");
        
        request.setIcon("https://example.com/team-icon.png");
        request.setAnnouncement("Welcome to our test team!");
        request.setIntro("This is a test team created for TeamMemberV2Service testing");

        // Set up configuration
        CreateTeamRequestV2.Configuration config = request.getConfiguration();
        if (config == null) {
            config = new CreateTeamRequestV2.Configuration();
            request.setConfiguration(config);
        }
        
        config.setJoinMode(1); // No Need owner/admin approval
        config.setInviteMode(0); // Only owner/admin can invite
        config.setAgreeMode(1); // No need for invitee consent

        ITeamV2Service teamService = services.getTeamService();
        Result<CreateTeamResponseV2> result = teamService.createTeam(request);
        
        System.out.println("createTestTeam:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        if (result.getCode() == 200) {
            CreateTeamResponseV2 response = result.getResponse();
            Assert.assertNotNull(response.getTeamInfo());
            
            CreateTeamResponseV2.TeamInfo teamInfo = response.getTeamInfo();
            Assert.assertEquals(ownerAccountId, teamInfo.getOwnerAccountId());
            Assert.assertEquals(teamName, teamInfo.getName());
            
            System.out.println("Created test team: " + teamInfo.getTeamId());
            return teamInfo.getTeamId();
        } else {
            System.out.println("Failed to create test team: " + result.getMsg());
            return null;
        }
    }
    
    /**
     * Test inviting members to a team
     */
    @Test
    public void testInviteTeamMembers() throws YunxinSdkException {
        if (services == null || teamId == null) return;
        
        System.out.println("\n============= TESTING INVITE TEAM MEMBERS =============");
        
        InviteTeamMembersRequestV2 request = new InviteTeamMembersRequestV2();
        request.setTeamId(teamId);
        request.setTeamType(1); // Advanced team
        request.setOperatorId(ownerAccountId);
        request.setInviteAccountIds(Arrays.asList(memberAccountId3));
        request.setMsg("You are invited to join our test team");
        
        ITeamMemberV2Service teamMemberService = services.getTeamMemberService();
        Result<InviteTeamMembersResponseV2> result = teamMemberService.inviteTeamMembers(request);
        
        System.out.println("inviteTeamMembers:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        InviteTeamMembersResponseV2 response = result.getResponse();
        if (response.getSuccessList() != null) {
            System.out.println("Successfully invited " + response.getSuccessList().size() + " members");
        }
        
        if (response.getFailedList() != null && !response.getFailedList().isEmpty()) {
            System.out.println("Failed to invite " + response.getFailedList().size() + " members:");
            for (InviteTeamMembersResponseV2.FailedInvitation failedInvite : response.getFailedList()) {
                System.out.println("  Failed to invite: " + failedInvite.getAccountId());
                System.out.println("    Error: " + failedInvite.getErrorCode() + " - " + failedInvite.getErrorMsg());
            }
        }
        
        System.out.println("============= END TESTING INVITE TEAM MEMBERS =============\n");
    }
    
    /**
     * Test updating a team member's information
     */
    @Test
    public void testUpdateTeamMember() throws YunxinSdkException {
        if (services == null || teamId == null) return;
        
        System.out.println("\n============= TESTING UPDATE TEAM MEMBER =============");
        
        // Update the first member's info
        UpdateTeamMemberRequestV2 request = new UpdateTeamMemberRequestV2();
        request.setAccountId(memberAccountId1);
        request.setTeamId(teamId);
        request.setTeamType(1); // Advanced team
        request.setOperatorId(ownerAccountId);
        request.setTeamNick("TestNickname");
        request.setMessageNotifyState(1); // Receive notifications but not push
        
        ITeamMemberV2Service teamMemberService = services.getTeamMemberService();
        Result<UpdateTeamMemberResponseV2> result = teamMemberService.updateTeamMember(request);
        
        System.out.println("updateTeamMember:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("============= END TESTING UPDATE TEAM MEMBER =============\n");
    }
    
    /**
     * Test batch mute team members
     * 
     * This method tests muting and unmuting multiple team members at once.
     * In advanced teams, only the team owner can mute members.
     * In super teams, owners and admins can mute regular members, but only owners can mute admins.
     */
    @Test
    public void testBatchMuteTeamMembers() throws YunxinSdkException {
        if (services == null || teamId == null) return;
        
        System.out.println("\n============= TESTING BATCH MUTE TEAM MEMBERS =============");
        
        // First mute the members
        System.out.println("Muting team members...");
        
        // Create request to mute members
        BatchMuteTeamMembersRequestV2 muteRequest = new BatchMuteTeamMembersRequestV2();
        muteRequest.setOperatorId(ownerAccountId); // Team owner is performing the operation
        muteRequest.setTeamId(teamId);
        muteRequest.setTeamType(1); // Advanced team
        muteRequest.setChatBanAccountIds(Arrays.asList(memberAccountId1, memberAccountId2));
        muteRequest.setChatBanned(true); // Set to mute (true)
        
        ITeamMemberV2Service teamMemberService = services.getTeamMemberService();
        Result<BatchMuteTeamMembersResponseV2> muteResult = teamMemberService.batchMuteTeamMembers(muteRequest);
        
        System.out.println("batchMuteTeamMembers (mute):" + muteResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(muteResult));
        
        // Verify the response
        Assert.assertEquals(200, muteResult.getCode());
        Assert.assertEquals("success", muteResult.getMsg());
        
        BatchMuteTeamMembersResponseV2 muteResponse = muteResult.getResponse();
        if (muteResponse.getSuccessList() != null) {
            System.out.println("Successfully muted " + muteResponse.getSuccessList().size() + " members:");
            for (String accountId : muteResponse.getSuccessList()) {
                System.out.println("  Muted: " + accountId);
            }
        }
        
        if (muteResponse.getFailedList() != null && !muteResponse.getFailedList().isEmpty()) {
            System.out.println("Failed to mute " + muteResponse.getFailedList().size() + " members:");
            for (BatchMuteTeamMembersResponseV2.FailedMute failedMute : muteResponse.getFailedList()) {
                System.out.println("  Failed to mute: " + failedMute.getAccountId());
                System.out.println("    Error: " + failedMute.getErrorCode() + " - " + failedMute.getErrorMsg());
            }
        }
        
        // Wait a moment to ensure mute has taken effect
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Ignore
        }
        
        // Now unmute the members
        System.out.println("\nUnmuting team members...");
        
        // Create request to unmute members
        BatchMuteTeamMembersRequestV2 unmuteRequest = new BatchMuteTeamMembersRequestV2();
        unmuteRequest.setOperatorId(ownerAccountId); // Team owner is performing the operation
        unmuteRequest.setTeamId(teamId);
        unmuteRequest.setTeamType(1); // Advanced team
        unmuteRequest.setChatBanAccountIds(Arrays.asList(memberAccountId1, memberAccountId2));
        unmuteRequest.setChatBanned(false); // Set to unmute (false)
        
        Result<BatchMuteTeamMembersResponseV2> unmuteResult = teamMemberService.batchMuteTeamMembers(unmuteRequest);
        
        System.out.println("batchMuteTeamMembers (unmute):" + unmuteResult.getMsg());
        System.out.println("Response: " + JSON.toJSONString(unmuteResult));
        
        // Verify the response
        Assert.assertEquals(200, unmuteResult.getCode());
        Assert.assertEquals("success", unmuteResult.getMsg());
        
        BatchMuteTeamMembersResponseV2 unmuteResponse = unmuteResult.getResponse();
        if (unmuteResponse.getSuccessList() != null) {
            System.out.println("Successfully unmuted " + unmuteResponse.getSuccessList().size() + " members:");
            for (String accountId : unmuteResponse.getSuccessList()) {
                System.out.println("  Unmuted: " + accountId);
            }
        }
        
        if (unmuteResponse.getFailedList() != null && !unmuteResponse.getFailedList().isEmpty()) {
            System.out.println("Failed to unmute " + unmuteResponse.getFailedList().size() + " members:");
            for (BatchMuteTeamMembersResponseV2.FailedMute failedMute : unmuteResponse.getFailedList()) {
                System.out.println("  Failed to unmute: " + failedMute.getAccountId());
                System.out.println("    Error: " + failedMute.getErrorCode() + " - " + failedMute.getErrorMsg());
            }
        }
        
        System.out.println("============= END TESTING BATCH MUTE TEAM MEMBERS =============\n");
    }
    
    /**
     * Test querying joined teams
     * 
     * This method tests retrieving the list of teams that an account has joined,
     * with options for pagination and returning member information.
     */
    @Test
    public void testQueryJoinedTeams() throws YunxinSdkException {
        if (services == null || teamId == null) return;
        
        System.out.println("\n============= TESTING QUERY JOINED TEAMS =============");
        
        // Create basic request
        QueryJoinedTeamsRequestV2 request = new QueryJoinedTeamsRequestV2(memberAccountId1, 1); // 1 for advanced team
        request.setLimit(20); // Get up to 20 teams per page
        request.setNeedReturnMemberInfo(1); // Include member info in the response
        
        ITeamMemberV2Service teamMemberService = services.getTeamMemberService();
        Result<QueryJoinedTeamsResponseV2> result = teamMemberService.queryJoinedTeams(request);
        
        System.out.println("queryJoinedTeams:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        // Verify the response
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        QueryJoinedTeamsResponseV2 response = result.getResponse();
        Assert.assertNotNull(response);
        
        // Display joined teams information
        if (response.getTeamInfoList() != null && !response.getTeamInfoList().isEmpty()) {
            System.out.println("Found " + response.getTeamInfoList().size() + " joined teams for account " + memberAccountId1 + ":");
            for (QueryJoinedTeamsResponseV2.TeamInfo teamInfo : response.getTeamInfoList()) {
                System.out.println("\nTeam ID: " + teamInfo.getTeamId());
                System.out.println("Team Name: " + teamInfo.getName());
                System.out.println("Owner Account ID: " + teamInfo.getOwnerAccountId());
                System.out.println("Member Count: " + teamInfo.getMemberCount());
                System.out.println("Members Limit: " + teamInfo.getMembersLimit());
                System.out.println("Create Time: " + teamInfo.getCreateTime());
                System.out.println("Update Time: " + teamInfo.getUpdateTime());
                
                // Display configuration if available
                QueryJoinedTeamsResponseV2.TeamConfiguration config = teamInfo.getConfiguration();
                if (config != null) {
                    System.out.println("\nTeam Configuration:");
                    System.out.println("  Join Mode: " + config.getJoinMode());
                    System.out.println("  Invite Mode: " + config.getInviteMode());
                    System.out.println("  Agree Mode: " + config.getAgreeMode());
                    System.out.println("  Update Team Info Mode: " + config.getUpdateTeamInfoMode());
                    System.out.println("  Update Extension Mode: " + config.getUpdateExtensionMode());
                }
                
                // Display member information if available
                QueryJoinedTeamsResponseV2.MemberInfo memberInfo = teamInfo.getMemberInfo();
                if (memberInfo != null) {
                    System.out.println("\nMember Information:");
                    System.out.println("  Member Role: " + getRoleName(memberInfo.getMemberRole()));
                    System.out.println("  Account ID: " + memberInfo.getAccountId());
                    System.out.println("  Chat Banned: " + (memberInfo.getChatBanned() != null && memberInfo.getChatBanned() ? "Yes" : "No"));
                    if (memberInfo.getTeamNick() != null && !memberInfo.getTeamNick().isEmpty()) {
                        System.out.println("  Team Nickname: " + memberInfo.getTeamNick());
                    }
                    System.out.println("  Join Time: " + memberInfo.getJoinTime());
                    System.out.println("  Update Time: " + memberInfo.getUpdateTime());
                    
                    if (memberInfo.getFollowAccountIds() != null && !memberInfo.getFollowAccountIds().isEmpty()) {
                        System.out.println("  Follow Account IDs: " + String.join(", ", memberInfo.getFollowAccountIds()));
                    }
                }
            }
            
            // If there are more teams, demonstrate pagination
            if (response.getHasMore() != null && response.getHasMore() && response.getNextToken() != null) {
                System.out.println("\nThere are more teams available. Next page token: " + response.getNextToken());
                
                // Optionally, fetch the next page
                System.out.println("Fetching next page of joined teams...");
                
                QueryJoinedTeamsRequestV2 nextPageRequest = new QueryJoinedTeamsRequestV2(
                        memberAccountId1, 1); // 1 for advanced team
                nextPageRequest.setLimit(20);
                nextPageRequest.setNeedReturnMemberInfo(1);
                nextPageRequest.setPageToken(response.getNextToken());
                
                Result<QueryJoinedTeamsResponseV2> nextPageResult = teamMemberService.queryJoinedTeams(nextPageRequest);
                
                System.out.println("Next page response: " + JSON.toJSONString(nextPageResult));
                if (nextPageResult.getCode() == 200 && nextPageResult.getResponse() != null && 
                    nextPageResult.getResponse().getTeamInfoList() != null) {
                    System.out.println("Found " + nextPageResult.getResponse().getTeamInfoList().size() + 
                                      " more teams on the next page");
                }
            }
        } else {
            System.out.println("No joined teams found for account " + memberAccountId1);
        }
        
        System.out.println("============= END TESTING QUERY JOINED TEAMS =============\n");
    }
    
    /**
     * Test kicking members from a team
     */
    @Test
    public void testKickTeamMembers() throws YunxinSdkException {
        if (services == null || teamId == null) return;
        
        System.out.println("\n============= TESTING KICK TEAM MEMBERS =============");
        
        // Create the request
        KickTeamMembersRequestV2 request = new KickTeamMembersRequestV2();
        request.setOperatorId(ownerAccountId); // Team owner is performing the operation
        request.setTeamId(teamId);
        request.setTeamType(1); // Advanced team
        request.setKickAccountIds(Arrays.asList(memberAccountId3)); // Kick one member
        
        ITeamMemberV2Service teamMemberService = services.getTeamMemberService();
        Result<KickTeamMembersResponseV2> result = teamMemberService.kickTeamMembers(request);
        
        System.out.println("kickTeamMembers:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("============= END TESTING KICK TEAM MEMBERS =============\n");
    }
    
    /**
     * Test a member leaving a team
     */
    @Test
    public void testLeaveTeam() throws YunxinSdkException {
        if (services == null || teamId == null) return;
        
        System.out.println("\n============= TESTING LEAVE TEAM =============");
        
        // Create the request
        LeaveTeamRequestV2 request = new LeaveTeamRequestV2();
        request.setAccountId(memberAccountId2); // Member is leaving
        request.setTeamId(teamId);
        request.setTeamType(1); // Advanced team
        
        ITeamMemberV2Service teamMemberService = services.getTeamMemberService();
        Result<LeaveTeamResponseV2> result = teamMemberService.leaveTeam(request);
        
        System.out.println("leaveTeam:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("============= END TESTING LEAVE TEAM =============\n");
    }

    /**
     * Test cleanup - disband the team after all tests
     */
    @Test
    public void testDisbandTeam() throws YunxinSdkException {
        if (services == null || teamId == null) return;
        
        System.out.println("\n============= TESTING DISBAND TEAM =============");
        
        DisbandTeamRequestV2 request = new DisbandTeamRequestV2(teamId.toString(), 1);
        request.setOperatorId(ownerAccountId);
        
        ITeamV2Service teamService = services.getTeamService();
        Result<DisbandTeamResponseV2> result = teamService.disbandTeam(request);
        
        System.out.println("disbandTeam:" + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        
        Assert.assertEquals(200, result.getCode());
        Assert.assertEquals("success", result.getMsg());
        
        System.out.println("Successfully disbanded team: " + teamId);
        System.out.println("============= END TESTING DISBAND TEAM =============\n");
    }
    
    /**
     * Helper method to get role name from role ID
     */
    private static String getRoleName(Integer roleId) {
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
} 