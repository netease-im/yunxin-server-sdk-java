package com.netease.nim.im.server.sdk.v2.account;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.core.YunxinApiResponse;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.v2.account.request.BatchQueryAccountsRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.DisableAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.GetAccountDetailsRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.KickAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.SetPushConfigRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.UpdateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.response.BatchQueryAccountsResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.DisableAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.GetAccountDetailsResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.KickAccountResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.SetPushConfigResponseV2;
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
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST, 
            AccountUrlContextV2.ACCOUNTS, 
            AccountUrlContextV2.ACCOUNTS, 
            null, 
            data
        );
        return ResultUtils.convert(apiResponse, CreateAccountResponseV2.class);
    }

    @Override
    public Result<UpdateAccountResponseV2> updateAccount(UpdateAccountRequestV2 request) throws YunxinSdkException {
        JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(request));
        data.remove("account_id");
        
        // Replace placeholder in the URL with the accountId
        String path = AccountUrlContextV2.ACCOUNT_WITH_ID.replace("{account_id}", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH, 
            AccountUrlContextV2.ACCOUNT_WITH_ID, 
            path, 
            null, 
            data.toString()
        );
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
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET, 
            AccountUrlContextV2.ACCOUNTS, 
            AccountUrlContextV2.ACCOUNTS, 
            map, 
            null
        );
        return ResultUtils.convert(apiResponse, BatchQueryAccountsResponseV2.class);
    }
    
    @Override
    public Result<DisableAccountResponseV2> disableAccount(DisableAccountRequestV2 request) throws YunxinSdkException {
        JSONObject data = new JSONObject();
        data.put("enabled", request.getEnabled());
        if (request.getNeedKick() != null) {
            data.put("need_kick", request.getNeedKick());
        }
        if (request.getKickNotifyExtension() != null) {
            data.put("kick_notify_extension", request.getKickNotifyExtension());
        }
        
        // Replace placeholder in the URL with the accountId
        String path = AccountUrlContextV2.DISABLE_ACCOUNT.replace("{account_id}", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH, 
            AccountUrlContextV2.DISABLE_ACCOUNT, 
            path, 
            null, 
            data.toString()
        );
        return ResultUtils.convert(apiResponse, DisableAccountResponseV2.class);
    }
    
    @Override
    public Result<SetPushConfigResponseV2> setPushConfig(SetPushConfigRequestV2 request) throws YunxinSdkException {
        JSONObject data = new JSONObject();
        data.put("push_enabled_when_desktop_online", request.getPushEnabledWhenDesktopOnline());
        
        // Replace placeholder in the URL with the accountId
        String path = AccountUrlContextV2.SET_PUSH_CONFIG.replace("{account_id}", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.PATCH, 
            AccountUrlContextV2.SET_PUSH_CONFIG, 
            path, 
            null, 
            data.toString()
        );
        return ResultUtils.convert(apiResponse, SetPushConfigResponseV2.class);
    }
    
    @Override
    public Result<GetAccountDetailsResponseV2> getAccountDetails(GetAccountDetailsRequestV2 request) throws YunxinSdkException {
        // Replace placeholder in the URL with the accountId
        String path = AccountUrlContextV2.ACCOUNT_WITH_ID.replace("{account_id}", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.GET, 
            AccountUrlContextV2.ACCOUNT_WITH_ID, 
            path, 
            null, 
            null
        );
        return ResultUtils.convert(apiResponse, GetAccountDetailsResponseV2.class);
    }
    
    
    @Override
    public Result<KickAccountResponseV2> kickAccount(KickAccountRequestV2 request) throws YunxinSdkException {
        JSONObject data = new JSONObject();
        data.put("type", request.getType());
        
        if (request.getDeviceIdList() != null && !request.getDeviceIdList().isEmpty()) {
            data.put("device_id_list", request.getDeviceIdList());
        }
        
        if (request.getKickNotifyExtension() != null) {
            data.put("kick_notify_extension", request.getKickNotifyExtension());
        }
        
        // Replace placeholder in the URL with the accountId
        String path = AccountUrlContextV2.KICK_ACCOUNT.replace("{account_id}", request.getAccountId());
        
        YunxinApiResponse apiResponse = httpClient.executeV2Api(
            HttpMethod.POST, 
            AccountUrlContextV2.KICK_ACCOUNT, 
            path, 
            null, 
            data.toString()
        );
        return ResultUtils.convert(apiResponse, KickAccountResponseV2.class);
    }
}
