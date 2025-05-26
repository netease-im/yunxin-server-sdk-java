package com.netease.nim.im.server.sdk.v2.mute;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v2.mute.request.AddMuteContactRequestV2;
import com.netease.nim.im.server.sdk.v2.mute.request.ListMuteContactsRequestV2;
import com.netease.nim.im.server.sdk.v2.mute.request.RemoveMuteContactRequestV2;
import com.netease.nim.im.server.sdk.v2.mute.response.AddMuteContactResponseV2;
import com.netease.nim.im.server.sdk.v2.mute.response.ListMuteContactsResponseV2;
import com.netease.nim.im.server.sdk.v2.mute.response.RemoveMuteContactResponseV2;

/**
 * Interface for Mute V2 operations
 */
public interface IMuteV2Service {

    /**
     * Add a mute contact
     * @param request request containing the account ID and contact account ID to mute
     * @return result containing the response status
     * @throws YunxinSdkException exception on network error
     */
    Result<AddMuteContactResponseV2> addMuteContact(AddMuteContactRequestV2 request) throws YunxinSdkException;
    
    /**
     * Remove a mute contact
     * @param request request containing the account ID and contact account ID to unmute
     * @return result containing the response status
     * @throws YunxinSdkException exception on network error
     */
    Result<RemoveMuteContactResponseV2> removeMuteContact(RemoveMuteContactRequestV2 request) throws YunxinSdkException;
    
    /**
     * List mute contacts for an account
     * @param request request containing the account ID and pagination parameters
     * @return result containing the list of mute contacts
     * @throws YunxinSdkException exception on network error
     */
    Result<ListMuteContactsResponseV2> listMuteContacts(ListMuteContactsRequestV2 request) throws YunxinSdkException;
} 