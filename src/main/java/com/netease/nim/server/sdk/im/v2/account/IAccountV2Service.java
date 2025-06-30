package com.netease.nim.server.sdk.im.v2.account;

import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.im.v2.account.request.BatchQueryAccountsRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.DisableAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.GetAccountDetailsRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.KickAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.SetPushConfigRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.UpdateAccountRequestV2;
import com.netease.nim.server.sdk.im.v2.account.request.RefreshTokenRequestV2;
import com.netease.nim.server.sdk.im.v2.account.response.BatchQueryAccountsResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.CreateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.DisableAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.GetAccountDetailsResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.KickAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.SetPushConfigResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.UpdateAccountResponseV2;
import com.netease.nim.server.sdk.im.v2.account.response.RefreshTokenResponseV2;

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IAccountV2Service {

    Result<CreateAccountResponseV2> createAccount(CreateAccountRequestV2 request) throws YunxinSdkException;

    Result<UpdateAccountResponseV2> updateAccount(UpdateAccountRequestV2 request) throws YunxinSdkException;

    Result<BatchQueryAccountsResponseV2> batchQueryAccounts(BatchQueryAccountsRequestV2 request) throws YunxinSdkException;

    Result<DisableAccountResponseV2> disableAccount(DisableAccountRequestV2 request) throws YunxinSdkException;
    
    Result<SetPushConfigResponseV2> setPushConfig(SetPushConfigRequestV2 request) throws YunxinSdkException;
    
    Result<GetAccountDetailsResponseV2> getAccountDetails(GetAccountDetailsRequestV2 request) throws YunxinSdkException;
    
    Result<KickAccountResponseV2> kickAccount(KickAccountRequestV2 request) throws YunxinSdkException;

    Result<RefreshTokenResponseV2> refreshToken(RefreshTokenRequestV2 request) throws YunxinSdkException;
}
