package com.netease.nim.im.server.sdk.test.v1;

import com.alibaba.fastjson2.JSON;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.test.YunxinApiHttpClientInit;
import com.netease.nim.server.sdk.im.v1.YunxinV1ApiServices;
import com.netease.nim.server.sdk.im.v1.account.IAccountV1Service;
import com.netease.nim.server.sdk.im.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.server.sdk.im.v1.account.response.CreateAccountResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.IEventSubscribeV1Service;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.AddEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.BatchDeleteEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.DeleteEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.request.QueryEventSubscribeRequestV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.AddEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.BatchDeleteEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.DeleteEventSubscribeResponseV1;
import com.netease.nim.server.sdk.im.v1.event_subscribe.response.QueryEventSubscribeResponseV1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for the EventSubscribeV1Service
 */
public class TestEventSubscribeV1 {

    private static YunxinV1ApiServices services = null;
    private static IEventSubscribeV1Service eventSubscribeV1Service = null;
    
    // Test account IDs with timestamps to ensure uniqueness
    private static final String subscriberAccid = "subscriber_" + System.currentTimeMillis();
    private static final String publisherAccid1 = "publisher1_" + System.currentTimeMillis();
    private static final String publisherAccid2 = "publisher2_" + System.currentTimeMillis();

    /**
     * Initialize test environment and create test accounts
     */
    @BeforeClass
    public static void setup() {
        YunxinApiHttpClient client = YunxinApiHttpClientInit.init();
        if (client == null) {
            return;
        }
                
        services = new YunxinV1ApiServices(client);
        eventSubscribeV1Service = services.getEventSubscribeV1Service();
        
        // Create test accounts
        try {
            System.out.println("\n==== Creating Test Accounts ====");
            createAccount(subscriberAccid, "Status Subscriber");
            createAccount(publisherAccid1, "Status Publisher 1");
            createAccount(publisherAccid2, "Status Publisher 2");
            
            System.out.println("Test accounts created:");
            System.out.println("subscriberAccid = " + subscriberAccid);
            System.out.println("publisherAccid1 = " + publisherAccid1);
            System.out.println("publisherAccid2 = " + publisherAccid2);
        } catch (Exception e) {
            System.err.println("Failed to initialize test resources: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Test adding event subscriptions
     */
    @Test
    public void testAddEventSubscribe() throws YunxinSdkException {
        if (eventSubscribeV1Service == null) return;
        
        System.out.println("\n==== Testing Add Event Subscription ====");
        
        // Create subscription request
        AddEventSubscribeRequestV1 request = new AddEventSubscribeRequestV1();
        request.setAccid(subscriberAccid);
        request.setPublisherAccids(Arrays.asList(publisherAccid1, publisherAccid2));
        request.setTtl(1000L); // 1000 seconds subscription
        
        // Print the request for debugging
        System.out.println("Add Event Subscribe Request:");
        System.out.println("  Subscriber: " + request.getAccid());
        System.out.println("  Publishers: " + JSON.toJSONString(request.getPublisherAccids()));
        System.out.println("  TTL: " + request.getTtl() + " seconds");
        
        // Execute the request
        Result<AddEventSubscribeResponseV1> result = eventSubscribeV1Service.addEventSubscribe(request);
        
        // Verify and display results
        System.out.println("Add Event Subscribe Result: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        // Check if there are any failed subscriptions
        if (result.getResponse() != null && result.getResponse().getFailedAccid() != null && 
            !result.getResponse().getFailedAccid().isEmpty()) {
            
            System.out.println("Failed subscriptions:");
            for (String failedAccid : result.getResponse().getFailedAccid()) {
                System.out.println("  Failed to subscribe to: " + failedAccid);
            }
            Assert.assertTrue("Failed accounts: " + result.getResponse().getFailedAccid(), 
                             result.getResponse().getFailedAccid().isEmpty());
        } else {
            System.out.println("All subscriptions were successful");
        }
        
        // Brief pause to allow server to process
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Ignore interruption
        }
    }

    /**
     * Test querying event subscriptions
     */
    @Test
    public void testQueryEventSubscribe() throws YunxinSdkException {
        if (eventSubscribeV1Service == null) return;
        
        System.out.println("\n==== Testing Query Event Subscription ====");
        
        // Ensure there's a subscription to query
        try {
            testAddEventSubscribe();
        } catch (Exception e) {
            System.out.println("Setup subscription for query test failed: " + e.getMessage());
            // Continue with the test anyway
        }
        
        // Create query request
        QueryEventSubscribeRequestV1 request = new QueryEventSubscribeRequestV1();
        request.setAccid(subscriberAccid);
        request.setPublisherAccids(Arrays.asList(publisherAccid1, publisherAccid2));
        
        // Print the request for debugging
        System.out.println("Query Event Subscribe Request:");
        System.out.println("  Subscriber: " + request.getAccid());
        System.out.println("  Publishers: " + JSON.toJSONString(request.getPublisherAccids()));
        
        // Execute the request
        Result<QueryEventSubscribeResponseV1> result = eventSubscribeV1Service.queryEventSubscribe(request);
        
        // Verify and display results
        System.out.println("Query Event Subscribe Result: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        // Display subscription details
        if (result.getResponse() != null && result.getResponse().getSubscribes() != null) {
            List<QueryEventSubscribeResponseV1.Subscription> subscriptions = result.getResponse().getSubscribes();
            System.out.println("Found " + subscriptions.size() + " subscriptions");
            
            for (QueryEventSubscribeResponseV1.Subscription subscription : subscriptions) {
                System.out.println("Subscription Details:");
                System.out.println("  Publisher: " + subscription.getAccid());
                System.out.println("  Event Type: " + subscription.getEventType());
                System.out.println("  Subscribe Time: " + subscription.getSubscribeTime());
                System.out.println("  Expire Time: " + subscription.getExpireTime());
            }
        } else {
            System.out.println("No subscriptions found");
        }
        
        // Brief pause to allow server to process
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Ignore interruption
        }
    }

    /**
     * Test deleting specific event subscriptions
     */
    @Test
    public void testDeleteEventSubscribe() throws YunxinSdkException {
        if (eventSubscribeV1Service == null) return;
        
        System.out.println("\n==== Testing Delete Event Subscription ====");
        
        // Ensure there's a subscription to delete
        try {
            testAddEventSubscribe();
        } catch (Exception e) {
            System.out.println("Setup subscription for delete test failed: " + e.getMessage());
            // Continue with the test anyway
        }
        
        // Create delete request for a specific publisher
        DeleteEventSubscribeRequestV1 request = new DeleteEventSubscribeRequestV1();
        request.setAccid(subscriberAccid);
        request.setPublisherAccids(Arrays.asList(publisherAccid1));
        
        // Print the request for debugging
        System.out.println("Delete Event Subscribe Request:");
        System.out.println("  Subscriber: " + request.getAccid());
        System.out.println("  Publishers: " + JSON.toJSONString(request.getPublisherAccids()));
        
        // Execute the request
        Result<DeleteEventSubscribeResponseV1> result = eventSubscribeV1Service.deleteEventSubscribe(request);
        
        // Verify and display results
        System.out.println("Delete Event Subscribe Result: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        
        // Check if there are any failed deletions
        if (result.getResponse() != null && result.getResponse().getFailedAccid() != null && 
            !result.getResponse().getFailedAccid().isEmpty()) {
            
            System.out.println("Failed deletions:");
            for (String failedAccid : result.getResponse().getFailedAccid()) {
                System.out.println("  Failed to delete subscription to: " + failedAccid);
            }
            Assert.assertTrue("Failed deletions: " + result.getResponse().getFailedAccid(), 
                             result.getResponse().getFailedAccid().isEmpty());
        } else {
            System.out.println("All specified deletions were successful");
        }
        
        // Verify deletion by querying
        try {
            QueryEventSubscribeRequestV1 queryRequest = new QueryEventSubscribeRequestV1();
            queryRequest.setAccid(subscriberAccid);
            queryRequest.setPublisherAccids(Arrays.asList(publisherAccid1));
            
            Result<QueryEventSubscribeResponseV1> queryResult = eventSubscribeV1Service.queryEventSubscribe(queryRequest);
            
            if (queryResult.isSuccess() && queryResult.getResponse() != null && 
                queryResult.getResponse().getSubscribes() != null) {
                
                boolean stillSubscribed = false;
                for (QueryEventSubscribeResponseV1.Subscription sub : queryResult.getResponse().getSubscribes()) {
                    if (publisherAccid1.equals(sub.getAccid())) {
                        stillSubscribed = true;
                        break;
                    }
                }
                
                Assert.assertFalse("Subscription should be deleted", stillSubscribed);
                System.out.println("Verified: Subscription was successfully deleted");
            }
        } catch (Exception e) {
            System.out.println("Verification query failed: " + e.getMessage());
        }
        
        // Brief pause to allow server to process
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Ignore interruption
        }
    }

    /**
     * Test batch deleting all event subscriptions
     */
    @Test
    public void testBatchDeleteEventSubscribe() throws YunxinSdkException {
        if (eventSubscribeV1Service == null) return;
        
        System.out.println("\n==== Testing Batch Delete Event Subscription ====");
        
        // Ensure there's a subscription to delete
        try {
            testAddEventSubscribe();
        } catch (Exception e) {
            System.out.println("Setup subscription for batch delete test failed: " + e.getMessage());
            // Continue with the test anyway
        }
        
        // Create batch delete request
        BatchDeleteEventSubscribeRequestV1 request = new BatchDeleteEventSubscribeRequestV1();
        request.setAccid(subscriberAccid);
        
        // Print the request for debugging
        System.out.println("Batch Delete Event Subscribe Request:");
        System.out.println("  Subscriber: " + request.getAccid());
        
        // Execute the request
        Result<BatchDeleteEventSubscribeResponseV1> result = eventSubscribeV1Service.batchDeleteEventSubscribe(request);
        
        // Verify and display results
        System.out.println("Batch Delete Event Subscribe Result: " + result.getMsg());
        System.out.println("Response: " + JSON.toJSONString(result));
        Assert.assertEquals(200, result.getCode());
        System.out.println("All subscriptions were successfully deleted");
        
        // Verify deletion by querying
        try {
            QueryEventSubscribeRequestV1 queryRequest = new QueryEventSubscribeRequestV1();
            queryRequest.setAccid(subscriberAccid);
            queryRequest.setPublisherAccids(Arrays.asList(publisherAccid1, publisherAccid2));
            
            Result<QueryEventSubscribeResponseV1> queryResult = eventSubscribeV1Service.queryEventSubscribe(queryRequest);
            
            if (queryResult.isSuccess() && queryResult.getResponse() != null && 
                queryResult.getResponse().getSubscribes() != null) {
                
                Assert.assertTrue("All subscriptions should be deleted", 
                                 queryResult.getResponse().getSubscribes().isEmpty());
                System.out.println("Verified: All subscriptions were successfully deleted");
            }
        } catch (Exception e) {
            System.out.println("Verification query failed: " + e.getMessage());
        }
        
        System.out.println("\n==== Event Subscription Tests Completed Successfully ====");
    }
    
    /**
     * Helper method to create a test account
     */
    private static void createAccount(String accid, String name) throws YunxinSdkException {
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid(accid);
        request.setName(name);
        request.setToken(accid + "_token"); // Simple token for testing
        
        IAccountV1Service accountService = services.getAccountService();
        Result<CreateAccountResponseV1> result = accountService.createAccount(request);
        
        // If account already exists, it's not an error for our test
        if (result.getCode() == 200) {
            System.out.println("Created account: " + accid + ", name: " + name);
            Assert.assertEquals(request.getAccid(), result.getResponse().getAccid());
        } else if (result.getCode() == 414) {
            // 414 usually means account already exists
            System.out.println("Account already exists: " + accid);
        } else {
            // Fail the test for other unexpected errors
            Assert.fail("Failed to create account: " + result.getMsg());
        }
    }
} 