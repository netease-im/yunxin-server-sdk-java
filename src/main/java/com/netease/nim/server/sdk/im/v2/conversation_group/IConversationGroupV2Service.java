package com.netease.nim.server.sdk.im.v2.conversation_group;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.conversation_group.request.*;
import com.netease.nim.server.sdk.im.v2.conversation_group.response.*;


public interface IConversationGroupV2Service {

    Result<CreateConversationGroupResponseV2> createConversationGroup(CreateConversationGroupRequestV2 request) throws YunxinSdkException;

    Result<UpdateConversationGroupResponseV2> updateConversationGroup(UpdateConversationGroupRequestV2 request) throws YunxinSdkException;

    Result<DeleteConversationGroupResponseV2> deleteConversationGroup(DeleteConversationGroupRequestV2 request) throws YunxinSdkException;
    
    Result<GetConversationGroupResponseV2> getConversationGroup(GetConversationGroupRequestV2 request) throws YunxinSdkException;

    Result<BatchGetConversationGroupsResponseV2> batchGetConversationGroups(BatchGetConversationGroupsRequestV2 request) throws YunxinSdkException;
    
    Result<ListAllConversationGroupsResponseV2> listAllConversationGroups(ListAllConversationGroupsRequestV2 request) throws YunxinSdkException;
} 