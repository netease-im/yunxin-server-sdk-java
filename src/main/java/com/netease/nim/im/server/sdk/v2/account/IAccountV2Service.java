package com.netease.nim.im.server.sdk.v2.account;

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.Result;
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

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IAccountV2Service {

    /**
     * create yunxin account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateAccountResponseV2> createAccount(CreateAccountRequestV2 request) throws YunxinSdkException;

    /**
     * update yunxin account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<UpdateAccountResponseV2> updateAccount(UpdateAccountRequestV2 request) throws YunxinSdkException;

    /**
     * batch query accounts
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<BatchQueryAccountsResponseV2> batchQueryAccounts(BatchQueryAccountsRequestV2 request) throws YunxinSdkException;
    
    /**
     * disable or enable yunxin account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<DisableAccountResponseV2> disableAccount(DisableAccountRequestV2 request) throws YunxinSdkException;
    
    /**
     * set account push configuration
     * @param request request containing account ID and push configuration
     * @return result containing account ID and configuration details
     * @throws YunxinSdkException exception on network error
     */
    Result<SetPushConfigResponseV2> setPushConfig(SetPushConfigRequestV2 request) throws YunxinSdkException;
    
    /**
     * get account details
     * @param request request containing yunxin account ID
     * @return result containing account details
     * @throws YunxinSdkException exception on network error
     */
    Result<GetAccountDetailsResponseV2> getAccountDetails(GetAccountDetailsRequestV2 request) throws YunxinSdkException;
    

    /**
     * Kick account devices offline
     * @param request request containing kick operation details
     * @return result containing lists of successful and failed kick operations
     * @throws YunxinSdkException exception on network error
     */
    Result<KickAccountResponseV2> kickAccount(KickAccountRequestV2 request) throws YunxinSdkException;
}
