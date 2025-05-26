package com.netease.nim.im.server.sdk.v1.special_relation;

import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.friend.request.*;
import com.netease.nim.im.server.sdk.v1.friend.response.BaseFriendResponseV1;
import com.netease.nim.im.server.sdk.v1.friend.response.GetFriendListResponseV1;
import com.netease.nim.im.server.sdk.v1.friend.response.GetFriendRelationshipResponseV1;
import com.netease.nim.im.server.sdk.v1.special_relation.request.ListSpecialRelationRequestV1;
import com.netease.nim.im.server.sdk.v1.special_relation.request.SetSpecialRelationRequestV1;
import com.netease.nim.im.server.sdk.v1.special_relation.response.ListSpecialRelationResponseV1;
import com.netease.nim.im.server.sdk.v1.special_relation.response.SetSpecialRelationResponseV1;

/**
 * Created by yangguoyong
 */
public interface ISpecialRelationV1Service {

    /**
     * /user/setSpecialRelation.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<SetSpecialRelationResponseV1> setSpecialRelation(SetSpecialRelationRequestV1 request) throws YunxinSdkException;

    /**
     * /user/listBlackAndMuteList.action
     *
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<ListSpecialRelationResponseV1> listBlackAndMuteList(ListSpecialRelationRequestV1 request) throws YunxinSdkException;

}
