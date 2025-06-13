package com.netease.nim.server.sdk.neroom;

import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.neroom.user.INeroomUserService;
import com.netease.nim.server.sdk.neroom.user.NeroomUserService;

/**
 * Created by caojiajun on 2025/6/12
 */
public class YunxinNeroomApiServices {

    private final INeroomUserService neroomUserService;

    public YunxinNeroomApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.neroomUserService = new NeroomUserService(yunxinApiHttpClient);
    }

    public INeroomUserService getNeroomUserService() {
        return neroomUserService;
    }
}
