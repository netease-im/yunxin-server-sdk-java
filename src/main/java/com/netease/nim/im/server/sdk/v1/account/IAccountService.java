package com.netease.nim.im.server.sdk.v1.account;

import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequest;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponse;

/**
 * Created by caojiajun on 2024/12/11
 */
public interface IAccountService {

    CreateAccountResponse createAccount(CreateAccountRequest request) throws YunxinSdkException;

}
