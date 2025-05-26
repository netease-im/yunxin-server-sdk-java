package com.netease.nim.im.server.sdk.v2.block;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.block.request.AddBlockContactRequestV2;
import com.netease.nim.im.server.sdk.v2.block.request.ListBlockContactsRequestV2;
import com.netease.nim.im.server.sdk.v2.block.request.RemoveBlockContactRequestV2;
import com.netease.nim.im.server.sdk.v2.block.response.AddBlockContactResponseV2;
import com.netease.nim.im.server.sdk.v2.block.response.ListBlockContactsResponseV2;
import com.netease.nim.im.server.sdk.v2.block.response.RemoveBlockContactResponseV2;

/**
 * Interface for Block V2 operations
 */
public interface IBlockV2Service {

    /**
     * Add a block contact
     * @param request request containing the account ID and contact account ID to block
     * @return result containing the response status
     * @throws YunxinSdkException exception on network error
     */
    Result<AddBlockContactResponseV2> addBlockContact(AddBlockContactRequestV2 request) throws YunxinSdkException;
    
    /**
     * Remove a block contact
     * @param request request containing the account ID and contact account ID to unblock
     * @return result containing the response status
     * @throws YunxinSdkException exception on network error
     */
    Result<RemoveBlockContactResponseV2> removeBlockContact(RemoveBlockContactRequestV2 request) throws YunxinSdkException;
    
    /**
     * List block contacts for an account
     * @param request request containing the account ID and pagination parameters
     * @return result containing the list of block contacts
     *         The 'items' field in the response contains an array of strings,
     *         where each string is a blocked contact account ID
     * @throws YunxinSdkException exception on network error
     */
    Result<ListBlockContactsResponseV2> listBlockContacts(ListBlockContactsRequestV2 request) throws YunxinSdkException;
} 