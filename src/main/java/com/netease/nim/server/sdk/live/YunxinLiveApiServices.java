package com.netease.nim.server.sdk.live;


import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.live.manage.ILiveManageService;
import com.netease.nim.server.sdk.live.manage.LiveManageService;

/**
 * Created by caojiajun on 2025/6/5
 */
public class YunxinLiveApiServices {

    private final ILiveManageService liveManageService;

    public YunxinLiveApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        this.liveManageService = new LiveManageService(yunxinApiHttpClient);
    }

    public ILiveManageService getLiveManageService() {
        return liveManageService;
    }
}
