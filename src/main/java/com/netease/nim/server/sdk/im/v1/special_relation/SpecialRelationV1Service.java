package com.netease.nim.server.sdk.im.v1.special_relation;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.YunxinApiResponse;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.im.v1.annotation.YunxinParamUtils;
import com.netease.nim.server.sdk.im.v1.special_relation.request.ListSpecialRelationRequestV1;
import com.netease.nim.server.sdk.im.v1.special_relation.request.SetSpecialRelationRequestV1;
import com.netease.nim.server.sdk.im.v1.special_relation.response.ListSpecialRelationResponseV1;
import com.netease.nim.server.sdk.im.v1.special_relation.response.SetSpecialRelationResponseV1;

import java.util.List;
import java.util.Map;


public class SpecialRelationV1Service implements ISpecialRelationV1Service {

    private final YunxinApiHttpClient httpClient;

    private final static String CODE = "code";

    private final static String DESC = "desc";


    public SpecialRelationV1Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<SetSpecialRelationResponseV1> setSpecialRelation(SetSpecialRelationRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SpecialRelationV1UrlContext.ADD_TO_BLACKLIST, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        SetSpecialRelationResponseV1 response = new SetSpecialRelationResponseV1();
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }

    @Override
    public Result<ListSpecialRelationResponseV1> listBlackAndMuteList(ListSpecialRelationRequestV1 request) throws YunxinSdkException {
        Map<String, String> paramMap = YunxinParamUtils.convert(request);
        YunxinApiResponse apiResponse = httpClient.executeV1Api(SpecialRelationV1UrlContext.QUERY_BLACKLIST, paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue(CODE);
        if (code != 200) {
            return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString(DESC), null);
        }
        ListSpecialRelationResponseV1 response = new ListSpecialRelationResponseV1();
        if (object.containsKey("mutelist")) {
            List<String> muteList = JSON.parseArray(object.getString("mutelist"), String.class);
            response.setMutelist(muteList);
        }
        if (object.containsKey("blacklist")) {
            List<String> blackList = JSON.parseArray(object.getString("blacklist"), String.class);
            response.setBlacklist(blackList);
        }
        return new Result<>(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), null, response);
    }
}
