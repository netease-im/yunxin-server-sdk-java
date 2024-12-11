package com.netease.nim.im.server.sdk.v1.account;

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.core.Result;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponseV1;

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IAccountV1Service {

    /**
     * create yunxin account
     * @param request request
     * @return result
     * @throws YunxinSdkException exception on network error
     */
    Result<CreateAccountResponseV1> createAccount(CreateAccountRequestV1 request) throws YunxinSdkException;

}
