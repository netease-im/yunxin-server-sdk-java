package com.netease.nim.im.server.sdk.v1;

import com.netease.nim.im.server.sdk.v1.account.AccountService;
import com.netease.nim.im.server.sdk.v1.account.IAccountService;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinV1ApiServices {

    private final IAccountService accountService;

    public YunxinV1ApiServices(YunxinV1ApiHttpClient yunxinV1ApiHttpClient) {
        this.accountService = new AccountService(yunxinV1ApiHttpClient);
    }

    public IAccountService getAccountService() {
        return accountService;
    }
}
