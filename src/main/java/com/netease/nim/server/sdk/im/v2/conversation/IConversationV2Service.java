package com.netease.nim.server.sdk.im.v2.conversation;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v2.conversation.request.*;
import com.netease.nim.server.sdk.im.v2.conversation.response.*;

public interface IConversationV2Service {

    Result<CreateConversationResponseV2> createConversation(CreateConversationRequestV2 request) throws YunxinSdkException;
    
    Result<UpdateConversationResponseV2> updateConversation(UpdateConversationRequestV2 request) throws YunxinSdkException;
    
    Result<DeleteConversationResponseV2> deleteConversation(DeleteConversationRequestV2 request) throws YunxinSdkException;
    
    Result<BatchDeleteConversationsResponseV2> batchDeleteConversations(BatchDeleteConversationsRequestV2 request) throws YunxinSdkException;
    
    Result<GetConversationResponseV2> getConversation(GetConversationRequestV2 request) throws YunxinSdkException;

    Result<BatchGetConversationsResponseV2> batchGetConversations(BatchGetConversationsRequestV2 request) throws YunxinSdkException;

    Result<ListConversationsResponseV2> listConversations(ListConversationsRequestV2 request) throws YunxinSdkException;
    
    Result<StickTopConversationResponseV2> stickTopConversation(StickTopConversationRequestV2 request) throws YunxinSdkException;
}