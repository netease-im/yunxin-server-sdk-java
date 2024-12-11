package com.netease.nim.im.server.sdk.v2.account;

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.v2.account.request.BatchQueryAccountsRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.CreateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.request.UpdateAccountRequestV2;
import com.netease.nim.im.server.sdk.v2.account.response.BatchQueryAccountsResponseV2;
import com.netease.nim.im.server.sdk.v2.account.response.CreateAccountResponseV2;
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
}
