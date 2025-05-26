package com.netease.nim.im.server.sdk.v2.block;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.block.request.AddBlockContactRequestV2;
import com.netease.nim.im.server.sdk.v2.block.request.ListBlockContactsRequestV2;
import com.netease.nim.im.server.sdk.v2.block.request.RemoveBlockContactRequestV2;
import com.netease.nim.im.server.sdk.v2.block.response.AddBlockContactResponseV2;
import com.netease.nim.im.server.sdk.v2.block.response.ListBlockContactsResponseV2;
import com.netease.nim.im.server.sdk.v2.block.response.RemoveBlockContactResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Block V2 operations
 * 
 * This service provides methods for managing block contacts (block list):
 * - Adding contacts to the block list
 * - Removing contacts from the block list
 * - Listing contacts in the block list
 * 
 * API documentation: https://doc.yunxin.163.com/messaging2/server-apis/DE0MzMwNTI?platform=server
 */
public class BlockV2Service implements IBlockV2Service {

    private final YunxinApiHttpClient httpClient;

    public BlockV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Add a contact to the block list
     * 
     * API: POST https://open.yunxinapi.com/im/v2/block_contacts
     * 
     * @param request request containing the account ID and contact account ID to block
     * @return result containing the response status
     * @throws YunxinSdkException exception on network error
     */
    @Override
    public Result<AddBlockContactResponseV2> addBlockContact(AddBlockContactRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            BlockUrlContextV2.ADD_BLOCK_CONTACT,
            BlockUrlContextV2.ADD_BLOCK_CONTACT,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, AddBlockContactResponseV2.class);
    }
    
    /**
     * Remove a contact from the block list
     * 
     * API: DELETE https://open.yunxinapi.com/im/v2/block_contacts/{account_id}
     * 
     * @param request request containing the account ID and contact account ID to unblock
     * @return result containing the response status
     * @throws YunxinSdkException exception on network error
     */
    @Override
    public Result<RemoveBlockContactResponseV2> removeBlockContact(RemoveBlockContactRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = BlockUrlContextV2.REMOVE_BLOCK_CONTACT.replace("{account_id}", request.getAccountId());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contact_account_id", request.getContactAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            BlockUrlContextV2.REMOVE_BLOCK_CONTACT,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, RemoveBlockContactResponseV2.class);
    }
    
    /**
     * List contacts in the block list for a specific account
     * 
     * The 'items' field in the response is an array of strings (account IDs),
     * not an array of objects with 'contact_account_id' field.
     */
    @Override
    public Result<ListBlockContactsResponseV2> listBlockContacts(ListBlockContactsRequestV2 request) throws YunxinSdkException {
        // Set up query parameters according to API specification
        Map<String, String> queryParams = new HashMap<>();
        
        // Required parameter
        queryParams.put("account_id", request.getAccountId());
        
        // Optional parameters
        if (request.getPageToken() != null && !request.getPageToken().isEmpty()) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        // Execute API call
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            BlockUrlContextV2.LIST_BLOCK_CONTACTS,
            BlockUrlContextV2.LIST_BLOCK_CONTACTS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListBlockContactsResponseV2.class);
    }
} 