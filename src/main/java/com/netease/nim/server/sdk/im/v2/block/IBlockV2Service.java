package com.netease.nim.server.sdk.im.v2.block;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.block.request.AddBlockContactRequestV2;
import com.netease.nim.server.sdk.im.v2.block.request.ListBlockContactsRequestV2;
import com.netease.nim.server.sdk.im.v2.block.request.RemoveBlockContactRequestV2;
import com.netease.nim.server.sdk.im.v2.block.response.AddBlockContactResponseV2;
import com.netease.nim.server.sdk.im.v2.block.response.ListBlockContactsResponseV2;
import com.netease.nim.server.sdk.im.v2.block.response.RemoveBlockContactResponseV2;

public interface IBlockV2Service {

    Result<AddBlockContactResponseV2> addBlockContact(AddBlockContactRequestV2 request) throws YunxinSdkException;

    Result<RemoveBlockContactResponseV2> removeBlockContact(RemoveBlockContactRequestV2 request) throws YunxinSdkException;

    Result<ListBlockContactsResponseV2> listBlockContacts(ListBlockContactsRequestV2 request) throws YunxinSdkException;
} 