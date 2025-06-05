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
import com.netease.nim.server.sdk.im.v2.subscription.ISubscriptionV2Service;
import com.netease.nim.server.sdk.im.v2.subscription.request.QueryUserStatusSubscriptionRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.request.SubscribeUserStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.request.UnsubscribeUserStatusRequestV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.QueryUserStatusSubscriptionResponseV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.SubscribeUserStatusResponseV2;
import com.netease.nim.server.sdk.im.v2.subscription.response.UnsubscribeUserStatusResponseV2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for the SubscriptionV2Service
 */
public class TestSubscriptionV2 {

    private static YunxinV2ApiServices services;
    
    // Test account IDs
    private static final String subscriber = "subscriber_" + System.currentTimeMillis();
    private static final String publisher1 = "publisher1_" + System.currentTimeMillis();
    private static final String publisher2 = "publisher2_" + System.currentTimeMillis();
    private static final String publisher3 = "publisher3_" + System.currentTimeMillis();
    
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
        
        // Create test accounts
        System.out.println("\n==== Creating Test Accounts ====");
        createAccount(subscriber, "Status Subscriber");
        createAccount(publisher1, "Status Publisher 1");
        createAccount(publisher2, "Status Publisher 2");
        createAccount(publisher3, "Status Publisher 3");
    }
    
    /**
     * Test subscribing to user status
     */
    @Test
    public void testSubscribeUserStatus() throws Exception {
        if (services == null) {
            return;
        }
        
        try {
            // Get subscription service
            ISubscriptionV2Service subscriptionService = services.getSubscriptionService();
            
            System.out.println("\n==== Testing User Status Subscription ====");
            
            // Create list of publishers to subscribe to
            List<String> publisherIds = Arrays.asList(publisher1, publisher2, publisher3);
            
            // Create subscription request
            SubscribeUserStatusRequestV2 subscribeRequest = new SubscribeUserStatusRequestV2();
            subscribeRequest.setSubscriberAccountId(subscriber);
            subscribeRequest.setDuration(3600L); // 1 hour subscription
            subscribeRequest.setAccountIds(publisherIds);
            
            // Subscribe to user status events
            Result<SubscribeUserStatusResponseV2> subscribeResult = 
                subscriptionService.subscribeUserStatus(subscribeRequest);
            
            // Verify the subscription was successful
            System.out.println("Subscription Result: " + subscribeResult.getMsg());
            System.out.println("Response: " + JSON.toJSONString(subscribeResult));
            Assert.assertEquals(200, subscribeResult.getCode());
            
            // Check if there are any failed subscriptions
            if (subscribeResult.getResponse() != null && 
                subscribeResult.getResponse().getFailedList() != null && 
                !subscribeResult.getResponse().getFailedList().isEmpty()) {
                
                System.out.println("Failed subscriptions:");
                for (SubscribeUserStatusResponseV2.FailedSubscription failed : 
                        subscribeResult.getResponse().getFailedList()) {
                    System.out.println("  Account: " + failed.getAccountId() + 
                                     ", Error: " + failed.getErrorCode() + " - " + failed.getErrorMsg());
                }
            } else {
                System.out.println("All subscriptions were successful");
            }
            
            // Brief pause to allow server to process
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test querying user status subscriptions
     */
    @Test
    public void testQueryUserStatusSubscription() throws Exception {
        if (services == null) {
            return;
        }
        
        try {
            
            // Get subscription service
            ISubscriptionV2Service subscriptionService = services.getSubscriptionService();
            
            System.out.println("\n==== Testing User Status Subscription Query ====");
            
            // Create query request
            QueryUserStatusSubscriptionRequestV2 queryRequest = new QueryUserStatusSubscriptionRequestV2();
            queryRequest.setSubscriberAccountId(subscriber);
            queryRequest.setAccountIds(Arrays.asList(publisher1, publisher2)); // Query subset of publishers
            
            // Query subscription status
            Result<QueryUserStatusSubscriptionResponseV2> queryResult = 
                subscriptionService.queryUserStatusSubscription(queryRequest);
            
            // Verify the query was successful
            System.out.println("Query Result: " + queryResult.getMsg());
            System.out.println("Response: " + JSON.toJSONString(queryResult));
            Assert.assertEquals(200, queryResult.getCode());
            
            // Check query results
            if (queryResult.getResponse() != null) {
                // Check failed queries
                if (queryResult.getResponse().getFailedList() != null && 
                    !queryResult.getResponse().getFailedList().isEmpty()) {
                    
                    System.out.println("Failed queries:");
                    for (QueryUserStatusSubscriptionResponseV2.FailedQuery failed : 
                            queryResult.getResponse().getFailedList()) {
                        System.out.println("  Account: " + failed.getAccountId() + 
                                        ", Error: " + failed.getErrorCode() + " - " + failed.getErrorMsg());
                    }
                }
                
                // Check subscription details
                if (queryResult.getResponse().getSubscribes() != null && 
                    !queryResult.getResponse().getSubscribes().isEmpty()) {
                    
                    System.out.println("Subscription details:");
                    for (QueryUserStatusSubscriptionResponseV2.SubscriptionDetail subscription : 
                            queryResult.getResponse().getSubscribes()) {
                        System.out.println("  Account: " + subscription.getAccountId());
                        System.out.println("    Event Type: " + subscription.getEventType());
                        System.out.println("    Subscribe Time: " + subscription.getSubscribeTime());
                        System.out.println("    Expire Time: " + subscription.getExpireTime());
                    }
                } else {
                    System.out.println("No active subscriptions found");
                }
            }
            
            // Brief pause to allow server to process
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test unsubscribing from specific user status
     */
    @Test
    public void testUnsubscribeSpecificUserStatus() throws Exception {
        if (services == null) {
            return;
        }
        
        try {
            // Get subscription service
            ISubscriptionV2Service subscriptionService = services.getSubscriptionService();
            
            System.out.println("\n==== Testing User Status Unsubscription (Specific Account) ====");
            
            // Create unsubscription request for a specific publisher
            UnsubscribeUserStatusRequestV2 unsubscribeRequest = new UnsubscribeUserStatusRequestV2();
            unsubscribeRequest.setSubscriberAccountId(subscriber);
            unsubscribeRequest.setAccountIds(Arrays.asList(publisher1));
            
            // Unsubscribe from specific publisher
            Result<UnsubscribeUserStatusResponseV2> unsubscribeResult = 
                subscriptionService.unsubscribeUserStatus(unsubscribeRequest);
            
            // Verify the unsubscription was successful
            System.out.println("Unsubscription Result: " + unsubscribeResult.getMsg());
            System.out.println("Response: " + JSON.toJSONString(unsubscribeResult));
            Assert.assertEquals(200, unsubscribeResult.getCode());
            
            // Check for failed unsubscriptions
            if (unsubscribeResult.getResponse() != null && 
                unsubscribeResult.getResponse().getFailedList() != null && 
                !unsubscribeResult.getResponse().getFailedList().isEmpty()) {
                
                System.out.println("Failed unsubscriptions:");
                for (UnsubscribeUserStatusResponseV2.FailedUnsubscription failed : 
                        unsubscribeResult.getResponse().getFailedList()) {
                    System.out.println("  Account: " + failed.getAccountId() + 
                                    ", Error: " + failed.getErrorCode() + " - " + failed.getErrorMsg());
                }
            } else {
                System.out.println("All specific unsubscriptions were successful");
            }
            
            // Brief pause to allow server to process
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
    
    /**
     * Test unsubscribing from all user statuses
     */
    @Test
    public void testUnsubscribeAllUserStatus() throws Exception {
        if (services == null) {
            return;
        }
        
        try {
            // Get subscription service
            ISubscriptionV2Service subscriptionService = services.getSubscriptionService();
            
            System.out.println("\n==== Testing User Status Unsubscription (All Accounts) ====");
            
            // Create unsubscription request for all publishers
            UnsubscribeUserStatusRequestV2 unsubscribeAllRequest = new UnsubscribeUserStatusRequestV2();
            unsubscribeAllRequest.setSubscriberAccountId(subscriber);
            // No need to set accountIds, as null or empty list means unsubscribe from all
            
            // Unsubscribe from all publishers
            Result<UnsubscribeUserStatusResponseV2> unsubscribeAllResult = 
                subscriptionService.unsubscribeUserStatus(unsubscribeAllRequest);
            
            // Verify the unsubscription was successful
            System.out.println("Unsubscription (All) Result: " + unsubscribeAllResult.getMsg());
            System.out.println("Response: " + JSON.toJSONString(unsubscribeAllResult));
            Assert.assertEquals(200, unsubscribeAllResult.getCode());
            
            System.out.println("\n==== User Status Subscription Tests Completed Successfully ====");
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