package com.netease.nim.im.server.sdk.v1;

import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.im.server.sdk.v1.account.AccountV1Service;
import com.netease.nim.im.server.sdk.v1.account.IAccountV1Service;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinV1ApiServices {

    private final IAccountV1Service accountService;

    public YunxinV1ApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.accountService = new AccountV1Service(yunxinApiHttpClient);
    }

    public IAccountV1Service getAccountService() {
        return accountService;
    }
}
