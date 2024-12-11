package com.netease.nim.im.server.sdk.v2.account;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.account.request.BatchQueryAccountsRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.UpdateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.response.BatchQueryAccountsResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.UpdateAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.util.ResultUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/11
 */
public class AccountV2Service implements IAccountV2Service {

    private final YunxinApiHttpClient httpClient;

    public AccountV2Service(YunxinApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Result<CreateAccountResponseV2> createAccount(CreateAccountRequestV2 request) throws YunxinSdkException {
        String data = JSONObject.toJSONString(request);
        YunxinApiResponse apiResponse = httpClient.executeV2Api(HttpMethod.POST, "/im/v2/accounts", "/im/v2/accounts", null, data);
        return ResultUtils.convert(apiResponse, CreateAccountResponseV2.class);
    }

    @Override
    public Result<UpdateAccountResponseV2> updateAccount(UpdateAccountRequestV2 request) throws YunxinSdkException {
        JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(request));
        data.remove("account_id");
        String path = "/im/v2/accounts/" + request.getAccountId();
        //
        YunxinApiResponse apiResponse = httpClient.executeV2Api(HttpMethod.PATCH, "/im/v2/accounts/{account_id}", path, null, data.toString());
        return ResultUtils.convert(apiResponse, UpdateAccountResponseV2.class);
    }

    @Override
    public Result<BatchQueryAccountsResponseV2> batchQueryAccounts(BatchQueryAccountsRequestV2 request) throws YunxinSdkException {
        Map<String, String> map = new HashMap<>();
        List<String> accountList = request.getAccountList();
        StringBuilder builder = new StringBuilder();
        for (String account : accountList) {
            builder.append(account).append(",");
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        map.put("account_ids", builder.toString());
        YunxinApiResponse apiResponse = httpClient.executeV2Api(HttpMethod.GET, "/im/v2/accounts", "/im/v2/accounts", map, null);
        return ResultUtils.convert(apiResponse, BatchQueryAccountsResponseV2.class);
    }
}
