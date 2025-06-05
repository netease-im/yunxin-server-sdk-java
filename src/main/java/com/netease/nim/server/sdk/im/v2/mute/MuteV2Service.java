package com.netease.nim.server.sdk.im.v2.mute;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.im.v2.mute.request.AddMuteContactRequestV2;
import com.netease.nim.server.sdk.im.v2.mute.request.ListMuteContactsRequestV2;
import com.netease.nim.server.sdk.im.v2.mute.request.RemoveMuteContactRequestV2;
import com.netease.nim.server.sdk.im.v2.mute.response.AddMuteContactResponseV2;
import com.netease.nim.server.sdk.im.v2.mute.response.ListMuteContactsResponseV2;
import com.netease.nim.server.sdk.im.v2.mute.response.RemoveMuteContactResponseV2;
import com.netease.nim.server.sdk.im.v2.util.ResultUtils;
import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Mute V2 operations
 */
public class MuteV2Service implements IMuteV2Service {

    private final YunxinApiHttpClient httpClient;

    public MuteV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<AddMuteContactResponseV2> addMuteContact(AddMuteContactRequestV2 request) throws YunxinSdkException {
        // Convert the request to JSON string
        String requestBody = JSONObject.toJSONString(request);
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST,
            MuteV2UrlContext.ADD_MUTE_CONTACT,
            MuteV2UrlContext.ADD_MUTE_CONTACT,
            null,
            requestBody
        );
        
        return ResultUtils.convert(apiResponse, AddMuteContactResponseV2.class);
    }
    
    @Override
    public Result<RemoveMuteContactResponseV2> removeMuteContact(RemoveMuteContactRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = MuteV2UrlContext.REMOVE_MUTE_CONTACT.replace("{account_id}", request.getAccountId());
        
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contact_account_id", request.getContactAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.DELETE,
            MuteV2UrlContext.REMOVE_MUTE_CONTACT,
            path,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, RemoveMuteContactResponseV2.class);
    }
    
    @Override
    public Result<ListMuteContactsResponseV2> listMuteContacts(ListMuteContactsRequestV2 request) throws YunxinSdkException {
        // Set up query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("account_id", request.getAccountId());
        
        // Add optional parameters if provided
        if (request.getPageToken() != null) {
            queryParams.put("page_token", request.getPageToken());
        }
        
        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET,
            MuteV2UrlContext.LIST_MUTE_CONTACTS,
            MuteV2UrlContext.LIST_MUTE_CONTACTS,
            queryParams,
            null
        );
        
        return ResultUtils.convert(apiResponse, ListMuteContactsResponseV2.class);
    }
} 