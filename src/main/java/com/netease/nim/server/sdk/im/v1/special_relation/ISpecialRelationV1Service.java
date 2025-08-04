package com.netease.nim.server.sdk.im.v1.special_relation;

import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.special_relation.request.ListSpecialRelationRequestV1;
import com.netease.nim.server.sdk.im.v1.special_relation.request.SetSpecialRelationRequestV1;
import com.netease.nim.server.sdk.im.v1.special_relation.response.ListSpecialRelationResponseV1;
import com.netease.nim.server.sdk.im.v1.special_relation.response.SetSpecialRelationResponseV1;

/**
 * Created by yangguoyong
 */
public interface ISpecialRelationV1Service {

    Result<SetSpecialRelationResponseV1> setSpecialRelation(SetSpecialRelationRequestV1 request) throws YunxinSdkException;

    Result<ListSpecialRelationResponseV1> listBlackAndMuteList(ListSpecialRelationRequestV1 request) throws YunxinSdkException;

}
