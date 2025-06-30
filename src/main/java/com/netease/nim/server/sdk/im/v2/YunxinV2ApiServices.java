package com.netease.nim.server.sdk.im.v2;

import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.im.v2.account.AccountV2Service;
import com.netease.nim.server.sdk.im.v2.account.IAccountV2Service;

/**
 * Created by caojiajun on 2024/12/11
 */
public class YunxinV2ApiServices {

    private final IAccountV2Service accountService;

    public YunxinV2ApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.accountService = new AccountV2Service(yunxinApiHttpClient);
    }

    public IAccountV2Service getAccountService() {
        return accountService;
    }

}
